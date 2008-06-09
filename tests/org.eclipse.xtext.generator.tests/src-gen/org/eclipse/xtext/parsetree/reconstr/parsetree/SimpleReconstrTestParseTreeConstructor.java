/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parsetree;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.reconstr.parsetree.internal.InternalSimpleReconstrTestParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class SimpleReconstrTestParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalSimpleReconstrTestParseTreeConstructor(getFactory(),getGrammar(),getValueConverterService()).update(object);
	}
}
