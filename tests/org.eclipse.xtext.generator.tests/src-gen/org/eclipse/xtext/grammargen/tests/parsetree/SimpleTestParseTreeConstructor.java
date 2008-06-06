/*
Generated using Xtext at Fri Jun 06 17:58:53 CEST 2008
*/
package org.eclipse.xtext.grammargen.tests.parsetree;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.grammargen.tests.parsetree.internal.InternalSimpleTestParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class SimpleTestParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalSimpleTestParseTreeConstructor(getFactory(),getGrammar(),getValueConverterService()).update(object);
	}
}
