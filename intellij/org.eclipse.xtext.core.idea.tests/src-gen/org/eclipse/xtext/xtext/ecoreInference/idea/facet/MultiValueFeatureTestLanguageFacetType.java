package org.eclipse.xtext.xtext.ecoreInference.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class MultiValueFeatureTestLanguageFacetType  extends AbstractFacetType<MultiValueFeatureTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<MultiValueFeatureTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<MultiValueFeatureTestLanguageFacetConfiguration>>("org.eclipse.xtext.xtext.ecoreInference.MultiValueFeatureTestLanguage");

	public MultiValueFeatureTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.xtext.ecoreInference.MultiValueFeatureTestLanguage", "MultiValueFeatureTestLanguage");
		org.eclipse.xtext.xtext.ecoreInference.idea.lang.MultiValueFeatureTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
