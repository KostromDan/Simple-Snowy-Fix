package dev.kostromdan.mods.simple_snowy_fix.mixin;

import dev.kostromdan.mods.simple_snowy_fix.SimpleSnowyFixMod;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.regions_unexplored.world.level.feature.tree.CobaltShrubFeature;
import net.regions_unexplored.world.level.feature.tree.SmallSocotraTreeFeature;
import net.regions_unexplored.world.level.feature.tree.YellowBioshroomShrubFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({
        CobaltShrubFeature.class,
        SmallSocotraTreeFeature.class,
        YellowBioshroomShrubFeature.class
})
public class RUCustomLeavesFeatureMixin {
    @Inject(
            method = "placeLeavesBlock",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/LevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z",
                    shift = At.Shift.AFTER
            )
    )
    private void snowOnLeaves(LevelAccessor level, BlockPos pos, RandomSource randomSource, CallbackInfo ci) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos);
    }
}
