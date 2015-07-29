/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.trace

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.generator.trace.AbsoluteURI
import org.eclipse.xtext.generator.trace.ITraceURIConverter
import org.eclipse.xtext.generator.trace.SourceRelativeURI
import org.eclipse.xtext.generator.trace.internal.AbstractTraceForURIProvider
import org.eclipse.xtext.idea.build.IdeaOutputConfigurationProvider
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent
import org.eclipse.xtext.idea.filesystem.IdeaModuleConfig
import org.eclipse.xtext.idea.filesystem.IdeaWorkspaceConfig
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil
import org.eclipse.xtext.workspace.IProjectConfig

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class TraceForVirtualFileProvider extends AbstractTraceForURIProvider<VirtualFileInProject, VirtualFileBasedTrace> implements ITraceForVirtualFileProvider {
	
	@FinalFieldsConstructor
	protected static class VirtualFilePersistedTrace implements PersistedTrace {

		val VirtualFile file
		val TraceForVirtualFileProvider traceProvider

		override AbsoluteURI getPath() {
			return traceProvider.getAbsoluteLocation(file);
		}

		override long getTimestamp() {
			return file.modificationStamp
		}

		override InputStream openStream() throws IOException {
			return new ByteArrayInputStream(file.contentsToByteArray)
		}

		override boolean exists() {
			return file.exists();
		}
		
	}
	
	@Inject Provider<VirtualFileBasedTrace> traceProvider
	@Inject IdeaOutputConfigurationProvider outputConfigurationProvider
	
	override protected asFile(AbsoluteURI absoluteURI, IProjectConfig project) {
		val file = VirtualFileManager.instance.findFileByUrl(absoluteURI.URI.toString)
		val module = (project as IdeaModuleConfig).module
		val ideaProject = module.project
		return new VirtualFileInProject(file, ideaProject)
	}
	
	override protected findInverseTraceFiles(VirtualFileInProject sourceFile) {
		val ideaProject = sourceFile.project
		val builder = ideaProject.getComponent(XtextAutoBuilderComponent)
		val generatedSources = builder.getGeneratedSources(VirtualFileURIUtil.getURI(sourceFile.file))
		val mngr = VirtualFileManager.instance
		val generatedFiles = generatedSources.map [
			mngr.findFileByUrl(it.toString)
		]
		val generatedTraces = generatedFiles.filter[
			isTraceFile(it)
		]
		val result = generatedTraces.map[
			new VirtualFilePersistedTrace(it, this) as PersistedTrace
		].toList
		return result
	}
	
	override SourceRelativeURI getGeneratedUriForTrace(IProjectConfig projectConfig, AbsoluteURI absoluteSourceResource, AbsoluteURI generatedFileURI, ITraceURIConverter traceURIConverter) {
		val module = (projectConfig as IdeaModuleConfig).module
		val outputConfigurations = outputConfigurationProvider.getOutputConfigurations(module)
		val sourceFolder = projectConfig.findSourceFolderContaining(absoluteSourceResource.getURI)
		val outputFolder = outputConfigurations.head.getOutputDirectory(sourceFolder.name)
		val contentRoot = ModuleRootManager.getInstance(module).contentRoots.head
		val sourceFolderURI = VirtualFileURIUtil.getURI(contentRoot.findFileByRelativePath(outputFolder))
		val result = generatedFileURI.deresolve(sourceFolderURI)
		return result
	}
	
	def private boolean isTraceFile(VirtualFile file) {
		return getTraceFileNameProvider().isTraceFileName(file.getName())
	}
	
	override getTraceToTarget(VirtualFileInProject sourceResource) {
		return getTraceToTarget(sourceResource, getAbsoluteLocation(sourceResource), getProjectConfig(sourceResource));
	}
	
	override protected findPersistedTrace(VirtualFileInProject generatedFile) {
		val virtualFile = generatedFile.file
		return new VirtualFilePersistedTrace(virtualFile.getTraceFile, this)
	}
	
	override protected getAbsoluteLocation(VirtualFileInProject file) {
		return getAbsoluteLocation(file.file)
	}
	
	def protected getAbsoluteLocation(VirtualFile file) {
		return new AbsoluteURI(VirtualFileURIUtil.getURI(file))
	}
	
	override protected getProjectConfig(VirtualFileInProject sourceFile) {
		return new IdeaWorkspaceConfig(sourceFile.project).findProjectContaining(VirtualFileURIUtil.getURI(sourceFile.file))
	}
	
	override protected newAbstractTrace(VirtualFileInProject file) {
		val result = traceProvider.get();
		result.localStorage = file
		result.module = (file.projectConfig as IdeaModuleConfig).module
		return result;
	}
	
	def protected VirtualFile getTraceFile(VirtualFile generatedFile) {
		val result = generatedFile.parent.findChild(traceFileNameProvider.getTraceFromJava(generatedFile.name))
		return result
	}
	
}