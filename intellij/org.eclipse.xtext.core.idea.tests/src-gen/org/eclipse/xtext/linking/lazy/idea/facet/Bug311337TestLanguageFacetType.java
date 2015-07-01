package org.eclipse.xtext.linking.lazy.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug311337TestLanguageFacetType  extends AbstractFacetType<Bug311337TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug311337TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug311337TestLanguageFacetConfiguration>>("org.eclipse.xtext.linking.lazy.Bug311337TestLanguage");

	public Bug311337TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.linking.lazy.Bug311337TestLanguage", "Bug311337TestLanguage");
		org.eclipse.xtext.linking.lazy.idea.lang.Bug311337TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
