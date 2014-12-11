package de.hdodenhof.xingapi.internal.util;

import java.util.List;

public class URLUtils {

    public static <T> String toQueryParam(List<T> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (T elem : list) {
                sb.append(elem.toString());
                sb.append(",");
            }
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }
        return null;
    }

}
