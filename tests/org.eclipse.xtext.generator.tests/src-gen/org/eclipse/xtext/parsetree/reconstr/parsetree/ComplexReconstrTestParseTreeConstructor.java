/*
Generated using Xtext at Sun Jun 08 11:15:26 CEST 2008
*/
package org.eclipse.xtext.parsetree.reconstr.parsetree;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.reconstr.parsetree.internal.InternalComplexReconstrTestParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class ComplexReconstrTestParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalComplexReconstrTestParseTreeConstructor(getFactory(),getGrammar(),getValueConverterService()).update(object);
	}
}
