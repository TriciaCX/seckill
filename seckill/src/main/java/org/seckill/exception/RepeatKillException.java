package org.seckill.exception;



/**
 * 重复秒杀异常
 * Create by Tricia on 2019/5/18
 */
public class RepeatKillException extends SeckillException{
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
