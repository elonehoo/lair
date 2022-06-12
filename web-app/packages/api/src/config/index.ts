import {
  send,
  deepMerge,
  ContentTypeEnum,
  CreateAxiosOptions,
  AxiosTransform,
  RequestOptions,
  ResultEnum,
  RequestEnum,
  isString,
  isUrl,
  joinTimestamp,
  formatRequestDate,
  setObjToUrlParams,
} from '@elonehoo/http'
import axios,{AxiosResponse} from 'axios'

export interface Result<T = any> {
  status: number;
  statusText: string;
  data?: T;
}

const transform: AxiosTransform = {
  /**
   * @description: 处理请求数据
   */
  transformRequestData: (res: AxiosResponse<Result>, options: RequestOptions) => {
    const {
      isShowMessage = true,
      isShowErrorMessage,
      isShowSuccessMessage,
      successMessageText,
      errorMessageText,
      isTransformResponse,
      isReturnNativeResponse,
    } = options;

    // 是否返回原生响应头 比如：需要获取响应头时使用该属性
    if (isReturnNativeResponse) {
      return res;
    }
    // 不进行任何处理，直接返回
    // 用于页面代码可能需要直接获取code，data，message这些信息时开启
    if (!isTransformResponse) {
      return res;
    }

    const { data } = res;


    if (!data) {
      // return '[HTTP] Request has no return value';
      throw new Error('error');
    }
    //  这里 code，result，message为 后台统一的字段，需要修改为项目自己的接口返回格式
    const { status, statusText } = res;
    // 请求成功
    const hasSuccess = res && Reflect.has(res, 'status') && status === ResultEnum.SUCCESS;
    // 是否显示提示信息
    if (isShowMessage) {
      if (hasSuccess && (successMessageText || isShowSuccessMessage)) {
        // 是否显示自定义信息提示
      } else if (!hasSuccess && (errorMessageText || isShowErrorMessage)) {
        // 是否显示自定义信息提示
      } else if (!hasSuccess && options.errorMessageMode === 'modal') {
        // errorMessageMode=‘custom-modal’的时候会显示modal错误弹窗，而不是消息提示，用于一些比较重要的错误

      }
    }

    // 接口请求成功，直接返回结果
    if (status === ResultEnum.SUCCESS) {
      return res;
    }
    // 接口请求错误，统一提示错误信息 这里逻辑可以根据项目进行修改
    let errorMsg = statusText;

    throw new Error(errorMsg);
  },

  // 请求之前处理config
  beforeRequestHook: (config, options) => {
    const { apiUrl, joinPrefix, joinParamsToUrl, formatDate, joinTime = true, urlPrefix } = options;

    const isUrlStr = isUrl(config.url as string);

    if (!isUrlStr && joinPrefix) {
      config.url = `${urlPrefix}${config.url}`;
    }

    if (!isUrlStr && apiUrl && isString(apiUrl)) {
      config.url = `${apiUrl}${config.url}`;
    }
    const params = config.params || {};
    const data = config.data || false;
    if (config.method?.toUpperCase() === RequestEnum.GET) {
      if (!isString(params)) {
        // 给 get 请求加上时间戳参数，避免从缓存中拿数据。
        config.params = Object.assign(params || {}, joinTimestamp(joinTime, false));
      } else {
        // 兼容restful风格
        config.url = config.url + params + `${joinTimestamp(joinTime, true)}`;
        config.params = undefined;
      }
    } else {
      if (!isString(params)) {
        formatDate && formatRequestDate(params);
        if (Reflect.has(config, 'data') && config.data && Object.keys(config.data).length > 0) {
          config.data = data;
          config.params = params;
        } else {
          config.data = params;
          config.params = undefined;
        }
        if (joinParamsToUrl) {
          config.url = setObjToUrlParams(
            config.url as string,
            Object.assign({}, config.params, config.data)
          );
        }
      } else {
        // 兼容restful风格
        config.url = config.url + params;
        config.params = undefined;
      }
    }
    return config;
  },

  /**
   * @description: 请求拦截器处理
   */
  requestInterceptors: (config, options) => {
    // 请求之前处理config

    return config;
  },

  /**
   * @description: 响应错误处理
   */
  responseInterceptorsCatch: (error: any) => {
    const { response, code, message } = error || {};
    // TODO 此处要根据后端接口返回格式修改
    const msg: string =
      response && response.data && response.data.message ? response.data.message : '';
    const err: string = error.toString();
    try {
      if (code === 'ECONNABORTED' && message.indexOf('timeout') !== -1) {
        return;
      }
      if (err && err.includes('Network Error')) {
        return Promise.reject(error);
      }
    } catch (error) {
      throw new Error(error as any);
    }
    // 请求是否被取消
    const isCancel = axios.isCancel(error);
    if (!isCancel) {
      console.debug(error.response && error.response.status, msg)
    } else {
      console.warn(error, 'cancel');
    }
    //return Promise.reject(error);
    return Promise.reject(response?.data);
  },
}

function createAxios(opt?: Partial<CreateAxiosOptions>) {
  return new send(
    deepMerge(
      {
        timeout: 10 * 1000,
        // 接口前缀
        headers: { 'Content-Type': ContentTypeEnum.JSON },
        transform,
        // 配置项，下面的选项都可以在独立的接口请求中覆盖
        requestOptions: {
          // 默认将prefix 添加到url
          joinPrefix: true,
          // 是否返回原生响应头 比如：需要获取响应头时使用该属性
          isReturnNativeResponse: false,
          // 需要对返回数据进行处理
          isTransformResponse: true,
          // post请求的时候添加参数到url
          joinParamsToUrl: false,
          // 格式化提交参数时间
          formatDate: true,
          // 消息提示类型
          errorMessageMode: 'none',
          // 接口拼接地址
          urlPrefix: 'http://localhost:8080/item',
          //  是否加入时间戳
          joinTime: false,
          // 忽略重复请求
          ignoreCancelToken: false,
          // 是否携带token
          withToken: false,
        },
        withCredentials: false,
      },
      opt || {}
    )
  );
}

export const basicHttp = createAxios();
