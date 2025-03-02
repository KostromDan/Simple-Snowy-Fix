package dev.kostromdan.mods.simple_snowy_fix.mixin;

import dev.corgitaco.ohthetreesyoullgrow.world.level.levelgen.feature.TreeFromStructureNBTFeature;
import dev.kostromdan.mods.simple_snowy_fix.SimpleSnowyFixMod;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;
import java.util.Set;

@Mixin(TreeFromStructureNBTFeature.class)
public class TreeFromStructureNBTFeatureMixin {

    @Inject(
            method = "placeLeavesWithCalculatedDistanceAndRotation",
            at = @At("TAIL"),
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private static void snowOnLeaves(BlockStateProvider leavesProvider, WorldGenLevel level, BlockPos origin, RandomSource random, StructurePlaceSettings placeSettings, List<StructureTemplate.StructureBlockInfo> leaves, Set<BlockPos> leavePositions, BlockPos canopyCenterOffset, BlockPredicate leavesPlacementFilter, CallbackInfo ci) {
        for (BlockPos pos : leavePositions) {
            SimpleSnowyFixMod.placeSnowOnLeaves(level, pos);
        }
    }
}