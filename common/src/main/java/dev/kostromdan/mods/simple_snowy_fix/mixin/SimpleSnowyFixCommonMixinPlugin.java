package dev.kostromdan.mods.simple_snowy_fix.mixin;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SimpleSnowyFixCommonMixinPlugin implements IMixinConfigPlugin {
    private static final String OH_THE_TREES_YOULL_GROW_CLASS = "dev.corgitaco.ohthetreesyoullgrow.world.level.levelgen.feature.TreeFromStructureNBTFeature";

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
        mixins.add("TreeFeatureMixin");

        if (existsByResource(OH_THE_TREES_YOULL_GROW_CLASS)) {
            mixins.add("TreeFromStructureNBTFeatureMixin");
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

    /**
     * Check for presence of a class by looking for its .class resource on the classpath.
     * This does NOT load or initialize the class.
     *
     * @param className Fully-qualified binary name, e.g. "com.example.MyClass"
     * @return true if the .class file is found on the classloader’s resource path
     */
    public static boolean existsByResource(String className) {
        String resourcePath = className.replace('.', '/') + ".class";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return loader.getResource(resourcePath) != null;
    }
}
