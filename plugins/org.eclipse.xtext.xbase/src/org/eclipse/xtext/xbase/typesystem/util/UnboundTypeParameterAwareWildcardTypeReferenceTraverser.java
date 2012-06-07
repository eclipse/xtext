/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.AbstractTypeReferencePairWalker.WildcardTypeReferenceTraverser;
import org.eclipse.xtext.xtype.XComputedTypeReference;

class UnboundTypeParameterAwareWildcardTypeReferenceTraverser extends
		WildcardTypeReferenceTraverser {
	protected UnboundTypeParameterAwareWildcardTypeReferenceTraverser(AbstractTypeReferencePairWalker delegate) {
		super(delegate);
	}

	@Override
	public Void doVisitComputedTypeReference(XComputedTypeReference reference,
			JvmWildcardTypeReference param) {
		if (UnboundTypeParameters.isUnboundTypeParameter(reference)) {
			return super.doVisitTypeReference(reference, param);
		}
		return super.doVisitComputedTypeReference(reference, param);
	}
}