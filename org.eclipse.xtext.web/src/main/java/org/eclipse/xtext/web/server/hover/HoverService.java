/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.hover;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.labels.AlternativeImageDescription;
import org.eclipse.xtext.ide.labels.DecoratedImageDescription;
import org.eclipse.xtext.ide.labels.IImageDescription;
import org.eclipse.xtext.ide.labels.IImageDescriptionProvider;
import org.eclipse.xtext.ide.labels.INameLabelProvider;
import org.eclipse.xtext.ide.labels.SimpleImageDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.contentassist.ContentAssistService;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.web.server.util.ElementAtOffsetUtil;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Service class for mouse hover information. Such information can be created
 * for an already existing model element or for an element proposed through
 * content assist.
 */
@Singleton
public class HoverService {
	@Inject
	private ElementAtOffsetUtil elementAtOffsetUtil;

	@Inject
	private IEObjectDocumentationProvider eObjectDocumentationProvider;

	@Inject
	private IImageDescriptionProvider imageDescriptionProvider;

	@Inject
	private INameLabelProvider nameLabelProvider;

	@Inject
	private OperationCanceledManager operationCanceledManager;

	@Inject
	private ContentAssistService contentAssistService;

	/**
	 * Compute a hover result at the given offset in the document.
	 */
	public HoverResult getHover(XtextWebDocumentAccess document, int offset) throws InvalidRequestException {
		return document.readOnly(new CancelableUnitOfWork<HoverResult, IXtextWebDocument>() {
			@Override
			public HoverResult exec(IXtextWebDocument it, CancelIndicator cancelIndicator) throws Exception {
				EObject element = elementAtOffsetUtil.getElementAt(it.getResource(), offset);
				return createHover(element, it.getStateId(), cancelIndicator);
			}
		});
	}

	/**
	 * Compute a hover result for a content assist proposal at the given offset.
	 */
	public HoverResult getHover(XtextWebDocumentAccess document, String proposal, ITextRegion selection, int offset)
			throws InvalidRequestException {
		return document.readOnly(new CancelableUnitOfWork<HoverResult, IXtextWebDocument>() {
			@Override
			public HoverResult exec(IXtextWebDocument it, CancelIndicator cancelIndicator) throws Exception {
				ContentAssistContext[] contexts = contentAssistService.getContexts(it, selection, offset);
				Wrapper<Object> proposedElement = new Wrapper<Object>();
				Collection<ContentAssistContext> contextsList = Arrays.asList(contexts);
				contentAssistService.getProposalProvider().createProposals(contextsList,
						new IIdeContentProposalAcceptor() {
							@Override
							public void accept(ContentAssistEntry entry, int priority) {
								operationCanceledManager.checkCanceled(cancelIndicator);
								if (entry != null && entry.getSource() != null
										&& Objects.equals(entry.getProposal(), proposal)) {
									proposedElement.set(entry.getSource());
								}
							}

							@Override
							public boolean canAcceptMoreProposals() {
								return proposedElement.get() == null;
							}
						});
				return createHover(proposedElement.get(), it.getStateId(), cancelIndicator);
			}
		});
	}

	protected HoverResult createHover(Object element, String stateId, CancelIndicator cancelIndicator) {
		String nameLabel = null;
		if (element != null) {
			nameLabel = nameLabelProvider.getNameLabel(element);
			if (nameLabel != null) {
				nameLabel = surroundWithDiv(nameLabel, "element-name");
			}
		}
		if (nameLabel != null) {
			operationCanceledManager.checkCanceled(cancelIndicator);
			String titleHtml = surroundWithDiv(
					addIconDivs(imageDescriptionProvider.getImageDescription(element), nameLabel), "xtext-hover");
			operationCanceledManager.checkCanceled(cancelIndicator);
			EObject eobject = null;
			if (element instanceof EObject) {
				eobject = ((EObject) element);
			} else if (element instanceof IEObjectDescription) {
				eobject = ((IEObjectDescription) element).getEObjectOrProxy();
			}
			String bodyHtml = "";
			if (eobject != null && !eobject.eIsProxy()) {
				String documentation = eObjectDocumentationProvider.getDocumentation(eobject);
				if (documentation != null) {
					bodyHtml = surroundWithDiv(documentation, "xtext-hover");
				}
			}
			return new HoverResult(stateId, titleHtml, bodyHtml);
		}
		return new HoverResult(stateId);
	}

	protected String addIconDivs(IImageDescription it, String nameHtml) {
		if (it instanceof SimpleImageDescription) {
			return surroundWithDiv(nameHtml, ((SimpleImageDescription) it).getImageID() + "-icon");
		} else if (it instanceof AlternativeImageDescription) {
			List<String> strings = Lists
					.transform(((AlternativeImageDescription) it).getImageIDs(), (String s) -> s + "-icon");
			return surroundWithDiv(nameHtml,
					strings.toArray(new String[strings.size()]));
		} else if (it instanceof DecoratedImageDescription) {
			return IterableExtensions.fold(
					Iterables.concat(((DecoratedImageDescription) it).getDecorators(),
							Lists.newArrayList(((DecoratedImageDescription) it).getBaseImage())),
					nameHtml, (String $0, IImageDescription $1) -> addIconDivs($1, $0));
		}
		return null;
	}

	protected String surroundWithDiv(String html, String... divClasses) {
		StringConcatenation builder = new StringConcatenation();
		builder.append("<div");
		if (divClasses.length > 0) {
			builder.append(" class=\"");
			builder.append(Joiner.on(" ").join(divClasses));
			builder.append("\"");
		}
		builder.append(">");
		builder.newLineIfNotEmpty();
		builder.append("\t");
		builder.append(html, "\t");
		builder.newLineIfNotEmpty();
		builder.append("</div>");
		builder.newLine();
		return builder.toString();
	}
}
