/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DeclaredMetamodelAccessFactory extends XtextSwitch<IDeclaredMetamodelAccess>{
	
	private static Logger log = Logger.getLogger(DeclaredMetamodelAccessFactory.class);
	
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
		final EPackage pack = loadEPackage(object);
		if (pack != null) {
			return new PackageBasedMetamodelAccess(pack);
		}
		return NullMetamodelAccess.INSTANCE;
	}
	
	EPackage loadEPackage(ReferencedMetamodel ref) {
		if (ref == null)
			throw new NullPointerException("ReferencedMetamodel was null");
		String uriAsString = ref.getUri();
		ResourceSet resourceSet = ref.eResource().getResourceSet();
		return loadEPackage(uriAsString, resourceSet);
	}

	EPackage loadEPackage(String resourceOrNsURI, ResourceSet resourceSet) {
		if (EPackage.Registry.INSTANCE.containsKey(resourceOrNsURI))
			return EPackage.Registry.INSTANCE.getEPackage(resourceOrNsURI);
		try {
			URI uri = URI.createURI(resourceOrNsURI);
			if (uri.fragment() == null) {
				Resource resource = resourceSet.getResource(uri, true);
				return (EPackage) resource.getContents().get(0);
			}
			else {
				return (EPackage) resourceSet.getEObject(uri, true);
			}
		} catch(RuntimeException ex) {
			log.trace("Cannot load package with URI '" + resourceOrNsURI + "'", ex);
			return null;
		}
	}
	

}
