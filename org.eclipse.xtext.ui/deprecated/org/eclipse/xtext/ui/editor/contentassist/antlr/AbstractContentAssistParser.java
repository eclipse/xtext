/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist.antlr;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.BaseContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.EofListener;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.BaseInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

/**
 * This class if effectively deprecated and clients should use the equivalent from
 * the ide package instead.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractContentAssistParser extends BaseContentAssistParser<FollowElement, LookAheadTerminal, AbstractInternalContentAssistParser> implements IContentAssistParser {

	/**
	 * @since 2.14
	 */
	protected static class MyEofListener extends EofListener implements AbstractInternalContentAssistParser.RecoveryListener {

		protected MyEofListener(BaseInternalContentAssistParser<?, ?> parser, AbstractElement elementToParse) {
			super(parser, elementToParse);
		}
		
	}
	
	/**
	 * @since 2.14
	 */
	@Override
	protected MyEofListener createEofListener(final AbstractInternalContentAssistParser parser,
			final AbstractElement elementToParse) {
		return new MyEofListener(parser, elementToParse);
	}
	
}
