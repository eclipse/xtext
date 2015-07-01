package org.eclipse.xtext.valueconverter.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class Bug250313FacetType  extends AbstractFacetType<Bug250313FacetConfiguration> {

	public static final FacetTypeId<Facet<Bug250313FacetConfiguration>> TYPEID = new FacetTypeId<Facet<Bug250313FacetConfiguration>>("org.eclipse.xtext.valueconverter.Bug250313");

	public Bug250313FacetType() {
		super(TYPEID, "org.eclipse.xtext.valueconverter.Bug250313", "Bug250313");
		org.eclipse.xtext.valueconverter.idea.lang.Bug250313Language.INSTANCE.injectMembers(this);
	}

}
