/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.typing;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DomainmodelTypeProvider extends XbaseTypeProvider {

	protected JvmTypeReference _expectedType(Operation operation, EReference reference, int index, boolean rawType) {
		if(reference == DomainmodelPackage.Literals.OPERATION__BODY) {
			if(operation.getType() != null) {
				if(!rawType || operation.getType().getArguments().isEmpty()) {
					return operation.getType();
				} else {
					return getTypeReferences().createTypeRef(operation.getType().getType());
				}
			}
		}				
		return null; 
	}
}
