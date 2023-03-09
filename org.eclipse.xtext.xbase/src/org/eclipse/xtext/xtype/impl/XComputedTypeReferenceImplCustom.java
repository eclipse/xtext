/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtype.impl;

import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitor;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.util.XtypeReferenceVisitor;
import org.eclipse.xtext.xtype.util.XtypeReferenceVisitorWithParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XComputedTypeReferenceImplCustom extends XComputedTypeReferenceImpl {

	@Override
	public <Result> Result accept(ITypeReferenceVisitor<Result> visitor) {
		if (visitor instanceof XtypeReferenceVisitor) {
			return ((XtypeReferenceVisitor<Result>) visitor).doVisitComputedTypeReference(this);
		}
		return super.accept(visitor);
	}
	
	@Override
	public <Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter, Result> visitor,
			Parameter parameter) {
		if (visitor instanceof XtypeReferenceVisitorWithParameter) {
			return ((XtypeReferenceVisitorWithParameter<Parameter, Result>) visitor).doVisitComputedTypeReference(this, parameter);
		}
		return super.accept(visitor, parameter);
	}
	
	@Override
	public JvmTypeReference getEquivalent() {
		if (equivalent == null) {
			IJvmTypeReferenceProvider provider = getTypeProvider();
			if (provider != null) {
				JvmTypeReference result = provider.getTypeReference(this);
				if (equivalent == null || equivalent != result) {
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
				}
			} else {
				equivalent = null;
			}
		}
		return equivalent;
	}
	
	public boolean isEquivalentComputed() {
		return equivalent != null;
	}
	
	public void unsetTypeProviderWithoutNotification() {
		typeProvider = null;
	}
}
