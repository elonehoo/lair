package com.item.utils;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;

public class VerificationUtil {
  public ICaptcha init(){
    return CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
  }
}
