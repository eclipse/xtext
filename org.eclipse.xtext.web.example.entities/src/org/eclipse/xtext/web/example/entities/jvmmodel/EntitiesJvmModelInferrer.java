/**
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.example.entities.jvmmodel;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.web.example.entities.domainmodel.Entity;
import org.eclipse.xtext.web.example.entities.domainmodel.Feature;
import org.eclipse.xtext.web.example.entities.domainmodel.Operation;
import org.eclipse.xtext.web.example.entities.domainmodel.Property;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class EntitiesJvmModelInferrer extends AbstractModelInferrer {
	@Inject
	private JvmTypesBuilder jvmTypesBuilder;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private EntitiesJvmModelHelper entitiesJvmModelHelper;

	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	protected void _infer(Entity entity, IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
		acceptor.accept(jvmTypesBuilder.toClass(entity, qualifiedNameProvider.getFullyQualifiedName(entity)),
				(JvmGenericType it) -> {
					jvmTypesBuilder.setDocumentation(it, jvmTypesBuilder.getDocumentation(entity));
					if (entity.getSuperType() != null) {
						it.getSuperTypes().add(jvmTypesBuilder.cloneWithProxies(entity.getSuperType()));
					}
					// let's add a default constructor
					it.getMembers().add(jvmTypesBuilder.toConstructor(entity, c -> {
					}));
					// and one which can be called with a lambda for initialization.
					JvmTypeReference procedureType = this._typeReferenceBuilder.typeRef(Procedure1.class,
							this._typeReferenceBuilder.typeRef(it));/* Procedure<MyEntity> */
					it.getMembers().add(jvmTypesBuilder.toConstructor(entity, (JvmConstructor c) -> {
						c.getParameters().add(jvmTypesBuilder.toParameter(entity, "initializer", procedureType));
						// here we implement the body using black box Java code.
						jvmTypesBuilder.setBody(c, new StringConcatenationClient() {
							@Override
							protected void appendTo(StringConcatenationClient.TargetStringConcatenation b) {
								b.append("initializer.apply(this);");
								b.newLine();
							}
						});
					}));
					// now let's go over the features
					for (Feature f : entity.getFeatures()) {
						if (f instanceof Property) {
							// for properties we create a field, a getter and a setter
							JvmField field = jvmTypesBuilder.toField(f, ((Property) f).getName(),
									((Property) f).getType());
							it.getMembers().add(field);
							it.getMembers().add(
									jvmTypesBuilder.toGetter(f, ((Property) f).getName(), ((Property) f).getType()));
							it.getMembers().add(
									jvmTypesBuilder.toSetter(f, ((Property) f).getName(), ((Property) f).getType()));
						} else if (f instanceof Operation) {
							// operations are mapped to methods
							JvmTypeReference operationType = null;
							if (((Operation) f).getType() != null) {
								operationType = ((Operation) f).getType();
							} else {
								operationType = jvmTypesBuilder.inferredType();
							}
							it.getMembers().add(jvmTypesBuilder.toMethod(f, ((Operation) f).getName(), operationType,
									(JvmOperation o) -> {
										jvmTypesBuilder.setDocumentation(o, jvmTypesBuilder.getDocumentation(f));
										for (JvmFormalParameter p : ((Operation) f).getParams()) {
											o.getParameters().add(
													jvmTypesBuilder.toParameter(p, p.getName(), p.getParameterType()));
										}
										// here the body is implemented using a user expression.
										// Note that by doing this we set the expression into the context of this
										// method,
										// The parameters, 'this' and all the members of this method will be visible for
										// the expression.
										jvmTypesBuilder.setBody(o, ((Operation) f).getBody());
									}));
						}
					}
					// remove created getters/setters in case they
					// are explicit in the source code
					removeDuplicateGettersSetters(it);
					// finally we want to have a nice toString methods.
					it.getMembers().add(jvmTypesBuilder.toToStringMethod(entity, it));
				});
	}

	private void removeDuplicateGettersSetters(JvmDeclaredType inferredType) {
		entitiesJvmModelHelper.handleDuplicateJvmOperations(inferredType, (Collection<JvmOperation> jvmOperations) -> {
			// we only remove getters/setters we created automatically
			JvmOperation getterOrSetter = Iterables.getFirst(Iterables.filter(jvmOperations,
					it -> jvmModelAssociations.getPrimarySourceElement(it) instanceof Property), null);
			if (getterOrSetter != null) {
				inferredType.getMembers().remove(getterOrSetter);
			}
			// other duplicated methods will be reported by the validator
		});
	}

	public void infer(EObject entity, IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
		if (entity instanceof Entity) {
			_infer((Entity) entity, acceptor, prelinkingPhase);
			return;
		} else if (entity != null) {
			_infer(entity, acceptor, prelinkingPhase);
			return;
		} else {
			throw new IllegalArgumentException(
					"Unhandled parameter types: " + Arrays.asList(entity, acceptor, prelinkingPhase).toString());
		}
	}
}
