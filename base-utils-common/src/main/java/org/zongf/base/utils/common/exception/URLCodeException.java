package org.zongf.base.utils.common.exception;

/** URL 编码异常
 * @author zongf
 * @date 2019-12-04
 */
public class URLCodeException extends RuntimeException{

    public URLCodeException() {
    }

    public URLCodeException(String message) {
        super(message);
    }

    public URLCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public URLCodeException(Throwable cause) {
        super(cause);
    }

    public URLCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
