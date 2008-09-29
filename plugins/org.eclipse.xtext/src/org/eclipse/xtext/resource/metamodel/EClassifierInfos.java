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
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.resource.metamodel.EClassifierInfo.EClassInfo;

/**
 * A possible extension would be to normalize the type hierarchy and remove
 * redundant supertype references. We currently don't think thats necessary as
 * EMF handles multiple inheritance gracefully.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class EClassifierInfos {

	private Map<String, EClassifierInfo> infoMap = new HashMap<String, EClassifierInfo>();

	public boolean addInfo(TypeRef typeRef, EClassifierInfo metatypeInfo) {
		return infoMap.put(GrammarUtil.getQualifiedName(typeRef), metatypeInfo) != metatypeInfo;
	}

	public boolean addInfo(String alias, String name, EClassifierInfo metatypeInfo) {
		return infoMap.put(GrammarUtil.getQualifiedName(alias, name), metatypeInfo) != metatypeInfo;
	}

	public EClassifierInfo getInfo(TypeRef typeRef) {
		return getInfo(GrammarUtil.getQualifiedName(typeRef));
	}

	public EClassifierInfo getInfo(String qualifiedName) {
		return infoMap.get(qualifiedName);
	}

	public EClassifierInfo getInfo(EClassifier eClassifier) {
		for (EClassifierInfo info : infoMap.values())
			if (info.getEClassifier().equals(eClassifier))
				return info;
		return null;
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

	private String getQualifiedNameFor(EClassifierInfo classifierInfo) {
		// lookup could be improved
		for (String key : infoMap.keySet()) {
			EClassifierInfo info = infoMap.get(key);
			if (info.equals(classifierInfo))
				return key;
		}
		return null;
	}

	public EClassifierInfo getCompatibleTypeOf(Collection<EClassifierInfo> types) {
		Iterator<EClassifierInfo> i = types.iterator();
		if (!i.hasNext())
			throw new IllegalArgumentException("Empty set of types cannot have a compatible type.");

		EClassifierInfo result = i.next();
		while (i.hasNext())
			result = getCompatibleType(result, i.next());

		return result;
	}
	
	@SuppressWarnings("unchecked")
	public EClassInfo getCompatibleTypeOf(Collection<EClassInfo> types) {
		Collection<EClassifierInfo> infos = (Collection<EClassifierInfo>)(Collection<?>)types;
		return (EClassInfo)getCompatibleTypeOf(infos);
	}

	public String getCompatibleTypeNameOf(Collection<String> typeNames) {
		Collection<EClassifierInfo> types = new HashSet<EClassifierInfo>();
		for (String typeName : typeNames)
			types.add(getInfo(typeName));

		EClassifierInfo compatibleType = getCompatibleTypeOf(types);
		if (compatibleType != null)
			return getQualifiedNameFor(compatibleType);
		else
			return "ecore::EObject";
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
