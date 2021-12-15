# Configuration cache incompatible tasks

This repository contains a Gradle build that shows how tasks from a plugin can be marked as incompatible with 
the configuration cache.

The build uses a plugin that defines 3 tasks that are incompatible with the configuration cache:

- `broken` and `broken2` are marked as incompatible.
- `accidentallyBroken` is not marked as incompatible.

The build script `build.gradle.kts` contains some examples of using the API.

To try it out run:

> ./gradlew broken

This will report the problems with this task, generate the configuration cache report, but won't fail the build
because the task is marked as incompatible. The configuration cache entry will not be persisted.

You can also run:

> ./gradlew accidentallyBroken

This will fail in the usual way, as the task is not marked as incompatible.
