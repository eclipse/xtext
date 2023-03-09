/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.compiler.output.ErrorTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein
 */
public class ErrorSafeExtensions {
	@Inject
	private TypeReferenceSerializer typeReferenceSerializer;

	@Inject
	private IElementIssueProvider.Factory issueProviderFactory;

	public Iterable<Issue> getErrors(EObject element) {
		IElementIssueProvider issueProvider = issueProviderFactory.get(element.eResource());
		return Iterables.filter(issueProvider.getIssues(element), it -> Severity.ERROR.equals(it.getSeverity()));
	}

	public boolean hasErrors(EObject element) {
		return !IterableExtensions.isEmpty(getErrors(element));
	}

	public <T extends EObject> void forEachSafely(ITreeAppendable appendable, Iterable<T> elements,
			Procedure1<? super LoopParams> loopInitializer, Procedure2<? super T, ? super ITreeAppendable> body) {
		if (Iterables.isEmpty(elements)) {
			return;
		}
		LoopParams loopParams = ObjectExtensions.operator_doubleArrow(new LoopParams(), loopInitializer);
		boolean allElementsBroken = Iterables
				.size(Iterables.<T>filter(elements, (T it) -> hasErrors(it))) == Iterables.size(elements);
		ITreeAppendable currentAppendable = null;
		if (allElementsBroken) {
			currentAppendable = openErrorAppendable(appendable, null);
		} else {
			currentAppendable = appendable;
		}
		loopParams.appendPrefix(currentAppendable);
		boolean isFirst = true;
		boolean isFirstBroken = true;
		for (T element : elements) {
			if (!hasErrors(element)) {
				currentAppendable = closeErrorAppendable(appendable, currentAppendable);
				if (!isFirst) {
					loopParams.appendSeparator(appendable);
				}
				isFirst = false;
				body.apply(element, appendable);
			} else {
				if (!allElementsBroken) {
					currentAppendable = openErrorAppendable(appendable, currentAppendable);
				}
				if (!isFirst || !isFirstBroken) {
					loopParams.appendSeparator(currentAppendable);
				}
				isFirstBroken = false;
				try {
					body.apply(element, currentAppendable);
				} catch (Exception ignoreMe) {
				}
			}
		}
		if (!allElementsBroken) {
			currentAppendable = closeErrorAppendable(appendable, currentAppendable);
		}
		loopParams.appendSuffix(currentAppendable);
		closeErrorAppendable(appendable, currentAppendable);
	}

	protected ITreeAppendable openErrorAppendable(ITreeAppendable parent, ITreeAppendable child) {
		if (child instanceof ErrorTreeAppendable) {
			return child;
		} else {
			return parent.errorChild().append("/* ");
		}
	}

	protected ITreeAppendable closeErrorAppendable(ITreeAppendable parent, ITreeAppendable child) {
		if (child instanceof ErrorTreeAppendable && !Objects.equal(child, parent)) {
			child.append(" */");
		}
		return parent;
	}

	public void serializeSafely(JvmTypeReference typeRef, ITreeAppendable appendable) {
		serializeSafely(typeRef, null, appendable);
	}

	public void serializeSafely(JvmTypeReference typeRef, String surrogateType, ITreeAppendable appendable) {
		if (typeRef == null || typeRef.getType() == null) {
			if (typeRef instanceof JvmSpecializedTypeReference) {
				serializeSafely(((JvmSpecializedTypeReference) typeRef).getEquivalent(), surrogateType, appendable);
			} else if (typeRef instanceof JvmUnknownTypeReference) {
				appendable.append(((JvmUnknownTypeReference) typeRef).getQualifiedName());
			} else {
				appendable.append("Object");
				ITreeAppendable errorChild = openErrorAppendable(appendable, appendable);
				errorChild.append("type is 'null'");
				closeErrorAppendable(appendable, errorChild);
			}
		} else {
			if (typeRef.accept(new BrokenTypeRefDetector())) {
				ITreeAppendable errorChild = openErrorAppendable(appendable, appendable);
				try {
					typeReferenceSerializer.serialize(typeRef, typeRef.eContainer(), errorChild);
				} catch (Exception ignoreMe) {
				}
				closeErrorAppendable(appendable, errorChild);
				if (surrogateType != null) {
					appendable.append(surrogateType);
				}
			} else {
				typeReferenceSerializer.serialize(typeRef, typeRef.eContainer(), appendable);
			}
		}
	}

	public void serializeSafely(JvmAnnotationReference annotationRef, ITreeAppendable appendable,
			Procedure1<? super ITreeAppendable> onSuccess) {
		if (annotationRef == null || annotationRef.getAnnotation() == null) {
			ITreeAppendable errorChild = openErrorAppendable(appendable, appendable);
			errorChild.append("annotation is 'null'");
			closeErrorAppendable(appendable, errorChild);
		} else {
			if (annotationRef.getAnnotation().eIsProxy()) {
				ITreeAppendable errorChild = openErrorAppendable(appendable, appendable);
				appendable.append("@");
				appendable.append(annotationRef.getAnnotation());
				closeErrorAppendable(appendable, errorChild);
			} else {
				appendable.append("@");
				appendable.append(annotationRef.getAnnotation());
				onSuccess.apply(appendable);
			}
		}
	}
}
