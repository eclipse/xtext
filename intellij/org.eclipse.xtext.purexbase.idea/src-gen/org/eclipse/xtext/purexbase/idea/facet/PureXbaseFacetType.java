package org.eclipse.xtext.purexbase.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class PureXbaseFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.purexbase.PureXbase";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public PureXbaseFacetType() {
		super(TYPEID, TYPE_ID_STRING, "PureXbase");
		org.eclipse.xtext.purexbase.idea.lang.PureXbaseLanguage.INSTANCE.injectMembers(this);
	}

}
