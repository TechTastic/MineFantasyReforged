package minefantasy.mfr.blockentity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import minefantasy.mfr.block.StorageComponentBlock;
import minefantasy.mfr.blockentity.StorageComponentBE;
import minefantasy.mfr.material.CustomMaterial;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;

import java.util.*;

public class StorageComponentBER implements BlockEntityRenderer<StorageComponentBE> {
    private final BlockEntityRendererProvider.Context context;
    private static final HashMap<StorageComponentBlock.Type, BakedModel> MODELS = new HashMap<>();

    public StorageComponentBER(BlockEntityRendererProvider.Context context) {
        this.context = context;
        ModelManager manager = context.getBlockRenderDispatcher().getBlockModelShaper().getModelManager();

        for (StorageComponentBlock.Type type : StorageComponentBlock.Type.values()) {
            MODELS.computeIfAbsent(type, t -> manager.getModel(ModelResourceLocation.standalone(t.getModelLocation())));
        }
    }

    @Override
    public void render(@NotNull StorageComponentBE storageComponentBE, float partialTick, @NotNull PoseStack poseStack,
                       @NotNull MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        StorageComponentBlock.Type type = storageComponentBE.getBlockState().getValue(StorageComponentBlock.TYPE);
        switch (type) {
            case TIMBER, TIMBER_CUT -> renderTimber(storageComponentBE, storageComponentBE.getMaterial(), poseStack, multiBufferSource, packedLight, packedOverlay);
            case TIMBER_PANE, PLATE, CHAIN_MESH, SCALE_MESH, SPLINT_MESH -> renderPane(storageComponentBE, storageComponentBE.getMaterial(), poseStack, multiBufferSource, packedLight, packedOverlay);
            case BAR, MOULD, FIREBRICK -> renderBar(storageComponentBE, storageComponentBE.getMaterial(), poseStack, multiBufferSource, packedLight, packedOverlay);
            case POT -> renderPot(storageComponentBE, storageComponentBE.getMaterial(), poseStack, multiBufferSource, packedLight, packedOverlay);
            case JUG -> {}
            case PLATE_HUGE -> renderBigPane(storageComponentBE, storageComponentBE.getMaterial(), poseStack, multiBufferSource, packedLight, packedOverlay);
        }
    }

    private void renderBar(@NotNull StorageComponentBE storageComponentBE, @NotNull CustomMaterial material, @NotNull PoseStack poseStack,
                            @NotNull MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        BakedModel model = MODELS.get(storageComponentBE.getBlockState().getValue(StorageComponentBlock.TYPE));

        for (int current = 1; current <= storageComponentBE.getStack().getCount(); current++) {
            int layer = (current - 1) / 8;
            int bar = current - layer * 8;
            int xOffset = switch (bar) {
                case 1, 5 -> 0;
                case 2, 6 -> 4;
                case 3, 7 -> 8;
                default -> 12;
            };
            int zOffset = (bar > 4) ? 8 : 0;

            if (layer % 2 != 0) {
                var quat = new Quaternionf();
                quat = quat.fromAxisAngleDeg(0, 1, 0, 90);
                poseStack.rotateAround(quat, 0.5f, 0, 0.5f);
            }

            poseStack.translate(xOffset / 16f, layer * .125f, zOffset / 16f);

            this.context.getBlockRenderDispatcher().getModelRenderer().renderModel(
                    poseStack.last(),
                    multiBufferSource.getBuffer(RenderType.TRANSLUCENT),
                    storageComponentBE.getBlockState(),
                    model,
                    material.getColourARGB()[1] / 255f,
                    material.getColourARGB()[2] / 255f,
                    material.getColourARGB()[3] / 255f,
                    packedLight,
                    packedOverlay,
                    ModelData.builder().build(),
                    RenderType.CUTOUT
            );

            poseStack.translate(-xOffset / 16f, -layer * .125f, -zOffset / 16f);

            if (layer % 2 != 0) {
                var quat = new Quaternionf();
                quat = quat.fromAxisAngleDeg(0, 1, 0, -90);
                poseStack.rotateAround(quat, 0.5f, 0, 0.5f);
            }
        }
    }

    private void renderTimber(@NotNull StorageComponentBE storageComponentBE, @NotNull CustomMaterial material, @NotNull PoseStack poseStack,
                              @NotNull MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        BakedModel model = MODELS.get(storageComponentBE.getBlockState().getValue(StorageComponentBlock.TYPE));

        for (int current = 1; current <= storageComponentBE.getStack().getCount(); current++) {
            int layer = (current - 1) / 4;
            int plank = current - layer * 4;
            int xOffset = switch (plank) {
                case 1 -> -1;
                case 2 -> 3;
                case 3 -> 7;
                default -> 11;
            };

            if (layer % 2 != 0)
                xOffset++;

            poseStack.translate(xOffset / 16f, layer / 16f, 0);

            this.context.getBlockRenderDispatcher().getModelRenderer().renderModel(
                    poseStack.last(),
                    multiBufferSource.getBuffer(RenderType.TRANSLUCENT),
                    storageComponentBE.getBlockState(),
                    model,
                    material.getColourARGB()[1] / 255f,
                    material.getColourARGB()[2] / 255f,
                    material.getColourARGB()[3] / 255f,
                    packedLight,
                    packedOverlay,
                    ModelData.builder().build(),
                    RenderType.CUTOUT
            );

            poseStack.translate(-xOffset / 16f, -layer / 16f, 0);
        }
    }

