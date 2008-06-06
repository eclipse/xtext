/*
Generated using Xtext at Fri Jun 06 17:58:54 CEST 2008
*/
package org.eclipse.xtext.grammargen.tests.parsetree;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.grammargen.tests.parsetree.internal.InternalSimpleTest2ParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class SimpleTest2ParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalSimpleTest2ParseTreeConstructor(getFactory(),getGrammar(),getValueConverterService()).update(object);
	}
}
