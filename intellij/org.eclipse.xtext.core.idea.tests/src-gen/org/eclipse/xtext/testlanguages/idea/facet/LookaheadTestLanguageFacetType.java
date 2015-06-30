package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class LookaheadTestLanguageFacetType  extends AbstractFacetType<LookaheadTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.testlanguages.LookaheadTestLanguage";

	public static  FacetTypeId<Facet<LookaheadTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<LookaheadTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public LookaheadTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "LookaheadTestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
