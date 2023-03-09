/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
