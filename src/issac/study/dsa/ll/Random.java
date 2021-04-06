package issac.study.dsa.ll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 随机（Random）法
 */
class Random {
    public static String getServer() {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap(IpMap.serverWeightMap);
        // 取得Ip地址List
        Set keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList(keySet);
        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(keyList.size());
        return keyList.get(randomPos);
    }
}