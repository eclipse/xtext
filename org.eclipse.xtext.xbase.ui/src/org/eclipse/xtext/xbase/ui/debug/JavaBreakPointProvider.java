/*******************************************************************************
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.jdt.core.IOrdinaryClassFile;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.debug.core.IJavaLineBreakpoint;
import org.eclipse.jdt.debug.core.IJavaStratumLineBreakpoint;
import org.eclipse.xtext.builder.smap.StratumBreakpointAdapterFactory;
import org.eclipse.xtext.common.types.ui.trace.ITraceForTypeRootProvider;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.LineMappingProvider;
import org.eclipse.xtext.generator.trace.LineMappingProvider.LineMapping;
import org.eclipse.xtext.ui.generator.trace.AbstractEclipseTrace;
import org.eclipse.xtext.ui.generator.trace.IEclipseTrace;
import org.eclipse.xtext.ui.generator.trace.ILocationInEclipseResource;
import org.eclipse.xtext.ui.generator.trace.ITraceForStorageProvider;
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
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if (method.getName().equals("getAttribute")) {
							if (args[0].equals(IMarker.LINE_NUMBER)) {
								return getJavaLineNumber(breakpoint);
							} else {
								@SuppressWarnings("restriction")
								String elementHandleID = org.eclipse.jdt.internal.debug.ui.JDIDebugUIPlugin.getUniqueIdentifier() 	+ ".JAVA_ELEMENT_HANDLE_ID";
								if (args[0].equals(elementHandleID)) {
									return getHandleId(breakpoint);
								}
							}
						}
						return method.invoke(marker, args);
					}
				});
		return (IJavaLineBreakpoint) Proxy.newProxyInstance(getClass().getClassLoader(),
				new Class[] { IJavaLineBreakpoint.class }, new InvocationHandler() {
					@Override
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
		if (classFile != null && classFile instanceof IOrdinaryClassFile)
			return ((IOrdinaryClassFile)classFile).getType().getHandleIdentifier();
		ILocationInEclipseResource javaLocation = getJavaLocation(breakpoint);
		if (javaLocation == null)
			return null;
		IStorage javaResource = javaLocation.getPlatformResource();
		if (!(javaResource instanceof IFile))
			return null;
		ICompilationUnit compilationUnit = (ICompilationUnit) JavaCore.create((IFile) javaResource);
		IJavaElement element = compilationUnit.getElementAt(javaLocation.getTextRegion().getOffset());
		return element == null ? null : element.getHandleIdentifier();
	}

	private int getJavaLineNumber(final IJavaStratumLineBreakpoint breakpoint) throws CoreException {
		ILocationInEclipseResource javaLocation = getJavaLocation(breakpoint);
		if (javaLocation == null)
			return -1;
		IStorage storage = javaLocation.getPlatformResource();
		if (storage == null) {
			ITextRegionWithLineInformation textRegion = javaLocation.getTextRegion();
			if (textRegion == null)
				return -1;
			return textRegion.getEndLineNumber();
		} else {
			AbstractEclipseTrace sourceTrace = (AbstractEclipseTrace) traceForStorageProvider.getTraceToSource(storage);
			if (sourceTrace == null)
				return -1;
			AbstractTraceRegion rootTraceRegion = sourceTrace.getRootTraceRegion();
			if (rootTraceRegion == null)
				return -1;
			List<LineMapping> lineMappings = lineMappingProvider.getLineMapping(rootTraceRegion);
			if (lineMappings == null) {
				return -1;
			}
			for (LineMapping lineMapping : lineMappings) {
				if (lineMapping.sourceStartLine == breakpoint.getLineNumber()) {
					return lineMapping.targetEndLine + 1;
				}
			}
			return -1;
		}
	}

	private ILocationInEclipseResource getJavaLocation(final IJavaStratumLineBreakpoint breakpoint) throws CoreException {
		IEclipseTrace javaTrace = getJavaTrace(breakpoint);
		if (javaTrace == null)
			return null;
		TextRegion textRegion = new TextRegion(breakpoint.getCharStart(), 0);
		ILocationInEclipseResource javaLocation = javaTrace.getBestAssociatedLocation(textRegion);
		if (javaLocation == null)
			return null;
		return javaLocation;
	}

	private IEclipseTrace getJavaTrace(final IJavaStratumLineBreakpoint breakpoint) throws CoreException {
		IEclipseTrace result;
		IClassFile classFile = getClassFile(breakpoint);
		if (classFile == null) {
			URI uri = URI.createURI((String) breakpoint.getMarker().getAttribute(
					StratumBreakpointAdapterFactory.ORG_ECLIPSE_XTEXT_XBASE_SOURCE_URI));
			Pair<IStorage, IProject> storage = Iterables.getFirst(storage2UriMapper.getStorages(uri), null);
			if (storage == null)
				return null;
			result = traceForStorageProvider.getTraceToTarget(storage.getFirst());
		} else {
			result = traceForTypeRootProvider.getTraceToSource(classFile);
		}
		return result;
	}

	private IClassFile getClassFile(IJavaStratumLineBreakpoint breakpoint) throws CoreException {
		String handle = (String) breakpoint.getMarker().getAttribute(StratumBreakpointAdapterFactory.ORG_ECLIPSE_XTEXT_XBASE_CLASS_HANDLE);
		return (IClassFile) JavaCore.create(handle);
	}
}
