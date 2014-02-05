package org.eclipse.xtext.xbase.formatting


import com.google.inject.Inject
import org.eclipse.xtext.nodemodel.INode
import java.util.List
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator
import org.eclipse.xtext.nodemodel.ICompositeNode

class HiddenLeafAccess {
	
	@Inject extension NodeModelAccess
	
	def HiddenLeafs getHiddenLeafsBefore(INode node) {
		val start = node.findNextLeaf[!hidden]
		val nodes = start.findPreviousHiddenLeafs
		if(start != null)
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
		if(start != null)
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
		if(current != null) {
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
		if(current != null) {
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


@Data class HiddenLeafs {
	int offset
	List<LeafInfo> leafs = newArrayList
	
	def boolean isSingleWhitespace() {
		leafs.empty || (leafs.size == 1 && leafs.head instanceof WhitespaceInfo)
	}
	
	def int getLenght() {
		leafs.fold(0, [x, i | x + i.node?.length])
	}
	
	def int getNewLines() {
		leafs.fold(0, [x, i | x + i.newLines])
	}
	
	def int getNewLinesInComments() {
		leafs.filter(CommentInfo).fold(0, [x, i | x + i.newLines])
	}

	def containsComment(){
		leafs.filter(CommentInfo).size > 0
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
	boolean trailing // true if this comment is in the first line of its HiddenLeafs
	
	def endsWithNewLine() {
		node.text.endsWith("\n")
	}
	
	def isMultiline() {
		!endsWithNewLine && node.text.contains("\n")
	}
	
	override toString() '''
		Comment: "«node.text»"
	'''
}