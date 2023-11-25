package com.gmail.vvvitas100.restcontroller;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCharsCount {
    
    public static Map<Character,Long> getCount(String in){
        Comparator<Entry<Character, Long>> comparator = Entry.comparingByValue();
        Map<Character,Long> out;
        Stream<Entry<Character, Long>> stream = in.chars().mapToObj( ch -> (char) ch)
        .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) )
        .entrySet().stream().sorted(comparator.reversed()); 

         out = stream.collect(LinkedHashMap::new, (a,b) -> a.put(b.getKey(), b.getValue()), LinkedHashMap::putAll);

        return out;
    }
}