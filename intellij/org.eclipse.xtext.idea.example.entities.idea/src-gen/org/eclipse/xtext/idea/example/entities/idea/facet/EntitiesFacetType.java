/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.example.entities.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class EntitiesFacetType extends AbstractFacetType<EntitiesFacetConfiguration> {

	public static final FacetTypeId<Facet<EntitiesFacetConfiguration>> TYPEID = new FacetTypeId<Facet<EntitiesFacetConfiguration>>("org.eclipse.xtext.idea.example.entities.Entities");

	public EntitiesFacetType() {
		super(TYPEID, "org.eclipse.xtext.idea.example.entities.Entities", "Entities");
		EntitiesLanguage.INSTANCE.injectMembers(this);
	}
}
