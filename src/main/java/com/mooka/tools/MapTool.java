package com.mooka.tools;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTool {
    private interface Criteria {
        boolean compare(String attributeName, Object attribueValue);
    }

    public static Map<String, Object> subMap(Map<String, Object> source, String... attributes) {
        Map<String, Object> elements = new HashMap<>();

        for(String attribute : attributes) {
            elements.put(attribute, source.get(attribute));
        }

        return elements;
    }

    public static LinkedHashMap<String, Object> convertAttributesToMap(Object instance) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();

        Field[] fields = instance.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                linkedHashMap.put(field.getName(), field.get(instance));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return linkedHashMap;
    }

    public static LinkedHashMap<String, Object> convertAttributesToMap(Object instance, Criteria criteria) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();

        Field[] fields = instance.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (criteria.compare(field.getName(), field.get(instance)))
                    linkedHashMap.put(field.getName(), field.get(instance));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return linkedHashMap;
    }

    public static Criteria inclusionNameComparissonCriteria(final String... includedNames) {
        return (name, value) ->  {
            for(String element : includedNames) {
                if(!element.equals(name))
                    return false;
            }
            return true;
        };
    }

    public static Criteria exclusionNameCriteria(final String... exludedNames) {
        return (name, value) ->  {
            for(String element : exludedNames) {
                if(element.equals(name))
                    return false;
            }
            return true;
        };
    }

    public static Criteria exclusionNameCriteria(final String excludedName) {
        return (name, value) -> excludedName.equals(name);
    }
}
