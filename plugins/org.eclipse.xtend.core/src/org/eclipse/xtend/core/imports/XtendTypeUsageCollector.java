/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.imports;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.imports.TypeUsageCollector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendTypeUsageCollector extends TypeUsageCollector {

	@Override
	protected JvmIdentifiableElement getReferencedElement(EObject owner, EReference reference) {
		JvmIdentifiableElement referencedThing = super.getReferencedElement(owner, reference);
		if(owner instanceof XConstructorCall && owner.eContainer() instanceof AnonymousClass && referencedThing instanceof JvmConstructor && 
				((JvmConstructor) referencedThing).getDeclaringType() instanceof JvmGenericType) {
			JvmGenericType referencedType = (JvmGenericType) ((JvmConstructor) referencedThing).getDeclaringType();
			if(referencedType.getSuperTypes().size() == 1) 
				referencedThing = referencedType.getSuperTypes().get(0).getType();
		}
		return referencedThing;
	}
}
