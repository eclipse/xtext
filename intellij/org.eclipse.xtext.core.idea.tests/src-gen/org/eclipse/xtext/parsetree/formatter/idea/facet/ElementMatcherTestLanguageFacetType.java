package org.eclipse.xtext.parsetree.formatter.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ElementMatcherTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public ElementMatcherTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "ElementMatcherTestLanguage");
		org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
