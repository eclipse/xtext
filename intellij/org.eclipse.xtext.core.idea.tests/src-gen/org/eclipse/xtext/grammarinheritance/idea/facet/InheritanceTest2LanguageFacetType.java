package org.eclipse.xtext.grammarinheritance.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class InheritanceTest2LanguageFacetType  extends AbstractFacetType<InheritanceTest2LanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.grammarinheritance.InheritanceTest2Language";

	public static  FacetTypeId<Facet<InheritanceTest2LanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<InheritanceTest2LanguageFacetConfiguration>>(TYPE_ID_STRING);

	public InheritanceTest2LanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "InheritanceTest2Language");
		org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest2LanguageLanguage.INSTANCE.injectMembers(this);
	}

}
