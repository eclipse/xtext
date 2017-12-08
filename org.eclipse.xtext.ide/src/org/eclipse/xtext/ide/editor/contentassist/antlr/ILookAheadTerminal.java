/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import org.antlr.runtime.Token;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @since 2.14
 */
public interface ILookAheadTerminal {

	Token getToken();
	
}
