package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SimpleReconstrTestLanguageFacetType  extends AbstractFacetType<SimpleReconstrTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<SimpleReconstrTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SimpleReconstrTestLanguageFacetConfiguration>>("org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage");

	public SimpleReconstrTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage", "SimpleReconstrTestLanguage");
		org.eclipse.xtext.parsetree.reconstr.idea.lang.SimpleReconstrTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
