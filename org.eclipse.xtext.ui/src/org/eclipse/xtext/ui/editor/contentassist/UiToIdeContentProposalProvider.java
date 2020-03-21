/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.contentassist;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext.Builder;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.AbstractContentProposalProvider.NullSafeCompletionProposalAcceptor;
import org.eclipse.xtext.util.TextRegion;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Delegates to the generic IDE content proposal provider. Use this Implementation to share the same content assist code between Eclipse and
 * other editors for your DSL.
 * 
 * @author Titouan Vervack - Initial contribution and API
 * 
 * @since 2.13
 */
public class UiToIdeContentProposalProvider extends AbstractCompletionProposalFactory implements IContentProposalProvider {

	@Inject
	private IdeContentProposalProvider ideProvider;

	@Inject
	private Provider<ContentAssistContext.Builder> builderProvider;

	@Inject
	@ContentProposalLabelProvider
	private ILabelProvider labelProvider;

	@Override
	public void createProposals(org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		ArrayList<SimpleEntry<ContentAssistEntry, Integer>> entries = new ArrayList<>();
		IIdeContentProposalAcceptor ideAcceptor = new IIdeContentProposalAcceptor() {

			@Override
			public void accept(ContentAssistEntry entry, int priority) {
				if (entry != null) {
					entries.add(new SimpleEntry<ContentAssistEntry, Integer>(entry, priority));
				}
			}

			@Override
			public boolean canAcceptMoreProposals() {
				return entries.size() < getMaxProposals();
			}
		};

		ideProvider.createProposals(Arrays.asList(getIdeContext(context)), ideAcceptor);
		NullSafeCompletionProposalAcceptor uiAcceptor = new NullSafeCompletionProposalAcceptor(acceptor);

		entries.forEach(entry -> {
			ContentAssistEntry cae = entry.getKey();
			ConfigurableCompletionProposal proposal = doCreateProposal(cae.getProposal(), getDisplayString(cae), getImage(cae),
					entry.getValue(), context);
			uiAcceptor.accept(proposal);
		});
	}

	protected int getMaxProposals() {
		return 1000;
	}

	private ContentAssistContext getIdeContext(org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext cac) {
		Builder builder = builderProvider.get();
		Region replaceRegion = cac.getReplaceRegion();
		builder //
				.setPrefix(cac.getPrefix()) //
				.setSelectedText(cac.getSelectedText()) //
				.setRootModel(cac.getRootModel()) //
				.setRootNode(cac.getRootNode()) //
				.setCurrentModel(cac.getCurrentModel()) //
				.setPreviousModel(cac.getPreviousModel()) //
				.setCurrentNode(cac.getCurrentNode()) //
				.setLastCompleteNode(cac.getLastCompleteNode()) //
				.setOffset(cac.getOffset()) //
				.setReplaceRegion(new TextRegion(replaceRegion.getOffset(), replaceRegion.getLength())) //
				.setResource(cac.getResource());

		cac.getFirstSetGrammarElements().forEach(grammarElement -> builder.accept(grammarElement));
		return builder.toContext();
	}

	protected StyledString getDisplayString(ContentAssistEntry entry) {
		StyledString result = new StyledString(entry.getLabel() != null ? entry.getLabel() : entry.getProposal());
		if (!Strings.isNullOrEmpty(entry.getDescription())) {
			result.append(new StyledString(" \u2013 " + entry.getDescription(), StyledString.QUALIFIER_STYLER));
		}
		return result;
	}

	protected Image getImage(ContentAssistEntry entry) {
		Object source = entry.getSource();
		if (source instanceof IEObjectDescription) {
			return getImage((IEObjectDescription) source);
		} else if (source instanceof EObject) {
			return getImage((EObject) source);
		}
		return null;
	}

	/**
	 * Returns the image for the label of the given element.
	 * 
	 * @param description
	 *            the {@link IEObjectDescription} for which to provide the label image
	 * @return the image used to label the element, or <code>null</code> if there is no image for the given object
	 * @noreference This method is not intended to be referenced by clients.
	 */
	protected Image getImage(IEObjectDescription description) {
		return getImage(description.getEObjectOrProxy());
	}

	/**
	 * Returns the image for the label of the given element.
	 * 
	 * @param eObject
	 *            the element for which to provide the label image
	 * @return the image used to label the element, or <code>null</code> if there is no image for the given object
	 */
	protected Image getImage(EObject eObject) {
		return labelProvider.getImage(eObject);
	}
}
