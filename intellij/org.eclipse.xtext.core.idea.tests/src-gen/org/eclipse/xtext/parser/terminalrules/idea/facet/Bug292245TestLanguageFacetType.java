package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug292245TestLanguageFacetType  extends AbstractFacetType<Bug292245TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug292245TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug292245TestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.terminalrules.Bug292245TestLanguage");

	public Bug292245TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.terminalrules.Bug292245TestLanguage", "Bug292245TestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.Bug292245TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
