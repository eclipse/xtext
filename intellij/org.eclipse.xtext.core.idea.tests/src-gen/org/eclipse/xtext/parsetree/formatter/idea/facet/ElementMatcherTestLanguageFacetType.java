package org.eclipse.xtext.parsetree.formatter.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ElementMatcherTestLanguageFacetType  extends AbstractFacetType<ElementMatcherTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<ElementMatcherTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ElementMatcherTestLanguageFacetConfiguration>>("org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage");

	public ElementMatcherTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage", "ElementMatcherTestLanguage");
		org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
