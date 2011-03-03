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
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.VisibilityService;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultJvmFeatureDescriptionProvider implements IJvmFeatureDescriptionProvider, IFeaturesForTypeProvider {
	
	@Inject
	protected VisibilityService visibilityService;
	
	public void setVisibilityService(VisibilityService visibilityService) {
		this.visibilityService = visibilityService;
	}
	
	@Inject
	protected IFeaturesForTypeProvider featuresForTypeProvider = new DefaultFeaturesForTypeProvider();
	
	@Inject
	protected JvmFeatureSignatureProvider signatureProvider = new JvmFeatureSignatureProvider();
	
	public void setFeaturesForTypeProvider(IFeaturesForTypeProvider featuresForTypeProvider) {
		this.featuresForTypeProvider = featuresForTypeProvider;
	}
	
	public Iterable<? extends JvmFeature> getFeaturesForType(JvmTypeReference declType) {
		return featuresForTypeProvider.getFeaturesForType(declType);
	}
	
	protected JvmDeclaredType contextType;
	protected JvmIdentifiableElement implicitReceiver;
	
	public void setContextType(JvmDeclaredType contextType) {
		this.contextType = contextType;
	}
	
	public void setImplicitReceiver(JvmIdentifiableElement implicitReceiver) {
		this.implicitReceiver = implicitReceiver;
	}
	
	protected JvmFeatureDescription createJvmFeatureDescription(QualifiedName name, JvmFeature jvmFeature,
			TypeArgumentContext ctx, String shadowingString, boolean isValid) {
		return new JvmFeatureDescription(name, jvmFeature, ctx, shadowingString, isValid, implicitReceiver, getNumberOfIrrelevantArguments());
	}
	
	private int getNumberOfIrrelevantArguments() {
		if (isExtensionProvider())
			return 1;
		return 0;
	}

	public boolean isExtensionProvider() {
		return featuresForTypeProvider!=null?featuresForTypeProvider.isExtensionProvider():false;
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
		return signatureProvider.getSignature(feature, context, getNumberOfIrrelevantArguments());
	}

	protected boolean isValid(JvmFeature feature) {
		final JvmMember jvmMember = feature;
		return visibilityService.isVisible(jvmMember,contextType);
	}

	public String getText() {
		return getClass().getSimpleName();
	}
}
