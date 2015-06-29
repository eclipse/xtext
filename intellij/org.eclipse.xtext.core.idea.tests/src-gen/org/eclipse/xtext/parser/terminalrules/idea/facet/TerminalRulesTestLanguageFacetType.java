package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class TerminalRulesTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public TerminalRulesTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "TerminalRulesTestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.TerminalRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
