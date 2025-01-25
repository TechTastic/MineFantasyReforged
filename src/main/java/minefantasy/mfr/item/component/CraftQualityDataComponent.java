package minefantasy.mfr.item.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

public record CraftQualityDataComponent(float quality) {
    public static final String QUALITY = "quality";

    public static final Codec<CraftQualityDataComponent> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.FLOAT.fieldOf(QUALITY).forGetter(CraftQualityDataComponent::quality)
            ).apply(instance, CraftQualityDataComponent::new)
    );

    public static final StreamCodec<ByteBuf, CraftQualityDataComponent> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.FLOAT, CraftQualityDataComponent::quality,
            CraftQualityDataComponent::new
    );
}
