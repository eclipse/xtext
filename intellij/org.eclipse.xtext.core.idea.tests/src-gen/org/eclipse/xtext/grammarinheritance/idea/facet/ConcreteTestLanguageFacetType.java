package org.eclipse.xtext.grammarinheritance.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ConcreteTestLanguageFacetType  extends AbstractFacetType<ConcreteTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<ConcreteTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ConcreteTestLanguageFacetConfiguration>>("org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage");

	public ConcreteTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage", "ConcreteTestLanguage");
		org.eclipse.xtext.grammarinheritance.idea.lang.ConcreteTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
