/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xtype.util.AbstractXtypeReferenceVisitorWithParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString implementation
 */
public abstract class AbstractTypeReferenceTraverser<Reference extends JvmTypeReference> extends 
		AbstractXtypeReferenceVisitorWithParameter<Reference, Void> {
	@Override
	public Void doVisitCompoundTypeReference(JvmCompoundTypeReference reference, Reference declaration) {
		for (JvmTypeReference component : reference.getReferences())
			visit(component, declaration);
		return null;
	}
	
	@Override
	protected Void handleNullReference(Reference declaration) {
		return null;
	}
	
	@Override
	public Void doVisitTypeReference(JvmTypeReference reference, Reference declaration) {
		return null;
	}
}