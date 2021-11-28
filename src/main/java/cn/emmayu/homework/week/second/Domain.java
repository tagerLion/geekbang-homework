package cn.emmayu.homework.week.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Domain {

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap();

        for (int i = 0; i < cpdomains.length; i++) {
            String inf = cpdomains[i];
            String[] arr = inf.split(" ");
            int cnt = Integer.parseInt(arr[0]);
            map.put(arr[1], map.getOrDefault(arr[1], 0) + cnt);
            while (arr[1].contains(".")) {
                String str = arr[1].substring(arr[1].indexOf(".") + 1);
                map.put(str, map.getOrDefault(str, 0) + cnt);
                arr[1] = str;
            }
        }

        for (String str : map.keySet()) {
            res.add(map.get(str) + " " + str);
        }

        return res;
    }

}
