/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import org.eclipse.xtext.ui.editor.folding.DefaultFoldedPosition;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class InitiallyCollapsableFoldedPosition extends DefaultFoldedPosition {

	private boolean initiallyCollapsed = false;
	
	public InitiallyCollapsableFoldedPosition(int offset, int length, int contentStart, int contentLength, boolean initiallyCollapsed) {
		super(offset, length, contentStart, contentLength);
		this.initiallyCollapsed = initiallyCollapsed;
	}

	public boolean isInitiallyCollapsed() {
		return initiallyCollapsed;
	}
	
}
