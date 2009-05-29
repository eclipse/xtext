/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.ParsetreePackage;
import org.eclipse.xtext.parsetree.SyntaxError;

/**
 * @author koehnlein
 * @author bkolb
 * @author Sebastian Zarnekow
 */
public class ParsetreeUtil {
	
	private static final char[] separator = System.getProperty("line.separator").toCharArray();

	private static void checkArgument(AbstractNodeImpl abstractParserNode) {
		int classifierID = abstractParserNode.eClass().getClassifierID();
		if (classifierID != ParsetreePackage.COMPOSITE_NODE && classifierID != ParsetreePackage.LEAF_NODE) {
			throw new IllegalArgumentException("Illegal subtype of AbstarctParserNode "
					+ abstractParserNode.eClass().getName());
		}
	}

	public static int line(AbstractNodeImpl _this) {
		checkArgument(_this);
		AbstractNode rootContainer = (AbstractNode) EcoreUtil.getRootContainer(_this);
		EList<LeafNode> leafNodes = rootContainer.getLeafNodes(_this);
		int line = 1;
		for (LeafNode leafNode : leafNodes) {
			String text = leafNode.getText();
			line += countLines(text);
		}
		return line;
	}
	
	public static int totalEndLine(AbstractNodeImpl _this) {
		int line = _this.getTotalLine();
		String text = _this.serialize();
		line += countLines(text);
		return line;
	}

	public static int countLines(String text) {
		return countLines(text, separator);
	}
	
	public static int countLines(String text, char[] separator) {
		int line = 0;
		char[] charArray = text.toCharArray();
		if ( separator.length == 1) {
			for (int i = 0; i<charArray.length; i++) {
				if (charArray[i] == separator[0]) {
					line++;
				}
			}
		} else if(separator.length==2){
			for (int i = 0; i<charArray.length; i++) {
				if (charArray[i] == separator[0] && charArray.length>i+1 && charArray[i+1]==separator[1]) {
					line++;
					i++;
				} else if (charArray[i] == separator[1]) {
					line++;
				}
			}
		} else {
			throw new IllegalArgumentException("Separators with more than two characters are unexpected");
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

	public static String serialize(LeafNodeImpl _this) {
		return _this.getText();
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

	public static EList<SyntaxError> allSyntaxErrors(CompositeNodeImpl compositeNodeImpl) {
		BasicEList<SyntaxError> basicEList = new BasicEList<SyntaxError>();
		TreeIterator<Object> iterator = EcoreUtil.getAllContents(compositeNodeImpl, false);
		while(iterator.hasNext()) {
			Object next = iterator.next();
			if (next instanceof SyntaxError)
				basicEList.add((SyntaxError) next);
		}
		return basicEList;
	}

	public static EList<SyntaxError> allSyntaxErrors(LeafNodeImpl leafNodeImpl) {
		BasicEList<SyntaxError> basicEList = new BasicEList<SyntaxError>();
		if (leafNodeImpl.getSyntaxError() != null)
			basicEList.add(leafNodeImpl.getSyntaxError());
		return basicEList;
	}

	public static EList<SyntaxError> allSyntaxErrors(AbstractNodeImpl abstractNodeImpl) {
		return null;
	}

	/**
	 * @param abstractNode
	 * @return
	 */
	public static int getOffset(AbstractNode abstractNode) {
		if (abstractNode instanceof LeafNode)
			return abstractNode.getTotalOffset();
		final CompositeNode node = (CompositeNode) abstractNode;
		for(int i = 0; i < node.getChildren().size(); i++) {
			final AbstractNode child = node.getChildren().get(i);
			if (child instanceof CompositeNode)
				return getOffset(child);
			final LeafNode leaf = (LeafNode) child;
			if (!leaf.isHidden())
				return leaf.getTotalOffset();
		}
		// every child node is a hidden node, return total offset
		return abstractNode.getTotalOffset();
	}

	/**
	 * @param abstractNode
	 * @return
	 */
	public static int getLine(AbstractNode abstractNode) {
		if (abstractNode instanceof LeafNode)
			return abstractNode.getTotalLine();
		final CompositeNode node = (CompositeNode) abstractNode;
		for(int i = 0; i < node.getChildren().size(); i++) {
			final AbstractNode child = node.getChildren().get(i);
			if (child instanceof CompositeNode)
				return getLine(child);
			final LeafNode leaf = (LeafNode) child;
			if (!leaf.isHidden())
				return leaf.getTotalLine();
		}
		// every child node is a hidden node, return total line
		return abstractNode.getTotalLine();
	}

	/**
	 * @param abstractNode
	 * @return
	 */
	public static int getLength(AbstractNode abstractNode) {
		if (abstractNode instanceof LeafNode)
			return abstractNode.getTotalLength();
		final CompositeNode node = (CompositeNode) abstractNode;
		for(int i = node.getChildren().size() - 1; i >= 0 ; i--) {
			final AbstractNode child = node.getChildren().get(i);
			if (child instanceof CompositeNode)
				return child.getOffset() - abstractNode.getOffset() + child.getLength();
			if (!((LeafNode) child).isHidden())
				return child.getTotalOffset() - abstractNode.getOffset() + child.getTotalLength();
		}
		// every child node is a hidden node, return total length
		return abstractNode.getTotalLength();
	}

	/**
	 * @param abstractNode
	 * @return
	 */
	public static int endLine(AbstractNode abstractNode) {
		if (abstractNode instanceof LeafNode)
			return abstractNode.totalEndLine();
		final CompositeNode node = (CompositeNode) abstractNode;
		for(int i = node.getChildren().size() - 1; i >= 0 ; i--) {
			final AbstractNode child = node.getChildren().get(i);
			if (child instanceof CompositeNode)
				return endLine(child);
			if (!((LeafNode) child).isHidden())
				return child.totalEndLine();
		}
		// every child node is a hidden node, return total endLine
		return abstractNode.totalEndLine();
	}

}
