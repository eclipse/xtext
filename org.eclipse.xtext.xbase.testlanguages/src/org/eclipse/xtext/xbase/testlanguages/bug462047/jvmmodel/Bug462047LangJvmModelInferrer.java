/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testlanguages.bug462047.jvmmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.testlanguages.bug462047.bug462047.Bug462047Element;

import com.google.inject.Inject;

/**
 * <p>
 * Infers a JVM model from the source model.
 * </p>
 * 
 * <p>
 * The JVM model should contain all elements that would appear in the Java code
 * which is generated from the source model. Other models link against the JVM
 * model rather than the source model.
 * </p>
 */
public class Bug462047LangJvmModelInferrer extends AbstractModelInferrer {
	@Inject
	private JvmTypesBuilder jvmTypesBuilder;

	protected void _infer(Bug462047Element element, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		acceptor.accept(jvmTypesBuilder.toClass(element, "CORE." + element.getName()), c -> {
			jvmTypesBuilder.setDocumentation(c, element.getRef() == null ? null : element.getRef().getQualifiedName());
		});
	}

	public void infer(EObject element, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		if (element instanceof Bug462047Element) {
			_infer((Bug462047Element) element, acceptor, isPreIndexingPhase);
			return;
		} else {
			super.infer(element, acceptor, isPreIndexingPhase);
		}
	}
}
