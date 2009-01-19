/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class TestLanguageDelimiters {

	private TestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	public static ISequenceMatcher ruleCall$18$Delimiter = new SetBasedKeywordMatcher(
		"choice", "optional", "reducible");

	public static ICharacterClass keyword$14$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;

	public static ISequenceMatcher ruleCall$33$Delimiter = ISequenceMatcher.Factory.nullMatcher();

}
