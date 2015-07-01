package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class LangATestLanguageFacetType  extends AbstractFacetType<LangATestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.linking.LangATestLanguage";

	public static  FacetTypeId<Facet<LangATestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<LangATestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public LangATestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "LangATestLanguage");
		org.eclipse.xtext.linking.idea.lang.LangATestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
