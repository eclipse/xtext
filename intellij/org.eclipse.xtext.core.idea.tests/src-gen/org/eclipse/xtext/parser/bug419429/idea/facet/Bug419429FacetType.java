package org.eclipse.xtext.parser.bug419429.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug419429FacetType  extends AbstractFacetType<AbstractFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parser.bug419429.Bug419429";

	public static  FacetTypeId<Facet<AbstractFacetConfiguration>> TYPEID = new FacetTypeId<Facet<AbstractFacetConfiguration>>(TYPE_ID_STRING);

	public Bug419429FacetType() {
		super(TYPEID, TYPE_ID_STRING, "Bug419429");
		org.eclipse.xtext.parser.bug419429.idea.lang.Bug419429Language.INSTANCE.injectMembers(this);
	}

}
