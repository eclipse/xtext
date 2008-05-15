package org.eclipse.xtext.core.parsetree.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.core.parsetree.AbstractNode;
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
		int classifierID = abstractParserNode.eClass().getClassifierID();
		if(classifierID != ParsetreePackage.COMPOSITE_NODE
				&& classifierID != ParsetreePackage.LEAF_NODE) {
			throw new IllegalArgumentException(
					"Illegal subtype of AbstarctParserNode "
							+ abstractParserNode.eClass().getName());
		}
		int offset = 0;
		EList<AbstractNode> siblings = abstractParserNode.getParent()
				.getChildren();
		int indexOf = siblings.indexOf(abstractParserNode);
		for (int i = 0; i < indexOf; ++i) {
			offset += siblings.get(i).length();
		}
		return offset;
	}

	public static int line(CompositeNodeImpl leafNodeImpl) {
		// TODO implement as soon as whitespaces are in node model
		return 0;
	}

	public static int line(LeafNodeImpl leafNodeImpl) {
		// TODO implement as soon as whitespaces are in node model
		return 0;
	}

	public static int line(AbstractNodeImpl abstractParserNode) {
		throw new IllegalArgumentException(
				"Illegal subtype of AbstarctParserNode "
						+ abstractParserNode.eClass().getName());
	}

	public static String serialize(CompositeNodeImpl compositeNodeImpl) {
		StringBuffer buff = new StringBuffer();
		for (AbstractNode child : compositeNodeImpl.getChildren()) {
			buff.append(child.serialize());
		}
		return buff.toString();
	}

	public static String serialize(LeafNodeImpl leafNodeImpl) {
		return leafNodeImpl.getText();
	}

	public static String serialize(AbstractNodeImpl abstractNodeImpl) {
		throw new IllegalArgumentException(
				"Illegal subtype of AbstarctParserNode "
						+ abstractNodeImpl.eClass().getName());
	}

}
