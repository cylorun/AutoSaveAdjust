package com.cylorun.autosaveadjust.mixin;

import com.cylorun.autosaveadjust.AutoSaveOptions;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
    @ModifyConstant(method = "tick", constant = @Constant(intValue = 6000))
    private int modifiedInterval(int ogv) {
        return AutoSaveOptions.getInstance().interval_seconds * 20;
    }
}