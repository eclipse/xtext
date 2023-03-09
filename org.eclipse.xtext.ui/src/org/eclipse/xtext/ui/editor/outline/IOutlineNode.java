/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.impl.BackgroundOutlineTreeProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IReadAccess;

/**
 * A model for a node in the outline. Implementors must inherit from
 * {@link org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IOutlineNode extends IAdaptable, IReadAccess<EObject> {

	Object getText();

	Image getImage();

	IOutlineNode getParent();

	List<IOutlineNode> getChildren();

	boolean hasChildren();

	/**
	 * The region that triggers selection of this node when "Link with Editor" is enabled.
	 */
	ITextRegion getFullTextRegion();

	/**
	 * The region that is selected in the editor when this node is double clicked or selected in "Link with Editor"
	 * mode.
	 */
	ITextRegion getSignificantTextRegion();

	/**
	 * Allows to use {@link ImageDescriptor}s instead of {@link Image}s. This enables 
	 * calculating the outline nodes in a background thread. 
	 * 
	 * @author Jan Koehnlein - Initial contribution and API
	 * @since 2.4
	 * @see BackgroundOutlineTreeProvider
	 */
	public interface Extension {

		ImageDescriptor getImageDescriptor();
	}
}
