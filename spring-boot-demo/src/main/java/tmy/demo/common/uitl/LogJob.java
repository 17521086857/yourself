package tmy.demo.common.uitl;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Log4j2
public class LogJob {

    /**
     * 2秒钟执行1次
     */
    @Scheduled(fixedRate = 60 * 1000)
    public void logging(){
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        log.info(simpleDateFormat.format(now));
        log.debug("-------DEBUG---------");
        log.error(now.getTime());
    }

}
