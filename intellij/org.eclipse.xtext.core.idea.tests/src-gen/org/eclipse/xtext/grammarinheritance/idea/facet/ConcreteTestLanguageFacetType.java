package org.eclipse.xtext.grammarinheritance.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ConcreteTestLanguageFacetType  extends AbstractFacetType<ConcreteTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage";

	public static  FacetTypeId<Facet<ConcreteTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ConcreteTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public ConcreteTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "ConcreteTestLanguage");
		org.eclipse.xtext.grammarinheritance.idea.lang.ConcreteTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
