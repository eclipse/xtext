/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IHiddenTokenHandler {

	ITerminalConsumer[] EMPTY_HIDDENS = new ITerminalConsumer[0];
	
	IHiddenTokenState replaceHiddenTokens(ITerminalConsumer... consumers);
	
	interface IHiddenTokenState {
		
		void restore();
		
	}
	
}
