/*
Generated using Xtext at Fri Jun 06 17:58:59 CEST 2008
*/
package org.eclipse.xtext.testlanguages.parsetree;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testlanguages.parsetree.internal.InternalSimpleExpressionsParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class SimpleExpressionsParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalSimpleExpressionsParseTreeConstructor(getFactory(),getGrammar(),getValueConverterService()).update(object);
	}
}
