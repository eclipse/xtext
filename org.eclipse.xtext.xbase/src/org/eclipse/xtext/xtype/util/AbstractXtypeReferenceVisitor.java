/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtype.util;

import org.eclipse.xtext.common.types.util.AbstractTypeReferenceVisitor;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractXtypeReferenceVisitor<Result> extends AbstractTypeReferenceVisitor.InheritanceAware<Result> implements XtypeReferenceVisitor<Result> {

	@Override
	public Result doVisitFunctionTypeReference(XFunctionTypeRef reference) {
		return doVisitSpecializedTypeReference(reference);
	}

	@Override
	public Result doVisitComputedTypeReference(XComputedTypeReference reference) {
		return doVisitSpecializedTypeReference(reference);
	}
	
}
