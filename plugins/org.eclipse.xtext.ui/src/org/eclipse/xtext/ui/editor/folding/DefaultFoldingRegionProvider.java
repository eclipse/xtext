/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.folding;

import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.AssertionFailedException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPartitioningException;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.ITokenTypeToPartitionTypeMapperExtension;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow - Introduced FoldedRegion, use ILocationInFileProvider
 */
public class DefaultFoldingRegionProvider implements IFoldingRegionProvider {
	
	private static final Logger log = Logger.getLogger(DefaultFoldingRegionProvider.class);
	
	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	/**
	 * @since 2.4
	 */
	@Inject
	private ITokenTypeToPartitionTypeMapperExtension tokenTypeToPartitionTypeMapperExtension;

	@Deprecated
	public DefaultFoldingRegionProvider(ILocationInFileProvider locationInFileProvider) {
		this.locationInFileProvider = locationInFileProvider;
		this.tokenTypeToPartitionTypeMapperExtension = new TerminalsTokenTypeToPartitionMapper();
	}

	@Inject
	public DefaultFoldingRegionProvider() {
	}
	
	public Collection<FoldedPosition> getFoldingRegions(final IXtextDocument xtextDocument) {
		return xtextDocument.readOnly(new IUnitOfWork<Collection<FoldedPosition>, XtextResource>() {
			public Collection<FoldedPosition> exec(XtextResource xtextResource) throws Exception {
				if (xtextResource == null)
					return Collections.emptyList();
				return doGetFoldingRegions(xtextDocument, xtextResource);
			}
		});
	}

	/**
	 * Compute the folding region. This method is executed in a {@link IUnitOfWork} so it's save to use the
	 * given resource. However, since this is a blocking action when opening editors in e4, implementors
	 * should be careful to not resolve too many cross references. Users of the {@link DerivedStateAwareResource}
	 * should consider to access the resource via {@link XtextResource#getParseResult() getParseResult().getRootAstElement()}
	 * rather than {@link Resource#getContents() getContents().get(0)}.
	 */
	protected Collection<FoldedPosition> doGetFoldingRegions(IXtextDocument xtextDocument, XtextResource xtextResource) {
		Collection<FoldedPosition> result = Sets.newLinkedHashSet();
		IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor = createAcceptor(xtextDocument, result);
		computeObjectFolding(xtextResource, foldingRegionAcceptor);
		computeCommentFolding(xtextDocument, foldingRegionAcceptor);
		return result;
	}

	protected IFoldingRegionAcceptor<ITextRegion> createAcceptor(IXtextDocument xtextDocument, Collection<FoldedPosition> foldedPositions) {
		return new DefaultFoldingRegionAcceptor(xtextDocument, foldedPositions);
	}

	protected void computeObjectFolding(XtextResource xtextResource, IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		IParseResult parseResult = xtextResource.getParseResult();
		if(parseResult != null){
			EObject rootASTElement = parseResult.getRootASTElement();
			if(rootASTElement != null){
				TreeIterator<EObject> allContents = rootASTElement.eAllContents();
				while (allContents.hasNext()) {
					EObject eObject = allContents.next();
					if (isHandled(eObject)) {
						computeObjectFolding(eObject, foldingRegionAcceptor);
					}
					if (!shouldProcessContent(eObject)) {
						allContents.prune();
					}
				}
			}
		}
	}

	protected ILocationInFileProvider getLocationInFileProvider() {
		return locationInFileProvider;
	}
	
	protected void computeObjectFolding(EObject eObject, IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		ITextRegion region = locationInFileProvider.getFullTextRegion(eObject);
		if (region != null) {
			ITextRegion significant = locationInFileProvider.getSignificantTextRegion(eObject);
			if (significant == null)
				throw new NullPointerException("significant region may not be null");
			int offset = region.getOffset();
			foldingRegionAcceptor.accept(offset, region.getLength(), significant);
		}
	}

	protected static final Pattern TEXT_PATTERN_IN_COMMENT = Pattern.compile("\\w");
	
	protected void computeCommentFolding(IXtextDocument xtextDocument, IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		try {
			ITypedRegion[] typedRegions = xtextDocument.computePartitioning(
					IDocumentExtension3.DEFAULT_PARTITIONING, 0, xtextDocument.getLength(), false);
			for (ITypedRegion typedRegion : typedRegions) {
				if (tokenTypeToPartitionTypeMapperExtension.isMultiLineComment(typedRegion.getType())) {
					int offset = typedRegion.getOffset();
					int length = typedRegion.getLength();
					Matcher matcher = getTextPatternInComment().matcher(xtextDocument.get(offset, length));
					if (matcher.find()) {
						TextRegion significant = new TextRegion(offset + matcher.start(), 0);
						foldingRegionAcceptor.accept(offset, length, significant);
					} else {
						foldingRegionAcceptor.accept(offset, length);
					}
				}
			}
		} catch (BadLocationException e) {
			log.error(e, e);
		} catch (BadPartitioningException e) {
			log.error(e, e);
		} catch (AssertionFailedException e) {
			// partioning failed
			log.error(e, e);
		}
	}
	
	/**
	 * @return the regular expression that finds the first significant part of a multi line comment.
	 */
	protected Pattern getTextPatternInComment() {
		return TEXT_PATTERN_IN_COMMENT;
	}

	/**
	 * @return <code>true</code> if the object should be folded if it spans more than one line. 
	 * Default is <code>false</code> if and only if the object is the root object of the resource.
	 */
	protected boolean isHandled(EObject eObject) {
		return eObject.eContainer() != null;
	}

	/**
	 * @return clients should <code>false</code> to abort the traversal of the model.
	 */
	protected boolean shouldProcessContent(EObject object) {
		return true;
	}
	
}
