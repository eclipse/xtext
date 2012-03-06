/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.hover;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.text.java.hover.JavadocBrowserInformationControlInput;
import org.eclipse.jface.internal.text.html.HTMLPrinter;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.common.types.xtext.ui.JdtHoverProvider.JavadocHoverWrapper;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider;
import org.eclipse.xtext.xbase.ui.hover.XbaseInformationControlInput;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
public class XtendHoverProvider extends XbaseHoverProvider {

	@Inject
	private IXtendJvmAssociations associations;
	@Inject
	private ILabelProvider labelProvider;
	@Inject
	private IJavaElementFinder javaElementFinder;
	@Inject
	private XtendHoverSerializer xtendHoverSerializer;
	@Inject
	private XtendHoverDocumentationProvider documentationProvider;
	@Inject
	private IURIEditorOpener uriEditorOpener;

	private JavadocHoverWrapper javadocHover = new JavadocHoverWrapper();
	
	@Override
	protected XtextBrowserInformationControlInput getHoverInfo(EObject element, IRegion hoverRegion,
			XtextBrowserInformationControlInput previous) {
		EObject objectToView = getObjectToView(element);
		Pair<String, String> prefixAndSuffixPair = xtendHoverSerializer.computePreAndSuffix(element);
		String unsugaredExpression = xtendHoverSerializer.computeUnsugaredExpression(element);
		
		if (objectToView instanceof JvmIdentifiableElement) {
			Set<EObject> sourceElements = associations.getSourceElements(objectToView);
			if(sourceElements.isEmpty()){
				IJavaElement javaElement = javaElementFinder.findElementFor((JvmIdentifiableElement) objectToView);
				if (javaElement != null) {
					javadocHover.setJavaElement(javaElement);
					JavadocBrowserInformationControlInput hoverInfo2 = (JavadocBrowserInformationControlInput) javadocHover
							.getHoverInfo2(null, hoverRegion);
					return new XbaseInformationControlInput(previous, objectToView, javaElement, hoverInfo2.getHtml(),
							labelProvider, prefixAndSuffixPair.getFirst(), unsugaredExpression,
							prefixAndSuffixPair.getSecond());
				}
			}
		}
		String html = getHoverInfoAsHtml(objectToView);
		if (html != null) {
			StringBuffer buffer = new StringBuffer(html);
			HTMLPrinter.insertPageProlog(buffer, 0, getStyleSheet());
			HTMLPrinter.addPageEpilog(buffer);
			html = buffer.toString();
			return new XbaseInformationControlInput(previous, objectToView, html, labelProvider,
					prefixAndSuffixPair.getFirst(), unsugaredExpression, prefixAndSuffixPair.getSecond());
		}

		return null;
	}
	
	@Override
	protected boolean hasHover(EObject o) {
		return super.hasHover(o) || o instanceof XtendParameter || o instanceof XAbstractFeatureCall;
	}
	
	private EObject getObjectToView(EObject object) {
		if (object instanceof XAbstractFeatureCall) {
			return ((XAbstractFeatureCall) object).getFeature();
		}
		return object;
	}
}
