package org.eclipse.xtend.gradle;

import com.google.common.base.Objects;
import com.google.inject.Injector;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import org.apache.log4j.BasicConfigurator;
import org.eclipse.xtend.core.XtendInjectorSingleton;
import org.eclipse.xtend.core.compiler.batch.XtendBatchCompiler;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gradle.api.Action;
import org.gradle.api.GradleException;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.logging.LogLevel;
import org.gradle.api.logging.Logger;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.plugins.PluginContainer;
import org.gradle.api.tasks.TaskCollection;
import org.gradle.api.tasks.TaskContainer;
import org.gradle.api.tasks.TaskInputs;
import org.gradle.api.tasks.TaskOutputs;
import org.gradle.api.tasks.compile.CompileOptions;
import org.gradle.api.tasks.compile.JavaCompile;

/**
 * @author Dennis Huebner
 */
@SuppressWarnings("all")
public class XtendPlugin implements Plugin<Project> {
  private File xtendSrcDir;
  
  private File xtendGenTargetDir;
  
  private File xtendTempDir;
  
  public void apply(final Project it) {
    PluginContainer _plugins = it.getPlugins();
    _plugins.<JavaPlugin>apply(JavaPlugin.class);
    File _file = it.file("src/main/java");
    this.xtendSrcDir = _file;
    File _file_1 = it.file("build/xtend-gen");
    this.xtendGenTargetDir = _file_1;
    File _file_2 = it.file("build/xtend-temp");
    this.xtendTempDir = _file_2;
    TaskContainer _tasks = it.getTasks();
    TaskCollection<JavaCompile> javaCompilerTasks = _tasks.<JavaCompile>withType(JavaCompile.class);
    boolean _isEmpty = javaCompilerTasks.isEmpty();
    if (_isEmpty) {
      String _plus = ("compilerXtend task depends on missing " + JavaPlugin.COMPILE_JAVA_TASK_NAME);
      String _plus_1 = (_plus + " task. Build failed");
      GradleException _gradleException = new GradleException(_plus_1);
      throw _gradleException;
    }
    Iterator<JavaCompile> _iterator = javaCompilerTasks.iterator();
    final JavaCompile javaCompile = _iterator.next();
    Task task = it.task("compileXtend");
    TaskInputs _inputs = task.getInputs();
    _inputs.dir(this.xtendSrcDir);
    TaskOutputs _outputs = task.getOutputs();
    _outputs.dir(this.xtendGenTargetDir);
    final Action<Task> _function = new Action<Task>() {
        public void execute(final Task it) {
          BasicConfigurator.configure();
          Injector injector = XtendInjectorSingleton.INJECTOR;
          XtendBatchCompiler compiler = injector.<XtendBatchCompiler>getInstance(XtendBatchCompiler.class);
          Project _project = it.getProject();
          ConfigurationContainer _configurations = _project.getConfigurations();
          Configuration _findByName = _configurations.findByName("compile");
          String classpath = _findByName.getAsPath();
          String _absolutePath = XtendPlugin.this.xtendSrcDir.getAbsolutePath();
          compiler.setSourcePath(_absolutePath);
          String _absolutePath_1 = XtendPlugin.this.xtendGenTargetDir.getAbsolutePath();
          compiler.setOutputPath(_absolutePath_1);
          compiler.setClassPath(classpath);
          String _absolutePath_2 = XtendPlugin.this.xtendTempDir.getAbsolutePath();
          compiler.setTempDirectory(_absolutePath_2);
          CompileOptions _options = javaCompile.getOptions();
          String encoding = _options.getEncoding();
          boolean _notEquals = (!Objects.equal(encoding, null));
          if (_notEquals) {
            compiler.setFileEncoding(encoding);
          }
          String _fileEncoding = compiler.getFileEncoding();
          String _plus = ("Encoding: " + _fileEncoding);
          InputOutput.<String>println(_plus);
          boolean _compile = compiler.compile();
          boolean _not = (!_compile);
          if (_not) {
            GradleException _gradleException = new GradleException("Xtend compilation failed.");
            throw _gradleException;
          }
          Logger _logger = it.getLogger();
          _logger.log(LogLevel.INFO, "Miau!");
        }
      };
    task.doLast(_function);
    Set<Object> _dependsOn = javaCompile.getDependsOn();
    _dependsOn.add(task);
  }
}
