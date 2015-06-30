package org.eclipse.xtext.validation.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ConcreteSyntaxValidationTestLanguageFacetType  extends AbstractFacetType<ConcreteSyntaxValidationTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage";

	public static  FacetTypeId<Facet<ConcreteSyntaxValidationTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ConcreteSyntaxValidationTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public ConcreteSyntaxValidationTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "ConcreteSyntaxValidationTestLanguage");
		org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
