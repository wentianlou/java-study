package com.study.javastudy.plugin.impl;

import com.study.javastudy.plugin.ValueRecorder;
import org.springframework.web.multipart.MultipartFile;

public class ParamValueRecorder implements ValueRecorder {

    private static final Class CLAZZ = MultipartFile.class;

    @SuppressWarnings("unchecked")
    @Override
    public String record(Object obj) {
        if (CLAZZ.isInstance(obj) || CLAZZ.isAssignableFrom(obj.getClass())) {
            MultipartFile multipartFile = (MultipartFile) obj;
            return "( original file name: " + multipartFile.getOriginalFilename() + ", " +
                    "name: " + multipartFile.getName() + ", " +
                    "content type: " + multipartFile.getContentType() + ", " +
                    "size: " + multipartFile.getSize() + ", " +
                    "is empty: " + multipartFile.isEmpty() + " )";
        }
        throw new RuntimeException("obj is not instanceof " + CLAZZ.getName());
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean test(Class clazz) {
        return CLAZZ.isInstance(clazz) || CLAZZ.isAssignableFrom(clazz);
    }

}
