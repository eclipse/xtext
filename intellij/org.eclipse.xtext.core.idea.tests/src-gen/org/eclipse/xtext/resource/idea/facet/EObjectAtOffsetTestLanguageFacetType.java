package org.eclipse.xtext.resource.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EObjectAtOffsetTestLanguageFacetType  extends AbstractFacetType<EObjectAtOffsetTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<EObjectAtOffsetTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EObjectAtOffsetTestLanguageFacetConfiguration>>("org.eclipse.xtext.resource.EObjectAtOffsetTestLanguage");

	public EObjectAtOffsetTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.resource.EObjectAtOffsetTestLanguage", "EObjectAtOffsetTestLanguage");
		org.eclipse.xtext.resource.idea.lang.EObjectAtOffsetTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
