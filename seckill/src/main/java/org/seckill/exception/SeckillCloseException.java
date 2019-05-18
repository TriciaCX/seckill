package org.seckill.exception;

import org.seckill.dto.SeckillExecution;


/**
 * 秒杀关闭异常
 * Create by Tricia on 2019/5/18
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
