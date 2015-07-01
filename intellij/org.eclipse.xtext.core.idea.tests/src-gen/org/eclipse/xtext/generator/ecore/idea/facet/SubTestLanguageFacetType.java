package org.eclipse.xtext.generator.ecore.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SubTestLanguageFacetType  extends AbstractFacetType<SubTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<SubTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SubTestLanguageFacetConfiguration>>("org.eclipse.xtext.generator.ecore.SubTestLanguage");

	public SubTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.generator.ecore.SubTestLanguage", "SubTestLanguage");
		org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
