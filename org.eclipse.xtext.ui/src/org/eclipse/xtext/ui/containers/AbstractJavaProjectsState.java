/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.ui.util.JavaProjectClasspathChangeAnalyzer;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractJavaProjectsState extends AbstractAllContainersState implements IElementChangedListener {

	@Inject
	private IJdtHelper jdtHelper;
	
	@Inject
	private JavaProjectClasspathChangeAnalyzer javaProjectClasspathChangeAnalyzer;
	
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

	@Override
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
			if (javaProjectClasspathChangeAnalyzer.isRelevantPackageFragmentRootChange(delta)) {
				return true;
			}
		} else if (element instanceof IJavaModel) {
			return isAffectingPackageFragmentRoots(delta.getAffectedChildren());
		} else if (element instanceof IJavaProject) {
			if (javaProjectClasspathChangeAnalyzer.isClasspathChangeOnProject(delta)) {
				// filter out IJavaElementDelta.F_SOURCEATTACHED | IJavaElementDelta.F_SOURCEDETACHED only
				if (javaProjectClasspathChangeAnalyzer.isAttachmentChangeOnly(delta)) {
					return  false;
				}
				return true;
			}
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

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setJavaProjectClasspathChangeAnalyzer(JavaProjectClasspathChangeAnalyzer javaProjectClasspathChangeAnalyzer) {
		this.javaProjectClasspathChangeAnalyzer = javaProjectClasspathChangeAnalyzer;
	}

}
