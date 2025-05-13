package minefantasy.mfr.worldgen.structure.processor;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import minefantasy.mfr.init.MFRBlocks;
import minefantasy.mfr.init.MFRStructureProcessorTypes;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DwarvenStrongholdAgeProcessor extends StructureProcessor {
    public static final MapCodec<DwarvenStrongholdAgeProcessor> CODEC;
    private static final float PROBABILITY_OF_REPLACING_FULL_BLOCK = 0.5F;
    private static final float PROBABILITY_OF_REPLACING_STAIRS = 0.5F;
    private static final float PROBABILITY_OF_REPLACING_OBSIDIAN = 0.15F;
    private static final BlockState[] NON_MOSSY_REPLACEMENTS;
    private final float mossiness;

    public DwarvenStrongholdAgeProcessor(float mossiness) {
        this.mossiness = mossiness;
    }

    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return MFRStructureProcessorTypes.DWARVEN_AGE_PROCESSOR.get();
    }

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo process(@NotNull LevelReader level, @NotNull BlockPos offset, @NotNull BlockPos pos, StructureTemplate.@NotNull StructureBlockInfo blockInfo, StructureTemplate.@NotNull StructureBlockInfo relativeBlockInfo, @NotNull StructurePlaceSettings settings, @Nullable StructureTemplate template) {
        RandomSource randomsource = settings.getRandom(relativeBlockInfo.pos());
        BlockState blockstate = relativeBlockInfo.state();
        BlockPos blockpos = relativeBlockInfo.pos();
        BlockState blockstate1 = null;
        if (!blockstate.is(MFRBlocks.REINFORCED_STONE_BRICKS)) {
            if (blockstate.is(MFRBlocks.REINFORCED_STONE_BRICK_STAIRS)) {
                blockstate1 = this.maybeReplaceStairs(randomsource, relativeBlockInfo.state());
            } else if (blockstate.is(MFRBlocks.REINFORCED_STONE_BRICK_SLAB)) {
                blockstate1 = this.maybeReplaceSlab(randomsource);
            } else if (blockstate.is(MFRBlocks.REINFORCED_STONE_BRICK_WALL)) {
                blockstate1 = this.maybeReplaceWall(randomsource);
            } else if (blockstate.is(Blocks.OBSIDIAN)) {
                blockstate1 = this.maybeReplaceObsidian(randomsource);
            }
        } else {
            blockstate1 = this.maybeReplaceFullStoneBlock(randomsource);
        }

        return blockstate1 != null ? new StructureTemplate.StructureBlockInfo(blockpos, blockstate1, relativeBlockInfo.nbt()) : relativeBlockInfo;
    }

    @javax.annotation.Nullable
    private BlockState maybeReplaceFullStoneBlock(RandomSource random) {
        if (random.nextFloat() >= 0.5F) {
            return null;
        } else {
            BlockState[] ablockstate = new BlockState[] {
                    MFRBlocks.CRACKED_REINFORCED_STONE_BRICKS.get().defaultBlockState(),
                    getRandomFacingStairs(random, MFRBlocks.CRACKED_REINFORCED_STONE_BRICK_STAIRS.get())
            };
            BlockState[] ablockstate1 = new BlockState[] {
                    MFRBlocks.MOSSY_REINFORCED_STONE_BRICKS.get().defaultBlockState(),
                    getRandomFacingStairs(random, MFRBlocks.MOSSY_REINFORCED_STONE_BRICK_STAIRS.get())
            };
            return this.getRandomBlock(random, ablockstate, ablockstate1);
        }
    }

    @javax.annotation.Nullable
    private BlockState maybeReplaceStairs(RandomSource random, BlockState state) {
        Direction direction = state.getValue(StairBlock.FACING);
        Half half = state.getValue(StairBlock.HALF);
        if (random.nextFloat() >= 0.5F) {
            return null;
        } else {
            BlockState[] ablockstate = new BlockState[] {
                    MFRBlocks.MOSSY_REINFORCED_STONE_BRICK_STAIRS.get().defaultBlockState()
                            .setValue(StairBlock.FACING, direction)
                            .setValue(StairBlock.HALF, half),
                    MFRBlocks.MOSSY_REINFORCED_STONE_BRICK_SLAB.get().defaultBlockState()};
            return this.getRandomBlock(random, NON_MOSSY_REPLACEMENTS, ablockstate);
        }
    }

    @javax.annotation.Nullable
    private BlockState maybeReplaceSlab(RandomSource random) {
        return random.nextFloat() < this.mossiness ? MFRBlocks.MOSSY_REINFORCED_STONE_BRICK_SLAB.get().defaultBlockState() : null;
    }

    @javax.annotation.Nullable
    private BlockState maybeReplaceWall(RandomSource random) {
        return random.nextFloat() < this.mossiness ? MFRBlocks.MOSSY_REINFORCED_STONE_BRICK_WALL.get().defaultBlockState() : null;
    }

    @javax.annotation.Nullable
    private BlockState maybeReplaceObsidian(RandomSource random) {
        return random.nextFloat() < 0.15F ? Blocks.CRYING_OBSIDIAN.defaultBlockState() : null;
    }

    private static BlockState getRandomFacingStairs(RandomSource random, Block stairsBlock) {
        return stairsBlock.defaultBlockState().setValue(StairBlock.FACING, Direction.Plane.HORIZONTAL.getRandomDirection(random)).setValue(StairBlock.HALF, Util.getRandom(Half.values(), random));
    }

    private BlockState getRandomBlock(RandomSource random, BlockState[] normalStates, BlockState[] mossyStates) {
        return random.nextFloat() < this.mossiness ? getRandomBlock(random, mossyStates) : getRandomBlock(random, normalStates);
    }

    private static BlockState getRandomBlock(RandomSource random, BlockState[] states) {
        return states[random.nextInt(states.length)];
    }

    static {
        CODEC = Codec.FLOAT.fieldOf("mossiness").xmap(DwarvenStrongholdAgeProcessor::new, (processor) -> processor.mossiness);
        NON_MOSSY_REPLACEMENTS = new BlockState[] {
                MFRBlocks.REINFORCED_STONE_BRICK_SLAB.get().defaultBlockState()
        };
    }
}
