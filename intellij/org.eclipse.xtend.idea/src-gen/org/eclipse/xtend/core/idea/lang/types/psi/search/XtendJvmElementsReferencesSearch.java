package org.eclipse.xtend.core.idea.lang.types.psi.search;

import org.eclipse.xtext.idea.types.psi.search.JvmElementsReferencesSearch;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;

public class XtendJvmElementsReferencesSearch extends JvmElementsReferencesSearch {

	public XtendJvmElementsReferencesSearch() {
		super(XtendLanguage.INSTANCE);
	}

}
