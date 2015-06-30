package org.eclipse.xtend.core.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class XtendFacetType  extends AbstractFacetType<XtendFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtend.core.Xtend";

	public static  FacetTypeId<Facet<XtendFacetConfiguration>> TYPEID = new FacetTypeId<Facet<XtendFacetConfiguration>>(TYPE_ID_STRING);

	public XtendFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Xtend");
		org.eclipse.xtend.core.idea.lang.XtendLanguage.INSTANCE.injectMembers(this);
	}

}
