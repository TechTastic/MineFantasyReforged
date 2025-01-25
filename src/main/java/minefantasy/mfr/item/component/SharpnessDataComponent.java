package minefantasy.mfr.item.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record SharpnessDataComponent(float sharpness) {
    public static final String SHARPNESS = "sharpness";

    public static final Codec<SharpnessDataComponent> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.FLOAT.fieldOf(SHARPNESS).forGetter(SharpnessDataComponent::sharpness)
            ).apply(instance, SharpnessDataComponent::new)
    );

    public static final StreamCodec<ByteBuf, SharpnessDataComponent> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.FLOAT, SharpnessDataComponent::sharpness,
            SharpnessDataComponent::new
    );
}
