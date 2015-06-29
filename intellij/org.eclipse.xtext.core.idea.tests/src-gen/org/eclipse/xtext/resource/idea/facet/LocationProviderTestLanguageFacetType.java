package org.eclipse.xtext.resource.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class LocationProviderTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.resource.LocationProviderTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public LocationProviderTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "LocationProviderTestLanguage");
		org.eclipse.xtext.resource.idea.lang.LocationProviderTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
