package minefantasy.mfr.item.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record InferiorQuailtyDataComponent(boolean isInferior) {
    public static final String INFERIOR = "inferior";

    public static final Codec<InferiorQuailtyDataComponent> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.BOOL.fieldOf(INFERIOR).forGetter(InferiorQuailtyDataComponent::isInferior)
            ).apply(instance, InferiorQuailtyDataComponent::new)
    );

    public static final StreamCodec<ByteBuf, InferiorQuailtyDataComponent> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, InferiorQuailtyDataComponent::isInferior,
            InferiorQuailtyDataComponent::new
    );
}
