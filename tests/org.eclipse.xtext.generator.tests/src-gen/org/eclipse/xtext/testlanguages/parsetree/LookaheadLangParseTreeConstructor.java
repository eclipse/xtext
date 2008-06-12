/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parsetree;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testlanguages.parsetree.internal.InternalLookaheadLangParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class LookaheadLangParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalLookaheadLangParseTreeConstructor(getFactory(),getGrammar(),getValueConverterService()).update(object);
	}
}
