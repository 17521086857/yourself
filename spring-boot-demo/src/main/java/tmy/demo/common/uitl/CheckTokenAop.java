package tmy.demo.common.uitl;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import tmy.demo.common.uitl.annotation.CheckToken;
import tmy.demo.user.model.User;


@Component
@Aspect
public class CheckTokenAop {

    @Before("@annotation(tmy.demo.common.uitl.annotation.CheckToken)")
    public void beforeCheckToken(JoinPoint point) throws Throwable {
       /* Object[] args = point.getArgs();
        Class<?>[] argTypes = new Class[point.getArgs().length];
        for (int i = 0; i < args.length; i++) {
            System.err.println(args[i].getClass());
              argTypes[i] = args[i].getClass();
        }
*/
        Method[] methods =null;//方法的形参不能是接口类
        Method method = null;
        try {
            methods = point.getTarget().getClass().getDeclaredMethods();
            for(Method m : methods){
                if(m.getName().equalsIgnoreCase(point.getSignature().getName())){
                    method = m;
                }
            }
            System.out.println(point.getSignature().getName());

        } catch (SecurityException e) {
            e.printStackTrace();
        }

        CheckToken ma = method.getAnnotation(CheckToken.class);
        System.out.println(ma.isEnable());
        System.out.println(ma.auth());


    }
    

}