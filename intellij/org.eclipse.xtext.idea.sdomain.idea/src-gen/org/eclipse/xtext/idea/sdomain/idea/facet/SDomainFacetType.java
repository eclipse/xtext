package org.eclipse.xtext.idea.sdomain.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SDomainFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.idea.sdomain.SDomain";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public SDomainFacetType() {
		super(TYPEID, TYPE_ID_STRING, "SDomain");
		org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage.INSTANCE.injectMembers(this);
	}

}
