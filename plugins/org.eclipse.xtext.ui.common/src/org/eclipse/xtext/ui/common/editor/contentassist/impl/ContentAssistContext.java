package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class ContentAssistContext implements IContentAssistContext {

	private String matchingString;
	private EObject model;
	private AbstractNode node;
	private int offSet;
	private AbstractNode referenceNode;
	private CompositeNode rootNode;

	public ContentAssistContext(EObject model, int offSet, String matchingString, AbstractNode node,
			AbstractNode referenceNode, CompositeNode rootNode) {
		super();
		this.model = model;
		this.offSet = offSet;
		this.matchingString = matchingString;
		this.node = node;
		this.referenceNode = referenceNode;
		this.rootNode = rootNode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext
	 * #getMatchString()
	 */
	public String getMatchString() {
		return matchingString;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext
	 * #getModel()
	 */
	public EObject getModel() {
		return model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext
	 * #getNode()
	 */
	public AbstractNode getNode() {
		return node;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext
	 * #getOffSet()
	 */
	public int getOffSet() {
		return offSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext
	 * #getReferenceNode()
	 */
	public AbstractNode getReferenceNode() {
		return referenceNode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext
	 * #getRootNode()
	 */
	public CompositeNode getRootNode() {
		return rootNode;
	}

}
