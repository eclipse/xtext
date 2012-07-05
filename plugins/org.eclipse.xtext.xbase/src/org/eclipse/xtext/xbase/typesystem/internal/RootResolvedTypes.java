/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNull;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO move this one to tests if everything worked out as expected
 */
public class RootResolvedTypes extends ResolvedTypes {

	protected RootResolvedTypes(DefaultReentrantTypeResolver resolver) {
		super(resolver);
	}

	@Override
	@NonNull
	protected ExpressionAwareUnboundTypeReference getUnboundTypeReference(@NonNull Object handle) {
		return (ExpressionAwareUnboundTypeReference) super.getUnboundTypeReference(handle);
	}

}
