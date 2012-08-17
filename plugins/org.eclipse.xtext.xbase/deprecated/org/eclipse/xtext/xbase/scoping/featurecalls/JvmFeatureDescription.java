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
import java.util.EnumSet;
import java.util.List;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeConformanceResult;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public class JvmFeatureDescription extends EObjectDescription implements IValidatedEObjectDescription {

	private static enum CheckState {
		UNCHECKED, FAST_CHECKED, TYPES_CHECKED, GENERICS_CHECKED
	}
	
	private final ITypeArgumentContext rawTypeContext;
	private ITypeArgumentContext genericTypeContext;
	private String shadowingString;
	private Provider<String> shadowingStringProvider;
	private final boolean isVisible;
	private XExpression implicitReceiver;
	private XExpression implicitArgument;
	private int numberOfIrrelevantArguments = 0;
	private String issueCode;
	private CheckState checkState;
	private List<EnumSet<TypeConformanceResult.Kind>> argumentConversionHints;
	private boolean isValidStaticState;

	public JvmFeatureDescription(
			QualifiedName qualifiedName, 
			JvmFeature feature, 
			ITypeArgumentContext rawTypeContext,
			String shadowingString, 
			boolean isVisible, 
			boolean isValidStaticState,
			XExpression implicitReceiver,
			XExpression implicitArgument,
			int numberOfIrrelevantArguments) {
		this(qualifiedName, feature, rawTypeContext, isVisible, isValidStaticState, implicitReceiver, implicitArgument, numberOfIrrelevantArguments);
		this.shadowingString = shadowingString;
		this.shadowingStringProvider = null;
	}
	
	public JvmFeatureDescription(
			QualifiedName qualifiedName, 
			JvmFeature feature, 
			ITypeArgumentContext rawTypeContext,
			Provider<String> shadowingStringProvider, 
			boolean isVisible, 
			boolean isValidStaticState,
			XExpression implicitReceiver,
			XExpression implicitArgument,
			int numberOfIrrelevantArguments) {
		this(qualifiedName, feature, rawTypeContext, isVisible, isValidStaticState, implicitReceiver, implicitArgument, numberOfIrrelevantArguments);
		this.shadowingStringProvider = shadowingStringProvider;
	}
	
	private JvmFeatureDescription(
			QualifiedName qualifiedName, 
			JvmFeature feature, 
			ITypeArgumentContext rawTypeContext,
			boolean isVisible, 
			boolean isValidStaticState, 
			XExpression implicitReceiver,
			XExpression implicitArgument,
			int numberOfIrrelevantArguments) {
		super(qualifiedName, feature, Collections.<String, String> emptyMap());
		this.rawTypeContext = rawTypeContext;
		this.isVisible = isVisible;
		this.isValidStaticState = isValidStaticState;
		this.implicitReceiver = implicitReceiver;
		this.implicitArgument = implicitArgument;
		this.numberOfIrrelevantArguments = numberOfIrrelevantArguments;
		this.checkState = CheckState.UNCHECKED;
	}
	
	@Override
	public JvmIdentifiableElement getEObjectOrProxy() {
		return (JvmIdentifiableElement) super.getEObjectOrProxy();
	}

	public JvmFeature getJvmFeature() {
		return (JvmFeature) getEObjectOrProxy();
	}

	public ITypeArgumentContext getRawTypeContext() {
		return rawTypeContext;
	}
	
	public ITypeArgumentContext getGenericTypeContext() {
		if (genericTypeContext != null)
			return genericTypeContext;
		return rawTypeContext;
	}

	public void setGenericTypeContext(ITypeArgumentContext genericTypeContext) {
		this.genericTypeContext = genericTypeContext;
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
		return isVisible && isEmpty(issueCode);
	}
	
	public boolean isVisible() {
		return isVisible;
	}
	
	public boolean isValidStaticState() {
		return isValidStaticState;
	}

	public XExpression getImplicitReceiver() {
		return implicitReceiver;
	}
	
	public XExpression getImplicitArgument() {
		return implicitArgument;
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

	public boolean isGenericsChecked() {
		return this.checkState == CheckState.GENERICS_CHECKED;
	}

	public void setGenericsChecked() {
		this.checkState = CheckState.GENERICS_CHECKED;
	}

	public boolean isTypesChecked() {
		return this.checkState == CheckState.GENERICS_CHECKED || this.checkState == CheckState.TYPES_CHECKED;
	}

	public void setTypesChecked() {
		this.checkState = CheckState.TYPES_CHECKED;
	}
	
	public boolean isFastChecked() {
		return this.checkState != CheckState.UNCHECKED;
	}

	public void setFastChecked() {
		this.checkState = CheckState.FAST_CHECKED;
	}
	
	public List<EnumSet<TypeConformanceResult.Kind>> getArgumentConversionHints() {
		return argumentConversionHints;
	}

	public void setArgumentConversionHints(List<EnumSet<TypeConformanceResult.Kind>> argumentConversionHints) {
		this.argumentConversionHints = argumentConversionHints;
	}
	
	public boolean isSameValidationState(IValidatedEObjectDescription other) {
		if (other instanceof JvmFeatureDescription) {
			return checkState.equals(((JvmFeatureDescription) other).checkState);
		}
		return isGenericsChecked();
	}

}