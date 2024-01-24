/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testlanguages.jvmmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClass;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyConstructor;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyField;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyInterface;

import com.google.inject.Inject;

/**
 * @author Lorenzo Bettini
 *
 */
public class JvmGenericTypeValidatorTestLangJmvModelInferrer extends AbstractModelInferrer {
	@Inject
	private JvmTypesBuilder jvmTypesBuilder;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	protected void _infer(MyClass myClass, IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
		acceptor.accept(jvmTypesBuilder.toClass(myClass, qualifiedNameProvider.getFullyQualifiedName(myClass)),
			(JvmGenericType it) -> {
				jvmTypesBuilder.setDocumentation(it, jvmTypesBuilder.getDocumentation(myClass));
				if (myClass.getExtends() != null) {
					it.getSuperTypes().add(jvmTypesBuilder.cloneWithProxies(myClass.getExtends()));
				}
				for (var interf : myClass.getImplements()) {
					it.getSuperTypes().add(jvmTypesBuilder.cloneWithProxies(interf));
				}
				inferMembers(myClass, it);
			});
	}

	private void inferMembers(MyClass myClass, JvmGenericType it) {
		for (var member : myClass.getMembers()) {
			if (member instanceof MyConstructor) {
				MyConstructor constructor = (MyConstructor) member;
				it.getMembers().add(jvmTypesBuilder.toConstructor(constructor, cons -> {
					jvmTypesBuilder.setBody(cons, constructor.getExpression());
					for (var param : constructor.getParameters()) {
						cons.getParameters().add(jvmTypesBuilder.toParameter(param, param.getName(), param.getParameterType()));
					}
				}));
			} else if (member instanceof MyField) {
				MyField field = (MyField) member;
				it.getMembers().add(jvmTypesBuilder.toField(field, field.getName(), field.getType()));
			}
		}
	}

	protected void _infer(MyInterface myInterface, IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
		acceptor.accept(jvmTypesBuilder.toInterface(myInterface, qualifiedNameProvider.getFullyQualifiedName(myInterface).toString(),
			(JvmGenericType it) -> {
				jvmTypesBuilder.setDocumentation(it, jvmTypesBuilder.getDocumentation(myInterface));
				for (var interf : myInterface.getExtends()) {
					it.getSuperTypes().add(jvmTypesBuilder.cloneWithProxies(interf));
				}
			}));
	}

	@Override
	public void infer(EObject element, IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
		if (element instanceof MyClass) {
			_infer((MyClass) element, acceptor, prelinkingPhase);
			return;
		} else if (element instanceof MyInterface) {
			_infer((MyInterface) element, acceptor, prelinkingPhase);
			return;
		} else {
			super.infer(element, acceptor, prelinkingPhase);
		}
	}
}
