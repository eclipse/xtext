package org.eclipse.xtext.testlanguages.backtracking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ExBeeLangTestLanguageFacetType  extends AbstractFacetType<ExBeeLangTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.testlanguages.backtracking.ExBeeLangTestLanguage";

	public static  FacetTypeId<Facet<ExBeeLangTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ExBeeLangTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public ExBeeLangTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "ExBeeLangTestLanguage");
		org.eclipse.xtext.testlanguages.backtracking.idea.lang.ExBeeLangTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
