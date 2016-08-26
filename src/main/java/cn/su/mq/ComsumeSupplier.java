package cn.su.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**  启动消费者
 * Created by sujinxian on 2016/8/19.
 */
@Component
public class ComsumeSupplier implements CommandLineRunner{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception{
        System.out.println("ComsumeSupplier 启动开始");
    }

}
