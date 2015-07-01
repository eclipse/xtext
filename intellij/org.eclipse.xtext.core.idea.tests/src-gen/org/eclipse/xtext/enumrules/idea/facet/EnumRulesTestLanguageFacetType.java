package org.eclipse.xtext.enumrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EnumRulesTestLanguageFacetType  extends AbstractFacetType<EnumRulesTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<EnumRulesTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EnumRulesTestLanguageFacetConfiguration>>("org.eclipse.xtext.enumrules.EnumRulesTestLanguage");

	public EnumRulesTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.enumrules.EnumRulesTestLanguage", "EnumRulesTestLanguage");
		org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
