/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class XbaseInformationControlInput extends XtextBrowserInformationControlInput {
	
	
	protected IJavaElement javaElement;
	protected ILabelProvider labelProvider;
	protected String unsugaredExpression = "";
	protected String prefix;
	protected String suffix;
	
	public XbaseInformationControlInput(XtextBrowserInformationControlInput previous, EObject element, IJavaElement javaElement, String html,
			ILabelProvider labelProvider) {
		super(previous, element, html, labelProvider);
		this.javaElement = javaElement;
	}
	
	public XbaseInformationControlInput(XtextBrowserInformationControlInput previous, XbaseInformationControlInput wrapped, String prefix, String unsugaredExpression, String suffix) {
		super(previous, wrapped.getElement(), wrapped.getHtml(), wrapped.getLabelProvider());
		this.javaElement = wrapped.getInputElement();
		this.prefix = prefix;
		this.unsugaredExpression = unsugaredExpression;
		this.suffix = suffix;
	}
	
	@Override
	public int getLeadingImageWidth() {
		return 16;
	}

	@Override
	public IJavaElement getInputElement() {
		return  javaElement;
	}

	public ILabelProvider getLabelProvider() {
		return labelProvider;
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
}
