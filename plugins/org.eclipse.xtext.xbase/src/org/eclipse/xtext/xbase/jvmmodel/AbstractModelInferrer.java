/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * A base dispatch class to be subclassed by clients.
 * It allows subclasses to use Xtend's dispatch methods in order to avoid explicit tree navigation and 
 * instanceof checking.
 * 
 * see also {@link IJvmModelInferrer}
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.7
 */
public abstract class AbstractModelInferrer implements IJvmModelInferrer {
	
	public void infer(EObject e, final /* @NonNull */ IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		_infer(e, acceptor, preIndexingPhase);
	}
	
	public void _infer(EObject e, /* @NonNull */ IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		for (EObject child : e.eContents()) {
			infer(child, acceptor, preIndexingPhase);
		}
	}
}
