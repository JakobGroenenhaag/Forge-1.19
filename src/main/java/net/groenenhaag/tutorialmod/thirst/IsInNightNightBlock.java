package net.groenenhaag.tutorialmod.thirst;

import net.minecraft.nbt.CompoundTag;

public class IsInNightNightBlock {
    private boolean isInNightNightBlock;

    public boolean getIsInNightNightBlock() {
        return isInNightNightBlock;
    }

    public void setIsInNightNightBlock(boolean isIn) {
        this.isInNightNightBlock = isIn;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putBoolean("isInNightNightBlock", isInNightNightBlock);
    }

    public void loadNBTData(CompoundTag nbt) {
        isInNightNightBlock = nbt.getBoolean("isInNightNightBlock");
    }
}
