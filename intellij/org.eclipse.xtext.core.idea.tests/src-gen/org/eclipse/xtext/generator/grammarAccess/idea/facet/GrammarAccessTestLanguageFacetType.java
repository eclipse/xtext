package org.eclipse.xtext.generator.grammarAccess.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class GrammarAccessTestLanguageFacetType  extends AbstractFacetType<GrammarAccessTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.generator.grammarAccess.GrammarAccessTestLanguage";

	public static  FacetTypeId<Facet<GrammarAccessTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<GrammarAccessTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public GrammarAccessTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "GrammarAccessTestLanguage");
		org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
