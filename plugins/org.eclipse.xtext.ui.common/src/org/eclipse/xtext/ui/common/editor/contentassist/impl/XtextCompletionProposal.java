package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;

/**
 * Default Xtext implementation of interface <code>ICompletionProposal</code>.
 * 
 * @author Dennis Hübner - Initial contribution and API
 * @author Michael Clay
 * @see org.eclipse.jface.text.contentassist.ICompletionProposal
 */
public class XtextCompletionProposal implements ICompletionProposal {

	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(XtextCompletionProposal.class);

	private final AbstractElement abstractElement;
	private final String text;
	private final IContentAssistContext contentAssistContext;
	private int selectionOffset;

	public XtextCompletionProposal(AbstractElement abstractElement, String displayString,
			IContentAssistContext contentAssistContext) {
		this.abstractElement = abstractElement;
		this.text = displayString;
		this.contentAssistContext = contentAssistContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#apply(org.eclipse.jface.text.IDocument)
	 */
	public void apply(IDocument document) {

		try {

			AbstractNode abstractNode = this.contentAssistContext.getNode();

			int replacementOffset = this.contentAssistContext.getOffSet();

			if (!"".equals(this.contentAssistContext.getMatchString())
					&& getDisplayString().toUpperCase().startsWith(
							this.contentAssistContext.getMatchString().toUpperCase())) {

				document.replace(abstractNode.getTotalOffset(), abstractNode.getTotalLength(), "");

				replacementOffset = abstractNode.getTotalOffset();

			}

			document.replace(replacementOffset, 0, this.text.trim());

			this.selectionOffset = replacementOffset + this.text.trim().length();

		}
		catch (BadLocationException e) {
			logger.error(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getAdditionalProposalInfo()
	 */
	public String getAdditionalProposalInfo() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getContextInformation()
	 */
	public IContextInformation getContextInformation() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getDisplayString()
	 */
	public String getDisplayString() {
		return this.text;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getImage()
	 */
	public Image getImage() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getSelection(org.eclipse.jface.text.IDocument)
	 */
	public Point getSelection(IDocument document) {
		return new Point(this.selectionOffset, 0);
	}

	/**
	 * 
	 * @return true or false whether the given prefix matches the text of this completion proposal
	 */
	public boolean matches() {

		boolean matches = true;

		AbstractElement abstractElement = null;

		if (this.abstractElement instanceof Keyword || this.abstractElement instanceof CrossReference) {
			abstractElement = GrammarUtil.containingAssignment(this.abstractElement);
		}

		if (null == abstractElement) {
			abstractElement = this.abstractElement;
		}

		boolean candidateToCompare = false;

		// means if we are at the end of a complete token we want to filter only
		// equal grammarelements (not the 'next' ones)
		if (isCusorAtEndOfLastCompleteNode() && abstractElement.equals(getCurrentGrammarElement())) {
			candidateToCompare = true;
		}
		else if (!isCusorAtEndOfLastCompleteNode()) {
			candidateToCompare = true;
		}

		if (candidateToCompare
				&& (!"".equals(this.contentAssistContext.getMatchString().trim()) && !getDisplayString().toUpperCase()
						.trim().startsWith(this.contentAssistContext.getMatchString().toUpperCase().trim()))) {
			matches = false;
		}

		return matches;
	}

	@Override
	public String toString() {
		return "XtextCompletionPoposal[text='" + this.text + "']";
	}

	/**
	 * @return true or false wheter the cursor is at the the last complete node
	 */
	public boolean isCusorAtEndOfLastCompleteNode() {
		return this.contentAssistContext.getNode() == this.contentAssistContext.getReferenceNode();
	}

	/**
	 * @return the grammar element of the current node
	 */
	public EObject getCurrentGrammarElement() {

		EObject grammarElement = GrammarUtil.containingAssignment(this.contentAssistContext.getNode()
				.getGrammarElement());

		if (null == grammarElement) {
			grammarElement = (this.contentAssistContext.getNode().getGrammarElement() instanceof ParserRule ? ((ParserRule) this.contentAssistContext
					.getNode().getGrammarElement()).getAlternatives()
					: this.contentAssistContext.getNode().getGrammarElement());
		}

		return grammarElement;
	}
}
