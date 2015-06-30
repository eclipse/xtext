package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class IgnoreCaseNamespacesTestLanguageFacetType  extends AbstractFacetType<IgnoreCaseNamespacesTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.linking.IgnoreCaseNamespacesTestLanguage";

	public static  FacetTypeId<Facet<IgnoreCaseNamespacesTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<IgnoreCaseNamespacesTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public IgnoreCaseNamespacesTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "IgnoreCaseNamespacesTestLanguage");
		org.eclipse.xtext.linking.idea.lang.IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
