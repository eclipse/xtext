/*
Generated using Xtext at Fri Jun 06 17:58:59 CEST 2008
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
