import org.gradle.api.DefaultTask;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.tasks.TaskAction;

public abstract class AccidentallyBrokenTask extends DefaultTask {
    @TaskAction
    public void run() {
        Configuration runtimeClasspath = getProject().getConfigurations().findByName("runtimeClasspath");
        System.out.println("runtime classpath = " + runtimeClasspath);
    }
}
