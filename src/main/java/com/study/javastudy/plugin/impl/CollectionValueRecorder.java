package com.study.javastudy.plugin.impl;

import com.study.javastudy.plugin.ValueRecorder;

import java.util.Collection;

public class CollectionValueRecorder implements ValueRecorder {

    private static final Class CLAZZ = Collection.class;

    @Override
    public String record(Object obj) {
        if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            return "collection size: " + collection.size();
        }
        return null;
    }

    @Override
    public boolean test(Class clazz) {
        return CLAZZ.equals(clazz);
    }

}
