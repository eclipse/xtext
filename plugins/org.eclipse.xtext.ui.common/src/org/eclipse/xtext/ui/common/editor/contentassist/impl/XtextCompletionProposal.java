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
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;

/**
 * Default Xtext implementation of interface <code>ICompletionProposal</code>.
 * 
 * @author Dennis Hübner - Initial contribution and API
 * @author Michael Clay
 * @author Jan Köhnlein
 * @see org.eclipse.jface.text.contentassist.ICompletionProposal
 */
public class XtextCompletionProposal implements ICompletionProposal {

	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(XtextCompletionProposal.class);

	private final AbstractElement abstractElement;
	private final String text;
	private int selectionOffset;

	// information copied from contentAssistContext
	private int offset;
	private int nodeTotalOffset;
	private int nodeTotalLength;
	private String matchString;
	private EObject grammarElement;
	private boolean isCusorAtEndOfLastCompleteNode;

	public XtextCompletionProposal(AbstractElement abstractElement, String displayString,
			IContentAssistContext contentAssistContext) {
		this.abstractElement = abstractElement;
		this.text = displayString;
		this.offset = contentAssistContext.getOffSet();
		this.nodeTotalOffset = contentAssistContext.getNode().getTotalOffset();
		this.nodeTotalLength = contentAssistContext.getNode().getTotalLength();
		this.matchString = contentAssistContext.getMatchString();
		this.grammarElement = contentAssistContext.getNode().getGrammarElement();
		this.isCusorAtEndOfLastCompleteNode = contentAssistContext.getNode() == contentAssistContext.getReferenceNode();
	}

	public void apply(IDocument document) {
		try {
			int replacementOffset = offset;
			if (!"".equals(matchString) && getDisplayString().toUpperCase().startsWith(matchString.toUpperCase())) {
				document.replace(nodeTotalOffset, nodeTotalLength, "");
				replacementOffset = nodeTotalOffset;
			}
			document.replace(replacementOffset, 0, this.text.trim());
			this.selectionOffset = replacementOffset + this.text.trim().length();
		}
		catch (BadLocationException e) {
			logger.error(e);
		}
	}

	public String getAdditionalProposalInfo() {
		return null;
	}

	public IContextInformation getContextInformation() {
		return null;
	}

	public String getDisplayString() {
		return this.text;
	}

	public Image getImage() {
		return null;
	}

	public Point getSelection(IDocument document) {
		return new Point(this.selectionOffset, 0);
	}

	/**
	 * 
	 * @return true or false whether the given prefix matches the text of this
	 *         completion proposal
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
		if (isCusorAtEndOfLastCompleteNode && abstractElement.equals(getCurrentGrammarElement())) {
			candidateToCompare = true;
		}
		else if (!isCusorAtEndOfLastCompleteNode) {
			candidateToCompare = true;
		}
		if (candidateToCompare
				&& (!"".equals(matchString.trim()) && !getDisplayString().toUpperCase().trim().startsWith(
						matchString.toUpperCase().trim()))) {
			matches = false;
		}
		return matches;
	}

	@Override
	public String toString() {
		return "XtextCompletionPoposal[text='" + this.text + "']";
	}

	/**
	 * @return the grammar element of the current node
	 */
	public EObject getCurrentGrammarElement() {
		EObject containingAssignment = GrammarUtil.containingAssignment(grammarElement);
		if (containingAssignment == null) {
			return grammarElement instanceof ParserRule ? ((ParserRule) grammarElement).getAlternatives()
					: grammarElement;
		}
		return containingAssignment;
	}
}
