# Configuration cache incompatible tasks

This repository contains a Gradle build that demonstrates the APIs that can be used to mark tasks from a plugin 
as incompatible with the configuration cache.

The build uses a plugin that defines 3 tasks that are incompatible with the configuration cache:

- `broken` and `broken2` are marked as incompatible.
- `accidentallyBroken` is not marked as incompatible.

The build script `build.gradle.kts` contains some examples of using the API.
The Javadoc for the method can be found [here](https://docs.gradle.org/nightly/javadoc/org/gradle/api/Task.html#notCompatibleWithConfigurationCache-java.lang.String-).

To try it out run:

> ./gradlew broken

This will report the problems with this task, generate the configuration cache report, but won't fail the build
because the task is marked as incompatible. The configuration cache entry will be discarded.

You can also run:

> ./gradlew accidentallyBroken

This will fail the build, because the task is not marked as incompatible should have no problems associated with it.

Incompatible tasks can also be used with the `--configuration-cache-problems=warn` option, to allow users to experiment
with the task's behaviour when it is loaded from the cache and to check for further problems. When this option is 
enabled, the "incompatible" flag is ignored and all tasks treated the same way.

For example:

> ./gradlew broken --configuration-cache-problems=warn
