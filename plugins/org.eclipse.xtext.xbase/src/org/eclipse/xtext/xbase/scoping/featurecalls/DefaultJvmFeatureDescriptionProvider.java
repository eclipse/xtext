/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.JvmVisibilityService;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultJvmFeatureDescriptionProvider implements IJvmFeatureDescriptionProvider, IFeaturesForTypeProvider {
	
	@Inject
	protected JvmVisibilityService visibilityService;
	
	public void setVisibilityService(JvmVisibilityService visibilityService) {
		this.visibilityService = visibilityService;
	}
	
	@Inject
	protected IFeaturesForTypeProvider featuresForTypeProvider = new DefaultFeaturesForTypeProvider();
	
	public void setFeaturesForTypeProvider(IFeaturesForTypeProvider featuresForTypeProvider) {
		this.featuresForTypeProvider = featuresForTypeProvider;
	}
	
	public Iterable<? extends JvmFeature> getFeaturesForType(JvmDeclaredType declType) {
		return featuresForTypeProvider.getFeaturesForType(declType);
	}
	
	protected JvmDeclaredType contextType;
	protected JvmIdentifyableElement implicitReceiver;
	
	public void setContextType(JvmDeclaredType contextType) {
		this.contextType = contextType;
	}
	
	public void setImplicitReceiver(JvmIdentifyableElement implicitReceiver) {
		this.implicitReceiver = implicitReceiver;
	}
	
	protected JvmFeatureDescription createJvmFeatureDescription(QualifiedName name, JvmFeature jvmFeature,
			TypeArgumentContext ctx, String shadowingString, boolean isValid) {
		return new JvmFeatureDescription(name, jvmFeature, ctx, shadowingString, isValid, implicitReceiver, isMemberFeatureContext(jvmFeature));
	}

	protected boolean isMemberFeatureContext(JvmFeature jvmFeature) {
		return !(jvmFeature instanceof JvmOperation && ((JvmOperation)jvmFeature).isStatic());
	}

	protected JvmFeatureDescription createJvmFeatureDescription(JvmFeature jvmFeature, TypeArgumentContext ctx,
			String shadowingString, boolean isValid) {
		return createJvmFeatureDescription(QualifiedName.create(jvmFeature.getSimpleName()), jvmFeature, ctx,
				shadowingString, isValid);
	}

	public void addFeatureDescriptions(JvmFeature feature, TypeArgumentContext context, IAcceptor<JvmFeatureDescription> acceptor) {
		String signature = getSignature(feature, context);
		acceptor.accept(createJvmFeatureDescription(feature, context, signature, isValid(feature)));
	}

	protected String getSignature(JvmFeature feature, TypeArgumentContext context) {
		return new JvmFeatureSignatureProvider(context).apply(feature);
	}

	protected boolean isValid(JvmFeature feature) {
		final JvmMember jvmMember = feature;
		return visibilityService.isVisible(jvmMember,contextType);
	}

	public String getText() {
		return "";
	}
}
