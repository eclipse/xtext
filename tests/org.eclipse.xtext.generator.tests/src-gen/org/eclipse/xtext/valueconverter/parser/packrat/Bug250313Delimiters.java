/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class Bug250313Delimiters {

	private Bug250313Delimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	public static ISequenceMatcher ruleCall$9$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	
	// TODO do not use IDConsumer internals
	public static ICharacterClass keyword$8$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;
	
	public static ISequenceMatcher ruleCall$10$Delimiter = new SetBasedKeywordMatcher(
		"mykeyword1");
		
	public static ICharacterClass keyword$4$Delimiter = ICharacterClass.Factory.nullClass();
	
}
