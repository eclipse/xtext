/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.css.ui.rendering;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
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
	private IWorkspace workspace;
	
	public StyleSheet getStyleSheet(URI uri) {
		XtextResourceSet resourceSet = resourceSetProvider.get();
		if (uri.isPlatformResource()) {
			String platformString = uri.toPlatformString(true);
			IResource resource = workspace.getRoot().findMember(platformString);
			IProject project = resource.getProject();
			IJavaProject javaProject = JavaCore.create(project);
			if (javaProject != null) {
				resourceSet.setClasspathURIContext(javaProject);
			}
		}
		Resource result = resourceSet.getResource(uri, true);
		List<Issue> issues = resourceValidator.validate(result, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
		if (issues.isEmpty() && !result.getContents().isEmpty())
			return (StyleSheet) result.getContents().get(0);
		return null;
	}
	
	int colorKey = 0;

	public void applyStyles(Display display, StyleSheet styleSheet, Widget widget, boolean recurse) {
		if (recurse && widget instanceof Composite) {
			Control[] children = ((Composite) widget).getChildren();
			for(Control child: children) {
				applyStyles(display, styleSheet, child, recurse);
			}
		}
		if (widget instanceof Text) {
			Text text = (Text) widget;
			switch(colorKey) {
				case 0: text.setBackground(display.getSystemColor(SWT.COLOR_RED)); break;
				case 1: text.setBackground(display.getSystemColor(SWT.COLOR_BLUE)); break;
				case 2: text.setBackground(display.getSystemColor(SWT.COLOR_YELLOW)); break;
			}
			colorKey = (colorKey+1) % 3;
		}
		if (widget instanceof StyledText) {
			StyledText text = (StyledText) widget;
			switch(colorKey) {
				case 0: text.setSelectionBackground(display.getSystemColor(SWT.COLOR_RED)); break;
				case 1: text.setSelectionBackground(display.getSystemColor(SWT.COLOR_BLUE)); break;
				case 2: text.setSelectionBackground(display.getSystemColor(SWT.COLOR_YELLOW)); break;
			}
			colorKey = (colorKey+1) % 3;
		}
	}

}
