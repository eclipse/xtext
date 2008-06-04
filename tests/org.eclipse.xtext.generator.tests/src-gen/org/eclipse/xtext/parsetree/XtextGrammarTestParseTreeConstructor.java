
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.internal.InternalXtextGrammarTestParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class XtextGrammarTestParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalXtextGrammarTestParseTreeConstructor(getFactory(),getGrammar(),getValueConverterService()).update(object);
	}
}
