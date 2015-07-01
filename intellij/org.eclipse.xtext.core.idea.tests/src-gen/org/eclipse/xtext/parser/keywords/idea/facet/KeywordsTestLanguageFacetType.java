package org.eclipse.xtext.parser.keywords.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class KeywordsTestLanguageFacetType  extends AbstractFacetType<KeywordsTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.keywords.KeywordsTestLanguage";

	public static  FacetTypeId<Facet<KeywordsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<KeywordsTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public KeywordsTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "KeywordsTestLanguage");
		org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
