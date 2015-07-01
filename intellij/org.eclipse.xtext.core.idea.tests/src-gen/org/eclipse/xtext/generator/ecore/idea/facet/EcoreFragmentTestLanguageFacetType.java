package org.eclipse.xtext.generator.ecore.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EcoreFragmentTestLanguageFacetType  extends AbstractFacetType<EcoreFragmentTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<EcoreFragmentTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EcoreFragmentTestLanguageFacetConfiguration>>("org.eclipse.xtext.generator.ecore.EcoreFragmentTestLanguage");

	public EcoreFragmentTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.generator.ecore.EcoreFragmentTestLanguage", "EcoreFragmentTestLanguage");
		org.eclipse.xtext.generator.ecore.idea.lang.EcoreFragmentTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
