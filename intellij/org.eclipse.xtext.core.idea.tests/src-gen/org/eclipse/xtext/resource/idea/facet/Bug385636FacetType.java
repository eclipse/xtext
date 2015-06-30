package org.eclipse.xtext.resource.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug385636FacetType  extends AbstractFacetType<Bug385636FacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.resource.Bug385636";

	public static  FacetTypeId<Facet<Bug385636FacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug385636FacetConfiguration>>(TYPE_ID_STRING);

	public Bug385636FacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug385636");
		org.eclipse.xtext.resource.idea.lang.Bug385636Language.INSTANCE.injectMembers(this);
	}

}
