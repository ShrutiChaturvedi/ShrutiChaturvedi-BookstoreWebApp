package com.hsbc.bookstoreWebApp.util;

import java.util.Map;
import java.util.stream.Collectors;

public class MapUtil {
	
	public static<K,V> Map<K,V> clone(Map<K,V> originalMap) {
        return originalMap.entrySet()
                       .stream()
                       .collect(Collectors.toMap(Map.Entry::getKey,
                                                Map.Entry::getValue));
    }

}
