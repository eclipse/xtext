/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class LangATestLanguageDelimiters {

	private LangATestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	public static ISequenceMatcher ruleCall$13$Delimiter = ISequenceMatcher.Factory.nullMatcher();

	public static ICharacterClass keyword$11$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;

	public static ISequenceMatcher ruleCall$21$Delimiter = new SetBasedKeywordMatcher(
		"import", "type", "extends");

}
