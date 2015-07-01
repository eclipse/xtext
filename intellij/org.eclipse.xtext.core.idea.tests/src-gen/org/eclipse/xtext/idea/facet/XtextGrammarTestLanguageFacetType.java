package org.eclipse.xtext.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class XtextGrammarTestLanguageFacetType  extends AbstractFacetType<XtextGrammarTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.XtextGrammarTestLanguage";

	public static  FacetTypeId<Facet<XtextGrammarTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<XtextGrammarTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public XtextGrammarTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "XtextGrammarTestLanguage");
		org.eclipse.xtext.idea.lang.XtextGrammarTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
