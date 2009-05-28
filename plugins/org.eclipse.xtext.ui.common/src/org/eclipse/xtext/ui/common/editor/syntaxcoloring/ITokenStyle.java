/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import org.eclipse.xtext.ui.core.editor.utils.TextStyle;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface ITokenStyle {
	String getID();

	String getName();

	TextStyle getDefaultTextStyle();
}
