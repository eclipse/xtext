/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcorePackage;
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

	private final Map<Grammar, EClassifierInfos> parents;

	public List<EClassifierInfos> getParents() {
		return Lists.newArrayList(parents.values());
	}

	public EClassifierInfos() {
		infoMap = new LinkedHashMap<Triple<String, String, String>, EClassifierInfo>();
		parents = new LinkedHashMap<Grammar, EClassifierInfos>();
	}

	public void addParent(Grammar grammar, EClassifierInfos parent) {
		if (this.parents.put(grammar, parent) != null)
			throw new IllegalStateException();
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
		Grammar grammar = GrammarUtil.getGrammar(typeRef);
		EClassifierInfos parentInfos = parents.get(grammar);
		if (parentInfos != null)
			return parentInfos.getInfo(typeRef);
		return getInfo(typeRef.getMetamodel(), typeRef.getClassifier().getName());
	}

	public EClassifierInfo getInfoOrNull(TypeRef typeRef) {
		EClassifierInfo result = getInfo(typeRef);
		if (result != null)
			return result;
		for(EClassifierInfos parent: parents.values()) {
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
		for (EClassifierInfo info : infoMap.values()) {
			if (info.getEClassifier().equals(eClassifier))
				return info;
		}
		for(EClassifierInfos parent: parents.values()) {
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

		EClassifier compatibleType = EcoreUtil2.getCompatibleType(infoA.getEClassifier(), infoB.getEClassifier());

		return getInfoOrNull(compatibleType);
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

	public EClassifier getCompatibleTypeNameOf(Collection<EClassifier> classifiers, boolean useParent) {
		final Collection<EClassifierInfo> types = new HashSet<EClassifierInfo>();
		for (EClassifier classifier : classifiers) {
			final EClassifierInfo info = getInfoOrNull(classifier);
			if (info == null)
				return null;
			types.add(info);
		}

		final EClassifierInfo compatibleType = getCompatibleTypeOf(types);
		if (compatibleType != null)
			return compatibleType.getEClassifier();

		return EcorePackage.Literals.EOBJECT;
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
		for (EClass superType : subTypeInfo.getEClass().getESuperTypes()) {
			EClassifierInfo info = getInfoOrNull(superType);
			if (info != null && info instanceof EClassInfo)
				result.add((EClassInfo) info);
			else
				throw new UnexpectedClassInfoException(TransformationErrorCode.InvalidSupertype, subTypeInfo, info, null);
		}
		return result;
	}

}
