package org.eclipse.xtext.valueconverter.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug250313FacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.valueconverter.Bug250313";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public Bug250313FacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug250313");
		org.eclipse.xtext.valueconverter.idea.lang.Bug250313Language.INSTANCE.injectMembers(this);
	}

}
