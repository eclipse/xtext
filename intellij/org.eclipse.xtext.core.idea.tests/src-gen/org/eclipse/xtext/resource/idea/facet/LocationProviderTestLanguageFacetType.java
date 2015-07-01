package org.eclipse.xtext.resource.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class LocationProviderTestLanguageFacetType  extends AbstractFacetType<LocationProviderTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<LocationProviderTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<LocationProviderTestLanguageFacetConfiguration>>("org.eclipse.xtext.resource.LocationProviderTestLanguage");

	public LocationProviderTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.resource.LocationProviderTestLanguage", "LocationProviderTestLanguage");
		org.eclipse.xtext.resource.idea.lang.LocationProviderTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
