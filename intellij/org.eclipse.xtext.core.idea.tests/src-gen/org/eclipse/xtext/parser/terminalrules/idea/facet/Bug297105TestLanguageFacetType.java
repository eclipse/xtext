package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug297105TestLanguageFacetType  extends AbstractFacetType<Bug297105TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug297105TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug297105TestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.terminalrules.Bug297105TestLanguage");

	public Bug297105TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.terminalrules.Bug297105TestLanguage", "Bug297105TestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
