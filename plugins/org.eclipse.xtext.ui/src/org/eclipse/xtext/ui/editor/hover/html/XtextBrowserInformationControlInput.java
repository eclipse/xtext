/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover.html;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.jface.internal.text.html.BrowserInformationControlInput;
import org.eclipse.jface.viewers.ILabelProvider;

/**
 * Browser input for XtextHtmlHover.
 *
 * @since 3.4
 */

// Clone from JavadocBrowserInformationControlInput. Following changes have been made:
// - Changed type of fElement from IJavaElement to EObject.
// - Removed fLeadingImageWidth, leading images are not yet supported by the XtextHtmlHover
// - getInputName requires an labelProvider to retrieve the EObjects name. 

@SuppressWarnings("restriction")
public class XtextBrowserInformationControlInput extends BrowserInformationControlInput {

	private final EObject fElement;
	private final String fHtml;
	private final ILabelProvider fLabelProvider;
	
	/**
	 * Creates a new browser information control input.
	 *
	 * @param previous previous input, or <code>null</code> if none available
	 * @param element the element, or <code>null</code> if none available
	 * @param html HTML contents, must not be null
	 * @param leadingImageWidth the indent required for the element image
	 */
	public XtextBrowserInformationControlInput(XtextBrowserInformationControlInput previous, EObject element, String html, ILabelProvider labelProvider) {
		super(previous);
		Assert.isNotNull(html);
		fElement= element;
		fHtml= html;
		fLabelProvider = labelProvider;
	}

	public EObject getElement() {
		return fElement;
	}

	@Override
	public String getHtml() {
		return fHtml;
	}

	@Override
	public Object getInputElement() {
		return fElement == null ? fHtml : fElement;
	}

	@Override
	public String getInputName() {
		return fLabelProvider.getText(fElement);
	}

}
