package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class HiddenTerminalsTestLanguageFacetType  extends AbstractFacetType<HiddenTerminalsTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage";

	public static  FacetTypeId<Facet<HiddenTerminalsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<HiddenTerminalsTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public HiddenTerminalsTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "HiddenTerminalsTestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
