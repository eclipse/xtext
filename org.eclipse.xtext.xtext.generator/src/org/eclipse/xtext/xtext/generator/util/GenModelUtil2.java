/**
 * Copyright (c) 2011, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.util;

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
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2;
import com.google.common.base.Objects;
import com.google.common.base.Strings;

public class GenModelUtil2 {
	public static GenClass getGenClass(EClass cls, ResourceSet resourceSet) {
		return (GenClass) GenModelUtil2.getGenClassifier(cls, resourceSet);
	}

	public static GenClassifier getGenClassifier(EClassifier cls, ResourceSet resourceSet) {
		GenPackage genPackage = GenModelUtil2.getGenPackage(cls.getEPackage(), resourceSet);
		for (GenClassifier genCls : genPackage.getGenClassifiers()) {
			if (Objects.equal(cls.getName(), genCls.getEcoreClassifier().getName())) {
				return genCls;
			}
		}
		throw new RuntimeException("No GenClassifier named '" + cls.getName() + "' found in GenModel " + genPackage.eResource().getURI());
	}

	public static GenDataType getGenDataType(EDataType dt, ResourceSet resourceSet) {
		return (GenDataType) GenModelUtil2.getGenClassifier(dt, resourceSet);
	}

	public static GenEnum getGenEnum(EEnum en, ResourceSet resourceSet) {
		return (GenEnum) GenModelUtil2.getGenClassifier(en, resourceSet);
	}

	public static GenFeature getGenFeature(EStructuralFeature feature, ResourceSet resourceSet) {
		GenClass genCls = (GenClass) GenModelUtil2.getGenClassifier(feature.getEContainingClass(), resourceSet);
		for (GenFeature genFeat : genCls.getGenFeatures()) {
			if (Objects.equal(feature.getName(), genFeat.getEcoreFeature().getName())) {
				return genFeat;
			}
		}
		throw new RuntimeException("No GenFeature named '" + feature.getName() + "' found in GenClass '" + genCls + "' from GenModel " + genCls.eResource().getURI());
	}

	public static GenPackage getGenPackage(EPackage pkg, ResourceSet resourceSet) {
		String nsURI = pkg.getNsURI();
		String location = null;
		Resource packageResource = pkg.eResource();
		URI packageResourceUri = null;
		if (packageResource != null) {
			packageResourceUri = packageResource.getURI();
		}
		if (packageResourceUri != null) {
			location = pkg.eResource().getURI().toString();
		}
		Resource genModelResource = GenModelUtil2.getGenModelResource(location, nsURI, resourceSet);
		if (genModelResource != null) {
			for (EObject model : genModelResource.getContents()) {
				if (model instanceof GenModel) {
					GenPackage genPkg = ((GenModel) model).findGenPackage(pkg);
					if (genPkg != null) {
						genPkg.getEcorePackage().getEClassifiers();
						return genPkg;
					}
				}
			}
			throw new RuntimeException("No GenPackage for NsURI " + nsURI + " found in " + genModelResource.getURI());
		}
		throw new RuntimeException("No GenPackage for NsURI " + nsURI + ".");
	}

	public static Resource getGenModelResource(String locationInfo, String nsURI,
			ResourceSet resourceSet) {
		URI genModelURI = EcorePlugin.getEPackageNsURIToGenModelLocationMap(false).get(nsURI);
		if (genModelURI == null) {
			if (Objects.equal(EcorePackage.eNS_URI, nsURI)) { // If we really want to use the registered ecore ...
				return null; // look into the resource set to find a genpackage
								// for the given URI
			}
			for (Resource res : resourceSet.getResources()) {
				// We only look into the first level, as genmodels are usually
				// among the top level elements.
				// This is just to avoid traversing all eobjects in the resource
				// set.
				for (EObject obj : res.getContents()) {
					if (obj instanceof GenModel) {
						for (GenPackage genPackage : ((GenModel) obj).getGenPackages()) {
							if (Objects.equal(genPackage.getNSURI(), nsURI)) {
								return genPackage.eResource();
							}
						}
					}
				}
			}
			String message =
					"Could not find a GenModel for EPackage '" + nsURI +"'" + (Strings.isNullOrEmpty(locationInfo) ? "" : " from " + locationInfo) + ".\n" +
					"If the missing GenModel has been generated via " + EMFGeneratorFragment2.class.getSimpleName() + ", make sure to run it first in the workflow.\n" +
					"If you have a *.genmodel-file, make sure to register it via StandaloneSetup.registerGenModelFile(String).\n";
			throw new RuntimeException(message);
		}
		if (resourceSet == null) {
			throw new RuntimeException("There is no ResourceSet for EPackage '" + nsURI
					+ "'. Please make sure the EPackage has been loaded from a .ecore file and not from the generated Java file.");
		}
		Resource genModelResource = resourceSet.getResource(genModelURI, true);
		if (genModelResource == null) {
			throw new RuntimeException("Error loading GenModel " + genModelURI);
		}
		for (EObject content : genModelResource.getContents()) {
			if (content instanceof GenModel) {
				((GenModel) content).reconcile();
			}
		}
		return genModelResource;
	}

	public static String getPackageLiteral() {
		return "eINSTANCE";
	}

	public static String getIntLiteral(EClass clazz, EStructuralFeature feature,
			ResourceSet resourceSet) {
		return GenModelUtil2.getGenClass(clazz, resourceSet)
				.getFeatureID(GenModelUtil2.getGenFeature(feature, resourceSet));
	}

	public static String getIntLiteral(EClassifier classifier, ResourceSet resourceSet) {
		return GenModelUtil2.getGenClassifier(classifier, resourceSet).getClassifierID();
	}

	public static String getTypeLiteral(EClassifier classifier, ResourceSet resourceSet) {
		GenClassifier genClassifier = GenModelUtil2.getGenClassifier(classifier, resourceSet);
		if (genClassifier.getGenPackage().isLiteralsInterface()) {
			return "Literals." + genClassifier.getClassifierID();
		} else {
			return "eINSTANCE.get" + genClassifier.getClassifierAccessorName() + "()";
		}
	}

	public static String getFeatureLiteral(EStructuralFeature feature, ResourceSet resourceSet) {
		return GenModelUtil2.getFeatureLiteral(GenModelUtil2.getGenFeature(feature, resourceSet), resourceSet);
	}

	public static String getFeatureLiteral(GenFeature genFeature, ResourceSet resourceSet) {
		if (genFeature.getGenPackage().isLiteralsInterface()) {
			return "Literals." + genFeature.getGenClass().getFeatureID(genFeature);
		} else {
			return "eINSTANCE.get" + genFeature.getFeatureAccessorName() + "()";
		}
	}

	public static String getJavaTypeName(EClassifier classifier, ResourceSet resourceSet) {
		GenClassifier genClassifier = GenModelUtil2.getGenClassifier(classifier, resourceSet);
		if (genClassifier instanceof GenClass) {
			return ((GenClass) genClassifier).getQualifiedInterfaceName();
		} else {
			return ((GenDataType) genClassifier).getQualifiedInstanceClassName();
		}
	}

	public static String getGetAccessor(EStructuralFeature feature, ResourceSet resourceSet) {
		return GenModelUtil2.getGetAccessor(GenModelUtil2.getGenFeature(feature, resourceSet), resourceSet);
	}

	public static String getGetAccessor(GenFeature genFeature, ResourceSet resourceSet) {
		GenClass genClass = genFeature.getGenClass();
		if (genClass.isMapEntry()) {
			if (Objects.equal(genFeature, genClass.getMapEntryKeyFeature())) {
				return "getKey";
			}
			if (Objects.equal(genFeature, genClass.getMapEntryValueFeature())) {
				return "getValue";
			}
		}
		return genFeature.getGetAccessor();
	}
}
