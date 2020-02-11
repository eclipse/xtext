/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.text.java.hover.JavadocHover;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;

import com.google.inject.Inject;

/**
 * @author Christoph Kulla - Initial contribution and API
 * @author Sven Efftinge
 */
public class JdtHoverProvider implements IEObjectHoverProvider {

	@Inject
	private IJavaElementFinder javaElementFinder;
	
	private JavadocHoverWrapper javadocHover = new JavadocHoverWrapper ();
	
	@Override
	public IInformationControlCreatorProvider getHoverInfo(EObject eObject, ITextViewer viewer, IRegion region) {
		if (eObject instanceof JvmIdentifiableElement) {
			JvmIdentifiableElement jvmIdentifiableElement = (JvmIdentifiableElement) eObject;
			IJavaElement javaElement = javaElementFinder.findElementFor(jvmIdentifiableElement);
			if (javaElement!=null && javaElement.exists()) {
				javadocHover.setJavaElement(javaElement);
				final Object hoverInfo2 = javadocHover.getHoverInfo2(viewer, region);
				return new IInformationControlCreatorProvider2() {

					@Override
					public IInformationControlCreator getHoverControlCreator() {
						return javadocHover.getHoverControlCreator();
					}

					@Override
					public Object getInfo() {
						return hoverInfo2;
					}

					@Override
					public IInformationControlCreator getInformationPresenterControlCreator() {
						return javadocHover.getInformationPresenterControlCreator();
					}
					
				};
			}
		} 
		return null;
	}
	
	/**
	 * @since 2.3
	 */
	public static class JavadocHoverWrapper extends JavadocHover {

		private IJavaElement currentElement;
		
		public void setJavaElement (IJavaElement element) {
			currentElement = element;
		}
		
		@Override
		protected IJavaElement[] getJavaElementsAt(ITextViewer textViewer, IRegion hoverRegion) {
			// hack: return previously registered element
			// required as JavadocHover.getHoverInfo(IJavaElement[] elements,...) is private
			return new IJavaElement[] { currentElement };
		}	
		
	}

}
