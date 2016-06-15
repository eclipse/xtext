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

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.search.IJavaSearchScope;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IntersectingJavaSearchScope implements IJavaSearchScope {

	private static final Logger log = Logger.getLogger(IntersectingJavaSearchScope.class);
	
	private final IJavaSearchScope[] scopes;
	private final boolean[] dontAsk;

	public IntersectingJavaSearchScope(IJavaSearchScope... scopes) {
		this.scopes = scopes;
		this.dontAsk = new boolean[scopes.length];
	}

	@Override
	public boolean encloses(String resourcePath) {
		boolean result = false;
		for (int i = 0; i < scopes.length; i++) {
			if (!dontAsk[i]) {
				IJavaSearchScope scope = scopes[i];
				try {
					if (!scope.encloses(resourcePath))
						return false;
					result = true;
				} catch(Exception e) {
					dontAsk[i] = true;
					log.info("Exception in JDT code", e);
				}
			}
		}
		return result;
	}

	@Override
	public boolean encloses(IJavaElement element) {
		boolean result = false;
		for (int i = 0; i < scopes.length; i++) {
			if (!dontAsk[i]) {
				IJavaSearchScope scope = scopes[i];
				try {
					if (!scope.encloses(element))
						return false;
					result = true;
				} catch(Exception e) {
					dontAsk[i] = true;
					log.info("Exception in JDT code", e);
				}
			}
		}
		return result;
	}

	@Override
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

	@Override
	@Deprecated
	public boolean includesBinaries() {
		for (IJavaSearchScope scope : scopes)
			if (!scope.includesBinaries())
				return false;
		return true;
	}

	@Override
	@Deprecated
	public boolean includesClasspaths() {
		for (IJavaSearchScope scope : scopes)
			if (!scope.includesClasspaths())
				return false;
		return true;
	}

	@Override
	@Deprecated
	public void setIncludesBinaries(boolean includesBinaries) {
		for (IJavaSearchScope scope : scopes)
			scope.setIncludesBinaries(includesBinaries);
	}

	@Override
	@Deprecated
	public void setIncludesClasspaths(boolean includesClasspaths) {
		for (IJavaSearchScope scope : scopes)
			scope.setIncludesClasspaths(includesClasspaths);
	}

}
