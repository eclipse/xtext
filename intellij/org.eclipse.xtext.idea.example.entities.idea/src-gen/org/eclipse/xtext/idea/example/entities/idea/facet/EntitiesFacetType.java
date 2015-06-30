package org.eclipse.xtext.idea.example.entities.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EntitiesFacetType  extends AbstractFacetType<EntitiesFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.idea.example.entities.Entities";

	public static  FacetTypeId<Facet<EntitiesFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EntitiesFacetConfiguration>>(TYPE_ID_STRING);

	public EntitiesFacetType() {
		super(TYPEID, TYPE_ID_STRING, "Entities");
		org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage.INSTANCE.injectMembers(this);
	}

}
