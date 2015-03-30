package org.eclipse.xtend.core.idea.lang.types.psi.search;

import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtext.xbase.idea.search.JvmElementsReferencesSearch;

public class XtendJvmElementsReferencesSearch extends JvmElementsReferencesSearch {

	public XtendJvmElementsReferencesSearch() {
		super(XtendLanguage.INSTANCE);
	}

}
