/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.reference.ui.services;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.core.parser.ITokenTypes;
import org.eclipse.xtext.core.parsetree.LeafNode;
import org.eclipse.xtext.ui.core.editor.utils.CustomResourceLibrary;
import org.eclipse.xtext.ui.core.service.ISyntaxColorer;

/**
 * @author Dennis Hübner
 * 
 */
public class SyntaxColorer implements ISyntaxColorer {

	private static RGB KEYWORD_COLOR = new RGB(127, 0, 85);
	private static RGB DEFAULT_COLOR = new RGB(0, 0, 0);
	private static RGB COMMENT_COLOR = new RGB(20, 127, 20);

	public TextAttribute color(LeafNode node) {
		CustomResourceLibrary lib = new CustomResourceLibrary(Display
				.getDefault());
		TextAttribute ta = new TextAttribute(lib.getColor(DEFAULT_COLOR), null,
				SWT.NONE);
		if (node instanceof LeafNode) {
			String tokenType = ((LeafNode) node).tokenType();
			if (ITokenTypes.KEYWORD.equals(tokenType)) {
				ta = new TextAttribute(lib.getColor(KEYWORD_COLOR), null,
						SWT.BOLD);
			} else if (ITokenTypes.COMMENT.equals(tokenType)) {
				ta = new TextAttribute(lib.getColor(COMMENT_COLOR), null,
						SWT.BOLD);
			}
		}
		return ta;
	}
}
