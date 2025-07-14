package dev.kostromdan.mods.simple_snowy_fix.forge.mixin;

import dev.kostromdan.mods.simple_snowy_fix.SimpleSnowyFixMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.ferreusveritas.dynamictrees.util.SimpleVoxmap;
import com.ferreusveritas.dynamictrees.worldgen.JoCode;

@Mixin(JoCode.class)
public class JoCodeMixin {
    @Inject(
            method = "addSnow",
            at = @At("TAIL"),
            remap = false
    )
    private void additionalSnowOnLeaves(SimpleVoxmap leafMap, LevelAccessor level, BlockPos rootPos, Biome biome, CallbackInfo ci) {
        for (SimpleVoxmap.Cell cell : leafMap.getAllNonZeroCells((byte) 0x0F)) {
            BlockPos cellPos = cell.getPos();
            SimpleSnowyFixMod.placeSnowOnLeaves(level, cellPos, true);
        }
    }
}