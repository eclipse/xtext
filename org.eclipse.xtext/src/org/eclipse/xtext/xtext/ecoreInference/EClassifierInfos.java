/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xtext.ecoreInference.EClassifierInfo.EClassInfo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * A possible extension would be to normalize the type hierarchy and remove
 * redundant supertype references. We currently don't think thats necessary as
 * EMF handles multiple inheritance gracefully.
 *
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class EClassifierInfos {

	private final Map<Triple<String, String, String>, EClassifierInfo> infoMap;

	private final List<EClassifierInfos> parents;
	
	private final Grammar grammar;

	public List<EClassifierInfos> getParents() {
		return parents;
	}

	public EClassifierInfos(Grammar grammar) {
		this.grammar = grammar;
		infoMap = Maps.newLinkedHashMap();
		parents = Lists.newArrayList();
	}

	public void addParent(EClassifierInfos parent) {
		parents.add(parent);
	}

	public boolean addInfo(TypeRef typeRef, EClassifierInfo metatypeInfo) {
		if (typeRef.getMetamodel() == null || typeRef.getClassifier() == null)
			throw new NullPointerException();
		return addInfo(typeRef.getMetamodel(), typeRef.getClassifier().getName(), metatypeInfo);
	}

	public boolean addInfo(AbstractMetamodelDeclaration alias, String name, EClassifierInfo metatypeInfo) {
		return infoMap.put(getKey(alias, name), metatypeInfo) == null;
	}

	private Triple<String, String, String> getKey(AbstractMetamodelDeclaration metamodelDecl, String name) {
		if (metamodelDecl == null || name == null)
			throw new NullPointerException("metamodelDecl: " + metamodelDecl + " / name: " + name);
		return Tuples.create(metamodelDecl.getEPackage().getNsURI(), Strings.emptyIfNull(metamodelDecl.getAlias()), name);
	}

	public EClassifierInfo getInfo(TypeRef typeRef) {
		if (typeRef.getClassifier() == null)
			return null;
		EClassifierInfo result = getInfo(typeRef.getMetamodel(), typeRef.getClassifier().getName());
		if (result == null) {
			Grammar declaringGrammar = GrammarUtil.getGrammar(typeRef);
			if (grammar.equals(declaringGrammar))
				return result;
			for(EClassifierInfos parent: parents) {
				result = parent.getInfo(typeRef);
				if (result != null)
					return result;
			}
		}
		return result;
	}

	public EClassifierInfo getInfoOrNull(TypeRef typeRef) {
		EClassifierInfo result = getInfo(typeRef);
		if (result != null)
			return result;
		for(EClassifierInfos parent: parents) {
			result = parent.getInfoOrNull(typeRef);
			if (result != null)
				return result;
		}
		return null;
	}

	public EClassifierInfo getInfo(AbstractMetamodelDeclaration alias, String name) {
		Triple<String, String, String> key = getKey(alias, name);
		return getInfo(key);
	}

	private EClassifierInfo getInfo(Triple<String, String, String> qualifiedName) {
		return infoMap.get(qualifiedName);
	}

	public EClassifierInfo getInfo(EClassifier eClassifier) {
		for (EClassifierInfo info : infoMap.values())
			if (info.getEClassifier().equals(eClassifier))
				return info;
		throw new NullPointerException("cannot find type info for classifier '" + eClassifier.getName() + "'");
	}

	public EClassifierInfo getInfoOrNull(EClassifier eClassifier) {
		if (eClassifier == null)
			return null;
		for (EClassifierInfo info : infoMap.values()) {
			if (info.getEClassifier().equals(eClassifier))
				return info;
		}
		for(EClassifierInfos parent: parents) {
			EClassifierInfo result = parent.getInfoOrNull(eClassifier);
			if (result != null)
				return result;
		}
		return null;
	}

	private EClassifierInfo getCompatibleType(EClassifierInfo infoA, EClassifierInfo infoB) {
		if (infoA.equals(infoB))
			return infoA;

		if (infoA.getEClassifier() instanceof EDataType || infoB.getEClassifier() instanceof EDataType)
			throw new IllegalArgumentException(
					"Simple Datatypes (lexer rules or keywords) do not have a common supertype (" + infoA + ", "
							+ infoB + ")");

		EClassifier compatibleType = EcoreUtil2.getCompatibleType(infoA.getEClassifier(), infoB.getEClassifier(), grammar);

		return getInfoOrNull(compatibleType);
	}

	public EClassifierInfo getCompatibleTypeOf(Collection<EClassifierInfo> types) {
		Iterator<EClassifierInfo> i = types.iterator();
		if (!i.hasNext())
			throw new IllegalArgumentException("Empty set of types cannot have a compatible type.");

		EClassifierInfo result = i.next();
		while (i.hasNext())
			result = getCompatibleType(result, i.next());

		if (result == null) {
			return getInfoOrNull(GrammarUtil.findEObject(grammar));
		}
		return result;
	}

	public List<EClassInfo> getAllEClassInfos() {
		List<EClassInfo> result = new ArrayList<EClassInfo>();
		for (EClassifierInfo classifier : this.infoMap.values())
			if (classifier instanceof EClassInfo)
				result.add((EClassInfo) classifier);

		return Collections.unmodifiableList(result);
	}

	public List<EClassInfo> getSuperTypeInfos(EClassInfo subTypeInfo) throws UnexpectedClassInfoException {
		List<EClassInfo> result = new ArrayList<EClassInfo>();
		List<EClass> superTypes = subTypeInfo.getEClass().getESuperTypes();
		for (int i = 0; i < superTypes.size(); i++) {
			EClass superType = superTypes.get(i);
			if (superType.eIsProxy()) {
				URI proxyURI = EcoreUtil.getURI(superType);
				if (proxyURI.isPlatformResource()) {
					String platformString = proxyURI.toPlatformString(true);
					URI platformPluginURI = URI.createPlatformPluginURI(platformString, true).appendFragment(proxyURI.fragment());
					EObject secondAttempt = subTypeInfo.getEClass().eResource().getResourceSet().getEObject(platformPluginURI, true);
					if (secondAttempt instanceof EClass) {
						superType = (EClass) secondAttempt;
						superTypes.set(i, superType);
					}
				}
			}
			EClassifierInfo info = getInfoOrNull(superType);
			if (info != null) {
				if (info instanceof EClassInfo) {
					result.add((EClassInfo) info);
				} else {
					throw new UnexpectedClassInfoException(TransformationErrorCode.InvalidSupertype, subTypeInfo, info, null);
				}
			} else {
				if (superType.eIsProxy()) {
					throw new UnexpectedClassInfoException(TransformationErrorCode.InvalidSupertype, subTypeInfo, null, "Cannot load all supertypes of  '" + subTypeInfo.getEClass().getName() + "'");
				} else if (isPackageKnown(superType.getEPackage().getNsURI())) {
					throw new UnexpectedClassInfoException(TransformationErrorCode.InvalidSupertype, subTypeInfo, null, "Cannot find info for type '" + superType.getName() + "'");
				}
			}
		}
		return result;
	}
	
	private boolean isPackageKnown(String nsURI) {
		for (Triple<String, String, String> key : infoMap.keySet()) {
			if (key.getFirst().equals(nsURI))
				return true;
		}
		for(EClassifierInfos parent: parents) {
			if (parent.isPackageKnown(nsURI))
				return true;
		}
		return false;
	}

}
