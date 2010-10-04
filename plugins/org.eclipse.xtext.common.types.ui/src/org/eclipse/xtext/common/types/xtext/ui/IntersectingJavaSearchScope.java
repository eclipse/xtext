/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.search.IJavaSearchScope;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IntersectingJavaSearchScope implements IJavaSearchScope {

	private final IJavaSearchScope[] scopes;

	public IntersectingJavaSearchScope(IJavaSearchScope... scopes) {
		this.scopes = scopes;
	}

	public boolean encloses(String resourcePath) {
		for (IJavaSearchScope scope : scopes)
			if (!scope.encloses(resourcePath))
				return false;
		return true;
	}

	public boolean encloses(IJavaElement element) {
		for (IJavaSearchScope scope : scopes)
			if (!scope.encloses(element))
				return false;
		return true;
	}

	public IPath[] enclosingProjectsAndJars() {
		if (scopes.length == 0)
			return new IPath[0];
		if (scopes.length == 1)
			return scopes[0].enclosingProjectsAndJars();
		Collection<IPath> result = null;
		for (IJavaSearchScope scope : scopes) {
			if (result == null) {
				result = Sets.newLinkedHashSet(Arrays.asList(scope.enclosingProjectsAndJars()));
			} else {
				result.retainAll(Arrays.asList(scope.enclosingProjectsAndJars()));
			}
		}
		if (result == null)
			return new IPath[0];
		return result.toArray(new IPath[result.size()]);
	}

	@Deprecated
	public boolean includesBinaries() {
		for (IJavaSearchScope scope : scopes)
			if (!scope.includesBinaries())
				return false;
		return true;
	}

	@Deprecated
	public boolean includesClasspaths() {
		for (IJavaSearchScope scope : scopes)
			if (!scope.includesClasspaths())
				return false;
		return true;
	}

	@Deprecated
	public void setIncludesBinaries(boolean includesBinaries) {
		for (IJavaSearchScope scope : scopes)
			scope.setIncludesBinaries(includesBinaries);
	}

	@Deprecated
	public void setIncludesClasspaths(boolean includesClasspaths) {
		for (IJavaSearchScope scope : scopes)
			scope.setIncludesClasspaths(includesClasspaths);
	}

}
