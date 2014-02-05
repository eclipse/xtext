/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.contentassist;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider;
import org.eclipse.jdt.ui.JavaElementImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.xtext.ui.TypeAwareReferenceProposalCreator;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.RepeatedContentAssistProcessor;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.batch.SimpleIdentifiableElementDescription;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseReferenceProposalCreator extends TypeAwareReferenceProposalCreator implements RepeatedContentAssistProcessor.ModeAware {

	private int mode;
	
	public void reset() {
		mode = 0;
	}
	
	public void nextMode() {
		switch(mode) {
			case 0: 
			case 7: mode = 8; return;
			case 1: mode = 2; return;
			case 2: mode = 4; return;
			case 4: mode = 7; return;
			case 8: mode = 1; return;
			default: throw new IllegalStateException("mode:" + mode);
		}
	}
	
	public String getNextCategory() {
		switch(mode) {
			case 0:
			case 7: return "smart proposals";
			case 1: return "java-like proposals";
			case 2: return "type proposals";
			case 4: return "all proposals";
			case 8: return "shortest proposals";
			default: throw new IllegalStateException("mode:" + mode);
		}
	}
	
	public boolean isLastMode() {
		return isShowAllProposals();
	}
	
	public boolean isShowTypeProposals() {
		return (mode & 4) != 0;
	}
	
	protected boolean isShowShortestSugar() {
		return (mode & 1) != 0;
	}
	
	protected boolean isShowJavaLikeProposals() {
		return (mode & 2) != 0;
	}
	
	protected boolean isShowAllProposals() {
		return mode == 7;
	}
	
	public boolean isShowSmartProposals() {
		return mode == 8;
	}
	
	@Inject
	private IQualifiedNameConverter nameConverter;
	
	@Override
	public void lookupCrossReference(IScope scope, EObject model, EReference reference,
			ICompletionProposalAcceptor acceptor, Predicate<IEObjectDescription> filter,
			Function<IEObjectDescription, ICompletionProposal> proposalFactory) {
		if (TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(getEReferenceType(model, reference))) {
			if (!isShowTypeProposals() && !isShowSmartProposals())
				return;
		}
		if (reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE) {
			if (!isShowShortestSugar() && !isShowJavaLikeProposals() && !isShowSmartProposals())
				return;
		}
		super.lookupCrossReference(scope, model, reference, acceptor, filter, proposalFactory);
	}
	
	@Override
	protected Function<IEObjectDescription, ICompletionProposal> getWrappedFactory(EObject model, EReference reference,
			final Function<IEObjectDescription, ICompletionProposal> proposalFactory) {
		if (!TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(getEReferenceType(model, reference))) {
			return new Function<IEObjectDescription, ICompletionProposal>() {

				public ICompletionProposal apply(IEObjectDescription from) {
					ICompletionProposal result = proposalFactory.apply(from);
					if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_FEATURE, from.getEClass())) {
						if (result instanceof ConfigurableCompletionProposal) {
							EObject eObjectOrProxy = from.getEObjectOrProxy();
							if (eObjectOrProxy.eIsProxy()) {
								Image img = null;
								if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_CONSTRUCTOR, from.getEClass())) {
									img = computeConstructorImage(false, false, Flags.AccPublic, JavaElementImageDescriptor.CONSTRUCTOR);
								} else if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_OPERATION, from.getEClass())) {
									img = computeMethodImage(false, Flags.AccPublic, 0);
								} else if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_FIELD, from.getEClass())) {
									img = computeFieldImage(false, Flags.AccPublic, 0);
								}
								if (img != null) {
									((ConfigurableCompletionProposal) result).setImage(img);
								}
							} else {
								((ConfigurableCompletionProposal) result).setImage(computeImage((JvmFeature)eObjectOrProxy));
							}
						}
					} 
					else if (from instanceof SimpleIdentifiableElementDescription && isLocalVarOrFormalParameter(from)){
						if (result instanceof ConfigurableCompletionProposal) {
							((ConfigurableCompletionProposal) result).setImage(JavaPlugin.getImageDescriptorRegistry().get(JavaPluginImages.DESC_OBJS_LOCAL_VARIABLE));
						}
					}
					return result;
				}
			};
		}
		return super.getWrappedFactory(model, reference, proposalFactory);
	}
	
	protected boolean isLocalVarOrFormalParameter(IEObjectDescription desc) {
		QualifiedName name = desc.getQualifiedName();
		return !name.equals(IFeatureNames.THIS) && !name.equals(IFeatureNames.SUPER);
	}
	
	@Override
	public Iterable<IEObjectDescription> queryScope(IScope scope, EObject model, EReference reference,
			Predicate<IEObjectDescription> filter) {
		if (reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE) {
			Map<EObject, IEObjectDescription> filteredDescriptions = Maps.newLinkedHashMap();
			List<IEObjectDescription> others = Lists.newArrayList();
			Iterable<IEObjectDescription> allDescriptions =	super.queryScope(scope, model, reference, filter);
			for(IEObjectDescription description: allDescriptions) {
				if (filter.apply(description)) {
					if (description instanceof IIdentifiableElementDescription) {
						IIdentifiableElementDescription featureDescription = (IIdentifiableElementDescription) description;
						if (filteredDescriptions.containsKey(featureDescription.getEObjectOrProxy())) {
							if (isShowShortestSugar() || isShowSmartProposals()) {
								IEObjectDescription previousDescription = filteredDescriptions.get(featureDescription.getEObjectOrProxy());
								IIdentifiableElementDescription previousFeatureDescription = null;
								MultiNameDescription multiNameDescription = null;
								if (previousDescription instanceof IIdentifiableElementDescription) {
									previousFeatureDescription = (IIdentifiableElementDescription) previousDescription;
								} else if (previousDescription instanceof MultiNameDescription) {
									multiNameDescription = (MultiNameDescription) previousDescription;
									previousFeatureDescription = (IIdentifiableElementDescription) multiNameDescription.getDelegate();
								}
								if (previousFeatureDescription == null)
									continue;
								String previousName = nameConverter.toString(previousFeatureDescription.getName());
								String candidateName = nameConverter.toString(featureDescription.getName());
								if (previousName.length() > candidateName.length()) {
									if (!isShowSmartProposals()) {
										filteredDescriptions.put(featureDescription.getEObjectOrProxy(), featureDescription);
										if (isShowAllProposals() && previousFeatureDescription.getShadowingKey().indexOf(')') >= 0)
											others.add(previousFeatureDescription);
									} else {
										if (multiNameDescription == null) {
											multiNameDescription = new MultiNameDescription(featureDescription);
											multiNameDescription.addOtherName(previousFeatureDescription.getName());
											filteredDescriptions.put(featureDescription.getEObjectOrProxy(), multiNameDescription);
										} else {
											multiNameDescription.addOtherName(previousFeatureDescription.getName());
											multiNameDescription.setDelegate(featureDescription);
										}
									}
								} else if (previousName.length() == candidateName.length()) {
									if (previousFeatureDescription.getNumberOfParameters() >= 1) {
										if (!isShowAllProposals()) {
											if (!previousFeatureDescription.getEObjectOrProxy().eIsProxy() && previousFeatureDescription.getEObjectOrProxy() instanceof JvmExecutable) {
												JvmExecutable exectuable = (JvmExecutable) previousFeatureDescription.getEObjectOrProxy();
												if (!exectuable.isVarArgs()) {
													filteredDescriptions.put(featureDescription.getEObjectOrProxy(), featureDescription);
												}
											} else {
												filteredDescriptions.put(featureDescription.getEObjectOrProxy(), featureDescription);
											}
										}
									}
								} else {
									if (isShowSmartProposals()) {
										if (multiNameDescription == null) {
											multiNameDescription = new MultiNameDescription(previousFeatureDescription);
											multiNameDescription.addOtherName(featureDescription.getName());
											filteredDescriptions.put(featureDescription.getEObjectOrProxy(), multiNameDescription);
										} else {
											multiNameDescription.addOtherName(featureDescription.getName());
										}
									}
								}
							}
						} else {
							filteredDescriptions.put(featureDescription.getEObjectOrProxy(), featureDescription);
						}
					} else {
						others.add(new SimpleIdentifiableElementDescription(description));
					}
				}
			}
			if (!others.isEmpty())
				return Iterables.concat(others, filteredDescriptions.values()); 
			return Collections.<IEObjectDescription>unmodifiableCollection(filteredDescriptions.values());
		}
		return super.queryScope(scope, model, reference, filter);
	}
	
	protected Image computeImage(JvmFeature feature) {
		int flags = 0;
		int decorator = 0;
		switch(feature.getVisibility()) {
			case PUBLIC: flags = Flags.AccPublic; break;
			case PROTECTED: flags = Flags.AccProtected; break;
			case PRIVATE: flags = Flags.AccPrivate; break;
			case DEFAULT: flags = Flags.AccDefault; break;
		}
		JvmDeclaredType declaringType = feature.getDeclaringType();
		boolean interfaceOrAnnotation = false;
		if (declaringType instanceof JvmGenericType) {
			interfaceOrAnnotation = ((JvmGenericType) declaringType).isInterface();
		} else if (declaringType instanceof JvmAnnotationType) {
			interfaceOrAnnotation = true;
		}
		if (feature instanceof JvmConstructor) {
			decorator = JavaElementImageDescriptor.CONSTRUCTOR;
			if (declaringType.isAbstract()) {
				flags |= Flags.AccAbstract;
				decorator |= JavaElementImageDescriptor.ABSTRACT;
			}
			return computeConstructorImage(declaringType.getDeclaringType() != null, interfaceOrAnnotation, flags, decorator);
		} else if (feature instanceof JvmOperation) {
			JvmOperation operation = (JvmOperation) feature;
			if (operation.isStatic()) {
				flags |= Flags.AccStatic;
				decorator |= JavaElementImageDescriptor.STATIC;
			}
			if (operation.isAbstract()) {
				flags |= Flags.AccAbstract;
				decorator |= JavaElementImageDescriptor.ABSTRACT;
			}
			if (operation.isFinal()) {
				flags |= Flags.AccFinal;
				decorator |= JavaElementImageDescriptor.FINAL;
			}
			return computeMethodImage(interfaceOrAnnotation, flags, decorator);
		} else if (feature instanceof JvmField) {
			JvmField field = (JvmField) feature;
			if (field.isStatic()) {
				flags |= Flags.AccStatic;
				decorator |= JavaElementImageDescriptor.STATIC;
			}
			if (field.isFinal()) {
				flags |= Flags.AccFinal;
				decorator |= JavaElementImageDescriptor.FINAL;
			}
			if (declaringType instanceof JvmEnumerationType)
				flags |= Flags.AccEnum;
			return computeFieldImage(interfaceOrAnnotation, flags, decorator);
		} 
		return null;
	}

	protected Image computeMethodImage(boolean interfaceOrAnnotation, int modifiers, int decorator) {
		ImageDescriptor baseImage = JavaElementImageProvider.getMethodImageDescriptor(interfaceOrAnnotation, modifiers);
		return JavaElementImageProvider.getDecoratedImage(baseImage, decorator, JavaElementImageProvider.BIG_SIZE);
	}
	
	protected Image computeConstructorImage(boolean inner, boolean interfaceOrAnnotation, int modifiers, int decorator) {
		ImageDescriptor baseImage = JavaElementImageProvider.getTypeImageDescriptor(inner,
				interfaceOrAnnotation, modifiers, false);
		return JavaElementImageProvider.getDecoratedImage(baseImage, decorator, JavaElementImageProvider.BIG_SIZE);
	}
	
	protected Image computeFieldImage(boolean interfaceOrAnnotation, int modifiers, int decorator) {
		ImageDescriptor baseImage =  JavaElementImageProvider.getFieldImageDescriptor(interfaceOrAnnotation, modifiers);
		return JavaElementImageProvider.getDecoratedImage(baseImage, decorator, JavaElementImageProvider.BIG_SIZE);
	}
}
