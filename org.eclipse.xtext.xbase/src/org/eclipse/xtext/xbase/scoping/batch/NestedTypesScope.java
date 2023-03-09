/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NestedTypesScope extends AbstractScope {
	
	private final IFeatureScopeSession session;

	public NestedTypesScope(IScope parent, IFeatureScopeSession session) {
		super(parent, false);
		this.session = session;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		List<JvmDeclaredType> nestedTypeDeclarators = session.getNestedTypeDeclarators();
		if (nestedTypeDeclarators.isEmpty())
			return Collections.emptyList();
		List<IEObjectDescription> result = Lists.newArrayList();
		Iterator<JvmDeclaredType> iterator = nestedTypeDeclarators.iterator();
		while(iterator.hasNext()) {
			JvmDeclaredType declarator = iterator.next();
			for(JvmDeclaredType nestedType: declarator.getAllNestedTypes()) {
				addDescriptions(nestedType, declarator, result);
			}
		}
		return result;
	}
	
	protected void addDescriptions(JvmDeclaredType type, JvmType declarator, List<IEObjectDescription> result) {
		String typeName = type.getQualifiedName('.');
		String declaratorName = declarator.getQualifiedName('.');
		int declaratorLength = declaratorName.length();
		String subName = typeName.substring(declaratorLength + 1);
		List<String> segments = Strings.split(subName, '.');
		result.add(EObjectDescription.create(QualifiedName.create(segments), type));
		result.add(EObjectDescription.create(subName.replace('.', '$'), type));
		for(JvmDeclaredType nestedType: type.getAllNestedTypes()) {
			addDescriptions(nestedType, declarator, result);
		}
	}

	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		List<JvmDeclaredType> nestedTypeDeclarators = session.getNestedTypeDeclarators();
		if (nestedTypeDeclarators.isEmpty())
			return Collections.emptyList();
		Iterator<JvmDeclaredType> iterator = nestedTypeDeclarators.iterator();
		String simpleName = name.getFirstSegment();
		List<IEObjectDescription> result = null;
		if (name.getSegmentCount() == 1) {
			Set<JvmDeclaredType> nestedTypesSet = new LinkedHashSet<>();
			while(iterator.hasNext()) {
				JvmDeclaredType declarator = iterator.next();
				Iterable<JvmDeclaredType> nestedTypes = declarator.findAllNestedTypesByName(simpleName);
				CollectionExtensions.addAll(nestedTypesSet, nestedTypes);
			}
			if (!nestedTypesSet.isEmpty()) {
				result = addDescriptions(name, 0, nestedTypesSet, result);
			}
		}
		if (result == null && name.getSegmentCount() == 1 && simpleName.indexOf('$') > 0) {
			QualifiedName splitted = QualifiedName.create(Strings.split(simpleName, '$'));
			return getLocalElementsByName(splitted);
		}
		if (result != null)
			return result;
		return Collections.emptyList();
	}
	
	private List<IEObjectDescription> addDescriptions(QualifiedName name, int idx, Iterable<JvmDeclaredType> declaredTypes, List<IEObjectDescription> result) {
		if (idx == name.getSegmentCount()) {
			return result;
		}
		if (idx == name.getSegmentCount() - 1) {
			if (result == null)
				result = Lists.newArrayList();
			for(JvmDeclaredType declaredType: declaredTypes) {
				result.add(createDescription(name, declaredType));
			}	
			return result;
		}
		String nextSegment = name.getSegment(idx);
		for(JvmDeclaredType declaredType: declaredTypes) {
			Iterable<JvmDeclaredType> nestedTypes = declaredType.findAllNestedTypesByName(nextSegment);
			addDescriptions(name, idx + 1, nestedTypes, result);
		}
		return result;
	}

	private IEObjectDescription createDescription(QualifiedName name, JvmDeclaredType declaredType) {
		// TODO visibility
		return EObjectDescription.create(name, declaredType);
	}

}