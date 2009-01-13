/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.formatter.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;

public class FormatterTestLanguageDelimiters {

	public static ICharacterClass ID_DELIMITER = XtextBuiltinIDConsumer.IDConsumer$$2;
	
	public static ICharacterClass ANY_OTHER_DELIMITER = ICharacterClass.Factory.nullClass();
	
	public static ISequenceMatcher ALL_KEYWORDS = new SetBasedKeywordMatcher(FormatterTestLanguageGrammarAccess.INSTANCE.getGrammar());

}
