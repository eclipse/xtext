package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class TerminalRulesTestLanguageFacetType  extends AbstractFacetType<TerminalRulesTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage";

	public static  FacetTypeId<Facet<TerminalRulesTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<TerminalRulesTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public TerminalRulesTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "TerminalRulesTestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.TerminalRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
