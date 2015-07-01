package org.eclipse.xtext.parser.terminalrules.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class UnicodeTestLanguageFacetType  extends AbstractFacetType<UnicodeTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<UnicodeTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<UnicodeTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.terminalrules.UnicodeTestLanguage");

	public UnicodeTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.terminalrules.UnicodeTestLanguage", "UnicodeTestLanguage");
		org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
