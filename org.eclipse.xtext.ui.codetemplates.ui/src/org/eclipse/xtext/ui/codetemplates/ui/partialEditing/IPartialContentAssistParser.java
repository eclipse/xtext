/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.partialEditing;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;

/**
 * The partial content assist parser allows to set the entry rule.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IPartialContentAssistParser extends IContentAssistParser {

	void initializeFor(AbstractRule rule);
	
}
