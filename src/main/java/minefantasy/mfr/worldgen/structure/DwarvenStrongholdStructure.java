package minefantasy.mfr.worldgen.structure;

import minefantasy.mfr.init.MFRStructureTypes;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class DwarvenStrongholdStructure extends Structure {
    public DwarvenStrongholdStructure(StructureSettings settings) {
        super(settings);
    }

    @Override
    protected @NotNull Optional<GenerationStub> findGenerationPoint(@NotNull GenerationContext generationContext) {
        return Optional.empty();
    }

    @Override
    public @NotNull StructureType<DwarvenStrongholdStructure> type() {
        return MFRStructureTypes.DWARVEN_STRONGHOLD.get();
    }
}
