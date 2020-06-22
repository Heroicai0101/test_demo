package com.cgx.test.common.exception;

import com.cgx.test.common.enums.Status;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = -1629784989090820983L;

	private static final String SPLIT = "/";

	public CustomException(Status status, Exception e) {
		this(status.getStatus(), status.getCode(), status.getMsg(), e);
	}

	public CustomException(int status, String errorCode, String errorMessage, Exception e) {
		super(status + SPLIT + errorCode + SPLIT + errorMessage, e);
	}

	public String getCode() {
		return splitMessage(1);
	}

	public String getMsg() {
		return splitMessage(2);
	}

	public int getStatus() {
		String status = splitMessage(0);
		return (status != null && status.length() > 0) ? Integer.valueOf(status) : 0;
	}

	private String splitMessage(int index) {
		String message = getMessage();
		if (message != null && message.contains(SPLIT)) {
			String[] split = message.split(SPLIT);
			if (split.length >= index) {
				return split[index];
			}
		}
		return "";
	}
}
