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
    //    private static final Map<ChunkPos, Map<BlockPos, Boolean>> toPlaceLater = Collections.synchronizedMap(new HashMap<>());

    public static void init() {
    }

    public static void placeSnowOnLeaves(LevelAccessor level, BlockPos leafPos) {
        BlockPos snowPos = leafPos.above();
        boolean isOnTop = level.getHeight(Heightmap.Types.MOTION_BLOCKING, snowPos.getX(), snowPos.getZ()) == snowPos.getY();
        if ((config.getPlaceSnowOnLeavesUnderLeaves() || isOnTop) &&
                level.isEmptyBlock(snowPos) &&
                level.getBiome(snowPos).value().shouldSnow(level, snowPos)) {
//            ChunkPos chunkPos = new ChunkPos(snowPos);
//            toPlaceLater.computeIfAbsent(chunkPos, k -> new HashMap<>()).put(snowPos, isOnTop);
            level.setBlock(snowPos, Blocks.SNOW.defaultBlockState(), 19);
        }
    }

//    public static int placeStoredSnow(Level level, boolean placeAll) { // Generate fixed blocks later, to make screenshots, since trees are generated random on the same seed.
//        int count = 0;
//        Map<ChunkPos, Map<BlockPos, Boolean>> positionsToPlace = new HashMap<>();
//        synchronized (toPlaceLater) {
//            for (Map.Entry<ChunkPos, Map<BlockPos, Boolean>> entry : toPlaceLater.entrySet()) {
//                positionsToPlace.put(entry.getKey(), new HashMap<>(entry.getValue()));
//            }
//        }
//
//        Map<ChunkPos, Set<BlockPos>> placedPositions = new HashMap<>();
//        for (Map.Entry<ChunkPos, Map<BlockPos, Boolean>> entry : positionsToPlace.entrySet()) {
//            ChunkPos chunkPos = entry.getKey();
//            Map<BlockPos, Boolean> positions = entry.getValue();
//            if (!level.hasChunk(chunkPos.x, chunkPos.z)) {
//                continue;
//            }
//            for (Map.Entry<BlockPos, Boolean> posEntry : positions.entrySet()) {
//                BlockPos pos = posEntry.getKey();
//                boolean isOnTop = posEntry.getValue();
//                if ((placeAll || isOnTop) && level.isEmptyBlock(pos)) {
//                    level.setBlockAndUpdate(pos, Blocks.SNOW.defaultBlockState());
//                    if (level.getBlockState(pos).is(Blocks.SNOW)) {
//                        count++;
//                        placedPositions.computeIfAbsent(chunkPos, k -> new HashSet<>()).add(pos);
//                    }
//                }
//            }
//        }
//
//        synchronized (toPlaceLater) {
//            for (Map.Entry<ChunkPos, Set<BlockPos>> placedEntry : placedPositions.entrySet()) {
//                ChunkPos chunkPos = placedEntry.getKey();
//                Set<BlockPos> placed = placedEntry.getValue();
//                Map<BlockPos, Boolean> currentMap = toPlaceLater.get(chunkPos);
//                if (currentMap != null) {
//                    currentMap.keySet().removeAll(placed);
//                    if (currentMap.isEmpty()) {
//                        toPlaceLater.remove(chunkPos);
//                    }
//                }
//            }
//        }
//        return count;
//    }
}