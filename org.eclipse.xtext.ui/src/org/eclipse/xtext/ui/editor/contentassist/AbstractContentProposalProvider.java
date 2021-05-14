/*******************************************************************************
 * Copyright (c) 2008, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.inject.Inject;

/**
 * The default implementation of interface {@link IContentProposalProvider} provided with Xtext.
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Heiko Behrens
 * @author Jan K&ouml;hnlein
 */
public abstract class AbstractContentProposalProvider extends AbstractCompletionProposalFactory implements IContentProposalProvider {

	public class DefaultContentAssistProcessorSwitch extends XtextSwitch<Boolean> implements IFollowElementAcceptor {

		private final ContentAssistContext context;
		private final ICompletionProposalAcceptor acceptor;

		public DefaultContentAssistProcessorSwitch(ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			this.context = context;
			this.acceptor = acceptor;
		}

		@Override
		public Boolean defaultCase(EObject object) {
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseKeyword(Keyword object) {
			completeKeyword(object, context, acceptor);
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseRuleCall(RuleCall object) {
			completeRuleCall(object, context, acceptor);
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseAssignment(Assignment object) {
			completeAssignment(object, context, acceptor);
			return Boolean.TRUE;
		}

		@Override
		public void accept(AbstractElement element) {
			doSwitch(element);
		}
	}

	@Inject
	@ContentProposalLabelProvider
	private ILabelProvider labelProvider;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private IValueConverterService valueConverter;

	public static class NullSafeCompletionProposalAcceptor extends ICompletionProposalAcceptor.Delegate {

		public NullSafeCompletionProposalAcceptor(ICompletionProposalAcceptor delegate) {
			super(delegate);
		}

		@Override
		public void accept(ICompletionProposal proposal) {
			if (proposal != null)
				super.accept(proposal);
		}
	}

	@Override
	public void createProposals(ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		ICompletionProposalAcceptor nullSafe = new NullSafeCompletionProposalAcceptor(acceptor);
		IFollowElementAcceptor selector = createSelector(context, nullSafe);
		for (AbstractElement element : context.getFirstSetGrammarElements()) {
			selector.accept(element);
		}
	}

	public abstract void completeKeyword(Keyword object, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor);

	public abstract void completeRuleCall(RuleCall object, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor);

	public abstract void completeAssignment(Assignment object, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor);

	public IFollowElementAcceptor createSelector(ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		return new DefaultContentAssistProcessorSwitch(context, acceptor);
	}

	protected StyledString getKeywordDisplayString(Keyword keyword) {
		return new StyledString(keyword.getValue());
	}

	protected StyledString getStyledDisplayString(IEObjectDescription description) {
		return getStyledDisplayString(description.getEObjectOrProxy(),
			qualifiedNameConverter.toString(description.getQualifiedName()),
			qualifiedNameConverter.toString(description.getName()));
	}
	
	protected StyledString getStyledDisplayString(EObject element, String qualifiedName, String shortName) {
        StyledString styledString = new StyledString(getDisplayString(element, qualifiedName, shortName));
        String text = styledString.getString();
        int offset = text.indexOf(" - ");
        if (offset != -1) {
            styledString.setStyle(offset, text.length() - offset, StyledString.QUALIFIER_STYLER);
        }
        return styledString;
	}

	protected String getDisplayString(EObject element, String qualifiedNameAsString, String shortName) {
		if (qualifiedNameAsString == null)
			qualifiedNameAsString = shortName;
		if (qualifiedNameAsString == null) {
			if (element != null)
				qualifiedNameAsString = labelProvider.getText(element);
			else
				return null;
		}
		QualifiedName qualifiedName = qualifiedNameConverter.toQualifiedName(qualifiedNameAsString);		
		if(qualifiedName.getSegmentCount() >1) {
			return qualifiedName.getLastSegment() + " - " + qualifiedNameAsString;
		}
		return qualifiedNameAsString;
	}

	public void setValueConverter(IValueConverterService valueConverter) {
		this.valueConverter = valueConverter;
	}

	public IValueConverterService getValueConverter() {
		return valueConverter;
	}

	/**
	 * Returns the image for the label of the given element.
	 * 
	 * @param description
	 *            the {@link IEObjectDescription} for which to provide the label image
	 * @return the image used to label the element, or <code>null</code> if there is no image for the given object
	 * 
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

	

	public IQualifiedNameConverter getQualifiedNameConverter() {
		return qualifiedNameConverter;
	}

	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	public ILabelProvider getLabelProvider() {
		return labelProvider;
	}

}
