/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.debug;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.debug.core.IJavaLineBreakpoint;
import org.eclipse.jdt.debug.core.IJavaStratumLineBreakpoint;
import org.eclipse.jdt.internal.debug.ui.JDIDebugUIPlugin;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.smap.StratumBreakpointAdapterFactory;
import org.eclipse.xtext.builder.trace.AbstractTrace;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.generator.trace.LineMappingProvider;
import org.eclipse.xtext.generator.trace.LineMappingProvider.LineMapping;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class JavaBreakPointProvider {
	@Inject
	private IResourceSetProvider resourceSetProvider;
	@Inject
	private IJavaElementFinder javaElementFinder;
	@Inject 
	private ITraceForStorageProvider traceForStorageProvider;
	@Inject
	private IJvmModelAssociations jvmModelAssociations;
	@Inject
	private IStorage2UriMapper storage2UriMapper;
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	@Inject
	private LineMappingProvider lineMappingProvider;
	
	public IJavaLineBreakpoint getBreakpointWithJavaLocation(final IJavaStratumLineBreakpoint breakpoint) {
		final IMarker marker = breakpoint.getMarker();
		final Object markerProxy = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{IMarker.class}, new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if (method.getName().equals("getAttribute")) {
					if (args[0].equals(IMarker.LINE_NUMBER)) {
						return getJavaLineNumber(breakpoint);
					} else if (args[0].equals(JDIDebugUIPlugin.getUniqueIdentifier() + ".JAVA_ELEMENT_HANDLE_ID")) {
						return getHandleId(breakpoint);
					}
				}
				return method.invoke(marker, args);
			}
		});
		return (IJavaLineBreakpoint) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{IJavaLineBreakpoint.class}, new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if (method.getName().equals("getMarker")) { 
					return markerProxy;
				} else {
					return method.invoke(breakpoint, args);
				}
			}
		});
	}

	private String getHandleId(final IJavaStratumLineBreakpoint breakpoint) throws CoreException {
		IMarker marker = breakpoint.getMarker();
		IResource storage = marker.getResource();
		ResourceSet resourceSet = resourceSetProvider.get(storage.getProject());
		URI uri = URI.createURI((String) marker.getAttribute(StratumBreakpointAdapterFactory.ORG_ECLIPSE_XTEXT_XBASE_SOURCE_URI));
		Resource resource = resourceSet.getResource(uri, true);
		resource.getContents();
		EObject sourceObject = eObjectAtOffsetHelper.resolveContainedElementAt((XtextResource) resource, breakpoint.getCharStart());
		EObject primaryJvmElement = null;
		while (primaryJvmElement == null && sourceObject != null) {
			primaryJvmElement = jvmModelAssociations.getPrimaryJvmElement(sourceObject);
			sourceObject = sourceObject.eContainer();
		}
		JvmType jvmType = EcoreUtil2.getContainerOfType(primaryJvmElement, JvmType.class);
		IJavaElement javaElement = javaElementFinder.findElementFor(jvmType);
		return javaElement == null? null : javaElement.getHandleIdentifier();
	}
	
	private int getJavaLineNumber(final IJavaStratumLineBreakpoint breakpoint) throws CoreException {
		URI uri = URI.createURI((String) breakpoint.getMarker().getAttribute(StratumBreakpointAdapterFactory.ORG_ECLIPSE_XTEXT_XBASE_SOURCE_URI));
		Pair<IStorage, IProject> storage = Iterables.getFirst(storage2UriMapper.getStorages(uri), null);
		if (storage == null)
			return -1;
		ITrace javaTrace = traceForStorageProvider.getTraceToTarget(storage.getFirst());
		if (javaTrace == null)
			return -1;
		TextRegion textRegion = new TextRegion(breakpoint.getCharStart(), 0);
		ILocationInResource javaLocation = javaTrace.getBestAssociatedLocation(textRegion);
		if (javaLocation == null)
			return -1;
		AbstractTrace sourceTrace = (AbstractTrace) traceForStorageProvider.getTraceToSource(javaLocation.getStorage());
		if (sourceTrace == null)
			return -1;
		AbstractTraceRegion rootTraceRegion = sourceTrace.getRootTraceRegion();
		if (rootTraceRegion == null)
			return -1;
		List<LineMapping> lineMappings = lineMappingProvider.getLineMapping(rootTraceRegion);
		for (LineMapping lineMapping : lineMappings) {
			if (lineMapping.sourceStartLine == breakpoint.getLineNumber()) {
				return lineMapping.targetEndLine + 1;
			}
		}
		return -1;
	}
}
