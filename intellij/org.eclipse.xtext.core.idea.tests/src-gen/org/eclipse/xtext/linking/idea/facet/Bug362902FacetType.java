package org.eclipse.xtext.linking.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug362902FacetType  extends AbstractFacetType<Bug362902FacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.linking.Bug362902";

	public static  FacetTypeId<Facet<Bug362902FacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug362902FacetConfiguration>>(TYPE_ID_STRING);

	public Bug362902FacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug362902");
		org.eclipse.xtext.linking.idea.lang.Bug362902Language.INSTANCE.injectMembers(this);
	}

}
