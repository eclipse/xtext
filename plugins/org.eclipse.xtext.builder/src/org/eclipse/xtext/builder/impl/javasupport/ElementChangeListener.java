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
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.impl.ToBeBuiltComputer;
import org.eclipse.xtext.builder.impl.UpdateProjectsJob;
import org.eclipse.xtext.ui.core.resource.IResourceSetProvider;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class ElementChangeListener implements IElementChangedListener {

	final static Logger log = Logger.getLogger(ElementChangeListener.class);

	public ElementChangeListener() {
		JavaCore.addElementChangedListener(this);
	}

	@Inject
	private ToBeBuiltComputer toBeBuiltComputer;

	@Inject
	private IBuilderState builderState;
	
	@Inject
	private IResourceSetProvider resourceSetProvider;
	
	public IResourceSetProvider getResourceSetProvider() {
		return resourceSetProvider;
	}

	public void elementChanged(ElementChangedEvent event) {
		try {
			if (event.getDelta() != null) {
				Set<IJavaProject> projects = getJavaProjectsWithClasspathChange(event.getDelta());
				if (!projects.isEmpty()) {
					Set<IProject> iProjects = Sets.newHashSet(Iterables.transform(projects, new Function<IJavaProject, IProject>() {
						public IProject apply(IJavaProject from) {
							return from.getProject();
						}
					}));
					new UpdateProjectsJob("updating projects",getResourceSetProvider(), iProjects, toBeBuiltComputer, builderState).schedule();
				}
			}
		} catch (WrappedException e) {
			log.error(e.getCause().getMessage(), e.getCause());
		} catch (RuntimeException e) {
			log.error(e.getMessage(), e);
		}
	}
	
	protected Set<IJavaProject> getJavaProjectsWithClasspathChange(IJavaElementDelta delta) {
		IJavaElement element = delta.getElement();
		if (element instanceof IPackageFragmentRoot) {
			IPackageFragmentRoot root = (IPackageFragmentRoot) element;
			if (delta.getKind() == IJavaElementDelta.REMOVED
				|| delta.getKind() == IJavaElementDelta.ADDED
				|| (delta.getFlags() & IJavaElementDelta.F_REORDER) != 0
				|| (delta.getFlags() & IJavaElementDelta.F_REMOVED_FROM_CLASSPATH) != 0
				|| (delta.getFlags() & IJavaElementDelta.F_ADDED_TO_CLASSPATH) != 0) {
				return Collections.singleton(root.getJavaProject());
			}
		} else if (element instanceof IJavaModel) {
			return getPackageFragmentRootDeltas(delta.getAffectedChildren());
		} else if (element instanceof IJavaProject) {
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
