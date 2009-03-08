package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.AbstractElement;
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

	private final String text;
	private int selectionOffset;

	// information copied from contentAssistContext
	private int offset;
	private int nodeTotalOffset;
	private int nodeTotalLength;
	private String matchString;

	public XtextCompletionProposal(AbstractElement abstractElement, String displayString,
			IContentAssistContext contentAssistContext) {
		this.text = displayString;
		this.offset = contentAssistContext.getOffSet();
		this.nodeTotalOffset = contentAssistContext.getNode().getTotalOffset();
		this.nodeTotalLength = contentAssistContext.getNode().getTotalLength();
		this.matchString = contentAssistContext.getMatchString();
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

	@Override
	public String toString() {
		return "XtextCompletionPoposal[text='" + this.text + "']";
	}

}
