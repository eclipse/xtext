package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class TestLanguageFacetType  extends AbstractFacetType<TestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.testlanguages.TestLanguage";

	public static  FacetTypeId<Facet<TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<TestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "TestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
