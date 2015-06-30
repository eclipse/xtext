package org.eclipse.xtext.enumrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class MultiRuleEnumTestLanguageFacetType  extends AbstractFacetType<MultiRuleEnumTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.enumrules.MultiRuleEnumTestLanguage";

	public static  FacetTypeId<Facet<MultiRuleEnumTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<MultiRuleEnumTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public MultiRuleEnumTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "MultiRuleEnumTestLanguage");
		org.eclipse.xtext.enumrules.idea.lang.MultiRuleEnumTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
