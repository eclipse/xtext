/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LegacyKnownTypesScope extends KnownTypesScope {
	
	private final List<QualifiedName> importNames;

	public LegacyKnownTypesScope(List<JvmType> types, List<QualifiedName> importNames, IScope parent) {
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