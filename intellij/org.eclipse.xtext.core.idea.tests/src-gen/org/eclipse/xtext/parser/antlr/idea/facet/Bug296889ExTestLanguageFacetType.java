package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug296889ExTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.antlr.Bug296889ExTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public Bug296889ExTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug296889ExTestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug296889ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
