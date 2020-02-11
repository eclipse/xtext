/*******************************************************************************
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.util.ITextRegion;

public class EObjectNode extends AbstractOutlineNode {

	private URI eObjectURI;

	private EClass eClass;

	private ITextRegion shortTextRegion;
	
	/**
	 * A {@link BackgroundOutlineTreeProvider} must use
	 * {@link #EObjectNode(EObject, IOutlineNode, ImageDescriptor, Object, boolean)} instead.
	 */
	public EObjectNode(EObject eObject, IOutlineNode parent, Image image, Object text, boolean isLeaf) {
		super(parent, image, text, isLeaf);
		this.eObjectURI = EcoreUtil.getURI(eObject);
		this.eClass = eObject.eClass();
	}

	/**
	 * @since 2.4
	 */
	public EObjectNode(EObject eObject, IOutlineNode parent, ImageDescriptor imageDescriptor, Object text, boolean isLeaf) {
		super(parent, imageDescriptor, text, isLeaf);
		this.eObjectURI = EcoreUtil.getURI(eObject);
		this.eClass = eObject.eClass();
	}

	@Override
	public URI getEObjectURI() {
		return eObjectURI;
	}

	public EClass getEClass() {
		return eClass;
	}
	
	public void setShortTextRegion(ITextRegion shortTextRegion) {
		this.shortTextRegion = shortTextRegion;
	}
	
	@Override
	public ITextRegion getSignificantTextRegion() {
		return shortTextRegion;
	}

	@Override
	public <T> T getAdapter(Class<T> adapterType) {
		if (adapterType == EClass.class) {
			return adapterType.cast(eClass);
		}
		return super.getAdapter(adapterType);
	}

	public EObject getEObject(Resource resource) {
		return resource.getResourceSet().getEObject(eObjectURI, true);
	}
}