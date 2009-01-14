/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.matching.SetBasedKeywordMatcher;

public final class DomainmodelDelimiters {

	private DomainmodelDelimiters() {
		throw new UnsupportedOperationException("Utility classes may not be initialized");
	}
	
	// TODO do not use IDConsumer internals
	public static ICharacterClass keyword$12$Delimiter = XtextBuiltinIDConsumer.IDConsumer$$2;
	
	public static ISequenceMatcher ruleCall$14$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	
	public static ICharacterClass keyword$29$Delimiter = ICharacterClass.Factory.nullClass();
	
	public static ISequenceMatcher ruleCall$43$Delimiter = new SetBasedKeywordMatcher(
		"import", "package", "datatype", "entity", "extends", "attr", "ref", "opposite", "op");
		
}
