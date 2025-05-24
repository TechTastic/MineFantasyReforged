package minefantasy.mfr.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

public class MFRUtils {
    @Nullable
    public static AABB getAOEToBeDestroyed(int range, Level level, BlockPos initalBlockPos, LivingEntity entity) {
        BlockHitResult traceResult = level.clip(new ClipContext(entity.getEyePosition(1f),
                (entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(entity.getAttributeValue(Attributes.BLOCK_INTERACTION_RANGE)))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity));
        if(traceResult.getType() == HitResult.Type.MISS)
            return null;

        AABB aabb = new AABB(initalBlockPos);

        return switch (traceResult.getDirection()) {
            case DOWN, UP -> aabb.inflate(range, 0, range);
            case NORTH, SOUTH -> aabb.inflate(range, range, 0);
            case EAST, WEST -> aabb.inflate(0, range, range);
        };
    }
}
