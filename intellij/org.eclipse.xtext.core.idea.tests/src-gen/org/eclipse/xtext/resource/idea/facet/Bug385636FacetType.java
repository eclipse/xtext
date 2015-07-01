package org.eclipse.xtext.resource.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug385636FacetType  extends AbstractFacetType<Bug385636FacetConfiguration> {

	public static final FacetTypeId<Facet<Bug385636FacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug385636FacetConfiguration>>("org.eclipse.xtext.resource.Bug385636");

	public Bug385636FacetType() {
		super(TYPEID, "org.eclipse.xtext.resource.Bug385636", "Bug385636");
		org.eclipse.xtext.resource.idea.lang.Bug385636Language.INSTANCE.injectMembers(this);
	}

}
