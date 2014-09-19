/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import static org.eclipse.core.resources.IResource.*;
import static org.eclipse.ui.IWorkbenchPage.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.internal.ui.javaeditor.IClassFileEditorInput;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.builder.DerivedResourceMarkers;
import org.eclipse.xtext.builder.trace.ITraceForTypeRootProvider;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.ui.generator.trace.AbstractOpenOppositeFileHandler;
import org.eclipse.xtext.ui.generator.trace.StorageWithRegion;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class OpenSourceFileHandler extends AbstractOpenOppositeFileHandler {

	private final static Logger LOG = Logger.getLogger(OpenSourceFileHandler.class);

	@Inject
	private IStorage2UriMapper storage2UriMapper;

	@Inject
	private ITraceForStorageProvider traceForStorageProvider;

	@Inject
	private ITraceForTypeRootProvider traceForTypeRootProvider;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if (editor.getEditorInput() instanceof IClassFileEditorInput) {
			try {
				IClassFile classFile = ((IClassFileEditorInput) editor.getEditorInput()).getClassFile();
				ITrace trace = traceForTypeRootProvider.getTraceToSource(classFile);
				for (ILocationInResource location : trace.getAllAssociatedLocations()) {
					String name = location.getAbsoluteResourceURI().trimFragment().lastSegment();
					IEditorDescriptor editorDescriptor = IDE.getEditorDescriptor(name);
					IWorkbenchPage page = editor.getEditorSite().getPage();
					page.openEditor(editor.getEditorInput(), editorDescriptor.getId(), true, MATCH_ID | MATCH_INPUT);
					return null;
				}
				return null;
			} catch (PartInitException e) {
				LOG.error(e.getMessage(), e);
				return null;
			}
		}
		return super.execute(event);
	}

	@Override
	protected Collection<StorageWithRegion> findDestinations(IEditorPart editor) {
		IStorage storage = getStorage(editor);
		ITextRegion region = getSelectedRegion(editor);
		if (storage != null) {
			ITrace trace = traceForStorageProvider.getTraceToSource(storage);
			if (((ITrace.Internal) trace).getRootTraceRegion() != null)
				return findDestinationsUsingTrace(trace, region);
			if (storage instanceof IResource) {
				return findDestinationsUsingDerivedResourceMarkers((IResource) storage);
			}
		}
		//		else if (editor.getEditorInput() instanceof IClassFileEditorInput) {
		//			IClassFile classFile = ((IClassFileEditorInput) editor.getEditorInput()).getClassFile();
		//			ITrace trace = traceForTypeRootProvider.getTraceToSource(classFile);
		//			if (((ITrace.Internal) trace).getRootTraceRegion() != null)
		//				return findDestinationsUsingTrace(trace, region);
		//		}
		return Collections.emptyList();
	}

	protected Collection<StorageWithRegion> findDestinationsUsingDerivedResourceMarkers(IResource resource) {
		try {
			Set<URI> uris = Sets.newHashSet();
			IMarker[] markers = resource.findMarkers(DerivedResourceMarkers.MARKER_ID, true, DEPTH_ZERO);
			for (IMarker marker : markers) {
				Object source = marker.getAttribute(DerivedResourceMarkers.MARKER_ID);
				if (source instanceof String)
					uris.add(URI.createURI(((String) source)));
			}
			List<StorageWithRegion> result = Lists.newArrayList();
			for (URI uri : uris)
				for (Pair<IStorage, IProject> destination : storage2UriMapper.getStorages(uri))
					result.add(new StorageWithRegion(destination.getFirst()));
			return result;
		} catch (CoreException e) {
			LOG.error(e.getMessage(), e);
			return Collections.emptyList();
		}
	}

	public IStorage2UriMapper getStorage2UriMapper() {
		return storage2UriMapper;
	}

	public ITraceForStorageProvider getTraceForStorageProvider() {
		return traceForStorageProvider;
	}

}
