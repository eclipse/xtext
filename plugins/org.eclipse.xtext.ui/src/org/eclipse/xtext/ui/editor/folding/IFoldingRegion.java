/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.folding;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.viewers.StyledString;

/**
 * @author Michael Clay - Initial contribution and API
 */
public interface IFoldingRegion {

	/**
	 * @return the the associated position
	 */
	Position getPosition();

	/**
	 * @return the optional alias text which will we displayed instead of the first line in the collapsed region
	 */
	StyledString getAlias();

}
