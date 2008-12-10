/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.impl.SimpleCachingScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextMetamodelReferenceScope extends SimpleCachingScope {

	public XtextMetamodelReferenceScope(Resource resource, EClass type) {
		super(IScope.NULLSCOPE, resource, type, false);
	}

	@Override
	protected String getNameFeature(EClass type) {
		if (AbstractMetamodelDeclaration.class.isAssignableFrom(type.getInstanceClass())) {
			return XtextPackage.eINSTANCE.getAbstractMetamodelDeclaration_Alias().getName();
		}
		return super.getNameFeature(type);
	}
	
}
