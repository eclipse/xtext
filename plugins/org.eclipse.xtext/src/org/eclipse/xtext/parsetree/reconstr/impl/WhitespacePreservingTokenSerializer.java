package org.eclipse.xtext.parsetree.reconstr.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.IAbstractToken;

public class WhitespacePreservingTokenSerializer extends SimpleTokenSerializer {

	private List<LeafNode> allLeafs = null;

	private int lastLeaf = -1;

	public void serialize(IAbstractToken firstToken, OutputStream out)
			throws IOException {
		beginSerialize();
		super.serialize(firstToken, out);
		endSerialize();
	}

	protected void beforeElement(IInstanceDescription curr, AbstractElement ele)
			throws IOException {
		int i = lastLeaf, last = findLeafNodeFor(curr, ele);
		if (last < 0)
			defaultSpacing(curr, ele);
		else
			while (++i < last) {
				LeafNode n = allLeafs.get(i);
				if (n.isHidden())
					append(n.getText());
			}
	}

	public void beginSerialize() {
		lastLeaf = -1;
		allLeafs = null;
	}

	protected void defaultSpacing(IInstanceDescription curr, AbstractElement ele)
			throws IOException {
		if (outputHasStarted)
			append(" ");
	}

	public void endSerialize() throws IOException {
		if (allLeafs != null)
			for (int i = lastLeaf + 1; i < allLeafs.size(); i++) {
				LeafNode n = allLeafs.get(i);
				if (n.isHidden())
					append(n.getText());
			}
	}

	protected int findLeafNodeFor(IInstanceDescription curr, AbstractElement ele) {
		NodeAdapter currAdapter = NodeUtil.getNodeAdapter(curr.getDelegate());
		if (currAdapter == null)
			return -1;

		if (allLeafs == null)
			allLeafs = ((CompositeNode) EcoreUtil.getRootContainer(currAdapter
					.getParserNode())).getLeafNodes();

		for (int i = lastLeaf + 1; i < allLeafs.size(); i++)
			if (nodeMatches(curr, ele, allLeafs.get(i)))
				return lastLeaf = i;

		return -1;
	}

	protected boolean nodeMatches(IInstanceDescription curr,
			AbstractElement ele, LeafNode leaf) {
		if (leaf.getGrammarElement() != ele)
			return false;
		if (ele instanceof Assignment) {
			Assignment a = (Assignment) ele;
			if (a.getFeature() != leaf.getFeature())
				return false;
		}
		return true;
	}

}
