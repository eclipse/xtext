/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;

import com.google.common.collect.Sets;

/**
 * Analyzes a given {@link IJavaElementDelta} for relevant classpath changes
 * 
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.10
 */
public class JavaProjectClasspathChangeAnalyzer {
	
	/**
	 * retrieves all Java Projects whose classpath was effected by the given delta
	 * 
	 * @param delta the delta to analyze
	 * @return a Set of the affected Java Projects
	 */
	public Set<IJavaProject> getJavaProjectsWithClasspathChange(IJavaElementDelta delta) {
		IJavaElement element = delta.getElement();
		if (element instanceof IPackageFragmentRoot) {
			if (isRelevantPackageFragmentRootChange(delta)) {
				IPackageFragmentRoot root = (IPackageFragmentRoot) element;
				return Collections.singleton(root.getJavaProject());
			}
		} else if (element instanceof IJavaModel) {
			return getJavaProjectsWithClasspathChange(delta.getAffectedChildren());
		} else if (element instanceof IJavaProject) {
			if (isClasspathChangeOnProject(delta)) {
				// filter out IJavaElementDelta.F_SOURCEATTACHED | IJavaElementDelta.F_SOURCEDETACHED only
				if (isAttachmentChangeOnly(delta)) {
					return  Collections.emptySet();
				}
				return Collections.singleton((IJavaProject) element);
			}
			return getJavaProjectsWithClasspathChange(delta.getAffectedChildren());
		}
		return Collections.emptySet();
	}

	/**
	 * Determines if the change i a classpath change on a project
	 * 
	 * @param delta the IJavaElementDelta to analyze. the deltas element must be an instance of IProject
	 */
	public boolean isClasspathChangeOnProject(IJavaElementDelta delta) {
		assert (delta.getElement() instanceof IJavaProject);
		return (delta.getFlags() & IJavaElementDelta.F_CLASSPATH_CHANGED) != 0
				|| (delta.getFlags() & IJavaElementDelta.F_RESOLVED_CLASSPATH_CHANGED) != 0;
	}

	/**
	 * Determines if a given change is a attachment change only
	 */
	public boolean isAttachmentChangeOnly(IJavaElementDelta delta) {
		// there must be at least one child delta
		if (delta.getAffectedChildren().length == 0) {
			return false;
		}
		// all child deltas have to be attachment changes only
		for (IJavaElementDelta child : delta.getAffectedChildren()) {
			if (!isAttachmentChangeFlagOnly(child)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * determines if the delta is a relevant change on a IPackageFragmentRoot
	 * 
	 * @param delta the IJavaElementDelta to analyze. the deltas element must be an instance of IPackageFragmentRoot
	 */
	public boolean isRelevantPackageFragmentRootChange(IJavaElementDelta delta) {
		IJavaElement element = delta.getElement();
		assert (element instanceof IPackageFragmentRoot);
		return delta.getKind() == IJavaElementDelta.REMOVED
			|| delta.getKind() == IJavaElementDelta.ADDED
			|| (delta.getFlags() & IJavaElementDelta.F_REORDER) != 0
			|| (delta.getFlags() & IJavaElementDelta.F_REMOVED_FROM_CLASSPATH) != 0
			|| (delta.getFlags() & IJavaElementDelta.F_ADDED_TO_CLASSPATH) != 0
			|| (((IPackageFragmentRoot) element).isExternal() && (delta.getFlags() & // external folders change
					(IJavaElementDelta.F_CONTENT)) == delta.getFlags());
	}

	private boolean isAttachmentChangeFlagOnly(IJavaElementDelta child) {
		// change is sourceattached or sourcedetached or sourceattached and sourcedetached at the same time
		return child.getFlags() == IJavaElementDelta.F_SOURCEATTACHED
				 || child.getFlags() == IJavaElementDelta.F_SOURCEDETACHED
				|| child.getFlags() == IJavaElementDelta.F_SOURCEDETACHED + IJavaElementDelta.F_SOURCEATTACHED;
	}

	private Set<IJavaProject> getJavaProjectsWithClasspathChange(IJavaElementDelta[] affectedChildren) {
		LinkedHashSet<IJavaProject> set = Sets.newLinkedHashSet();
		for (IJavaElementDelta delta : affectedChildren) {
			set.addAll(getJavaProjectsWithClasspathChange(delta));
		}
		return set;
	}

}
