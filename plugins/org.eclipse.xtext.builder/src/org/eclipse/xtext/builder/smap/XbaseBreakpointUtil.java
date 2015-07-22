/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.smap;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.internal.ui.javaeditor.IClassFileEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.xtext.common.types.ui.trace.ITraceForTypeRootProvider;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XbaseBreakpointUtil {

	private static final Logger logger = Logger.getLogger(XbaseBreakpointUtil.class);

	@Inject
	private ITraceForTypeRootProvider traceForTypeRootProvider;

	// copied from org.eclipse.jdt.internal.debug.ui.BreakpointUtils.getBreakpointResource(IMember)
	protected IResource getBreakpointResource(IMember member) {
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
			if (storage instanceof IJarEntryResource) {
				IResource underlyingResource = ((IJarEntryResource) storage).getPackageFragmentRoot().getUnderlyingResource();
				if (underlyingResource != null)
					return underlyingResource;
			}
		} else if (input instanceof IClassFileEditorInput) {
			IClassFile classFile = ((IClassFileEditorInput) input).getClassFile();
			return getBreakpointResource(classFile.findPrimaryType());
		}
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	// this URI is only used for breakpoints on JARed files
	public SourceRelativeURI getBreakpointURI(IEditorInput input) {
		Object adapter = input.getAdapter(IResource.class);
		if (adapter != null)
			return null;
		if (input instanceof IStorageEditorInput) {
			IStorage storage;
			try {
				storage = ((IStorageEditorInput) input).getStorage();
				if (storage instanceof IResource)
					return null;
				if (storage instanceof IJarEntryResource) {
					IJarEntryResource jarEntryResource = (IJarEntryResource) storage;
					if (!jarEntryResource.getPackageFragmentRoot().isArchive())
						return null;
					Object parent = jarEntryResource.getParent();
					if (parent instanceof IPackageFragment) {
						String path = ((IPackageFragment) parent).getElementName().replace('.', '/');
						return new SourceRelativeURI(path + "/" + storage.getName());
					} else if (parent instanceof IPackageFragmentRoot) {
						return new SourceRelativeURI(storage.getName());
					}
				}
			} catch (CoreException e) {
				logger.error("Error finding breakpoint URI", e);
				return null;
			}
		} else if (input instanceof IClassFileEditorInput) {
			IClassFile classFile = ((IClassFileEditorInput) input).getClassFile();
			if (classFile == null) {
				return null;
			}
			ITrace traceToSource = traceForTypeRootProvider.getTraceToSource(classFile);
			if (traceToSource == null)
				return null;
			for (ILocationInResource loc : traceToSource.getAllAssociatedLocations())
				return loc.getSrcRelativeResourceURI();
			return null;
		}
		return null;
	}

}
