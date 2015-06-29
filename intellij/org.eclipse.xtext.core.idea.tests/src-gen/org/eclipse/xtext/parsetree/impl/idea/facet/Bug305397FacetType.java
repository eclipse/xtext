package org.eclipse.xtext.parsetree.impl.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug305397FacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parsetree.impl.Bug305397";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public Bug305397FacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug305397");
		org.eclipse.xtext.parsetree.impl.idea.lang.Bug305397Language.INSTANCE.injectMembers(this);
	}

}
