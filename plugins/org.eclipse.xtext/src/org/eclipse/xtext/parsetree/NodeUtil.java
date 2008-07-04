/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class NodeUtil {
	
    public static NodeAdapter getNodeAdapter(EObject obj) {
        return (NodeAdapter) EcoreUtil.getAdapter(obj.eAdapters(), AbstractNode.class);
    }

    protected static boolean removeNodeAdapter(EObject obj) {
        NodeAdapter adapter = getNodeAdapter(obj);
        if (adapter == null)
            return false;
        while (adapter != null) {
            adapter.getParserNode().setParent(null);
            adapter = getNodeAdapter(obj);
        }
        return true;
    }

    public static CompositeNode getRootNode(EObject obj) {
        NodeAdapter adapter = getNodeAdapter(obj);
        if (adapter == null)
            return null;
        CompositeNode parserNode = adapter.getParserNode();
        if (parserNode == null)
            return null;
        return (CompositeNode) EcoreUtil.getRootContainer(parserNode);
    }

    public static List<CompositeNode> getCompositeChildren(CompositeNode parent) {
        List<CompositeNode> compositeChildren = new ArrayList<CompositeNode>();
        for (AbstractNode node : parent.getChildren()) {
            if (node instanceof CompositeNode) {
                compositeChildren.add((CompositeNode) node);
            }
        }
        return compositeChildren;
    }
    
    public static EObject getASTElementForRootNode(CompositeNode compositeNode) {
    	if(compositeNode.getElement() != null) {
    		return compositeNode.getElement();
    	}
    	WHILE: while (!compositeNode.getChildren().isEmpty()) {
			boolean foundCompositeChild = false;
			for (AbstractNode child : compositeNode.getChildren()) {
				if (child instanceof CompositeNode) {
					if (foundCompositeChild) {
						throw new IllegalStateException(
								"Corrupt node model: Composite node without element has multiple composite children");
					}
					foundCompositeChild = true;
					CompositeNode childComposite = (CompositeNode) child;
					if (childComposite.getElement() != null) {
						return childComposite.getElement();
					}
					else {
						compositeNode = childComposite;
						continue WHILE;
					}
				}
			}
			return null;
		}
    	return null;
    }
    
    public static EObject findASTParentElement(CompositeNode replaceRootNode) {
		CompositeNode parent = replaceRootNode.getParent();
		if (parent == null) {
			return null;
		}
		if (parent.getElement() != null) {
			return parent.getElement();
		}
		return findASTParentElement(parent);
	}

    public static void dumpCompositeNodes(String indent, CompositeNode node) {
        dumpCompositeNodeInfo(indent, node);
        for (AbstractNode childNode : node.getChildren()) {
            if (childNode instanceof CompositeNode) {
                CompositeNode compositeNode = (CompositeNode) childNode;
                dumpCompositeNodes(indent + "  ", compositeNode);
            }
        }
    }

    public static void dumpCompositeNodeInfo(String indent, CompositeNode node) {
        EObject grammarElement = node.getGrammarElement();
        String name;
        try {
            name = grammarElement.getClass().getMethod("getName").invoke(grammarElement).toString();
        } catch (Exception exc) {
            name = grammarElement.getClass().getSimpleName();
        }
        String astElementAsString = (node.getElement() == null) ? "null" : node.getElement().eClass().getName();
        System.out.print(indent + name + " : " + node.serialize()
                + " -> " + astElementAsString + "  la={ ");
        for (LeafNode lookaheadNode : node.getLookaheadLeafNodes()) {
        	System.out.print("\""+ lookaheadNode.getText() +"\" ");
		}
        System.out.print(" (" + node.getOffset() + ", " + node.getLength() + ")");
        System.out.println("}");
    }
    
}
