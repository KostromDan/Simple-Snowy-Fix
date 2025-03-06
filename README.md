#   

<h1 align="center">Simple Snowy Fix  <br>
	<a href="https://www.curseforge.com/minecraft/mc-mods/simple-snowy-fix-forge-fabric/files"><img src="https://cf.way2muchnoise.eu/versions/1211256(c70039).svg" alt="Supported Versions"></a>
	<a href="https://github.com/KostromDan/Simple-Snowy-Fix/blob/main/LICENSE"><img src="https://img.shields.io/github/license/KostromDan/Crash-Assistant?style=flat&color=900c3f" alt="License"></a>
	<a href="https://www.curseforge.com/minecraft/mc-mods/simple-snowy-fix-forge-fabric"><img src="http://cf.way2muchnoise.eu/1211256.svg" alt="CF"></a>
    <a href="https://modrinth.com/mod/simple-snowy-fix-(forge-fabric)"><img src="https://img.shields.io/modrinth/dt/3WP3HZRG?logo=modrinth&label=&suffix=%20&style=flat&color=242629&labelColor=5ca424&logoColor=1c1c1c" alt="Modrinth"></a>
    <br><br>
</h1>

This mod is a multiloader port of [Simple Snowy Fix (fabric)](https://github.com/Apollounknowndev/simple-snowy-fix) by [Apollo](https://github.com/Apollounknowndev).

Differences with original mod:

- Added compatibility with many mods.
- Fixed many issues, like snow was generating on manually grown trees from saplings.
- Just fixes bug by default. Original mod was generating snow on leaves under leaves. We have config option for this,
  not enabled by default.
- Doesn't include the snow under trees feature, since it is implemented well
  in [Snow Under Trees](https://github.com/bl4ckscor3/SnowUnderTrees) mod,
  which has fixed many problems and compatibility issues. There is no reason to duplicate its function.

## Features

In Minecraft 1.12 and later, snow often doesn’t fully cover tree leaves in snowy biomes,
including modded ones, making trees look bad—especially large modded ones.

It's because of a Vanilla bug, [MC-119599](https://bugs.mojang.com/browse/MC/issues/MC-119599).
When terrain is generated chunk by chunk, snow is placed in a chunk before trees are added in neighboring chunks.
If a tree’s leaves from a chunk generated later extend into a chunk generated earlier,
the snow in the earlier chunk ends up under those leaves because it was already placed before the leaves appeared.

This very simple mod fixes this issue. No dependencies, just drop it in and it works.

## Configuration

By default, it just fixes the bug.
However, if you want snow to also generate on leaves under other leaves,
you can enable this feature in the mod config (If you want snow biomes to look snowier).

<details>
  <summary>Demo:</summary>
  <img src="https://KostromDan.github.io/Simple-Snowy-Fix/demo_images/vanilla_leaves.gif" alt="Vanilla Leaves">
  <img src="https://KostromDan.github.io/Simple-Snowy-Fix/demo_images/BYWG_leaves.gif" alt="BYWG Leaves">
</details>

## Compatibility

It should work out of the box with most worldgen mods that add new snowy biomes.

Tested:

- Biomes O' Plenty
- Regions Unexplored
- Oh The Biomes We've Gone (and all other mods using Oh The Trees You'll Grow)

If a mod implements trees in some cursed way, it might require a patch. Feel free to open an issue.
It won't create problems. If there is some compatibility issue, the fix just won't apply to those biomes.

## Performance

Very well, you will notice no difference. It takes less than an additional 100ms (0.1s) to generate a 32-chunk radius
of snowy biome with a lot of leaves. This was profiled directly from the code, ensuring 100% accuracy.

## Improve your Snow Generation

If you want a more perfect snow experience, I suggest also using these mods:

* [Snow Under Trees](https://github.com/bl4ckscor3/SnowUnderTrees) to let snow generate under trees.
* [Snow! Real Magic! ⛄](https://github.com/Snownee/SnowRealMagic) to let grass, flowers, etc. generate with snow.

## Demo:

![](https://KostromDan.github.io/Simple-Snowy-Fix/demo_images/vanilla.gif)
![](https://KostromDan.github.io/Simple-Snowy-Fix/demo_images/vanilla_map.gif)

![](https://KostromDan.github.io/Simple-Snowy-Fix/demo_images/BYWG.gif)
![](https://KostromDan.github.io/Simple-Snowy-Fix/demo_images/BYWG_map.gif)

Note: Screenshots were taken with the [Snow Under Trees](https://github.com/bl4ckscor3/SnowUnderTrees) and [Snow! Real Magic! ⛄](https://github.com/Snownee/SnowRealMagic) mods installed.
