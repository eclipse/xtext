/**
 * 
 */
package org.eclipse.xtend.gradle;

import java.util.Set;

import groovy.lang.Closure;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.xtend.core.XtendInjectorSingleton;
import org.eclipse.xtend.core.compiler.batch.XtendBatchCompiler;
import org.gradle.api.GradleException;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.logging.LogLevel;

import com.google.inject.Injector;

/**
 * @author Dennis Huebner
 * 
 */
public class XtendPlugin implements Plugin<Project> {

	public void apply(final Project project) {
		final XtendPluginExtension extension = project.getExtensions().create(
				"greeting", XtendPluginExtension.class);
		Task task = project.task("compileXtend");
		task.doLast(new Closure<Object>(this) {
			private static final long serialVersionUID = 1L;

			@Override
			public Object call() {

				BasicConfigurator.configure();
				Injector injector = XtendInjectorSingleton.INJECTOR;
				XtendBatchCompiler compiler = injector
						.getInstance(XtendBatchCompiler.class);
				// compiler.setOutputPath(targetPath);
				// compiler.setClassPath(classpath)
				// compiler.setSourcePath(srcPath)
				// compiler.setTempDirectory(xtendTempDir.absolutePath)
				// compiler.setFileEncoding(project.getPlugins().getPlugin(JavaPlugin.class));
				// println 'Encoding: ' + compileJava.options.encoding
				if (!compiler.compile()) {
					throw new GradleException("Xtend compilation failed.");
				}
				project.getLogger().log(LogLevel.INFO,
						extension.getStartMessage());
				return null;
			}
		});
		Set<Task> tasksByName = project.getTasksByName("compileJava", true);
		task.setDependsOn(tasksByName);
	}
}
