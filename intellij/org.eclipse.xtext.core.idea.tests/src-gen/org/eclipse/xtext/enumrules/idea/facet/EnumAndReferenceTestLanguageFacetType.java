package org.eclipse.xtext.enumrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EnumAndReferenceTestLanguageFacetType  extends AbstractFacetType<EnumAndReferenceTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<EnumAndReferenceTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EnumAndReferenceTestLanguageFacetConfiguration>>("org.eclipse.xtext.enumrules.EnumAndReferenceTestLanguage");

	public EnumAndReferenceTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.enumrules.EnumAndReferenceTestLanguage", "EnumAndReferenceTestLanguage");
		org.eclipse.xtext.enumrules.idea.lang.EnumAndReferenceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
