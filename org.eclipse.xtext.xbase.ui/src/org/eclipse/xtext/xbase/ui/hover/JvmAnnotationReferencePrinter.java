/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.hover;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.ui.editor.hover.html.XtextElementLinks;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;

/**
 * Provides a HTML representation for {@code JvmAnnotationReference}s to be used in the hover.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmAnnotationReferencePrinter {

	private static final Logger LOG = Logger.getLogger(JvmAnnotationReferencePrinter.class);

	/**
	 * @return the HTML representation for the passed {@code reference}
	 * @throws NullPointerException
	 *             if the {@code reference} is {@code null}
	 */
	public String toHtmlString(JvmAnnotationReference reference) {
		Preconditions.checkNotNull(reference);

		try {
			return internalToString(reference);
		} catch (RuntimeException e) {
			LOG.error(e.getMessage(), e);
			return reference.getAnnotation() != null ? reference.getAnnotation().getSimpleName() : null;
		}
	}

	protected String internalToString(Object obj) {
		if (obj instanceof XBinaryOperation) {
			return _internalToString((XBinaryOperation) obj);
		} else if (obj instanceof XFeatureCall) {
			return _internalToString((XFeatureCall) obj);
		} else if (obj instanceof XListLiteral) {
			return _internalToString((XListLiteral) obj);
		} else if (obj instanceof XMemberFeatureCall) {
			return _internalToString((XMemberFeatureCall) obj);
		} else if (obj instanceof XBooleanLiteral) {
			return _internalToString((XBooleanLiteral) obj);
		} else if (obj instanceof XNumberLiteral) {
			return _internalToString((XNumberLiteral) obj);
		} else if (obj instanceof XStringLiteral) {
			return _internalToString((XStringLiteral) obj);
		} else if (obj instanceof XTypeLiteral) {
			return _internalToString((XTypeLiteral) obj);
		} else if (obj instanceof XAnnotation) {
			return _internalToString((XAnnotation) obj);
		} else if (obj instanceof JvmAnnotationReference) {
			return _internalToString((JvmAnnotationReference) obj);
		} else if (obj instanceof JvmAnnotationValue) {
			return _internalToString((JvmAnnotationValue) obj);
		} else {
			return _internalToString(obj);
		}
	}

	protected String _internalToString(JvmAnnotationReference reference) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("@");
		buffer.append(createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, EcoreUtil.getURI(reference.getAnnotation()), reference.getAnnotation().getSimpleName()));

		List<JvmAnnotationValue> explicitValues = reference.getExplicitValues();
		boolean needsExplicitProperties = explicitValues.size() > 1 //
				|| (!explicitValues.isEmpty() && explicitValues.get(0).getOperation() != null //
						&& !"value".equals(explicitValues.get(0).getOperation().getSimpleName()));

		if (!explicitValues.isEmpty()) {
			buffer.append("(");
			buffer.append(explicitValues.stream().map(explicitValue -> {
				StringBuilder builder = new StringBuilder();
				if (needsExplicitProperties) {
					Iterable<JvmOperation> declaredOperations = reference.getAnnotation().getDeclaredOperations();
					builder.append(createLinkToOperation(explicitValue.getOperation(), declaredOperations));
					builder.append("=");
				}
				builder.append(internalToString(explicitValue));
				return builder.toString();
			}).collect(Collectors.joining(", ")));
			buffer.append(")");
		}
		return buffer.toString();
	}

	protected String _internalToString(XAnnotation reference) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("@");
		buffer.append(createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, EcoreUtil.getURI(reference.getAnnotationType()), reference.getAnnotationType().getSimpleName()));
		if (reference.getValue() != null) {
			buffer.append("(");
			buffer.append(reference.getValue());
			buffer.append(")");
		} else if (!reference.getElementValuePairs().isEmpty()) {
			buffer.append("(");
			buffer.append(reference.getElementValuePairs().stream().map(evPair -> {
				StringBuilder builder = new StringBuilder();
				Iterable<JvmOperation> declaredOperations = ((JvmAnnotationType) reference.getAnnotationType()).getDeclaredOperations();
				builder.append(createLinkToOperation(evPair.getElement(), declaredOperations));
				builder.append("=");
				builder.append(internalToString(evPair.getValue()));
				return builder.toString();
			}).collect(Collectors.joining(", ")));
			buffer.append(")");
		}
		return buffer.toString();
	}

	protected String _internalToString(JvmAnnotationValue jvmAnnotationValue) {
		EStructuralFeature ref = jvmAnnotationValue.eClass().getEStructuralFeature("values");
		if (ref == null) {
			throw new IllegalStateException("Cannot find feature with name 'values' in " + jvmAnnotationValue);
		}

		EList<?> values = (EList<?>) jvmAnnotationValue.eGet(ref);
		if (values.size() > 1) {
			return values.stream().map((value) -> internalToString(value)).collect(Collectors.joining(", ", "#[", "]"));
		} else {
			return internalToString(values.get(0));
		}
	}

	protected String _internalToString(Object obj) {
		return obj.toString();
	}

	protected String _internalToString(XTypeLiteral typeLiteral) {
		String text = createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, EcoreUtil.getURI(typeLiteral.getType()), typeLiteral.getType().getSimpleName());
		return text + String.join("", typeLiteral.getArrayDimensions());
	}

	protected String _internalToString(XListLiteral listLiteral) {
		return listLiteral.getElements().stream().map(element -> internalToString(element)).collect(Collectors.joining(", ", "#[", "]"));
	}

	protected String _internalToString(XBinaryOperation binaryOperation) {
		return internalToString(binaryOperation.getLeftOperand()) + " " + binaryOperation.getConcreteSyntaxFeatureName() + " "
				+ internalToString(binaryOperation.getRightOperand());
	}

	protected String _internalToString(XStringLiteral stringLiteral) {
		return "\"" + stringLiteral.getValue() + "\"";
	}

	protected String _internalToString(XNumberLiteral numberLiteral) {
		return numberLiteral.getValue();
	}

	protected String _internalToString(XBooleanLiteral booleanLiteral) {
		return Boolean.toString(booleanLiteral.isIsTrue());
	}

	protected String _internalToString(XMemberFeatureCall memberFeatureCall) {
		if (memberFeatureCall.isPackageFragment()) {
			return null;
		}
		String prefix = internalToString(memberFeatureCall.getMemberCallTarget());
		return internalHandleAbstractFeatureCall(prefix, memberFeatureCall);
	}

	protected String _internalToString(XFeatureCall featureCall) {
		return featureCall.isPackageFragment() ? null : internalHandleAbstractFeatureCall(null, featureCall);
	}

	protected String internalHandleAbstractFeatureCall(String prefix, XAbstractFeatureCall abstractFeatureCall) {
		final String postfix;
		if (abstractFeatureCall.getFeature() != null && !abstractFeatureCall.getFeature().eIsProxy()) {
			postfix = createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, EcoreUtil.getURI(abstractFeatureCall.getFeature()), abstractFeatureCall.getConcreteSyntaxFeatureName());
		} else {
			postfix = abstractFeatureCall.getConcreteSyntaxFeatureName();
		}

		if (prefix == null) {
			return postfix;
		} else {
			return prefix + "." + postfix;
		}
	}

	private String createLinkToOperation(JvmOperation toOperation, Iterable<JvmOperation> declaredOperations) {
		JvmOperation operation = toOperation != null //
				? toOperation //
				: Iterables.tryFind(declaredOperations, o -> "value".equals(o.getSimpleName())).orNull();
		return createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, EcoreUtil.getURI(operation), operation.getSimpleName());
	}

	protected String createLinkWithLabel(String scheme, URI uri, String label) {
		return HoverLinkHelper.createLinkWithLabel(scheme, uri, label);
	}

}
