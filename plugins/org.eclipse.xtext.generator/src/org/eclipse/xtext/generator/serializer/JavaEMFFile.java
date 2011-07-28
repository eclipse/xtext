/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.GenModelAccess;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class JavaEMFFile extends JavaFile {

	protected ResourceSet resourceSet;

	public JavaEMFFile(ResourceSet rs, String packageName) {
		super(packageName);
		this.resourceSet = rs;
	}

	public String getGetAccessor(EStructuralFeature feature) {
		return GenModelAccess.getGenFeature(feature, resourceSet).getGetAccessor();
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
		return imported(GenModelAccess.getGenClass(clazz, resourceSet).getQualifiedInterfaceName());
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
