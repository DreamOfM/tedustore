package cn.tedu.store.service.ex;

//业务异常：密码不匹配错误异常
public class PasswordNotMatchException extends RuntimeException {

	public PasswordNotMatchException() {
		
	}

	public PasswordNotMatchException(String message) {
		super(message);
		
	}

	public PasswordNotMatchException(Throwable cause) {
		super(cause);
		
	}

	public PasswordNotMatchException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
