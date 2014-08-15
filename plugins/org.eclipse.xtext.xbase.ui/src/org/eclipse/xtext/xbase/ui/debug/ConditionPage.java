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
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.internal.ui.SWTFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.debug.core.IJavaLineBreakpoint;
import org.eclipse.jdt.debug.core.IJavaStratumLineBreakpoint;
import org.eclipse.jdt.debug.ui.breakpoints.JavaBreakpointConditionEditor;
import org.eclipse.jdt.internal.debug.ui.JDIDebugUIPlugin;
import org.eclipse.jdt.internal.debug.ui.propertypages.JavaBreakpointPage;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.xtext.EcoreUtil2;
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
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

public class ConditionPage extends JavaBreakpointPage {
	
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
	
	private JavaBreakpointConditionEditor editor;

	@Override
	protected Control createContents(Composite parent) {
		noDefaultAndApplyButton();
		Composite mainComposite = SWTFactory.createComposite(parent, parent.getFont(), 1, 1, GridData.FILL_HORIZONTAL, 0, 0);
		createTypeSpecificEditors(mainComposite);
		setValid(true);
		return mainComposite;
	}
	
	@Override
	protected void doStore() throws CoreException {
		if (editor.isDirty()) {
			editor.doSave();
		}
	}
	
	@Override
	protected void createTypeSpecificEditors(Composite parent) {
		try {
			String type = getBreakpoint().getMarker().getType();
			if ("org.eclipse.jdt.debug.javaStratumLineBreakpointMarker".equals(type)) {
				setTitle("Condition");
				editor = new JavaBreakpointConditionEditor();
				editor.createControl(parent);
				editor.addPropertyListener(new IPropertyListener() {
					public void propertyChanged(Object source, int propId) {
						IStatus status = editor.getStatus();
						if (status.isOK()) {
							if (fPrevMessage != null) {
								removeErrorMessage(fPrevMessage);
								fPrevMessage = null;
							}
						} else {
							fPrevMessage = status.getMessage();
							addErrorMessage(fPrevMessage);
						}
					}
				});
				editor.setInput(getBreakpointWithJavaLocation());
			} else {
				super.createTypeSpecificEditors(parent);
			}
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
	}
	
	private IJavaLineBreakpoint getBreakpointWithJavaLocation() {
		final IJavaStratumLineBreakpoint breakpoint = (IJavaStratumLineBreakpoint) getBreakpoint();
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
		IResource storage = breakpoint.getMarker().getResource();
		ResourceSet resourceSet = resourceSetProvider.get(storage.getProject());
		URI uri = storage2UriMapper.getUri((IStorage) storage);
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
		IResource storage = breakpoint.getMarker().getResource();
		ITrace javaTrace = traceForStorageProvider.getTraceToTarget((IStorage) storage);
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
