package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ReferenceGrammarTestLanguageFacetType  extends AbstractFacetType<ReferenceGrammarTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage";

	public static  FacetTypeId<Facet<ReferenceGrammarTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ReferenceGrammarTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public ReferenceGrammarTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "ReferenceGrammarTestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
