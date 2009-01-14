/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class SimpleReconstrTestLanguageDelimiters {

	private SimpleReconstrTestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	public static ISequenceMatcher ruleCall$28$Delimiter = new SetBasedKeywordMatcher(
		"type", "extends", "mykeyword1", "mykeyword2");
		
	public static ICharacterClass keyword$34$Delimiter = ICharacterClass.Factory.nullClass();
	
	public static ISequenceMatcher ruleCall$44$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	
	// TODO do not use IDConsumer internals
	public static ICharacterClass keyword$65$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;
	
}
