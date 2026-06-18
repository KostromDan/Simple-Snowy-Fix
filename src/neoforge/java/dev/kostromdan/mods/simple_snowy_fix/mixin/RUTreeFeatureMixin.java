package dev.kostromdan.mods.simple_snowy_fix.mixin;

import dev.kostromdan.mods.simple_snowy_fix.SimpleSnowyFixMod;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.regions_unexplored.world.level.feature.configuration.RUTreeConfiguration;
import net.regions_unexplored.world.level.feature.tree.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({
        AshenTreeFeature.class,
        BambooTreeFeature.class,
        BlackwoodTreeFeature.class,
        CypressTreeFeature.class,
        DeadTreeFeature.class,
        EucalyptusTreeFeature.class,
        GiantCypressTreeFeature.class,
        IceSpireFeature.class,
        KapokTreeFeature.class,
        LarchTreeFeature.class,
        LargeSocotraTreeFeature.class,
        LushPineTreeFeature.class,
        MegaBaobabTreeFeature.class,
        PalmTreeFeature.class,
        SmallEucalyptusTreeFeature.class,
        SmallOakTreeFeature.class,
        TreeShrubFeature.class,
        StrippedPineTreeFeature.class,
        UltraBaobabTreeFeature.class
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
    private void snowOnLeaves(LevelAccessor level, BlockPos pos, RandomSource randomSource, RUTreeConfiguration treeConfiguration, CallbackInfoReturnable<Boolean> cir) {
        SimpleSnowyFixMod.placeSnowOnLeaves(level, pos);
    }
}
