/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.occurrences;

import static java.util.Collections.*;
import static org.eclipse.xtext.util.ITextRegionWithLineInformation.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.DocumentHighlight;
import org.eclipse.lsp4j.DocumentHighlightKind;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.IReferenceFinder.Acceptor;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.util.DocumentHighlightComparator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegion;

import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Default implementation of the {@link IDocumentHighlightService document
 * highlight service}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@Singleton
public class DefaultDocumentHighlightService implements IDocumentHighlightService {

	private static final Logger LOGGER = Logger.getLogger(DefaultDocumentHighlightService.class);

	/**
	 * Placeholder document version.
	 */
	private static final int UNUSED_VERSION = -1;

	/**
	 * Filters all elements that does not have {@link EObject#eContainer()
	 * container}.
	 */
	private static final Predicate<EObject> AST_ROOT_FILTER = obj -> obj.eContainer() != null;

	@Inject
	protected EObjectAtOffsetHelper offsetHelper;

	@Inject
	protected ILocationInFileProvider locationInFileProvider;

	@Inject
	protected ITextRegionTransformer textRegionTransformer;

	@Inject
	private Provider<TargetURIs> targetURIsProvider;

	@Inject
	private IReferenceFinder referenceFinder;

	@Inject
	private TargetURICollector uriCollector;

	@Inject
	private DocumentHighlightComparator comparator;

	@Override
	public List<? extends DocumentHighlight> getDocumentHighlights(Document document, XtextResource resource, TextDocumentPositionParams params, CancelIndicator cancelIndicator) {
		int offset = document.getOffSet(params.getPosition());
		return getDocumentHighlights(resource, offset);
	}

