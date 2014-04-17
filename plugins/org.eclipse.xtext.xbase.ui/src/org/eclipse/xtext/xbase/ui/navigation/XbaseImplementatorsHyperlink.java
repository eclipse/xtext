/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.navigation;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;

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

	public IRegion getHyperlinkRegion() {
		return region;
	}

	public String getTypeLabel() {
		return null;
	}

	public String getHyperlinkText() {
		return "Open Implementation";
	}

	public void open() {
		opener.openImplementations(element, textViewer, region);
	}



}
