package org.eclipse.xtext.parsetree.transientvalues.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class TransientValuesTestFacetType  extends AbstractFacetType<TransientValuesTestFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parsetree.transientvalues.TransientValuesTest";

	public static  FacetTypeId<Facet<TransientValuesTestFacetConfiguration>> TYPEID = new FacetTypeId<Facet<TransientValuesTestFacetConfiguration>>(TYPE_ID_STRING);

	public TransientValuesTestFacetType() {
		super(TYPEID, TYPE_ID_STRING, "TransientValuesTest");
		org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestLanguage.INSTANCE.injectMembers(this);
	}

}
