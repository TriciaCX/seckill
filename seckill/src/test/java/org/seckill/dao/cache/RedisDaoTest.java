package org.seckill.dao.cache;

import org.junit.jupiter.api.Test;
import org.seckill.dao.SeckillDao;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration({"classpath:spring/spring-dao.xml"})
class RedisDaoTest {

    private long id =1001;

    @Autowired
    private  RedisDao redisDao;

    @Autowired
    private SeckillDao seckillDao;

    @Test
    void getSeckill() {
        Seckill seckill = redisDao.getSeckill(id);
        if(seckill == null){
            seckill = seckillDao.queryById(id);
            if(seckill!=null){
                String result = redisDao.putSeckill(seckill);
                System.out.println(result);
                seckill = redisDao.getSeckill(id);
                System.out.println(seckill);
            }
        }
    }

    @Test
    void putSeckill() {
    }
}