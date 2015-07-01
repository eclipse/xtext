package org.eclipse.xtext.serializer.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ContextFinderTestLanguageFacetType  extends AbstractFacetType<ContextFinderTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<ContextFinderTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ContextFinderTestLanguageFacetConfiguration>>("org.eclipse.xtext.serializer.ContextFinderTestLanguage");

	public ContextFinderTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.serializer.ContextFinderTestLanguage", "ContextFinderTestLanguage");
		org.eclipse.xtext.serializer.idea.lang.ContextFinderTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
