/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.parser.handwritten;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;
import org.eclipse.xtext.services.XtextGrammarAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class HandwrittenDelimiters {

	public static ICharacterClass idDelimiter() {
		return XtextBuiltinIDConsumer.IDConsumer$$2;
	}
	
	public static ICharacterClass anyOtherDelimiter() {
		return ICharacterClass.Factory.nullClass();
	}
	
	public static ISequenceMatcher allKeywords = new SetBasedKeywordMatcher(XtextGrammarAccess.INSTANCE.getGrammar());
	
}
