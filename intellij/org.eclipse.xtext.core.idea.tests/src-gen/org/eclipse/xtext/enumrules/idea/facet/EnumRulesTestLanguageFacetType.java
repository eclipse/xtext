package org.eclipse.xtext.enumrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EnumRulesTestLanguageFacetType  extends AbstractFacetType<EnumRulesTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.enumrules.EnumRulesTestLanguage";

	public static  FacetTypeId<Facet<EnumRulesTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EnumRulesTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public EnumRulesTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "EnumRulesTestLanguage");
		org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
