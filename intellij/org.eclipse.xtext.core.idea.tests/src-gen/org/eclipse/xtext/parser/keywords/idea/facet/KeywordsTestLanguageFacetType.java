package org.eclipse.xtext.parser.keywords.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class KeywordsTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.keywords.KeywordsTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public KeywordsTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "KeywordsTestLanguage");
		org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
