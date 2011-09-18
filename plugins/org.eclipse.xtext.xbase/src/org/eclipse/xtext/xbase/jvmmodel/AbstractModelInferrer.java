/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.util.IAcceptor;

/**
 * A base dispatch class to be subclassed by Xtend.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractModelInferrer implements IJvmModelInferrer {
	
	public void infer(EObject e, IAcceptor<JvmDeclaredType> acceptor, boolean prelinkingPhase) {
		_infer(e, acceptor, prelinkingPhase);
	}
	
	public void _infer(EObject e, IAcceptor<JvmDeclaredType> acceptor, boolean prelinkingPhase) {
		for (EObject child : e.eContents()) {
			infer(child, acceptor, prelinkingPhase);
		}
	}
}
