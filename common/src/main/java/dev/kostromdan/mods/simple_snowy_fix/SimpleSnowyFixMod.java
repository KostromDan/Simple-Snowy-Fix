package dev.kostromdan.mods.simple_snowy_fix;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class SimpleSnowyFixMod {
    public static final String MOD_ID = "simple_snowy_fix";
    public static final Logger LOGGER = LogManager.getLogger("SimpleSnowyFix");
    private static final Config config = Config.loadConfig();

    public static void init() {
    }

    public static void placeSnowOnLeaves(LevelAccessor level, BlockPos leafPos, boolean ignoreCanSurvive) {
        BlockPos snowPos = leafPos.above();
        if (level instanceof WorldGenRegion &&
                (config.getPlaceSnowOnLeavesUnderLeaves() || level.getHeight(Heightmap.Types.MOTION_BLOCKING, snowPos.getX(), snowPos.getZ()) == snowPos.getY()) &&
                level.isEmptyBlock(snowPos) &&
                !level.isEmptyBlock(leafPos) &&
                ignoreCanSurvive ? shouldSnowIgnoreCanSurvive(level, snowPos) : level.getBiome(snowPos).value().shouldSnow(level, snowPos)) {
            level.setBlock(snowPos, Blocks.SNOW.defaultBlockState(), 19);
        }
    }

    public static boolean shouldSnowIgnoreCanSurvive(LevelReader levelReader, BlockPos blockPos) {
        if (levelReader.getBiome(blockPos).value().warmEnoughToRain(blockPos)) {
            return false;
        } else {
            if (blockPos.getY() >= levelReader.getMinBuildHeight() && blockPos.getY() < levelReader.getMaxBuildHeight() && levelReader.getBrightness(LightLayer.BLOCK, blockPos) < 10) {
                BlockState blockState = levelReader.getBlockState(blockPos);
                return blockState.isAir();
            }

            return false;
        }
    }
}
