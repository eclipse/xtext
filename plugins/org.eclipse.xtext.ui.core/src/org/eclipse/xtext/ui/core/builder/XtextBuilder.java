/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.emfindex.Index;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.store.IndexUpdater;
import org.eclipse.emf.emfindex.store.UpdateCommand;
import org.eclipse.emf.emfindex.store.UpdateableIndex;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.resource.ResourceSetReferencingResourceSetImpl;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextBuilder extends IncrementalProjectBuilder {
	public static Logger log = Logger.getLogger(XtextBuilder.class);

	private static Injector injector;

	static {
		try {
			injector = Guice.createInjector(new BuilderModule());
			IndexAccess.setIndex(injector.getInstance(Index.class));
		}
		catch (Exception e) {
			log.error("Couldn't initialize XtextBuilder", e);
		}
	}
	
	public XtextBuilder() {
		injector.injectMembers(this);
	}


	public static final String BUILDER_ID = "org.eclipse.xtext.ui.core.xtextBuilder";

	private Map<IProject, ResourceSetReferencingResourceSetImpl> projectToResourceSetMap = new HashMap<IProject, ResourceSetReferencingResourceSetImpl>();

	@Inject
	private UpdateableIndex index;

	@Inject
	private ResourcesToBuildBuilder resourcesToBuildBuilder;

	@SuppressWarnings("unchecked")
	@Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		try {
			if (kind == FULL_BUILD) {
				fullBuild(monitor);
			}
			else {
				IResourceDelta delta = getDelta(getProject());
				if (delta == null || isDependencyChange(delta) || isOpened(delta) || changesInReferencedProjects()) {
					fullBuild(monitor);
					//project builders don't get triggered for their close event.
					//			} else if (isClosed(delta)){
					//				clean(monitor);
				}
				else {
					incrementalBuild(delta, monitor);
				}
			}
		}
		catch (RuntimeException e) {
			log.error(e.getMessage(), e);
		}
		return getProject().getReferencedProjects();
	}

	private boolean changesInReferencedProjects() throws CoreException {
		for (IProject refProj : getProject().getReferencedProjects()) {
			IResourceDelta delta = getDelta(refProj);
			if (isClosed(delta) || isOpened(delta) || isDependencyChange(delta))
				return true;
			ResourceToBuildCollector collector = new ResourceToBuildCollector(getResourceSet(refProj));
			delta.accept(collector);
			if (!collector.getResourcesToBuild().isEmpty())
				return true;
		}
		return false;
	}

	protected boolean isDependencyChange(IResourceDelta delta) {
		return (delta.getFlags() & IResourceDelta.DESCRIPTION) != 0;
	}

	protected boolean isOpened(IResourceDelta delta) {
		return delta.getResource() instanceof IProject && (delta.getFlags() & IResourceDelta.OPEN) != 0
				&& ((IProject) delta.getResource()).isOpen();
	}

	protected boolean isClosed(IResourceDelta delta) {
		return delta.getResource() instanceof IProject && (delta.getFlags() & IResourceDelta.OPEN) != 0
				&& !((IProject) delta.getResource()).isOpen();
	}

	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {
		ResourceToBuildCollector visitor = new ResourceToBuildCollector(getResourceSet(getProject()));
		try {
			getProject().accept(visitor);
			resourcesToBuildBuilder.doBuild(getProject().getName(), visitor.getResourcesToBuild(), monitor);
		}
		catch (RuntimeException e) {
			log.error(e.getMessage(), e);
		}
	}

	private ResourceSet getResourceSet(IProject project) {
		ResourceSetReferencingResourceSetImpl resourceSet = projectToResourceSetMap.get(project);
		if (resourceSet == null) {
			resourceSet = new ResourceSetReferencingResourceSetImpl();
			projectToResourceSetMap.put(project, resourceSet);
			setJavaContext(project, resourceSet);
			try {
				IProject[] projects = project.getReferencedProjects();
				for (IProject iProject : projects) {
					ResourceSet referencedResourceSet = getResourceSet(iProject);
					resourceSet.getReferencedResourceSets().add(referencedResourceSet);
				}
			}
			catch (CoreException e) {
				throw new WrappedException(e);
			}
		}
		return resourceSet;
	}

	private void setJavaContext(IProject project, ResourceSetReferencingResourceSetImpl resourceSet) {
		IJavaProject javaProject = JavaCore.create(project);
		if (javaProject != null && javaProject.exists()) {
			resourceSet.setClasspathURIContext(javaProject);
		}
	}

	protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		ResourceToBuildCollector visitor = new ResourceToBuildCollector(getResourceSet(getProject()));
		try {
			delta.accept(visitor);
			resourcesToBuildBuilder.doBuild(getProject().getName(), visitor.getResourcesToBuild(), monitor);
		}
		catch (RuntimeException e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		super.clean(monitor);
		projectToResourceSetMap = new HashMap<IProject, ResourceSetReferencingResourceSetImpl>();
		index.executeUpdateCommand(new UpdateCommand<Void>() {
			public Void execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
				indexUpdater.deleteContainer(getProject().getName());
				return null;
			}
		});
	}
}
