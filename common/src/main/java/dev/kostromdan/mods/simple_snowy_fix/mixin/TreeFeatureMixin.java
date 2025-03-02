package dev.kostromdan.mods.simple_snowy_fix.mixin;

import dev.kostromdan.mods.simple_snowy_fix.SimpleSnowyFixMod;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Set;

@Mixin(TreeFeature.class)
public class TreeFeatureMixin {
    @Inject(
            method = "place(Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;)Z",
            locals = LocalCapture.CAPTURE_FAILHARD,
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/levelgen/structure/BoundingBox;encapsulatingPositions(Ljava/lang/Iterable;)Ljava/util/Optional;",
                    shift = Shift.BEFORE
            )
    )
    private void snowOnLeaves(FeaturePlaceContext<TreeConfiguration> context, CallbackInfoReturnable<Boolean> cir, WorldGenLevel level, RandomSource random, BlockPos blockPos, TreeConfiguration treeFeatureConfig, Set<BlockPos> set, Set<BlockPos> set2, Set<BlockPos> set3, Set<BlockPos> set4) {
        for (BlockPos leafPos : set3) {
            SimpleSnowyFixMod.placeSnowOnLeaves(level, leafPos);
        }
    }
}