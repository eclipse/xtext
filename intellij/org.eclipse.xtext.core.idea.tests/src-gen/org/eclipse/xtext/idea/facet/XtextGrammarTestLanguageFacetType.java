package org.eclipse.xtext.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class XtextGrammarTestLanguageFacetType  extends AbstractFacetType<XtextGrammarTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<XtextGrammarTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<XtextGrammarTestLanguageFacetConfiguration>>("org.eclipse.xtext.XtextGrammarTestLanguage");

	public XtextGrammarTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.XtextGrammarTestLanguage", "XtextGrammarTestLanguage");
		org.eclipse.xtext.idea.lang.XtextGrammarTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
