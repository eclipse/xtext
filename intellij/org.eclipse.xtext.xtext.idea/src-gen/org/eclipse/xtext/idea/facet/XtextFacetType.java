package org.eclipse.xtext.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class XtextFacetType  extends AbstractFacetType<XtextFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.Xtext";

	public static  FacetTypeId<Facet<XtextFacetConfiguration>> TYPEID = new FacetTypeId<Facet<XtextFacetConfiguration>>(TYPE_ID_STRING);

	public XtextFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Xtext");
		org.eclipse.xtext.idea.lang.XtextLanguage.INSTANCE.injectMembers(this);
	}

}
