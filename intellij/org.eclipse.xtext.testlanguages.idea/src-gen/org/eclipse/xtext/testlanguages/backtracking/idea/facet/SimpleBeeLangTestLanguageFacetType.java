package org.eclipse.xtext.testlanguages.backtracking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SimpleBeeLangTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.testlanguages.backtracking.SimpleBeeLangTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public SimpleBeeLangTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "SimpleBeeLangTestLanguage");
		org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
