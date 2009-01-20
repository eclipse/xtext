/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class PartialParserTestLanguageDelimiters {

	private PartialParserTestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	public static ICharacterClass keyword$10$Delimiter = ICharacterClass.Factory.nullClass();

	public static ICharacterClass keyword$7$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;

	public static ISequenceMatcher ruleCall$9$Delimiter = new SetBasedKeywordMatcher(
		"container", "nested", "children", "C", "abstract children", "F", "S");

}
