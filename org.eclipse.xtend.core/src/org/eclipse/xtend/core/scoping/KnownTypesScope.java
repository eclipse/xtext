/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class KnownTypesScope extends AbstractKnownTypesScope {
	
	private final List<? extends JvmType> types;

	public KnownTypesScope(List<? extends JvmType> types, AbstractScope parent) {
		super(parent);
		this.types = types;
	}
	
	@Override
	protected void doGetElements(JvmType type, List<IEObjectDescription> result) {
		for(int i = 0; i < types.size(); i++) {
			JvmType knownType = types.get(i);
			if (EcoreUtil.isAncestor(knownType, type)) {
				doGetDescriptions(type, knownType, i, result);
			}
		}
		super.doGetElements(type, result);
	}
	
	@Override
	protected IEObjectDescription doGetSingleElement(QualifiedName name, String firstSegment, int dollarIndex) {
		int index = -1;
		JvmType result = null;
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
					result = resolved;
					index = i;
				}
			}
		}
		return toDescription(name, result, dollarIndex, index);
	}
	
	@Override
	protected IEObjectDescription toDescription(QualifiedName name, JvmType result, int dollarIndex, int index) {
		if (result != null) {
			JvmType actualResult = dollarIndex > 0 || name.getSegmentCount() > 0 ? findNestedType(result, index, name) : result;
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
		String qn = type.getQualifiedName();
		if (Strings.isEmpty(qn)) {
			return null;
		}
		QualifiedName typeName = QualifiedName.create(Strings.split(qn, '.'));
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
	
	protected boolean isMatch(int index, JvmType type, String simpleName, QualifiedName relativeName) {
		return simpleName.equals(type.getSimpleName());
	}
	
	@Override
	protected void doGetDescriptions(JvmType type, JvmType knownType, int index, List<IEObjectDescription> result) {
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

}