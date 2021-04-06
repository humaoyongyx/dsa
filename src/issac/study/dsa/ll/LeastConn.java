package issac.study.dsa.ll;

import java.util.HashMap;
import java.util.Map;

/**
 * @author issac.hu
 */
public class LeastConn {

    /**
     * 最小连接数（Least Connections）法
     * key:ip
     * value: connections
     */
    static HashMap<String, Integer> serverMap = new HashMap<>();

    static {
        serverMap.put("192.168.0.1", 0);
        serverMap.put("192.168.0.2", 0);
        serverMap.put("192.168.0.3", 0);
    }

    static synchronized String getServer() {
        HashMap<String, Integer> serverConn = new HashMap<>(serverMap);
        Integer min = Integer.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Integer> entry : serverConn.entrySet()) {
            Integer conn = entry.getValue();
            if (conn == 0) {
                serverMap.put(entry.getKey(), entry.getValue() + 1);
                return entry.getKey();
            }
            if (conn < min) {
                min = conn;
                key = entry.getKey();
            }
        }
        serverMap.put(key, min + 1);
        return key;
    }
}
