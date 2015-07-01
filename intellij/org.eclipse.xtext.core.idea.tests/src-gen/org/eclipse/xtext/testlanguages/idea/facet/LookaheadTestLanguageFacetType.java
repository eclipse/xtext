package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class LookaheadTestLanguageFacetType  extends AbstractFacetType<LookaheadTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<LookaheadTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<LookaheadTestLanguageFacetConfiguration>>("org.eclipse.xtext.testlanguages.LookaheadTestLanguage");

	public LookaheadTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.testlanguages.LookaheadTestLanguage", "LookaheadTestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
