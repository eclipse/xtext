/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.formatter.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class FormatterTestLanguageDelimiters {

	private FormatterTestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	public static ICharacterClass keyword$4$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;

	public static ICharacterClass keyword$16$Delimiter = ICharacterClass.Factory.nullClass();

	public static ISequenceMatcher ruleCall$13$Delimiter = new SetBasedKeywordMatcher(
		"test", "linewrap", "indentation");

}
