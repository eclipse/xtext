/*
Generated with Xtext
*/
package org.eclipse.xtext.ui.core.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class TestLanguageDelimiters {

	private TestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	// TODO do not use IDConsumer internals
	public static ICharacterClass keyword$8$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;
	
	public static ISequenceMatcher ruleCall$10$Delimiter = new SetBasedKeywordMatcher(
		"stuff");
		
}
