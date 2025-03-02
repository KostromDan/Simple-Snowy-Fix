package dev.kostromdan.mods.simple_snowy_fix.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;
import net.regions_unexplored.world.level.feature.tree.StrippedPineTreeFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin({
        StrippedPineTreeFeature.class
        // ... Another RU classes
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
    private void snowOnLeaves(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration, CallbackInfoReturnable<Boolean> cir) {
        BlockPos snowPos = pos.above();
        if (level.isEmptyBlock(snowPos) && level.getBiome(snowPos).value().shouldSnow(level, snowPos)) {
            level.setBlock(snowPos, Blocks.SNOW.defaultBlockState(), 19);
        }
    }
}