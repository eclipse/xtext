package org.eclipse.xtext.parsetree.reconstr.callbacks;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;

public class WhitespacePreservingCallback extends SimpleSerializingCallback {

	private Map<CompositeNode, Map<AbstractElement, Integer>> numberOfOccurences = new HashMap<CompositeNode, Map<AbstractElement, Integer>>();

	public WhitespacePreservingCallback(IValueConverterService converterService) {
		super(converterService);
	}

	private Integer getOccurencesAndIncrease(CompositeNode node, AbstractElement ele) {
		Map<AbstractElement, Integer> map = null;
		if (numberOfOccurences.containsKey(node)) {
			map = numberOfOccurences.get(node);
		}
		if (map == null)
			map = new HashMap<AbstractElement, Integer>();
		Integer n = 0;
		if (map.containsKey(ele)) {
			n = map.get(ele);
		}
		// increase
		n++;
		map.put(ele, n);
		numberOfOccurences.put(node, map);
		return n - 1;
	}

	@Override
	public void parserRuleCallStart(IInstanceDescription current, RuleCall call) {
		super.parserRuleCallStart(current, call);
		if (getBuff().length() == 0) {
			CompositeNode rootNode = getEntryNode(current);
			if (rootNode != null) {
				EList<LeafNode> list = rootNode.getLeafNodes();
				for (int x = list.size() - 1; x >= 0; x--) {
					LeafNode ln = list.get(x);
					if (!ln.isHidden())
						return;
					prepend(ln.getText());
				}
			}
		}
	}

	@Override
	protected void before(IInstanceDescription desc, AbstractElement element) {
		CompositeNode rootNode = getEntryNode(desc);
		if (rootNode != null)
			iterateChldren(element, rootNode);
	}

	private CompositeNode getEntryNode(IInstanceDescription desc) {
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(desc.getDelegate());
		if (nodeAdapter == null)
			return null;
		CompositeNode rootNode = nodeAdapter.getParserNode();
		// go up normalizable rulecalls
		while (rootNode.getParent() != null && rootNode.getParent().getElement() == null)
			rootNode = rootNode.getParent();
		return rootNode;
	}

	private void iterateChldren(AbstractElement element, CompositeNode rootNode) {
		EList<AbstractNode> leafNodes = rootNode.getChildren();
		boolean consumingMode = false;
		int skip = getOccurencesAndIncrease(rootNode, element);
		for (int x = leafNodes.size() - 1; x >= 0; x--) {
			AbstractNode an = leafNodes.get(x);
			if (an instanceof LeafNode) {
				LeafNode n = (LeafNode) an;
				if (consumingMode) {
					if (!n.isHidden())
						return;
					prepend(n.getText());
				}
				if (n.getGrammarElement() == element) {
					if (skip == 0) {
						consumingMode = true;
					} else {
						skip--;
					}
				}
			} else if (an instanceof CompositeNode) {
				CompositeNode cn = (CompositeNode) an;
				if (rootNode.getElement() == null) {
					iterateChldren(element, cn);
				}
			}
			// if (n.getGrammarElement() == element)
			// log.info(debugInfo(n.getGrammarElement()));
		}
	}

}
