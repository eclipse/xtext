package org.eclipse.xtext.index.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class IndexTestLanguageFacetType  extends AbstractFacetType<IndexTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<IndexTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<IndexTestLanguageFacetConfiguration>>("org.eclipse.xtext.index.IndexTestLanguage");

	public IndexTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.index.IndexTestLanguage", "IndexTestLanguage");
		org.eclipse.xtext.index.idea.lang.IndexTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
