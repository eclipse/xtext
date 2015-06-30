package org.eclipse.xtext.enumrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EnumRulesTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.enumrules.EnumRulesTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public EnumRulesTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "EnumRulesTestLanguage");
		org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