    private void renderPane(@NotNull StorageComponentBE storageComponentBE, @NotNull CustomMaterial material, @NotNull PoseStack poseStack,
                            @NotNull MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        BakedModel model = MODELS.get(storageComponentBE.getBlockState().getValue(StorageComponentBlock.TYPE));

        long seed = Mth.getSeed(storageComponentBE.getBlockPos());
        Random random = new Random(seed);

        for (int current = 1; current <= storageComponentBE.getStack().getCount(); current++) {
            int layer = current - 1;
            float layerRot = random.nextFloat(-10, 10);

            poseStack.translate(0, layer / 16f, 0);

            var quat = new Quaternionf();
            quat = quat.fromAxisAngleDeg(0, 1, 0, layerRot);
            poseStack.rotateAround(quat, .5f, 0, .5f);

            this.context.getBlockRenderDispatcher().getModelRenderer().renderModel(
                    poseStack.last(),
                    multiBufferSource.getBuffer(RenderType.TRANSLUCENT),
                    storageComponentBE.getBlockState(),
                    model,
                    material.getColourARGB()[1] / 255f,
                    material.getColourARGB()[2] / 255f,
                    material.getColourARGB()[3] / 255f,
                    packedLight,
                    packedOverlay,
                    ModelData.builder().build(),
                    RenderType.CUTOUT
            );

            quat = quat.fromAxisAngleDeg(0, 1, 0, -layerRot);
            poseStack.rotateAround(quat, 0.5f, 0, 0.5f);

            poseStack.translate(0, -layer / 16f, 0);
        }
    }

    private void renderBigPane(@NotNull StorageComponentBE storageComponentBE, @NotNull CustomMaterial material, @NotNull PoseStack poseStack,
                            @NotNull MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        BakedModel model = MODELS.get(storageComponentBE.getBlockState().getValue(StorageComponentBlock.TYPE));

        long seed = Mth.getSeed(storageComponentBE.getBlockPos());
        Random random = new Random(seed);

        for (int current = 1; current <= storageComponentBE.getStack().getCount(); current++) {
            int layer = current - 1;
            float layerRot = random.nextFloat(-10, 10);

            poseStack.translate(0, layer / 8f, 0);

            var quat = new Quaternionf();
            quat = quat.fromAxisAngleDeg(0, 1, 0, layerRot);
            poseStack.rotateAround(quat, .5f, 0, .5f);

            this.context.getBlockRenderDispatcher().getModelRenderer().renderModel(
                    poseStack.last(),
                    multiBufferSource.getBuffer(RenderType.TRANSLUCENT),
                    storageComponentBE.getBlockState(),
                    model,
                    material.getColourARGB()[1] / 255f,
                    material.getColourARGB()[2] / 255f,
                    material.getColourARGB()[3] / 255f,
                    packedLight,
                    packedOverlay,
                    ModelData.builder().build(),
                    RenderType.CUTOUT
            );

            quat = quat.fromAxisAngleDeg(0, 1, 0, -layerRot);
            poseStack.rotateAround(quat, 0.5f, 0, 0.5f);

            poseStack.translate(0, -layer / 8f, 0);
        }
    }

    private void renderPot(@NotNull StorageComponentBE storageComponentBE, @NotNull CustomMaterial material, @NotNull PoseStack poseStack,
                            @NotNull MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        BakedModel model = MODELS.get(storageComponentBE.getBlockState().getValue(StorageComponentBlock.TYPE));

        for (int current = 1; current <= storageComponentBE.getStack().getCount(); current++) {
            int layer = (current - 1) / 16;
            int plank = current - layer * 16;
            int xOffset = switch (plank) {
                case 1, 5, 9, 13 -> 0;
                case 2, 6, 10, 14 -> 4;
                case 3, 7, 11, 15 -> 8;
                default -> 12;
            };

            int zOffset = ((plank - 1) / 4) * 4;

            poseStack.translate(xOffset / 16f, layer / 4f, zOffset / 16f);

            this.context.getBlockRenderDispatcher().getModelRenderer().renderModel(
                    poseStack.last(),
                    multiBufferSource.getBuffer(RenderType.TRANSLUCENT),
                    storageComponentBE.getBlockState(),
                    model,
                    material.getColourARGB()[1] / 255f,
                    material.getColourARGB()[2] / 255f,
                    material.getColourARGB()[3] / 255f,
                    packedLight,
                    packedOverlay,
                    ModelData.builder().build(),
                    RenderType.CUTOUT
            );

            poseStack.translate(-xOffset / 16f, -layer / 4f, -zOffset / 16f);
        }
    }
}