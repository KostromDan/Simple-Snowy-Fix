package dev.kostromdan.mods.simple_snowy_fix.mixin;

import dev.kostromdan.mods.simple_snowy_fix.SimpleSnowyFixMod;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.regions_unexplored.world.level.feature.configuration.RUTreeConfiguration;
import net.regions_unexplored.world.level.feature.tree.SmallOakTreeFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SmallOakTreeFeature.class)
public class RUSmallOakBranchLeavesFeatureMixin {
    @Inject(method = "placeNorthBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 1, shift = At.Shift.AFTER))
    private void snowOnNorthAbove(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.north().above());
    }

    @Inject(method = "placeNorthBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 2, shift = At.Shift.AFTER))
    private void snowOnNorthBelow(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.north().below());
    }

    @Inject(method = "placeNorthBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 3, shift = At.Shift.AFTER))
    private void snowOnNorthNorth(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.north().north());
    }

    @Inject(method = "placeNorthBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 4, shift = At.Shift.AFTER))
    private void snowOnNorthEast(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.north().east());
    }

    @Inject(method = "placeNorthBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 5, shift = At.Shift.AFTER))
    private void snowOnNorthWest(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.north().west());
    }

    @Inject(method = "placeSouthBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 1, shift = At.Shift.AFTER))
    private void snowOnSouthAbove(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.south().above());
    }

    @Inject(method = "placeSouthBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 2, shift = At.Shift.AFTER))
    private void snowOnSouthBelow(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.south().below());
    }

    @Inject(method = "placeSouthBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 3, shift = At.Shift.AFTER))
    private void snowOnSouthSouth(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.south().south());
    }

    @Inject(method = "placeSouthBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 4, shift = At.Shift.AFTER))
    private void snowOnSouthEast(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.south().east());
    }

    @Inject(method = "placeSouthBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 5, shift = At.Shift.AFTER))
    private void snowOnSouthWest(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.south().west());
    }

    @Inject(method = "placeEastBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 1, shift = At.Shift.AFTER))
    private void snowOnEastAbove(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.east().above());
    }

    @Inject(method = "placeEastBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 2, shift = At.Shift.AFTER))
    private void snowOnEastBelow(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.east().below());
    }

    @Inject(method = "placeEastBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 3, shift = At.Shift.AFTER))
    private void snowOnEastEast(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.east().east());
    }

    @Inject(method = "placeEastBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 4, shift = At.Shift.AFTER))
    private void snowOnEastSouth(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.east().south());
    }

    @Inject(method = "placeEastBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 5, shift = At.Shift.AFTER))
    private void snowOnEastNorth(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.east().north());
    }

    @Inject(method = "placeWestBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 1, shift = At.Shift.AFTER))
    private void snowOnWestAbove(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.west().above());
    }

    @Inject(method = "placeWestBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 2, shift = At.Shift.AFTER))
    private void snowOnWestBelow(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.west().below());
    }

    @Inject(method = "placeWestBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 3, shift = At.Shift.AFTER))
    private void snowOnWestWest(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.west().west());
    }

    @Inject(method = "placeWestBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 4, shift = At.Shift.AFTER))
    private void snowOnWestSouth(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.west().south());
    }

    @Inject(method = "placeWestBranch", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 5, shift = At.Shift.AFTER))
    private void snowOnWestNorth(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos.west().north());
    }
}
