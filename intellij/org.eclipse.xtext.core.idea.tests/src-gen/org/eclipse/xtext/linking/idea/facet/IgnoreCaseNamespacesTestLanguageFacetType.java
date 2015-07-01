package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class IgnoreCaseNamespacesTestLanguageFacetType  extends AbstractFacetType<IgnoreCaseNamespacesTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<IgnoreCaseNamespacesTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<IgnoreCaseNamespacesTestLanguageFacetConfiguration>>("org.eclipse.xtext.linking.IgnoreCaseNamespacesTestLanguage");

	public IgnoreCaseNamespacesTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.linking.IgnoreCaseNamespacesTestLanguage", "IgnoreCaseNamespacesTestLanguage");
		org.eclipse.xtext.linking.idea.lang.IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
