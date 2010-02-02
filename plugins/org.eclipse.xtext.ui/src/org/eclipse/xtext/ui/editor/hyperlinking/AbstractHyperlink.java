/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hyperlinking;

import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractHyperlink implements IHyperlink {

	private String hyperlinkText;
	private String typeLabel;
	private Region hyperlinkRegion;

	public String getHyperlinkText() {
		return hyperlinkText;
	}

	public void setHyperlinkText(String hyperlinkText) {
		this.hyperlinkText = hyperlinkText;
	}

	public String getTypeLabel() {
		return typeLabel;
	}

	public void setTypeLabel(String typeLabel) {
		this.typeLabel = typeLabel;
	}

	public Region getHyperlinkRegion() {
		return hyperlinkRegion;
	}

	public void setHyperlinkRegion(Region hyperlinkRegion) {
		this.hyperlinkRegion = hyperlinkRegion;
	}

}
