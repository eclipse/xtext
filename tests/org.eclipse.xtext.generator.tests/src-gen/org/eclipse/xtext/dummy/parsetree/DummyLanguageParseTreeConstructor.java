/*
Generated using Xtext at Sun Jun 08 11:15:25 CEST 2008
*/
package org.eclipse.xtext.dummy.parsetree;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.dummy.parsetree.internal.InternalDummyLanguageParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class DummyLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalDummyLanguageParseTreeConstructor(getFactory(),getGrammar(),getValueConverterService()).update(object);
	}
}
