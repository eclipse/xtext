package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class HiddenTerminalsTestLanguageFacetType  extends AbstractFacetType<HiddenTerminalsTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<HiddenTerminalsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<HiddenTerminalsTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage");

	public HiddenTerminalsTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage", "HiddenTerminalsTestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
