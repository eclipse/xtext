/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtype.util;

import org.eclipse.xtext.common.types.util.AbstractTypeReferenceVisitorWithParameter;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractXtypeReferenceVisitorWithParameter<Parameter, Result> extends AbstractTypeReferenceVisitorWithParameter.InheritanceAware<Parameter, Result> implements XtypeReferenceVisitorWithParameter<Parameter, Result> {

	@Override
	public Result doVisitFunctionTypeReference(XFunctionTypeRef reference, Parameter param) {
		return doVisitSpecializedTypeReference(reference, param);
	}

	@Override
	public Result doVisitComputedTypeReference(XComputedTypeReference reference, Parameter param) {
		return doVisitSpecializedTypeReference(reference, param);
	}
	
}
