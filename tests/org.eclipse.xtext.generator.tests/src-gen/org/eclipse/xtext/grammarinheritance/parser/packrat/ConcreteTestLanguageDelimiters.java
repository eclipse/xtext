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
	
    // TODO: remove hardcoded character class from template
	public static ICharacterClass keyword$14$Delimiter = ICharacterClass.Factory.join(
			ICharacterClass.Factory.createRange('a', 'z'),
			ICharacterClass.Factory.createRange('A', 'Z'),
			ICharacterClass.Factory.create('_'),
			ICharacterClass.Factory.createRange('0', '9')
	);

	public static ICharacterClass keyword$17$Delimiter = ICharacterClass.Factory.nullClass();

	public static ISequenceMatcher ruleCall$16$Delimiter = ISequenceMatcher.Factory.nullMatcher();

	public static ISequenceMatcher ruleCall$25$Delimiter = new SetBasedKeywordMatcher(
		"model", "overriddenelement", "subrule1", "subrule3");

}
