package cn.tedu.store.service.ex;
/**
 * 用户名已存在异常
 * @author yyj37
 *
 */
public class UsernameAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsernameAlreadyExistException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public UsernameAlreadyExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public UsernameAlreadyExistException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public UsernameAlreadyExistException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
