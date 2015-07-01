package org.eclipse.xtext.enumrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class MultiRuleEnumTestLanguageFacetType  extends AbstractFacetType<MultiRuleEnumTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<MultiRuleEnumTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<MultiRuleEnumTestLanguageFacetConfiguration>>("org.eclipse.xtext.enumrules.MultiRuleEnumTestLanguage");

	public MultiRuleEnumTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.enumrules.MultiRuleEnumTestLanguage", "MultiRuleEnumTestLanguage");
		org.eclipse.xtext.enumrules.idea.lang.MultiRuleEnumTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
