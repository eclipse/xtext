/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.AbstractEObjectHover;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Christoph Kulla - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JdtHover extends AbstractEObjectHover {

	@Inject
	private IJavaElementFinder javaElementFinder;
	
	private JavadocHoverWrapper javadocHover = new JavadocHoverWrapper ();
	
	@Override
	@Deprecated
	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		Object o = getHoverInfo2(textViewer, hoverRegion);
		if (o!=null) {
			return o.toString();
		}
		return null;
	}

	@Override
	public Object getHoverInfo2(final ITextViewer textViewer, final IRegion hoverRegion) {		
		IXtextDocument xtextDocument = XtextDocumentUtil.get(textViewer);
		return xtextDocument.readOnly(new IUnitOfWork<Object, XtextResource>() {
			public Object exec(XtextResource state) throws Exception {
				Pair<EObject,IRegion> element = getXtextElementAt(state, hoverRegion);
				if (element!=null && element.getFirst() instanceof JvmIdentifyableElement) {
					JvmIdentifyableElement jvmIdentifyableElement = (JvmIdentifyableElement) element.getFirst();
					IJavaElement javaElement = javaElementFinder.findElementFor(jvmIdentifyableElement);
					if (javaElement!=null) {
						javadocHover.setJavaElement(javaElement);
						return javadocHover.getHoverInfo2(textViewer, hoverRegion);
					}
				} 
				return null;
			}		
		});
	}

	@Override
	public IInformationControlCreator getHoverControlCreator() {
		return javadocHover.getHoverControlCreator();
	}

	@Override
	protected Object getHoverInfo2(final EObject eObject, final ITextViewer textViewer, final IRegion hoverRegion) {
		if (eObject instanceof JvmIdentifyableElement) {
			JvmIdentifyableElement jvmIdentifyableElement = (JvmIdentifyableElement) eObject;
			IJavaElement javaElement = javaElementFinder.findElementFor(jvmIdentifyableElement);
			if (javaElement!=null) {
				javadocHover.setJavaElement(javaElement);
				return javadocHover.getHoverInfo2(textViewer, hoverRegion);
			}
		} 
		return null;
	}
	
}
