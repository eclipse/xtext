package org.eclipse.xtext.idea.example.entities.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EntitiesFacetType  extends AbstractFacetType<EntitiesFacetConfiguration> {

	public static final FacetTypeId<Facet<EntitiesFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EntitiesFacetConfiguration>>("org.eclipse.xtext.idea.example.entities.Entities");

	public EntitiesFacetType() {
		super(TYPEID, "org.eclipse.xtext.idea.example.entities.Entities", "Entities");
		org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage.INSTANCE.injectMembers(this);
	}

}
