package minefantasy.mfr.entity.attachment;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import minefantasy.mfr.init.MFRAttachmentComponents;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

import static minefantasy.mfr.MineFantasyReforged.MOD_ID;

public record PlayerSkillsAttachment(int artisanry, int construction, int provisioning, int engineering, int weaponry) implements CustomPacketPayload {
    public static final String ARTISANRY = "artisanry";
    public static final String CONSTRUCTION = "construction";
    public static final String PROVISIONING = "provisioning";
    public static final String ENGINEERING = "engineering";
    public static final String WEAPONRY = "weaponry";

    public static final Codec<PlayerSkillsAttachment> CODEC;
    public static final StreamCodec<ByteBuf, PlayerSkillsAttachment> STREAM_CODEC;
    public static final CustomPacketPayload.Type<PlayerSkillsAttachment> TYPE;

    public PlayerSkillsAttachment() {
        this(1, 1, 1, 1, 1);
    }

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void increaseArtisanry(ServerLevel level, ServerPlayer player, int increment) {
        updateClient(player, player.setData(MFRAttachmentComponents.PLAYER_SKILLS_ATTACHMENT_TYPE,
                player.getData(MFRAttachmentComponents.PLAYER_SKILLS_ATTACHMENT_TYPE).increaseArtisanry(increment)));
    }

    public static void increaseConstruction(ServerLevel level, ServerPlayer player, int increment) {
        updateClient(player, player.setData(MFRAttachmentComponents.PLAYER_SKILLS_ATTACHMENT_TYPE,
                player.getData(MFRAttachmentComponents.PLAYER_SKILLS_ATTACHMENT_TYPE).increaseConstruction(increment)));
    }

    public static void increaseProvisioning(ServerLevel level, ServerPlayer player, int increment) {
        updateClient(player, player.setData(MFRAttachmentComponents.PLAYER_SKILLS_ATTACHMENT_TYPE,
                player.getData(MFRAttachmentComponents.PLAYER_SKILLS_ATTACHMENT_TYPE).increaseProvisioning(increment)));
    }

    public static void increaseEngineering(ServerLevel level, ServerPlayer player, int increment) {
        updateClient(player, player.setData(MFRAttachmentComponents.PLAYER_SKILLS_ATTACHMENT_TYPE,
                player.getData(MFRAttachmentComponents.PLAYER_SKILLS_ATTACHMENT_TYPE).increaseEngineering(increment)));
    }

    public static void increaseWeaponry(ServerLevel level, ServerPlayer player, int increment) {
        updateClient(player, player.setData(MFRAttachmentComponents.PLAYER_SKILLS_ATTACHMENT_TYPE,
                player.getData(MFRAttachmentComponents.PLAYER_SKILLS_ATTACHMENT_TYPE).increaseWeaponry(increment)));
    }

    private static void updateClient(ServerPlayer player, PlayerSkillsAttachment attachment) {
        PacketDistributor.sendToPlayer(player, attachment);
    }

    private PlayerSkillsAttachment increaseArtisanry(int increment) {
        return new PlayerSkillsAttachment(Math.min(artisanry + increment, 100), construction, provisioning, engineering, weaponry);
    }

    private PlayerSkillsAttachment increaseConstruction(int increment) {
        return new PlayerSkillsAttachment(artisanry, Math.min(construction + increment, 100), provisioning, engineering, weaponry);
    }

    private PlayerSkillsAttachment increaseProvisioning(int increment) {
        return new PlayerSkillsAttachment(artisanry, construction, Math.min(provisioning + increment, 100), engineering, weaponry);
    }

    private PlayerSkillsAttachment increaseEngineering(int increment) {
        return new PlayerSkillsAttachment(artisanry, construction, provisioning, Math.min(engineering + increment, 100), weaponry);
    }

    private PlayerSkillsAttachment increaseWeaponry(int increment) {
        return new PlayerSkillsAttachment(artisanry, construction, provisioning, engineering, Math.min(weaponry + increment, 100));
    }

    static {
        CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        Codec.INT.optionalFieldOf(ARTISANRY, 0).forGetter(PlayerSkillsAttachment::artisanry),
                        Codec.INT.optionalFieldOf(CONSTRUCTION, 0).forGetter(PlayerSkillsAttachment::construction),
                        Codec.INT.optionalFieldOf(PROVISIONING, 0).forGetter(PlayerSkillsAttachment::provisioning),
                        Codec.INT.optionalFieldOf(ENGINEERING, 0).forGetter(PlayerSkillsAttachment::engineering),
                        Codec.INT.optionalFieldOf(WEAPONRY, 0).forGetter(PlayerSkillsAttachment::weaponry)
                ).apply(instance, PlayerSkillsAttachment::new)
        );

        STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.INT, PlayerSkillsAttachment::artisanry,
                ByteBufCodecs.INT, PlayerSkillsAttachment::construction,
                ByteBufCodecs.INT, PlayerSkillsAttachment::provisioning,
                ByteBufCodecs.INT, PlayerSkillsAttachment::engineering,
                ByteBufCodecs.INT, PlayerSkillsAttachment::weaponry,
                PlayerSkillsAttachment::new
        );

        TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MOD_ID, "player_skills"));
    }
}
