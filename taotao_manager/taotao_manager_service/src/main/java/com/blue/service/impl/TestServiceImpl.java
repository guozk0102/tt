package com.blue.service.impl;

import com.blue.mapper.TestMapper;
import com.blue.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gzk
 * @version 1.0
 * @description com.blue.service.impl
 * @date 2018/1/25
 */
@Service //使用spring 的注解
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper mapper;

    @Override
    public String getNow() {
        return mapper.getNow();
    }
}
