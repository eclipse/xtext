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
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

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
public class XFeatureCallSugarDescriptionProvider extends DefaultJvmFeatureDescriptionProvider {

	@Inject
	private OperatorMapping operatorMapping;

	public void setOperatorMapping(OperatorMapping operatorMapping) {
		this.operatorMapping = operatorMapping;
	}

	@Override
	public void addFeatureDescriptions(JvmFeature feature, final TypeArgumentContext context,
			IAcceptor<JvmFeatureDescription> acceptor) {
		if (feature instanceof JvmOperation) {
			JvmOperation op = (JvmOperation) feature;
			// handle operator mapping
			final int syntacticalNumberOfArguments = getSyntacticalNumberOfArguments(op);
			if (syntacticalNumberOfArguments<=1) {
				QualifiedName operator = operatorMapping.getOperator(QualifiedName.create(op.getSimpleName()));
				if (operator != null) {
					final String shadowingString = getSignature(op, context).replace(op.getSimpleName(),
							operator.toString());
					acceptor.accept(createJvmFeatureDescription(operator, op, context, shadowingString,
							isValid(feature)));
				}
			}
			if (syntacticalNumberOfArguments==0) {
				// allow invocation without parenthesis
				acceptor.accept(createJvmFeatureDescription(op, context, op.getSimpleName(), isValid(feature)));
				// handle property access for getter
				if (isGetterMethod(op)) {
					String propertyName = getPropertyNameForGetterMethod(op.getSimpleName());
					if (propertyName != null) {
						acceptor.accept(createJvmFeatureDescription(QualifiedName.create(propertyName), op, context,
								propertyName, isValid(feature)));
					}
				}
			}
		}
	}

	protected int getSyntacticalNumberOfArguments(JvmOperation op) {
		int numberOfArgs = op.getParameters().size();
		if (isExtensionProvider()) {
			numberOfArgs--;
		}
		return numberOfArgs;
	}

	protected boolean isGetterMethod(JvmOperation op) {
		if (getSyntacticalNumberOfArguments(op)!=0)
			return false;
		if (getPropertyNameForGetterMethod(op.getSimpleName()) == null)
			return false;
		if (op.getReturnType() == null)
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
