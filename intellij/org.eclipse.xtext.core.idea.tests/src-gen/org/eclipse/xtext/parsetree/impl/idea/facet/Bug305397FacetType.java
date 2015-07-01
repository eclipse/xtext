package org.eclipse.xtext.parsetree.impl.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug305397FacetType  extends AbstractFacetType<Bug305397FacetConfiguration> {

	public static final FacetTypeId<Facet<Bug305397FacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug305397FacetConfiguration>>("org.eclipse.xtext.parsetree.impl.Bug305397");

	public Bug305397FacetType() {
		super(TYPEID, "org.eclipse.xtext.parsetree.impl.Bug305397", "Bug305397");
		org.eclipse.xtext.parsetree.impl.idea.lang.Bug305397Language.INSTANCE.injectMembers(this);
	}

}
