
package org.eclipse.xtext.testlanguages.parsetree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testlanguages.parsetree.internal.InternalLexerLanguageParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class LexerLanguageParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalLexerLanguageParseTreeConstructor(getFactory(),getGrammar()).update(object);
	}
}
