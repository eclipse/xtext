/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.editor;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.generator.trace.IEclipseTrace;
import org.eclipse.xtext.ui.generator.trace.ILocationInEclipseResource;
import org.eclipse.xtext.ui.generator.trace.ITraceForStorageProvider;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

public class XbaseEditorInputRedirector {

	private final static Logger LOG = Logger.getLogger(XbaseEditorInputRedirector.class);

	@Inject
	private ITraceForStorageProvider traceInformation;

	@Inject
	private LanguageInfo languageInfo;

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	public ITypeRoot getTypeRoot(IEditorInput editorInput) {
		IJavaElement adapter = editorInput.getAdapter(IJavaElement.class);
		return adapter instanceof ITypeRoot ? (ITypeRoot) adapter : null;
	}

	/**
	 * @return The original source for an editor input that points to an Xtext resource copied to the output folder, the given input
	 *         otherwise
	 */
	public IEditorInput findOriginalSourceForOuputFolderCopy(IEditorInput input) {
		IFile resource = ResourceUtil.getFile(input);
		if (resource == null) {
			return input;
		}

		try {
			// If the given resource is already pointing to a language file
			if (fileExtensionProvider.isValid(resource.getFullPath().getFileExtension())) {
				IJavaProject project = JavaCore.create(resource.getProject());
				if (project.exists()) {

					// Check if it's sitting in the output dir, look for original one
					if (project.getOutputLocation().isPrefixOf(resource.getFullPath())) {
						IPath relative = resource.getFullPath().removeFirstSegments(project.getOutputLocation().segmentCount());

						for (IPackageFragmentRoot root : project.getPackageFragmentRoots()) {
							if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
								IPath fullPath = root.getCorrespondingResource().getProjectRelativePath().append(relative);
								IFile newFile = resource.getProject().getFile(fullPath);
								if (newFile.exists()) {
									return new FileEditorInput(newFile);
								}
							}
						}
					}

					// Check if it's sitting in one of the output folders set on the source folders
					for (IClasspathEntry classpathEntry : project.getRawClasspath()) {
						if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
							if (classpathEntry.getOutputLocation() != null
									&& classpathEntry.getOutputLocation().isPrefixOf(resource.getFullPath())) {
								IPath relative = resource.getFullPath()
										.removeFirstSegments(classpathEntry.getOutputLocation().segmentCount());
								for (IPackageFragmentRoot root : project.findPackageFragmentRoots(classpathEntry)) {
									IPath fullPath = root.getCorrespondingResource().getProjectRelativePath().append(relative);
									IFile newFile = resource.getProject().getFile(fullPath);
									if (newFile.exists()) {
										return new FileEditorInput(newFile);
									}
								}
							}
						}
					}
				}
			}
		} catch (JavaModelException e) {
			if (!e.isDoesNotExist()) {
				LOG.error("Error finding the original source for the editor input", e);
			}
		}

		return input;
	}

	public IEditorInput findOriginalSource(IEditorInput input) {
		IFile resource = ResourceUtil.getFile(input);
		if (resource == null) {
			return input;
		}

		IEditorInput original = findOriginalSourceForOuputFolderCopy(input);
		if (original != input) {
			return original;
		}

		IEclipseTrace trace = traceInformation.getTraceToSource(resource);
		if (trace == null) {
			return input;
		}

		for (ILocationInEclipseResource candidate : trace.getAllAssociatedLocations()) {
			if (languageInfo.equals(candidate.getLanguage())) {
				IStorage storage = candidate.getPlatformResource();
				if (storage != null) {
					return EditorUtils.createEditorInput(storage);
				}
			}
		}

		return input;
	}

	/**
	 * @return the {@code IPackageFragmentRoot} that contains the provided {@code element}
	 * @throws NullPointerException
	 *             if the provided {@code element} is null
	 */
	public IPackageFragmentRoot getPackageFragmentRoot(IJavaElement element) {
		Preconditions.checkNotNull(element, "Couldn't find source package fragment root.");
		return (IPackageFragmentRoot) element.getAncestor(IJavaElement.PACKAGE_FRAGMENT_ROOT);
	}

}
