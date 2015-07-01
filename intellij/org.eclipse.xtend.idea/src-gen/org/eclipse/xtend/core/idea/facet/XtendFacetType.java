package org.eclipse.xtend.core.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class XtendFacetType  extends AbstractFacetType<XtendFacetConfiguration> {

	public static final FacetTypeId<Facet<XtendFacetConfiguration>> TYPEID = new FacetTypeId<Facet<XtendFacetConfiguration>>("org.eclipse.xtend.core.Xtend");

	public XtendFacetType() {
		super(TYPEID, "org.eclipse.xtend.core.Xtend", "Xtend");
		org.eclipse.xtend.core.idea.lang.XtendLanguage.INSTANCE.injectMembers(this);
	}

}
