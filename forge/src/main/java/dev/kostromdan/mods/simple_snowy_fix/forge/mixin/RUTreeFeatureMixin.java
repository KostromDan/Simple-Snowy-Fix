package dev.kostromdan.mods.simple_snowy_fix.forge.mixin;

import dev.kostromdan.mods.simple_snowy_fix.SimpleSnowyFixMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.regions_unexplored.data.worldgen.features.feature.tree.MapleTreeFeature;
import net.regions_unexplored.data.worldgen.features.feature.tree.config.RuTreeConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;


@Mixin({
        MapleTreeFeature.class
})
public class RUTreeFeatureMixin {
    @Inject(
            method = "placeLeavesBlock",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z",
                    shift = At.Shift.AFTER
            )
    )
    private void snowOnLeaves(LevelAccessor level, BlockPos pos, Random Random, RuTreeConfiguration treeConfiguration, CallbackInfoReturnable<Boolean> cir) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos, false);
    }
}