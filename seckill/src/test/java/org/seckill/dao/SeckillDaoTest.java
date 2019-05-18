package org.seckill.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
class SeckillDaoTest {

    @Resource
    private SeckillDao seckillDao;

    @Test
    void queryById(){
        long id = 1000L;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    void reduceNumber() {
        Date killTime = new Date();
        int updateCount  = seckillDao.reduceNumber(1000L,killTime);
        System.out.println("updateCount" + updateCount);
    }

    @Test
    void queryAll() {
        //Java没有保存形参的记录
        List<Seckill> seckills = seckillDao.queryAll(0,100);
        for (Seckill seckill:seckills){
            System.out.println(seckill);
        }
    }
}