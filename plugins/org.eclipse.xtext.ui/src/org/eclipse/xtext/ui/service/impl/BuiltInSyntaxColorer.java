/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.ui.service.impl;

import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.service.ISyntaxColorer;
import org.eclipse.xtext.ui.service.ITokenTypeDefProvider;
import org.eclipse.xtext.ui.tokentype.ITokenTypeDef;

/**
 * @author Dennis Hübner
 * 
 */
public class BuiltInSyntaxColorer implements ISyntaxColorer {

	private ITokenTypeDefProvider tokenTypeDef;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.service.ISyntaxColorer#color(org.eclipse.xtext
	 * .parsetree.LeafNode)
	 */
	public TextStyle color(LeafNode leafNode) {
		for (ITokenTypeDef ttd : tokenTypeDef.allTokenTypes()) {
			if (ttd.match(leafNode)) {
				return ttd.textStyleCopy();
			}
		}
		return null;
	}

	@Inject
	public void setTokenTypeDefProvider(ITokenTypeDefProvider service) {
		this.tokenTypeDef = service;
	}

}
