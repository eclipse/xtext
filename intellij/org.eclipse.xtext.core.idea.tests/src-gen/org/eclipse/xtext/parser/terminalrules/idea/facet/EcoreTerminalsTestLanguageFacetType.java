package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EcoreTerminalsTestLanguageFacetType  extends AbstractFacetType<EcoreTerminalsTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<EcoreTerminalsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EcoreTerminalsTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.terminalrules.EcoreTerminalsTestLanguage");

	public EcoreTerminalsTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.terminalrules.EcoreTerminalsTestLanguage", "EcoreTerminalsTestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.EcoreTerminalsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
