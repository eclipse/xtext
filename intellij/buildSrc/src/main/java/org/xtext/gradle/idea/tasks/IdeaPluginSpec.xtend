package org.xtext.gradle.idea.tasks

import org.gradle.api.file.CopySpec

interface IdeaPluginSpec {
	def CopySpec getClasses()
	def CopySpec getLibraries()
	def CopySpec getMetaInf()
}