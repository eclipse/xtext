/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.hyperlinking;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class ActionBasedHyperlink implements IHyperlink {

	private final String label;
	private final OpenDeclarationAction action;
	private final Region location;

	public ActionBasedHyperlink(String label, Region location, OpenDeclarationAction action) {
		this.label = label;
		this.location = location;
		this.action = action;
	}

	public OpenDeclarationAction getAction() {
		return action;
	}

	public IRegion getHyperlinkRegion() {
		return location;
	}

	public String getHyperlinkText() {
		return label;
	}

	public String getTypeLabel() {
		return null;
	}

	public void open() {
		action.run();
	}
}