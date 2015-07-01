package org.eclipse.xtext.validation.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ConcreteSyntaxValidationTestLanguageFacetType  extends AbstractFacetType<ConcreteSyntaxValidationTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<ConcreteSyntaxValidationTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ConcreteSyntaxValidationTestLanguageFacetConfiguration>>("org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage");

	public ConcreteSyntaxValidationTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage", "ConcreteSyntaxValidationTestLanguage");
		org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
