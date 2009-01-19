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
	
	public static ISequenceMatcher ruleCall$30$Delimiter = new SetBasedKeywordMatcher(
		"type", "extends", "mykeyword1", "mykeyword2", "myoption", "kw");
		
	public static ICharacterClass keyword$36$Delimiter = ICharacterClass.Factory.nullClass();
	
	public static ISequenceMatcher ruleCall$46$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	
	// TODO do not use IDConsumer internals
	public static ICharacterClass keyword$67$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;
	
}
