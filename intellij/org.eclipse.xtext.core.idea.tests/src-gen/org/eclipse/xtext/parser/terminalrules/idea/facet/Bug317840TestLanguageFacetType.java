package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug317840TestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.terminalrules.Bug317840TestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public Bug317840TestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug317840TestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
