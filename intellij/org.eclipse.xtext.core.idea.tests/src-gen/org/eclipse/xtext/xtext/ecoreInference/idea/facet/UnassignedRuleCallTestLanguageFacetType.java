package org.eclipse.xtext.xtext.ecoreInference.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class UnassignedRuleCallTestLanguageFacetType  extends AbstractFacetType<UnassignedRuleCallTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<UnassignedRuleCallTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<UnassignedRuleCallTestLanguageFacetConfiguration>>("org.eclipse.xtext.xtext.ecoreInference.UnassignedRuleCallTestLanguage");

	public UnassignedRuleCallTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.xtext.ecoreInference.UnassignedRuleCallTestLanguage", "UnassignedRuleCallTestLanguage");
		org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
