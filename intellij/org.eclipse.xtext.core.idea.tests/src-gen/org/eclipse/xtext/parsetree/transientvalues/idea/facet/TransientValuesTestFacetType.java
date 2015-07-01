package org.eclipse.xtext.parsetree.transientvalues.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class TransientValuesTestFacetType  extends AbstractFacetType<TransientValuesTestFacetConfiguration> {

	public static final FacetTypeId<Facet<TransientValuesTestFacetConfiguration>> TYPEID = new FacetTypeId<Facet<TransientValuesTestFacetConfiguration>>("org.eclipse.xtext.parsetree.transientvalues.TransientValuesTest");

	public TransientValuesTestFacetType() {
		super(TYPEID, "org.eclipse.xtext.parsetree.transientvalues.TransientValuesTest", "TransientValuesTest");
		org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestLanguage.INSTANCE.injectMembers(this);
	}

}
