package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug301935ExTestLanguageFacetType  extends AbstractFacetType<Bug301935ExTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug301935ExTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug301935ExTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.antlr.Bug301935ExTestLanguage");

	public Bug301935ExTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.antlr.Bug301935ExTestLanguage", "Bug301935ExTestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug301935ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
