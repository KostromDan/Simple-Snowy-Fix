# 
<h1 align="center">Simple Snowy Fix  <br>
	<a href="https://www.curseforge.com/minecraft/mc-mods/simple-snowy-fix-forge-fabric/files"><img src="https://cf.way2muchnoise.eu/versions/1211256(c70039).svg" alt="Supported Versions"></a>
	<a href="https://github.com/KostromDan/Simple-Snowy-Fix/blob/main/LICENSE"><img src="https://img.shields.io/github/license/KostromDan/Crash-Assistant?style=flat&color=900c3f" alt="License"></a>
	<a href="https://www.curseforge.com/minecraft/mc-mods/simple-snowy-fix-forge-fabric"><img src="http://cf.way2muchnoise.eu/1211256.svg" alt="CF"></a>
    <a href="https://modrinth.com/mod/simple-snowy-fix-(forge-fabric)"><img src="https://img.shields.io/modrinth/dt/3WP3HZRG?logo=modrinth&label=&suffix=%20&style=flat&color=242629&labelColor=5ca424&logoColor=1c1c1c" alt="Modrinth"></a>
    <br><br>
</h1>

This mod is a multiloader port of [Simple Snowy Fix (fabric)](https://github.com/Apollounknowndev/simple-snowy-fix) by [Apollo](https://github.com/Apollounknowndev).

Despite the original mod, doesn't include the snow under trees feature, since it is implemented well in [Snow Under Trees](https://github.com/bl4ckscor3/SnowUnderTrees) mod,
which has fixed many compatibility issues. There is no reason to duplicate its function. Also fixed compatibility with many mods.

## Features

In vanilla, snow quite often won't generate on the leaves of trees. All snowy biomes from all world generation mods are
also affected. This looks especially bad on big, voluminous trees from mods.  
It's because of a Vanilla bug, [MC-119599](https://bugs.mojang.com/browse/MC/issues/MC-119599).  
If tree leaves are in a chunk generated before the chunk containing the tree’s trunk, snow won’t cover those leaves
because the snow was placed before the leaves were added.  
This very simple mod fixes this issue. No dependencies, just drop it in and it works.

## Configuration

By default, it just fixes the bug.
However, if you want snow to also generate on leaves under other leaves, you can enable this feature in the mod config (If you want snow biomes to look snowier).

## Compatibility

It should work out of the box with most worldgen mods that add new snowy biomes.

Tested:
- Biomes O' Plenty
- Regions Unexplored
- Oh The Biomes We've Gone (and all other mods using Oh The Trees You'll Grow)

If a mod implements `TreeFeature` in some cursed way, it might require a patch. Feel free to open an issue.
It won't create problems. If there is some compatibility issue, the fix just won't apply to those biomes.

## Improve your Snow Generation

If you want a more perfect snow experience, I suggest also using these mods:

* [Snow Under Trees](https://github.com/bl4ckscor3/SnowUnderTrees) to let snow generate under trees.
* [Snow! Real Magic! ⛄](https://github.com/Snownee/SnowRealMagic) to let grass, flowers, etc generate with snow.

## Demo:

![](https://KostromDan.github.io/Simple-Snowy-Fix/slider/slider.gif)
