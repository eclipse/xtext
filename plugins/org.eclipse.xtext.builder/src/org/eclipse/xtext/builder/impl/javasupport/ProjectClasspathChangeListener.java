/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.xtext.builder.impl.BuildScheduler;
import org.eclipse.xtext.builder.impl.IBuildFlag;
import org.eclipse.xtext.resource.impl.CoarseGrainedChangeEvent;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.util.JavaProjectClasspathChangeAnalyzer;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class ProjectClasspathChangeListener implements IElementChangedListener {

	private final static Logger log = Logger.getLogger(ProjectClasspathChangeListener.class);

	@Inject
	private IWorkspace workspace;
	
	@Inject 
	private BuildScheduler buildManager;
	
	@Inject 
	private IDirtyStateManager dirtyStateManager;
	
	@Inject 
	private JavaProjectClasspathChangeAnalyzer javaProjectClasspathChangeAnalyzer;

	@Override
	public void elementChanged(ElementChangedEvent event) {
		if (workspace != null && workspace.isAutoBuilding()) {
			try {
				if (event.getDelta() != null) {
					Set<IJavaProject> javaProjects = getJavaProjectsWithClasspathChange(event.getDelta());
					if (!javaProjects.isEmpty()) {
						Set<IProject> projects = Sets.newHashSet(Iterables.filter(Iterables.transform(javaProjects,
								new Function<IJavaProject, IProject>() {
									@Override
									public IProject apply(IJavaProject from) {
										return from.getProject();
									}
								}), Predicates.notNull()));
						dirtyStateManager.notifyListeners(new CoarseGrainedChangeEvent());
						buildManager.scheduleBuildIfNecessary(projects, IBuildFlag.FORGET_BUILD_STATE_ONLY);
					}
				}
			} catch (WrappedException e) {
				log.error(e.getCause().getMessage(), e.getCause());
			} catch (RuntimeException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	protected Set<IJavaProject> getJavaProjectsWithClasspathChange(IJavaElementDelta delta) {
		return javaProjectClasspathChangeAnalyzer.getJavaProjectsWithClasspathChange(delta);
	}

}
