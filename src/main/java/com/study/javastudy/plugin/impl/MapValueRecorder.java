package com.study.javastudy.plugin.impl;

import com.study.javastudy.plugin.ValueRecorder;

import java.util.Map;

public class MapValueRecorder implements ValueRecorder {

    private static final Class CLAZZ = Map.class;

    @Override
    public String record(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            return "map size: " + map.size();
        }
        throw new RuntimeException("obj is not instanceof " + CLAZZ.getName());
    }

    @Override
    public boolean test(Class clazz) {
        return CLAZZ.equals(clazz);
    }

}
