/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class PackageFragmentRootWalker<T> {

	public static class TraversalState {
		
		private List<Object> parents;

		TraversalState(Object obj) {
			parents = Lists.<Object>newArrayList(obj);
		}
		
		public List<?> getParents() {
			return Collections.unmodifiableList(parents);
		}
		
		void pop() {
			parents.remove(parents.size() - 1);
		}
		
		void push(Object obj) {
			parents.add(obj);
		}
		
	}
	
	public T traverse(IPackageFragmentRoot root, boolean stopOnFirstResult) throws JavaModelException {
		T result = null;
		if (root.exists() && existsPhysically(root)) {
			Object[] resources = root.getNonJavaResources();
			TraversalState state = new TraversalState(root);
			for (Object object : resources) {
				if (object instanceof IJarEntryResource) {
					result = traverse((IJarEntryResource) object, stopOnFirstResult, state);
					if (stopOnFirstResult && result != null)
						return result;
				}
			}

			IJavaElement[] children = root.getChildren();
			for (IJavaElement javaElement : children) {
				if (javaElement instanceof IPackageFragment) {
					result = traverse((IPackageFragment) javaElement, stopOnFirstResult, state);
					if (stopOnFirstResult && result != null)
						return result;
				}
			}
		}
		return result;
	}
	
	private boolean existsPhysically(IPackageFragmentRoot root) throws JavaModelException {
		if(root.isExternal()) 
			return root.getPath().toFile().exists();
		else
			return root.getUnderlyingResource().exists();
	}

	protected T traverse(IPackageFragment pack, boolean stopOnFirstResult, TraversalState state) throws JavaModelException {
		T result = null;
		state.push(pack);
		IJavaElement[] children = pack.getChildren();
		for (IJavaElement iJavaElement : children) {
			if (iJavaElement instanceof IPackageFragment) {
				result = traverse((IPackageFragment) iJavaElement, stopOnFirstResult, state);
				if (stopOnFirstResult && result!=null)
					return result;
			}
		}
		Object[] resources = pack.getNonJavaResources();
		for (Object object : resources) {
			if (object instanceof IJarEntryResource) {
				result = traverse((IJarEntryResource) object, stopOnFirstResult, state);
				if (stopOnFirstResult && result!=null)
					return result;
			}
		}
		state.pop();
		return result;
	}

	protected T traverse(IJarEntryResource jarEntry, boolean stopOnFirstResult, TraversalState state) {
		T result = null;
		if (jarEntry.isFile()) {
			result = handle(jarEntry, state);
		} else {
			state.push(jarEntry);
			IJarEntryResource[] children = jarEntry.getChildren();
			for (IJarEntryResource child : children) {
				result = traverse(child, stopOnFirstResult, state);
				if (stopOnFirstResult && result!=null)
					return result;
			}
			state.pop();
		}
		return result;
	}

	protected abstract T handle(IJarEntryResource jarEntry, TraversalState state);
	
}
