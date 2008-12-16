/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.resource.metamodel.EClassifierInfo.EClassInfo;
import org.eclipse.xtext.util.Pair;

/**
 * A possible extension would be to normalize the type hierarchy and remove
 * redundant supertype references. We currently don't think thats necessary as
 * EMF handles multiple inheritance gracefully.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class EClassifierInfos {

	private Map<Pair<String, String>, EClassifierInfo> infoMap = new HashMap<Pair<String, String>, EClassifierInfo>();
	
	public boolean addInfo(TypeRef typeRef, EClassifierInfo metatypeInfo) {
		if (typeRef.getMetamodel() == null || typeRef.getType() == null)
			throw new NullPointerException();
		return addInfo(typeRef.getMetamodel(), typeRef.getType().getName(), metatypeInfo);
	}

	public boolean addInfo(AbstractMetamodelDeclaration alias, String name, EClassifierInfo metatypeInfo) {
		return infoMap.put(getKey(alias, name), metatypeInfo) == null;
	}

	private Pair<String, String> getKey(AbstractMetamodelDeclaration alias, String name) {
		if (alias == null || name == null)
			throw new NullPointerException();
		String uri = alias instanceof ReferencedMetamodel ? ((ReferencedMetamodel)alias).getUri() : ((GeneratedMetamodel) alias).getNsURI();
		return new Pair<String, String>(uri, name);
	}

	public EClassifierInfo getInfo(TypeRef typeRef) {
		if (typeRef.getType() == null)
			return null;
		if (typeRef.getMetamodel() == null)
			throw new NullPointerException();
		return getInfo(typeRef.getMetamodel(), typeRef.getType().getName());
	}
	
	EClassifierInfo getInfo(AbstractMetamodelDeclaration alias, String name) {
		return getInfo(getKey(alias, name));
	}

	private EClassifierInfo getInfo(Pair<String, String> qualifiedName) {
		return infoMap.get(qualifiedName);
	}

	public EClassifierInfo getInfo(EClassifier eClassifier) {
		for (EClassifierInfo info : infoMap.values())
			if (info.getEClassifier().getName().equals(eClassifier.getName()))
				return info;
		throw new NullPointerException("cannot find type info for classifier '" + eClassifier.getName() + "' in map " + infoMap);
	}

	public void addAll(EClassifierInfos classInfos) {
		infoMap.putAll(classInfos.infoMap);
	}

	private EClassifierInfo getCompatibleType(EClassifierInfo infoA, EClassifierInfo infoB) {
		if (infoA.equals(infoB))
			return infoA;

		if (infoA.getEClassifier() instanceof EDataType || infoB.getEClassifier() instanceof EDataType)
			throw new IllegalArgumentException(
					"Simple Datatypes (lexer rules or keywords) do not have a common supertype (" + infoA + ", "
							+ infoB + ")");

		EClassifier compatibleType = EcoreUtil2.getCompatibleType((EClass) infoA.getEClassifier(), (EClass) infoB
				.getEClassifier());
		return getInfo(compatibleType);
	}

//	private String getQualifiedNameFor(EClassifierInfo classifierInfo) {
//		// lookup could be improved
//		for (String key : infoMap.keySet()) {
//			EClassifierInfo info = infoMap.get(key);
//			if (info.equals(classifierInfo))
//				return key;
//		}
//		return null;
//	}

	public EClassifierInfo getCompatibleTypeOf(Collection<EClassifierInfo> types) {
		Iterator<EClassifierInfo> i = types.iterator();
		if (!i.hasNext())
			throw new IllegalArgumentException("Empty set of types cannot have a compatible type.");

		EClassifierInfo result = i.next();
		while (i.hasNext())
			result = getCompatibleType(result, i.next());

		return result;
	}
	
//	@SuppressWarnings("unchecked")
//	public EClassInfo getCompatibleTypeOf(Collection<EClassInfo> types) {
//		Collection<EClassifierInfo> infos = (Collection<EClassifierInfo>)(Collection<?>)types;
//		return (EClassInfo)getCompatibleTypeOf(infos);
//	}

	public EClassifier getCompatibleTypeNameOf(Collection<EClassifier> typeNames) {
		Collection<EClassifierInfo> types = new HashSet<EClassifierInfo>();
		for (EClassifier typeName : typeNames)
			types.add(getInfo(typeName));

		EClassifierInfo compatibleType = getCompatibleTypeOf(types);
		if (compatibleType != null)
			return compatibleType.getEClassifier();
		else
			return EcorePackage.Literals.EOBJECT;
	}

	public List<EClassInfo> getAllEClassInfos() {
		List<EClassInfo> result = new ArrayList<EClassInfo>();
		for (EClassifierInfo classifier : this.infoMap.values())
			if (classifier instanceof EClassInfo)
				result.add((EClassInfo) classifier);

		return Collections.unmodifiableList(result);
	}

	public List<EClassInfo> getSuperTypeInfos(EClassInfo subTypeInfo) {
		List<EClassInfo> result = new ArrayList<EClassInfo>();
		for (EClass superType : subTypeInfo.getEClass().getESuperTypes())
			result.add((EClassInfo) this.getInfo(superType));
		return result;
	}

}
