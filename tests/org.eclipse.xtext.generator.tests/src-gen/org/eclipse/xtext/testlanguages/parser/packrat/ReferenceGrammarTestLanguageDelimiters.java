/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class ReferenceGrammarTestLanguageDelimiters {

	private ReferenceGrammarTestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	public static ISequenceMatcher ruleCall$10$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	
	// TODO do not use IDConsumer internals
	public static ICharacterClass keyword$8$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;
	
	public static ICharacterClass keyword$13$Delimiter = ICharacterClass.Factory.nullClass();
	
	public static ISequenceMatcher ruleCall$40$Delimiter = new SetBasedKeywordMatcher(
		"spielplatz", "kind", "erwachsener", "spielzeug", "ROT", "BLAU", "GELB", "GRÜN", "familie", "keyword");
		
}
