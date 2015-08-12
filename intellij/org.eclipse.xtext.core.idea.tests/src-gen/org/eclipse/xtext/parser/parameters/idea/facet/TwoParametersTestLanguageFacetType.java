package org.eclipse.xtext.parser.parameters.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class TwoParametersTestLanguageFacetType  extends AbstractFacetType<TwoParametersTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<TwoParametersTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<TwoParametersTestLanguageFacetConfiguration>>("org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage");

	public TwoParametersTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.parameters.TwoParametersTestLanguage", "TwoParametersTestLanguage");
		org.eclipse.xtext.parser.parameters.idea.lang.TwoParametersTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
