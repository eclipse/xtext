/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class KnownTypesScope extends AbstractScope {
	
	private final List<? extends JvmType> types;
	private final AbstractScope parent;

	public KnownTypesScope(List<? extends JvmType> types, AbstractScope parent) {
		this.types = types;
		this.parent = parent;
	}
	
	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		IEObjectDescription result = doGetSingleElement(name);
		if (result != null) {
			return result;
		}
		return parent.getSingleElement(name);
	}
	
	protected IEObjectDescription doGetSingleElement(QualifiedName name) {
		JvmType result = null;
		int index = -1;
		String firstSegment = name.getFirstSegment();
		int dollar = firstSegment.indexOf('$');
		if (dollar > 0) {
			firstSegment = firstSegment.substring(0, dollar);
		}
		for(int i = 0; i < types.size(); i++) {
			JvmType type = types.get(i);
			JvmType exactMatch = getExactMatch(type, index, name);
			if (exactMatch != null)
				return EObjectDescription.create(name, exactMatch);
			if (isMatch(i, type, firstSegment, name)) {
				JvmType resolved = getUnambiguousResult(result, index, type, i, name);
				if (resolved == null) {
					return null;
				}
				if (resolved != result) {
					result = type;
					index = i;
				}
			}
		}
		if (result != null) {
			JvmType actualResult = dollar > 0 || name.getSegmentCount() > 0 ? findNestedType(result, index, name) : result;
			if (actualResult != null) {
				return EObjectDescription.create(name, actualResult);
			}
		}
		return null;
	}

	/*
	 * If we know java.util.Map$Entry exists and we query for the FQN, we assume things are valid.
	 */
	protected JvmType getExactMatch(JvmType type, int index, QualifiedName name) {
		QualifiedName typeName = QualifiedName.create(Strings.split(type.getQualifiedName(), '.'));
		if (name.equals(typeName)) {
			return type;
		}
		if (name.startsWith(typeName)) {
			JvmType result = findNestedType(type, index, name.skipFirst(typeName.getSegmentCount()-1));
			return result;
		}
		if (name.getSegmentCount() > typeName.getSegmentCount()) {
			if (typeName.skipLast(1).equals(name.skipLast(1))) {
				if (typeName.getLastSegment().equals(name.skipFirst(typeName.getSegmentCount() - 1).toString("$"))) {
					return type;
				}
			}
		}
		return null;
	}

	protected JvmType getUnambiguousResult(JvmType current, int currentIndex, JvmType next, int nextIndex, QualifiedName name) {
		if (current != null && current != next) {
			return null;
		}
		return next;
	}
	
	@Override
	protected void doGetElements(JvmType type, List<IEObjectDescription> result) {
		for(int i = 0; i < types.size(); i++) {
			JvmType knownType = types.get(i);
			if (EcoreUtil.isAncestor(knownType, type)) {
				doGetDescriptions(type, knownType, i, result);
			}
		}
		parent.doGetElements(type, result);
	}

	protected void doGetDescriptions(JvmType type, JvmType knownType, int i, List<IEObjectDescription> result) {
		if (type == knownType) {
			result.add(EObjectDescription.create(QualifiedName.create(type.getSimpleName()), type));
		} else if (type.eContainer() == knownType) {
			result.add(EObjectDescription.create(QualifiedName.create(knownType.getSimpleName(), type.getSimpleName()), type));
			result.add(EObjectDescription.create(QualifiedName.create(knownType.getSimpleName() + '$' + type.getSimpleName()), type));
		} else {
			String knownTypeName = knownType.getQualifiedName();
			String withDollar = type.getQualifiedName('$');
			String withDot = type.getQualifiedName('.');
			result.add(EObjectDescription.create(QualifiedName.create(Strings.split(withDot.substring(knownTypeName.length()), '.')), type));
			result.add(EObjectDescription.create(QualifiedName.create(withDollar.substring(knownTypeName.length())), type));
		}
	}

	protected JvmType findNestedType(JvmType result, int index, QualifiedName name) {
		List<String> segments = name.getSegmentCount() == 1 ? Strings.split(name.getFirstSegment(), '$') : name.getSegments();
		for(int i = 1; i < segments.size() && result instanceof JvmDeclaredType; i++) {
			JvmDeclaredType declaredType = (JvmDeclaredType) result;
			String simpleName = segments.get(i);
			for(JvmMember member: declaredType.getMembers()) {
				if (member instanceof JvmType && simpleName.equals(member.getSimpleName())) {
					result = (JvmType) member;
					break;
				}
			}
			if (declaredType == result) {
				return null;
			}
		}
		return result;
	}

	protected boolean isMatch(int index, JvmType type, String simpleName, QualifiedName relativeName) {
		return simpleName.equals(type.getSimpleName());
	}

}