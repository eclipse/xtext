/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.navigation;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.ui.editor.hyperlinking.SingleHoverShowingHyperlinkPresenter;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XbaseImplementatorsHyperlink implements IHyperlink {

	private IRegion region;
	private IJavaElement element;
	private ITextViewer textViewer;
	private JvmImplementationOpener opener;

	public XbaseImplementatorsHyperlink(IJavaElement element, IRegion region, ITextViewer textViewer, JvmImplementationOpener opener) {
		this.element = element;
		this.region = region;
		this.textViewer = textViewer;
		this.opener = opener;
	}

	@Override
	public IRegion getHyperlinkRegion() {
		return region;
	}

	@Override
	public String getTypeLabel() {
		return SingleHoverShowingHyperlinkPresenter.SHOW_ALWAYS;
	}

	@Override
	public String getHyperlinkText() {
		return "Open Implementation";
	}

	@Override
	public void open() {
		opener.openImplementations(element, textViewer, region);
	}

	public IJavaElement getElement() {
		return element;
	}

}
