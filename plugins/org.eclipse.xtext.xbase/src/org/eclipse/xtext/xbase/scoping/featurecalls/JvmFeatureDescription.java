/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import static org.eclipse.xtext.util.Strings.*;

import java.util.Collections;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmFeatureDescription extends EObjectDescription implements IValidatedEObjectDescription {

	private final TypeArgumentContext context;
	private String shadowingString;
	private Provider<String> shadowingStringProvider;
	private final boolean isValid;
	private XExpression implicitReceiver;
	private int numberOfIrrelevantArguments = 0;
	private String issueCode;

	public JvmFeatureDescription(QualifiedName qualifiedName, JvmFeature element, TypeArgumentContext context,
			String shadowingString, boolean isValid, XExpression implicitReceiver,
			int numberOfIrrelevantArguments) {
		super(qualifiedName, element, Collections.<String, String> emptyMap());
		this.context = context;
		this.shadowingString = shadowingString;
		this.shadowingStringProvider = null;
		this.isValid = isValid;
		this.implicitReceiver = implicitReceiver;
		this.numberOfIrrelevantArguments = numberOfIrrelevantArguments;
	}
	
	public JvmFeatureDescription(QualifiedName qualifiedName, JvmFeature element, TypeArgumentContext context,
			Provider<String> shadowingStringProvider, boolean isValid, XExpression implicitReceiver,
			int numberOfIrrelevantArguments) {
		super(qualifiedName, element, Collections.<String, String> emptyMap());
		this.context = context;
		this.shadowingStringProvider = shadowingStringProvider;
		this.isValid = isValid;
		this.implicitReceiver = implicitReceiver;
		this.numberOfIrrelevantArguments = numberOfIrrelevantArguments;
	}
	
	@Override
	public JvmIdentifiableElement getEObjectOrProxy() {
		return (JvmIdentifiableElement) super.getEObjectOrProxy();
	}

	public JvmFeature getJvmFeature() {
		return (JvmFeature) getEObjectOrProxy();
	}

	public TypeArgumentContext getContext() {
		return context;
	}

	public String getKey() {
		if (shadowingString == null && shadowingStringProvider != null) {
			shadowingString = shadowingStringProvider.get();
			shadowingStringProvider = null;
		}
		return shadowingString;
	}

	@Override
	public String toString() {
		return shadowingString;
	}

	public boolean isValid() {
		return isValid && isEmpty(issueCode);
	}

	public XExpression getImplicitReceiver() {
		return implicitReceiver;
	}

	public int getNumberOfIrrelevantArguments() {
		return numberOfIrrelevantArguments;
	}

	public void setIssueCode(String issueCode) {
		this.issueCode = issueCode;
	}

	public String getIssueCode() {
		return issueCode;
	}
}
