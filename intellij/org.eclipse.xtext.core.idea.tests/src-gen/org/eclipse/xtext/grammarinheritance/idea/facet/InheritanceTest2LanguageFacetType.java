package org.eclipse.xtext.grammarinheritance.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class InheritanceTest2LanguageFacetType  extends AbstractFacetType<InheritanceTest2LanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<InheritanceTest2LanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<InheritanceTest2LanguageFacetConfiguration>>("org.eclipse.xtext.grammarinheritance.InheritanceTest2Language");

	public InheritanceTest2LanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.grammarinheritance.InheritanceTest2Language", "InheritanceTest2Language");
		org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest2LanguageLanguage.INSTANCE.injectMembers(this);
	}

}
