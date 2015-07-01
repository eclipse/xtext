package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class ComplexReconstrTestLanguageFacetType  extends AbstractFacetType<ComplexReconstrTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parsetree.reconstr.ComplexReconstrTestLanguage";

	public static  FacetTypeId<Facet<ComplexReconstrTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<ComplexReconstrTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public ComplexReconstrTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "ComplexReconstrTestLanguage");
		org.eclipse.xtext.parsetree.reconstr.idea.lang.ComplexReconstrTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
