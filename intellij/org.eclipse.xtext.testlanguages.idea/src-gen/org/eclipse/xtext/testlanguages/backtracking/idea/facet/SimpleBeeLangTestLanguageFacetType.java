package org.eclipse.xtext.testlanguages.backtracking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SimpleBeeLangTestLanguageFacetType  extends AbstractFacetType<SimpleBeeLangTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.testlanguages.backtracking.SimpleBeeLangTestLanguage";

	public static  FacetTypeId<Facet<SimpleBeeLangTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SimpleBeeLangTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public SimpleBeeLangTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "SimpleBeeLangTestLanguage");
		org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
