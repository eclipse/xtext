package org.eclipse.xtend.core.formatting

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator
import org.eclipse.xtext.xbase.lib.Pair

class NodeModelAccess {
		def INode nodeForEObject(EObject obj) {
		NodeModelUtils::findActualNodeFor(obj)
	}
	
	def ILeafNode nodeForKeyword(EObject obj, String kw) {
		val node = NodeModelUtils::findActualNodeFor(obj)
		node.asTreeIterable.findFirst[semanticElement == obj && grammarElement instanceof Keyword && text == kw] as ILeafNode
	}
	
	def INode nodeForFeature(EObject obj, EStructuralFeature feature) {
		NodeModelUtils::findNodesForFeature(obj, feature).head
	}
	
	def Iterable<INode> features(EObject obj, EStructuralFeature feature) {
		NodeModelUtils::findNodesForFeature(obj, feature)
	}
	
	def ILeafNode immediatelyFollowingKeyword(INode node, String kw) {
		var current = node
		while(current instanceof ICompositeNode) 
			current = (current as ICompositeNode).lastChild
		val current1 = current
		val result = current1.findNextLeaf[current1 != it && grammarElement instanceof Keyword]
		if(result != null && result.text == kw) result
	}
	
	def Pair<Integer, Integer> getRangeBefore(INode node) {
		val start = node.findNextLeaf[!hidden]
		val previous = start.findPreviousLeaf
		if(previous.hidden)
			previous.offset -> previous.length
		else  
			start.offset -> 0
	}
	
	def whitespaceBefore(INode node) {
		val start = node.findNextLeaf[!hidden]
		val previous = start.findPreviousLeaf
		if(previous.hidden) 
			previous
	}
	
	def Pair<Integer, Integer> getRangeAfter(INode node) {
		val start = node.findPreviousLeaf[!hidden]
		val next = start.findNextLeaf
		if(next != null) {
			if(next.hidden) 
				next.offset -> next.length
			else  
				start.offset + start.length -> 0
		}
	}
	
	
	def protected ILeafNode findNextLeaf(INode node, (ILeafNode) => boolean matches) {
		if(node != null) {
			if(node instanceof ILeafNode && matches.apply(node as ILeafNode))
				return node as ILeafNode
			val ni = new NodeIterator(node)
			while(ni.hasNext) {
				val next = ni.next
				if(next instanceof ILeafNode && matches.apply(next as ILeafNode))
					return next as ILeafNode
			}
		}
	}
	
	def protected ILeafNode findNextLeaf(INode node) {
		val ni = new NodeIterator(node)
		while(ni.hasNext) {
			val next = ni.next
			if(next instanceof ILeafNode)
				return next as ILeafNode
		}
	}
	
	def protected ILeafNode findPreviousLeaf(INode node, (ILeafNode) => boolean matches) {
		var current = node
		while(current instanceof ICompositeNode)
			current = (current as ICompositeNode).lastChild
		if(current instanceof ILeafNode && matches.apply(current as ILeafNode))
			return current as ILeafNode
		val ni = new NodeIterator(current)
		while(ni.hasPrevious) {
			val previous = ni.previous
			if(previous instanceof ILeafNode && matches.apply(previous as ILeafNode))
				return previous as ILeafNode
		}
	}
	
	def protected ILeafNode findPreviousLeaf(INode node) {
		var current = node
		while(current instanceof ICompositeNode)
			current = (current as ICompositeNode).lastChild
		val ni = new NodeIterator(current)
		while(ni.hasPrevious) {
			val previous = ni.previous
			if(previous != current && previous instanceof ILeafNode)
				return previous as ILeafNode
		}
	}
}