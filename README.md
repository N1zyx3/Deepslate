# Deepslate

Fabric mod for **Minecraft 26.1.2, 26.2 and 26.3**, built as a multi-version project with [Stonecutter](https://stonecutter.kikugie.dev/).

## Setup

For setup instructions, please see the [Fabric Documentation page](https://docs.fabricmc.net/develop/getting-started/creating-a-project#setting-up) related to the IDE that you are using.

## Versions

| Minecraft | Fabric API       |
|-----------|------------------|
| 26.1.2    | 0.155.3+26.1.2   |
| 26.2      | 0.161.0+26.2     |
| 26.3      | 0.166.2+26.3     |

Per-version dependencies live in `versions/<version>/gradle.properties`.

## Build

```bash
./gradlew build                  # builds every registered version
./gradlew :26.3:runClient        # run a specific version
./gradlew stonecutterSwitchTo26.2  # switch the shared src/ to 26.2
```

Jars are written to `versions/<version>/build/libs/`.

## License

This template is available under the CC0 license. Feel free to learn from it and incorporate it in your own projects.
