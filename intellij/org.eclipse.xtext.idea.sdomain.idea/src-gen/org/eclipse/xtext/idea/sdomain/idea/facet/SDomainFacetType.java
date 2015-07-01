package org.eclipse.xtext.idea.sdomain.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class SDomainFacetType  extends AbstractFacetType<SDomainFacetConfiguration> {

	public static final FacetTypeId<Facet<SDomainFacetConfiguration>> TYPEID = new FacetTypeId<Facet<SDomainFacetConfiguration>>("org.eclipse.xtext.idea.sdomain.SDomain");

	public SDomainFacetType() {
		super(TYPEID, "org.eclipse.xtext.idea.sdomain.SDomain", "SDomain");
		org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage.INSTANCE.injectMembers(this);
	}

}
