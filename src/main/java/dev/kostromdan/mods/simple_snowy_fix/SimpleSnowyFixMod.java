package dev.kostromdan.mods.simple_snowy_fix;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public final class SimpleSnowyFixMod {
    public static final String MOD_ID = "simple_snowy_fix";
    public static final Logger LOGGER = LogManager.getLogger("SimpleSnowyFix");
    private static final Config config = Config.loadConfig();

    private static final Cache<WorldGenRegion, BiomeManager> REGION_CACHE = CacheBuilder.newBuilder()
            .weakKeys()
            .expireAfterAccess(10, TimeUnit.SECONDS)
            .build();

    public static void init() {
    }

    public static void placeSnowOnLeaves(LevelAccessor level, BlockPos leafPos) {
        BlockPos snowPos = leafPos.above();
        if (level instanceof WorldGenRegion region &&
                (config.getPlaceSnowOnLeavesUnderLeaves() || region.getHeight(Heightmap.Types.MOTION_BLOCKING, snowPos.getX(), snowPos.getZ()) == snowPos.getY()) &&
                region.isEmptyBlock(snowPos) &&
                !region.isEmptyBlock(leafPos)) {

            Holder<Biome> biome = getSafeBiomeCached(region, snowPos);

            if (biome.value().shouldSnow(region, snowPos)) {
                region.setBlock(snowPos, Blocks.SNOW.defaultBlockState(), 19);
            }
        }
    }

    private static Holder<Biome> getSafeBiomeCached(WorldGenRegion region, BlockPos pos) {
        try {
            BiomeManager safeManager = REGION_CACHE.get(region, () -> createSafeManager(region));
            return safeManager.getBiome(pos);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static BiomeManager createSafeManager(WorldGenRegion region) {
        BiomeManager.NoiseBiomeSource safeSource = (quartX, quartY, quartZ) -> {
            int chunkX = quartX >> 2;
            int chunkZ = quartZ >> 2;

            if (region.hasChunk(chunkX, chunkZ)) {
                return region.getChunk(chunkX, chunkZ).getNoiseBiome(quartX, quartY, quartZ);
            } else {
                return region.getUncachedNoiseBiome(quartX, quartY, quartZ);
            }
        };
        return new BiomeManager(safeSource, BiomeManager.obfuscateSeed(region.getSeed()));
    }
}