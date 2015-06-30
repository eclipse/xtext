package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug378967TestLanguageFacetType  extends AbstractFacetType<Bug378967TestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.antlr.Bug378967TestLanguage";

	public static  FacetTypeId<Facet<Bug378967TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug378967TestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public Bug378967TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug378967TestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug378967TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
