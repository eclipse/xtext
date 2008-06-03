/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.reference.ui.services;

import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;

/**
 * @author Dennis Hübner
 * 
 */
public class ReferenceSyntaxColorer extends org.eclipse.xtext.ui.core.service.impl.SyntaxColorer {
	@Override
	public TextStyle color(LeafNode leafNode) {
		return super.color(leafNode);
	}
}
