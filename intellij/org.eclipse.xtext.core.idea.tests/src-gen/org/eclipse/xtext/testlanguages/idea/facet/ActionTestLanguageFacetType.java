package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ActionTestLanguageFacetType  extends AbstractFacetType<ActionTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<ActionTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ActionTestLanguageFacetConfiguration>>("org.eclipse.xtext.testlanguages.ActionTestLanguage");

	public ActionTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.testlanguages.ActionTestLanguage", "ActionTestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
