/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class ContentAssistTestLanguageDelimiters {

	private ContentAssistTestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	public static ICharacterClass keyword$5$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;

	public static ICharacterClass keyword$22$Delimiter = ICharacterClass.Factory.nullClass();

	public static ISequenceMatcher ruleCall$21$Delimiter = new SetBasedKeywordMatcher(
		"abstract rules", "end", "rule");

}
