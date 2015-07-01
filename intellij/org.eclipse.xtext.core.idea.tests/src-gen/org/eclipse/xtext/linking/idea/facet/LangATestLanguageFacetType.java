package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class LangATestLanguageFacetType  extends AbstractFacetType<LangATestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<LangATestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<LangATestLanguageFacetConfiguration>>("org.eclipse.xtext.linking.LangATestLanguage");

	public LangATestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.linking.LangATestLanguage", "LangATestLanguage");
		org.eclipse.xtext.linking.idea.lang.LangATestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
