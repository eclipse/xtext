package org.eclipse.xtext.resource.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class LiveContainerTestLanguageFacetType  extends AbstractFacetType<LiveContainerTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.resource.LiveContainerTestLanguage";

	public static  FacetTypeId<Facet<LiveContainerTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<LiveContainerTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public LiveContainerTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "LiveContainerTestLanguage");
		org.eclipse.xtext.resource.idea.lang.LiveContainerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
