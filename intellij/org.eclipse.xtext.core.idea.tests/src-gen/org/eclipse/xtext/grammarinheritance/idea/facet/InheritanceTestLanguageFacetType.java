package org.eclipse.xtext.grammarinheritance.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class InheritanceTestLanguageFacetType  extends AbstractFacetType<InheritanceTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<InheritanceTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<InheritanceTestLanguageFacetConfiguration>>("org.eclipse.xtext.grammarinheritance.InheritanceTestLanguage");

	public InheritanceTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.grammarinheritance.InheritanceTestLanguage", "InheritanceTestLanguage");
		org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
