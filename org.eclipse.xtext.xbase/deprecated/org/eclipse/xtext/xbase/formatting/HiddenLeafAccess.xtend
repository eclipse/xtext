package org.eclipse.xtext.xbase.formatting

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator

/**
 * @deprecated use {@link ITextRegionAccess}
 */
@Deprecated class HiddenLeafAccess {
	
	@Inject extension NodeModelAccess
	
	def HiddenLeafs getHiddenLeafsBefore(INode node) {
		val start = node.findNextLeaf[!hidden]
		val nodes = start.findPreviousHiddenLeafs
		if(start !== null)
			newHiddenLeafs(if(nodes.empty) start.offset else nodes.head.offset, nodes)
		else 
			new HiddenLeafs(node?.offset)
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
					else if(!Character.isWhitespace(c))
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
			result.leafs += new WhitespaceInfo(result, null, 0, if(result.leafs.empty) offset else result.leafs.last.node.endOffset)
		result
	}
	
	def HiddenLeafs getHiddenLeafsAfter(INode node) {
		val start = node.findPreviousLeaf[!hidden]
		if(start !== null)
			newHiddenLeafs(start.endOffset, start.findNextHiddenLeafs)
		else 
			new HiddenLeafs(node?.offset)
	}
	
	def protected List<ILeafNode> findNextHiddenLeafs(INode node) {
		val result = <ILeafNode>newArrayList()
		val ni = new NodeIterator(node)
		while(ni.hasNext) {
			val next = ni.next
			if(next instanceof ILeafNode) { 
				if (next.hidden)
					result += next
				else //if(!result.empty)
					return result
			}
		}
		result
	}
	
	def protected ILeafNode findPreviousLeaf(INode node, (ILeafNode) => boolean matches) {
		var current = node
		while(current instanceof ICompositeNode)
			current = current.lastChild
		if(current instanceof ILeafNode && matches.apply(current as ILeafNode))
			return current as ILeafNode
		if(current !== null) {
			val ni = new NodeIterator(current)
			while(ni.hasPrevious) {
				val previous = ni.previous
				if(previous instanceof ILeafNode && matches.apply(previous as ILeafNode))
					return previous as ILeafNode
			}
		}
		return null
	}
	
	def protected List<ILeafNode> findPreviousHiddenLeafs(INode node) {
		var current = node
		while(current instanceof ICompositeNode)
			current = current.lastChild
		val result = <ILeafNode>newArrayList
		if(current !== null) {
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
		}
		result.reverse
	}
	
}
