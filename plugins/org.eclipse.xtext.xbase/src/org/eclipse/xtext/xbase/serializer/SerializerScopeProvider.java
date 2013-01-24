/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.serializer;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.scoping.impl.SingletonScope;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Provides minimal scopes for the serialization of feature calls, e.g.
 * scopes that contain only a single element or two elements in case of aliased
 * feature names.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SerializerScopeProvider extends XbaseBatchScopeProvider implements IFeatureNames {

	@Inject
	private OperatorMapping operatorMapping;
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (isFeatureCallScope(reference)) {
			IScope result = createFeatureCallSerializationScope(context);
			return result;
		}
		return super.getScope(context, reference);
	}
	
	// TODO split this into smaller methods, investigate override / overload semantics
	// This assumes that the model was linked properly and not changed in an incompatible way
	// which is quite hard anyway ...
	public IScope createFeatureCallSerializationScope(EObject context) {
		if (!(context instanceof XAbstractFeatureCall)) {
			return IScope.NULLSCOPE;
		}
		XAbstractFeatureCall call = (XAbstractFeatureCall) context;
		JvmIdentifiableElement feature = call.getFeature();
		// this and super - logical container aware FeatureScopes
		if (feature instanceof JvmType) {
			return new SingletonScope(EObjectDescription.create(THIS, feature), IScope.NULLSCOPE);
		}
		if (feature instanceof JvmConstructor) {
			return new SingletonScope(EObjectDescription.create(THIS, feature), IScope.NULLSCOPE);
		}
		if (feature instanceof JvmExecutable) {
			QualifiedName name = QualifiedName.create(feature.getSimpleName());
			if (call instanceof XBinaryOperation || call instanceof XUnaryOperation) {
				QualifiedName operator = operatorMapping.getOperator(name);
				return new SingletonScope(EObjectDescription.create(operator, feature), IScope.NULLSCOPE);
			}
			if (call instanceof XAssignment) {
				String propertyName = Strings.toFirstLower(feature.getSimpleName().substring(3));
				return new SingletonScope(EObjectDescription.create(propertyName, feature), IScope.NULLSCOPE);
			}
			if (call.isExplicitOperationCallOrBuilderSyntax() || ((JvmExecutable) feature).getParameters().size() >= 1) {
				return new SingletonScope(EObjectDescription.create(name, feature), IScope.NULLSCOPE);
			}
			if (feature.getSimpleName().startsWith("get") || feature.getSimpleName().startsWith("is")) {
				List<IEObjectDescription> result = Lists.newArrayListWithCapacity(2);
				result.add(EObjectDescription.create(name, feature));
				if (feature.getSimpleName().startsWith("get")) {
					String propertyName = Strings.toFirstLower(feature.getSimpleName().substring(3));
					result.add(EObjectDescription.create(propertyName, feature));
				} else {
					String propertyName = Strings.toFirstLower(feature.getSimpleName().substring(2));
					result.add(EObjectDescription.create(propertyName, feature));
				}
				return new SimpleScope(result);
			}
			return new SingletonScope(EObjectDescription.create(name, feature), IScope.NULLSCOPE);
		}
		if (feature instanceof JvmFormalParameter || feature instanceof JvmField || feature instanceof XVariableDeclaration) {
			return new SingletonScope(EObjectDescription.create(feature.getSimpleName(), feature), IScope.NULLSCOPE);
		}
		if (feature instanceof XSwitchExpression) {
			return new SingletonScope(EObjectDescription.create(feature.getSimpleName(), feature), IScope.NULLSCOPE);
		}
		return IScope.NULLSCOPE;
	}
}
