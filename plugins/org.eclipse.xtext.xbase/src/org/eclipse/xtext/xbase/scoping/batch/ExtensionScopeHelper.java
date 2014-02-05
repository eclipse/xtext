/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExtensionScopeHelper {

	private LightweightTypeReference receiverType;

	public ExtensionScopeHelper(LightweightTypeReference receiverType) {
		this.receiverType = receiverType;
	}
	
	/**
	 * Features that are valid extensions are all {@link JvmOperation operations}
	 * with at least one {@link JvmExecutable#getParameters() parameter}.
	 */
	boolean isPossibleExtension(JvmFeature feature) {
		if (!(feature instanceof JvmOperation)) {
			return false;
		}
		List<JvmFormalParameter> parameters = ((JvmExecutable) feature).getParameters();
		if (parameters.isEmpty()) {
			return false;
		}
		return true;
	}
	
	protected LightweightTypeReference getFirstParameterType(JvmOperation candidate) {
		return getParameterType(candidate.getParameters().get(0));
	}
	
	protected LightweightTypeReference getParameterType(JvmFormalParameter p) {
		return new OwnedConverter(receiverType.getOwner()).toRawLightweightReference(p.getParameterType().getType()).getRawTypeReference();
	}

	protected boolean isMatchingFirstParameter(JvmOperation feature) {
		List<JvmFormalParameter> parameters = feature.getParameters();
		JvmFormalParameter firstParameter = parameters.get(0);
		JvmTypeReference type = firstParameter.getParameterType();
		if (type == null)
			return false;
		JvmType rawParameterType = type.getType();
		if (rawParameterType == null || rawParameterType.eIsProxy())
			return false;
		if (!(rawParameterType instanceof JvmTypeParameter)) {
			LightweightTypeReference rawReceiverType = receiverType.getRawTypeReference();
			if (rawReceiverType.isResolved()) {
				// short circuit - limit extension scope entries to real candidates
				LightweightTypeReference parameterTypeReference = new OwnedConverter(rawReceiverType.getOwner()).toRawLightweightReference(rawParameterType);
				if (parameterTypeReference.isResolved() && !parameterTypeReference.isAssignableFrom(rawReceiverType)) {
					return false;
				}
				if (parameterTypeReference.isArray() && !rawReceiverType.isArray() && !rawReceiverType.isSubtypeOf(Iterable.class)) {
					return false;
				}
			} else if (isArrayTypeMismatch(rawReceiverType, rawParameterType)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isArrayTypeMismatch(LightweightTypeReference rawReceiverType, JvmType rawParameterType) {
		if (rawReceiverType.isArray()) {
			LightweightTypeReference parameterTypeReference = new OwnedConverter(rawReceiverType.getOwner()).toRawLightweightReference(rawParameterType);
			if (parameterTypeReference.getSuperType(Iterable.class) == null && isArrayTypeMismatch(rawReceiverType, parameterTypeReference)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isArrayTypeMismatch(LightweightTypeReference receiverType, LightweightTypeReference parameterType) {
		if (receiverType.isArray()) {
			if (parameterType.isArray()) {
				LightweightTypeReference componentType = parameterType.getComponentType();
				if (isArrayTypeMismatch(receiverType.getComponentType(), componentType)) {
					return true;
				}
				return false;
			}
			return true;
		} else {
			if (!parameterType.isArray() && parameterType.isPrimitive()) {
				return true;
			}
		}
		return false;
	}
	
	protected List<JvmOperation> getFilteredExtensionDescriptions(Map<String, List<JvmOperation>> extensionSignatures) {
		List<JvmOperation> result = Lists.newArrayList();
		for(List<JvmOperation> list: extensionSignatures.values()) {
			int size = list.size();
			for(int i = 0; i < size; i++) {
				JvmOperation candidate = list.get(i);
				if (candidate != null) {
					LightweightTypeReference firstParameterType = getFirstParameterType(candidate);
					if (i + 1 < list.size()) {
						for(int j = i + 1; j < list.size(); j++) {
							JvmOperation next = list.get(j);
							if (next != null) {
								LightweightTypeReference otherFirstParameterType = getFirstParameterType(next);
								if (otherFirstParameterType.isAssignableFrom(firstParameterType)) {
									list.set(j, null);
								} else if (firstParameterType.isAssignableFrom(otherFirstParameterType)) {
									list.set(j, null);
									candidate = next;
									firstParameterType = otherFirstParameterType;
								}
							}
						}
					}
					result.add(candidate);
				}
			}
		}
		return result;
	}
	
	protected String getExtensionSignature(JvmOperation operation) {
		StringBuilder builder = new StringBuilder(64).append(operation.getSimpleName()).append('(');
		List<JvmFormalParameter> parameters = operation.getParameters();
		for(int i = 1; i < parameters.size(); i++) {
			if (i != 1) {
				builder.append(',');
			}
			JvmFormalParameter parameter = parameters.get(i);
			builder.append(getParameterType(parameter).getIdentifier());
		}
		builder.append(')');
		return builder.toString();
	}
}
