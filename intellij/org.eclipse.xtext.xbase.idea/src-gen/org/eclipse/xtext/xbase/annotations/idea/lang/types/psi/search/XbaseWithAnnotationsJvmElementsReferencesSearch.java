package org.eclipse.xtext.xbase.annotations.idea.lang.types.psi.search;

import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage;
import org.eclipse.xtext.xbase.idea.search.JvmElementsReferencesSearch;

public class XbaseWithAnnotationsJvmElementsReferencesSearch extends JvmElementsReferencesSearch {

	public XbaseWithAnnotationsJvmElementsReferencesSearch() {
		super(XbaseWithAnnotationsLanguage.INSTANCE);
	}

}
