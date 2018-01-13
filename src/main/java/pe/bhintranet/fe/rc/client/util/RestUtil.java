package pe.bhintranet.rc.client.util;

import org.springframework.http.HttpStatus;

public class RestUtil {

    public static boolean isError(HttpStatus status) {
        HttpStatus.Series series = status.series();
        return (HttpStatus.Series.CLIENT_ERROR.equals(series)
                || HttpStatus.Series.SERVER_ERROR.equals(series) || HttpStatus.INTERNAL_SERVER_ERROR.equals(status));
    }
}
