/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.packrat;

import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

@SuppressWarnings("unused")
public final class ConcreteTestLanguageDelimiters {

	private ConcreteTestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	public static ICharacterClass keyword$12$Delimiter = ICharacterClass.Factory.nullClass();

    // TODO: remove hardcoded character class from template
	public static ICharacterClass keyword$9$Delimiter = ICharacterClass.Factory.join(
			ICharacterClass.Factory.createRange('a', 'z'),
			ICharacterClass.Factory.createRange('A', 'Z'),
			ICharacterClass.Factory.create('_'),
			ICharacterClass.Factory.createRange('0', '9')
	);

	public static ISequenceMatcher ruleCall$11$Delimiter = ISequenceMatcher.Factory.nullMatcher();

	public static ISequenceMatcher ruleCall$7$Delimiter = new SetBasedKeywordMatcher(
		"model");

	public static ISequenceMatcher ruleCall$19$Delimiter = new SetBasedKeywordMatcher(
		"model");

	public static ISequenceMatcher ruleCall$31$Delimiter = new SetBasedKeywordMatcher(
		"model");

}
