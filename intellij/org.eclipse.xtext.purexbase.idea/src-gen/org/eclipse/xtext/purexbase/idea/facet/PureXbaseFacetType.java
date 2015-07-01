package org.eclipse.xtext.purexbase.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class PureXbaseFacetType  extends AbstractFacetType<PureXbaseFacetConfiguration> {

	public static final FacetTypeId<Facet<PureXbaseFacetConfiguration>> TYPEID = new FacetTypeId<Facet<PureXbaseFacetConfiguration>>("org.eclipse.xtext.purexbase.PureXbase");

	public PureXbaseFacetType() {
		super(TYPEID, "org.eclipse.xtext.purexbase.PureXbase", "PureXbase");
		org.eclipse.xtext.purexbase.idea.lang.PureXbaseLanguage.INSTANCE.injectMembers(this);
	}

}
