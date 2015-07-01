package org.eclipse.xtext.parser.antlr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug296889TestLanguageFacetType  extends AbstractFacetType<Bug296889TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug296889TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug296889TestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.antlr.Bug296889TestLanguage");

	public Bug296889TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.antlr.Bug296889TestLanguage", "Bug296889TestLanguage");
		org.eclipse.xtext.parser.antlr.idea.lang.Bug296889TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
