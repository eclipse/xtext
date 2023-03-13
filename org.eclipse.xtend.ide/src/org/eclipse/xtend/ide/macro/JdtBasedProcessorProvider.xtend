/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.macro

import java.net.URL
import java.net.URLClassLoader
import java.util.LinkedHashSet
import java.util.Set
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.core.JavaModelException
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.resource.ResourceSetContext
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.internal.Log
import org.eclipse.core.filesystem.EFS

@Log
class JdtBasedProcessorProvider extends ProcessorInstanceForJvmTypeProvider {
	
	override getProcessorInstance(JvmType type) {
		try {
			val classLoader = getClassLoader(type)
			val result = classLoader.loadClass(type.identifier)
			return result.getDeclaredConstructor().newInstance
		} catch (Exception e) {
			throw new IllegalStateException("Problem during instantiation of " + type.identifier + " : " + e.getMessage,
				e);
		}
	}

	override getClassLoader(EObject ctx) {
		val rs = ctx.eResource.resourceSet as XtextResourceSet
		val isBuilder = ResourceSetContext.get(rs).isBuilder
		val isEditor = ResourceSetContext.get(rs).isEditor
		if (isBuilder) {
			val adapter = rs.eAdapters.filter(ProcessorClassloaderAdapter).head
			if (adapter !== null)
				return adapter.classLoader
		}
		if (isEditor) {
			val adapter = ctx.editorResource.eAdapters.filter(ProcessorClassloaderAdapter).head
			if (adapter !== null) {
				if (adapter.classLoader === null) {
					// old adapter without classLoader (already closed)
					// remove
					ctx.editorResource.eAdapters.remove(adapter)				
				} else {
					return adapter.classLoader
				}
			}
		}
		val project = rs.classpathURIContext as IJavaProject
		val classloader = createClassLoaderForJavaProject(project)
		if (isBuilder) {
			rs.eAdapters.add(new ProcessorClassloaderAdapter(classloader))
		}
		if (isEditor) {
			ctx.editorResource.eAdapters += new ProcessorClassloaderAdapter(classloader)
		}
		return classloader
	}
	
	private def Resource getEditorResource(EObject ctx) {
		// in editor it is resource #1
		ctx.eResource.resourceSet.resources.head
	}

	/**
	 * Construct a Classloader with the classpathentries from the provided and all upstream-projects, 
	 * except the output folders of the local project.
	 */
	protected def createClassLoaderForJavaProject(IJavaProject projectToUse) {
		val urls = newLinkedHashSet()
		try {
			collectClasspathURLs(projectToUse, urls, isOutputFolderIncluded(), newHashSet)
		} catch(JavaModelException e) {
			if (!e.isDoesNotExist)
				LOG.error(e.message, e)
		}
		return new URLClassLoader(urls, getParentClassLoader())
	}

	protected def isOutputFolderIncluded() {
		false;
	}

	protected def void collectClasspathURLs(IJavaProject projectToUse, LinkedHashSet<URL> result,
		boolean includeOutputFolder, Set<IJavaProject> visited) throws JavaModelException {
		if (!projectToUse.project.isAccessible || !visited.add(projectToUse)) {
			return;
		}
		if (includeOutputFolder) {
			var IPath path = projectToUse.getOutputLocation().addTrailingSeparator();
			var URL url = new URL(URI.createPlatformResourceURI(path.toString(), true).toString());
			result.add(url);
		}
		val resolvedClasspath = projectToUse.getResolvedClasspath(true)
		for (entry : resolvedClasspath) {
			var URL url = null
			switch entry.entryKind {
				case IClasspathEntry.CPE_SOURCE: {
					if (includeOutputFolder) {
						val path = entry.getOutputLocation();
						if (path !== null)
							url = new URL(
								URI.createPlatformResourceURI(path.addTrailingSeparator().toString(), true).toString());
					}
				}
				case IClasspathEntry.CPE_PROJECT: {
					var IPath path = entry.getPath()
					val IResource project = projectToUse.workspaceRoot.findMember(path)
					val referencedProject = JavaCore.create(project.getProject())
					collectClasspathURLs(referencedProject, result, true, visited)
				}
				case IClasspathEntry.CPE_LIBRARY: {
					var IPath path = entry.getPath()
					// if the library is in the workspace, the entry path is relative to the workspace root
					// thus we load it as a resource and take the raw path to find the location in the file system
					val IResource library = projectToUse.workspaceRoot.findMember(path)
					url = if (library !== null) {
						val locationUri = library.locationURI
						if (EFS.SCHEME_FILE == locationUri?.scheme) {
							library.rawLocationURI?.toURL
						} else {
							//TODO we should support non default file systems as well
							null
						}
					} else {
						// otherwise we use the path itself
						path.toFile().toURI().toURL()
					}
				}
				default: {
					var IPath path = entry.getPath();
					url = path.toFile().toURI().toURL();
				}
			}
			if (url !== null) {
				result.add(url);
			}
		}
	}

	protected def getParentClassLoader() {
		val bundleClassLoader = TransformationContext.classLoader
		return bundleClassLoader
	}

	def private getWorkspaceRoot(IJavaProject javaProject) {
		javaProject.project.workspace.root
	}
}
