/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FunctionTypeReference extends ParameterizedTypeReference {

	private List<LightweightTypeReference> parameterTypes;
	private LightweightTypeReference returnType;
	
	public FunctionTypeReference(ITypeReferenceOwner owner, JvmType type) {
		super(owner, type);
	}
	
	/**
	 * Subclasses <em>must</em> override this method.
	 */
	@Override
	public int getKind() {
		return KIND_FUNCTION_TYPE_REFERENCE;
	}
	
	@Override
	protected FunctionTypeReference doCopyInto(ITypeReferenceOwner owner) {
		FunctionTypeReference result = new FunctionTypeReference(owner, getType());
		copyTypeArguments(result, owner);
		return result;
	}
	
	@Override
	protected void copyTypeArguments(ParameterizedTypeReference result, ITypeReferenceOwner owner) {
		super.copyTypeArguments(result, owner);
		FunctionTypeReference casted = (FunctionTypeReference) result;
		if (parameterTypes != null && !parameterTypes.isEmpty()) {
			for(LightweightTypeReference typeArgument: parameterTypes) {
				casted.addParameterType(typeArgument.copyInto(owner));
			}
		}
		if (returnType != null) {
			casted.setReturnType(returnType.copyInto(owner));
		}
	}
	
	public List<LightweightTypeReference> getParameterTypes() {
		return expose(parameterTypes);
	}
	
	/* @Nullable */
	public LightweightTypeReference getReturnType() {
		return returnType;
	}
	
	@Override
	public boolean isVisible(IVisibilityHelper visibilityHelper) {
		if (super.isVisible(visibilityHelper)) {
			if (returnType != null && !returnType.isVisible(visibilityHelper)) {
				return false;
			}
			if (parameterTypes != null) {
				for(LightweightTypeReference parameterType: parameterTypes) {
					if (!parameterType.isVisible(visibilityHelper)) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isOwnedBy(ITypeReferenceOwner owner) {
		if (super.isOwnedBy(owner)) {
			if (returnType != null && !returnType.isOwnedBy(owner))
				return false;
			if (parameterTypes != null) {
				for(LightweightTypeReference parameterType: parameterTypes) {
					if (!parameterType.isOwnedBy(owner)) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	public JvmTypeReference toTypeReference() {
		XFunctionTypeRef result = getOwner().getServices().getXtypeFactory().createXFunctionTypeRef();
		result.setType(getType());
		result.setEquivalent(getEquivalentTypeReference());
		if (parameterTypes != null) {
			for(LightweightTypeReference parameterType: parameterTypes) {
				result.getParamTypes().add(parameterType.toTypeReference());
			}
		}
		if (returnType != null) {
			result.setReturnType(returnType.toTypeReference());
		}
		return result;
	}

	protected JvmTypeReference getEquivalentTypeReference() {
		return super.toTypeReference();
	}
	
	public void addParameterType(LightweightTypeReference parameterType) {
		if (parameterType == null) {
			throw new NullPointerException("parameterType may not be null");
		}
		if (!parameterType.isOwnedBy(getOwner())) {
			throw new NullPointerException("parameterType is not valid in current context");
		}
		if (parameterTypes == null)
			parameterTypes = Lists.newArrayListWithCapacity(2);
		parameterTypes.add(parameterType);
		resolved = resolved && parameterType.isResolved();
	}
	
	public void setReturnType(LightweightTypeReference returnType) {
		if (returnType == null) {
			throw new NullPointerException("returnType may not be null");
		}
		if (!returnType.isOwnedBy(getOwner())) {
			throw new NullPointerException("returnType is not valid in current context");
		}
		this.returnType = returnType;
		resolved = resolved && returnType.isResolved();
	}
	
	@Override
	protected String getAsString(String type, Function<LightweightTypeReference, String> format) {
		if (isRawType())
			return type;
		return "(" + Joiner.on(", ").join(Iterables.transform(expose(parameterTypes), format)) + ")=>" + (returnType != null ? format.apply(returnType) : "./.");
	}
	
	@Override
	public String getJavaIdentifier() {
		return getAsStringNoFunctionType(getType().getIdentifier(), JavaIdentifierFunction.INSTANCE);
	}

	protected String getAsStringNoFunctionType(String type, Function<LightweightTypeReference,String> format) {
		return super.getAsString(type, format);
	}
	
	@Override
	public void accept(TypeReferenceVisitor visitor) {
		visitor.doVisitFunctionTypeReference(this);
	}
	
	@Override
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		visitor.doVisitFunctionTypeReference(this, param);
	}
	
	@Override
	/* @Nullable */
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		return visitor.doVisitFunctionTypeReference(this);
	}
	
	@Override
	/* @Nullable */
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		return visitor.doVisitFunctionTypeReference(this, param);
	}
	
	@Override
	public FunctionTypeReference tryConvertToFunctionTypeReference(boolean rawType) {
		return this;
	}
	
	@Override
	public FunctionTypeReference getAsFunctionTypeReference() {
		return this;
	}

}
