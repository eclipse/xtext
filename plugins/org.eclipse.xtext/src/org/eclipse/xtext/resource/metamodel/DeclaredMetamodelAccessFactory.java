/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DeclaredMetamodelAccessFactory extends XtextSwitch<IDeclaredMetamodelAccess>{
	
	public static IDeclaredMetamodelAccess getAccessTo(AbstractMetamodelDeclaration declaration) {
		return new DeclaredMetamodelAccessFactory().doSwitch(declaration);
	}

	@Override
	public IDeclaredMetamodelAccess caseAbstractMetamodelDeclaration(AbstractMetamodelDeclaration object) {
		return NullMetamodelAccess.INSTANCE;
	}

	@Override
	public IDeclaredMetamodelAccess caseGeneratedMetamodel(GeneratedMetamodel object) {
		final ResourceSet set = object.eResource().getResourceSet();
		for(Resource resource: set.getResources()) {
			for (EObject content: resource.getContents()) {
				if (content instanceof EPackage) {
					EPackage pack = (EPackage) content;
					if (pack.getNsURI().equals(object.getNsURI())) {
						return new PackageBasedMetamodelAccess((EPackage) content);	
					}
				}
			}
		}
		return NullMetamodelAccess.INSTANCE;
	}

	@Override
	public IDeclaredMetamodelAccess caseReferencedMetamodel(ReferencedMetamodel object) {
		try {
			final EPackage pack = GrammarUtil.loadEPackage(object);
			if (pack != null) {
				return new PackageBasedMetamodelAccess(pack);
			}
		}
		catch (RuntimeException ex) {
			if (ex.getCause() instanceof IOException) {
				return NullMetamodelAccess.INSTANCE;
			} else {
				throw ex;
			}
		}
		return NullMetamodelAccess.INSTANCE;
	}
	
	

}
