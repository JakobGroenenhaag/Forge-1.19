package net.groenenhaag.tutorialmod.block.entity;

import net.groenenhaag.tutorialmod.TutorialMod;
import net.groenenhaag.tutorialmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<TutorialTableBlockEntity>> TUTORIAL_TABLE =
            BLOCK_ENTITIES.register("tutorial_table", () -> BlockEntityType.Builder.of(TutorialTableBlockEntity::new,
                    ModBlocks.TUTORIAL_TABLE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
