package org.eclipse.xtext.grammarinheritance.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class AbstractTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.grammarinheritance.AbstractTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public AbstractTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "AbstractTestLanguage");
		org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
