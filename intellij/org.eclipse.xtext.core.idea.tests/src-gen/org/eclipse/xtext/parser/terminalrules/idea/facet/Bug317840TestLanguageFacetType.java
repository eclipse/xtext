package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug317840TestLanguageFacetType  extends AbstractFacetType<Bug317840TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug317840TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug317840TestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.terminalrules.Bug317840TestLanguage");

	public Bug317840TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.terminalrules.Bug317840TestLanguage", "Bug317840TestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
