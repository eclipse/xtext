package org.eclipse.xtext.parser.bug419429.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug419429FacetType  extends AbstractFacetType<Bug419429FacetConfiguration> {

	public static final FacetTypeId<Facet<Bug419429FacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug419429FacetConfiguration>>("org.eclipse.xtext.parser.bug419429.Bug419429");

	public Bug419429FacetType() {
		super(TYPEID, "org.eclipse.xtext.parser.bug419429.Bug419429", "Bug419429");
		org.eclipse.xtext.parser.bug419429.idea.lang.Bug419429Language.INSTANCE.injectMembers(this);
	}

}
