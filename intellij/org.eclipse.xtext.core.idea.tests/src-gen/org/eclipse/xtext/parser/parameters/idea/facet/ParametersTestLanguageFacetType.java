package org.eclipse.xtext.parser.parameters.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ParametersTestLanguageFacetType  extends AbstractFacetType<ParametersTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<ParametersTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ParametersTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.parameters.ParametersTestLanguage");

	public ParametersTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.parameters.ParametersTestLanguage", "ParametersTestLanguage");
		org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
