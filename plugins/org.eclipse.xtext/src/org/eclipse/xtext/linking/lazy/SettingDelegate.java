/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Delegating implementation of an {@link EStructuralFeature.Setting} to be independent
 * of other's {@code hashCode()} and {@code equals(Object)} implementation.
 * The criteria is here: The settings's eObject and eStructuralFeature have to be equal.
 * 
 * @author Sebastian Zarnekow 
 */
public class SettingDelegate implements EStructuralFeature.Setting {

	private EStructuralFeature.Setting delegate;

	public SettingDelegate(EStructuralFeature.Setting delegate) {
		this.delegate = delegate;
	}

	public Object get(boolean resolve) {
		return delegate.get(resolve);
	}

	public EObject getEObject() {
		return delegate.getEObject();
	}

	public EStructuralFeature getEStructuralFeature() {
		return delegate.getEStructuralFeature();
	}

	public boolean isSet() {
		return delegate.isSet();
	}

	public void set(Object newValue) {
		delegate.set(newValue);
	}

	public void unset() {
		delegate.unset();
	}
	
	public int hashCode() {
		return delegate.getEObject().hashCode() ^ delegate.getEStructuralFeature().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SettingDelegate))
			return false;
		if (obj == null)
			return false;
		SettingDelegate other = (SettingDelegate) obj;
		return delegate == other.delegate || 
			(delegate.getEObject().equals(other.getEObject()) && 
					delegate.getEStructuralFeature().equals(other.getEStructuralFeature()));
	}
	
}
