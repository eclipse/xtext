/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import java.util.List;

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
public abstract class AbstractKnownTypesScope extends AbstractScope {

	private final AbstractScope parent;

	protected AbstractKnownTypesScope(AbstractScope parent) {
		this.parent = parent;
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		return parent.getElements(name);
	}
	
	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		IEObjectDescription result = doGetSingleElement(name);
		if (result != null) {
			return result;
		}
		return parent.getSingleElement(name);
	}
	
	@Override
	protected void doGetElements(JvmType type, List<IEObjectDescription> result) {
		parent.doGetElements(type, result);
	}
	
	protected abstract void doGetDescriptions(JvmType type, JvmType knownType, int index, List<IEObjectDescription> result);
	
	protected JvmType getUnambiguousResult(JvmType current, int currentIndex, JvmType next, int nextIndex, QualifiedName name) {
		if (current != null && current != next) {
			return null;
		}
		return next;
	}
	
	protected IEObjectDescription doGetSingleElement(QualifiedName name) {
		String firstSegment = name.getFirstSegment();
		int dollar = firstSegment.indexOf('$');
		if (dollar > 0) {
			firstSegment = firstSegment.substring(0, dollar);
		}
		return doGetSingleElement(name, firstSegment, dollar);
	}

	protected abstract IEObjectDescription doGetSingleElement(QualifiedName name, String firstSegment, int dollarIndex);

	protected IEObjectDescription toDescription(QualifiedName name, JvmType result, int dollarIndex, int index) {
		return EObjectDescription.create(name, result);
	}
	
	protected JvmType findNestedType(JvmType result, int index, QualifiedName name) {
		List<String> segments = name.getSegmentCount() == 1 ? Strings.split(name.getFirstSegment(), '$') : name.getSegments();
		for(int i = 1; i < segments.size() && result instanceof JvmDeclaredType; i++) {
			JvmDeclaredType declaredType = (JvmDeclaredType) result;
			String simpleName = segments.get(i);
			// TODO handle ambiguous types
			for(JvmMember member: declaredType.findAllNestedTypesByName(simpleName)) {
				result = (JvmType) member;
				break;
			}
			if (declaredType == result) {
				return null;
			}
		}
		return result;
	}

}
