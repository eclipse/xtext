package org.eclipse.xtext.testlanguages.backtracking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class BeeLangTestLanguageFacetType  extends AbstractFacetType<BeeLangTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<BeeLangTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<BeeLangTestLanguageFacetConfiguration>>("org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage");

	public BeeLangTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage", "BeeLangTestLanguage");
		org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
