/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.css.rendering;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xtext.example.css.xcss.StyleSheet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow
 */
public class XcssRendererHelper {

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;
	
	@Inject
	private IResourceValidator resourceValidator;
	
	@Inject
	private Provider<XcssInterpreter> interpreterProvider;
	
	public XcssRendererHelper() {
	}
	
	public XcssRendererHelper(Provider<XtextResourceSet> resourceSetProvider, IResourceValidator resourceValidator, Provider<XcssInterpreter> interpreterProvider) {
		this.resourceSetProvider = resourceSetProvider;
		this.resourceValidator = resourceValidator;
		this.interpreterProvider = interpreterProvider;
	}
	
	public XtextResourceSet createResourceSet() {
		XtextResourceSet resourceSet = resourceSetProvider.get();
		return resourceSet;
	}
	
	public StyleSheet getStyleSheet(URI uri) {
		XtextResourceSet resourceSet = createResourceSet();
		resourceSet.setClasspathURIContext(getClass().getClassLoader());
		Resource result = resourceSet.getResource(uri, true);
		return getValidStyleSheet(result);
	}

	public StyleSheet getValidStyleSheet(Resource resource) {
		List<Issue> issues = resourceValidator.validate(resource, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
		if (issues.isEmpty() && !resource.getContents().isEmpty())
			return (StyleSheet) resource.getContents().get(0);
		return null;
	}
	
	int colorKey = 0;

	public void applyStyles(Display display, StyleSheet styleSheet, Widget widget, boolean recurse) {
		XcssInterpreter interpreter = interpreterProvider.get();
		interpreter.setDisplay(display);
		applyStyles(interpreter, styleSheet, widget, recurse);
	}
	
	protected void applyStyles(XcssInterpreter interpreter, StyleSheet styleSheet, Widget widget, boolean recurse) {
		StyleAwareImpl.discard(widget);
		interpreter.evaluate(styleSheet, widget);
		if (recurse && widget instanceof Composite) {
			Control[] children = ((Composite) widget).getChildren();
			for(Control child: children) {
				applyStyles(interpreter, styleSheet, child, recurse);
			}
		}
	}

}
