package org.eclipse.xtext.testlanguages.backtracking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SimpleBeeLangTestLanguageFacetType  extends AbstractFacetType<SimpleBeeLangTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<SimpleBeeLangTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SimpleBeeLangTestLanguageFacetConfiguration>>("org.eclipse.xtext.testlanguages.backtracking.SimpleBeeLangTestLanguage");

	public SimpleBeeLangTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.testlanguages.backtracking.SimpleBeeLangTestLanguage", "SimpleBeeLangTestLanguage");
		org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
