/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import static org.eclipse.xtext.util.Strings.*;

import java.util.Map;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.VisibilityService;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XExpression;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@Deprecated
public class DefaultJvmFeatureDescriptionProvider implements IJvmFeatureDescriptionProvider, IFeaturesForTypeProvider {
	
	protected static class ShadowingAwareAcceptor implements IAcceptor<JvmFeatureDescription> {
		private final Map<String, IEObjectDescription> descriptions;
		private final Function<? super JvmFeatureDescription, ? extends ITypeArgumentContext> genericContextFactory;

		protected ShadowingAwareAcceptor(Map<String, IEObjectDescription> descriptions, 
				Function<? super JvmFeatureDescription, ? extends ITypeArgumentContext> genericContextFactory) {
			this.descriptions = descriptions;
			this.genericContextFactory = genericContextFactory;
		}

		public void accept(JvmFeatureDescription t) {
			String key = t.getKey();
			IEObjectDescription old = descriptions.put(key, t);
			// optimistic - conflicts are expected to be rare
			if (useOldDescription(key, old, t)) {
				descriptions.put(key, old);
			} else {
				t.setGenericTypeContext(genericContextFactory.apply(t));
			}
		}

		protected boolean useOldDescription(String key, IEObjectDescription oldDescription, IEObjectDescription newDescription) {
			if (oldDescription == null)
				return false;
			if (!(oldDescription instanceof JvmFeatureDescription))
				return true;
			String oldFeatureName = ((JvmFeatureDescription)oldDescription).getJvmFeature().getSimpleName();
			if (equal(key, oldFeatureName)) {
				return true;
			}
			String newFeatureName = ((JvmFeatureDescription)newDescription).getJvmFeature().getSimpleName();
			if (equal(key, newFeatureName)) {
				return false;
			}
			if (oldFeatureName.startsWith("get") && (newFeatureName.startsWith("is")))
				return true;
			if (oldFeatureName.startsWith("is") && (newFeatureName.startsWith("old")))
				return false;
			return true;
		}
	}

	@Inject
	protected VisibilityService visibilityService;
	
	public void setVisibilityService(VisibilityService visibilityService) {
		this.visibilityService = visibilityService;
	}
	
	@Inject
	protected IFeaturesForTypeProvider featuresForTypeProvider = new DefaultFeaturesForTypeProvider();
	
	@Inject
	protected JvmFeatureSignatureProvider signatureProvider = new JvmFeatureSignatureProvider();
	
	public Iterable<IEObjectDescription> getDescriptionsByName(
			String name, 
			IFeaturesForTypeProvider featureProvider, 
			JvmTypeReference typeReference,
			Function<? super JvmFeatureDescription, ? extends ITypeArgumentContext> genericContextFactory,
			ITypeArgumentContext rawTypeContext, 
			Iterable<JvmTypeReference> hierarchy) {
		final Map<String, IEObjectDescription> descriptions = Maps.newLinkedHashMap();
		IAcceptor<JvmFeatureDescription> acceptor = new ShadowingAwareAcceptor(descriptions, genericContextFactory);
		doCollectDescriptions(name, featureProvider, typeReference, rawTypeContext, hierarchy, acceptor);
		return descriptions.values();
	}
	
	public Iterable<IEObjectDescription> getAllDescriptions(
			IFeaturesForTypeProvider featureProvider,
			JvmTypeReference typeReference, 
			Function<? super JvmFeatureDescription, ? extends ITypeArgumentContext> genericContextFactory,
			ITypeArgumentContext context, 
			Iterable<JvmTypeReference> hierarchy) {
		final Map<String, IEObjectDescription> descriptions = Maps.newLinkedHashMap();
		IAcceptor<JvmFeatureDescription> acceptor = new ShadowingAwareAcceptor(descriptions, genericContextFactory);
		doCollectDescriptions(featureProvider, typeReference, context, hierarchy, acceptor);
		return descriptions.values();
	}

	protected void doCollectDescriptions(String name, IFeaturesForTypeProvider featureProvider, 
			JvmTypeReference typeReference, ITypeArgumentContext rawTypeContext,
			Iterable<JvmTypeReference> hierarchy, IAcceptor<JvmFeatureDescription> acceptor) {
		Iterable<JvmFeature> features = featureProvider.getFeaturesByName(name, typeReference, hierarchy);
		for (JvmFeature jvmFeature : features) {
			addFeatureDescriptions(jvmFeature, rawTypeContext, acceptor);
		}
	}
	
	protected void doCollectDescriptions(IFeaturesForTypeProvider featureProvider, JvmTypeReference typeReference, ITypeArgumentContext context,
			Iterable<JvmTypeReference> hierarchy, IAcceptor<JvmFeatureDescription> acceptor) {
		Iterable<JvmFeature> features = featureProvider.getAllFeatures(typeReference, hierarchy);
		for (JvmFeature jvmFeature : features) {
			addFeatureDescriptions(jvmFeature, context, acceptor);
		}
	}
	
