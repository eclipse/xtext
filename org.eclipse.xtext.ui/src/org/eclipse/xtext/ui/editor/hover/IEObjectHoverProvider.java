/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill - Add IInformationControlCreatorProvider2
 */
@ImplementedBy(DefaultEObjectHoverProvider.class)
public interface IEObjectHoverProvider {
	/**
	 * 
	 * @param object
	 *            {@link EObject} for which to show an information hover.
	 * @param viewer
	 *            - might not contain the given {@link EObject}.
	 * @param region
	 *            - might be a cross reference pointing to the given object.
	 * 
	 * @return an to be shown in a hover pop up, returns <code>null</code> if no hover information exists for the given
	 *         element.
	 */
	IInformationControlCreatorProvider getHoverInfo(EObject object, ITextViewer viewer, IRegion region);

	public interface IInformationControlCreatorProvider {
		/**
		 * an {@link IInformationControlCreator} capable of creating an
		 * {@link org.eclipse.jface.text.IInformationControl} for the information provided by {@link #getInfo()}.
		 */
		IInformationControlCreator getHoverControlCreator();

		/**
		 * The information to be used by the {@link IInformationControlCreator}.
		 */
		Object getInfo();
	}

	/**
	 * @since 2.6
	 */
	public interface IInformationControlCreatorProvider2 extends IInformationControlCreatorProvider{
		/**
		 * an {@link IInformationControlCreator} capable of creating an
		 * {@link org.eclipse.jface.text.IInformationControl} for the information provided by {@link IInformationControlCreatorProvider#getInfo()}.
		 * Used to get the InformationPresenterControlCreator to show tooltip description (F2) on an element in the editor.
		 */
		IInformationControlCreator getInformationPresenterControlCreator();
	}
}
