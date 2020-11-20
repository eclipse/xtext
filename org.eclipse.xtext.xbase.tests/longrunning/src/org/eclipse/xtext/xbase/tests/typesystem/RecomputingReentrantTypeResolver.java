/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IApplicableCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IClosureCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.internal.ITypeLiteralLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.internal.ImplicitFirstArgument;
import org.eclipse.xtext.xbase.typesystem.internal.ImplicitReceiver;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeInsteadOfConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow
 */
public class RecomputingReentrantTypeResolver extends PublicReentrantTypeResolver {
	@Inject
	private ReflectExtensions reflectExtensions;

	private Joiner.MapJoiner mapJoiner = Joiner.on("\n").withKeyValueSeparator("=");

	@Override
	public RootResolvedTypes createResolvedTypes(CancelIndicator monitor) {
		return new RecordingRootResolvedTypes(this, CancelIndicator.NullImpl);
	}

	@Override
	public IResolvedTypes resolve(CancelIndicator monitor) {
		RecordingRootResolvedTypes firstResult = (RecordingRootResolvedTypes) super.resolve(monitor);
		Map<XExpression, IApplicableCandidate> firstRun = firstResult.getResolvedProxies();
		RecordingRootResolvedTypes result = (RecordingRootResolvedTypes) super.resolve(monitor);
		Map<XExpression, IApplicableCandidate> secondRun = result.getResolvedProxies();
		Assert.assertEquals(vs(mapJoiner.join(firstRun), mapJoiner.join(secondRun)), firstRun.size(), secondRun.size());
		Joiner setJoiner = Joiner.on("\n");
		Assert.assertEquals(vs(setJoiner.join(firstRun.keySet()), setJoiner.join(secondRun.keySet())), firstRun.keySet(),
				secondRun.keySet());
		firstRun.forEach((XExpression expression, IApplicableCandidate firstLinkingData) -> {
			IApplicableCandidate secondLinkingData = secondRun.get(expression);
			try {
				assertEqualLinkingData(firstLinkingData, secondLinkingData);
			} catch (Exception e) {
				Exceptions.sneakyThrow(e);
			}
			Assert.assertEquals(firstResult.isRefinedType(expression), result.isRefinedType(expression));
		});
		return result;
	}

	public String vs(String a, String b) {
		return 
				a + "\n" +
				"	\n" +
				"	vs\n" +
				"	\n" + b;
	}

	protected void _assertEqualLinkingData(IApplicableCandidate left, IApplicableCandidate right) {
		Assert.fail(left + " vs " + right);
	}

	protected void _assertEqualLinkingData(IClosureCandidate left, IClosureCandidate right) {
		Assert.assertEquals("type", left.getParameters().size(), right.getParameters().size());
		IterableExtensions.forEach(left.getParameters(), (JvmFormalParameter leftParam, Integer idx) -> {
			JvmFormalParameter rightParam = right.getParameters().get(idx.intValue());
			Assert.assertEquals(leftParam.getName(), rightParam.getName());
			if (XbasePackage.Literals.XCLOSURE__DECLARED_FORMAL_PARAMETERS != leftParam.eContainingFeature()) {
				Assert.assertEquals(leftParam.getParameterType().getIdentifier(), rightParam.getParameterType().getIdentifier());
			}
		});
	}

	protected void _assertEqualLinkingData(ITypeLiteralLinkingCandidate left, ITypeLiteralLinkingCandidate right) throws Exception {
		Assert.assertEquals("type", left.getType(), right.getType());
		Assert.assertEquals("featureCall", left.getFeatureCall(), right.getFeatureCall());
		doAssertEqualLinkingData(left, right);
		Assert.assertEquals("isStatic", left.isStatic(), right.isStatic());
		Assert.assertEquals("isTypeLiteral", left.isTypeLiteral(), right.isTypeLiteral());
		Assert.assertEquals("isExtension", left.isExtension(), right.isExtension());
	}

	protected void _assertEqualLinkingData(ITypeLiteralLinkingCandidate left, ILinkingCandidate right) {
		Assert.fail(left + " vs " + right);
	}

	protected void _assertEqualLinkingData(ILinkingCandidate left, ITypeLiteralLinkingCandidate right) {
		Assert.fail(left + " vs " + right);
	}

	protected void _assertEqualLinkingData(IConstructorLinkingCandidate left, IConstructorLinkingCandidate right) throws Exception {
		Assert.assertEquals("constructor", left.getConstructor(), right.getConstructor());
		Assert.assertEquals("constructorCall", left.getConstructorCall(), right.getConstructorCall());
		doAssertEqualLinkingData(left, right);
	}

	protected void _assertEqualLinkingData(TypeInsteadOfConstructorLinkingCandidate left, IConstructorLinkingCandidate right) {
		Assert.fail(left + " vs " + right);
	}

	protected void _assertEqualLinkingData(IConstructorLinkingCandidate left, TypeInsteadOfConstructorLinkingCandidate right) {
		Assert.fail(left + " vs " + right);
	}

