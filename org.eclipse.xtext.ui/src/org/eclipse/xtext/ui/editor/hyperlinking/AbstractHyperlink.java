/*******************************************************************************
 * Copyright (c) 2009, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hyperlinking;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractHyperlink implements IHyperlink {

	private String hyperlinkText;
	private String typeLabel;
	private IRegion hyperlinkRegion;

	@Override
	public String getHyperlinkText() {
		return hyperlinkText;
	}

	public void setHyperlinkText(String hyperlinkText) {
		this.hyperlinkText = hyperlinkText;
	}

	@Override
	public String getTypeLabel() {
		return typeLabel;
	}

	public void setTypeLabel(String typeLabel) {
		this.typeLabel = typeLabel;
	}

	@Override
	public IRegion getHyperlinkRegion() {
		return hyperlinkRegion;
	}

	/**
	 * since 2.18
	 */
	public void setHyperlinkRegion(IRegion hyperlinkRegion) {
		if (hyperlinkRegion instanceof Region) {
			setHyperlinkRegion((Region)hyperlinkRegion);
		} else {
			this.hyperlinkRegion = hyperlinkRegion;
		}
	}

	/**
	 * @deprecated use {@link #setHyperlinkRegion(IRegion)} instead.
	 */
	@Deprecated(forRemoval = true)
	public void setHyperlinkRegion(Region hyperlinkRegion) {
		this.hyperlinkRegion = hyperlinkRegion;
	}

}
