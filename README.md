# 
<h1 align="center">Simple Snowy Fix  <br>
	<a href="https://legacy.curseforge.com/minecraft/mc-mods/simple-snowy-fix-forge-fabric/files"><img src="https://cf.way2muchnoise.eu/versions/1211256(c70039).svg" alt="Supported Versions"></a>
	<a href="https://github.com/KostromDan/Simple-Snowy-Fix/blob/main/LICENSE"><img src="https://img.shields.io/github/license/KostromDan/Crash-Assistant?style=flat&color=900c3f" alt="License"></a>
	<a href="https://legacy.curseforge.com/minecraft/mc-mods/simple-snowy-fix-forge-fabric"><img src="http://cf.way2muchnoise.eu/1211256.svg" alt="CF"></a>
    <a href="https://modrinth.com/mod/simple-snowy-fix-(forge-fabric)"><img src="https://img.shields.io/modrinth/dt/3WP3HZRG?logo=modrinth&label=&suffix=%20&style=flat&color=242629&labelColor=5ca424&logoColor=1c1c1c" alt="Modrinth"></a>
    <br><br>
</h1>

This mod is a multiloader port of [Simple Snowy Fix (fabric)](https://github.com/Apollounknowndev/simple-snowy-fix) by [Apollo](https://github.com/Apollounknowndev).

Despite the original mod, doesn't include the snow under trees feature, since it is implemented well in [Snow Under Trees](https://github.com/bl4ckscor3/SnowUnderTrees) mod,
which has fixed many compatibility issues. There is no reason to duplicate its function. 

## Features

In vanilla snow quite common won't generate on the leaves of trees.
It's because of a Vanilla bug [MC-119599](https://bugs.mojang.com/browse/MC/issues/MC-119599),
If tree leaves are in a chunk generated before the chunk containing the tree’s trunk, snow won’t cover those leaves because the snow was placed before the leaves were added.
This very simple mod fixes this issue. No dependencies, no config, just drop it in and it works.

It works out of the box with worldgen mods that add new snowy biomes as well.

## Improve your Snow Generation

If you want a more perfect snow experience, I suggest also using these mods:

* [Snow Under Trees](https://github.com/bl4ckscor3/SnowUnderTrees) to let snow generate under trees.
* [Snow! Real Magic! ⛄](https://github.com/Snownee/SnowRealMagic) to let grass, flowers, etc generate with snow.

## Demo:

![](https://KostromDan.github.io/Simple-Snowy-Fix/slider/slider.gif)
