package org.xtext.gradle.idea.tasks

import com.google.common.base.Splitter
import com.google.common.collect.Lists
import java.io.File
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.gradle.api.internal.tasks.options.Option
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.JavaExec

@Accessors
class RunIdea extends JavaExec {
	@Input File sandboxDir
	@Input File ideaHome
	@Input List<String> pluginsToRun = Lists.newArrayList

	new() {
		main = "com.intellij.idea.Main"
		maxHeapSize = "2G"
		jvmArgs("-XX:MaxPermSize=512m")
	}

	override getJvmArgs() {
		val args = Lists.newArrayList(super.jvmArgs)
		args += '''-Didea.home.path=«ideaHome»'''
		if (pluginsToRun.isEmpty) {
			args += '''-Didea.plugins.path=«sandboxDir»'''
		} else {
			args += '''-Dplugin.path=«pluginsToRun.join(',')[new File(sandboxDir, it).path]»'''
		}
		args
	}

	@Option(option="ideaPlugins", description="A comma-separated list of the IDs of the plugins to activate. By default, all plugins in the sandbox are activated")
	def setPluginsToRun(String pluginsToRun) {
		this.pluginsToRun = Splitter.on(',').trimResults.omitEmptyStrings.split(pluginsToRun).toList
	}
}