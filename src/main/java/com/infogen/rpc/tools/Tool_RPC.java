package com.infogen.rpc.tools;

import java.net.InetSocketAddress;
import java.util.Set;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.cookie.Cookie;
import io.netty.handler.codec.http.cookie.ServerCookieDecoder;
import io.netty.handler.codec.http.cookie.ServerCookieEncoder;

/**
 * HTTP上下文相关的基本工具方法
 * 
 * @author larry/larrylv@outlook.com/创建时间 2015年8月3日 上午11:31:18
 * @since 1.0
 * @version 1.0
 */
public class Tool_RPC {

	public static String get_cookie(FullHttpRequest request, String key) {
		String cookieString = request.headers().get(HttpHeaderNames.COOKIE);
		if (cookieString != null) {
			Set<Cookie> cookies = ServerCookieDecoder.STRICT.decode(cookieString);
			if (!cookies.isEmpty()) {
				for (Cookie cookie : cookies) {
					if (cookie.name().equals(key)) {
						return cookie.value();
					}
				}
			}
		}
		return null;
	}

	public static void set_cookie(FullHttpResponse response, String key, String value) {
		response.headers().add(HttpHeaderNames.SET_COOKIE, ServerCookieEncoder.STRICT.encode(key, value));
	}

	/**
	 * 获取 web 客户端IP
	 * 
	 * @param request
	 * @return
	 */
	public static String get_ip(ChannelHandlerContext ctx, FullHttpRequest request) {
		String clientIP = request.headers().get("X-Forwarded-For");
		if (clientIP == null) {
			InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
			clientIP = insocket.getAddress().getHostAddress();
		}
		return clientIP;
	}

}
