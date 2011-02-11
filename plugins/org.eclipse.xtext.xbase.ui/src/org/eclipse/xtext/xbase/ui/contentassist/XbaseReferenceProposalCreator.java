/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.core.Flags;
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
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.xtext.ui.TypeAwareReferenceProposalCreator;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;

import com.google.common.base.Function;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XbaseReferenceProposalCreator extends TypeAwareReferenceProposalCreator {

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
					return result;
				}
			};
		}
		return super.getWrappedFactory(model, reference, proposalFactory);
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
