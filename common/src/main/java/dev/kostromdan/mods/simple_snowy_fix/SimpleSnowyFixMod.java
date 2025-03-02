package dev.kostromdan.mods.simple_snowy_fix;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public final class SimpleSnowyFixMod {
    public static final String MOD_ID = "simple_snowy_fix";

    public static void init() {
    }

    public static void placeSnowOnLeaves(LevelAccessor level, BlockPos leafPos) {
        BlockPos snowPos = leafPos.above();
        BlockPos upSnowPos1 = snowPos.above();
        BlockPos upSnowPos2 = upSnowPos1.above();
        BlockPos upSnowPos3 = upSnowPos2.above();

        if (level.isEmptyBlock(snowPos) && level.getBiome(snowPos).value().shouldSnow(level, snowPos) && level.isEmptyBlock(upSnowPos1) && level.isEmptyBlock(upSnowPos2) && level.isEmptyBlock(upSnowPos3)) {
            level.setBlock(snowPos, Blocks.SNOW.defaultBlockState(), 19);
        }
    }
}
