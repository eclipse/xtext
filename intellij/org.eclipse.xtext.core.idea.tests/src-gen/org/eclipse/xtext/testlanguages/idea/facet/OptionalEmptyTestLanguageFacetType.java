package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class OptionalEmptyTestLanguageFacetType  extends AbstractFacetType<OptionalEmptyTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<OptionalEmptyTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<OptionalEmptyTestLanguageFacetConfiguration>>("org.eclipse.xtext.testlanguages.OptionalEmptyTestLanguage");

	public OptionalEmptyTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.testlanguages.OptionalEmptyTestLanguage", "OptionalEmptyTestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
