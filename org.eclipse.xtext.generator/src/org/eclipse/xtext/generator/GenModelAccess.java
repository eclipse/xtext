/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.ecore.EMFGeneratorFragment;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.0
 */
@Deprecated(forRemoval = true)
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
		throw new RuntimeException("No GenFeature named '" + feature.getName() + "' found in GenClass '" + genCls
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
		String nsURI = pkg.getNsURI();
		String location = null;
		if (pkg.eResource() != null && pkg.eResource().getURI() != null)
			location = pkg.eResource().getURI().toString();
		Resource genModelResource = getGenModelResource(location, nsURI, resourceSet);
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
	
	/**
	 * @since 2.1
	 */
	@Deprecated(forRemoval = true)
	public static Resource getGenModelResource(String locationInfo, String nsURI, ResourceSet resourceSet) {
		URI genModelURI = EcorePlugin.getEPackageNsURIToGenModelLocationMap(false).get(nsURI);
		if (genModelURI == null) {
			if (EcorePackage.eNS_URI.equals(nsURI)) // if we really want to use the registered ecore ...
				return null;
			
			// look into the resource set to find a genpackage for the given URI
			for (Resource res: resourceSet.getResources()) {
				
				// we only look into the first level, as genmodels are usually among the top level elements.
				// this just to avoid traversing all eobjects in the resource set.
				for (EObject obj : res.getContents()) {
					if (obj instanceof GenModel) {
						for (GenPackage genPackage:((GenModel) obj).getGenPackages()) {
							if (genPackage.getNSURI().equals(nsURI)) {
								return genPackage.eResource();
							}
						}
					}
				}
			}
			
			StringBuilder buf = new StringBuilder();
			if (locationInfo != null && locationInfo.length() > 0)
				locationInfo = " from " + locationInfo; 
			else 
				locationInfo = "";
			buf.append("Could not find a GenModel for EPackage '").append(nsURI).append("'").append(locationInfo).append("\n");
			buf.append("If the missing GenModel has been generated via " + EMFGeneratorFragment.class.getSimpleName() + " or " + 
					org.eclipse.xtext.generator.ecore.EcoreGeneratorFragment.class.getSimpleName());
			buf.append(" make sure to run it first in the workflow.\n");
			buf.append("If you have a *.genmodel-file, make sure to register it via StandaloneSetup.registerGenModelFile(String)");
			throw new RuntimeException(buf.toString());
		}
		if (resourceSet == null)
			throw new RuntimeException("There is no ResourceSet for EPackage '" + nsURI + "'. "
					+ "Please make sure the EPackage has been loaded from a .ecore file "
					+ "and not from the generated Java file.");
		Resource genModelResource = resourceSet.getResource(genModelURI, true);
		if (genModelResource == null)
			throw new RuntimeException("Error loading GenModel " + genModelURI);
		for(EObject content: genModelResource.getContents()) {
			if (content instanceof GenModel)
				((GenModel) content).reconcile();
		}
		return genModelResource;
	}

	public static String getGenTypeLiteral(EClassifier classifier, ResourceSet resourceSet) {
		// inspired by org.eclipse.emf.codegen.ecore.genmodel.impl.GenClassifierImpl.getQualifiedClassifierAccessor()
		GenClassifier genClassifier = getGenClassifier(classifier, resourceSet);
		String pkg = genClassifier.getGenPackage().getPackageInterfaceName();
		if (genClassifier.getGenPackage().isLiteralsInterface())
			return pkg + ".Literals." + genClassifier.getClassifierID();
		else
			return pkg + ".eINSTANCE.get" + genClassifier.getClassifierAccessorName() + "()";
	}

	public static String getGenTypeLiteral(EPackage pkg, ResourceSet resourceSet) {
		return getGenPackage(pkg, resourceSet).getPackageInterfaceName() + ".eINSTANCE";
	}

	public static String getGenTypeLiteral(EStructuralFeature feature, ResourceSet resourceSet) {
		// inspired by org.eclipse.emf.codegen.ecore.genmodel.impl.GenFeatureImpl.getQualifiedFeatureAccessor()
		GenFeature genFeature = getGenFeature(feature, resourceSet);
		String pkg = genFeature.getGenPackage().getPackageInterfaceName();
		if (genFeature.getGenPackage().isLiteralsInterface())
			return pkg + ".Literals." + genFeature.getGenClass().getFeatureID(genFeature);
		else
			return pkg + ".eINSTANCE.get" + genFeature.getFeatureAccessorName() + "()";
	}
	
	/**
	 * @since 2.1
	 */
	public static String getJavaTypeName(EClassifier classifier, ResourceSet resourceSet) {
		GenClassifier genClassifier = getGenClassifier(classifier, resourceSet);
		if (genClassifier instanceof GenClass) {
			return ((GenClass) genClassifier).getQualifiedInterfaceName();
		} else {
			return ((GenDataType) genClassifier).getQualifiedInstanceClassName();
		}
	}

}
