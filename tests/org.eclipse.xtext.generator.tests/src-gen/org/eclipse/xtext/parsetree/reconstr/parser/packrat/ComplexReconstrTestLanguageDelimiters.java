/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class ComplexReconstrTestLanguageDelimiters {

	private ComplexReconstrTestLanguageDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	public static ICharacterClass keyword$15$Delimiter = ICharacterClass.Factory.nullClass();

	public static ISequenceMatcher ruleCall$33$Delimiter = new SetBasedKeywordMatcher(
		"TA", "x", "y", "TB", "TC", "z", "TD", "TE", "TF", "TG");

	public static ICharacterClass keyword$50$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;

	public static ISequenceMatcher ruleCall$64$Delimiter = ISequenceMatcher.Factory.nullMatcher();

}
