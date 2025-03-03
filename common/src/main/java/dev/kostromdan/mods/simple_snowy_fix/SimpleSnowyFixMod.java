package dev.kostromdan.mods.simple_snowy_fix;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class SimpleSnowyFixMod {
    public static final String MOD_ID = "simple_snowy_fix";
    public static final Logger LOGGER = LogManager.getLogger("SimpleSnowyFix");
    private static final Config config = Config.loadConfig();

    public static void init() {
    }

    public static void placeSnowOnLeaves(LevelAccessor level, BlockPos leafPos) {
        BlockPos snowPos = leafPos.above();
        if ((config.getPlaceSnowOnLeavesUnderLeaves() || level.getHeight(Heightmap.Types.MOTION_BLOCKING, snowPos.getX(), snowPos.getZ()) == snowPos.getY()) &&
                level.isEmptyBlock(snowPos) &&
                level.getBiome(snowPos).value().shouldSnow(level, snowPos)) {
            level.setBlock(snowPos, Blocks.SNOW.defaultBlockState(), 19);
        }
    }
}
