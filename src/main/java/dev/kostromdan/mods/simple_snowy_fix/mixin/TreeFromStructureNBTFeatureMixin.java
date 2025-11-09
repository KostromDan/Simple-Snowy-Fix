package dev.kostromdan.mods.simple_snowy_fix.mixin;

import dev.corgitaco.ohthetreesyoullgrow.world.level.levelgen.feature.TreeFromStructureNBTFeature;
import dev.kostromdan.mods.simple_snowy_fix.SimpleSnowyFixMod;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Set;

@Mixin(TreeFromStructureNBTFeature.class)
public class TreeFromStructureNBTFeatureMixin {

    @Inject(
            method = "placeTreeDecorations",
            at = @At("TAIL"),
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private static void afterPlaceTreeDecorations(Iterable<TreeDecorator> treeDecorators, WorldGenLevel level, RandomSource random, Set<BlockPos> leavePositions, Set<BlockPos> trunkPositions, Set<BlockPos> decorationPositions, CallbackInfo ci) {
        for (BlockPos pos : leavePositions) {
            SimpleSnowyFixMod.placeSnowOnLeaves(level, pos);
        }
    }
}