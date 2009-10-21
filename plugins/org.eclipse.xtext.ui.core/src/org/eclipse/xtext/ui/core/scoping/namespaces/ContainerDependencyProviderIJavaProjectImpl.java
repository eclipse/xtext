/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.scoping.namespaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfindex.ContainerDescriptor;
import org.eclipse.emf.emfindex.query.ContainerDescriptorQuery;
import org.eclipse.emf.emfindex.query.QueryCommand;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.query.QueryResult;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.index.IXtextIndex;
import org.eclipse.xtext.scoping.namespaces.IContainerDependencyProvider;
import org.eclipse.xtext.ui.core.builder.impl.DefaultLanguageBuilder;
import org.eclipse.xtext.ui.core.util.JdtURIUtil;

import com.google.inject.Inject;

public class ContainerDependencyProviderIJavaProjectImpl implements
		IContainerDependencyProvider {

	public static Logger log = Logger.getLogger(ContainerDependencyProviderIJavaProjectImpl.class);

	@Inject
	private IXtextIndex index;
	
	@Inject
	private JdtURIUtil jdtURIUtil;
	
	public String getContainer(EObject context) {
		IJavaProject project = getProject(context);
		if (project==null)
			return null;
		return project.getProject().getName();
	}

	public List<String> getReferencedContainers(EObject context) {
		IJavaProject project = getProject(context);
		if (project == null || !project.exists()) {
			return Collections.emptyList();
		}
		List<String> containerNames = new ArrayList<String>();
		try {
			IClasspathEntry[] classpathEntries = project.getResolvedClasspath(true);
			for (IClasspathEntry entry : classpathEntries) {
				if (entry.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
					IPath projectPath = entry.getPath();
                    IProject otherProject = getWorkspaceRoot().getProject(projectPath.segment(0));
                    containerNames.addAll(getContainerNamesForReferencedProject(otherProject));
				} else if (entry.getEntryKind() == IClasspathEntry.CPE_LIBRARY || entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
					containerNames.add(getContainerName(project, entry));
				}
			}
		} catch (JavaModelException e) {
			throw new WrappedException(e);
		}
		return containerNames;
	}

	protected String getContainerName(IJavaProject project, IClasspathEntry entry) {
		URI uri = jdtURIUtil.getURI(project, entry);
		return uri.toString();
	}

	protected Set<String> getContainerNamesForReferencedProject(IProject otherProject) throws JavaModelException {
		Set<String> names = new LinkedHashSet<String>();
		IJavaProject jp = getJavaProject(otherProject);
		if (!jp.exists() || !jp.isOpen())
			return names;
		
		IClasspathEntry[] entries = jp.getResolvedClasspath(true);
		for (IClasspathEntry cpEntry : entries) {
			if (cpEntry.isExported()) {
				names.add(getContainerName(jp,cpEntry));
			}
		}
		return names;
	}

	private IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	private IJavaProject getProject(EObject context) {
		URI uri = context.eResource().getURI();
		if (uri.isArchive()) {
			return findJavaProjectForArchive(uri);
		}
		final IFile file = getWorkspaceRoot().getFile(new Path(uri.toPlatformString(true)));
		if (file == null) {
			log.error("Couldn't find IFile for " + uri);
			return null;
		}
		return getJavaProject(file.getProject());
	}

	private IJavaProject getJavaProject(final IProject project) {
		IJavaProject javaProject = JavaCore.create(project);
		if (javaProject == null || !javaProject.exists()) {
			return null;
		}
		return javaProject;
	}

	private IJavaProject findJavaProjectForArchive(final URI uri) {
		String projectName = index.executeQueryCommand(new QueryCommand<String>() {

			public String execute(QueryExecutor queryExecutor) {
				ContainerDescriptorQuery query = new ContainerDescriptorQuery();
				query.setName(jdtURIUtil.getPathToArchive(uri).toString());
				QueryResult<ContainerDescriptor> result = queryExecutor.execute(query);
				for (ContainerDescriptor containerDescriptor : result) {
					return containerDescriptor.getUserData(DefaultLanguageBuilder.MANAGED_BY);
				}
				return null;
			}
		});
		if (projectName == null)
			return null;

		IProject project = getWorkspaceRoot().getProject(projectName);
		return getJavaProject(project);
	}


}