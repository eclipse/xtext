package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug289515TestLanguageFacetType  extends AbstractFacetType<Bug289515TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug289515TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug289515TestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.antlr.Bug289515TestLanguage");

	public Bug289515TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.antlr.Bug289515TestLanguage", "Bug289515TestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
