package dev.kostromdan.mods.simple_snowy_fix.mixin;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SimpleSnowyFixFabricMixinPlugin implements IMixinConfigPlugin {
    private static final String REGIONS_UNEXPLORED_FABRIC_CLASS = "net.regions_unexplored.world.level.feature.configuration.RUTreeConfiguration";

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

        mixins.addAll(SimpleSnowyFixCommonMixinPlugin.getCommonMixins());

        if (SimpleSnowyFixCommonMixinPlugin.existsByResource(REGIONS_UNEXPLORED_FABRIC_CLASS)) {
            mixins.add("RUTreeFeatureMixin");
            mixins.add("RUAspenTreeFeatureMixin");
            mixins.add("RUCustomLeavesFeatureMixin");
            mixins.add("RUSakuraTreeFeatureMixin");
            mixins.add("RUKapokTreeFeatureMixin");
            mixins.add("RUSmallJoshuaTreeFeatureMixin");
            mixins.add("RUJoshuaTreeFeatureMixin");
            mixins.add("RUBranchLeavesFeatureMixin");
            mixins.add("RUBaobabBranchLeavesFeatureMixin");
            mixins.add("RUSmallOakBranchLeavesFeatureMixin");
            mixins.add("RUBrimWillowFeatureMixin");
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
