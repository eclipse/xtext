package org.eclipse.xtend.core.formatting

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtend.lib.Data
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator

class NodeModelAccess {
	def INode nodeForEObject(EObject obj) {
		NodeModelUtils::findActualNodeFor(obj)
	}
	
	def ILeafNode nodeForKeyword(EObject obj, String kw) {
		val node = NodeModelUtils::findActualNodeFor(obj)
		node.asTreeIterable.findFirst[semanticElement == obj && grammarElement instanceof Keyword && text == kw] as ILeafNode
	}
	
	def Iterable<ILeafNode> nodesForKeyword(EObject obj, String kw) {
		val node = NodeModelUtils::findActualNodeFor(obj)
		node.asTreeIterable.filter(typeof(ILeafNode)).filter[semanticElement == obj && grammarElement instanceof Keyword && text == kw]
	}
	
	def INode nodeForFeature(EObject obj, EStructuralFeature feature) {
		NodeModelUtils::findNodesForFeature(obj, feature).head
	}
	
	def Iterable<INode> features(EObject obj, EStructuralFeature feature) {
		NodeModelUtils::findNodesForFeature(obj, feature)
	}
	
	def ILeafNode immediatelyFollowingKeyword(EObject obj, String kw) {
		obj.nodeForEObject.immediatelyFollowingKeyword(kw)
	}
	
	def ILeafNode immediatelyFollowingKeyword(INode node, String kw) {
		var current = node
		while(current instanceof ICompositeNode) 
			current = (current as ICompositeNode).lastChild
		val current1 = current
		val result = current1.findNextLeaf[current1 != it && grammarElement instanceof Keyword]
		if(result != null && result.text == kw) result
	}
	
	def HiddenLeafs getHiddenLeafsBefore(INode node) {
		val start = node.findNextLeaf[!hidden]
		val nodes = start.findPreviousHiddenLeafs
		newHiddenLeafs(if(nodes.empty) start.offset else nodes.head.offset, nodes)
	}
	
	def whitespaceBefore(INode node) {
		val start = node.findNextLeaf[!hidden]
		val previous = start.findPreviousLeaf
		if(previous.hidden) 
			previous
	}
	
	def HiddenLeafs getHiddenLeafsAfter(INode node) {
		val start = node.findPreviousLeaf[!hidden]
		newHiddenLeafs(start.offset + start.length, start.findNextHiddenLeafs)
	}
	
	def protected newHiddenLeafs(int offset, List<ILeafNode> nodes) {
		val result = new HiddenLeafs(offset)
		var trailing = true
		for(node:nodes) {
			var comment = false
			var newLines = 0
			if(!node.text.nullOrEmpty) 
				for(i : 0 .. node.text.length - 1) {
					val c = node.text.charAt(i)
					if(c.toString == "\n")
						newLines = newLines + 1
					else if(!Character::isWhitespace(c))
						comment = true
				}
			if(comment) {
				if(!(result.leafs.last instanceof WhitespaceInfo))
					result.leafs += new WhitespaceInfo(result, null, 0, node.offset) 
				result.leafs += new CommentInfo(result, node, newLines, trailing) 	
			} else 
				result.leafs += new WhitespaceInfo(result, node, newLines, node.offset)
			if(newLines > 0)
				trailing = false
		}
		if(!(result.leafs.last instanceof WhitespaceInfo))
			result.leafs += new WhitespaceInfo(result, null, 0, if(result.leafs.empty) offset else result.leafs.last.node.offset + result.leafs.last.node.length)
		result
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
	
	def protected List<ILeafNode> findNextHiddenLeafs(INode node) {
		val result = <ILeafNode>newArrayList()
		val ni = new NodeIterator(node)
		while(ni.hasNext) {
			val next = ni.next
			if(next instanceof ILeafNode) { 
				if ((next as ILeafNode).hidden)
					result += next as ILeafNode
				else //if(!result.empty)
					return result
			}
		}
		result
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
	
	def protected List<ILeafNode> findPreviousHiddenLeafs(INode node) {
		var current = node
		while(current instanceof ICompositeNode)
			current = (current as ICompositeNode).lastChild
		val result = <ILeafNode>newArrayList
		val ni = new NodeIterator(current)
		while(ni.hasPrevious) {
			val previous = ni.previous
			if(previous != current && previous instanceof ILeafNode) {
				if((previous as ILeafNode).hidden)
					result += previous as ILeafNode
				else //if(!result.empty)
					return result.reverse
			}		
		}
		result.reverse
	}
}

@Data class HiddenLeafs {
	int offset
	List<LeafInfo> leafs = newArrayList
	
	def boolean isSingleWhitespace() {
		leafs.empty || (leafs.size == 1 && leafs.head instanceof WhitespaceInfo)
	}
	
	def getLenght() {
		leafs.fold(0, [x, i | x + i.node?.length])
	}
	
	def getNewLines() {
		leafs.fold(0, [x, i | x + i.newLines])
	}
	
	def getNewLinesInComments() {
		leafs.filter(typeof(CommentInfo)).fold(0, [x, i | x + i.newLines])
	}
}

@Data abstract class LeafInfo {
	HiddenLeafs container
	ILeafNode node
	int newLines
}

@Data class WhitespaceInfo extends LeafInfo {
	int offset
	
	def getLength() {
		node?.length
	}
	
	def leadingComment() {
		val i = container.leafs.indexOf(this) - 1
		if(i >= 0) 
			container.leafs.get(i) as CommentInfo
	}
	
	def trailingComment() {
		val i = container.leafs.indexOf(this) + 1
		if(i < container.leafs.size) 
			container.leafs.get(i) as CommentInfo
	}
	
	override toString() '''
		WS: "«node?.text»"
	'''
}

@Data class CommentInfo extends LeafInfo {
	boolean trailing
	
	def endsWithNewLine() {
		node.text.endsWith("\n")
	}
	
	override toString() '''
		Comment: "«node.text»"
	'''
}