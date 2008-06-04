
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.internal.InternalXtextParseTreeConstructor;
import org.eclipse.xtext.parsetree.AbstractParseTreeConstructor;

public class XtextParseTreeConstructor extends AbstractParseTreeConstructor {

	public void update(EObject object) {
		new InternalXtextParseTreeConstructor(getFactory(),getGrammar(),getValueConverterService()).update(object);
	}
}
