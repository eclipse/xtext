package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class FowlerDslTestLanguageFacetType  extends AbstractFacetType<FowlerDslTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<FowlerDslTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<FowlerDslTestLanguageFacetConfiguration>>("org.eclipse.xtext.testlanguages.FowlerDslTestLanguage");

	public FowlerDslTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.testlanguages.FowlerDslTestLanguage", "FowlerDslTestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.FowlerDslTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
