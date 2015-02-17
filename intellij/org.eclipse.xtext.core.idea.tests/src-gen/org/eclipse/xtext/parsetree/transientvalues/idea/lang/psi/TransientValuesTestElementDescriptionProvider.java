package org.eclipse.xtext.parsetree.transientvalues.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestLanguage;

public class TransientValuesTestElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public TransientValuesTestElementDescriptionProvider() {
		super(TransientValuesTestLanguage.INSTANCE);
	}

}
