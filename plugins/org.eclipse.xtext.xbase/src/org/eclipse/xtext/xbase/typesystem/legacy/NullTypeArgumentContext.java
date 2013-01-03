/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.legacy;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class NullTypeArgumentContext implements ITypeArgumentContext {

	private TypeArgumentContextProvider.Request request;

	public NullTypeArgumentContext(TypeArgumentContextProvider.Request request) {
		this.request = request;
	}
	
	public TypeArgumentContextProvider.Request getRequest() {
		return request;
	}

	public JvmTypeReference getBoundArgument(JvmTypeParameter parameter) {
		throw new UnsupportedOperationException("Only valid operation is #getRequest");
	}

	public JvmTypeReference getLowerBound(JvmTypeReference reference) {
		throw new UnsupportedOperationException("Only valid operation is #getRequest");
	}

	public JvmTypeReference getUpperBound(JvmTypeReference element, Notifier context) {
		throw new UnsupportedOperationException("Only valid operation is #getRequest");
	}

	public JvmTypeReference resolve(JvmTypeReference reference) {
		throw new UnsupportedOperationException("Only valid operation is #getRequest");
	}

	public boolean isRawTypeContext() {
		throw new UnsupportedOperationException("Only valid operation is #getRequest");
	}

}
