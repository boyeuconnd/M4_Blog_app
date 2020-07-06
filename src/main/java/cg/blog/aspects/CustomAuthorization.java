package cg.blog.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Aspect
public class CustomAuthorization {
    /*@Before(value = "execution(* javax.servlet.http.HttpServlet.service(..)) && " + "args(request,response)")
    public void checkAccess(JoinPoint joinPoint,
                            HttpServletRequest request,
                            HttpServletResponse response) throws ServletException, IOException {

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        if (methodName.startsWith("test")) {
            throw new RuntimeException("Không được thực hiện phương thức này");
        }

        System.out.println("this-is-my-error");
        System.out.println(methodName);
    }*/

    @Before(value = "execution(* cg.blog.controllers.BlogController.*(..))")
    public void checkAccess(JoinPoint joinPoint) {

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        if (methodName.startsWith("test")) {
            throw new RuntimeException("Khong duoc thuc hien phuong thuc nay");
        }

        System.out.println("this-is-my-error");
        System.out.println(methodName);
    }

}
