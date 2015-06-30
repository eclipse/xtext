package org.eclipse.xtext.validation.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ConcreteSyntaxValidationTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public ConcreteSyntaxValidationTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "ConcreteSyntaxValidationTestLanguage");
		org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
