/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.smap;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.internal.ui.javaeditor.IClassFileEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IStorageEditorInput;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XbaseBreakpointUtil {

	// copied from org.eclipse.jdt.internal.debug.ui.BreakpointUtils.getBreakpointResource(IMember)
	public IResource getBreakpointResource(IMember member) {
		ICompilationUnit cu = member.getCompilationUnit();
		if (cu != null && cu.isWorkingCopy()) {
			member = (IMember) member.getPrimaryElement();
		}
		IResource res = member.getResource();
		if (res == null) {
			res = ResourcesPlugin.getWorkspace().getRoot();
		} else if (!res.getProject().exists()) {
			res = ResourcesPlugin.getWorkspace().getRoot();
		}
		return res;
	}

	public IResource getBreakpointResource(IEditorInput input) throws CoreException {
		Object adapter = input.getAdapter(IResource.class);
		if (adapter != null)
			return (IResource) adapter;
		if (input instanceof IStorageEditorInput) {
			IStorage storage = ((IStorageEditorInput) input).getStorage();
			if (storage instanceof IResource)
				return (IResource) storage;
			if (storage instanceof IJarEntryResource)
				return ((IJarEntryResource) storage).getPackageFragmentRoot().getUnderlyingResource();
		} else if (input instanceof IClassFileEditorInput) {
			IClassFile classFile = ((IClassFileEditorInput) input).getClassFile();
			return getBreakpointResource(classFile.findPrimaryType());
		}
		return ResourcesPlugin.getWorkspace().getRoot();
	}

}
