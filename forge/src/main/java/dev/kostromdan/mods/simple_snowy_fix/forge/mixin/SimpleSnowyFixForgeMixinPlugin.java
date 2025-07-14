package dev.kostromdan.mods.simple_snowy_fix.forge.mixin;

import net.minecraftforge.fml.loading.LoadingModList;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SimpleSnowyFixForgeMixinPlugin implements IMixinConfigPlugin {
    private static final String REGIONS_UNEXPLORED_MOD_ID = "regions_unexplored";
    private static final String DYNAMIC_TREES_MOD_ID = "dynamictrees";

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
        if (LoadingModList.get().getModFileById(REGIONS_UNEXPLORED_MOD_ID)!=null) {
            mixins.add("RUTreeFeatureMixin");
        }

        // Check if Dynamic Trees is loaded
        if (LoadingModList.get().getModFileById(DYNAMIC_TREES_MOD_ID)!=null) {
            mixins.add("JoCodeMixin");
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