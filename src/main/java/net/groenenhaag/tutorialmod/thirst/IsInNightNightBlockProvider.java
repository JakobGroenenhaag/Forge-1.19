package net.groenenhaag.tutorialmod.thirst;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IsInNightNightBlockProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<IsInNightNightBlock> IS_IN_NIGHT_NIGHT_BLOCK = CapabilityManager.get(new CapabilityToken<IsInNightNightBlock>() { });

    private IsInNightNightBlock isInNightNightBlock = null;
    private final LazyOptional<IsInNightNightBlock> optional = LazyOptional.of(this::createIsInNightNightBlock);

    private IsInNightNightBlock createIsInNightNightBlock() {
        if(this.isInNightNightBlock == null) {
            this.isInNightNightBlock = new IsInNightNightBlock();
        }

        return this.isInNightNightBlock;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == IS_IN_NIGHT_NIGHT_BLOCK) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createIsInNightNightBlock().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createIsInNightNightBlock().loadNBTData(nbt);
    }
}
