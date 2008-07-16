/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.tokentype;

import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public interface ITokenTypeDef {
	/**
	 * @return identifier
	 */
	String getId();

	/**
	 * @return Human readable name, can be used for labels.
	 */
	String getName();

	/**
	 * @return a clone of textStyle used for this TokenTypeDef
	 */
	TextStyle textStyleCopy();

	boolean match(LeafNode node);

}
