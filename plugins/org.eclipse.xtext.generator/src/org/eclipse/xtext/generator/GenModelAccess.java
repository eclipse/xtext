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
import org.eclipse.xtext.generator.ecore.EcoreGeneratorFragment;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.0
 */
public class GenModelAccess {

	public static GenClass getGenClass(EClass cls, ResourceSet resourceSet) {
		return (GenClass) getGenClassifier(cls, resourceSet);
	}

	public static GenClassifier getGenClassifier(EClassifier cls, ResourceSet resourceSet) {
		GenPackage genPackage = getGenPackage(cls.getEPackage(), resourceSet);
		for (GenClassifier genCls : genPackage.getGenClassifiers())
			if (cls.getName().equals(genCls.getEcoreClassifier().getName())) {
				return genCls;
			}
		throw new RuntimeException("No GenClassifier named '" + cls.getName() + "' found in GenModel "
				+ genPackage.eResource().getURI());
	}

	public static GenDataType getGenDataType(EDataType dt, ResourceSet resourceSet) {
		return (GenDataType) getGenClassifier(dt, resourceSet);
	}

	public static GenEnum getGenEnum(EEnum en, ResourceSet resourceSet) {
		return (GenEnum) getGenClassifier(en, resourceSet);
	}

	public static GenFeature getGenFeature(EStructuralFeature feature, ResourceSet resourceSet) {
		GenClass genCls = (GenClass) getGenClassifier(feature.getEContainingClass(), resourceSet);
		for (GenFeature genFeat : genCls.getGenFeatures())
			if (feature.getName().equals(genFeat.getEcoreFeature().getName())) {
				return genFeat;
			}
		throw new RuntimeException("No GenClassifier named '" + feature.getName() + "' found in GenClass '" + genCls
				+ "' from GenModel" + genCls.eResource().getURI());
	}

	public static String getGenIntLiteral(EClass clazz, EStructuralFeature feature, ResourceSet resourceSet) {
		GenFeature genFeature = getGenFeature(feature, resourceSet);
		GenClass genClass = getGenClass(clazz, resourceSet);
		return genClass.getGenPackage().getPackageInterfaceName() + "." + genClass.getFeatureID(genFeature);
	}

	public static String getGenIntLiteral(EClassifier classifier, ResourceSet resourceSet) {
		GenClassifier genClassifier = getGenClassifier(classifier, resourceSet);
		return genClassifier.getGenPackage().getPackageInterfaceName() + "." + genClassifier.getClassifierID();
	}

	public static GenPackage getGenPackage(EPackage pkg, ResourceSet resourceSet) {
		URI genModelURI = EcorePlugin.getEPackageNsURIToGenModelLocationMap().get(pkg.getNsURI());
		if (genModelURI == null) {
			String from = pkg.eResource() != null ? " from " + pkg.eResource().getURI() : "";
			StringBuilder buf = new StringBuilder();
			buf.append("Could not find a GenModel for EPackage '" + pkg.getNsURI() + "'" + from + "\n");
			buf.append("If the missing GenModel has been generated via " + EcoreGeneratorFragment.class.getSimpleName());
			buf.append(" make sure to run it first in the workflow.\n");
			buf.append("If you have a *.genmodel-file, make sure to register it via StandaloneSetup.registerGenModelFile(String)");
			throw new RuntimeException(buf.toString());
		}
		if (resourceSet == null)
			throw new RuntimeException("There is no ResourceSet for EPackage '" + pkg.getNsURI() + "'. "
					+ "Please make sure the EPackage has been loaded from a .ecore file "
					+ "and not from the generated Java file.");
		Resource genModelResource = resourceSet.getResource(genModelURI, true);
		if (genModelResource == null)
			throw new RuntimeException("Error loading GenModel " + genModelURI);
		for (EObject model : genModelResource.getContents())
			if (model instanceof GenModel) {
				GenPackage genPkg = ((GenModel) model).findGenPackage(pkg);
				if (genPkg != null) {
					genPkg.getEcorePackage().getEClassifiers();
					return genPkg;
				}
			}
		throw new RuntimeException("No GenPackage for NsURI " + pkg.getNsURI() + " found in " + genModelURI);
	}

	public static String getGenTypeLiteral(EClassifier classifier, ResourceSet resourceSet) {
		GenClassifier genClassifier = getGenClassifier(classifier, resourceSet);
		String pkg = genClassifier.getGenPackage().getPackageInterfaceName();
		String id = genClassifier.getClassifierID();
		return pkg + ".Literals." + id;
	}

	public static String getGenTypeLiteral(EPackage pkg, ResourceSet resourceSet) {
		return getGenPackage(pkg, resourceSet).getPackageInterfaceName() + ".eINSTANCE";
	}

	public static String getGenTypeLiteral(EStructuralFeature feature, ResourceSet resourceSet) {
		GenFeature genFeature = getGenFeature(feature, resourceSet);
		String pkg = genFeature.getGenPackage().getPackageInterfaceName();
		String id = genFeature.getGenClass().getFeatureID(genFeature);
		return pkg + ".Literals." + id;
	}

}
