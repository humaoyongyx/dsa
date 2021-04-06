package issac.study.dsa.ll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 轮询（Round Robin）法
 */
class RoundRobin {
    private static Integer pos = 0;

    public static String getServer() {
       // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);
       // 取得Ip地址List
        Set keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList(keySet);
        String server = null;
        synchronized (pos) {
       // if (pos > keySet.size()) 謝謝@WO還在這兒的提醒，
       // 應該為**-1否則確實會出現IndexOutOfBoundsException
            if (pos > keySet.size() - 1)
                pos = 0;
            server = keyList.get(pos);
            pos++;
        }
        return server;
    }
}