package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
     String[] subdivisions = {"K1\\SK1","K1\\SK2","K1\\SK1\\SSK1","K1\\SK1\\SSK2","K2","K2\\SK1\\SSK1","K2\\SK1\\SSK2"};



        Collection<String> list = subdivisionsSorting(subdivisions);

        list.forEach(System.out::println);

    }


    /**
     * Делаю сплит у каждого элемента массива по: \ .
     * Узнаю индекс после каждой: \ , делаю  substring по этому индексу и добавляю эту подстраку в HashSet,
     * если подразделения и их отделы если уже есть в subdivisions, они не добавляются .
     * После этого всё сортируется.
     */
    private static Collection<String> subdivisionsSorting(String[] subdivisions) {
        HashSet<String> listResult = new HashSet<>(Arrays.asList(subdivisions)); //HashSet потому что уникальные значения


        for(String s :subdivisions){
            int index= 0;
            for(String s1: s.split("\\\\")){
                index+=s1.length();
                listResult.add(s.substring(0,index));

                index+=+1; //+1 потому что надо посчитать еще: \
            }
        }

        return listResult.stream().sorted(Sorting::compare).collect(Collectors.toList());
    }


}
