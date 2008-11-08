package org.eclipse.xtext.ui.common.editor.codecompletion;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
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
	
	private Logger logger = Logger.getLogger(XtextCompletionProposal.class);

	private String text;
	private String description;
	private Image image;
	private final StyledString label;
	private final int offset;
	private String pluginIdentifier;

	/**
	 * @param text
	 *            the text value to be replaced/inserted
	 * @param label
	 *            the label to be displayed
	 * @param description
	 *            some additional description for the tooltip
	 * @param imageFilePath
	 *            the relative path of the image file, relative to the root of
	 *            the plug-in; the path must be legal
	 * @param pluginId
	 *            the id of the plug-in containing the image file;
	 * @param offset
	 *            the offset of the text
	 */
	public XtextCompletionProposal(String text, StyledString label,
			String description, String imageFilePath, String pluginIdentifier,
			int offset) {
		Assert.isNotNull(text, "parameter 'text' must not be null");
		Assert.isNotNull(pluginIdentifier,
				"pluginIdentifier 'text' must not be null");
		this.text = text;
		this.description = description;
		this.offset = offset;
		this.pluginIdentifier = pluginIdentifier;

		if (label != null) {
			this.label = label;
		} else {
			this.label = new StyledString(this.text);
		}
		if (imageFilePath != null) {
			initializeImage(imageFilePath);
		}
	}
	
	/**
	 * Setter for the text to insert
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	
	/**
	 * Getter for the text to insert
	 * @return the text to insert
	 */
	public String getText() {
		return text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposal#apply(org.eclipse
	 * .jface.text.IDocument)
	 */
	public void apply(IDocument document) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.text.contentassist.ICompletionProposal#
	 * getAdditionalProposalInfo()
	 */
	public String getAdditionalProposalInfo() {
		return this.description == null ? null : this.description
				+ " Additional";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.text.contentassist.ICompletionProposal#
	 * getContextInformation()
	 */
	public IContextInformation getContextInformation() {
		if (this.description != null)
			return new ContextInformation(getImage(), this.text,
					this.description);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposal#getDisplayString
	 * ()
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
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#apply
	 * (org.eclipse.jface.text.ITextViewer, char, int, int)
	 */
	public void apply(ITextViewer viewer, char trigger, int stateMask,
			int offset) {

		try {
			IDocument document = viewer.getDocument();

			document.replace(this.offset, offset != this.offset ? offset
					- this.offset : 0, this.text);

		} catch (BadLocationException e) {
			logger.error(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#selected
	 * (org.eclipse.jface.text.ITextViewer, boolean)
	 */
	public void selected(ITextViewer viewer, boolean smartToggle) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#unselected
	 * (org.eclipse.jface.text.ITextViewer)
	 */
	public void unselected(ITextViewer viewer) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposalExtension2#validate
	 * (org.eclipse.jface.text.IDocument, int,
	 * org.eclipse.jface.text.DocumentEvent)
	 */
	public boolean validate(IDocument document, int offset, DocumentEvent event) {
		boolean startsWith = false;
		try {
			String prefix = document.get(this.offset, offset - this.offset);
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
	 * 
	 * @see
	 * org.eclipse.jface.text.contentassist.ICompletionProposal#getSelection
	 * (org.eclipse.jface.text.IDocument)
	 */
	public Point getSelection(IDocument document) {
		return new Point(offset + this.text.length(), 0);
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
}
