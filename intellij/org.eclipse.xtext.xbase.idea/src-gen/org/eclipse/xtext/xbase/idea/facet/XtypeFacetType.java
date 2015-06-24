package org.eclipse.xtext.xbase.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class XtypeFacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.xbase.Xtype";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public XtypeFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Xtype");
		org.eclipse.xtext.xbase.idea.lang.XtypeLanguage.INSTANCE.injectMembers(this);
	}

}
