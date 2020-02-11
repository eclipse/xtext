/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.partialEditing;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser;

/**
 * The partial content assist parser allows to set the entry rule.
 * @since 2.9
 */
public interface IPartialEditingContentAssistParser extends IContentAssistParser {

	void initializeFor(AbstractRule rule);
	
}
