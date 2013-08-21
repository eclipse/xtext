/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.ITextHoverExtension;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension2;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension3;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension4;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension5;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension6;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.link.ILinkedModeListener;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.link.LinkedModeUI;
import org.eclipse.jface.text.link.LinkedModeUI.ExitFlags;
import org.eclipse.jface.text.link.LinkedModeUI.IExitPolicy;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Michael Clay
 * @author Christoph Kulla - Added support for hovers
 * @author Holger Schill - Resolve proxies against context for hover
 */
public class ConfigurableCompletionProposal implements 
		Comparable<ConfigurableCompletionProposal>, 
		ICompletionProposal,
		ICompletionProposalExtension,
		ICompletionProposalExtension2, 
		ICompletionProposalExtension3, 
		ICompletionProposalExtension4, 
		ICompletionProposalExtension5, 
		ICompletionProposalExtension6 {

	private static final Logger log = Logger.getLogger(ConfigurableCompletionProposal.class);
	
	// copied from final class CompletionProposal
	
	/** The styled string builder used to display this proposal */
	private StyledString displayString;
	/** The replacement string. */
	private String replacementString;
	/** The replacement offset. */
	private int replacementOffset;
	/** The replacement length. */
	private int replacementLength;
	/** The cursor position after this proposal has been applied. */
	private int cursorPosition;
	/** The image to be displayed in the completion proposal popup. */
	private Image image;
	/** The context information of this proposal. */
	private IContextInformation contextInformation;
	/** The additional info of this proposal. */
	private Object additionalProposalInfo;
	
	private IReplacementTextApplier textApplier;
	
	private IEObjectHover hover;
	
	private Map<String,Object> additionalData;
	
	/**
	 * Used to store arbitrary data as a protocol between two or more clients unknown to this class.
	 * 
	 * @since 2.4
	 */
	public void setAdditionalData(String key, Object additionalData) {
		if (this.additionalData == null)
			this.additionalData = newHashMap();
		this.additionalData.put(key, additionalData);
	}
	
	/**
	 * Used to store arbitrary data as a protocol between two or more clients unknown to this class.
	 * 
	 * @since 2.4
	 */
	public Object getAdditionalData(String key) {
		return additionalData != null ? additionalData.get(key) : null;
	}
	
	public interface IReplacementTextApplier {
		void apply(IDocument document, ConfigurableCompletionProposal proposal) throws BadLocationException;
	}
	
	/**
	 * Creates a new completion proposal based on the provided information. The replacement string is
	 * considered being the display string too. All remaining fields are set to <code>null</code>.
	 *
	 * @param replacementString the actual string to be inserted into the document
	 * @param replacementOffset the offset of the text to be replaced
	 * @param replacementLength the length of the text to be replaced
	 * @param cursorPosition the position of the cursor following the insert relative to replacementOffset
	 */
	public ConfigurableCompletionProposal(String replacementString, int replacementOffset, int replacementLength, int cursorPosition) {
		this(replacementString, replacementOffset, replacementLength, cursorPosition, null, null, null, null);
	}

	/**
	 * Creates a new completion proposal. All fields are initialized based on the provided information.
	 *
	 * @param replacementString the actual string to be inserted into the document
	 * @param replacementOffset the offset of the text to be replaced
	 * @param replacementLength the length of the text to be replaced
	 * @param cursorPosition the position of the cursor following the insert relative to replacementOffset
	 * @param image the image to display for this proposal
	 * @param displayString the string to be displayed for the proposal
	 * @param contextInformation the context information associated with this proposal
	 * @param additionalProposalInfo the additional information associated with this proposal
	 */
	public ConfigurableCompletionProposal(String replacementString, int replacementOffset, int replacementLength, int cursorPosition, Image image, StyledString displayString, IContextInformation contextInformation, String additionalProposalInfo) {
		Assert.isNotNull(replacementString);
		Assert.isTrue(replacementOffset >= 0);
		Assert.isTrue(replacementLength >= 0);
		Assert.isTrue(cursorPosition >= 0);

		this.replacementString= replacementString;
		this.replacementOffset= replacementOffset;
		this.replacementLength= replacementLength;
		this.cursorPosition= cursorPosition;
		this.selectionStart = replacementOffset + cursorPosition;
		this.image= image;
		this.displayString= displayString==null ? new StyledString(this.replacementString) : displayString;
		this.contextInformation= contextInformation;
		this.additionalProposalInfo= additionalProposalInfo;
	}

	/*
	 * @see ICompletionProposal#apply(IDocument)
	 */
	public void apply(IDocument document) {
		String original = document.get();
		try {
			if (getTextApplier() == null) {
				document.replace(getReplacementOffset(), getReplacementLength(), getReplacementString());
			} else {
				getTextApplier().apply(document, this);
			}
			if (linkedMode)
				setUpLinkedMode(document);
		} catch (Exception exc) {
			log.error("Error applying completion proposal", exc);
			document.set(original);
		}
	}
	
	/*
	 * @see ICompletionProposal#getSelection(IDocument)
	 */
	public Point getSelection(IDocument document) {
		if (!linkedMode && getSelectionLength() == 0)
			return new Point(getReplacementOffset() + getCursorPosition(), 0);
		return new Point(getSelectionStart(), getSelectionLength());
	}

	/*
	 * @see ICompletionProposal#getContextInformation()
	 */
	public IContextInformation getContextInformation() {
		return contextInformation;
	}

	/*
	 * @see ICompletionProposal#getImage()
	 */
	public Image getImage() {
		return image;
	}

	/*
	 * @see ICompletionProposal#getDisplayString()
	 */
	public String getDisplayString() {
		if (displayString != null) {
			return getStyledDisplayString().getString();
		}
		return replacementString;
	}

	/*
	 * @see ICompletionProposalExtension6#getStyledDisplayString()
	 */
	public StyledString getStyledDisplayString() {
		return displayString;
	}
	/*
	 * @see ICompletionProposal#getAdditionalProposalInfo()
	 */
	public String getAdditionalProposalInfo() {
		if (additionalProposalInfo != null) {
			return additionalProposalInfo.toString();
		}
		return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof ConfigurableCompletionProposal))
			return false;
		String otherDisplayString = ((ConfigurableCompletionProposal) obj).getDisplayString();
		return Strings.equal(otherDisplayString, getDisplayString());
	}
	
	@Override
	public int hashCode() {
		String displayString = getDisplayString();
		return displayString != null ? displayString.hashCode() : 31;
	}

	// end copy
	
	private boolean autoInsertable = true;
	
	private int selectionLength = 0;
	
	private int selectionStart;
	private boolean linkedMode;
	private ITextViewer viewer;
	private char[] exitChars;
	private char[] triggerChars;
	private PrefixMatcher matcher;
	private int replaceContextLength;
	private int priority;
	private Resource contextResource;
	
	public boolean isAutoInsertable() {
		return autoInsertable;
	}

	public void setAutoInsertable(boolean autoInsertable) {
		this.autoInsertable = autoInsertable;
	}

	public String getReplacementString() {
		return replacementString;
	}

	public int getReplacementOffset() {
		return replacementOffset;
	}

	public int getReplacementLength() {
		return replacementLength;
	}

	public int getCursorPosition() {
		return cursorPosition;
	}

	public void setDisplayString(String displayString) {
		setDisplayString(new StyledString(displayString));
	}
	
	public void setDisplayString(StyledString displayString) {
		this.displayString = displayString;
	}

	public void setReplacementString(String replacementString) {
		this.replacementString = replacementString;
	}

	public void setReplacementOffset(int replacementOffset) {
		this.replacementOffset = replacementOffset;
	}

	public void setReplacementLength(int replacementLength) {
		this.replacementLength = replacementLength;
	}

	public void setCursorPosition(int cursorPosition) {
		this.cursorPosition = cursorPosition;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setContextInformation(IContextInformation contextInformation) {
		this.contextInformation = contextInformation;
	}

	public void setAdditionalProposalInfo(Object additionalProposalInfo) {
		this.additionalProposalInfo = additionalProposalInfo;
	}
	/**
	 * @since 2.4
	 */
	public void setProposalContextResource(Resource contextResource){
		this.contextResource = contextResource;
	}

	public int getSelectionStart() {
		return selectionStart;
	}
	
	public int getSelectionLength() {
		return selectionLength;
	}

	public void setSelectionLength(int selectionLength) {
		this.selectionLength = selectionLength;
	}

	public void setSelectionStart(int selectionStart) {
		this.selectionStart = selectionStart;
	}
	
	public void setSimpleLinkedMode(ITextViewer viewer, char... exitChars) {
		this.linkedMode = true;
		this.viewer = viewer;
		this.exitChars = exitChars;
	}
	
	/**
	 * @since 2.2
	 */
	protected boolean isLinkedMode() {
		return linkedMode;
	}
	
	public void apply(ITextViewer viewer, char trigger, int stateMask, int offset) {
		this.setReplacementLength(offset - getReplacementOffset() + viewer.getSelectedRange().y);
		boolean replaceRight = (stateMask & SWT.CTRL) != 0;
		if (replaceRight) {
			setReplacementLength(getReplaceContextLength());
		}
		apply(viewer.getDocument());
	}
	
	/**
	 * @since 2.3
	 */
	public void apply(IDocument document, char trigger, int offset) {
		this.setReplacementLength(offset - getReplacementOffset() + viewer.getSelectedRange().y);
		apply(viewer.getDocument());
	}
	
	/**
	 * @since 2.3
	 */
	public boolean isValidFor(IDocument document, int offset) {
		return validate(document, offset, null);
	}
	
	/**
	 * @since 2.3
	 */
	public int getContextInformationPosition() {
		if (getContextInformation() == null)
			return -1;
		return getReplacementOffset() + getCursorPosition();
	}
	
	/**
	 * @since 2.3
	 */
	public char[] getTriggerCharacters() {
		return triggerChars;
	}
	
	/**
	 * @since 2.3
	 */
	public void setTriggerCharacters(char[] triggerChars) {
		this.triggerChars = triggerChars;
	}
	
	private Point rememberedSelection;
	
	private void updateSelection(ITextViewer viewer) {
		rememberedSelection = viewer.getSelectedRange();
		int offset = rememberedSelection.x;
		int length= getReplaceContextLength() - (offset - getReplacementOffset());
		
		viewer.setSelectedRange(offset, length);
	}
	
	private void restoreSelection(ITextViewer viewer) {
		if (rememberedSelection != null)
			viewer.setSelectedRange(rememberedSelection.x, rememberedSelection.y);
	}

	public void selected(ITextViewer viewer, boolean smartToggle) {
		if (smartToggle)
			updateSelection(viewer);
		else {
			restoreSelection(viewer);
			rememberedSelection= null;
		}
	}

	public void unselected(ITextViewer viewer) {
		restoreSelection(viewer);
		rememberedSelection= null;
	}

	public boolean validate(IDocument document, int offset, DocumentEvent event) {
		if (event != null) {
			int oldReplaceContextLength = getReplaceContextLength();
			int diff = event.getText().length() - event.getLength();
			setReplaceContextLength(oldReplaceContextLength + diff);
		}
		try {
			String prefix = document.get(replacementOffset, offset - replacementOffset);
			return matcher.isCandidateMatchingPrefix(replacementString, prefix);
		}
		catch (BadLocationException e) {
			log.info(e.getMessage(), e);
			return false;
		}
	}
	
	public void setMatcher(PrefixMatcher matcher) {
		this.matcher = matcher;
	}

	public PrefixMatcher getMatcher() {
		return matcher;
	}
	
	public void setReplaceContextLength(int replaceContextLength) {
		this.replaceContextLength = replaceContextLength;
	}

	public int getReplaceContextLength() {
		return replaceContextLength;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * Returns the priority of the proposal. The bigger the returned int value, the 
	 * higher is the precedence of the proposal. Proposals with higher priority will
	 * be listed above proposals with lower priority.
	 */
	public int getPriority() {
		return priority;
	}
	
	public int compareTo(ConfigurableCompletionProposal other) {
		if (priority < other.getPriority())
			return 1;
		if (priority > other.getPriority())
			return -1;
		return getDisplayString().compareTo(other.getDisplayString());
	}
	
	// copied from AbstractJavaCompletionProposal
	/**
	 * Sets up a simple linked mode at {@link #getCursorPosition()} and an exit policy that will
	 * exit the mode when <code>closingCharacter</code> is typed and an exit position at
	 * <code>getCursorPosition() + 1</code>.
	 *
	 * @param document the document
	 */
	protected void setUpLinkedMode(IDocument document) {
		try {
			LinkedPositionGroup group= new LinkedPositionGroup();
			group.addPosition(new LinkedPosition(document, getSelectionStart(), getSelectionLength(), LinkedPositionGroup.NO_STOP));

			LinkedModeModel model= new LinkedModeModel();
			model.addGroup(group);
			model.forceInstall();

			LinkedModeUI ui= new LinkedModeUI(model, viewer);
//			ui.setSimpleMode(true);
			ui.setExitPolicy(new ExitPolicy(exitChars));
			ui.setExitPosition(viewer, getCursorPosition() + getReplacementOffset(), 0, Integer.MAX_VALUE);
			ui.setCyclingMode(LinkedModeUI.CYCLE_NEVER);
			ui.enter();
		} catch (BadLocationException e) {
			log.info(e.getMessage(), e);
		}
	}

	public void setTextApplier(IReplacementTextApplier textApplier) {
		this.textApplier = textApplier;
	}

	public IReplacementTextApplier getTextApplier() {
		return textApplier;
	}

	// mainly copied from AbstractJavaCompletionProposal
	protected static class ExitPolicy implements IExitPolicy {

		private final char exitCharacters[];

		public ExitPolicy(char[] exitCharacter) {
			exitCharacters= exitCharacter;
		}

		/*
		 * @see org.eclipse.jdt.internal.ui.text.link.LinkedPositionUI.ExitPolicy#doExit(org.eclipse.jdt.internal.ui.text.link.LinkedPositionManager, org.eclipse.swt.events.VerifyEvent, int, int)
		 */
		public ExitFlags doExit(LinkedModeModel environment, VerifyEvent event, int offset, int length) {
			if (event.character == '\0')
				return null;
			for (char c: exitCharacters) {
				if (event.character == c) {
					return new ExitFlags(ILinkedModeListener.UPDATE_CARET, false);
				}
			}

			switch (event.character) {
				case SWT.CR:
					return new ExitFlags(ILinkedModeListener.UPDATE_CARET, false);
				default:
					return null;
			}
		}

	}

	public IInformationControlCreator getInformationControlCreator() {
		if (hover!=null && hover instanceof ITextHoverExtension) {
			return ((ITextHoverExtension) hover).getHoverControlCreator();
		}
		return null;
	}

	public CharSequence getPrefixCompletionText(IDocument document, int completionOffset) {
		return getReplacementString();
	}

	public int getPrefixCompletionStart(IDocument document, int completionOffset) {
		return getReplacementOffset();
	}

	public void setHover (IEObjectHover hover) {
		this.hover = hover;
	}

	public Object getAdditionalProposalInfo(IProgressMonitor monitor) {
		if (hover!=null) {
			EObject eObject = null;
			if (additionalProposalInfo instanceof EObject) {
				eObject = (EObject) additionalProposalInfo;
			} else { 
				if (additionalProposalInfo instanceof Provider) {
					Object o = ((Provider<?>) additionalProposalInfo).get();
					if (o instanceof EObject)
						eObject = (EObject) o;
				}
			}
			if (eObject != null) {
				if(eObject.eIsProxy()){
					eObject = EcoreUtil.resolve(eObject, contextResource);
				}
				return hover.getHoverInfo(eObject, viewer, null);
			}
		}
		return additionalProposalInfo != null ? additionalProposalInfo : null;
	}
	
	@Override
	public String toString() {
		return "Proposal: " + getDisplayString();
	}
}
