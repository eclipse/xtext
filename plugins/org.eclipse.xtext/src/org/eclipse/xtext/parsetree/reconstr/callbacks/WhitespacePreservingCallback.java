package org.eclipse.xtext.parsetree.reconstr.callbacks;

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

public class WhitespacePreservingCallback extends SimpleSerializingCallback {

	private List<LeafNode> allLeafs = null;

	private int lastLeaf = -1;


	protected void before(IInstanceDescription curr, AbstractElement ele) {
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

	public void beginSerialize(OutputStream output) {
		super.beginSerialize(output);
		lastLeaf = -1;
		allLeafs = null;
	}

	protected void defaultSpacing(IInstanceDescription curr, AbstractElement ele) {
		if (outputHasStarted)
			append(" ");
	}

	public void endSerialize() {
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
