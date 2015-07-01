package org.eclipse.xtext.resource.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class LiveContainerTestLanguageFacetType  extends AbstractFacetType<LiveContainerTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<LiveContainerTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<LiveContainerTestLanguageFacetConfiguration>>("org.eclipse.xtext.resource.LiveContainerTestLanguage");

	public LiveContainerTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.resource.LiveContainerTestLanguage", "LiveContainerTestLanguage");
		org.eclipse.xtext.resource.idea.lang.LiveContainerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
