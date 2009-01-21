/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class FowlerDslTestLanguageDelimiters {

	private FowlerDslTestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
    // TODO: remove hardcoded character class from template
	public static ICharacterClass keyword$9$Delimiter = ICharacterClass.Factory.join(
			ICharacterClass.Factory.createRange('a', 'z'),
			ICharacterClass.Factory.createRange('A', 'Z'),
			ICharacterClass.Factory.create('_'),
			ICharacterClass.Factory.createRange('0', '9')
	);

	public static ISequenceMatcher ruleCall$26$Delimiter = new SetBasedKeywordMatcher(
		"events", "end", "commands", "resetting", "state", "actions");

	public static ICharacterClass keyword$49$Delimiter = ICharacterClass.Factory.nullClass();

}
