/*******************************************************************************
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.LineAndColumn;

import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.*;
import org.eclipse.xtext.nodemodel.ICompositeNode;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
public class DocumentExtensions {

	@Inject
	private UriExtensions uriExtensions;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	public Position newPosition(Resource resource, int offset) {
		if (resource instanceof XtextResource) {
			ICompositeNode rootNode = ((XtextResource) resource).getParseResult().getRootNode();
			LineAndColumn lineAndColumn = getLineAndColumn(rootNode, offset);
			return new Position(lineAndColumn.getLine() - 1, lineAndColumn.getColumn() - 1);
		}
		return null;
	}

	public Range newRange(Resource resource, int startOffset, int endOffset) {
		Position startPosition = newPosition(resource, startOffset);
		if (startPosition == null) {
			return null;
		}
		Position endPosition = newPosition(resource, endOffset);
		if (endPosition == null) {
			return null;
		}
		return new Range(startPosition, endPosition);
	}

	public Range newRange(Resource resource, ITextRegion region) {
		if (region == null)
			return null;
		return newRange(resource, region.getOffset(), region.getOffset() + region.getLength());
	}

	public Location newLocation(Resource resource, ITextRegion textRegion) {
		Range range = newRange(resource, textRegion);
		if (range == null) {
			return null;
		}
		String uri = uriExtensions.toUriString(resource.getURI());
		return new Location(uri, range);
	}

	public Location newLocation(EObject object) {
		Resource resource = object.eResource();
		ITextRegion textRegion = locationInFileProvider.getSignificantTextRegion(object);
		return newLocation(resource, textRegion);
	}

	/**
	 * Returns with the {@link Location location} that represents the {@link ILocationInFileProvider#getFullTextRegion
	 * full text region} of the argument.
	 * 
	 * @since 2.16
	 */
	public Location newFullLocation(EObject object) {
		Resource resource = object.eResource();
		ITextRegion textRegion = locationInFileProvider.getFullTextRegion(object);
		return newLocation(resource, textRegion);
	}

	public Location newLocation(EObject owner, EStructuralFeature feature, int indexInList) {
		Resource resource = owner.eResource();
		ITextRegion textRegion = locationInFileProvider.getSignificantTextRegion(owner, feature, indexInList);
		return newLocation(resource, textRegion);
	}

}
