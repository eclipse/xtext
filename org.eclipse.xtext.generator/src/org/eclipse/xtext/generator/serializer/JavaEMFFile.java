/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.GenModelAccess;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public class JavaEMFFile extends JavaFile {

	protected final ResourceSet resourceSet;

	public JavaEMFFile(ResourceSet rs, String packageName, String fileHeader) {
		super(packageName, fileHeader);
		this.resourceSet = rs;
	}
	
	public JavaEMFFile(ResourceSet rs, String packageName) {
		this(rs, packageName, null);
	}

	public String getEObjectCast(EClass eClass) {
		GenClass genClass = GenModelAccess.getGenClass(eClass, resourceSet);
		if (genClass.isEObjectExtension())
			return "";
		return "(" + imported(EObject.class) + ")";
	}

	public String getGetAccessor(EStructuralFeature feature) {
		GenFeature genFeature = GenModelAccess.getGenFeature(feature, resourceSet);
		GenClass genClass = genFeature.getGenClass();
		if (genClass.isMapEntry()) {
			if (genFeature == genClass.getMapEntryKeyFeature())
				return "getKey";
			if (genFeature == genClass.getMapEntryValueFeature())
				return "getValue";
		}
		return genFeature.getGetAccessor();
	}

	public String importedGenIntLiteral(EClass clazz, EStructuralFeature feature) {
		importedGenTypeName(clazz.getEPackage());
		return GenModelAccess.getGenIntLiteral(clazz, feature, resourceSet);
	}

	public String importedGenIntLiteral(EClassifier classifier) {
		importedGenTypeName(classifier.getEPackage());
		return GenModelAccess.getGenIntLiteral(classifier, resourceSet);
	}

	public String importedGenTypeLiteral(EClassifier classifier) {
		importedGenTypeName(classifier.getEPackage());
		return GenModelAccess.getGenTypeLiteral(classifier, resourceSet);
	}

	public String importedGenTypeLiteral(EPackage pkg) {
		importedGenTypeName(pkg);
		return GenModelAccess.getGenTypeLiteral(pkg, resourceSet);
	}

	public String importedGenTypeLiteral(EStructuralFeature feature) {
		importedGenTypeName(feature.getEContainingClass().getEPackage());
		return GenModelAccess.getGenTypeLiteral(feature, resourceSet);
	}

	public String importedGenTypeName(EClass clazz) {
		GenClass gc = GenModelAccess.getGenClass(clazz, resourceSet);
		if (gc.isMapEntry()) {
			String entryType = imported(BasicEMap.Entry.class);
			return entryType + "<?, ?>";
		}
		return imported(gc.getQualifiedInterfaceName());
	}

	public String importedGenTypeName(EClassifier cls) {
		if (cls instanceof EClass)
			return importedGenTypeName((EClass) cls);
		else if (cls instanceof EDataType)
			return importedGenTypeName((EDataType) cls);
		throw new RuntimeException("Unknown Type: " + cls.eClass().getName());
	}

	public String importedGenTypeName(EDataType dataType) {
		return imported(GenModelAccess.getGenDataType(dataType, resourceSet).getQualifiedInstanceClassName());
	}

	public String importedGenTypeName(EPackage pkg) {
		return imported(GenModelAccess.getGenPackage(pkg, resourceSet).getQualifiedPackageInterfaceName());
	}

}
