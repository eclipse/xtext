/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.hover;

import static org.eclipse.xtext.xbase.ui.hover.HoverLinkHelper.*;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.hover.html.XtextElementLinks;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverDocumentationProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
@SuppressWarnings("deprecation")
public class XtendHoverDocumentationProvider extends XbaseHoverDocumentationProvider {

	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private OverrideHelper overrideHelper;

	@Override
	protected JvmDeclaredType getDeclaringType(EObject eObject) {
		if (eObject instanceof XtendFunction) {
			JvmOperation jvmOperation = associations.getDirectlyInferredOperation((XtendFunction) eObject);
			return super.getDeclaringType(jvmOperation);
		}
		return super.getDeclaringType(eObject);
	}

	@Override
	protected void addAnnotations(EObject object) {
		if (object instanceof XtendAnnotationTarget) {
			for (XAnnotation annotation : ((XtendAnnotationTarget) object).getAnnotations()) {
				JvmType annotationType = annotation.getAnnotationType();
				if (annotationType != null && !annotationType.eIsProxy() && annotationType instanceof JvmAnnotationType) {
					buffer.append("@");
					buffer.append(createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME,
							EcoreUtil.getURI(annotationType), annotation.getAnnotationType().getSimpleName()));
					EList<XAnnotationElementValuePair> elementValuePairs = annotation.getElementValuePairs();
					if (elementValuePairs.size() > 0) {
						buffer.append("(");
						List<INode> findNodesForFeature = NodeModelUtils.findNodesForFeature(annotation,
								XAnnotationsPackage.eINSTANCE.getXAnnotation_ElementValuePairs());
						if (findNodesForFeature.size() > 0)
							buffer.append(findNodesForFeature.get(0).getText());
						buffer.append(")");
					}
					buffer.append("<br>");
				}
			}
		} else {
			super.addAnnotations(object);
		}
	}

	@Override
	protected void handleSuperMethodReferences(EObject context) {
		if (context instanceof XtendFunction) {
			XtendFunction function = (XtendFunction) context;
			if (function.isOverride()) {
				JvmOperation inferredOperation = associations.getDirectlyInferredOperation(function);
				if (inferredOperation != null) {
					JvmOperation overridden = overrideHelper.findOverriddenOperation(inferredOperation);
					if (overridden != null) {
						buffer.append("<div>"); //$NON-NLS-1$
						buffer.append("<b>"); //$NON-NLS-1$
						buffer.append("Overrides:"); //$NON-NLS-1$
						buffer.append("</b> "); //$NON-NLS-1$
						buffer.append(createMethodInTypeLinks(overridden));
						buffer.append("</div>"); //$NON-NLS-1$
					}
				}
			}
		}
	}

	@Override
	protected List<String> initParameterNames() {
		List<String> result = super.initParameterNames();
		if (context instanceof XtendFunction) {
			for (XtendParameter param : ((XtendFunction) context).getParameters()) {
				result.add(param.getName());
			}
		}
		if (context instanceof XtendConstructor) {
			for (XtendParameter param : ((XtendConstructor) context).getParameters()) {
				result.add(param.getName());
			}
		}
		return result;
	}

	@Override
	protected Map<String, URI> initExceptionNamesToURI() {
		Map<String, URI> result = super.initExceptionNamesToURI();
		if (context instanceof XtendFunction) {
			for (JvmTypeReference exception : ((XtendFunction) context).getExceptions()) {
				result.put(exception.getSimpleName(), EcoreUtil.getURI(exception.getType()));
			}
		}
		if (context instanceof XtendConstructor) {
			for (JvmTypeReference exception : ((XtendConstructor) context).getExceptions()) {
				result.put(exception.getSimpleName(), EcoreUtil.getURI(exception.getType()));
			}
		}
		return result;
	}

	@Override
	protected List<EObject> getFilteredDerivedElements(EObject o, EClass type) {
		List<EObject> filteredDerivedElements = super.getFilteredDerivedElements(o, type);
		if (filteredDerivedElements.size() > 1)
			return filteredDerivedElements;
		return Lists.newArrayList();
	}

	@Override
	protected List<EObject> getFilteredSourceElements(EObject o, EClass type) {
		List<EObject> filteredSourceElements = super.getFilteredSourceElements(o, type);
		if (filteredSourceElements.size() > 1)
			return filteredSourceElements;
		return Lists.newArrayList();
	}

	protected String resolveDocumentationForJvmElement(EObject jvmElement) {
		String documentation = documentationProvider.getDocumentation(jvmElement);
		if (documentation != null) {
			return documentation;
		}
		DocumentationAdapter adapter = getDocumentationAdapter(jvmElement);
		return adapter == null ? null : adapter.getDocumentation();
	}

}
