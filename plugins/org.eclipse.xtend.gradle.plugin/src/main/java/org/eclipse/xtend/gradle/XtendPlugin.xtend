package org.eclipse.xtend.gradle

import java.io.File
import org.apache.log4j.BasicConfigurator
import org.eclipse.xtend.core.XtendInjectorSingleton
import org.eclipse.xtend.core.compiler.batch.XtendBatchCompiler
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.LogLevel
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.tasks.compile.JavaCompile

/** 
 * @author Dennis Huebner
 */
class XtendPlugin implements Plugin<Project> {
	var File xtendSrcDir
	var File xtendGenTargetDir
	var File xtendTempDir

	override apply(Project it) {
		plugins.apply(typeof(JavaPlugin))
		xtendSrcDir = file('src/main/java')
		xtendGenTargetDir = file('build/xtend-gen')
		xtendTempDir = file('build/xtend-temp')
		var javaCompilerTasks = tasks.withType(typeof(JavaCompile))
		if (javaCompilerTasks.empty) {
			throw new GradleException(
				'compilerXtend task depends on missing ' + JavaPlugin::COMPILE_JAVA_TASK_NAME + ' task. Build failed');
		}
		val javaCompile = javaCompilerTasks.iterator.next
		var task = task('compileXtend')
		task.inputs.dir(xtendSrcDir)
		task.outputs.dir(xtendGenTargetDir)
		task.doLast(
			[
				BasicConfigurator::configure
				var injector = XtendInjectorSingleton::INJECTOR
				var compiler = injector.getInstance(typeof(XtendBatchCompiler))
				var classpath = project.configurations.findByName('compile').asPath
				compiler.sourcePath = xtendSrcDir.absolutePath
				compiler.outputPath = xtendGenTargetDir.absolutePath
				compiler.classPath = classpath
				compiler.tempDirectory = xtendTempDir.absolutePath
				var encoding = javaCompile.options.encoding
				if (encoding != null) {
					compiler.fileEncoding = encoding
				}
				println('Encoding: ' + compiler.fileEncoding)
				if (!compiler.compile) {
					throw new GradleException('Xtend compilation failed.');
				}
				logger.log(LogLevel::INFO, "Miau!")
			]
		)
		javaCompile.dependsOn.add(task)
	}
}
