package org.eclipse.xtext.testlanguages.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ReferenceGrammarTestLanguageFacetType  extends AbstractFacetType<ReferenceGrammarTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<ReferenceGrammarTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ReferenceGrammarTestLanguageFacetConfiguration>>("org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage");

	public ReferenceGrammarTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage", "ReferenceGrammarTestLanguage");
		org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
