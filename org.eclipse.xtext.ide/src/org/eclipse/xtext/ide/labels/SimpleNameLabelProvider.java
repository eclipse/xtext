/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.labels;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.SimpleAttributeResolver;

public class SimpleNameLabelProvider implements INameLabelProvider {
	
	/**
	 * Calculates the simple-name based on the type of the passed {@code element}. If the {@code element} is an instance
	 * of {@code EObject}, the value of the {@code name} attribute is returned. If the {@code element} is an instance of
	 * {@code IEObjectDescription}, the value of the {@link QualifiedName#getLastSegment()} is returned. A {@code null}
	 * value is returned otherwise.
	 */
	@Override
	public String getNameLabel(Object element) {
		if (element instanceof EObject) {
			return SimpleAttributeResolver.NAME_RESOLVER.apply(((EObject) element));
		} else if (element instanceof IEObjectDescription) {
			return ((IEObjectDescription) element).getName().getLastSegment();
		}
		return null;
	}
}
