package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ComplexReconstrTestLanguageFacetType  extends AbstractFacetType<ComplexReconstrTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<ComplexReconstrTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ComplexReconstrTestLanguageFacetConfiguration>>("org.eclipse.xtext.parsetree.reconstr.ComplexReconstrTestLanguage");

	public ComplexReconstrTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parsetree.reconstr.ComplexReconstrTestLanguage", "ComplexReconstrTestLanguage");
		org.eclipse.xtext.parsetree.reconstr.idea.lang.ComplexReconstrTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
