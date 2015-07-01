package org.eclipse.xtext.generator.grammarAccess.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class GrammarAccessTestLanguageFacetType  extends AbstractFacetType<GrammarAccessTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<GrammarAccessTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<GrammarAccessTestLanguageFacetConfiguration>>("org.eclipse.xtext.generator.grammarAccess.GrammarAccessTestLanguage");

	public GrammarAccessTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.generator.grammarAccess.GrammarAccessTestLanguage", "GrammarAccessTestLanguage");
		org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
