package org.eclipse.xtext.ui.service.impl;

import java.util.Collections;
import java.util.ListIterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.editor.formatting.XtextFormattingStrategy;
import org.eclipse.xtext.ui.service.IFormatterService;
import org.eclipse.xtext.ui.service.IPreferenceStoreService;
import org.eclipse.xtext.ui.tokentype.BuildInTokenTypeDef;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BuildInFormatterService implements IFormatterService {

	private IPreferenceStoreService preferenceStoreService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.service.IFormatterService#shouldIndent(org.eclipse
	 * .xtext.parsetree.AbstractNode)
	 */
	public boolean shouldIndent(AbstractNode node) {
		// indentation make sense for non root composite nodes that has at least
		// 2 LeafNodes
		if (node.getParent() != null && node instanceof CompositeNode && hasGivenNumberOfDirectLeafNodes(2, node)) {
			return true;
		}
		else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.service.IFormatterService#after(org.eclipse.xtext
	 * .parsetree.LeafNode)
	 */
	public String before(LeafNode leafNode) {
		BuildInTokenTypeDef bittd = new BuildInTokenTypeDef();
		if (bittd.mlCommentTokenType().match(leafNode)
				|| (bittd.keyWordTokenType().match(leafNode) && leafNode.getText().length() > 1)) {
			return XtextFormattingStrategy.NEW_LINE;
		}
		return XtextFormattingStrategy.SPACE;
	}

	/**
	 * @param leafNode
	 * @param withHidden
	 * @return
	 */
	protected final LeafNode nextNode(LeafNode leafNode, boolean withHidden) {
		EList<EObject> nodes = asList(getRootNode(leafNode).eAllContents());
		return next(nodes, leafNode, withHidden);
	}

	protected final LeafNode previousNode(LeafNode leafNode, boolean withHidden) {
		EList<EObject> nodes = new BasicEList<EObject>(asList(getRootNode(leafNode).eAllContents()));
		Collections.reverse(nodes);
		return next(nodes, leafNode, withHidden);
	}

	private EList<EObject> asList(TreeIterator<EObject> allContents) {
		EList<EObject> list = new BasicEList<EObject>();
		for (; allContents.hasNext();) {
			list.add(allContents.next());
		}
		return list;
	}

	private LeafNode next(EList<EObject> nodes, LeafNode ln, boolean withHidden) {
		int index = nodes.indexOf(ln) + 1;
		if (nodes.size() > index) {
			for (ListIterator<EObject> lIter = nodes.listIterator(index); lIter.hasNext();) {
				EObject current = lIter.next();
				if (current instanceof LeafNode) {
					LeafNode currentLeafNode = (LeafNode) current;
					if (withHidden || !currentLeafNode.isHidden())
						return currentLeafNode;
				}
			}

		}
		return null;
	}

	private boolean hasGivenNumberOfDirectLeafNodes(int number, AbstractNode node) {
		int count = 0;
		for (EObject eO : node.eContents()) {
			if (eO instanceof LeafNode && !((LeafNode) eO).isHidden()) {
				count++;
				if (count == number)
					return true;
			}
		}
		return false;
	}

	private AbstractNode getRootNode(AbstractNode leafNode) {
		AbstractNode parent = (AbstractNode) leafNode.eContainer();
		if (parent == null) {
			return leafNode;
		}
		else {
			return getRootNode(parent);
		}
	}

	public void setPreferenceStoreService(IPreferenceStoreService preferenceStoreService) {
		this.preferenceStoreService = preferenceStoreService;
	}
}