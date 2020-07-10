package cn.crm.exception;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandleAdvice {
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public Map requestTypeMismatch(TypeMismatchException ex){
        ex.printStackTrace();
        HashMap<String, String> map = new HashMap<>();
        //outputJson(-400, "参数类型不匹配,参数" + ex.getPropertyName() + "类型应该为" + ex.getRequiredType())
        map.put("msg","参数类型不匹配,参数" + ex.getPropertyName() + "类型应该为" + ex.getRequiredType());
        System.out.println("-------------------------------------------\n map = " + map);

        return map;
    }
}
