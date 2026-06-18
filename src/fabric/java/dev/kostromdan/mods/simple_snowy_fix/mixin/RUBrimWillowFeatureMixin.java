package dev.kostromdan.mods.simple_snowy_fix.mixin;

import dev.kostromdan.mods.simple_snowy_fix.SimpleSnowyFixMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.regions_unexplored.world.level.feature.tree.nether.BrimWillowFeature;
import net.regions_unexplored.world.level.feature.tree.nether.TallBrimWillowFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Random;

@Mixin({
        BrimWillowFeature.class,
        TallBrimWillowFeature.class
})
public class RUBrimWillowFeatureMixin {
    @Inject(
            method = "placeBrimwoodLeaves",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z",
                    shift = At.Shift.AFTER
            )
    )
    private void snowOnBrimwoodLeaves(LevelAccessor level, BlockPos pos, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos);
    }

    @Inject(
            method = "addVine",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z",
                    ordinal = 0,
                    shift = At.Shift.AFTER
            ),
            locals = LocalCapture.CAPTURE_FAILHARD,
            require = 0
    )
    private void snowOnBrimwoodVineCollision(LevelAccessor level, BlockPos pos, CallbackInfo ci, Random random, int size, BlockPos place, int i) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, place.below());
    }

    @Inject(
            method = "addVine",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z",
                    ordinal = 1,
                    shift = At.Shift.AFTER
            ),
            locals = LocalCapture.CAPTURE_FAILHARD,
            require = 0
    )
    private void snowOnBrimwoodVineLast(LevelAccessor level, BlockPos pos, CallbackInfo ci, Random random, int size, BlockPos place, int i) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, place);
    }

    @Inject(
            method = "addVine",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z",
                    ordinal = 2,
                    shift = At.Shift.AFTER
            ),
            locals = LocalCapture.CAPTURE_FAILHARD,
            require = 0
    )
    private void snowOnBrimwoodVine(LevelAccessor level, BlockPos pos, CallbackInfo ci, Random random, int size, BlockPos place, int i) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, place);
    }
}
