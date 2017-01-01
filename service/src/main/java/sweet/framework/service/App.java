package sweet.framework.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("sweet.framework");
        ctx.refresh();

        IUserService userService = ctx.getBean(IUserService.class);
        Date time = userService.getTime();

        System.out.println(time);

        System.out.println("Hello World!");
    }
}
