package dev.kostromdan.mods.simple_snowy_fix.fabric.mixin;

import dev.kostromdan.mods.simple_snowy_fix.SimpleSnowyFixMod;
import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SimpleSnowyFixFabricMixinPlugin implements IMixinConfigPlugin {
    private static final String REGIONS_UNEXPLORED_MOD_ID = "regions_unexplored";

    @Override
    public void onLoad(String mixinPackage) {
        // No initialization needed
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
        // No need to modify targets
    }

    @Override
    public List<String> getMixins() {
        List<String> mixins = new ArrayList<>();

        // Check if Regions Unexplored is loaded
        if (FabricLoader.getInstance().isModLoaded(REGIONS_UNEXPLORED_MOD_ID)) {
            mixins.add("RUTreeFeatureMixin");
        }

        return mixins;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        // No pre-processing needed
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        // No post-processing needed
    }
}