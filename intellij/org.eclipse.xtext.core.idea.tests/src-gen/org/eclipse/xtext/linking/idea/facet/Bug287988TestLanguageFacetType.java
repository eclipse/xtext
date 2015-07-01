package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug287988TestLanguageFacetType  extends AbstractFacetType<Bug287988TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug287988TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug287988TestLanguageFacetConfiguration>>("org.eclipse.xtext.linking.Bug287988TestLanguage");

	public Bug287988TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.linking.Bug287988TestLanguage", "Bug287988TestLanguage");
		org.eclipse.xtext.linking.idea.lang.Bug287988TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