	public Iterable<JvmFeature> getFeaturesByName(
			String name, JvmTypeReference declarator,
			Iterable<JvmTypeReference> hierarchy) {
		return featuresForTypeProvider.getFeaturesByName(name, declarator, hierarchy);
	}
	
	public Iterable<JvmFeature> getAllFeatures(JvmTypeReference typeReference, 
			Iterable<JvmTypeReference> hierarchy) {
		return featuresForTypeProvider.getAllFeatures(typeReference, hierarchy);
	}
	
	public void setFeaturesForTypeProvider(IFeaturesForTypeProvider featuresForTypeProvider) {
		this.featuresForTypeProvider = featuresForTypeProvider;
	}
	
	protected JvmDeclaredType contextType;
	protected XExpression implicitReceiver;
	protected XExpression implicitArgument;
	protected int priority;
	protected boolean preferStatics;

	public void setPreferStatics(boolean preferStatics) {
		this.preferStatics = preferStatics;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setContextType(JvmDeclaredType contextType) {
		this.contextType = contextType;
	}
	
	public void setImplicitReceiver(XExpression implicitReceiver) {
		this.implicitReceiver = implicitReceiver;
	}
	
	public XExpression getImplicitReceiver() {
		return implicitReceiver;
	}
	
	public void setImplicitArgument(XExpression implicitArgument) {
		this.implicitArgument = implicitArgument;
	}
	
	public XExpression getImplicitArgument() {
		return implicitArgument;
	}
	
	protected JvmFeatureDescription createJvmFeatureDescription(QualifiedName name, JvmFeature jvmFeature,
			ITypeArgumentContext rawTypeContext, String shadowingString, boolean isValid, boolean isValidStaticState) {
		return new JvmFeatureDescription(name, jvmFeature, rawTypeContext, shadowingString, isValid, isValidStaticState, implicitReceiver, implicitArgument, getNumberOfIrrelevantArguments());
	}
	
	protected JvmFeatureDescription createJvmFeatureDescription(QualifiedName name, JvmFeature jvmFeature,
			ITypeArgumentContext rawTypeContext, Provider<String> shadowingStringProvider, boolean isVisible, boolean isValidStaticState) {
		return new JvmFeatureDescription(name, jvmFeature, rawTypeContext, shadowingStringProvider, isVisible, isValidStaticState, implicitReceiver, implicitArgument, getNumberOfIrrelevantArguments());
	}
	
	protected int getNumberOfIrrelevantArguments() {
		if (isExtensionProvider() || implicitArgument != null)
			return 1;
		return 0;
	}

	public boolean isExtensionProvider() {
		return featuresForTypeProvider!=null ? featuresForTypeProvider.isExtensionProvider() : false;
	}

	protected JvmFeatureDescription createJvmFeatureDescription(
			JvmFeature jvmFeature, ITypeArgumentContext rawTypeContext,
			Provider<String> shadowingStringProvider, boolean isValid, boolean isValidStaticState) {
		return createJvmFeatureDescription(
				QualifiedName.create(jvmFeature.getSimpleName()), 
				jvmFeature, rawTypeContext, shadowingStringProvider, isValid, isValidStaticState);
	}

	public void addFeatureDescriptions(JvmFeature feature, 
			ITypeArgumentContext rawTypeContext, 
			IAcceptor<JvmFeatureDescription> acceptor) {
		Provider<String> signatureProvider = getSignature(feature, rawTypeContext);
		acceptor.accept(createJvmFeatureDescription(feature, rawTypeContext, signatureProvider, isVisible(feature), isValidStaticState(feature)));
	}

	protected Provider<String> getSignature(final JvmFeature feature, final ITypeArgumentContext context) {
		return new Provider<String>() {
			public String get() {
				return signatureProvider.getSignature(feature, context, getNumberOfIrrelevantArguments());
			}
		};
	}

	protected boolean isVisible(JvmFeature feature) {
		return visibilityService.isVisible(feature, contextType);
	}
	
	protected boolean isValidStaticState(JvmFeature feature) {
		if (feature instanceof JvmOperation) {
			if (preferStatics != ((JvmOperation) feature).isStatic())
				return false;
		} else if (feature instanceof JvmField) {
			if (preferStatics != ((JvmField) feature).isStatic())
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [featuresForTypeProvider=" + featuresForTypeProvider
				+ ", contextType=" + getContextIdentifier() + ", implicitReceiver=" + implicitReceiver + ", implicitArgument="
				+ implicitArgument + ", priority=" + priority + "]";
	}

	private String getContextIdentifier() {
		return contextType == null ? null : contextType.getIdentifier();
	}

}