	protected void _assertEqualLinkingData(TypeInsteadOfConstructorLinkingCandidate left, TypeInsteadOfConstructorLinkingCandidate right)
			throws Exception {
		Assert.assertEquals("feature", left.getFeature(), right.getFeature());
		Assert.assertEquals("constructorCall", left.getConstructorCall(), right.getConstructorCall());
		assertEqualReferences("typeArguments", left.getTypeArguments(), right.getTypeArguments());
		assertEqualReferences("syntacticTypeArguments", invokeAndCast(left, "getSyntacticTypeArguments"),
				invokeAndCast(right, "getSyntacticTypeArguments"));
		Assert.assertEquals("arguments", reflectExtensions.invoke(left, "getArguments"), reflectExtensions.invoke(right, "getArguments"));
	}

	protected void _assertEqualLinkingData(ImplicitReceiver left, IFeatureLinkingCandidate right) {
		Assert.fail(left + " vs " + right);
	}

	protected void _assertEqualLinkingData(IFeatureLinkingCandidate left, ImplicitReceiver right) {
		Assert.fail(left + " vs " + right);
	}

	protected void _assertEqualLinkingData(ImplicitReceiver left, ImplicitReceiver right) {
		Assert.assertEquals("feature", left.getFeature(), right.getFeature());
		Assert.assertEquals("featureCall", left.getFeatureCall(), right.getFeatureCall());
		assertEqualReferences("typeArguments", left.getTypeArguments(), right.getTypeArguments());
	}

	protected void _assertEqualLinkingData(ImplicitFirstArgument left, ImplicitFirstArgument right) {
		Assert.assertEquals("feature", left.getFeature(), right.getFeature());
		Assert.assertEquals("featureCall", left.getFeatureCall(), right.getFeatureCall());
		assertEqualReferences("typeArguments", left.getTypeArguments(), right.getTypeArguments());
	}

	protected void _assertEqualLinkingData(IFeatureLinkingCandidate left, IFeatureLinkingCandidate right) throws Exception {
		Assert.assertEquals("feature", left.getFeature(), right.getFeature());
		Assert.assertEquals("featureCall", left.getFeatureCall(), right.getFeatureCall());
		doAssertEqualLinkingData(left, right);
		Assert.assertEquals("receiver", reflectExtensions.invoke(left, "getReceiver"), reflectExtensions.invoke(right, "getReceiver"));
		assertEqualTypes("receiverType", invokeAndCast(left, "getReceiverType"), invokeAndCast(left, "getReceiverType"));
		Assert.assertEquals("implicitReceiver", reflectExtensions.invoke(left, "getImplicitReceiver"),
				reflectExtensions.invoke(right, "getImplicitReceiver"));
		assertEqualTypes("implicitReceiverType", invokeAndCast(left, "getImplicitReceiverType"),
				invokeAndCast(left, "getImplicitReceiverType"));
		Assert.assertEquals("implicitFirstArgument", reflectExtensions.invoke(left, "getImplicitFirstArgument"),
				reflectExtensions.invoke(right, "getImplicitFirstArgument"));
		assertEqualTypes("implicitFirstArgumentType", invokeAndCast(left, "getImplicitFirstArgumentType"),
				invokeAndCast(left, "getImplicitFirstArgumentType"));
		Assert.assertEquals("syntacticReceiver", reflectExtensions.invoke(left, "getSyntacticReceiver"),
				reflectExtensions.invoke(right, "getSyntacticReceiver"));
		assertEqualTypes("syntacticReceiverType", invokeAndCast(left, "getSyntacticReceiverType"),
				invokeAndCast(left, "getSyntacticReceiverType"));
		Assert.assertEquals("isStatic", left.isStatic(), right.isStatic());
		Assert.assertEquals("isTypeLiteral", left.isTypeLiteral(), right.isTypeLiteral());
		Assert.assertEquals("syntacticReceiver", reflectExtensions.invoke(left, "getSyntacticReceiver"),
				reflectExtensions.invoke(right, "getSyntacticReceiver"));
		Assert.assertEquals("isExtension", left.isExtension(), right.isExtension());
		Assert.assertEquals("syntacticArguments", reflectExtensions.invoke(left, "getSyntacticArguments"),
				reflectExtensions.invoke(right, "getSyntacticArguments"));
	}

	public void doAssertEqualLinkingData(ILinkingCandidate left, ILinkingCandidate right) throws Exception {
		assertEqualReferences("typeArguments", left.getTypeArguments(), right.getTypeArguments());
		assertEqualReferences("syntacticTypeArguments", invokeAndCast(left, "getSyntacticTypeArguments"),
				invokeAndCast(right, "getSyntacticTypeArguments"));
		Assert.assertEquals("arguments", reflectExtensions.invoke(left, "getArguments"), reflectExtensions.invoke(right, "getArguments"));
		Assert.assertEquals("declaredTypeParameters", reflectExtensions.invoke(left, "getDeclaredTypeParameters"),
				reflectExtensions.invoke(right, "getDeclaredTypeParameters"));
		assertEqualMapping("typeParameterMapping", invokeAndCast(left, "getTypeParameterMapping"),
				invokeAndCast(right, "getTypeParameterMapping"));
		assertEqualMapping("declaratorParameterMapping", invokeAndCast(left, "getDeclaratorParameterMapping"),
				invokeAndCast(right, "getDeclaratorParameterMapping"));
	}

