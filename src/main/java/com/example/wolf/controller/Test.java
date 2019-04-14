package com.example.wolf.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String regex = "([0-9a-zA-Z]+-[0-9a-zA-Z]+)";
        String uuid = "FBAD-1020304陈DXF";
        System.out.println(uuid.matches(regex));
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(uuid);
        while(matcher.find()){
            String id = matcher.group();
            System.out.println("group1----" + id);
        }

    }
}
