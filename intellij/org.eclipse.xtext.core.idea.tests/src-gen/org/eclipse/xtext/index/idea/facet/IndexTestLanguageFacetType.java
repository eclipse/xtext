package org.eclipse.xtext.index.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class IndexTestLanguageFacetType  extends AbstractFacetType<IndexTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.index.IndexTestLanguage";

	public static  FacetTypeId<Facet<IndexTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<IndexTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public IndexTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "IndexTestLanguage");
		org.eclipse.xtext.index.idea.lang.IndexTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
