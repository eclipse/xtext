/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
