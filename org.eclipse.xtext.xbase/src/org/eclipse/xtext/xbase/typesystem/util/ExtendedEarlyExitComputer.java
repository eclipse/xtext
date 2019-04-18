/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.override.BottomResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.override.OverrideTester;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExtendedEarlyExitComputer {
	
	@Inject
	private OverrideTester overrideTester;
	
	// TODO discuss / improve
	/**
	 * Returns <code>true</code> for expressions that seem to be early exit expressions, e.g.
	 * <pre>
	 *   while(condition) {
	 *     if (anotherCondition)
	 *       return value
	 *     changeResultOfFirstCondition
	 *   }
	 * </pre>
	 */
	public boolean isIntentionalEarlyExit(/* @Nullable */ XExpression expression) {
		if (expression == null) {
			return true;
		}
		if (expression instanceof XBlockExpression) {
			XBlockExpression block = (XBlockExpression) expression;
			List<XExpression> children = block.getExpressions();
			for(XExpression child: children) {
				if (isIntentionalEarlyExit(child)) {
					return true;
				}
			}
		} else if (expression instanceof XIfExpression) {
			return isIntentionalEarlyExit(((XIfExpression) expression).getThen()) 
					|| isIntentionalEarlyExit(((XIfExpression) expression).getElse());
		} else if (expression instanceof XSwitchExpression) {
			XSwitchExpression switchExpression = (XSwitchExpression) expression;
			for(XCasePart caseExpression: switchExpression.getCases()) {
				if (isIntentionalEarlyExit(caseExpression.getThen())) {
					return true;
				}
			}
			if (isIntentionalEarlyExit(switchExpression.getDefault())) {
				return true;
			}
		} else if (expression instanceof XTryCatchFinallyExpression) {
			XTryCatchFinallyExpression tryCatchFinally = (XTryCatchFinallyExpression) expression;
			if (isIntentionalEarlyExit(tryCatchFinally.getExpression())) {
				for(XCatchClause catchClause: tryCatchFinally.getCatchClauses()) {
					if (!isIntentionalEarlyExit(catchClause.getExpression()))
						return false;
				}
				return true;
			}
			return false;
		} else if (expression instanceof XAbstractWhileExpression) {
			return isIntentionalEarlyExit(((XAbstractWhileExpression) expression).getBody());
		} else if (expression instanceof XForLoopExpression) {
			return isIntentionalEarlyExit(((XForLoopExpression) expression).getEachExpression());
		} else if (expression instanceof XBasicForLoopExpression) {
			return isIntentionalEarlyExit(((XBasicForLoopExpression) expression).getEachExpression());
		} else if (expression instanceof XSynchronizedExpression) {
			return isIntentionalEarlyExit(((XSynchronizedExpression) expression).getExpression());
		}
		return expression instanceof XReturnExpression || expression instanceof XThrowExpression;
	}

	public boolean isDefiniteEarlyExit(XExpression expression) {
		// TODO further improvements
		if (expression instanceof XIfExpression) {
			XIfExpression ifExpression = (XIfExpression) expression;
			return isDefiniteEarlyExit(ifExpression.getThen()) && isDefiniteEarlyExit(ifExpression.getElse());
		} else if (expression instanceof XSwitchExpression) {
			XSwitchExpression switchExpression = (XSwitchExpression) expression;
			if (isDefiniteEarlyExit(switchExpression.getDefault())) {
				for(XCasePart caseExpression: switchExpression.getCases()) {
					if (!isDefiniteEarlyExit(caseExpression.getThen())) {
						return false;
					}
				}
				return true;
			}
			return false;
		} else if (expression instanceof XTryCatchFinallyExpression) {
			XTryCatchFinallyExpression tryExpression = (XTryCatchFinallyExpression) expression;
			if (isDefiniteEarlyExit(tryExpression.getFinallyExpression())) {
				return true;
			}
			if (isDefiniteEarlyExit(tryExpression.getExpression())) {
				for(XCatchClause catchClause: tryExpression.getCatchClauses()) {
					if (!isDefiniteEarlyExit(catchClause.getExpression())) {
						return false;
					}
				}
				return true;
			}
			return false;
		} else if (expression instanceof XBlockExpression) {
			List<XExpression> expressions = ((XBlockExpression) expression).getExpressions();
			for(int i = expressions.size() - 1; i >= 0; i--) {
				if (isDefiniteEarlyExit(expressions.get(i))) {
					return true;
				}
			}
		} else if (expression instanceof XSynchronizedExpression) {
			return isDefiniteEarlyExit(((XSynchronizedExpression) expression).getExpression());
		}
		return expression instanceof XReturnExpression || expression instanceof XThrowExpression;
	}
	
	protected abstract class AbstractThrownExceptionDelegate implements IThrownExceptionDelegate {
		private Switch<Boolean> collector;

		@Override
		public void collectThrownExceptions(XExpression expression) {
			if (expression != null) {
				TreeIterator<EObject> iterator = EcoreUtil2.eAll(expression);
				while(iterator.hasNext()) {
					if (!collector.doSwitch(iterator.next())) {
						iterator.prune();
					}
				}
			}
		}

		@Override
		public IThrownExceptionDelegate catchExceptions(List<LightweightTypeReference> caughtExceptions) {
			if (caughtExceptions.isEmpty()) {
				return this;
			}
			FilteringThrownExceptionDelegate delegate = new FilteringThrownExceptionDelegate(this, caughtExceptions);
			Switch<Boolean> collector = createThrownExceptionCollector(delegate);
			delegate.collectWith(collector);
			return delegate;
		}

		public void collectWith(Switch<Boolean> collector) {
			this.collector = collector;
		}
		
		@Override
		public IResolvedExecutable getResolvedFeature(JvmExecutable executable, LightweightTypeReference contextType) {
			if (executable instanceof JvmOperation) {
				return new BottomResolvedOperation((JvmOperation) executable, contextType, overrideTester);
			}
			if (executable instanceof JvmConstructor) {
				return new ResolvedConstructor((JvmConstructor) executable, contextType);
			}
			throw new IllegalArgumentException(String.valueOf(executable));
		}

	}
	
	protected class ThrownExceptionDelegate extends AbstractThrownExceptionDelegate {

		private final List<LightweightTypeReference> result;
		private final Set<String> seen;
		private final IResolvedTypes types;
		private final ITypeReferenceOwner owner;

		public ThrownExceptionDelegate(List<LightweightTypeReference> result, IResolvedTypes types, ITypeReferenceOwner owner) {
			this.result = result;
			this.types = types;
			this.owner = owner;
			this.seen = Sets.newHashSet();
		}

		@Override
		public LightweightTypeReference toLightweightReference(JvmTypeReference exception) {
			return owner.toLightweightTypeReference(exception);
		}

		@Override
		public void accept(LightweightTypeReference type) {
			if (type != null && seen.add(type.getIdentifier())) {
				result.add(type);
			}
		}

		@Override
		public LightweightTypeReference getActualType(XExpression expr) {
			return types.getActualType(expr);
		}
		
		@Override
		public LightweightTypeReference getActualType(JvmIdentifiableElement identifiable) {
			return types.getActualType(identifiable);
		}
		
	}
	
	protected class FilteringThrownExceptionDelegate extends AbstractThrownExceptionDelegate {

		private final IThrownExceptionDelegate delegate;
		private final List<LightweightTypeReference> caughtExceptions;

		protected FilteringThrownExceptionDelegate(IThrownExceptionDelegate delegate, List<LightweightTypeReference> caughtExceptions) {
			this.delegate = delegate;
			this.caughtExceptions = caughtExceptions;
			
		}
		
		@Override
		public LightweightTypeReference toLightweightReference(JvmTypeReference exception) {
			return delegate.toLightweightReference(exception);
		}

		@Override
		public void accept(LightweightTypeReference type) {
			for(LightweightTypeReference caughtException: caughtExceptions) {
				if (type.isSubtypeOf(caughtException.getType())) {
					return;
				}
			}
			delegate.accept(type);
		}

		@Override
		public LightweightTypeReference getActualType(XExpression expr) {
			return delegate.getActualType(expr);
		}
		
		@Override
		public LightweightTypeReference getActualType(JvmIdentifiableElement identifiable) {
			return delegate.getActualType(identifiable);
		}

	}
	
	public List<LightweightTypeReference> getThrownExceptions(XExpression obj, IResolvedTypes types, ITypeReferenceOwner owner) {
		if (obj == null) {
			return Collections.emptyList();
		}
		final List<LightweightTypeReference> result = Lists.newArrayListWithExpectedSize(2);
		ThrownExceptionDelegate delegate = createDelegate(result, types, owner);
		Switch<Boolean> collector = createThrownExceptionCollector(delegate);
		delegate.collectWith(collector);
		delegate.collectThrownExceptions(obj);
		return result;
	}

	protected ThrownExceptionDelegate createDelegate(final List<LightweightTypeReference> result, IResolvedTypes types, ITypeReferenceOwner owner) {
		return new ThrownExceptionDelegate(result, types, owner);
	}
	
	protected Switch<Boolean> createThrownExceptionCollector(IThrownExceptionDelegate delegate) {
		return new ThrownExceptionSwitch(delegate);
	}
	
}
