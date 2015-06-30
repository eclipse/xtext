package org.eclipse.xtext.enumrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EnumAndReferenceTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.enumrules.EnumAndReferenceTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public EnumAndReferenceTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "EnumAndReferenceTestLanguage");
		org.eclipse.xtext.enumrules.idea.lang.EnumAndReferenceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
