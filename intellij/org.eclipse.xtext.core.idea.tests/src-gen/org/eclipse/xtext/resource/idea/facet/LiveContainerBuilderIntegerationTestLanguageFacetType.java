package org.eclipse.xtext.resource.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class LiveContainerBuilderIntegerationTestLanguageFacetType  extends AbstractFacetType<LiveContainerBuilderIntegerationTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.resource.LiveContainerBuilderIntegerationTestLanguage";

	public static  FacetTypeId<Facet<LiveContainerBuilderIntegerationTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<LiveContainerBuilderIntegerationTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public LiveContainerBuilderIntegerationTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "LiveContainerBuilderIntegerationTestLanguage");
		org.eclipse.xtext.resource.idea.lang.LiveContainerBuilderIntegerationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
