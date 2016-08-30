package cn.su.controller;

import cn.su.redis.RedisService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by sujinxian on 2016/8/22.
 */
@Controller
public class RedisController {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(RedisController.class);

    private String host = "192.168.8.119";
    private int port = 6379;

    private int honBaoCount = 1_0_0000;

    private int threadCount = 20;

    private String hongBaoList = "hongBaoList";
    private String hongBaoConsumedList = "hongBaoConsumedList";
    private String hongBaoConsumedMap = "hongBaoConsumedMap";

    private Random random = new Random();

    private StopWatch watch = new StopWatch();

    @Autowired
    private RedisService redisService;

    @RequestMapping("/redis")
    public boolean set()
    {
        boolean i = redisService.checkAndSet("su","su","wu");
        return i;
    }

    @RequestMapping("/fu")
    @ResponseBody
    public String getString()
    {

        ArrayList<Integer> list = new ArrayList<Integer>();
        String i = redisService.setProductCount("su");
        logger.info("redis print"+i);
        return i;
    }

    @RequestMapping("/hongbao")
    @ResponseBody
    public void hongbao()
    {
        generateTestData();
       // testTryGetHongBao();
    }

    public void generateTestData() {

        final CountDownLatch latch = new CountDownLatch(threadCount);
        for(int i = 0; i < threadCount; ++i) {
            final int temp = i;
            Thread thread = new Thread() {
                public void run() {
                    int per = honBaoCount/threadCount;
                    JSONObject object = new JSONObject();
                    for(int j = temp * per; j < (temp+1) * per; j++) {
                        object.put("id", j);
                        object.put("money", j);
                        //jedis.lpush(hongBaoList, object.toJSONString());
                    }
                    latch.countDown();
                }
            };
            thread.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testTryGetHongBao() {
        final CountDownLatch latch = new CountDownLatch(threadCount);
        System.err.println("start:" + System.currentTimeMillis()/1000);
        watch.start();
        for(int i = 0; i < threadCount; ++i) {
            final int temp = i;
            Thread thread = new Thread() {
                public void run() {
                    //String sha = jedis.scriptLoad(tryGetHongBaoScript);
                    int j = honBaoCount/threadCount * temp;
//                    while(true) {
                       // Object object = jedis.eval(tryGetHongBaoScript, 4, hongBaoList, hongBaoConsumedList, hongBaoConsumedMap, "" + j);
//                        j++;
//                            if (object != null) {
//                          System.out.println("get hongBao:" + object);
//                        }else {
//                            //已经取完了
//                            if(jedis.llen(hongBaoList) == 0)
//                                break;
//                        }
//                    }
                    latch.countDown();
                }
            };
            thread.start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        watch.stop();

        System.err.println("time:" + watch.getTotalTimeSeconds());
        System.err.println("speed:" + honBaoCount/watch.getTotalTimeSeconds());
        System.err.println("end:" + System.currentTimeMillis()/1000);
    }





}
