package net.groenenhaag.tutorialmod.block;

import net.groenenhaag.tutorialmod.TutorialMod;
import net.groenenhaag.tutorialmod.block.custom.*;
import net.groenenhaag.tutorialmod.item.ModCreativeModeTab;
import net.groenenhaag.tutorialmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> RED_GEM_BLOCK = registerBlock("red_gem_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> YELLOW_GEM_ORE = registerBlock("yellow_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> DEEPSLATE_YELLOW_GEM_ORE = registerBlock("deepslate_yellow_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> NETHERRACK_YELLOW_GEM_ORE = registerBlock("netherrack_yellow_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> ENDSTONE_YELLOW_GEM_ORE = registerBlock("endstone_yellow_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> YELLOW_GEM_LAMP = registerBlock("yellow_gem_lamp",
            () -> new YellowGemLampBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(YellowGemLampBlock.LIT) ? 15 : 0)), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> TOME = registerBlock("tome",
            () -> new TomeBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)
                    .lightLevel(state -> 3).noOcclusion()), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> ITEM_DRAIN = registerBlock("item_drain",
            () -> new ItemDrainBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).noOcclusion()), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> NIGHT_NIGHT_BLOCK = registerBlock("night_night_block",
            () -> new NightNightBlock(BlockBehaviour.Properties.of(Material.POWDER_SNOW)
                    .strength(0.2f).dynamicShape()), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> BLUEBERRY_CROP = BLOCKS.register("blueberry_crop",
            () -> new BlueberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab ) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
