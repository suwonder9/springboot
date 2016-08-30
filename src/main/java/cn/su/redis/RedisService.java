package cn.su.redis;

/**
 * Created by sujinxian on 2016/8/22.
 */

public interface RedisService {

    public String setProductCount(String num);

    public boolean checkAndSet(String key, String expectvalue, String newValue);

//    public void generateTestData();
//
//    public void testTryGetHongBao();


}
