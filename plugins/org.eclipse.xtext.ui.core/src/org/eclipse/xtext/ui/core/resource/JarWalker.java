/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.resource;

import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class JarWalker<T> {

	public T traverse(IPackageFragmentRoot root, boolean stopOnFirstResult) throws JavaModelException {
		T result = null;
		
		Object[] resources = root.getNonJavaResources();
		for (Object object : resources) {
			if (object instanceof IJarEntryResource) {
				result = traverse((IJarEntryResource) object,stopOnFirstResult);
				if (stopOnFirstResult && result!=null)
					return result;
			}
		}
		
		IJavaElement[] children = root.getChildren();
		for (IJavaElement iJavaElement : children) {
			if (iJavaElement instanceof IPackageFragment) {
				result = traverse((IPackageFragment) iJavaElement,stopOnFirstResult);
				if (stopOnFirstResult && result!=null)
					return result;
			}
		}
		return result;
	}

	protected T traverse(IPackageFragment pack, boolean stopOnFirstResult) throws JavaModelException {
		T result = null;
		IJavaElement[] children = pack.getChildren();
		for (IJavaElement iJavaElement : children) {
			if (iJavaElement instanceof IPackageFragment) {
				result = traverse((IPackageFragment) iJavaElement,stopOnFirstResult);
				if (stopOnFirstResult && result!=null)
					return result;
			}
		}
		Object[] resources = pack.getNonJavaResources();
		for (Object object : resources) {
			if (object instanceof IJarEntryResource) {
				result = traverse((IJarEntryResource) object,stopOnFirstResult);
				if (stopOnFirstResult && result!=null)
					return result;
			}
		}
		return result;
	}

	protected T traverse(IJarEntryResource jarEntry, boolean stopOnFirstResult) {
		T result = null;
		if (jarEntry.isFile()) {
			result = handle(jarEntry);
		} else {
			IJarEntryResource[] children = jarEntry.getChildren();
			for (IJarEntryResource child : children) {
				result = traverse(child,stopOnFirstResult);
				if (stopOnFirstResult && result!=null)
					return result;
			}
		}
		return result;
	}

	protected abstract T handle(IJarEntryResource jarEntry);

}
