package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug289059TestLanguageFacetType  extends AbstractFacetType<Bug289059TestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<Bug289059TestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug289059TestLanguageFacetConfiguration>>("org.eclipse.xtext.linking.Bug289059TestLanguage");

	public Bug289059TestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.linking.Bug289059TestLanguage", "Bug289059TestLanguage");
		org.eclipse.xtext.linking.idea.lang.Bug289059TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
