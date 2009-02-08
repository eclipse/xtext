/*
Generated with Xtext
*/
package org.eclipse.xtext.dummy.parser.packrat;

import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

@SuppressWarnings("unused")
public final class DummyTestLanguageDelimiters {

	private DummyTestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
    // TODO: remove hardcoded character class from template
	public static ICharacterClass keyword$12$Delimiter = ICharacterClass.Factory.join(
			ICharacterClass.Factory.createRange('a', 'z'),
			ICharacterClass.Factory.createRange('A', 'Z'),
			ICharacterClass.Factory.create('_'),
			ICharacterClass.Factory.createRange('0', '9')
	);

	public static ICharacterClass keyword$18$Delimiter = ICharacterClass.Factory.nullClass();

	public static ISequenceMatcher ruleCall$15$Delimiter = new SetBasedKeywordMatcher(
		"optional", "element");

	public static ISequenceMatcher ruleCall$17$Delimiter = ISequenceMatcher.Factory.nullMatcher();

}
