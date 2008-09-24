/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TypeRef;

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

	public void addAll(EClassifierInfos classInfos) {
		infoMap.putAll(classInfos.infoMap);
	}

	private String getCompatibleTypeNameOf(String typeA, String typeB) {
		EClassifier classifierA = getInfo(typeA).getEClassifier();
		EClassifier classifierB = getInfo(typeB).getEClassifier();
		if (classifierA.equals(classifierB))
			return typeA;
		if (classifierA instanceof EDataType || classifierB instanceof EDataType)
			throw new IllegalArgumentException(
					"Simple Datatypes (lexer rules or keywords) do not have a common supertype (" + typeA + ", "
							+ typeB + ")");

		// TODO EClass commonSupertype = EcoreUtil2.getCommonCompatibleType((EClass) classifierA, (EClass) classifierB);
		EClass commonSupertype = classifierA.equals(classifierB) ? (EClass)classifierA : null;
		if(commonSupertype != null)
			return getQualifiedNameFor(commonSupertype);
		else
			return "ecore::EObject";
	}

	private String getQualifiedNameFor(EClass eClass) {
		// lookup could be improved
		for (String key : infoMap.keySet()) {
			EClassifierInfo info = infoMap.get(key);
			if (info.getEClassifier().equals(eClass))
				return key;
		}
		return null;
	}

	public String getCompatibleTypeNameOf(Collection<String> typeNames) {
		Iterator<String> i = typeNames.iterator();
		if (!i.hasNext())
			throw new IllegalArgumentException("Empty set of types cannot have a common super type.");

		String result = i.next();
		while (i.hasNext())
			result = getCompatibleTypeNameOf(result, i.next());

		return result;
	}

}
