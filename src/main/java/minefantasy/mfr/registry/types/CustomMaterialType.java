package minefantasy.mfr.registry.types;

import com.mojang.serialization.MapCodec;
import minefantasy.mfr.material.CustomMaterial;

public record CustomMaterialType(MapCodec<? extends CustomMaterial> codec) {
    public MapCodec<? extends CustomMaterial> getCodec() {
        return this.codec;
    }
}