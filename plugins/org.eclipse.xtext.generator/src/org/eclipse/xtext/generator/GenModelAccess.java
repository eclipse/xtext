/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.0
 */
public class GenModelAccess {

	public static GenClass getGenClass(EClass cls) {
		return (GenClass) getGenClassifier(cls);
	}

	public static GenClassifier getGenClassifier(EClassifier cls) {
		GenPackage genPackage = getGenPackage(cls.getEPackage());
		for (GenClassifier genCls : genPackage.getGenClassifiers())
			if (cls.getName().equals(genCls.getEcoreClassifier().getName())) {
				return genCls;
			}
		throw new RuntimeException("No GenClassifier named '" + cls.getName() + "' found in GenModel "
				+ genPackage.eResource().getURI());
	}

	public static GenDataType getGenDataType(EDataType dt) {
		return (GenDataType) getGenClassifier(dt);
	}

	public static GenEnum getGenEnum(EEnum en) {
		return (GenEnum) getGenClassifier(en);
	}

	public static GenFeature getGenFeature(EStructuralFeature feature) {
		GenClass genCls = (GenClass) getGenClassifier(feature.getEContainingClass());
		for (GenFeature genFeat : genCls.getGenFeatures())
			if (feature.getName().equals(genFeat.getEcoreFeature().getName())) {
				return genFeat;
			}
		throw new RuntimeException("No GenClassifier named '" + feature.getName() + "' found in GenClass '" + genCls
				+ "' from GenModel" + genCls.eResource().getURI());
	}

	public static String getGenIntLiteral(EClass clazz, EStructuralFeature feature) {
		GenFeature genFeature = getGenFeature(feature);
		GenClass genClass = getGenClass(clazz);
		return genClass.getGenPackage().getPackageInterfaceName() + "." + genClass.getFeatureID(genFeature);
	}

	public static String getGenIntLiteral(EClassifier classifier) {
		GenClassifier genClassifier = getGenClassifier(classifier);
		return genClassifier.getGenPackage().getPackageInterfaceName() + "." + genClassifier.getClassifierID();
	}

	public static GenPackage getGenPackage(EPackage pkg) {
		URI genModelURI = EcorePlugin.getEPackageNsURIToGenModelLocationMap().get(pkg.getNsURI());
		if (genModelURI == null)
			throw new RuntimeException("No GenModel for EPackage '" + pkg.getNsURI() + "' is registered.");
		ResourceSet resourceSet = pkg.eResource().getResourceSet();
		if (resourceSet == null)
			throw new RuntimeException("There is no ResourceSet for EPackage '" + pkg.getNsURI() + "'. "
					+ "Please make sure the EPackage has been loaded from a .ecore file "
					+ "and not from the generated Java file.");
		Resource genModelResource = resourceSet.getResource(genModelURI, true);
		if (genModelResource == null)
			throw new RuntimeException("Error loading GenModel " + genModelURI);
		for (EObject model : genModelResource.getContents())
			if (model instanceof GenModel)
				for (GenPackage genPkg : ((GenModel) model).getGenPackages())
					if (pkg.getNsURI().equals(genPkg.getEcorePackage().getNsURI())) {
						return genPkg;
					}
		throw new RuntimeException("No GenPackage for NsURI " + pkg.getNsURI() + " found in " + genModelURI);
	}

	public static String getGenTypeLiteral(EClassifier classifier) {
		GenClassifier genClassifier = getGenClassifier(classifier);
		String pkg = genClassifier.getGenPackage().getPackageInterfaceName();
		String id = genClassifier.getClassifierID();
		return pkg + ".Literals." + id;
	}

	public static String getGenTypeLiteral(EPackage pkg) {
		return getGenPackage(pkg).getPackageInterfaceName() + ".eINSTANCE";
	}

	public static String getGenTypeLiteral(EStructuralFeature feature) {
		GenFeature genFeature = getGenFeature(feature);
		String pkg = genFeature.getGenPackage().getPackageInterfaceName();
		String id = genFeature.getGenClass().getFeatureID(genFeature);
		return pkg + ".Literals." + id;
	}

}
