/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.folding;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.viewers.StyledString;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class DefaultFoldingRegion implements IFoldingRegion {
	private Position position;
	private StyledString alias;

	public DefaultFoldingRegion(Position position) {
		super();
		this.position = position;
	}

	public DefaultFoldingRegion(Position position, StyledString alias) {
		super();
		this.position = position;
		this.alias = alias;
	}

	public StyledString getAlias() {
		return alias;
	}

	public Position getPosition() {
		return position;
	}

}
