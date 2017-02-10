/*******************************************************************************
 * Copyright (c) 2010-2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class XtendFacetType extends AbstractFacetType<XtendFacetConfiguration> {

	public static final FacetTypeId<Facet<XtendFacetConfiguration>> TYPEID = new FacetTypeId<Facet<XtendFacetConfiguration>>("org.eclipse.xtend.core.Xtend");

	public XtendFacetType() {
		super(TYPEID, "org.eclipse.xtend.core.Xtend", "Xtend");
		XtendLanguage.INSTANCE.injectMembers(this);
	}
}
