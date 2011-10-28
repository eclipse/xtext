/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.jvmmodel;

import static com.google.common.collect.Lists.*;

import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.Later;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.lib.Functions;

import com.google.inject.Inject;

public class DispatchMethodCompileStrategy implements Functions.Function1<ImportManager, CharSequence> {
	
	@Inject
	private TypeReferences typeReferences;

	@Inject
	private TypeConformanceComputer typeConformanceComputer;

	@Inject
	private Primitives primitives;

	@Inject
	private TypeReferenceSerializer typeReferenceSerializer;

	private List<JvmOperation> sortedDispatchOperations;

	private JvmOperation dispatchOperation;

	protected void initialize(JvmOperation dispatchOperation, List<JvmOperation> sortedDispatchOperations) {
		this.dispatchOperation = dispatchOperation;
		this.sortedDispatchOperations = sortedDispatchOperations;
	}

	public CharSequence apply(ImportManager importManager) {
		final StringBuilderBasedAppendable a = new StringBuilderBasedAppendable(importManager);
		boolean needsElse = true;
		for (JvmOperation operation : sortedDispatchOperations) {
			Iterator<JvmFormalParameter> iter1 = dispatchOperation.getParameters().iterator();
			final List<Later> laters = newArrayList();
			for (Iterator<JvmFormalParameter> iter2 = operation.getParameters().iterator(); iter2.hasNext();) {
				JvmFormalParameter p1 = iter1.next();
				JvmFormalParameter p2 = iter2.next();
				final JvmTypeReference type = p2.getParameterType();
				final String name = getVarName(p1, a);
				if (!typeConformanceComputer.isConformant(p2.getParameterType(), p1.getParameterType(), true)) {
					if (typeReferences.is(type, Void.class)) {
						laters.add(new Later() {
							@Override
							public void exec() {
								if (laters.size() > 1)
									a.append("(");
								a.append(name).append(" == null");
								if (laters.size() > 1)
									a.append(")");
							}
						});
					} else {
						laters.add(new Later() {
							@Override
							public void exec() {
								if (laters.size() > 1)
									a.append("(");
								a.append(name).append(" instanceof ");
								a.append(primitives.asWrapperTypeIfPrimitive(type).getType());
								if (laters.size() > 1)
									a.append(")");
							}
						});
					}
				}
			}
			// if it's not the first if append an 'else'
			if (sortedDispatchOperations.get(0) != operation) {
				a.append(" else ");
			}
			if (laters.isEmpty()) {
				needsElse = false;
				a.append("{").increaseIndentation();
			} else {
				a.append("if (");
				a.increaseIndentation().increaseIndentation();
				Iterator<Later> iterator = laters.iterator();
				while (iterator.hasNext()) {
					iterator.next().exec();
					if (iterator.hasNext()) {
						a.append("\n && ");
					}
				}
				a.decreaseIndentation().decreaseIndentation();
				a.append(") {").increaseIndentation();
			}
			a.append("\n");
			final boolean isCurrentVoid = typeReferences.is(operation.getReturnType(), Void.TYPE);
			final boolean isDispatchVoid = typeReferences.is(dispatchOperation.getReturnType(), Void.TYPE);
			if (isDispatchVoid) {
				generateActualDispatchCall(dispatchOperation, operation, a);
				a.append(";");
			} else {
				if (isCurrentVoid) {
					generateActualDispatchCall(dispatchOperation, operation, a);
					a.append(";\nreturn null");
				} else {
					a.append("return ");
					generateActualDispatchCall(dispatchOperation, operation, a);
				}
				a.append(";");
			}
			a.decreaseIndentation().append("\n}");
		}
		if (needsElse) {
			a.append(" else {").increaseIndentation();
			a.append("\n");
			a.increaseIndentation();
			a.append("throw new IllegalArgumentException(\"Unhandled parameter types: \" +\n");
			JvmType jvmType = typeReferences.findDeclaredType("java.util.Arrays", dispatchOperation);
			a.append(jvmType).append(".<Object>asList(");
			Iterator<JvmFormalParameter> iterator = dispatchOperation.getParameters().iterator();
			while (iterator.hasNext()) {
				JvmFormalParameter parameter = iterator.next();
				final String name = getVarName(parameter, a);
				a.append(name);
				if (iterator.hasNext()) {
					a.append(", ");
				}
			}
			a.append(").toString());");
			a.decreaseIndentation();
			a.decreaseIndentation().append("\n}");
		}
		return a.toString();
	}

	protected void generateActualDispatchCall(JvmOperation dispatchOperation, JvmOperation actualOperationToCall,
			IAppendable a) {
		a.append(actualOperationToCall.getSimpleName()).append("(");
		Iterator<JvmFormalParameter> iter1 = dispatchOperation.getParameters().iterator();
		for (Iterator<JvmFormalParameter> iter2 = actualOperationToCall.getParameters().iterator(); iter2.hasNext();) {
			JvmFormalParameter p1 = iter1.next();
			JvmFormalParameter p2 = iter2.next();
			if (!typeConformanceComputer.isConformant(p2.getParameterType(), p1.getParameterType(), true)) {
				a.append("(");
				typeReferenceSerializer.serialize(primitives.asWrapperTypeIfPrimitive(p2.getParameterType()),
						dispatchOperation, a);
				a.append(")");
			}
			if (typeReferences.is(p2.getParameterType(), Void.class)) {
				a.append("null");
			} else {
				a.append(getVarName(p1, a));
			}
			if (iter2.hasNext()) {
				a.append(", ");
			}
		}
		a.append(")");
	}

	/**
	 * TODO: we assume that names from the inferred JVM model are the same in the Java code. Does that assumption
	 * hold?
	 */
	protected String getVarName(JvmIdentifiableElement ex, IAppendable appendable) {
		return ex.getSimpleName();
	}
}