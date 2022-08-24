package net.groenenhaag.tutorialmod.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.groenenhaag.tutorialmod.TutorialMod;
import net.groenenhaag.tutorialmod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, TutorialMod.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_YELLOW_GEM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.YELLOW_GEM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_YELLOW_GEM_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_YELLOW_GEM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHERRACK_YELLOW_GEM_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_YELLOW_GEM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.ENDSTONE_YELLOW_GEM_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> YELLOW_GEM_ORE = CONFIGURED_FEATURES.register("yellow_gem_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_YELLOW_GEM_ORES.get(), 7)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_YELLOW_GEM_ORE = CONFIGURED_FEATURES.register("nether_yellow_gem_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_YELLOW_GEM_ORES.get(), 9)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> END_YELLOW_GEM_ORE = CONFIGURED_FEATURES.register("end_yellow_gem_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_YELLOW_GEM_ORES.get(), 9)));



    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
