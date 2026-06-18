package dev.kostromdan.mods.simple_snowy_fix.mixin;

import dev.kostromdan.mods.simple_snowy_fix.SimpleSnowyFixMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.regions_unexplored.world.level.feature.tree.LargeJoshuaTreeFeature;
import net.regions_unexplored.world.level.feature.tree.MediumJoshuaTreeFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({
        LargeJoshuaTreeFeature.class,
        MediumJoshuaTreeFeature.class
})
public class RUJoshuaTreeFeatureMixin {
    @Inject(
            method = "placeLeaves",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z",
                    ordinal = 4,
                    shift = At.Shift.AFTER
            )
    )
    private void snowOnLowerLeaves(LevelAccessor level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.above());
    }

    @Inject(
            method = "placeLeaves",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z",
                    ordinal = 5,
                    shift = At.Shift.AFTER
            )
    )
    private void snowOnUpperLeaves(LevelAccessor level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.above().above());
    }
}
