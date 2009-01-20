/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class ConcreteTestLanguageDelimiters {

	private ConcreteTestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	public static ICharacterClass keyword$6$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;

	public static ICharacterClass keyword$9$Delimiter = ICharacterClass.Factory.nullClass();

	public static ISequenceMatcher ruleCall$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();

	public static ISequenceMatcher ruleCall$7$Delimiter = new SetBasedKeywordMatcher(
		"model");

}
