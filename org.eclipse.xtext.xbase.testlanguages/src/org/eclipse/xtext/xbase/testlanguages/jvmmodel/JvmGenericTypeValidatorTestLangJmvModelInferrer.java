/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testlanguages.jvmmodel;

import java.io.Serializable;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClass;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClassWithSuperTypes;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyClassWithWrongAdditionalInferredInterface;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyConstructor;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyField;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyInterface;
import org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyMethod;

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

	@Inject
	private IJvmModelAssociator associator;

	@Inject
	private TypeReferences typeReferences;

	protected void inferClass(MyClass myClass, IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase, JvmDeclaredType containerSceleton) {
		if (Strings.isEmpty(myClass.getName()))
			return;
		var inferred = jvmTypesBuilder.toClass(myClass, qualifiedNameProvider.getFullyQualifiedName(myClass));
		if (containerSceleton != null)
			containerSceleton.getMembers().add(inferred);
		acceptor.accept(inferred,
			(JvmGenericType it) -> {
				jvmTypesBuilder.setDocumentation(it, jvmTypesBuilder.getDocumentation(myClass));
				it.setAbstract(myClass.isAbstract());
				jvmTypesBuilder.setSuperClass(it, myClass.getExtends());
				for (var interf : myClass.getImplements()) {
					jvmTypesBuilder.addSuperInterface(it, interf);
				}
				inferMembers(myClass, it, acceptor, prelinkingPhase);
			});
		for (var member : myClass.getMembers()) {
			if (member instanceof MyClass) {
				inferClass((MyClass) member, acceptor, prelinkingPhase, inferred);
			}
		}
	}

	private void inferMembers(MyClass myClass, JvmGenericType it, IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
		for (var member : myClass.getMembers()) {
			if (member instanceof MyConstructor) {
				MyConstructor constructor = (MyConstructor) member;
				it.getMembers().add(jvmTypesBuilder.toConstructor(constructor, cons -> {
					for (var param : constructor.getParameters()) {
						cons.getParameters().add(jvmTypesBuilder.toParameter(param, param.getName(), param.getParameterType()));
					}
					for (JvmTypeReference exception : constructor.getExceptions()) {
						cons.getExceptions().add(jvmTypesBuilder.cloneWithProxies(exception));
					}
					jvmTypesBuilder.setBody(cons, constructor.getExpression());
				}));
			} else if (member instanceof MyField) {
				MyField field = (MyField) member;
				it.getMembers().add(jvmTypesBuilder.toField(field, field.getName(), field.getType()));
			} else if (member instanceof MyMethod) {
				MyMethod method = (MyMethod) member;
				it.getMembers().add(jvmTypesBuilder.toMethod(method, method.getName(), method.getType(), meth -> {
					meth.setStatic(method.isStatic());
					meth.setSynchronized(method.isSynchronized());
					if (method.isPrivate())
						meth.setVisibility(JvmVisibility.PRIVATE);
					for (var param : method.getParameters()) {
						meth.getParameters().add(jvmTypesBuilder.toParameter(param, param.getName(), param.getParameterType()));
					}
					copyTypeParameters(method.getTypeParameters(), meth);
					for (JvmTypeReference exception : method.getExceptions()) {
						meth.getExceptions().add(jvmTypesBuilder.cloneWithProxies(exception));
					}
					jvmTypesBuilder.setBody(meth, method.getExpression());
				}));
			}
		}
	}

	private void copyTypeParameters(List<JvmTypeParameter> typeParameters, JvmTypeParameterDeclarator target) {
		for (JvmTypeParameter typeParameter : typeParameters) {
			if (!Strings.isEmpty(typeParameter.getName())) {
				final JvmTypeParameter clonedTypeParameter = jvmTypesBuilder.cloneWithProxies(typeParameter);
				if (clonedTypeParameter != null) {
					target.getTypeParameters().add(clonedTypeParameter);
					associator.associate(typeParameter, clonedTypeParameter);
				}
			}
		}
	}

	protected void inferInterface(MyInterface myInterface, IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
		if (Strings.isEmpty(myInterface.getName()))
			return;
		acceptor.accept(jvmTypesBuilder.toInterface(myInterface, qualifiedNameProvider.getFullyQualifiedName(myInterface).toString(),
			(JvmGenericType it) -> {
				jvmTypesBuilder.setDocumentation(it, jvmTypesBuilder.getDocumentation(myInterface));
				for (var interf : myInterface.getExtends()) {
					jvmTypesBuilder.addSuperInterface(it, interf);
				}
			}));
	}

	protected void inferClassWithSuperTypes(MyClassWithSuperTypes myClass, IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
		if (Strings.isEmpty(myClass.getName()))
			return;
		acceptor.accept(jvmTypesBuilder.toClass(myClass, qualifiedNameProvider.getFullyQualifiedName(myClass),
			(JvmGenericType it) -> {
				jvmTypesBuilder.setDocumentation(it, jvmTypesBuilder.getDocumentation(myClass));
				var superTypes = myClass.getSuperTypes();
				it.getSuperTypes().add(typeReferences.getTypeForName(Serializable.class, myClass));
				for (int i = 0; i < superTypes.size(); i++) {
					if (i == 0) {
						jvmTypesBuilder.setSuperClass(it, superTypes.get(i));
					} else {
						jvmTypesBuilder.addSuperInterface(it, superTypes.get(i));
					}
				}
			}));
	}

	private void inferClassAndWrongInterface(MyClassWithWrongAdditionalInferredInterface element,
			IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
		// Infers a class correctly
		var inferred = jvmTypesBuilder.toClass(element, qualifiedNameProvider.getFullyQualifiedName(element));
		acceptor.accept(inferred,
				(JvmGenericType it) -> {
					for (var member : element.getMembers()) {
						// for simplicity, let's assume it's a method
						MyMethod method = (MyMethod) member;
						it.getMembers().add(jvmTypesBuilder.toMethod(method, method.getName(), method.getType(), meth -> {
							for (var param : method.getParameters()) {
								meth.getParameters().add(jvmTypesBuilder.toParameter(param, param.getName(), param.getParameterType()));
							}
							jvmTypesBuilder.setBody(meth, method.getExpression());
						}));
					}
			});
		// but also infers an interface with a wrong method
		// to verify that the JvmGenericType of the inferred interface will NOT be checked
		// See https://github.com/eclipse/xtext/issues/3045
		var wrongInferredInterface = jvmTypesBuilder.toInterface(element,
				qualifiedNameProvider.getFullyQualifiedName(element).toString()+ "Interface",
			(JvmGenericType it) -> {
				for (var member : element.getMembers()) {
					// for simplicity, let's assume it's a method
					MyMethod method = (MyMethod) member;
					// wrong abstract method with duplicate parameters
					it.getMembers().add(jvmTypesBuilder.toMethod(method, method.getName() + "Wrong", method.getType(), meth -> {
						meth.setAbstract(true);
						for (var param : method.getParameters()) {
							meth.getParameters().add(jvmTypesBuilder.toParameter(param, param.getName(),
									param.getParameterType()));
							// intentionally duplicate parameters
							meth.getParameters().add(jvmTypesBuilder.toParameter(param, param.getName(),
									param.getParameterType()));
						}
					}));
				}
			});
		acceptor.accept(wrongInferredInterface);
	}

	@Override
	public void infer(EObject element, IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
		if (element instanceof MyClass) {
			inferClass((MyClass) element, acceptor, prelinkingPhase, null);
			return;
		} else if (element instanceof MyInterface) {
			inferInterface((MyInterface) element, acceptor, prelinkingPhase);
			return;
		} else if (element instanceof MyClassWithSuperTypes) {
			inferClassWithSuperTypes((MyClassWithSuperTypes) element, acceptor, prelinkingPhase);
			return;
		} else if (element instanceof MyClassWithWrongAdditionalInferredInterface) {
			inferClassAndWrongInterface((MyClassWithWrongAdditionalInferredInterface) element, acceptor, prelinkingPhase);
			return;
		} else {
			super.infer(element, acceptor, prelinkingPhase);
		}
	}
}
