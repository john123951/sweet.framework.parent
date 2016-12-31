package sweet.framework.utility;


import sweet.framework.utility.hardware.LocalIpAddressUtil;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 生成RequestId
 */
public class RequestIdGen {

    private static AtomicLong lastId         = new AtomicLong();                                         // 自增id，用于requestId的生成过程
    private static final long startTimeStamp = System.currentTimeMillis();                               // 启动加载时的时间戳，用于requestId的生成过程
    private static final String ip           = LocalIpAddressUtil.resolveLocalAddress().iterator().next().getHostAddress(); // 本机ip地址，用于requestId的生成过程

    private static String resolveReqId() {
        // 规则： hexIp(ip)base36(timestamp)-seq
        return hexIp(ip) + Long.toString(startTimeStamp, Character.MAX_RADIX) + "T" + lastId.incrementAndGet();
    }

    // 将ip转换为定长8个字符的16进制表示形式：255.255.255.255 -> FFFFFFFF
    private static String hexIp(String ip) {
        StringBuilder sb = new StringBuilder();
        for (String seg : ip.split("\\.")) {
            String h = Integer.toHexString(Integer.parseInt(seg));
            if (h.length() == 1) sb.append("0");
            sb.append(h);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(resolveReqId());
    }
}