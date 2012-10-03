package br.com.humansoftware.j2jtransform;


public class Json2JsonTransformationException extends Exception {
	private static final long serialVersionUID = -6495893569762307894L;

	public Json2JsonTransformationException() {
		super();
	}

	public Json2JsonTransformationException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public Json2JsonTransformationException(String message, Throwable cause) {
		super(message, cause);
	}

	public Json2JsonTransformationException(String message) {
		super(message);
	}

	public Json2JsonTransformationException(Throwable cause) {
		super(cause);
	}

}
