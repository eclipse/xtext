package org.eclipse.xtext.parsetree.reconstr.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SimpleReconstrTestLanguageFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public SimpleReconstrTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "SimpleReconstrTestLanguage");
		org.eclipse.xtext.parsetree.reconstr.idea.lang.SimpleReconstrTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
