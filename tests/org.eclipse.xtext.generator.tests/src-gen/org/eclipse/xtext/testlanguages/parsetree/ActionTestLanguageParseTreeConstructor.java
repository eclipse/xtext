/*
Generated using Xtext at Fri Jun 06 17:59:00 CEST 2008
*/
package org.eclipse.xtext.testlanguages.parsetree;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testlanguages.parsetree.internal.InternalActionTestLanguageParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class ActionTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalActionTestLanguageParseTreeConstructor(getFactory(),getGrammar(),getValueConverterService()).update(object);
	}
}
