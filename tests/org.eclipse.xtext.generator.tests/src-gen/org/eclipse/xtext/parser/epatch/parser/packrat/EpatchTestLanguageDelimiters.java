/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.epatch.parser.packrat;

import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class EpatchTestLanguageDelimiters {

	private EpatchTestLanguageDelimiters() {
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

	public static ISequenceMatcher ruleCall$11$Delimiter = new SetBasedKeywordMatcher(
		"epatch", "import", "uri", "ns", "java", "extension", "resource", "left", "right", "object", "null", "new", "copy", "migrate", "as", "each");

	public static ISequenceMatcher ruleCall$42$Delimiter = ISequenceMatcher.Factory.nullMatcher();

}
