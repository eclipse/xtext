package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class TerminalRulesTestLanguageFacetType  extends AbstractFacetType<TerminalRulesTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<TerminalRulesTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<TerminalRulesTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage");

	public TerminalRulesTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage", "TerminalRulesTestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.TerminalRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
