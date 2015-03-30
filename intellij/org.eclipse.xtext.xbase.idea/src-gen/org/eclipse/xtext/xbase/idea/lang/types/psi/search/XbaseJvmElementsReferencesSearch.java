package org.eclipse.xtext.xbase.idea.lang.types.psi.search;

import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;
import org.eclipse.xtext.xbase.idea.search.JvmElementsReferencesSearch;

public class XbaseJvmElementsReferencesSearch extends JvmElementsReferencesSearch {

	public XbaseJvmElementsReferencesSearch() {
		super(XbaseLanguage.INSTANCE);
	}

}
