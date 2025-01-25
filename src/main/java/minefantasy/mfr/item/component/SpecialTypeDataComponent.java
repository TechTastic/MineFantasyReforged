package minefantasy.mfr.item.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record SpecialTypeDataComponent(String type) {
    public static final String TYPE = "special_type";

    public static final Codec<SpecialTypeDataComponent> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf(TYPE).forGetter(SpecialTypeDataComponent::type)
            ).apply(instance, SpecialTypeDataComponent::new)
    );

    public static final StreamCodec<ByteBuf, SpecialTypeDataComponent> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, SpecialTypeDataComponent::type,
            SpecialTypeDataComponent::new
    );
}
