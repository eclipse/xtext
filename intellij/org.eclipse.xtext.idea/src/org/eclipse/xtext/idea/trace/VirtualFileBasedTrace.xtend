/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.trace

import com.intellij.openapi.module.Module
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import java.io.ByteArrayInputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.io.StringReader
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.generator.trace.AbsoluteURI
import org.eclipse.xtext.generator.trace.SourceRelativeURI
import org.eclipse.xtext.generator.trace.internal.AbstractTrace
import org.eclipse.xtext.idea.build.IdeaOutputConfigurationProvider
import org.eclipse.xtext.idea.filesystem.IdeaProjectConfig
import org.eclipse.xtext.idea.filesystem.IdeaProjectConfigProvider
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.ITextRegionWithLineInformation

import static extension org.eclipse.xtext.idea.resource.VirtualFileURIUtil.*

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class VirtualFileBasedTrace extends AbstractTrace implements IIdeaTrace {
	
	VirtualFileInProject localVirtualFile
	IdeaOutputConfigurationProvider outputConfigurationProvider
	IdeaProjectConfigProvider projectConfigProvider
	
	@Accessors(PROTECTED_SETTER, PUBLIC_GETTER) IdeaProjectConfig localProjectConfig
	@Accessors(PROTECTED_SETTER, PUBLIC_GETTER) VirtualFile jarRoot
	
	override getLocalURI() {
		return getURIForVirtualFile(localVirtualFile)
	}
	
	def Module getModule() {
		localProjectConfig?.module
	}
	
	override getLocalStorage() {
		return localVirtualFile
	}
	
	def protected void setLocalStorage(VirtualFileInProject localVirtualFile) {
		this.localVirtualFile = localVirtualFile;
	}

	def protected void setOutputConfigurationProvider(IdeaOutputConfigurationProvider outputConfigurationProvider) {
		this.outputConfigurationProvider = outputConfigurationProvider
	}
	
	def protected void setProjectConfigProvider(IdeaProjectConfigProvider projectConfigProvider) {
		this.projectConfigProvider = projectConfigProvider
	}
	
	def protected AbsoluteURI getURIForVirtualFile(VirtualFile virtualFile) {
		return new AbsoluteURI(virtualFile.URI)
	}
	
	def protected AbsoluteURI getURIForVirtualFile(VirtualFileInProject virtualFile) {
		return virtualFile.file.URIForVirtualFile
	}
	
	def VirtualFileInProject findVirtualFileInProject(SourceRelativeURI srcRelativeLocation) {
		val absoluteUri = resolvePath(srcRelativeLocation)
		val vFile = VirtualFileURIUtil.getVirtualFile(absoluteUri.URI)
		if (vFile === null)
			return null;
		return new VirtualFileInProject(vFile, localVirtualFile.project)
	}
	
	override AbsoluteURI resolvePath(SourceRelativeURI path) {
		if (jarRoot !== null) {
			val child = jarRoot.findFileByRelativePath(path.toString)
			val uri = VirtualFileURIUtil.getURI(child)
			return new AbsoluteURI(uri)
		} else if (isTraceToTarget && module !== null) {
			val outputConfigurations = outputConfigurationProvider.getOutputConfigurations(module)
			val sourceFolders = localProjectConfig.sourceFolders
			for(sourceFolder : sourceFolders) {
				val outputFolder = localProjectConfig.contentRoot.findFileByRelativePath(outputConfigurations.head.getOutputDirectory(sourceFolder.name))
				if (outputFolder !== null) {
					val file = outputFolder.findFileByRelativePath(path.URI.toString)
					if (file !== null) {
						return new AbsoluteURI(VirtualFileURIUtil.getURI(file))
					}
				}
			}
		}
		return super.resolvePath(path)
	}
	
	override InputStream getContents(SourceRelativeURI uri) throws IOException {
		val file = findVirtualFileInProject(uri)
		return new ByteArrayInputStream(file.file.contentsToByteArray)
	}
	
	override getContentsAsText(SourceRelativeURI uri) throws IOException {
		val project = module
		var fileInProject = findVirtualFileInProject(uri)
		if (fileInProject === null) {
			val module = "'" + project?.name + "' (" + project?.moduleFilePath + ")"
			throw new FileNotFoundException("File '" + uri + "' not found in module " + module)
		}
		val file = fileInProject.file
		return new StringReader(VfsUtil.loadText(file))
	}
	
	override protected getLocalContentsAsText() throws IOException {
		val file = localVirtualFile.file
		return new StringReader(VfsUtil.loadText(file))
	}
	
	override ILocationInVirtualFile getBestAssociatedLocation(ITextRegion region, VirtualFileInProject associatedVirtualFile) {
		val uri = getURIForVirtualFile(associatedVirtualFile);
		return getBestAssociatedLocation(region, uri);
	}

	override Iterable<? extends ILocationInVirtualFile> getAllAssociatedLocations(ITextRegion localRegion,
			VirtualFileInProject associatedVirtualFile) {
		val uri = getURIForVirtualFile(associatedVirtualFile);
		return getAllAssociatedLocations(localRegion, uri);
	}

	override Iterable<? extends ILocationInVirtualFile> getAllAssociatedLocations(VirtualFileInProject associatedVirtualFile) {
		val uri = getURIForVirtualFile(associatedVirtualFile);
		return getAllAssociatedLocations(uri);
	}

	override ILocationInVirtualFile getBestAssociatedLocation(ITextRegion region) {
		return super.getBestAssociatedLocation(region) as ILocationInVirtualFile
	}

	override ILocationInVirtualFile createLocationInResource(ITextRegionWithLineInformation region, SourceRelativeURI srcRelativePath) {
		return new LocationInVirtualFile(region.getOffset(), region.getLength(), region.getLineNumber(), region.getEndLineNumber(), srcRelativePath, this);
	}

	override Iterable<? extends ILocationInVirtualFile> getAllAssociatedLocations(ITextRegion localRegion) {
		return super.getAllAssociatedLocations(localRegion) as Iterable<? extends ILocationInVirtualFile>
	}

	override ILocationInVirtualFile getBestAssociatedLocation(ITextRegion localRegion, AbsoluteURI uri) {
		return super.getBestAssociatedLocation(localRegion, uri) as ILocationInVirtualFile
	}

	override Iterable<? extends ILocationInVirtualFile> getAllAssociatedLocations(ITextRegion localRegion, AbsoluteURI uri) {
		return super.getAllAssociatedLocations(localRegion, uri) as Iterable<? extends ILocationInVirtualFile>
	}

	override Iterable<? extends ILocationInVirtualFile> getAllAssociatedLocations(AbsoluteURI uri) {
		return super.getAllAssociatedLocations(uri) as Iterable<? extends ILocationInVirtualFile>
	}

	override Iterable<? extends ILocationInVirtualFile> getAllAssociatedLocations() {
		return super.getAllAssociatedLocations() as Iterable<? extends ILocationInVirtualFile>
	}

}