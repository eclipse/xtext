/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel;

import static com.google.common.collect.Lists.*;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.Later;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Procedures;

import com.google.inject.Inject;

@NonNullByDefault
public class DispatchMethodCompileStrategy implements Procedures.Procedure1<ITreeAppendable> {
	
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

	public void apply(@Nullable ITreeAppendable a) {
		if (a == null)
			throw new IllegalArgumentException("a is never null");
		boolean needsElse = true;
		int parameterCount = dispatchOperation.getParameters().size();
		boolean[] allCasesSameType = new boolean[parameterCount];
		for(int i = 0; i < parameterCount; i++) {
			allCasesSameType[i] = true;
			JvmTypeReference dispatchParameterType = dispatchOperation.getParameters().get(i).getParameterType();
			for (JvmOperation operation : sortedDispatchOperations) {
				JvmFormalParameter parameter = operation.getParameters().get(i);
				JvmTypeReference caseParameterType = parameter.getParameterType();
				if (!EcoreUtil.equals(dispatchParameterType, caseParameterType)) {
					allCasesSameType[i] = false;
					break;
				}
			}
		}
		for (JvmOperation operation : sortedDispatchOperations) {
			final List<Later> laters = newArrayList();
			for (int i = 0; i < parameterCount; i++) {
				final JvmFormalParameter dispatchParam = dispatchOperation.getParameters().get(i);
				final JvmTypeReference dispatchParamType = dispatchParam.getParameterType();
				final JvmFormalParameter caseParam = operation.getParameters().get(i);
				final JvmTypeReference caseParamType = caseParam.getParameterType();
				final String name = getVarName(dispatchParam, a);
				if (typeReferences.is(caseParamType, Void.class)) {
					laters.add(new Later() {
						public void exec(ITreeAppendable appendable) {
							appendable.append(name).append(" == null");
						}
					});
				} else if (!allCasesSameType[i]) {
					laters.add(new Later() {
						public void exec(ITreeAppendable appendable) {
							if (typeConformanceComputer.isConformant(caseParamType, dispatchParamType, true) && !primitives.isPrimitive(dispatchParamType)) {
								appendable.append(name).append(" != null");
							} else {
								appendable.append(name).append(" instanceof ");
								appendable.append(primitives.asWrapperTypeIfPrimitive(caseParamType).getType());
							}
						}
					});
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
					iterator.next().exec(a);
					if (iterator.hasNext()) {
						a.newLine().append(" && ");
					}
				}
				a.decreaseIndentation().decreaseIndentation();
				a.append(") {").increaseIndentation();
			}
			a.newLine();
			final boolean isCurrentVoid = typeReferences.is(operation.getReturnType(), Void.TYPE);
			final boolean isDispatchVoid = typeReferences.is(dispatchOperation.getReturnType(), Void.TYPE);
			if (isDispatchVoid) {
				generateActualDispatchCall(dispatchOperation, operation, a);
				a.append(";");
			} else {
				if (isCurrentVoid) {
					generateActualDispatchCall(dispatchOperation, operation, a);
					a.append(";").newLine().append("return null");
				} else {
					a.append("return ");
					generateActualDispatchCall(dispatchOperation, operation, a);
				}
				a.append(";");
			}
			a.decreaseIndentation().newLine().append("}");
		}
		if (needsElse) {
			a.append(" else {").increaseIndentation();
			a.newLine();
			a.increaseIndentation();
			a.append("throw new IllegalArgumentException(\"Unhandled parameter types: \" +").newLine();
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
			a.decreaseIndentation().newLine().append("}");
		}
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