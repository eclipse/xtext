/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
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
@SuppressWarnings("restriction")
public class XbaseReferenceProposalCreator extends TypeAwareReferenceProposalCreator implements RepeatedContentAssistProcessor.ModeAware {

	private int mode;
	
	@Override
	public void reset() {
		mode = 0;
	}
	
	@Override
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
	
	@Override
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
	
	@Override
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

				@Override
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
	
	protected static class MultiNameDescriptions {
		private Kind kind;

		enum Kind {
			Shortest {
				@Override
				protected void apply(IIdentifiableElementDescription featureDescription, MultiNameDescriptions result) {
					EObject feature = featureDescription.getEObjectOrProxy();
					IIdentifiableElementDescription previous = (IIdentifiableElementDescription) result.descriptionsByEObject.get(feature);
					if (previous != null) {
						String previousName = result.nameConverter.toString(previous.getName());
						String candidateName = result.nameConverter.toString(featureDescription.getName());
						if (previousName.length() > candidateName.length() || (previousName.length() == candidateName.length() && previous.getNumberOfParameters() >= 1)) {
							result.descriptionsByEObject.put(feature, featureDescription);	
						}
					} else {
						result.descriptionsByEObject.put(feature, featureDescription);
					}
				}
			},
			Smart {
				@Override
				protected void apply(IIdentifiableElementDescription featureDescription, MultiNameDescriptions result) {
					EObject feature = featureDescription.getEObjectOrProxy();
					IEObjectDescription previous = result.descriptionsByEObject.get(feature);
					if (previous != null) {
						IIdentifiableElementDescription previousFeatureDescription = null;
						MultiNameDescription multiNameDescription = null;
						if (previous instanceof IIdentifiableElementDescription) {
							previousFeatureDescription = (IIdentifiableElementDescription) previous;
							multiNameDescription = new MultiNameDescription(previousFeatureDescription);
							result.descriptionsByEObject.put(feature, multiNameDescription);
						} else if (previous instanceof MultiNameDescription) {
							multiNameDescription = (MultiNameDescription) previous;
							previousFeatureDescription = (IIdentifiableElementDescription) multiNameDescription.getDelegate();
						} else {
							throw new IllegalStateException(String.valueOf(previousFeatureDescription));
						}
						if (result.isLongerThan(previousFeatureDescription, featureDescription)) {
							multiNameDescription.addOtherName(previousFeatureDescription.getName());
							multiNameDescription.setDelegate(featureDescription);
						} else {
							multiNameDescription.addOtherName(featureDescription.getName());
						}
					} else {
						result.descriptionsByEObject.put(featureDescription.getEObjectOrProxy(), featureDescription);
					}
				}
			},
			Java {
				@Override
				protected void apply(IIdentifiableElementDescription featureDescription, MultiNameDescriptions result) {
					JvmIdentifiableElement element = featureDescription.getElementOrProxy();
					String firstSegment = featureDescription.getName().getFirstSegment();
					if (element.getSimpleName().equals(firstSegment)) {
						result.others.add(featureDescription);
					}
				}
			},
			All {
				@Override
				protected void apply(IIdentifiableElementDescription featureDescription, MultiNameDescriptions result) {
					result.others.add(featureDescription);
				}
			};
			
			protected abstract void apply(IIdentifiableElementDescription featureDescription, MultiNameDescriptions result);
		}
		
		List<IEObjectDescription> others;
		Map<EObject, IEObjectDescription> descriptionsByEObject;
		IQualifiedNameConverter nameConverter;
		
		MultiNameDescriptions(Kind kind, IQualifiedNameConverter nameConverter) {
			this.kind = kind;
			this.nameConverter = nameConverter;
			this.others = Lists.newArrayList();
			this.descriptionsByEObject = Maps.newLinkedHashMap();
		}
		
		protected boolean isLongerThan(IIdentifiableElementDescription previous, IIdentifiableElementDescription next) {
			String previousName = nameConverter.toString(previous.getName());
			String candidateName = nameConverter.toString(next.getName());
			if (previousName.length() > candidateName.length()) {
				return true;
			}
			if (previousName.length() == candidateName.length()) {
				if (previous.getNumberOfParameters() >= 1) {
					return true;
				}
			}
			return false;
		}
		
		protected void apply(IEObjectDescription description) {
			if (description instanceof IIdentifiableElementDescription) {
				IIdentifiableElementDescription featureDescription = (IIdentifiableElementDescription) description;
				kind.apply(featureDescription, this);
			} else {
				others.add(new SimpleIdentifiableElementDescription(description));
			}
		}
		
		protected Iterable<IEObjectDescription> getResult() {
			if (!others.isEmpty())
				return Iterables.concat(others, descriptionsByEObject.values()); 
			return Collections.<IEObjectDescription>unmodifiableCollection(descriptionsByEObject.values());
		}
	}
	
	@Override
	public Iterable<IEObjectDescription> queryScope(IScope scope, EObject model, EReference reference,
			Predicate<IEObjectDescription> filter) {
		if (reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE) {
			MultiNameDescriptions.Kind kind;
			if (isShowAllProposals()) {
				kind = MultiNameDescriptions.Kind.All;	
			} else if (isShowShortestSugar()) {
				kind = MultiNameDescriptions.Kind.Shortest;
			} else if (isShowSmartProposals()) {
				kind = MultiNameDescriptions.Kind.Smart;
			} else if (isShowJavaLikeProposals()) {
				kind = MultiNameDescriptions.Kind.Java;
			} else {
				kind = MultiNameDescriptions.Kind.All;
			}
			MultiNameDescriptions proposals = new MultiNameDescriptions(kind, nameConverter);
			Iterable<IEObjectDescription> allDescriptions =	super.queryScope(scope, model, reference, filter);
			for(IEObjectDescription description: allDescriptions) {
				if (filter.apply(description)) {
					proposals.apply(description);
				}
			}
			return proposals.getResult();
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
