/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MacroProcessingJvmModelInferrer implements IJvmModelInferrer {

	public void infer(EObject e, @NonNull IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		
	}

}
