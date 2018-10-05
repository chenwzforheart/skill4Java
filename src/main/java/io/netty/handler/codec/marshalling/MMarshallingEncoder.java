package io.netty.handler.codec.marshalling;

import com.cwzsmile.redis.netty.protocol.MarshallingCodeCFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelOutboundBuffer;

/**
 * Created by Administrator on 2018/10/6 0006.
 */
public class MMarshallingEncoder {

    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
    io.netty.handler.codec.marshalling.MarshallingEncoder marshaller;

    public MMarshallingEncoder() {
        this.marshaller = MarshallingCodeCFactory.buildMarshallingEncoder();
    }

    protected void encode(Object msg, ByteBuf out)throws Exception {
        int lengthPos = out.writerIndex();
        out.writeBytes(LENGTH_PLACEHOLDER);
        ChannelBufferByteOutput output = new ChannelBufferByteOutput(out);
    }
}
