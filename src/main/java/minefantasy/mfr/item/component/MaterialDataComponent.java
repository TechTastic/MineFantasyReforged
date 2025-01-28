package minefantasy.mfr.item.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.init.MFRMaterials;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public record MaterialDataComponent(Optional<ResourceLocation> mainMaterial, Optional<ResourceLocation> haftMaterial) {
    public static final String SLOT_MAIN = "main_material";
    public static final String SLOT_HAFT = "haft_material";

    public MaterialDataComponent(ResourceLocation mainMaterial, ResourceLocation haftMaterial) {
        this(Optional.of(mainMaterial), Optional.of(haftMaterial));
    }

    public static final MaterialDataComponent TOOL_DEFAULT =
            new MaterialDataComponent(MFRMaterials.ANY, MFRMaterials.OAK_WOOD);

    public static final MaterialDataComponent ITEM_DEFAULT =
            new MaterialDataComponent(MFRMaterials.ANY, MFRMaterials.ANY);

    public static final Codec<MaterialDataComponent> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    ResourceLocation.CODEC.optionalFieldOf(SLOT_MAIN).forGetter(MaterialDataComponent::mainMaterial),
                    ResourceLocation.CODEC.optionalFieldOf(SLOT_HAFT).forGetter(MaterialDataComponent::haftMaterial)
            ).apply(instance, MaterialDataComponent::new)
    );

    public static final StreamCodec<ByteBuf, MaterialDataComponent> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(ResourceLocation.CODEC), comp -> comp.mainMaterial().orElse(MFRMaterials.ANY),
            ByteBufCodecs.fromCodec(ResourceLocation.CODEC), comp -> comp.haftMaterial().orElse(MFRMaterials.ANY),
            MaterialDataComponent::new
    );
}
