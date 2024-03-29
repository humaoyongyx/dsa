package issac.study.dsa.ll;

import java.util.*;

/**
 * 加权轮询（Weight Round Robin）法
 */
class WeightRoundRobin {
    private static Integer pos;

    public static String getServer() {
// 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);
// 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        List<String> serverList = new ArrayList();
        while (iterator.hasNext()) {
            String server = iterator.next();
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++)
                serverList.add(server);
        }
        String server = null;
        synchronized (pos) {
            // if (pos > keySet.size()) 感謝網友“紫寒”的指正，確實需要訂正為“serverList”應爲此時serverList 大小和keySet大小是有可能不一致的。有可能就達不到權重的效果
            if (pos > serverList.size() - 1)
                pos = 0;
            server = serverList.get(pos);
            pos++;
        }
        return server;
    }
}J