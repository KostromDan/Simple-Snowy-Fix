package dev.kostromdan.mods.simple_snowy_fix;

import net.minecraft.ReportedException;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.server.level.WorldGenRegion;
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
        placeSnowOnLeaves(level, leafPos, null);
    }

    public static void placeSnowOnLeaves(LevelAccessor level, BlockPos leafPos, BlockPos origin) {
        BlockPos snowPos = leafPos.above();
        if (level instanceof WorldGenRegion region &&
                (config.getPlaceSnowOnLeavesUnderLeaves() || region.getHeight(Heightmap.Types.MOTION_BLOCKING, snowPos.getX(), snowPos.getZ()) == snowPos.getY()) &&
                region.isEmptyBlock(snowPos) &&
                !region.isEmptyBlock(leafPos) &&
                isSafeToGetBiome(region, snowPos, origin)) {

            try {
                if (!region.getBiome(snowPos).value().shouldSnow(region, snowPos)) return;
            } catch (ReportedException e) {
                if (e.getCause().getMessage().contains("Requested chunk unavailable during world generation")) {
                    LOGGER.warn("Simple Snowy Fix prevented crash, this should not happen, pls report.\n" +
                            "If you're seeing massive spam of such warnings, this may be the reason of worldgen lag:\n" +
                            "{}, {}, {}, {}, {}", origin, snowPos, SectionPos.of(origin), SectionPos.of(snowPos), region.getCenter());
                    return;
                }
                throw e;
            }
            region.setBlock(snowPos, Blocks.SNOW.defaultBlockState(), 19);
        }
    }

    public static boolean isSafeToGetBiome(WorldGenRegion region, BlockPos snowPos, BlockPos origin) {
        if (origin == null) return true;

        int cx = region.getCenter().getMinBlockX();
        int cz = region.getCenter().getMinBlockZ();

        int sx = snowPos.getX() - cx;
        int sz = snowPos.getZ() - cz;

        return sx >= -14 && sx <= 29 && sz >= -14 && sz <= 29;
    }
}