/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmModelInferrerDescriptor implements IJvmModelInferrer {
	
	private IJvmModelInferrer delegate = null;
	private IConfigurationElement element;
	
	public JvmModelInferrerDescriptor(IConfigurationElement element) {
		this.element = element;
	}

	public void infer(EObject e, /* @NonNull */ IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		if (delegate == null)
			delegate = loadDelegate();
		delegate.infer(e, acceptor, preIndexingPhase);
	}

	protected IJvmModelInferrer loadDelegate() {
		if (delegate == null) {
			try {
				return (IJvmModelInferrer) element.createExecutableExtension("class");
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
		return new IJvmModelInferrer.NullImpl();
	}

	@Override
	public String toString() {
		return "descriptor from :" + element.getContributor().getName()+" ("+ element.getAttribute("class")+")";
	}
}
