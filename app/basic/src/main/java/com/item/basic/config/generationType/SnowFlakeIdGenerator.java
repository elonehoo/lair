package com.item.basic.config.generationType;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

public class SnowFlakeIdGenerator implements IdentifierGenerator {
  /**
   * 起始的时间戳
   */
  private final long twepoch = 1557825652094L;

  /**
   * 每一部分占用的位数
   */
  private final long workerIdBits = 5L;
  private final long datacenterIdBits = 5L;
  private final long sequenceBits = 12L;

  /**
   * 每一部分的最大值
   */
  private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
  private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
  private final long maxSequence = -1L ^ (-1L << sequenceBits);

  /**
   * 每一部分向左的位移
   */
  private final long workerIdShift = sequenceBits;
  private final long datacenterIdShift = sequenceBits + workerIdBits;
  private final long timestampShift = sequenceBits + workerIdBits + datacenterIdBits;

  private long datacenterId = 1; // 数据中心ID

  private long workerId = 0; // 机器ID

  private long sequence = 0L; // 序列号
  private long lastTimestamp = -1L; // 上一次时间戳

  @PostConstruct
  public void init() {
    String msg;
    if (workerId > maxWorkerId || workerId < 0) {
      msg = String.format("worker Id can't be greater than %d or less than 0", maxWorkerId);
    }
    if (datacenterId > maxDatacenterId || datacenterId < 0) {
      msg = String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId);
    }
  }

  @Transactional
  public synchronized long nextId() {
    long timestamp = timeGen();
    if (timestamp < lastTimestamp) {
      try {
        throw new Exception(String.format(
          "Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
      } catch (Exception e) {
        e.printStackTrace();
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      }
    }
    if (timestamp == lastTimestamp) {
      sequence = (sequence + 1) & maxSequence;
      if (sequence == 0L) {
        timestamp = tilNextMillis();
      }
    } else {
      sequence = 0L;
    }
    lastTimestamp = timestamp;

    return (timestamp - twepoch) << timestampShift // 时间戳部分
      | datacenterId << datacenterIdShift // 数据中心部分
      | workerId << workerIdShift // 机器标识部分
      | sequence; // 序列号部分
  }

  private long tilNextMillis() {
    long timestamp = timeGen();
    while (timestamp <= lastTimestamp) {
      timestamp = timeGen();
    }
    return timestamp;
  }

  private long timeGen() {
    return System.currentTimeMillis();
  }

  //重写IdentifierGenerator的方法
  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object o) throws HibernateException {
    return String.valueOf(nextId());
  }
}
