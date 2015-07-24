/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor

import com.google.inject.Inject
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.IJavaElement
import org.eclipse.jdt.core.IPackageFragmentRoot
import org.eclipse.jdt.core.ITypeRoot
import org.eclipse.jdt.core.JavaCore
import org.eclipse.ui.IEditorInput
import org.eclipse.ui.ide.ResourceUtil
import org.eclipse.ui.part.FileEditorInput
import org.eclipse.xtext.LanguageInfo
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.ui.editor.utils.EditorUtils
import org.eclipse.xtext.ui.generator.trace.ILocationInEclipseResource
import org.eclipse.xtext.ui.generator.trace.ITraceForStorageProvider

class XbaseEditorInputRedirector {

	@Inject
	private ITraceForStorageProvider traceInformation;

	@Inject
	private LanguageInfo languageInfo;

	@Inject
	private FileExtensionProvider fileExtensionProvider
	
	def getTypeRoot(IEditorInput it) {
		val adapter = getAdapter(IJavaElement);
		if (adapter instanceof ITypeRoot) {
			adapter
		}
	}
	
	/**
	 * @param an input
	 * 
	 * @return the original source for an editor input that points to an Xtext resource copied to the output folder, the given input otherwise 
	 */
	def IEditorInput findOriginalSourceForOuputFolderCopy(IEditorInput input) {
		val resource = ResourceUtil.getFile(input)
		if (resource != null) {
			// if the given resource is already pointing to a language file
			if (fileExtensionProvider.isValid(resource.fullPath.fileExtension)) {
				val project = JavaCore.create(resource.project)
				if (project.exists) {

					// if it's sitting in the output dir look for original one
					if (project.outputLocation.isPrefixOf(resource.fullPath)) {
						val relative = resource.fullPath.removeFirstSegments(project.outputLocation.segmentCount)
						for (source : project.packageFragmentRoots.filter[kind == IPackageFragmentRoot.K_SOURCE]) {
							val fullPath = source.correspondingResource.projectRelativePath.append(relative)
							val newFile = resource.project.getFile(fullPath)
							if (newFile.exists) {
								return new FileEditorInput(newFile)
							}
						}
					}
					// check if it's sitting in one of the output folders set on the source folders
					for (sourceFolder : project.rawClasspath.filter[entryKind == IClasspathEntry.CPE_SOURCE]) {
						if (sourceFolder.outputLocation != null
							&& sourceFolder.outputLocation.isPrefixOf(resource.fullPath)) {
								val relative = resource.fullPath.removeFirstSegments(sourceFolder.outputLocation.segmentCount)
								val source = project.findPackageFragmentRoots(sourceFolder).head
								val fullPath = source.correspondingResource.projectRelativePath.append(relative)
								val newFile = resource.project.getFile(fullPath)
								if(newFile.exists) {
									return new FileEditorInput(newFile)
								}
						}
					}
				}
			}
		}
		return input;
	}

	def IEditorInput findOriginalSource(IEditorInput input) {
		val resource = ResourceUtil.getFile(input)
		if (resource != null) {
			val original = findOriginalSourceForOuputFolderCopy(input)
			if (original !== input)
				return original

			val trace = traceInformation.getTraceToSource(resource);
			if (trace == null)
				return input;
			val allLocations = trace.getAllAssociatedLocations().iterator();
			var ILocationInEclipseResource sourceInformation = null;
			while (allLocations.hasNext() && sourceInformation == null) {
				val candidate = allLocations.next();
				if (languageInfo.equals(candidate.getLanguage())) {
					sourceInformation = candidate;
				}
			}
			if (sourceInformation == null)
				return input;
			val originalStorage = sourceInformation.platformResource
			if (originalStorage != null) {
				return EditorUtils.createEditorInput(originalStorage)
			}
		}
		return input;
	}

	def dispatch IPackageFragmentRoot getPackageFragmentRoot(IJavaElement element) {
		return element.parent.packageFragmentRoot
	}

	def dispatch IPackageFragmentRoot getPackageFragmentRoot(IPackageFragmentRoot element) {
		return element
	}

	def dispatch IPackageFragmentRoot getPackageFragmentRoot(Void element) {
		throw new IllegalStateException("couldn't find source package fragment root.")
	}

}
