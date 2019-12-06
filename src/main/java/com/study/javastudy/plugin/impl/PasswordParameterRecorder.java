package com.study.javastudy.plugin.impl;

import com.study.javastudy.plugin.ParameterRecorder;

import java.util.HashSet;
import java.util.Set;

public class PasswordParameterRecorder implements ParameterRecorder {

    private static final Set<String> PASSWORD_PARAMS = new HashSet<>();

    private static final Class CLAZZ = String.class;

    static {
        PASSWORD_PARAMS.add("password");
        PASSWORD_PARAMS.add("PASSWORD");
    }

    @Override
    public String record(String paramName, Object obj) {
        if (obj == null) {
            return null;
        }
        if (CLAZZ.equals(obj.getClass())) {
            return "******";
        }
        throw new RuntimeException("obj is not instanceof " + CLAZZ.getName());
    }

    @Override
    public boolean test(String paramName, Class valueClazz) {
        if (paramName == null || paramName.length() == 0) {
            return false;
        }
        if (!CLAZZ.equals(valueClazz)) {
            return false;
        }
        return PASSWORD_PARAMS.contains(paramName);
    }

}
