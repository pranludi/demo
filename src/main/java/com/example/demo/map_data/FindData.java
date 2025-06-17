package com.example.demo.map_data;

import com.example.demo.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FindData {

    public static void main(String[] args) {

        Map<String, String> data = new HashMap<>();
        data.put("dataA", "DataAA");
        data.put("dataB", "DataBB");
        data.put("dataC", "DataCC");
        data.put("dataD", "DataDD");

        String findValue = "DataBB";
        for (String s : data.keySet()) {
            if (data.get(s).equals(findValue)) {
                System.out.println("for loop : " + s + " / " + findValue);
            }
        }

        // lambda
        Optional<String> dataValue = data.values() // data.keySet()
                .stream() // java stream function
                .filter(s -> s.equals(findValue))
                .findAny();// get data
        System.out.println("lambda data value = " + dataValue.get());

        System.out.println();
        System.out.println();
        System.out.println();

        Map<String, Member> data2 = new HashMap<>();
        data2.put("dataA", new Member(1L, "name1"));
        data2.put("dataB", new Member(1L, "name2"));
        data2.put("dataC", new Member(1L, "name3"));
        data2.put("dataD", new Member(1L, "name4"));

        String findValue2 = "name3";
        for (String s : data2.keySet()) {
            Member m = data2.get(s);
            if (m.getName().equals(findValue2)) {
                System.out.println(m.getId() + " // " + m.getName());
            }
        }
        /*
        return store.values() // map values
                .stream() // java stream function
                .filter(member -> member.getName().equals(name))
                .findAny(); // get data
         */

    }
}
