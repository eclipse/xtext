package org.eclipse.xtext.xtext.ecoreInference.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class MultiValueFeatureTestLanguageFacetType  extends AbstractFacetType<MultiValueFeatureTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.xtext.ecoreInference.MultiValueFeatureTestLanguage";

	public static  FacetTypeId<Facet<MultiValueFeatureTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<MultiValueFeatureTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public MultiValueFeatureTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "MultiValueFeatureTestLanguage");
		org.eclipse.xtext.xtext.ecoreInference.idea.lang.MultiValueFeatureTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
