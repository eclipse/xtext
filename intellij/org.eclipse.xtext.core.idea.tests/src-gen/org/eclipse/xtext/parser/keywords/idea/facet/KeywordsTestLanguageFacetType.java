package org.eclipse.xtext.parser.keywords.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class KeywordsTestLanguageFacetType  extends AbstractFacetType<KeywordsTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<KeywordsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<KeywordsTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.keywords.KeywordsTestLanguage");

	public KeywordsTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.keywords.KeywordsTestLanguage", "KeywordsTestLanguage");
		org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
