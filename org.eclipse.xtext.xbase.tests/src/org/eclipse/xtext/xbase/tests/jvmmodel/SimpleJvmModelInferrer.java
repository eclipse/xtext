/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.jvmmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.inject.Inject;

public class SimpleJvmModelInferrer implements IJvmModelInferrer {
	@Inject
	private JvmTypesBuilder jvmTypesBuilder;

	@Inject
	private TypeReferences references;

	@Override
	public void infer(EObject e, IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
		acceptor.accept(jvmTypesBuilder.toClass(e, "Test"), (Procedure1<JvmGenericType>) (JvmGenericType it) -> {
			it.getMembers().add(jvmTypesBuilder.toMethod(e, "doStuff", references.getTypeForName(String.class, e), (JvmOperation op) -> {
				op.getParameters().add(jvmTypesBuilder.toParameter(e, "s", references.getTypeForName(String.class, e)));
				jvmTypesBuilder.setBody(op, ((XExpression) e));
			}));
		});
	}
}
