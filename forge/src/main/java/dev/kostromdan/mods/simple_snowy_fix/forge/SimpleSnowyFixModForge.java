package dev.kostromdan.mods.simple_snowy_fix.forge;

import dev.kostromdan.mods.simple_snowy_fix.SimpleSnowyFixMod;
import net.minecraftforge.fml.common.Mod;

@Mod(SimpleSnowyFixMod.MOD_ID)
public final class SimpleSnowyFixModForge {
    public SimpleSnowyFixModForge() {
        SimpleSnowyFixMod.init();
    }

//    @Mod.EventBusSubscriber(modid = SimpleSnowyFixMod.MOD_ID) // Generate fixed blocks later, to make screenshots, since trees are generated random on the same seed.
//    public static class ServerModEvents {
//        @SubscribeEvent
//        public static void onRegisterCommands(RegisterCommandsEvent event) {
//            CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
//            dispatcher.register(Commands.literal("place_snow")
//                    .then(Commands.argument("placeAll", BoolArgumentType.bool())
//                            .executes(context -> {
//                                boolean placeAll = BoolArgumentType.getBool(context, "placeAll");
//                                Level level = context.getSource().getLevel();
//                                int placedCount = SimpleSnowyFixMod.placeStoredSnow(level, placeAll);
//                                context.getSource().sendSuccess(
//                                        () -> Component.literal("Placed " + placedCount + " snow blocks."),
//                                        true
//                                );
//                                return placedCount;
//                            })
//                    )
//            );
//        }
//    }
}