/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;

import com.google.common.collect.Lists;

/**
 * Implementation of the {@link ITypeArgumentContext} that encapsulates how the available
 * information of an {@link TypeArgumentContextProvider.Request} will be used to resolve
 * type parameters. It maintains a chain of delegate contexts and knows which delegate has to 
 * was already produced and which will be created next on demand.
 * 
 * Prior to using the class, clients have to 
 * {@link #initialize(TypeArgumentContextProvider.Request, TypeArgumentContextProvider) initialize}
 * it.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class LazyTypeArgumentContext implements TypeArgumentContextProvider.IInitializableTypeArgumentContext {

	private TypeArgumentContextProvider.Request request;

	private TypeArgumentContextProvider contextProvider;
	
	private int nextLevel = 0;
	
	private final List<ITypeArgumentContext> delegates;
	
	public LazyTypeArgumentContext() {
		this.delegates = Lists.newArrayListWithCapacity(3);		
	}
	
	public void initialize(TypeArgumentContextProvider.Request request, TypeArgumentContextProvider contextProvider) {
		this.request = request;
		this.contextProvider = contextProvider;
	}

	public boolean isRawTypeContext() {
		for(ITypeArgumentContext delegate: delegates) {
			if (delegate.isRawTypeContext())
				return true;
		}
		while(hasNextLevel()) {
			ITypeArgumentContext delegate = computeNext();
			if (delegate != null) {
				if (delegate.isRawTypeContext())
					return true;
			}
		}
		return delegates.isEmpty();
	}
	
	public JvmTypeReference getBoundArgument(JvmTypeParameter parameter) {
		if (parameter == null)
			return null;
		JvmTypeReference firstCandidate = null;
		for(ITypeArgumentContext delegate: delegates) {
			JvmTypeReference candidate = delegate.getBoundArgument(parameter);
			if (isResolved(candidate, delegate.isRawTypeContext(), false))
				return candidate;
			else if (firstCandidate == null && candidate != null) {
				firstCandidate = candidate;
			}
		}
		while(hasNextLevel()) {
			ITypeArgumentContext delegate = computeNext();
			if (delegate != null) {
				JvmTypeReference candidate = delegate.getBoundArgument(parameter);
				if (isResolved(candidate, delegate.isRawTypeContext(), false) || !hasNextLevel())
					return candidate;
				else if (firstCandidate == null && candidate != null) {
					if (!(candidate instanceof JvmParameterizedTypeReference) || candidate.getType() != parameter)
						firstCandidate = candidate;
				}
			}
		}
		return firstCandidate;
	}

	public JvmTypeReference getLowerBound(JvmTypeReference reference) {
		JvmTypeReference result = reference;
		if (isResolved(result, false))
			return result;
		for(ITypeArgumentContext delegate: delegates) {
			result = delegate.getLowerBound(result);
			if (isResolved(result, delegate.isRawTypeContext()))
				return result;
		}
		while(hasNextLevel()) {
			ITypeArgumentContext delegate = computeNext();
			if (delegate != null) {
				result = delegate.getLowerBound(result);
				if (isResolved(result, delegate.isRawTypeContext()))
					return result;
			}
		}
		return result;
	}

	public JvmTypeReference getUpperBound(JvmTypeReference reference, Notifier context) {
		JvmTypeReference result = reference;
		if (isResolved(result, false))
			return result;
		for(ITypeArgumentContext delegate: delegates) {
			result = delegate.getUpperBound(result, context);
			if (isResolved(result, delegate.isRawTypeContext()))
				return result;
		}
		while(hasNextLevel()) {
			ITypeArgumentContext delegate = computeNext();
			if (delegate != null) {
				result = delegate.getUpperBound(result, context);
				if (isResolved(result, delegate.isRawTypeContext()))
					return result;
			}
		}
		return result;
	}

	public JvmTypeReference resolve(JvmTypeReference reference) {
		JvmTypeReference result = reference;
		if (isResolved(result, false))
			return result;
		for(ITypeArgumentContext delegate: delegates) {
			result = delegate.resolve(result);
			if (isResolved(result, delegate.isRawTypeContext()))
				return result;
		}
		while(hasNextLevel()) {
			ITypeArgumentContext delegate = computeNext();
			if (delegate != null) {
				result = delegate.resolve(result);
				if (isResolved(result, delegate.isRawTypeContext()))
					return result;
			}
		}
		return result;
	}
	
	protected boolean hasNextLevel() {
		return nextLevel >= 0;
	}
	
	protected ITypeArgumentContext computeNext() {
		ITypeArgumentContext result = doComputeNext();
		if (result != null) {
			delegates.add(result);
		}
		return result;
	}
	
	protected ITypeArgumentContext doComputeNext() {
		JvmFeature feature = null;
		switch(nextLevel) {
			case 0: 
				JvmTypeReference receiverType = request.getReceiverType();
				if (receiverType != null) {
					nextLevel = 1;
					return contextProvider.getReceiverContext(receiverType);
				}
			case 1:
				feature = request.getFeature();
				if (feature instanceof JvmExecutable) {
					List<JvmTypeReference> explicitTypeArguments = request.getExplicitTypeArgument();
					if (explicitTypeArguments != null && !explicitTypeArguments.isEmpty()) {
						nextLevel = 2;
						return contextProvider.getExplicitArgumentContext((JvmExecutable) feature, explicitTypeArguments);
					}
				}
			case 2:
				if (feature == null)
					feature = request.getFeature();
				if (feature instanceof JvmExecutable) {
					List<JvmTypeReference> argumentTypes = request.getArgumentTypes();
					if (argumentTypes != null && !argumentTypes.isEmpty()) {
						nextLevel = 3;
						return contextProvider.getParameterContext((JvmExecutable) feature, argumentTypes);
					}
				}
			case 3:
				JvmTypeReference declaredType = request.getDeclaredType();
				if (declaredType != null) {
					JvmTypeReference expectedType = request.getExpectedType();
					if (expectedType != null) {
						nextLevel = 4;
						return contextProvider.getExpectedTypeContext(declaredType, expectedType);
					}
				}
			case 4:
				if (feature == null)
					feature = request.getFeature();
				if (feature instanceof JvmExecutable && ((JvmExecutable) feature).isVarArgs()) {
					nextLevel = -1;
					return contextProvider.getDeclaredBoundsContext((JvmExecutable) feature);
				}
		}
		nextLevel = -1;
		return null;
	}
		
	protected boolean isResolved(JvmTypeReference reference, final boolean rawType) {
		return isResolved(reference, rawType, true);
	}
	
	protected boolean isResolved(JvmTypeReference reference, final boolean rawType, boolean firstWildcardUnresolved) {
		// nothing that we can do about a 'null' reference on the entry level - treat as resolved
		if (reference == null)
			return true;
		Boolean result = new IsResolvedVisitor(rawType).visit(reference, firstWildcardUnresolved);
		return result;
	}
	
	protected class IsResolvedVisitor extends AbstractTypeReferenceVisitorWithParameter.InheritanceAware<Boolean, Boolean> {
		private final boolean rawType;

		protected IsResolvedVisitor(boolean rawType) {
			this.rawType = rawType;
		}

		@Override
		public Boolean doVisitTypeReference(JvmTypeReference reference, Boolean wildcardIsUnresolved) {
			return Boolean.TRUE;
		}

		@Override
		protected Boolean handleNullReference(Boolean wildcardIsUnresolved) {
			return Boolean.FALSE;
		}

		@Override
		public Boolean doVisitCompoundTypeReference(JvmCompoundTypeReference reference, Boolean wildcardIsUnresolved) {
			for(JvmTypeReference component: reference.getReferences()) {
				if (!visit(component, wildcardIsUnresolved))
					return Boolean.FALSE;
			}
			return Boolean.TRUE;
		}

		@Override
		public Boolean doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, Boolean wildcardIsUnresolved) {
			JvmType type = reference.getType();
			if (type instanceof JvmTypeParameter) {
				JvmTypeParameterDeclarator declarator = ((JvmTypeParameter) type).getDeclarator();
				JvmTypeParameterDeclarator nearestDeclarator = request.getNearestDeclarator();
				if (nearestDeclarator == null) {
					return Boolean.FALSE;
				} else if (!EcoreUtil.isAncestor(nearestDeclarator, declarator)) {
					return Boolean.FALSE;
				}
			}
			if (!rawType) {
				if (type instanceof JvmTypeParameterDeclarator) {
					List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) type).getTypeParameters();
					List<JvmTypeReference> typeArguments = reference.getArguments();
					if (typeParameters.size() != typeArguments.size()) {
						return Boolean.FALSE;
					}
				}
				for(JvmTypeReference typeArgument: reference.getArguments()) {
					if (!visit(typeArgument, Boolean.FALSE))
						return Boolean.FALSE;
				}
			}
			return Boolean.TRUE;
		}

		@Override
		public Boolean doVisitWildcardTypeReference(JvmWildcardTypeReference reference, Boolean wildcardIsUnresolved) {
			if (wildcardIsUnresolved)
				return Boolean.FALSE;
			for(JvmTypeConstraint constraint: reference.getConstraints()) {
				if (!visit(constraint.getTypeReference(), Boolean.FALSE))
					return Boolean.FALSE;
			}
			return Boolean.TRUE;
		}

		@Override
		public Boolean doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, Boolean wildcardIsUnresolved) {
			return visit(reference.getComponentType(), wildcardIsUnresolved);
		}
	}
}
