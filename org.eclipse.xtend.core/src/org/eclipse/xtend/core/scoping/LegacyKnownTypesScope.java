/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LegacyKnownTypesScope extends KnownTypesScope {
	
	private final List<QualifiedName> importNames;

	public LegacyKnownTypesScope(List<JvmType> types, List<QualifiedName> importNames, AbstractScope parent) {
		super(types, parent);
		this.importNames = importNames;
	}
	
	@Override
	protected boolean isMatch(int index, JvmType type, String simpleName, QualifiedName relativeName) {
		return super.isMatch(index, type, simpleName, relativeName) || isLegacyMatch(index, relativeName);
	}

	protected boolean isLegacyMatch(int index, QualifiedName relativeName) {
		QualifiedName importedName = importNames.get(index);
		return importedName != null && relativeName.getSegmentCount() == 1 && importedName.getLastSegment().equals(relativeName.getFirstSegment());
	}
	
	@Override
	protected JvmType getUnambiguousResult(JvmType current, int currentIndex, JvmType next, int nextIndex, QualifiedName relativeName) {
		if (current != null && current != next) {
			if (isLegacyMatch(currentIndex, relativeName)) {
				if (isLegacyMatch(nextIndex, relativeName)) {
					return null;
				} else {
					JvmType realNextType = findNestedType(next, nextIndex, relativeName);
					if (realNextType == current) {
						return current;
					}
				}
			} else if (isLegacyMatch(nextIndex, relativeName)) {
				JvmType realCurrentType = findNestedType(current, currentIndex, relativeName);
				if (realCurrentType == next) {
					return next;
				}
			}
			return null;
		}
		return next;
	}
	
	@Override
	protected void doGetDescriptions(JvmType type, JvmType knownType, int index, List<IEObjectDescription> result) {
		super.doGetDescriptions(type, knownType, index, result);
		QualifiedName importName = importNames.get(index);
		if (type == knownType && importName != null) {
			result.add(EObjectDescription.create(QualifiedName.create(importName.getLastSegment()), type));
		}
	}
	
	@Override
	protected JvmType findNestedType(JvmType result, int index, QualifiedName name) {
		if (result.eContainer() instanceof JvmDeclaredType && name.getSegmentCount() == 1) {
			QualifiedName importName = importNames.get(index);
			if (importName != null && importName.getLastSegment().equals(name.getFirstSegment())) {
				return result;
			}
		}
		return super.findNestedType(result, index, name);
	}

}