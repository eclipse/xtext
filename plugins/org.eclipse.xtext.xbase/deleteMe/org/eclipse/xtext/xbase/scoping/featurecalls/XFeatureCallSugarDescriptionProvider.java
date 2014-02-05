/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.beans.Introspector;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * 
 * Constructs sugared {@link JvmFeatureDescription}s for - {@link org.eclipse.xtext.xbase.XFeatureCall} -
 * {@link org.eclipse.xtext.xbase.XMemberFeatureCall} - {@link org.eclipse.xtext.xbase.XBinaryOperation}
 * 
 * This includes operator overloading for {@link org.eclipse.xtext.xbase.XBinaryOperation}, invocation of
 * unparameterized methods without parenthesis, and access to getters using the property name (i.e. getFoo -> foo)
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
@Deprecated
public class XFeatureCallSugarDescriptionProvider extends DefaultJvmFeatureDescriptionProvider {

	@Inject
	private OperatorMapping operatorMapping;

	public void setOperatorMapping(OperatorMapping operatorMapping) {
		this.operatorMapping = operatorMapping;
	}

	@Override
	protected void doCollectDescriptions(final String name, IFeaturesForTypeProvider featureProvider, JvmTypeReference typeReference, ITypeArgumentContext context,
			Iterable<JvmTypeReference> hierarchy, final IAcceptor<JvmFeatureDescription> acceptor) {
		IAcceptor<JvmFeatureDescription> myAcceptor = new IAcceptor<JvmFeatureDescription>() {
			public void accept(JvmFeatureDescription t) {
				if (name.equals(t.getName().toString())) {
					acceptor.accept(t);
				}
			}
		};
		super.doCollectDescriptions(name, featureProvider, typeReference, context, hierarchy, myAcceptor);
		QualifiedName methodName = operatorMapping.getMethodName(QualifiedName.create(name));
		if (methodName != null) {
			super.doCollectDescriptions(methodName.toString(), featureProvider, typeReference, context, hierarchy, myAcceptor);	
		} else {
			String getterAlias = "get" + Strings.toFirstUpper(name);
			super.doCollectDescriptions(getterAlias, featureProvider, typeReference, context, hierarchy, myAcceptor);
			String isAlias = "is" + Strings.toFirstUpper(name);
			super.doCollectDescriptions(isAlias, featureProvider, typeReference, context, hierarchy, myAcceptor);
		}
	}
	
	@Override
	public void addFeatureDescriptions(JvmFeature feature, final ITypeArgumentContext context,
			IAcceptor<JvmFeatureDescription> acceptor) {
		if (feature instanceof JvmOperation) {
			final JvmOperation op = (JvmOperation) feature;
			// handle operator mapping
			final int syntacticalNumberOfArguments = getSyntacticalNumberOfArguments(op);
			if (syntacticalNumberOfArguments<=1) {
				final QualifiedName operator = operatorMapping.getOperator(QualifiedName.create(op.getSimpleName()));
				if (operator != null) {
					final Provider<String> originalShadowingStringProvider = getSignature(feature, context);
					Provider<String> shadowingStringProvider = new Provider<String>() {
						public String get() {
							final String result = operator.toString() + 
								originalShadowingStringProvider.get().substring(op.getSimpleName().length());
							return result;
						}
					};
					acceptor.accept(createJvmFeatureDescription(operator, op, context, shadowingStringProvider,
							isVisible(feature), isValidStaticState(feature)));
				}
			}
			if (syntacticalNumberOfArguments==0) {
				// allow invocation without parenthesis
				acceptor.accept(createJvmFeatureDescription(op, context, new Provider<String>() {
					public String get() {
						return op.getSimpleName();
					}
				}, isVisible(feature), isValidStaticState(feature)));
				// handle property access for getter
				if (isGetterMethod(op)) {
					String propertyName = getPropertyNameForGetterMethod(op.getSimpleName());
					if (propertyName != null) {
						acceptor.accept(createJvmFeatureDescription(QualifiedName.create(propertyName), op, context,
								propertyName, isVisible(feature), isValidStaticState(feature)));
					}
				}
			}
		}
	}

	protected int getSyntacticalNumberOfArguments(JvmOperation op) {
		int numberOfArgs = op.getParameters().size();
		if (numberOfArgs == 0)
			return numberOfArgs;
		if (isExtensionProvider() || implicitArgument != null) {
			numberOfArgs--;
		}
		if (numberOfArgs == 1 && op.isVarArgs()) {
			numberOfArgs--;
		}
		return numberOfArgs;
	}

	protected boolean isGetterMethod(JvmOperation op) {
		if (getSyntacticalNumberOfArguments(op)!=0)
			return false;
		if (op.isVarArgs())
			return false;
		if (getPropertyNameForGetterMethod(op.getSimpleName()) == null)
			return false;
		return true;
	}

	protected String getPropertyNameForGetterMethod(String opName) {
		if (opName.startsWith("get") && opName.length() > 3 && Character.isUpperCase(opName.charAt(3)))
			return Introspector.decapitalize(opName.substring(3));

		if (opName.startsWith("is") && opName.length() > 2 && Character.isUpperCase(opName.charAt(2)))
			return Introspector.decapitalize(opName.substring(2));
		return null;
	}

}
