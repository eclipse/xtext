/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class XtendInformationControlInput extends XtextBrowserInformationControlInput {
	
	private String unsugaredExpression = "";
	private String prefix;
	private String suffix;
	private IJavaElement javaElement;

	public XtendInformationControlInput(XtextBrowserInformationControlInput previous, EObject element, String html,
			ILabelProvider labelProvider, String prefix, String unsugaredExpression, String suffix) {
		super(previous, element, html, labelProvider);
		this.prefix = prefix;
		this.unsugaredExpression = unsugaredExpression;
		this.suffix = suffix;
	}
	
	public XtendInformationControlInput(XtextBrowserInformationControlInput previous, EObject element, IJavaElement javaElement, String html,
			ILabelProvider labelProvider, String prefix, String unsugaredExpression, String suffix) {
		super(previous, element, html, labelProvider);
		this.prefix = prefix;
		this.unsugaredExpression = unsugaredExpression;
		this.suffix = suffix;
		this.javaElement = javaElement;
	}

	public String getPrefix(){
		return prefix;
	}
	
	public String getUnsugaredExpression() {
		return unsugaredExpression;
	}
	
	public String getSuffix(){
		return suffix;
	}

	@Override
	public IJavaElement getInputElement() {
		return  javaElement;
	}
	
	
	
}
