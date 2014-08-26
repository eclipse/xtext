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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.debug.core.IJavaLineBreakpoint;
import org.eclipse.jdt.debug.core.IJavaStratumLineBreakpoint;
import org.eclipse.jdt.internal.debug.ui.JDIDebugUIPlugin;
import org.eclipse.xtext.builder.smap.StratumBreakpointAdapterFactory;
import org.eclipse.xtext.builder.trace.AbstractTrace;
import org.eclipse.xtext.builder.trace.ITraceForTypeRootProvider;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.generator.trace.LineMappingProvider;
import org.eclipse.xtext.generator.trace.LineMappingProvider.LineMapping;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.TextRegion;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class JavaBreakPointProvider {
	@Inject
	private ITraceForStorageProvider traceForStorageProvider;
	@Inject
	private ITraceForTypeRootProvider traceForTypeRootProvider;
	@Inject
	private IStorage2UriMapper storage2UriMapper;
	@Inject
	private LineMappingProvider lineMappingProvider;

	public IJavaLineBreakpoint getBreakpointWithJavaLocation(final IJavaStratumLineBreakpoint breakpoint) {
		final IMarker marker = breakpoint.getMarker();
		final Object markerProxy = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { IMarker.class },
				new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if (method.getName().equals("getAttribute")) {
							if (args[0].equals(IMarker.LINE_NUMBER)) {
								return getJavaLineNumber(breakpoint);
							} else if (args[0].equals(JDIDebugUIPlugin.getUniqueIdentifier()
									+ ".JAVA_ELEMENT_HANDLE_ID")) {
								return getHandleId(breakpoint);
							}
						}
						return method.invoke(marker, args);
					}
				});
		return (IJavaLineBreakpoint) Proxy.newProxyInstance(getClass().getClassLoader(),
				new Class[] { IJavaLineBreakpoint.class }, new InvocationHandler() {
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
		IClassFile classFile = getClassFile(breakpoint);
		if (classFile != null)
			return classFile.getType().getHandleIdentifier();
		ILocationInResource javaLocation = getJavaLocation(breakpoint);
		IStorage javaResource = javaLocation.getStorage();
		if (!(javaResource instanceof IFile)) {
			return null;
		}
		ICompilationUnit compilationUnit = (ICompilationUnit) JavaCore.create((IFile) javaResource);
		IJavaElement element = compilationUnit.getElementAt(javaLocation.getTextRegion().getOffset());
		return element == null ? null : element.getHandleIdentifier();
	}

	private int getJavaLineNumber(final IJavaStratumLineBreakpoint breakpoint) throws CoreException {
		ILocationInResource javaLocation = getJavaLocation(breakpoint);
		if (javaLocation == null)
			return -1;
		IStorage storage = javaLocation.getStorage();
		if (storage == null) {
			ITextRegionWithLineInformation textRegion = javaLocation.getTextRegion();
			if (textRegion == null)
				return -1;
			return textRegion.getEndLineNumber();
		} else {
			AbstractTrace sourceTrace = (AbstractTrace) traceForStorageProvider.getTraceToSource(storage);
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

	private ILocationInResource getJavaLocation(final IJavaStratumLineBreakpoint breakpoint) throws CoreException {
		ITrace javaTrace = getJavaTrace(breakpoint);
		if (javaTrace == null)
			return null;
		TextRegion textRegion = new TextRegion(breakpoint.getCharStart(), 0);
		ILocationInResource javaLocation = javaTrace.getBestAssociatedLocation(textRegion);
		if (javaLocation == null)
			return null;
		return javaLocation;
	}

	private ITrace getJavaTrace(final IJavaStratumLineBreakpoint breakpoint) throws CoreException {
		ITrace javaTrace;
		IClassFile classFile = getClassFile(breakpoint);
		if (classFile == null) {
			URI uri = URI.createURI((String) breakpoint.getMarker().getAttribute(
					StratumBreakpointAdapterFactory.ORG_ECLIPSE_XTEXT_XBASE_SOURCE_URI));
			Pair<IStorage, IProject> storage = Iterables.getFirst(storage2UriMapper.getStorages(uri), null);
			if (storage == null)
				return null;
			javaTrace = traceForStorageProvider.getTraceToTarget(storage.getFirst());
		} else {
			javaTrace = traceForTypeRootProvider.getTraceToSource(classFile);
		}
		return javaTrace;
	}

	private IClassFile getClassFile(IJavaStratumLineBreakpoint breakpoint) throws CoreException {
		String handle = (String) breakpoint.getMarker().getAttribute(StratumBreakpointAdapterFactory.ORG_ECLIPSE_XTEXT_XBASE_CLASS_HANDLE);
		return (IClassFile) JavaCore.create(handle);
	}
}
