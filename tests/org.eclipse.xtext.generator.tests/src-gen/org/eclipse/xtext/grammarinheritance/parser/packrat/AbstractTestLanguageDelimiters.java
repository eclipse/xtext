/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.packrat;

import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

@SuppressWarnings("unused")
public final class AbstractTestLanguageDelimiters {

	private AbstractTestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
    // TODO: remove hardcoded character class from template
	public static ICharacterClass keyword$5$Delimiter = ICharacterClass.Factory.join(
			ICharacterClass.Factory.createRange('a', 'z'),
			ICharacterClass.Factory.createRange('A', 'Z'),
			ICharacterClass.Factory.create('_'),
			ICharacterClass.Factory.createRange('0', '9')
	);

	public static ISequenceMatcher ruleCall$7$Delimiter = new SetBasedKeywordMatcher(
		"element", "overridemodel", "other element", "extendedmodel");

	public static ISequenceMatcher ruleCall$25$Delimiter = ISequenceMatcher.Factory.nullMatcher();

}
