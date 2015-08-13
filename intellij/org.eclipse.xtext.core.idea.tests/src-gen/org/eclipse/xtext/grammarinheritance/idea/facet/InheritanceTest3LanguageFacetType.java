package org.eclipse.xtext.grammarinheritance.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class InheritanceTest3LanguageFacetType  extends AbstractFacetType<InheritanceTest3LanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<InheritanceTest3LanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<InheritanceTest3LanguageFacetConfiguration>>("org.eclipse.xtext.grammarinheritance.InheritanceTest3Language");

	public InheritanceTest3LanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.grammarinheritance.InheritanceTest3Language", "InheritanceTest3Language");
		org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest3LanguageLanguage.INSTANCE.injectMembers(this);
	}

}
