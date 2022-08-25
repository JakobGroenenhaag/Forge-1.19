package net.groenenhaag.tutorialmod.item;

import net.groenenhaag.tutorialmod.TutorialMod;
import net.groenenhaag.tutorialmod.block.ModBlocks;
import net.groenenhaag.tutorialmod.fluid.ModFluidTypes;
import net.groenenhaag.tutorialmod.fluid.ModFluids;
import net.groenenhaag.tutorialmod.item.custom.EightBallItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> RED_GEM = ITEMS.register("red_gem",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> YELLOW_GEM = ITEMS.register("yellow_gem",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register("eight_ball",
            () -> new EightBallItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)
                    .stacksTo(1)));

    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_CROP.get(),
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));

    public static final RegistryObject<Item> SOAP_WATER_BUCKET = ITEMS.register("soap_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SOAP_WATER, new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)
                    .stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final RegistryObject<Item> ORANGESWORD = ITEMS.register("orangesword",
            () -> new SwordItem(Tiers.IRON, 10, 5f, new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
