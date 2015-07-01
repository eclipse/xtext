package org.eclipse.xtext.grammarinheritance.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class AbstractTestLanguageFacetType  extends AbstractFacetType<AbstractTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<AbstractTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractTestLanguageFacetConfiguration>>("org.eclipse.xtext.grammarinheritance.AbstractTestLanguage");

	public AbstractTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.grammarinheritance.AbstractTestLanguage", "AbstractTestLanguage");
		org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
