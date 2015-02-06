/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.macro

import java.net.URL
import java.net.URLClassLoader
import java.util.LinkedHashSet
import java.util.Set
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.ResourceSetContext

class JdtBasedProcessorProvider extends ProcessorInstanceForJvmTypeProvider {
	
	@FinalFieldsConstructor @Accessors public static class ProcessorClassloaderAdapter extends AdapterImpl {
		val ClassLoader classLoader
	}
	
	override getProcessorInstance(JvmType type) {
		try {
			val classLoader = getClassLoader(type)
			val result = classLoader.loadClass(type.identifier)
			return result.newInstance
		} catch (Exception e) {
			throw new IllegalStateException("Problem during instantiation of "+type.identifier+" : "+e.getMessage, e);
		}
	}
	
	override getClassLoader(EObject ctx) {
		val rs = ctx.eResource.resourceSet as XtextResourceSet
		val isBuilder = ResourceSetContext.get(rs).isBuilder
		if (isBuilder) {
			val adapter = rs.eAdapters.filter(ProcessorClassloaderAdapter).head
			if (adapter != null)
				return adapter.classLoader
		}
		val project = rs.classpathURIContext as IJavaProject
		val classloader = createClassLoaderForJavaProject(project)
		if (isBuilder) {
			rs.eAdapters.add(new ProcessorClassloaderAdapter(classloader))
		}
		return classloader
	}
	
	/**
	 * Construct a Classloader with the classpathentries from the provided and all upstream-projects, 
	 * except the output folders of the local project.
	 */
	protected def createClassLoaderForJavaProject(IJavaProject projectToUse) {
		val urls = newLinkedHashSet()
		collectClasspathURLs(projectToUse, urls, false, newHashSet)
		return new URLClassLoader(urls, getParentClassLoader())
	}
	
	protected def void collectClasspathURLs(IJavaProject projectToUse, LinkedHashSet<URL> result, boolean includeOutputFolder, Set<IJavaProject> visited) {
		if(!visited.add(projectToUse)) {
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
						if (path != null) 
							url = new URL(URI.createPlatformResourceURI(path.addTrailingSeparator().toString(), true).toString());
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
					url = if (library != null) {
						library.rawLocationURI.toURL
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
			if (url != null) {
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