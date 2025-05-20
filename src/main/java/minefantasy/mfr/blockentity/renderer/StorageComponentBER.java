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
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;

import java.util.HashMap;

public class StorageComponentBER implements BlockEntityRenderer<StorageComponentBE> {
    private final BlockEntityRendererProvider.Context context;
    private final HashMap<StorageComponentBlock.Type, BakedModel> models = new HashMap<>();

    public StorageComponentBER(BlockEntityRendererProvider.Context context) {
        this.context = context;
         ModelManager manager = context.getBlockRenderDispatcher().getBlockModelShaper().getModelManager();

         for (StorageComponentBlock.Type type : StorageComponentBlock.Type.values()) {
             this.models.computeIfAbsent(type, t -> manager.getModel(ModelResourceLocation.standalone(t.getModelLocation())));
         }
    }

    @Override
    public void render(@NotNull StorageComponentBE storageComponentBE, float partialTick, @NotNull PoseStack poseStack,
                       @NotNull MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        renderBars(storageComponentBE, partialTick, poseStack, multiBufferSource, packedLight, packedOverlay);
    }

    private void renderBars(@NotNull StorageComponentBE storageComponentBE, float partialTick, @NotNull PoseStack poseStack,
                            @NotNull MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        BakedModel model = this.models.get(StorageComponentBlock.Type.BAR);
        CustomMaterial material = storageComponentBE.getMaterial();

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
                poseStack.rotateAround(quat, 0, 1, 0);

                poseStack.translate(-1, 0, 0);
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
                poseStack.translate(1, 0, 0);

                var quat = new Quaternionf();
                quat = quat.fromAxisAngleDeg(0, 1, 0, -90);
                poseStack.rotateAround(quat, 0, 1, 0);
            }
        }
    }
}