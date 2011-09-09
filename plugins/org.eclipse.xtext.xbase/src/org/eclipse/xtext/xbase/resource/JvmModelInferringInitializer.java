/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.resource.ILateInitialization;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmModelInferringInitializer implements ILateInitialization {
	
	@Inject
	private IJvmModelInferrer inferrer;
	
	public void doLateInitialization(final EList<EObject> resourcesContents) {
		if (resourcesContents == null || resourcesContents.isEmpty())
			return;
		EObject eObject = resourcesContents.get(0);
		inferrer.infer(eObject, new IAcceptor<JvmDeclaredType>() {
			public void accept(JvmDeclaredType t) {
				resourcesContents.add(t);
			}
		});
	}
}
