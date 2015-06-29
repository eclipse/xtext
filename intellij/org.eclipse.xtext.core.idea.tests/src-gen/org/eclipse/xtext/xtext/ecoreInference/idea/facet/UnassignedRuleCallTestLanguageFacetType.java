package org.eclipse.xtext.xtext.ecoreInference.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class UnassignedRuleCallTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.xtext.ecoreInference.UnassignedRuleCallTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public UnassignedRuleCallTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "UnassignedRuleCallTestLanguage");
		org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
