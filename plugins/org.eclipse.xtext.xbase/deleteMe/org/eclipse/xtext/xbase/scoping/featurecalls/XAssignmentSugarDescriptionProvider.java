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

import com.google.inject.Provider;

/**
 * creates assignment feature descriptions for setter methods.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public class XAssignmentSugarDescriptionProvider extends DefaultJvmFeatureDescriptionProvider {
	
	@Override
	public void addFeatureDescriptions(JvmFeature feature, ITypeArgumentContext context,
			IAcceptor<JvmFeatureDescription> acceptor) {
		if (feature instanceof JvmOperation) {
			final JvmOperation jvmOperation = (JvmOperation) feature;
			if (isSetterMethod(jvmOperation)) {
				final String propertyName = getPropertyNameForSetter(jvmOperation.getSimpleName());
				final Provider<String> originalSignatureProvider = getSignature(jvmOperation, context);
				Provider<String> signatureProvider = new Provider<String>() {
					public String get() {
						String shadowingString = originalSignatureProvider.get();
						shadowingString = propertyName + "=" + shadowingString.substring(jvmOperation.getSimpleName().length());
						return shadowingString;
					}
				};
				JvmFeatureDescription description = createJvmFeatureDescription(QualifiedName.create(propertyName), 
						jvmOperation, context, signatureProvider, isVisible(feature), isValidStaticState(feature));
				acceptor.accept(description);
			}
		}
	}
	
	@Override
	protected void doCollectDescriptions(String name, IFeaturesForTypeProvider featureProvider, JvmTypeReference typeReference, ITypeArgumentContext context,
			Iterable<JvmTypeReference> hierarchy, IAcceptor<JvmFeatureDescription> acceptor) {
		String alias = "set" + Strings.toFirstUpper(name);
		super.doCollectDescriptions(alias, featureProvider, typeReference, context, hierarchy, acceptor);
	}

	protected String getPropertyNameForSetter(String simpleName) {
		if (simpleName.startsWith("set") && simpleName.length()>3 && Character.isUpperCase(simpleName.charAt(3))) {
			return Introspector.decapitalize(simpleName.substring(3));
		}
		return null;
	}

	protected boolean isSetterMethod(JvmOperation jvmOperation) {
		if (jvmOperation.getParameters().size() - getNumberOfIrrelevantArguments() != 1)
			return false;
		if (getPropertyNameForSetter(jvmOperation.getSimpleName())==null)
			return false;
		return true;
	}
	
}
