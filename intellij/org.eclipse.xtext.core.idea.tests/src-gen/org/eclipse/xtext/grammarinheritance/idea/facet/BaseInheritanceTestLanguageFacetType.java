package org.eclipse.xtext.grammarinheritance.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class BaseInheritanceTestLanguageFacetType  extends AbstractFacetType<BaseInheritanceTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<BaseInheritanceTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<BaseInheritanceTestLanguageFacetConfiguration>>("org.eclipse.xtext.grammarinheritance.BaseInheritanceTestLanguage");

	public BaseInheritanceTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.grammarinheritance.BaseInheritanceTestLanguage", "BaseInheritanceTestLanguage");
		org.eclipse.xtext.grammarinheritance.idea.lang.BaseInheritanceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
