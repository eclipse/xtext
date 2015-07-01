package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class TestLanguageFacetType  extends AbstractFacetType<TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<TestLanguageFacetConfiguration>>("org.eclipse.xtext.testlanguages.TestLanguage");

	public TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.testlanguages.TestLanguage", "TestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
