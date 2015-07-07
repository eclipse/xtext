package org.eclipse.xtext.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class XtextFacetType  extends AbstractFacetType<XtextFacetConfiguration> {

	public static final FacetTypeId<Facet<XtextFacetConfiguration>> TYPEID = new FacetTypeId<Facet<XtextFacetConfiguration>>("org.eclipse.xtext.Xtext");

	public XtextFacetType() {
		super(TYPEID, "org.eclipse.xtext.Xtext", "Xtext");
		org.eclipse.xtext.idea.lang.XtextLanguage.INSTANCE.injectMembers(this);
	}

}
