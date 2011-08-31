/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.withexpression;

import static com.google.common.collect.Iterables.*;

import java.util.Collection;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XWithExpression;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.impl.XWithExpressionSupport;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendField;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendWithExpressionSupport extends XWithExpressionSupport {

	@Inject
	private TypeArgumentContextProvider contextProvider;

	@Inject
	private IXtend2JvmAssociations jvmAssociations;

	@Inject
	private OnChangeEvictingCache cache;
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Override
	public Object evaluateMainExpression(XWithExpression expr, IEvaluationContext context, CancelIndicator indicator,
			XbaseInterpreter xbaseInterpreter) {
		throw new UnsupportedOperationException("Xtend doesn't support interpretation mode");
	}
	
	@Override
	public void prepareMainExpressionAsJavaStatement(XWithExpression expr, IAppendable b, XbaseCompiler xbaseCompiler) {
		JvmTypeReference expectedType = typeProvider.getExpectedType(expr);
		XExpression expression = getSingleExpressionToFactory(expr, expectedType);
		if (expression == null) {
			super.prepareMainExpressionAsJavaStatement(expr, b, xbaseCompiler);
		} else {
			xbaseCompiler.toJavaStatement(expression, b, true);
		}
	}
	
	@Override
	public void mainExpressionAsJavaExpression(XWithExpression expr, IAppendable b, XbaseCompiler xbaseCompiler) {
		JvmTypeReference expectedType = typeProvider.getExpectedType(expr);
		XExpression expression = getSingleExpressionToFactory(expr, expectedType);
		if (expression == null) {
			super.mainExpressionAsJavaExpression(expr, b, xbaseCompiler);
		} else {
			xbaseCompiler.toJavaExpression(expression, b);
		}
	}

	@Override
	public boolean isConstructionInferrable(XWithExpression expr, JvmTypeReference expectedType) {
		return super.isConstructionInferrable(expr, expectedType) || getSingleExpressionToFactory(expr, expectedType) != null;
	}

	protected XExpression getSingleExpressionToFactory(final XWithExpression expr, JvmTypeReference expectedType) {
		if (expectedType == null)
			return null;
		Collection<XExpression> collection = getAvailableFactoryExpressions(expr).get(expectedType.getIdentifier());
		if (collection.isEmpty() || collection.size() > 1) {
			return null;
		} else {
			return collection.iterator().next();
		}
	}

	protected Multimap<String, XExpression> getAvailableFactoryExpressions(final XWithExpression expr) {
		return cache.get("instancefactories", expr.eResource(), new Provider<Multimap<String, XExpression>>() {
			public Multimap<String, XExpression> get() {
				XtendClass xtendClass = EcoreUtil2.getContainerOfType(expr, XtendClass.class);
				Iterable<XtendField> fields = filter(xtendClass.getMembers(), XtendField.class);
				Multimap<String, XExpression> typeToCreationExpressions = ArrayListMultimap.create();
				for (XtendField field : fields) {
					if (field.isInstancefactory()) {
						JvmField jvmField = jvmAssociations.getJvmField(field);
						final JvmTypeReference type = field.getType();
						TypeArgumentContext context = contextProvider.getReceiverContext(type);
						Iterable<JvmFeature> features = ((JvmGenericType) type.getType()).getAllFeatures();
						for (JvmFeature jvmFeature : features) {
							if (jvmFeature instanceof JvmOperation) {
								final JvmOperation jvmOperation = (JvmOperation) jvmFeature;
								if (jvmOperation.getParameters().isEmpty()) {
									JvmTypeReference returnType = context.resolve(jvmOperation.getReturnType());
									XFeatureCall callToThis = XbaseFactory.eINSTANCE.createXFeatureCall();
									callToThis.setFeature(xtendClass);
									XMemberFeatureCall callToField = XbaseFactory.eINSTANCE.createXMemberFeatureCall();
									callToField.setFeature(jvmField);
									callToField.setMemberCallTarget(callToThis);
									XMemberFeatureCall callToFactory = XbaseFactory.eINSTANCE
											.createXMemberFeatureCall();
									callToFactory.setFeature(jvmFeature);
									callToFactory.setMemberCallTarget(callToField);
									typeToCreationExpressions.put(returnType.getIdentifier(), callToFactory);
								}
							}
						}
					}
				}
				return typeToCreationExpressions;
			}
		});
	}
}
