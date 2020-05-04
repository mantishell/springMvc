package com.mantishell.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    /**
     * @param source 传入进来的字符串
     * @return
     */
    @Override
    public Date convert(String source) {
        if(source == null){
            throw new RuntimeException("请您输入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转出出错");
        }
    }
}
