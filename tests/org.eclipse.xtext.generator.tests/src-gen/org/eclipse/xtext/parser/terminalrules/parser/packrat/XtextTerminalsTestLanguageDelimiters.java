/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat;

import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageDelimiters {

	private XtextTerminalsTestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
    // TODO: remove hardcoded character class from template
	public static ICharacterClass keyword$11$Delimiter = ICharacterClass.Factory.join(
			ICharacterClass.Factory.createRange('a', 'z'),
			ICharacterClass.Factory.createRange('A', 'Z'),
			ICharacterClass.Factory.create('_'),
			ICharacterClass.Factory.createRange('0', '9')
	);

	public static ICharacterClass keyword$16$Delimiter = ICharacterClass.Factory.nullClass();

	public static ISequenceMatcher ruleCall$14$Delimiter = new SetBasedKeywordMatcher(
		"language", "extends", "generate", "as", "import", "native", "lexer", "returns", "hidden", "terminal", "current");

	public static ISequenceMatcher crossReference$53$Delimiter = ISequenceMatcher.Factory.nullMatcher();

}