	public void assertEqualTypes(String message, LightweightTypeReference left, LightweightTypeReference right) {
		Assert.assertEquals(message, left == null ? null : left.toString(), right == null ? null : right.toString());
	}

	public void assertEqualReferences(String message, List<LightweightTypeReference> left, List<LightweightTypeReference> right) {
		Assert.assertEquals(message, Lists.transform(left, LightweightTypeReference::toString),
				Lists.transform(right, LightweightTypeReference::toString));
	}

	public void assertEqualMapping(String message, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> left,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> right) {
		Assert.assertEquals(message + ":\n" + vs(mapJoiner.join(left), mapJoiner.join(right)), left.size(), right.size());
		Assert.assertEquals(message + ":\n" + vs(mapJoiner.join(left), mapJoiner.join(right)), left.keySet(), right.keySet());
		left.forEach((JvmTypeParameter typeParam, LightweightMergedBoundTypeArgument leftData) -> {
			LightweightMergedBoundTypeArgument rightData = right.get(typeParam);
			Assert.assertEquals(leftData.getVariance(), rightData.getVariance());
			Assert.assertEquals(leftData.getTypeReference().getSimpleName(), rightData.getTypeReference().getSimpleName());
		});
	}

	@SuppressWarnings("unchecked")
	public <T extends Object> T invokeAndCast(ILinkingCandidate receiver, String getter) throws Exception {
		Object _invoke = reflectExtensions.invoke(receiver, getter);
		return (T) _invoke;
	}

	public void assertEqualLinkingData(IApplicableCandidate left, IApplicableCandidate right) throws Exception {
		if (left instanceof ImplicitFirstArgument && right instanceof ImplicitFirstArgument) {
			_assertEqualLinkingData((ImplicitFirstArgument) left, (ImplicitFirstArgument) right);
			return;
		} else if (left instanceof ImplicitReceiver && right instanceof ImplicitReceiver) {
			_assertEqualLinkingData((ImplicitReceiver) left, (ImplicitReceiver) right);
			return;
		} else if (left instanceof ImplicitReceiver && right instanceof IFeatureLinkingCandidate) {
			_assertEqualLinkingData((ImplicitReceiver) left, (IFeatureLinkingCandidate) right);
			return;
		} else if (left instanceof ITypeLiteralLinkingCandidate && right instanceof ITypeLiteralLinkingCandidate) {
			_assertEqualLinkingData((ITypeLiteralLinkingCandidate) left, (ITypeLiteralLinkingCandidate) right);
			return;
		} else if (left instanceof TypeInsteadOfConstructorLinkingCandidate && right instanceof TypeInsteadOfConstructorLinkingCandidate) {
			_assertEqualLinkingData((TypeInsteadOfConstructorLinkingCandidate) left, (TypeInsteadOfConstructorLinkingCandidate) right);
			return;
		} else if (left instanceof TypeInsteadOfConstructorLinkingCandidate && right instanceof IConstructorLinkingCandidate) {
			_assertEqualLinkingData((TypeInsteadOfConstructorLinkingCandidate) left, (IConstructorLinkingCandidate) right);
			return;
		} else if (left instanceof ITypeLiteralLinkingCandidate && right instanceof ILinkingCandidate) {
			_assertEqualLinkingData((ITypeLiteralLinkingCandidate) left, (ILinkingCandidate) right);
			return;
		} else if (left instanceof IFeatureLinkingCandidate && right instanceof ImplicitReceiver) {
			_assertEqualLinkingData((IFeatureLinkingCandidate) left, (ImplicitReceiver) right);
			return;
		} else if (left instanceof IConstructorLinkingCandidate && right instanceof TypeInsteadOfConstructorLinkingCandidate) {
			_assertEqualLinkingData((IConstructorLinkingCandidate) left, (TypeInsteadOfConstructorLinkingCandidate) right);
			return;
		} else if (left instanceof IConstructorLinkingCandidate && right instanceof IConstructorLinkingCandidate) {
			_assertEqualLinkingData((IConstructorLinkingCandidate) left, (IConstructorLinkingCandidate) right);
			return;
		} else if (left instanceof IFeatureLinkingCandidate && right instanceof IFeatureLinkingCandidate) {
			_assertEqualLinkingData((IFeatureLinkingCandidate) left, (IFeatureLinkingCandidate) right);
			return;
		} else if (left instanceof ILinkingCandidate && right instanceof ITypeLiteralLinkingCandidate) {
			_assertEqualLinkingData((ILinkingCandidate) left, (ITypeLiteralLinkingCandidate) right);
			return;
		} else if (left instanceof IClosureCandidate && right instanceof IClosureCandidate) {
			_assertEqualLinkingData((IClosureCandidate) left, (IClosureCandidate) right);
			return;
		} else if (left != null && right != null) {
			_assertEqualLinkingData(left, right);
			return;
		} else {
			throw new IllegalArgumentException("Unhandled parameter types: " + Arrays.<Object> asList(left, right).toString());
		}
	}
}
