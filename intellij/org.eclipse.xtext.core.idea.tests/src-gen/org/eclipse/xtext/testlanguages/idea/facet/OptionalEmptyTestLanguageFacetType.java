package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class OptionalEmptyTestLanguageFacetType  extends AbstractFacetType<OptionalEmptyTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.testlanguages.OptionalEmptyTestLanguage";

	public static  FacetTypeId<Facet<OptionalEmptyTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<OptionalEmptyTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public OptionalEmptyTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "OptionalEmptyTestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
