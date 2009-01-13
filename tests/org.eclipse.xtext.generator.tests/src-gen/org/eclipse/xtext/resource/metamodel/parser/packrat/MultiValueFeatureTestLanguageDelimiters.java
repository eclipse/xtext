/*
Generated with Xtext
*/
package org.eclipse.xtext.resource.metamodel.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

import org.eclipse.xtext.resource.metamodel.services.MultiValueFeatureTestLanguageGrammarAccess;

public class MultiValueFeatureTestLanguageDelimiters {

	public static ICharacterClass ID_DELIMITER = XtextBuiltinIDConsumer.IDConsumer$$2;
	
	public static ICharacterClass ANY_OTHER_DELIMITER = ICharacterClass.Factory.nullClass();
	
	public static ISequenceMatcher ALL_KEYWORDS = new SetBasedKeywordMatcher(MultiValueFeatureTestLanguageGrammarAccess.INSTANCE.getGrammar());

}
