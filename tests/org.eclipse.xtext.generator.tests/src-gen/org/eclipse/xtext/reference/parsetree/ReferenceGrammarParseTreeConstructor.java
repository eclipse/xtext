/*
Generated using Xtext at Sun Jun 08 11:15:28 CEST 2008
*/
package org.eclipse.xtext.reference.parsetree;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.reference.parsetree.internal.InternalReferenceGrammarParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class ReferenceGrammarParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalReferenceGrammarParseTreeConstructor(getFactory(),getGrammar(),getValueConverterService()).update(object);
	}
}
