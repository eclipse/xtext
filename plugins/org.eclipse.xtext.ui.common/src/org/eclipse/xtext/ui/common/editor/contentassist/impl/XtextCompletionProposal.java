package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension2;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension6;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;

/**
 * Default Xtext implementation of interface <code>ICompletionProposal</code>.
 * 
 * @author Dennis Hübner - Initial contribution and API
 * @author Michael Clay
 * @see org.eclipse.jface.text.contentassist.ICompletionProposal
 * @see org.eclipse.jface.text.contentassist.ICompletionProposalExtension2
 * @see org.eclipse.jface.text.contentassist.ICompletionProposalExtension6
 */
public class XtextCompletionProposal implements ICompletionProposal,
		ICompletionProposalExtension2, ICompletionProposalExtension6 {
	
	protected final Logger logger = Logger.getLogger(XtextCompletionProposal.class);

	
	private AbstractElement abstractElement;
	private String text;
	private String description;
	private Image image;
	private final StyledString label;
	private String pluginIdentifier;
	private IContentAssistContext contentAssistContext;

	
	public XtextCompletionProposal(AbstractElement abstractElement, String displayString,
			IContentAssistContext contentAssistContext) {
		this.abstractElement = abstractElement;
		this.text = displayString;
		this.description = displayString;
		this.label = new StyledString(displayString);
		this.contentAssistContext = contentAssistContext;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#apply(org.eclipse.jface.text.IDocument)
	 */
	public void apply(IDocument document) {

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getAdditionalProposalInfo()
	 */
	public String getAdditionalProposalInfo() {
		return this.description == null ? null : this.description
				+ " Additional";
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getContextInformation()
	 */
	public IContextInformation getContextInformation() {
		if (this.description != null)
			return new ContextInformation(getImage(), this.text,
					this.description);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getDisplayString()
	 */
	public String getDisplayString() {
		return this.label.getString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getImage()
	 */
	public Image getImage() {
		return this.image;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#apply(org.eclipse.jface.text.ITextViewer, char, int, int)
	 */
	public void apply(ITextViewer viewer, char trigger, int stateMask,
			int offset) {

		try {
			
			IDocument document = viewer.getDocument();
			
			if (this.contentAssistContext.getModel() != null) {
				
				
				AbstractNode abstractNode = this.contentAssistContext.getNode();
				
				if (abstractNode instanceof LeafNode) {
					
					LeafNode currentLeafNode = (LeafNode) abstractNode;
					
					if (getDisplayString().toUpperCase().startsWith(currentLeafNode.getText().toUpperCase())) {
						this.text = this.text.substring(this.contentAssistContext.getOffSet() - currentLeafNode.getTotalOffset());
					} else if (isCusorAtEndOfLastCompleteNode()) {

						if (currentLeafNode.getGrammarElement() instanceof CrossReference
								&& abstractElement instanceof CrossReference) {
							this.text =  " " + this.text;
						}
						else if (currentLeafNode.getGrammarElement() instanceof RuleCall
								&& currentLeafNode.getGrammarElement().eContainer() instanceof Assignment
								&& abstractElement instanceof Assignment) {
							this.text = " " + this.text;
						}
						else if (!GrammarUtil.containingParserRule(abstractElement).equals(
								  GrammarUtil.containingParserRule(currentLeafNode.getGrammarElement()))) {
							this.text = " " + this.text;
						}
					}
				} 
			}
			
			document.replace(this.contentAssistContext.getOffSet(), 0, this.text);

		} catch (BadLocationException e) {
			logger.error(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#selected(org.eclipse.jface.text.ITextViewer, boolean)
	 */
	public void selected(ITextViewer viewer, boolean smartToggle) {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#unselected(org.eclipse.jface.text.ITextViewer)
	 */
	public void unselected(ITextViewer viewer) {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#validate(org.eclipse.jface.text.IDocument, int, org.eclipse.jface.text.DocumentEvent)
	 */
	public boolean validate(IDocument document, int offset, DocumentEvent event) {
		boolean startsWith = false;
		try {
			String prefix = document.get(this.contentAssistContext.getOffSet(), offset - this.contentAssistContext.getOffSet());
			startsWith = getDisplayString().toLowerCase().startsWith(
					prefix.toLowerCase());
		} catch (BadLocationException e) {
			logger.error(e);
		}
		return startsWith;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.text.contentassist.ICompletionProposalExtension6#
	 * getStyledDisplayString()
	 */
	public StyledString getStyledDisplayString() {
		return this.label;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getSelection(org.eclipse.jface.text.IDocument)
	 */
	public Point getSelection(IDocument document) {
		return new Point(this.contentAssistContext.getOffSet() + this.text.length(), 0);
	}
	
	/**
	 * 
	 * @return true or false whether the given prefix matches the text of this completion proposal
	 */
	public boolean matches() {
		
		boolean matches = true;
		
		if (this.contentAssistContext.getModel() != null) {
			
			AbstractElement abstractElement = null;

			if (this.abstractElement instanceof Keyword ||
					this.abstractElement instanceof CrossReference) {
				abstractElement = GrammarUtil.containingAssignment(this.abstractElement);
			} 
			
			if (null==abstractElement) {
				abstractElement = this.abstractElement;
			}
			
			
			boolean candidateToCompare 	= false;
			
			// means if we are at the end of a complete token we want to filter only equal grammarelements (not the 'next' ones)
			if (isCusorAtEndOfLastCompleteNode() && 
					abstractElement.equals(getCurrentGrammarElement())) {
				candidateToCompare = true;
			} else if (!isCusorAtEndOfLastCompleteNode() ) {
				candidateToCompare = true;
			}
			
			if ( candidateToCompare && (!"".equals(this.contentAssistContext.getMatchString().trim()) && 
					!getDisplayString().toUpperCase().trim().startsWith(this.contentAssistContext.getMatchString().toUpperCase().trim()))) {
				matches = false;
			}	
		}
		
		
		return matches;
	}

	@Override
	public String toString() {
		return "XtextCompletionPoposal[text='"+this.text+"']";
	}

	private void initializeImage(String imageName) {
		Image newImage = JFaceResources.getImage(imageName);
		//TODO: needs plugin to resolve image path
//		if (newImage == null) {
//			ImageDescriptor imageDescriptorFromPlugin = Activator
//					.imageDescriptorFromPlugin(this.pluginIdentifier, imageName);
//			if (imageDescriptorFromPlugin != null) {
//				JFaceResources.getImageRegistry().put(imageName,
//						imageDescriptorFromPlugin);
//				newImage = JFaceResources.getImage(imageName);
//			}
//		}
		this.image = newImage;
	}
	
	
	/**
	 * @return true or false wheter the cursor is at the the last complete node
	 */
	public boolean isCusorAtEndOfLastCompleteNode() {
		return  this.contentAssistContext.getNode() == this.contentAssistContext.getReferenceNode();
	}

	/**
	 * @return the grammar element of the current node
	 */
	public EObject getCurrentGrammarElement() {

		EObject grammarElement = GrammarUtil.containingAssignment(this.contentAssistContext.getNode().getGrammarElement());

		if (null == grammarElement) {
			grammarElement = (this.contentAssistContext.getNode().getGrammarElement() instanceof ParserRule ? ((ParserRule) this.contentAssistContext.getNode()
					.getGrammarElement()).getAlternatives() : this.contentAssistContext.getNode().getGrammarElement());
		}

		return grammarElement;
	}
}
