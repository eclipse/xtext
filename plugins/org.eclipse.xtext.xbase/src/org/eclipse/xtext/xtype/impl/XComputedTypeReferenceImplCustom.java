/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtype.impl;

import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XComputedTypeReferenceImplCustom extends XComputedTypeReferenceImpl {

	@Override
	public JvmTypeReference getEquivalent() {
		if (equivalent == null) {
			IJvmTypeReferenceProvider provider = getTypeProvider();
			if (provider != null) {
				JvmTypeReference result = provider.getTypeReference();
				if (result != null && (result.eResource() != null || result.eContainer() != null)) {
					JvmDelegateTypeReference delegate = TypesFactory.eINSTANCE.createJvmDelegateTypeReference();
					delegate.setDelegate(result);
					result = delegate;
				}
				if (result != null) {
					boolean wasDeliver = eDeliver();
					try {
						eSetDeliver(false);
						setEquivalent(result);
					} finally {
						eSetDeliver(wasDeliver);
					}
				}
			} else {
				equivalent = null;
			}
		}
		return equivalent;
		
	}
	
}
