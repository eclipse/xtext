/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.smap;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointManager;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTargetExtension;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.debug.core.IJavaStratumLineBreakpoint;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.debug.IStratumBreakpointSupport;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.JarFileMarkerAnnotationModel;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Moritz Eysholdt
 */
public class StratumBreakpointAdapterFactory implements IAdapterFactory, IToggleBreakpointsTargetExtension {

	private final static Logger log = Logger.getLogger(StratumBreakpointAdapterFactory.class);

	private static final String ORG_ECLIPSE_JDT_DEBUG_CORE_SOURCE_NAME = "org.eclipse.jdt.debug.core.sourceName";
	public static final String ORG_ECLIPSE_XTEXT_XBASE_SOURCE_URI = "org.eclipse.xtext.xbase.source.uri";
	public static final String ORG_ECLIPSE_XTEXT_XBASE_CLASS_HANDLE = "org.eclipse.xtext.xbase.class.handle";

	@Inject
	private IResourceServiceProvider.Registry providerRegistry;

	@Inject
	private IStorage2UriMapper uriMapper;

	@Inject
	private XbaseBreakpointUtil breakpointUtil;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		if (adaptableObject instanceof XtextEditor && adapterType == IToggleBreakpointsTarget.class) {
			return (T) this;
		}
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return new Class[] { IToggleBreakpointsTargetExtension.class };
	}

	protected static class Data {
		protected String name;
		protected String types;
		protected boolean valid;
		protected LanguageInfo lang;
		protected URI sourceUri;
		protected String classHandle;
	}

	@Override
	public void toggleBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
		if (!(part instanceof XtextEditor) || !(selection instanceof ITextSelection)) {
			return;
		}
		try {
			final XtextEditor xtextEditor = (XtextEditor) part;
			final IEditorInput editorInput = xtextEditor.getEditorInput();
			final IResource breakpointResource = breakpointUtil.getBreakpointResource(editorInput);
			final SourceRelativeURI breakpointUri = breakpointUtil.getBreakpointURI(editorInput);
			final int offset = ((ITextSelection) selection).getOffset();
			final int line = xtextEditor.getDocument().getLineOfOffset(offset) + 1;
			
			Data data = xtextEditor.getDocument().tryReadOnly(new IUnitOfWork<Data, XtextResource>() {
				@Override
				public Data exec(XtextResource state) throws Exception {
					IResourceServiceProvider provider = state.getResourceServiceProvider();
					IStratumBreakpointSupport breakpointSupport = provider.get(IStratumBreakpointSupport.class);
					Data result = new Data();
					result.name = state.getURI().lastSegment();
					result.valid = breakpointSupport != null && breakpointSupport.isValidLineForBreakPoint(state, line);
					result.types = getClassNamePattern(state);
					result.lang = provider.get(LanguageInfo.class);
					result.sourceUri = state.getURI();
					if (editorInput.getAdapter(IClassFile.class) != null) {
						result.classHandle = editorInput.getAdapter(IClassFile.class).getHandleIdentifier();
					}
					return result;
				}
			});

			if (data == null) return;

			IJavaStratumLineBreakpoint existingBreakpoint = findExistingBreakpoint(breakpointResource, breakpointUri, line);

			if (existingBreakpoint != null) {
				existingBreakpoint.delete();
				return;
			}

			if (!data.valid || data.types == null)
				return;

			if (log.isDebugEnabled()) {
				log.debug("Types the breakpoint listens for : " + data.types);
			}
			final IRegion information = xtextEditor.getDocument().getLineInformation(line - 1);
			final int charStart = information.getOffset();
			final int charEnd = information.getOffset() + information.getLength();

			final String shortName = data.lang.getShortName();

			Map<String, Object> attributes = Maps.newHashMap();
			if (breakpointUri != null)
				attributes.put(JarFileMarkerAnnotationModel.MARKER_URI, breakpointUri.toString());
			attributes.put(ORG_ECLIPSE_JDT_DEBUG_CORE_SOURCE_NAME, data.name);
			attributes.put(ORG_ECLIPSE_XTEXT_XBASE_SOURCE_URI, data.sourceUri.toString());
			if (data.classHandle != null)
				attributes.put(ORG_ECLIPSE_XTEXT_XBASE_CLASS_HANDLE, data.classHandle);

			final IJavaStratumLineBreakpoint breakpoint = new XbaseLineBreakpoint(breakpointResource, shortName, data.types, line, charStart, charEnd, attributes);

			// make sure the class name pattern gets updated on change
			final IMarker marker = breakpoint.getMarker();
			final IWorkspace ws = marker.getResource().getWorkspace();
			IResourceChangeListener listener = new IResourceChangeListener() {
				@Override
				public void resourceChanged(IResourceChangeEvent event) {
					if (!marker.exists())
						ws.removeResourceChangeListener(this);
					IResourceDelta delta = event.getDelta();
					if (delta == null)
						return;
					final IResourceDelta findMember = event.getDelta().findMember(marker.getResource().getFullPath());
					if (findMember == null)
						return;
					IResource res = findMember.getResource();
					if (res == null || !res.exists())
						return;
					if (event.getType() == IResourceChangeEvent.PRE_DELETE) {
						ws.removeResourceChangeListener(this);
					} else if (event.getType() == IResourceChangeEvent.POST_CHANGE
							&& (findMember.getFlags() & IResourceDelta.CONTENT) != 0) {
						String classNamePattern = getClassNamePattern(event.getResource());
						try {
							breakpoint.getMarker().setAttribute("org.eclipse.jdt.debug.pattern", classNamePattern);
						} catch (CoreException e) {
							log.info(e.getMessage(), e);
						}
					}
				}
			};
			ws.addResourceChangeListener(listener, IResourceChangeEvent.POST_CHANGE | IResourceChangeEvent.PRE_DELETE);
		} catch (BadLocationException e) {
			log.info(e.getMessage(), e);
		}
	}

	protected IJavaStratumLineBreakpoint findExistingBreakpoint(IResource res, SourceRelativeURI uri, final int line)
			throws CoreException {
		IBreakpointManager manager = DebugPlugin.getDefault().getBreakpointManager();
		IBreakpoint[] breakpoints = manager.getBreakpoints();
		if (uri == null) {
			for (IBreakpoint breakpoint : breakpoints) {
				IMarker marker = breakpoint.getMarker();
				if (breakpoint instanceof IJavaStratumLineBreakpoint && marker.getResource().equals(res)) {
					final IJavaStratumLineBreakpoint stratumBreakpoint = (IJavaStratumLineBreakpoint) breakpoint;
					if (stratumBreakpoint.getLineNumber() == line) {
						return stratumBreakpoint;
					}
				}
			}
		} else {
			String uriString = uri.toString();
			for (IBreakpoint breakpoint : breakpoints) {
				IMarker marker = breakpoint.getMarker();
				if (breakpoint instanceof IJavaStratumLineBreakpoint && marker.getResource().equals(res)
						&& uriString.equals(marker.getAttribute(JarFileMarkerAnnotationModel.MARKER_URI))) {
					final IJavaStratumLineBreakpoint stratumBreakpoint = (IJavaStratumLineBreakpoint) breakpoint;
					if (stratumBreakpoint.getLineNumber() == line) {
						return stratumBreakpoint;
					}
				}
			}
		}
		return null;
	}

	protected String getClassNamePattern(IResource res) {
		if (!(res instanceof IStorage))
			return null;
		URI uri = uriMapper.getUri((IStorage) res);
		IResourceServiceProvider provider = providerRegistry.getResourceServiceProvider(uri);
		if (provider == null)
			return null;
		IResourceSetProvider resourceSetProvider = provider.get(IResourceSetProvider.class);
		ResourceSet set = resourceSetProvider.get(res.getProject());
		Resource resource = set.getResource(uri, true);
		if (resource instanceof XtextResource) {
			return getClassNamePattern((XtextResource) resource);
		}
		return null;
	}

	protected String getClassNamePattern(XtextResource state) {
		TreeIterator<Object> contents = EcoreUtil.getAllContents(state, false);
		StringBuilder sb = new StringBuilder();
		while (contents.hasNext()) {
			Object next = contents.next();
			if (next instanceof JvmDeclaredType) {
				JvmDeclaredType type = (JvmDeclaredType) next;
				sb.append(type.getQualifiedName()).append("*");
				sb.append(",");
			}
		}
		if (sb.length() == 0)
			return null;
		else
			return sb.substring(0, sb.length() - 1);
	}

	@Override
	public void toggleLineBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
	}

	@Override
	public boolean canToggleLineBreakpoints(IWorkbenchPart part, ISelection selection) {
		return true;
	}

	@Override
	public void toggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
	}

	@Override
	public boolean canToggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) {
		return false;
	}

	@Override
	public void toggleWatchpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
	}

	@Override
	public boolean canToggleWatchpoints(IWorkbenchPart part, ISelection selection) {
		return false;
	}

	@Override
	public boolean canToggleBreakpoints(IWorkbenchPart part, ISelection selection) {
		return true;
	}
}
