
package org.eclipse.xtext.grammargen.tests.parsetree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.grammargen.tests.parsetree.internal.InternalSimpleTestParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class SimpleTestParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalSimpleTestParseTreeConstructor(getFactory(),getGrammar()).update(object);
	}
}
