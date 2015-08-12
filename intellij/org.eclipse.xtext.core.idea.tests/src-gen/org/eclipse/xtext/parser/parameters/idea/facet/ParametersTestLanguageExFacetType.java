package org.eclipse.xtext.parser.parameters.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ParametersTestLanguageExFacetType  extends AbstractFacetType<ParametersTestLanguageExFacetConfiguration> {

	public static final FacetTypeId<Facet<ParametersTestLanguageExFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ParametersTestLanguageExFacetConfiguration>>("org.eclipse.xtext.parser.parameters.ParametersTestLanguageEx");

	public ParametersTestLanguageExFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.parameters.ParametersTestLanguageEx", "ParametersTestLanguageEx");
		org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageExLanguage.INSTANCE.injectMembers(this);
	}

}
