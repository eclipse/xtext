/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.parser.packrat;

import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

@SuppressWarnings("unused")
public final class Bug250313Delimiters {

	private Bug250313Delimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	public static ICharacterClass keyword$4$Delimiter = ICharacterClass.Factory.nullClass();

    // TODO: remove hardcoded character class from template
	public static ICharacterClass keyword$8$Delimiter = ICharacterClass.Factory.join(
			ICharacterClass.Factory.createRange('a', 'z'),
			ICharacterClass.Factory.createRange('A', 'Z'),
			ICharacterClass.Factory.create('_'),
			ICharacterClass.Factory.createRange('0', '9')
	);

	public static ISequenceMatcher ruleCall$10$Delimiter = new SetBasedKeywordMatcher(
		"mykeyword1");

	public static ISequenceMatcher ruleCall$9$Delimiter = ISequenceMatcher.Factory.nullMatcher();

}
