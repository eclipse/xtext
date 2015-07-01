package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug301935TestLanguageFacetType  extends AbstractFacetType<Bug301935TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug301935TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug301935TestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.antlr.Bug301935TestLanguage");

	public Bug301935TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.antlr.Bug301935TestLanguage", "Bug301935TestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
