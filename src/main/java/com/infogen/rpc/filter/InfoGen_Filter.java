package com.infogen.rpc.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author larry/larrylv@outlook.com/创建时间 2015年8月31日 下午3:15:50
 * @since 1.0
 * @version 1.0
 */
public abstract class InfoGen_Filter {
	public abstract Boolean doFilter(ChannelHandlerContext ctx, FullHttpRequest request, FullHttpResponse response);
}
