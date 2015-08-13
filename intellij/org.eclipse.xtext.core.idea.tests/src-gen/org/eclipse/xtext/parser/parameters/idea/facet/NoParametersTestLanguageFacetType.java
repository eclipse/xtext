package org.eclipse.xtext.parser.parameters.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class NoParametersTestLanguageFacetType  extends AbstractFacetType<NoParametersTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<NoParametersTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<NoParametersTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.parameters.NoParametersTestLanguage");

	public NoParametersTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.parameters.NoParametersTestLanguage", "NoParametersTestLanguage");
		org.eclipse.xtext.parser.parameters.idea.lang.NoParametersTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
