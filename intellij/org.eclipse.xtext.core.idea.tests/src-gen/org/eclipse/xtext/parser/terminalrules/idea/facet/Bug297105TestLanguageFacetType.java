package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug297105TestLanguageFacetType  extends AbstractFacetType<Bug297105TestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.terminalrules.Bug297105TestLanguage";

	public static  FacetTypeId<Facet<Bug297105TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug297105TestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public Bug297105TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug297105TestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
