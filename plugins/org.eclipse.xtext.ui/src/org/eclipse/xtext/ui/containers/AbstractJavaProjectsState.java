/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.containers;

import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.ui.util.IJdtHelper;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractJavaProjectsState extends AbstractAllContainersState implements IElementChangedListener {

	@Inject
	private IJdtHelper jdtHelper;
	
	@Override
	protected void registerAsListener() {
		super.registerAsListener();
		JavaCore.addElementChangedListener(this);
	}
	
	@Override
	public void unregisterAsListener() {
		JavaCore.removeElementChangedListener(this);
		super.unregisterAsListener();
	}

	public void elementChanged(ElementChangedEvent event) {
		if (event.getDelta() != null) {
			if (isAffectingPackageFragmentRoots(event.getDelta())) {
				initialize();
			}
		}
	}

	private boolean isAffectingPackageFragmentRoots(IJavaElementDelta delta) {
		IJavaElement element = delta.getElement();
		if (element instanceof IPackageFragmentRoot) {
			if (delta.getKind() == IJavaElementDelta.REMOVED
				|| delta.getKind() == IJavaElementDelta.ADDED
				|| (delta.getFlags() & IJavaElementDelta.F_REORDER) != 0
				|| (delta.getFlags() & IJavaElementDelta.F_REMOVED_FROM_CLASSPATH) != 0
				|| (delta.getFlags() & IJavaElementDelta.F_ADDED_TO_CLASSPATH) != 0
				|| (((IPackageFragmentRoot) element).isExternal() && (delta.getFlags() & // external folders change
						(IJavaElementDelta.F_CONTENT 
								| IJavaElementDelta.F_SOURCEATTACHED 
								| IJavaElementDelta.F_SOURCEDETACHED)) == delta.getFlags())) {
				return true;
			}
		} else if (element instanceof IJavaModel) {
			return isAffectingPackageFragmentRoots(delta.getAffectedChildren());
		} else if (element instanceof IJavaProject) {
			if ((delta.getFlags() & IJavaElementDelta.F_CLASSPATH_CHANGED) != 0 ||
					(delta.getFlags() & IJavaElementDelta.F_RESOLVED_CLASSPATH_CHANGED) != 0)
				return true;
			return isAffectingPackageFragmentRoots(delta.getAffectedChildren());
		}
		return false;
	}
	
	private boolean isAffectingPackageFragmentRoots(IJavaElementDelta[] affectedChildren) {
		for (IJavaElementDelta delta : affectedChildren) {
			if (isAffectingPackageFragmentRoots(delta))
				return true;
		}
		return false;
	}
	
	/**
	 * @since 2.1
	 */
	@Override
	protected boolean isIgnoredResource(IResource resource) {
		return jdtHelper.isFromOutputPath(resource);
	}
	
	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setJdtHelper(IJdtHelper jdtHelper) {
		this.jdtHelper = jdtHelper;
	}
}
