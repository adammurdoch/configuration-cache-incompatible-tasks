import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class TestPlugin implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        target.getPlugins().apply("java-library");

        target.getTasks().register("broken", BrokenTask.class);
        target.getTasks().register("broken2", BrokenTask.class);
        target.getTasks().register("accidentallyBroken", AccidentallyBrokenTask.class);
    }
}
