/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.macro

import java.io.File
import java.net.URL
import java.net.URLClassLoader
import java.util.LinkedHashSet
import java.util.List
import java.util.Set
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.ecore.EObject
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.launching.JavaRuntime
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.resource.XtextResourceSet

class JdtBasedProcessorProvider extends ProcessorInstanceForJvmTypeProvider {
	
	override getProcessorInstance(JvmType type) {
		try {
			val project = (type.eResource.resourceSet as XtextResourceSet).classpathURIContext as IJavaProject
			val classLoader = createClassLoaderForJavaProject(project)
			val result = classLoader.loadClass(type.identifier)
			return result.newInstance
		} catch (Exception e) {
			throw new IllegalStateException("Problem during instantiation of "+type.identifier+" : "+e.getMessage, e);
		}
	}
	
	override getClassLoader(EObject ctx) {
		val project = (ctx.eResource.resourceSet as XtextResourceSet).classpathURIContext as IJavaProject
		return createClassLoaderForJavaProject(project)
	}
	
	protected def createClassLoaderForJavaProject(IJavaProject projectToUse) {
		val classPathEntries = <String>newLinkedHashSet
		deepCollectRuntimeClassPath(projectToUse, newHashSet, classPathEntries)
		// remove local output folders, as they are in an inconsistent state
		removeLocalOutputFolders(projectToUse, classPathEntries)
		val List<URL> urls = classPathEntries.map[new File(it).toURI.toURL].toList
		return new URLClassLoader(urls, getParentClassLoader())
	}
	
	protected def removeLocalOutputFolders(IJavaProject project, LinkedHashSet<String> classPathEntries) {
		for (classpathEntry : project.rawClasspath) {
			if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
				var IPath path=classpathEntry.getOutputLocation() 
				if (path != null) {
					val outputfolder = project.project.workspace.root.getFolder(path)
					classPathEntries.remove(outputfolder.location.toString) 
				}
			}
		}
		val outputfolder = project.project.workspace.root.getFolder(project.outputLocation)
		classPathEntries.remove(outputfolder.location.toString)
	}
	
	private def void deepCollectRuntimeClassPath(IJavaProject project, Set<IJavaProject> visitedProjects, LinkedHashSet<String> allEntries) {
		if (!visitedProjects.add(project)) {
			return;
		}
		val entries = JavaRuntime.computeDefaultRuntimeClassPath(project)
		allEntries.addAll(entries)
		for (requiredProjectName : project.requiredProjectNames) {
			val reqProject = project.project.workspace.root.getProject(requiredProjectName);
			val javaReqProject = JavaCore.create(reqProject)
			if (javaReqProject.isOpen) {
				deepCollectRuntimeClassPath(javaReqProject, visitedProjects, allEntries)
			}
		}
	}
	
	protected def getParentClassLoader() {
		val bundleClassLoader = TransformationContext.classLoader
		return bundleClassLoader
	}
	
}