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

public record MaterialDataComponent(ResourceLocation mainMaterial, ResourceLocation haftMaterial) {
    public static final String SLOT_MAIN = "main_material";
    public static final String SLOT_HAFT = "haft_material";

    public static final MaterialDataComponent TOOL_DEFAULT =
            new MaterialDataComponent(MFRMaterials.ANY, MFRMaterials.OAK_WOOD);

    public static final MaterialDataComponent ITEM_DEFAULT =
            new MaterialDataComponent(MFRMaterials.ANY, MFRMaterials.ANY);

    public static final Codec<MaterialDataComponent> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    ResourceLocation.CODEC.optionalFieldOf(SLOT_MAIN, MFRMaterials.ANY).forGetter(MaterialDataComponent::mainMaterial),
                    ResourceLocation.CODEC.optionalFieldOf(SLOT_HAFT, MFRMaterials.ANY).forGetter(MaterialDataComponent::haftMaterial)
            ).apply(instance, MaterialDataComponent::new)
    );

    public static final StreamCodec<ByteBuf, MaterialDataComponent> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(ResourceLocation.CODEC), MaterialDataComponent::mainMaterial,
            ByteBufCodecs.fromCodec(ResourceLocation.CODEC), MaterialDataComponent::haftMaterial,
            MaterialDataComponent::new
    );
}
