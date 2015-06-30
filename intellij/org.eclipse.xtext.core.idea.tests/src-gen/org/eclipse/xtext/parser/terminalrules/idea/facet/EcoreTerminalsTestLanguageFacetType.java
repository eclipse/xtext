package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EcoreTerminalsTestLanguageFacetType  extends AbstractFacetType<EcoreTerminalsTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.terminalrules.EcoreTerminalsTestLanguage";

	public static  FacetTypeId<Facet<EcoreTerminalsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EcoreTerminalsTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public EcoreTerminalsTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "EcoreTerminalsTestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.EcoreTerminalsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
