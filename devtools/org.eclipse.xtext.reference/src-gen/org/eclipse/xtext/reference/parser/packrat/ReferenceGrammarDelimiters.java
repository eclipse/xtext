/*
Generated with Xtext
*/
package org.eclipse.xtext.reference.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class ReferenceGrammarDelimiters {

	private ReferenceGrammarDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	public static ICharacterClass keyword$14$Delimiter = ICharacterClass.Factory.nullClass();
	
	// TODO do not use IDConsumer internals
	public static ICharacterClass keyword$9$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;
	
	public static ISequenceMatcher ruleCall$11$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	
	public static ISequenceMatcher ruleCall$44$Delimiter = new SetBasedKeywordMatcher(
		"spielplatz", "kind", "erwachsener", "spielzeug", "familie", "keyword", "ROT", "BLAU", "GELB", "GRÜN", "type");
		
}
