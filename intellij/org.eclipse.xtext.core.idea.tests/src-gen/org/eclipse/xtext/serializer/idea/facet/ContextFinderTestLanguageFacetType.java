package org.eclipse.xtext.serializer.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ContextFinderTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.serializer.ContextFinderTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public ContextFinderTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "ContextFinderTestLanguage");
		org.eclipse.xtext.serializer.idea.lang.ContextFinderTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
