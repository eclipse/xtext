/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public abstract class AbstractReentrantTypeReferenceProvider implements IJvmTypeReferenceProvider {

	private boolean computing = false;

	public final JvmTypeReference getTypeReference() {
		if (computing)
			return null;
		try {
			computing = true;
			return doGetTypeReference();
		} finally {
			computing = false;
		}
	}

	protected abstract JvmTypeReference doGetTypeReference();
}
