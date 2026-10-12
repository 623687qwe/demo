package com.example.demo.handler;

import com.example.demo.Util.StudentException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //捕获主键冲突
    @ExceptionHandler(DuplicateKeyException.class)
    public Map<String,Object> handleDuplicateKey(DuplicateKeyException e){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","数据重复，添加失败（请检查ID是否存在）");
        return result;
    }
    @ExceptionHandler(StudentException.class)
    public  Map<String,Object> handleBusinessException(StudentException e){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg",e.getMessage());
        return result;
    }

    //捕获其他异常
    @ExceptionHandler(Exception.class)
    public Map<String,Object>handleException(Exception e){
        Map<String,Object>result=new HashMap<>();
        result.put("code",500);
        result.put("msg","系统内部错误，请联系管理员");
        return  result;
    }
}
