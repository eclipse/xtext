/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import org.eclipse.jdt.internal.debug.ui.JavaDebugHover;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider.IInformationControlCreatorProvider;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * The purpose of this class is to make the dependency to JavaDebugHover optional. Hence, JavaDebugHover must not appear
 * in the signatures of this class.
 * 
 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=437104
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JavaDebugHoverProvider {

	@Inject
	private Injector injector;

	public static boolean IS_JAVA_DEBUG_HOVER_AVAILABLE = isJavaDebugHoverAvailable();

	private static boolean isJavaDebugHoverAvailable() {
		try {
			JavaDebugHover.class.getName();
			return true;
		} catch (Throwable t) {
			return false;
		}
	}

	public IInformationControlCreatorProvider getInformationControlCreatorProvider(ITextViewer textViewer,
			IRegion hoverRegion) {

		if (!IS_JAVA_DEBUG_HOVER_AVAILABLE)
			return null;

		final JavaDebugHover javaDebugHover = injector.getInstance(JavaDebugHover.class);
		final Object hoverInfo = javaDebugHover.getHoverInfo2(textViewer, hoverRegion);
		if (hoverInfo == null)
			return null;

		return new IEObjectHoverProvider.IInformationControlCreatorProvider2() {
			@Override
			public IInformationControlCreator getHoverControlCreator() {
				return javaDebugHover.getHoverControlCreator();
			}

			@Override
			public Object getInfo() {
				return hoverInfo;
			}

			@Override
			public IInformationControlCreator getInformationPresenterControlCreator() {
				return javaDebugHover.getInformationPresenterControlCreator();
			}
		};
	}

}
