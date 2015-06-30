package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug289524ExTestLanguageFacetType  extends AbstractFacetType<Bug289524ExTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.antlr.Bug289524ExTestLanguage";

	public static  FacetTypeId<Facet<Bug289524ExTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug289524ExTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public Bug289524ExTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug289524ExTestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug289524ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