	@Override
	public List<DocumentHighlight> getDocumentHighlights(final XtextResource resource, final int offset) {
		if (resource == null) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.warn("Resource was null.");
			}
			return emptyList();
		}

		final URI uri = resource.getURI();
		if (offset < 0) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.warn("Invalid offset argument. Offset must be a non-negative integer for resource: " + uri);
			}
			return emptyList();
		}

		final IParseResult parseResult = resource.getParseResult();
		if (parseResult == null) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.warn("Parse result was null for resource: " + uri);
			}
			return emptyList();
		}

		final ICompositeNode rootNode = parseResult.getRootNode();
		final String docContent = rootNode.getText();
		final int docLength = docContent.length();
		if (offset >= docLength) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.warn("Offset exceeds document lenght. Document was " + docLength + " and offset was: " + offset
						+ " for resource: " + uri);
			}
			return emptyList();
		}

		final EObject selectedElement = offsetHelper.resolveElementAt(resource, offset);
		if (!isDocumentHighlightAvailableFor(selectedElement, resource, offset)) {
			return emptyList();
		}

		final Supplier<Document> docSupplier = Suppliers.memoize(() -> new Document(UNUSED_VERSION, docContent));
		Iterable<URI> targetURIs = getTargetURIs(selectedElement);
		if (!(targetURIs instanceof TargetURIs)) {
			final TargetURIs result = targetURIsProvider.get();
			result.addAllURIs(targetURIs);
			targetURIs = result;
		}

		final Builder<DocumentHighlight> resultBuilder = ImmutableList.<DocumentHighlight>builder();
		final Acceptor acceptor = (Acceptor2) (source, sourceURI, eReference, index, targetOrProxy, targetURI) -> {
			final ITextRegion region = locationInFileProvider.getSignificantTextRegion(source, eReference, index);
			if (!isNullOrEmpty(region)) {
				resultBuilder.add(textRegionTransformer.apply(docSupplier.get(), region, DocumentHighlightKind.Read));
			}
		};
		referenceFinder.findReferences((TargetURIs) targetURIs, resource, acceptor, new NullProgressMonitor());

		if (resource.equals(selectedElement.eResource())) {
			final ITextRegion region = locationInFileProvider.getSignificantTextRegion(selectedElement);
			if (!isNullOrEmpty(region)) {
				resultBuilder.add(textRegionTransformer.apply(docSupplier.get(), region, DocumentHighlightKind.Write));
			}
		}

		return FluentIterable.from(resultBuilder.build()).toSortedList(comparator);
	}

	/**
	 * Returns with {@code true} if the AST element selected from the resource
	 * can provide document highlights, otherwise returns with {@code false}.
	 * 
	 * <p>
	 * Clients may override this method to change the default behavior.
	 * 
	 * @param selectedElement
	 *            the selected element resolved via the offset from the
	 *            resource. Can be {@code null}.
	 * @param resource
	 *            the resource for the document.
	 * @param offset
	 *            the offset of the selection.
	 * 
	 * @return {@code true} if the document highlight is available for the
	 *         selected element, otherwise {@code false}.
	 *
	 */
	protected boolean isDocumentHighlightAvailableFor(final EObject selectedElement, final XtextResource resource,
			final int offset) {
		if (selectedElement == null || !getSelectedElementFilter().apply(selectedElement)) {
			return false;
		}

		// This code handles the special case where your language has constructs that can refer to
		// themselves. For example "function MyFunction begin ... end MyFunction" defines the function "MyFunction" and
		// terminates its implementation block with an additional repetition of the word "MyFunction". Normally, when
		// you are positioned on a selected element, you only want to highlight that selected element when you are
		// positioned directly on top of the name of the selected element. However, when the selected element can refer
		// to itself then there are references inside the element that must trigger highlighting.  In the example,
		// we also want to highlight "MyFunction" when we are positioned on the "end MyFunction".
		
		INode crossReferenceNode = offsetHelper.getCrossReferenceNode(resource, new TextRegion(offset, 0));
		
		if (crossReferenceNode != null) {
			EObject crossReferencedElement = offsetHelper.getCrossReferencedElement(crossReferenceNode);

			if (crossReferencedElement != null && crossReferencedElement == selectedElement) {
				return true;
			}
		}

		final EObject containedElement = offsetHelper.resolveContainedElementAt(resource, offset);
		// When the cursor is positioned in the selected element, then we only want to highlight the selected element
		// when we are directly on top of the name (the significant text region) of that element.
		
 		if (selectedElement == containedElement) {
			final ITextRegion region = locationInFileProvider.getSignificantTextRegion(containedElement);
			return !isNullOrEmpty(region)
					// Region is comparable to a selection in an editor,
					// therefore the end position is exclusive.
					&& (region.contains(offset) || (region.getOffset() + region.getLength()) == offset);
		}

		return true;
	}

	/**
	 * Returns with a filter that is used to ignore elements at a given offset.
	 * <p>
	 * By default returns with a filter that skips all {@link EObject} instances
	 * that have no {@link EObject#eContainer() eContainer()}.
	 * 
	 * @return a function that will be used to skip elements selected on the
	 *         given offset.
	 */
	protected Predicate<EObject> getSelectedElementFilter() {
		return AST_ROOT_FILTER;
	}

	/**
	 * Returns with an iterable of URIs that points to all elements that are
	 * referenced by the argument or vice-versa.
	 * 
	 * @return an iterable of URIs that are referenced by the argument or the
	 *         other way around.
	 */
	protected Iterable<URI> getTargetURIs(final EObject primaryTarget) {
		final TargetURIs result = targetURIsProvider.get();
		uriCollector.add(primaryTarget, result);
		return result;
	}

	/**
	 * Returns {@code true} if the argument is either {@code null} or
	 * {@link ITextRegionWithLineInformation#EMPTY_REGION empty}. Otherwise
	 * returns with {@code false}.
	 * 
	 * @return {@code true} if the argument is either {@code null} or empty.
	 */
	protected boolean isNullOrEmpty(final ITextRegion region) {
		return region == null || EMPTY_REGION == region;
	}

	/**
	 * Sugar for lambda.
	 */
	@FunctionalInterface
	private static interface Acceptor2 extends Acceptor {

		@Override
		default void accept(final IReferenceDescription description) {
			// Does not accept any reference descriptions because local
			// references are announced per object.
		}

	}

}
