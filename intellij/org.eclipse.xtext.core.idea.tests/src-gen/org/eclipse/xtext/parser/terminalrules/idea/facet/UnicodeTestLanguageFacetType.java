package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class UnicodeTestLanguageFacetType  extends AbstractFacetType<UnicodeTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.terminalrules.UnicodeTestLanguage";

	public static  FacetTypeId<Facet<UnicodeTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<UnicodeTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public UnicodeTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "UnicodeTestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
