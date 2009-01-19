/*
Generated with Xtext
*/
package org.eclipse.xtext.dummy.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class DummyTestLanguageDelimiters {

	private DummyTestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	public static ISequenceMatcher ruleCall$15$Delimiter = new SetBasedKeywordMatcher(
		"optional", "element");
		
	// TODO do not use IDConsumer internals
	public static ICharacterClass keyword$12$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;
	
	public static ICharacterClass keyword$18$Delimiter = ICharacterClass.Factory.nullClass();
	
	public static ISequenceMatcher ruleCall$17$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	
}
