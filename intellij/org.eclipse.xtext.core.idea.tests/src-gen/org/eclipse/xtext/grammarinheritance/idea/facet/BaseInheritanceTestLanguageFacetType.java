package org.eclipse.xtext.grammarinheritance.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class BaseInheritanceTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.grammarinheritance.BaseInheritanceTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public BaseInheritanceTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "BaseInheritanceTestLanguage");
		org.eclipse.xtext.grammarinheritance.idea.lang.BaseInheritanceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
