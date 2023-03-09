/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.HoverParams;
import org.eclipse.lsp4j.MarkupContent;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.annotations.Beta;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@Beta
public class HoverService implements IHoverService {
	@Inject
	private DocumentExtensions documentExtensions;

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private IEObjectDocumentationProvider eObjectDocumentationProvider;

	@Override
	public Hover hover(Document document, XtextResource resource, HoverParams params, CancelIndicator cancelIndicator) {
		int offset = document.getOffSet(params.getPosition());
		HoverContext context = createContext(document, resource, offset);
		return hover(context);
	}

	protected HoverContext createContext(Document document, XtextResource resource, int offset) {
		EObject crossLinkedEObject = eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, offset);
		if (crossLinkedEObject != null) {
			if (crossLinkedEObject.eIsProxy()) {
				return null;
			}
			IParseResult parseResult = resource.getParseResult();
			if (parseResult == null) {
				return null;
			}
			ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			if (leafNode != null && leafNode.isHidden() && leafNode.getOffset() == offset) {
				leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset - 1);
			}
			if (leafNode == null) {
				return null;
			}
			ITextRegion leafRegion = leafNode.getTextRegion();
			return new HoverContext(document, resource, offset, leafRegion, crossLinkedEObject);
		}
		EObject element = eObjectAtOffsetHelper.resolveElementAt(resource, offset);
		if (element == null) {
			return null;
		}
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(element);
		return new HoverContext(document, resource, offset, region, element);
	}

	protected Hover hover(HoverContext context) {
		if (context == null) {
			return IHoverService.EMPTY_HOVER;
		}
		MarkupContent contents = getMarkupContent(context);
		if (contents == null) {
			return IHoverService.EMPTY_HOVER;
		}
		Range range = getRange(context);
		if (range == null) {
			return IHoverService.EMPTY_HOVER;
		}
		return new Hover(contents, range);
	}

	protected Range getRange(HoverContext ctx) {
		if (!ctx.getRegion().contains(ctx.getOffset())) {
			return null;
		}
		return documentExtensions.newRange(ctx.getResource(), ctx.getRegion());
	}

	protected MarkupContent getMarkupContent(HoverContext ctx) {
		return toMarkupContent(getKind(ctx), getContents(ctx.getElement()));
	}

	protected String getKind(HoverContext it) {
		return "markdown";
	}

	protected MarkupContent toMarkupContent(String kind, String value) {
		return new MarkupContent(kind, value);
	}

	public String getContents(EObject element) {
		if (element == null) {
			return "";
		}
		String documentation = eObjectDocumentationProvider.getDocumentation(element);
		if (documentation == null) {
			return "";
		}
		return documentation;
	}
}
