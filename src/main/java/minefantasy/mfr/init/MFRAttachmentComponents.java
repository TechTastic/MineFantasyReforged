package minefantasy.mfr.init;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.entity.component.PlayerSkillsAttachment;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class MFRAttachmentComponents {
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MineFantasyReforged.MOD_ID);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<PlayerSkillsAttachment>> PLAYER_SKILLS_ATTACHMENT_TYPE =
            ATTACHMENTS.register("skills", () ->
                    AttachmentType.builder(PlayerSkillsAttachment::new)
                            .serialize(PlayerSkillsAttachment.CODEC)
                            .copyOnDeath()
                            .build());

    public static void register(IEventBus bus) {
        ATTACHMENTS.register(bus);
    }
}
