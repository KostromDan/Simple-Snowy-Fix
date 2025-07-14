package dev.kostromdan.mods.simple_snowy_fix.neoforge.mixin;

import com.dtteam.dynamictrees.api.voxmap.SimpleVoxmap;
import com.dtteam.dynamictrees.worldgen.JoCode;
import dev.kostromdan.mods.simple_snowy_fix.SimpleSnowyFixMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(JoCode.class)
public class JoCodeMixin {
    @Inject(
            method = "addSnow",
            at = @At("TAIL"),
            remap = false
    )
    private void additionalSnowOnLeaves(SimpleVoxmap leafMap, LevelAccessor level, BlockPos rootPos, Holder<Biome> biome, CallbackInfo ci) {
        for (SimpleVoxmap.VoxmapCell cell : leafMap.getAllNonZeroCells((byte) 0x0F)) {
            BlockPos cellPos = cell.getPos();
            SimpleSnowyFixMod.placeSnowOnLeaves(level, cellPos);
        }
    }
}