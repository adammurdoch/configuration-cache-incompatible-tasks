plugins {
    id("test.plugin")
}

// Locate task by name
tasks.named("broken").configure {
    notCompatibleWithConfigurationCache("uses project at runtime")
}

// Locate task by type
tasks.withType(BrokenTask::class.java).configureEach {
    notCompatibleWithConfigurationCache("uses project at runtime")
}
