package minefantasy.mfr.entity.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record PlayerSkillsAttachment(int artisanry, int construction, int provisioning, int engineering, int weaponry) {
    public static final String ARTISANRY = "artisanry";
    public static final String CONSTRUCTION = "construction";
    public static final String PROVISIONING = "provisioning";
    public static final String ENGINEERING = "engineering";
    public static final String WEAPONRY = "weaponry";

    public PlayerSkillsAttachment() {
        this(1, 1, 1, 1, 1);
    }

    public static final Codec<PlayerSkillsAttachment> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.optionalFieldOf(ARTISANRY, 0).forGetter(PlayerSkillsAttachment::artisanry),
                    Codec.INT.optionalFieldOf(CONSTRUCTION, 0).forGetter(PlayerSkillsAttachment::construction),
                    Codec.INT.optionalFieldOf(PROVISIONING, 0).forGetter(PlayerSkillsAttachment::provisioning),
                    Codec.INT.optionalFieldOf(ENGINEERING, 0).forGetter(PlayerSkillsAttachment::engineering),
                    Codec.INT.optionalFieldOf(WEAPONRY, 0).forGetter(PlayerSkillsAttachment::weaponry)
            ).apply(instance, PlayerSkillsAttachment::new)
    );

    public static final StreamCodec<ByteBuf, PlayerSkillsAttachment> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, PlayerSkillsAttachment::artisanry,
            ByteBufCodecs.INT, PlayerSkillsAttachment::construction,
            ByteBufCodecs.INT, PlayerSkillsAttachment::provisioning,
            ByteBufCodecs.INT, PlayerSkillsAttachment::engineering,
            ByteBufCodecs.INT, PlayerSkillsAttachment::weaponry,
            PlayerSkillsAttachment::new
    );
}
