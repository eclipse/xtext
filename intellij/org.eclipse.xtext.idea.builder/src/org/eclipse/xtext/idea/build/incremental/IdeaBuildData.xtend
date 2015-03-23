package org.eclipse.xtext.idea.build.incremental

import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Data
import org.jetbrains.jps.ModuleChunk
import org.jetbrains.jps.ProjectPaths
import org.jetbrains.jps.incremental.CompileContext
import org.jetbrains.jps.incremental.ModuleLevelBuilder.OutputConsumer
import org.eclipse.xtext.idea.build.XtextIdeaRefreshComponent

@Data
class IdeaBuildData {
	String compilerName
	CompileContext context
	ModuleChunk chunk
	OutputConsumer outputConsumer
	XtextIdeaRefreshComponent refreshComponent

	def getModule() {
		chunk.modules.head // TODO: how to deal with multiple modules?
	}

	def getClasspath() {
		ProjectPaths.getCompilationClasspath(chunk, true)
	}

	def getSourceRoots() {
		ProjectPaths.getSourceRootsWithDependents(chunk).keySet
	}
	
	def getEncoding() {
		context.projectDescriptor.encodingConfiguration.getPreferredModuleChunkEncoding(chunk)
	}
	
	def getBaseDir() {
		module.contentRootsList.urls.map[
			URI.createURI(it)
		].findFirst [
			isFile
		].path
	}
}