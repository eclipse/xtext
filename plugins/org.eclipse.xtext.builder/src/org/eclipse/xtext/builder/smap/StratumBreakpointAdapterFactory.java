/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.smap;

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
import org.eclipse.debug.ui.actions.IToggleBreakpointsTargetExtension;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.debug.core.IJavaStratumLineBreakpoint;
import org.eclipse.jdt.debug.core.JDIDebugModel;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.debug.IStratumBreakpointSupport;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class StratumBreakpointAdapterFactory implements IAdapterFactory, IToggleBreakpointsTargetExtension {

	private final static Logger log = Logger.getLogger(StratumBreakpointAdapterFactory.class);
	private @Inject IResourceServiceProvider.Registry providerRegistry;
	private @Inject IStorage2UriMapper uriMapper;

	@SuppressWarnings({ "rawtypes"}) 
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof XtextEditor) {
			return this;
		}
		return null;
	}

	public Class<?>[] getAdapterList() {
		return new Class[] { IToggleBreakpointsTargetExtension.class };
	}

	public void toggleBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
		if (!(part instanceof XtextEditor) || !(selection instanceof ITextSelection)) {
			return;
		}
		try {
			final XtextEditor xtextEditor = (XtextEditor) part;
			final IResource res = xtextEditor.getResource();
			final int offset = ((TextSelection) selection).getOffset();
			final int line = xtextEditor.getDocument().getLineOfOffset(offset) + 1;

			IJavaStratumLineBreakpoint existingBreakpoint = findExistingBreakpoint(res, line);
			if (existingBreakpoint != null) {
				existingBreakpoint.delete();
				return;
			}
			
			URI uri = uriMapper.getUri((IStorage)res);
			final IResourceServiceProvider serviceProvider = providerRegistry.getResourceServiceProvider(uri);
			if (serviceProvider == null)
				return;
			final IStratumBreakpointSupport breakpointSupport = serviceProvider.get(IStratumBreakpointSupport.class);
			if (breakpointSupport == null)
				return;
			// check whether it's a sensible line for a breakpoint
			boolean isBreakpointLocation = xtextEditor.getDocument().readOnly(new IUnitOfWork<Boolean, XtextResource>(){
				public Boolean exec(XtextResource state) throws Exception {
					return breakpointSupport.isValidLineForBreakPoint(state, line);
				}
			});
			if (!isBreakpointLocation)
				return;
			
			String types = xtextEditor.getDocument().readOnly(new IUnitOfWork<String, XtextResource>(){
				public String exec(XtextResource state) throws Exception {
					return getClassNamePattern(state);
				}
			});
			if (types == null)
				return;
			if (log.isDebugEnabled()) {
				log.debug("Types the breakpoint listens for : "+types);
			}
			final IRegion information = xtextEditor.getDocument().getLineInformation(line-1);
			final int charStart = information.getOffset();
			final int charEnd = information.getOffset() + information.getLength();

			final String shortName = serviceProvider.get(LanguageInfo.class).getShortName();
			final IJavaStratumLineBreakpoint breakpoint = JDIDebugModel.createStratumBreakpoint(res, shortName, null, null, types, line, charStart, charEnd, 0, true, null);
			
			// make sure the class name pattern gets updated on change
			final IMarker marker = breakpoint.getMarker();
			final IWorkspace ws = marker.getResource().getWorkspace();
			IResourceChangeListener listener = new IResourceChangeListener() {
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
							&& (findMember.getFlags() & IResourceDelta.CONTENT ) != 0) {
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
			log.info(e.getMessage(),e);
		}
	}

	protected IJavaStratumLineBreakpoint findExistingBreakpoint(IResource res, final int line) throws CoreException {
		IBreakpointManager manager = DebugPlugin.getDefault().getBreakpointManager();
		IBreakpoint[] breakpoints = manager.getBreakpoints();
		for (IBreakpoint breakpoint : breakpoints) {
			if (breakpoint instanceof IJavaStratumLineBreakpoint 
				&& breakpoint.getMarker().getResource().equals(res)) {
				final IJavaStratumLineBreakpoint stratumBreakpoint = (IJavaStratumLineBreakpoint) breakpoint;
				if (stratumBreakpoint.getLineNumber() == line) {
					return stratumBreakpoint;
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
		IResourceSetProvider resourceSetProvider = provider.get(IResourceSetProvider.class);
		ResourceSet set = resourceSetProvider.get(res.getProject());
		Resource resource = set.getResource(uri, true);
		if (resource instanceof XtextResource) {
			return getClassNamePattern((XtextResource)resource);
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
			return sb.substring(0, sb.length()-1);
	}
	
	public void toggleLineBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
	}

	public boolean canToggleLineBreakpoints(IWorkbenchPart part, ISelection selection) {
		return true;
	}

	public void toggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
	}

	public boolean canToggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) {
		return false;
	}

	public void toggleWatchpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
	}

	public boolean canToggleWatchpoints(IWorkbenchPart part, ISelection selection) {
		return false;
	}

	public boolean canToggleBreakpoints(IWorkbenchPart part, ISelection selection) {
		return true;
	}
}
