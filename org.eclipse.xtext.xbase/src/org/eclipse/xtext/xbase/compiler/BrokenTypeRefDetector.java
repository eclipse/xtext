/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.AbstractTypeReferenceVisitor;

/**
 * A visitor that detects broken type references. Returns <code>true</code> if a
 * broken reference was detected.
 */
public class BrokenTypeRefDetector extends AbstractTypeReferenceVisitor.InheritanceAware<Boolean> {
	@Override
	protected Boolean handleNullReference() {
		return true;
	}

	@Override
	public Boolean doVisitTypeReference(JvmTypeReference it) {
		return it.getType() == null || it.getType().eIsProxy();
	}

	@Override
	public Boolean doVisitCompoundTypeReference(JvmCompoundTypeReference it) {
		return doVisitTypeReference(it) || it.getReferences().stream().anyMatch(ref -> visit(ref));
	}

	@Override
	public Boolean doVisitParameterizedTypeReference(JvmParameterizedTypeReference it) {
		return doVisitTypeReference(it) || it.getArguments().stream().anyMatch(ref -> visit(ref));
	}

	@Override
	public Boolean doVisitWildcardTypeReference(JvmWildcardTypeReference it) {
		return it.getConstraints().stream().anyMatch(constr -> visit(constr.getTypeReference()));
	}
}
