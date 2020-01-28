
# RGB

At Github, create repository `java-rgb`

repo: https://github.com/johnvincentio/java-rgb

```
cd /Users/jv/Desktop/MyDevelopment/github/java/Utilities
create-repo java-rgb
```

Remove non-relevant files.

## Add `README.md`

```
cd java-rgb
```

Create `README.md`

```
For details, see Rgb/README.md
```

## Start Eclipse

in Finder

* select `/Users/jv/Desktop/MyDevelopment/github/java/Utilities/java-rgb`
* Right click, Services
  * eclipse-jee

## Create Java Project

* File, New, Project
* Java Project

Settings

* Project Name: Rgb
* Use default location
* JRE; Use an execution environment JRE: JavaSE-1.8
* Create separate folders for sources and class files

* Default output folder: `Rgb/classes`

## Package

Select `src`

* Right click, New, Package
* `io.johnvincent.rgb`

Copy code to this package and change package names.

## Script file

Add `/Users/jv/Desktop/MyDevelopment/github/java/Utilities/java-rgb/Rgb/rgb.command`

## Create Symbolic Link

```
ln -s /Users/jv/Desktop/MyDevelopment/github/java/Utilities/java-rgb/Rgb/rgb.command /Users/jv/Desktop/MyDevelopment/github/repo_shell_scripts/mac/unix-scripts/bin/rgb
```
