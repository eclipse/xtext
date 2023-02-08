/*******************************************************************************
 * Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.ui.contentassist;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
/**
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
public class XbaseWithAnnotationsProposalProvider extends AbstractXbaseWithAnnotationsProposalProvider {

	@Override
	public void completeXAnnotation_AnnotationType(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, 
				createVisibilityFilter(context, IJavaSearchConstants.ANNOTATION_TYPE), acceptor);
	}
	
	@Override
	public void completeXAnnotationElementValuePair_Element(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		XAnnotation annotationReference = null;
		if (model instanceof XAnnotationElementValuePair) {
			annotationReference = (XAnnotation) model.eContainer();
		} else if (model instanceof XAnnotation) {
			annotationReference = (XAnnotation) model;
		}
		if (annotationReference != null) {
			JvmType annotationType = annotationReference.getAnnotationType();
			if (annotationType != null && !annotationType.eIsProxy() && annotationType instanceof JvmAnnotationType) {
				// do not propose features like #toString, #hashCode etc
				JvmAnnotationType casted = (JvmAnnotationType) annotationType;
				final Set<JvmOperation> operations = Sets.newHashSet(casted.getDeclaredOperations());
				Predicate<IEObjectDescription> predicate = Predicates.and(new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription in) {
						return operations.contains(in.getEObjectOrProxy());
					}
				}, getFeatureDescriptionPredicate(context));
				lookupCrossReference(((CrossReference)assignment.getTerminal()), context, acceptor, predicate);
			}
		}
	}
	
	@Override
	public void completeXAnnotationElementValuePair_Value(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.completeXAnnotationElementValuePair_Value(model, assignment, context, acceptor);
		proposeDeclaringTypeForStaticInvocation(model, null, context, acceptor);
	}
	
	@Override
	public void completeXAnnotation_Value(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof XAnnotation) {
			JvmType annotationType = ((XAnnotation) model).getAnnotationType();
			if (annotationType != null && !annotationType.eIsProxy() && annotationType instanceof JvmAnnotationType) {
				JvmAnnotationType casted = (JvmAnnotationType) annotationType;
				List<JvmOperation> operations = Lists.newArrayList(casted.getDeclaredOperations());
				if (operations.size() == 1) {
					JvmOperation singleOperation = operations.get(0);
					if ("value".equals(singleOperation.getSimpleName())) {
						// TODO propose qualified enum literals + import
						super.completeXAnnotation_Value(model, assignment, context, acceptor);
						if ("java.lang.Class".equals(getRawReturnType(singleOperation))) {
							// eager proposals for classes if the expected type is a suptype of class
							// TODO evaluate the bounds of the class
							completeJavaTypes(
									context, 
									TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE,
									true, // force
									getQualifiedNameValueConverter(),
									createVisibilityFilter(context), acceptor);
						} else {
							proposeDeclaringTypeForStaticInvocation(model, assignment, context, acceptor);
						}
					}
				}
			}
		}
	}
	
	@Override
	public void completeXFeatureCall_Feature(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof XAnnotation) {
			createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor);
			return;
		} else if (model instanceof XAnnotationElementValuePair) {
			XAnnotationElementValuePair pair = (XAnnotationElementValuePair) model;
			XAnnotation annotation = (XAnnotation) pair.eContainer();
			createLocalVariableAndImplicitProposals(annotation, IExpressionScope.Anchor.WITHIN, context, acceptor);
			return;
		}
		super.completeXFeatureCall_Feature(model, assignment, context, acceptor);
	}

	private String getRawReturnType(JvmOperation singleOperation) {
		JvmTypeReference returnType = singleOperation.getReturnType();
		if (returnType == null)
			return null;
		JvmType rawType = returnType.getType();
		if (rawType == null) {
			return null;
		}
		return rawType.getQualifiedName();
	}

}
