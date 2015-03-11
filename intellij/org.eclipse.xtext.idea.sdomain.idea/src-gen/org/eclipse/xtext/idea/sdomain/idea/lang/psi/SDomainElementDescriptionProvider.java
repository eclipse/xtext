package org.eclipse.xtext.idea.sdomain.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;

public class SDomainElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public SDomainElementDescriptionProvider() {
		super(SDomainLanguage.INSTANCE);
	}

}
