package org.eclipse.xtext.xbase.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class XbaseFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.xbase.Xbase";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public XbaseFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Xbase");
		org.eclipse.xtext.xbase.idea.lang.XbaseLanguage.INSTANCE.injectMembers(this);
	}

}
