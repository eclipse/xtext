package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug289524ExTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.antlr.Bug289524ExTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public Bug289524ExTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug289524ExTestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug289524ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
