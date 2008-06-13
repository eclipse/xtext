/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testlanguages.parsetree.internal.InternalReferenceGrammarParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class ReferenceGrammarParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalReferenceGrammarParseTreeConstructor(getFactory(),getGrammar(),getValueConverterService()).update(object);
	}
}
