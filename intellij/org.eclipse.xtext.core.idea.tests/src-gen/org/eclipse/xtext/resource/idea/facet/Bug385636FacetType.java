package org.eclipse.xtext.resource.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug385636FacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.resource.Bug385636";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public Bug385636FacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug385636");
		org.eclipse.xtext.resource.idea.lang.Bug385636Language.INSTANCE.injectMembers(this);
	}

}
