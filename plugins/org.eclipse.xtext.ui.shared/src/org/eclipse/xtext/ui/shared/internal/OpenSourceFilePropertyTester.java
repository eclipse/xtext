/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import static org.eclipse.core.resources.IResource.*;

import org.apache.log4j.Logger;
import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.internal.ui.javaeditor.IClassFileEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.xtext.builder.DerivedResourceMarkers;
import org.eclipse.xtext.builder.trace.ITraceForTypeRootProvider;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class OpenSourceFilePropertyTester extends PropertyTester {

	private final static Logger LOG = Logger.getLogger(OpenSourceFilePropertyTester.class);

	@Inject
	private ITraceForStorageProvider traceForStorageProvider;

	@Inject
	private ITraceForTypeRootProvider traceForTypeRootProvider;

	protected boolean canOpenSourceFile(IEditorPart editorPart) {
		IEditorInput editorInput = editorPart.getEditorInput();
		try {
			if (editorInput instanceof IStorageEditorInput) {
				IStorage storage = ((IStorageEditorInput) editorInput).getStorage();
				if (storage instanceof IResource)
					return canOpenSourceFile((IResource) storage);
				return canOpenSourceFile(storage);
			} else if (editorInput instanceof IClassFileEditorInput) {
				if (editorPart instanceof XtextEditor)
					return false;
				IClassFile classFile = ((IClassFileEditorInput) editorInput).getClassFile();
				return canOpenSourceFile(classFile);
			}
		} catch (CoreException e) {
			LOG.error(e.getMessage(), e);
			return false;
		}
		return false;
	}

	private boolean canOpenSourceFile(IClassFile classFile) {
		ITrace trace = traceForTypeRootProvider.getTraceToSource(classFile);
		return trace != null && ((ITrace.Internal) trace).getRootTraceRegion() != null;
	}

	// for resources from the workspace we can assume there is a resource marker.
	protected boolean canOpenSourceFile(IResource storage) {
		IResource resource = storage;
		if (resource.isAccessible()) {
			try {
				IMarker[] markers = resource.findMarkers(DerivedResourceMarkers.MARKER_ID, true, DEPTH_ZERO);
				return markers.length > 0;
			} catch (CoreException e) {
				LOG.error(e.getMessage(), e);
				return false;
			}
		}
		return false;
	}

	// for other resources, e.g. from JARs, we need to check if there is a trace file.
	protected boolean canOpenSourceFile(IStorage storage) {
		ITrace trace = traceForStorageProvider.getTraceToSource(storage);
		return trace != null && ((ITrace.Internal) trace).getRootTraceRegion() != null;
	}

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof IEditorPart) {
			if ("canOpenSourceFile".equals(property))
				return canOpenSourceFile((IEditorPart) receiver);
		}
		return false;
	}

}
