package dev.kostromdan.mods.simple_snowy_fix.neoforge.mixin;

import dev.kostromdan.mods.simple_snowy_fix.SimpleSnowyFixMod;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;
import net.regions_unexplored.world.level.feature.tree.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin({
        AshenTreeFeature.class,
        AspenTreeFeature.class,
        CypressTreeFeature.class,
        DeadTreeFeature.class,
        GiantCypressTreeFeature.class,
        KapokTreeFeature.class,
        LushPineTreeFeature.class,
        PineTreeFeature.class,
        SmallOakTreeFeature.class,
        TreeShrubFeature.class,
        StrippedPineTreeFeature.class,
        LarchTreeFeature.class,
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
    private void snowOnLeaves(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration, CallbackInfoReturnable<Boolean> cir) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos);
    }
}