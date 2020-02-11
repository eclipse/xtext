/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import java.util.List
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.util.internal.Stopwatches
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer
import org.eclipse.xtext.xbase.typesystem.internal.AbstractPendingLinkingCandidate
import org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionAwareStackedResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.ReassigningStackedResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.StackedResolvedTypes
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author Sebastian Zarnekow
 */
class InvariantCheckingBatchTypeResolverTest extends AbstractBatchTypeResolverTest {
	
	@Inject
	InvariantCheckingBatchTypeResolver typeResolver;
	
	override getTypeResolver() {
		typeResolver
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class InvariantCheckingBatchTypeResolver extends DefaultBatchTypeResolver {

	@Inject
	Provider<ValidatingReentrantTypeResolver> resolverProvider

	override protected createResolver() {
		resolverProvider.get
	}

}

/**
 * @author Sebastian Zarnekow
 */
class EagerBatchTypeResolver extends DefaultBatchTypeResolver {

	@Inject
	Provider<EagerReentrantTypeResolver> resolverProvider

	override protected createResolver() {
		resolverProvider.get
	}
			
}

/**
 * @author Sebastian Zarnekow
 */
class InvariantCheckingEagerBatchTypeResolver extends DefaultBatchTypeResolver {

	@Inject
	Provider<InvariantCheckingEagerReentrantTypeResolver> resolverProvider

	override protected createResolver() {
		resolverProvider.get
	}
			
}

/**
 * @author Sebastian Zarnekow
 */
class EagerReentrantTypeResolver extends DefaultReentrantTypeResolver {
	
	@Inject
	EagerArgumentTypeComputer typeComputer
	
	override protected getTypeComputer() {
		typeComputer
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class InvariantCheckingEagerReentrantTypeResolver extends EagerReentrantTypeResolver {
	
	override protected createResolvedTypes(CancelIndicator monitor) {
		return new ValidatingRootResolvedTypes(this, monitor)
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
@Singleton
class EagerArgumentTypeComputer extends XbaseTypeComputer {
	
	override protected ILinkingCandidate getBestCandidate(List<? extends ILinkingCandidate> candidates) {
		candidates.forEach[
			if (it instanceof AbstractPendingLinkingCandidate<?>)
				it.computeArgumentTypes()
		]
		super.getBestCandidate(candidates)
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class TimedBatchTypeResolver extends DefaultBatchTypeResolver {

	@Inject
	Provider<TimedReentrantTypeResolver> resolverProvider;

	override createResolver() {
		resolverProvider.get
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class TimedReentrantTypeResolver extends DefaultReentrantTypeResolver {
	
	override createResolvedTypes(CancelIndicator monitor) {
		return new TimedRootResolvedTypes(this, new TypeResolutionTimes(), monitor)
	}
	
}

class TypeResolutionTimes {
	
	public val getFeatureTask = Stopwatches::forTask('StackedResolvedTypes.getFeature')
	public val getHintsTask = Stopwatches::forTask('StackedResolvedTypes.getHints')
	public val getActualTypeTask = Stopwatches::forTask('StackedResolvedTypes.getActualType(identifiable)')
	public val getActualExpressionTypeTask = Stopwatches::forTask('StackedResolvedTypes.getActualType(expression)')
	
}

/**
 * @author Sebastian Zarnekow
 */
class TimedRootResolvedTypes extends RootResolvedTypes {
	
	TypeResolutionTimes times
	
	new(DefaultReentrantTypeResolver resolver, TypeResolutionTimes times, CancelIndicator monitor) {
		super(resolver, monitor)
		this.times = times
	}
	
	override pushReassigningTypes() {
		return new TimedReassigningResolvedTypes(this, times)
	}
	
	override pushTypes() {
		return new TimedStackedResolvedTypes(this, times)
	}
	
	override pushTypes(XExpression context) {
		return new TimedExpressionAwareResolvedTypes(this, context, times)
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class TimedExpressionAwareResolvedTypes extends ExpressionAwareStackedResolvedTypes {
	
	TypeResolutionTimes times
	
	new(ResolvedTypes parent, XExpression expression, TypeResolutionTimes times) {
		super(parent, expression)
		this.times = times
	}
	
	override pushReassigningTypes() {
		return new TimedReassigningResolvedTypes(this, times)
	}
	
	override pushTypes() {
		return new TimedStackedResolvedTypes(this, times)
	}
	
	override pushTypes(XExpression context) {
		return new TimedExpressionAwareResolvedTypes(this, context, times)
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class TimedStackedResolvedTypes extends StackedResolvedTypes {
	
	TypeResolutionTimes times
	
	new(ResolvedTypes parent, TypeResolutionTimes times) {
		super(parent)
		this.times = times
	}
	
	override pushReassigningTypes() {
		return new TimedReassigningResolvedTypes(this, times)
	}
	
	override pushTypes() {
		return new TimedStackedResolvedTypes(this, times)
	}
	
	override pushTypes(XExpression context) {
		return new TimedExpressionAwareResolvedTypes(this, context, times)
	}
	
	override doGetFeature(XAbstractFeatureCall featureCall) {
		try {
			times.getFeatureTask.start
			super.getFeature(featureCall)
		} finally {
			times.getFeatureTask.stop
		}
	}
	
	override getActualType(JvmIdentifiableElement identifiable) {
		try {
			times.getActualTypeTask.start
			super.getActualType(identifiable)
		} finally {
			times.getActualTypeTask.stop
		}
	}
	
	override getActualType(XExpression expression) {
		try {
			times.getActualExpressionTypeTask.start
			super.getActualType(expression)
		} finally {
			times.getActualExpressionTypeTask.stop
		}
	}
	
	override getAllHints(Object handle) {
		try {
			times.getHintsTask.start
			super.getAllHints(handle)
		} finally {
			times.getHintsTask.stop
		}
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class TimedReassigningResolvedTypes extends ReassigningStackedResolvedTypes {
	
	TypeResolutionTimes times
	
	new(ResolvedTypes parent, TypeResolutionTimes times) {
		super(parent)
		this.times = times
	}
	
	override pushReassigningTypes() {
		return new TimedReassigningResolvedTypes(this, times)
	}
	
	override pushTypes() {
		return new TimedStackedResolvedTypes(this, times)
	}
	
	override pushTypes(XExpression context) {
		return new TimedExpressionAwareResolvedTypes(this, context, times)
	}
	
}

