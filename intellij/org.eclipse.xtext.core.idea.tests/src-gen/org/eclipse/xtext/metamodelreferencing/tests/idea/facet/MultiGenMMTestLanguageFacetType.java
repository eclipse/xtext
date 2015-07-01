package org.eclipse.xtext.metamodelreferencing.tests.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class MultiGenMMTestLanguageFacetType  extends AbstractFacetType<MultiGenMMTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<MultiGenMMTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<MultiGenMMTestLanguageFacetConfiguration>>("org.eclipse.xtext.metamodelreferencing.tests.MultiGenMMTestLanguage");

	public MultiGenMMTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.metamodelreferencing.tests.MultiGenMMTestLanguage", "MultiGenMMTestLanguage");
		org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
