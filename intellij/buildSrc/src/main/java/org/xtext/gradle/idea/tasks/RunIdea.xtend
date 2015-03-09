package org.xtext.gradle.idea.tasks

import com.google.common.collect.Lists
import java.io.File
import org.eclipse.xtend.lib.annotations.Accessors
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.JavaExec

/**
 * @see https://github.com/JetBrains/intellij-community/blob/3f7e93e20b7e79ba389adf593b3b59e46a3e01d1/plugins/devkit/src/run/PluginRunConfiguration.java
 */
class RunIdea extends JavaExec {
	@Input @Accessors
	File sandboxDir
	@Input @Accessors
	File ideaHome

	new() {
		main = "com.intellij.idea.Main"
		maxHeapSize = "2G"
		jvmArgs("-XX:MaxPermSize=512m")
	}

	override getJvmArgs() {
		val args = Lists.newArrayList(super.jvmArgs)
		args += '''-Didea.plugins.path=«sandboxDir»'''
		args += '''-Didea.home.path=«ideaHome»'''
		args
	}
}