package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug301935ExTestLanguageFacetType  extends AbstractFacetType<Bug301935ExTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.antlr.Bug301935ExTestLanguage";

	public static  FacetTypeId<Facet<Bug301935ExTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug301935ExTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public Bug301935ExTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug301935ExTestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug301935ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
