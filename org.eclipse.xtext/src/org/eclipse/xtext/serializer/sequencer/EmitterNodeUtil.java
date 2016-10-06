/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EmitterNodeUtil {

	private static boolean isEmitter(INode node, EObject grammarElement) {
		if (node instanceof ILeafNode) {
			ILeafNode leaf = (ILeafNode) node;
			if (leaf.isHidden())
				return false;
			return true;
		} else if (node instanceof ICompositeNode) {
			return GrammarUtil.isDatatypeRuleCall(grammarElement) || grammarElement instanceof CrossReference;
		}
		return false;
	}

	private static boolean isAbsorber(EObject grammarElement) {
		return grammarElement != null && GrammarUtil.isAssigned(grammarElement);
	}

	public static List<INode> collectEmitterNodes(INode from, INode to) {
		if (from == null) {
			return Collections.emptyList();
		}
		TreeIterator<INode> iterator;
		if (from == to) {
			iterator = from.getAsTreeIterable().iterator();
			iterator.next();
		} else {
			iterator = new NodeIterator(from);
		}
		List<INode> result = null;
		while (iterator.hasNext()) {
			INode next = iterator.next();
			if (next == to)
				break;
			EObject grammarElement = next.getGrammarElement();
			if (isEmitter(next, grammarElement)) {
				if (isAbsorber(grammarElement))
					break;
				iterator.prune();
				if (result == null) {
					result = Lists.newArrayList();
				}
				result.add(next);
			}
		}
		if (result == null) {
			return Collections.emptyList();
		}
		return result;
	}

}
