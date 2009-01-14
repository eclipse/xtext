/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class XtextGrammarTestLanguageDelimiters {

	private XtextGrammarTestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	// TODO do not use IDConsumer internals
	public static ICharacterClass keyword$11$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;
	
	public static ISequenceMatcher ruleCall$14$Delimiter = new SetBasedKeywordMatcher(
		"abstract language", "language", "extends", "generate", "as", "import", "native", "lexer", "returns", "current");
		
	public static ICharacterClass keyword$16$Delimiter = ICharacterClass.Factory.nullClass();
	
	public static ISequenceMatcher ruleCall$51$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	
}
