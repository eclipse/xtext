package org.eclipse.xtext.xbase.annotations.idea.lang.types.psi.search;

import org.eclipse.xtext.xbase.idea.search.JvmElementsReferencesSearch;
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage;

public class XbaseWithAnnotationsJvmElementsReferencesSearch extends JvmElementsReferencesSearch {

	public XbaseWithAnnotationsJvmElementsReferencesSearch() {
		super(XbaseWithAnnotationsLanguage.INSTANCE);
	}

}
