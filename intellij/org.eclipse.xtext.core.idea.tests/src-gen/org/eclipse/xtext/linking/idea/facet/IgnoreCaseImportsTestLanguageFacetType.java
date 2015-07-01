package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class IgnoreCaseImportsTestLanguageFacetType  extends AbstractFacetType<IgnoreCaseImportsTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<IgnoreCaseImportsTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<IgnoreCaseImportsTestLanguageFacetConfiguration>>("org.eclipse.xtext.linking.IgnoreCaseImportsTestLanguage");

	public IgnoreCaseImportsTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.linking.IgnoreCaseImportsTestLanguage", "IgnoreCaseImportsTestLanguage");
		org.eclipse.xtext.linking.idea.lang.IgnoreCaseImportsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
