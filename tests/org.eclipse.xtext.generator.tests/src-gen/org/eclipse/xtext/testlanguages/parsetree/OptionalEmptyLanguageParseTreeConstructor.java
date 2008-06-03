
package org.eclipse.xtext.testlanguages.parsetree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testlanguages.parsetree.internal.InternalOptionalEmptyLanguageParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class OptionalEmptyLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalOptionalEmptyLanguageParseTreeConstructor(getFactory(),getGrammar()).update(object);
	}
}
