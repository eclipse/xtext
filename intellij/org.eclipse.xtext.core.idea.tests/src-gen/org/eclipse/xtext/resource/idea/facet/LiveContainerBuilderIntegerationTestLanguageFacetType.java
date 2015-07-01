package org.eclipse.xtext.resource.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class LiveContainerBuilderIntegerationTestLanguageFacetType  extends AbstractFacetType<LiveContainerBuilderIntegerationTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<LiveContainerBuilderIntegerationTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<LiveContainerBuilderIntegerationTestLanguageFacetConfiguration>>("org.eclipse.xtext.resource.LiveContainerBuilderIntegerationTestLanguage");

	public LiveContainerBuilderIntegerationTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.resource.LiveContainerBuilderIntegerationTestLanguage", "LiveContainerBuilderIntegerationTestLanguage");
		org.eclipse.xtext.resource.idea.lang.LiveContainerBuilderIntegerationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
