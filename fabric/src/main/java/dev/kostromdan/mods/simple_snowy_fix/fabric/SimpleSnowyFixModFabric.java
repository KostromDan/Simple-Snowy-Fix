package dev.kostromdan.mods.simple_snowy_fix.fabric;

import net.fabricmc.api.ModInitializer;

import dev.kostromdan.mods.simple_snowy_fix.SimpleSnowyFixMod;

public final class SimpleSnowyFixModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        SimpleSnowyFixMod.init();
    }
}
