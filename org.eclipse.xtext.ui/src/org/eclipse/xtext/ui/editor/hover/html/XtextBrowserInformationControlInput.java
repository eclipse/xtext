/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
 * @since 2.3
 */

// Clone from JavadocBrowserInformationControlInput. Following changes have been made:
// - Changed type of fElement from IJavaElement to EObject.
// - Removed fLeadingImageWidth, leading images are not yet supported by the XtextHtmlHover
// - getInputName requires an labelProvider to retrieve the EObjects name. 

public class XtextBrowserInformationControlInput extends BrowserInformationControlInput {

	private final EObject fElement;
	private final String fHtml;
	private final ILabelProvider fLabelProvider;

	/**
	 * Creates a new browser information control input.
	 * 
	 * @param previous
	 *            previous input, or <code>null</code> if none available
	 * @param element
	 *            the element, or <code>null</code> if none available
	 * @param html
	 *            HTML contents, must not be null
	 * @param labelProvider
	 *            used to determinate the input name {@link #getInputName()}.
	 */
	public XtextBrowserInformationControlInput(XtextBrowserInformationControlInput previous, EObject element,
			String html, ILabelProvider labelProvider) {
		super(previous);
		Assert.isNotNull(html);
		fElement = element;
		fHtml = html;
		fLabelProvider = labelProvider;
	}

	/**
	 * @since 2.3
	 */
	@Override
	public int getLeadingImageWidth() {
		return 16;
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
		return fElement;
	}

	@Override
	public String getInputName() {
		if (fLabelProvider == null)
			return "no label provider";
		return fLabelProvider.getText(fElement);
	}

}
