package com.infogen.rpc.header;

/**
 * @author larry/larrylv@outlook.com/创建时间 2015年8月31日 上午10:33:59
 * @since 1.0
 * @version 1.0
 */
public enum X_HttpHeaderNames {
	x_sequence("x-infogen-seq", "sequence"); //
	public String key;
	public String note;

	private X_HttpHeaderNames(String key, String note) {
		this.key = key;
		this.note = note;
	}
}
