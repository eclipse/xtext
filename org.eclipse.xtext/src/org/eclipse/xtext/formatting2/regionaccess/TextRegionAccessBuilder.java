/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeModelBasedRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextRegionAccessBuildingSequencer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TextRegionAccessBuilder {

	private TextRegionAccessBuildingSequencer fromSequencer;

	private NodeModelBasedRegionAccessBuilder fromNodeModel;

	public TextRegionAccessBuilder forNodeModel(XtextResource resource) {
		this.fromNodeModel = new NodeModelBasedRegionAccessBuilder().withResource(resource);
		return this;
	}

	public ISequenceAcceptor forSequence(ISerializationContext ctx, EObject root) {
		return this.fromSequencer = new TextRegionAccessBuildingSequencer().withRoot(ctx, root);
	}

	public ITextRegionAccess create() {
		if (fromNodeModel != null)
			return fromNodeModel.create();
		if (fromSequencer != null)
			return fromSequencer.getRegionAccess();
		throw new IllegalStateException();
	}

}
