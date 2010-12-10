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
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.impl.BuildScheduler;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * TODO: this class should have a meaningful name
 */
@Singleton
public class ElementChangeListener implements IElementChangedListener {

	private final static Logger log = Logger.getLogger(ElementChangeListener.class);

	@Inject
	private IWorkspace workspace;
	
	@Inject 
	private BuildScheduler buildManager;

	public ElementChangeListener() {
		JavaCore.addElementChangedListener(this);
	}

	public void elementChanged(ElementChangedEvent event) {
		if (workspace != null && workspace.isAutoBuilding()) {
			try {
				if (event.getDelta() != null) {
					Set<IJavaProject> javaProjects = getJavaProjectsWithClasspathChange(event.getDelta());
					if (!javaProjects.isEmpty()) {
						Set<IProject> projects = Sets.newHashSet(Iterables.filter(Iterables.transform(javaProjects,
								new Function<IJavaProject, IProject>() {
									public IProject apply(IJavaProject from) {
										return from.getProject();
									}
								}), Predicates.notNull()));
						buildManager.scheduleBuildIfNecessary(projects);
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
		IJavaElement element = delta.getElement();
		if (element instanceof IPackageFragmentRoot) {
			IPackageFragmentRoot root = (IPackageFragmentRoot) element;
			if (delta.getKind() == IJavaElementDelta.REMOVED || delta.getKind() == IJavaElementDelta.ADDED
					|| (delta.getFlags() & IJavaElementDelta.F_REORDER) != 0
					|| (delta.getFlags() & IJavaElementDelta.F_REMOVED_FROM_CLASSPATH) != 0
					|| (delta.getFlags() & IJavaElementDelta.F_ADDED_TO_CLASSPATH) != 0
					|| (root.isExternal() && (delta.getFlags() & // external folders change
					(IJavaElementDelta.F_CONTENT | IJavaElementDelta.F_SOURCEATTACHED | IJavaElementDelta.F_SOURCEDETACHED)) == delta
							.getFlags())) {
				return Collections.singleton(root.getJavaProject());
			}
		} else if (element instanceof IJavaModel) {
			return getPackageFragmentRootDeltas(delta.getAffectedChildren());
		} else if (element instanceof IJavaProject) {
			if ((delta.getFlags() & IJavaElementDelta.F_CLASSPATH_CHANGED) != 0
					|| (delta.getFlags() & IJavaElementDelta.F_RESOLVED_CLASSPATH_CHANGED) != 0)
				return Collections.singleton((IJavaProject) element);
			return getPackageFragmentRootDeltas(delta.getAffectedChildren());
		}
		return Collections.emptySet();
	}

	private Set<IJavaProject> getPackageFragmentRootDeltas(IJavaElementDelta[] affectedChildren) {
		LinkedHashSet<IJavaProject> set = Sets.newLinkedHashSet();
		for (IJavaElementDelta delta : affectedChildren) {
			set.addAll(getJavaProjectsWithClasspathChange(delta));
		}
		return set;
	}

}
