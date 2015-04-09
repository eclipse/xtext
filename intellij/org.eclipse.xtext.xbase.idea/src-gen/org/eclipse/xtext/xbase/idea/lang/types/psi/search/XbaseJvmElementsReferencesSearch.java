package org.eclipse.xtext.xbase.idea.lang.types.psi.search;

import org.eclipse.xtext.xbase.idea.search.JvmElementsReferencesSearch;
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;

public class XbaseJvmElementsReferencesSearch extends JvmElementsReferencesSearch {

	public XbaseJvmElementsReferencesSearch() {
		super(XbaseLanguage.INSTANCE);
	}

}
