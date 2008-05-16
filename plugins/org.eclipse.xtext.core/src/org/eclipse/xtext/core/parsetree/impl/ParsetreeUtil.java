package org.eclipse.xtext.core.parsetree.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.core.parsetree.LeafNode;
import org.eclipse.xtext.core.parsetree.ParsetreePackage;

public class ParsetreeUtil {

	public static int length(CompositeNodeImpl compositeNodeImpl) {
		int length = 0;
		for (AbstractNode node : compositeNodeImpl.getChildren()) {
			length += node.length();
		}
		return length;
	}

	public static int length(LeafNodeImpl leafNodeImpl) {
		return leafNodeImpl.getText().length();
	}

	public static int length(AbstractNodeImpl abstractParserNode) {
		throw new IllegalArgumentException(
				"Illegal subtype of AbstarctParserNode "
						+ abstractParserNode.eClass().getName());
	}

	public static int offset(AbstractNodeImpl abstractParserNode) {
		checkArgument(abstractParserNode);
		AbstractNode rootContainer = (AbstractNode) EcoreUtil.getRootContainer(abstractParserNode);
		EList<LeafNode> leafNodes = rootContainer.getLeafNodes(abstractParserNode);
		int offset = 0;
		for (LeafNode leafNode : leafNodes) {
			offset+=leafNode.length();
		}
		return offset;
	}

	private static void checkArgument(AbstractNodeImpl abstractParserNode) {
		int classifierID = abstractParserNode.eClass().getClassifierID();
		if(classifierID != ParsetreePackage.COMPOSITE_NODE
				&& classifierID != ParsetreePackage.LEAF_NODE) {
			throw new IllegalArgumentException(
					"Illegal subtype of AbstarctParserNode "
							+ abstractParserNode.eClass().getName());
		}
	}

	public static int line(AbstractNodeImpl _this) {
		checkArgument(_this);
		AbstractNode rootContainer = (AbstractNode) EcoreUtil.getRootContainer(_this);
		EList<LeafNode> leafNodes = rootContainer.getLeafNodes(_this);
		int line = 0;
		for (LeafNode leafNode : leafNodes) {
			String text = leafNode.getText();
			char[] charArray = text.toCharArray();
			for (char c : charArray) {
				//TODO handle os specific newlines
				if (c=='\n' || c=='\r') 
					line++;
			}
		}
		return line;
	}

	public static String serialize(AbstractNodeImpl _this) {
		checkArgument(_this);
		StringBuffer buff = new StringBuffer();
		EList<LeafNode> leafNodes = _this.getLeafNodes();
		for (LeafNode leafNode : leafNodes) {
			buff.append(leafNode.getText());
		}
		return buff.toString();
	}

	public static EList<LeafNode> getLeafNodes(AbstractNodeImpl _this) {
		return getLeafNodes(_this, null);
	}

	public static EList<LeafNode> getLeafNodes(AbstractNodeImpl _this, AbstractNode to) {
		checkArgument(_this);
		BasicEList<LeafNode> result = new BasicEList<LeafNode>();
		TreeIterator<EObject> allContents = _this.eAllContents();
		while (allContents.hasNext()) {
			EObject current = allContents.next();
			if (current.equals(to)) 
				return result;
			if (current instanceof LeafNode) {
				result.add((LeafNode) current);
			}
		}
		return result;
	}

}
