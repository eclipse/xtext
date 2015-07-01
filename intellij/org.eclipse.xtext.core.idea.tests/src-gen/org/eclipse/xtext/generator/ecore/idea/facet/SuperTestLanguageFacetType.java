package org.eclipse.xtext.generator.ecore.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SuperTestLanguageFacetType  extends AbstractFacetType<SuperTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<SuperTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SuperTestLanguageFacetConfiguration>>("org.eclipse.xtext.generator.ecore.SuperTestLanguage");

	public SuperTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.generator.ecore.SuperTestLanguage", "SuperTestLanguage");
		org.eclipse.xtext.generator.ecore.idea.lang.SuperTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
