/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.ui.JavaElementLabels;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtHyperlinkFactory {

	@Inject
	private IJavaElementFinder javaElementFinder;
	
	@Inject
	private Provider<JdtHyperlink> jdtHyperlinkProvider;
	
	public boolean canHandle(EObject to) {
		return to instanceof JvmIdentifiableElement && to.eResource() instanceof TypeResource;
	}

	public void createHyperlink(Region region, EObject to, IHyperlinkAcceptor acceptor) {
		JvmIdentifiableElement element = (JvmIdentifiableElement) to;
		IJavaElement javaElement = javaElementFinder.findElementFor(element);
		if (javaElement == null)
			return;
		String label = JavaElementLabels.getElementLabel(javaElement, JavaElementLabels.ALL_DEFAULT);
		JdtHyperlink result = jdtHyperlinkProvider.get();
		result.setHyperlinkRegion((IRegion)region);
		result.setHyperlinkText(label);
		result.setJavaElement(javaElement);
		acceptor.accept(result);
	}

	public void setJavaElementFinder(IJavaElementFinder javaElementFinder) {
		this.javaElementFinder = javaElementFinder;
	}

	public IJavaElementFinder getJavaElementFinder() {
		return javaElementFinder;
	}

	public void setJdtHyperlinkProvider(Provider<JdtHyperlink> jdtHyperlinkProvider) {
		this.jdtHyperlinkProvider = jdtHyperlinkProvider;
	}

	public Provider<JdtHyperlink> getJdtHyperlinkProvider() {
		return jdtHyperlinkProvider;
	}

}
