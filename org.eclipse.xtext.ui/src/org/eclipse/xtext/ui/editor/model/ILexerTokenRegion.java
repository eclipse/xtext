/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.jface.text.IRegion;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface ILexerTokenRegion extends IRegion {
	int getLexerTokenType();
	
}
