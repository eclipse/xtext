/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.smap;

import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.ISourceLocator;
import org.eclipse.debug.core.sourcelookup.ISourceLookupDirector;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.debug.core.IJavaReferenceType;
import org.eclipse.jdt.debug.core.IJavaStackFrame;
import org.eclipse.jdt.debug.core.IJavaType;
import org.eclipse.jdt.internal.debug.core.breakpoints.JavaStratumLineBreakpoint;

public class XbaseLineBreakpoint extends JavaStratumLineBreakpoint {

	private static final String XBASE_BREAKPOINT = "org.eclipse.xtext.xbase.ui.xbaseLineBreakpointMarker";

	public XbaseLineBreakpoint() {
	}
	
	public XbaseLineBreakpoint(IResource breakpointResource, String languageShortName, String typePattern, int line, int charStart, int charEnd, Map<String, Object> attributes) throws DebugException {
		super(breakpointResource, languageShortName, null, null, typePattern, line, charStart, charEnd, 0, true, attributes, XBASE_BREAKPOINT);
	}
	
	@Override
	protected IJavaProject getJavaProject(IJavaStackFrame stackFrame) {
		IJavaProject javaProject = super.getJavaProject(stackFrame);
		if (javaProject == null) {
			javaProject = computeJavaProject(stackFrame);
		}
		return javaProject;
	}
	
	//old working implementation copied from 3.8
	private IJavaProject computeJavaProject(IJavaStackFrame stackFrame) {
		ILaunch launch = stackFrame.getLaunch();
		if (launch == null) {
			return null;
		}
		ISourceLocator locator = launch.getSourceLocator();
		if (locator == null)
			return null;

		Object sourceElement = null;
		try {
			if (locator instanceof ISourceLookupDirector
					&& !stackFrame.isStatic()) {
				IJavaType thisType = stackFrame.getThis().getJavaType();
				if (thisType instanceof IJavaReferenceType) {
					String[] sourcePaths = ((IJavaReferenceType) thisType)
							.getSourcePaths(null);
					if (sourcePaths != null && sourcePaths.length > 0) {
						sourceElement = ((ISourceLookupDirector) locator)
								.getSourceElement(sourcePaths[0]);
					}
				}
			}
		} catch (DebugException e) {
			DebugPlugin.log(e);
		}
		if (sourceElement == null) {
			sourceElement = locator.getSourceElement(stackFrame);
		}
		if (!(sourceElement instanceof IJavaElement)
				&& sourceElement instanceof IAdaptable) {
			Object element = ((IAdaptable) sourceElement)
					.getAdapter(IJavaElement.class);
			if (element != null) {
				sourceElement = element;
			}
		}
		if (sourceElement instanceof IJavaElement) {
			return ((IJavaElement) sourceElement).getJavaProject();
		} else if (sourceElement instanceof IResource) {
			IJavaProject project = JavaCore.create(((IResource) sourceElement)
					.getProject());
			if (project.exists()) {
				return project;
			}
		}
		return null;
	}
}
