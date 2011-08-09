package xtend.tutorial.basics

import junit.framework.Assert
import junit.framework.TestCase
import xtend.tutorial.util.NetNode

/**
 * create functions are used to transform object graphs to nw object graphs in jsut one pass 
 * instead of the usual two pass was, where you first create a tree and then establish cross links.
 * 
 * It solves the m2m transformation problem.
 */
class Xtend10_CreateFunctions extends TestCase {
	
	def void testCreateFunctions() {
		val nodeA = new NetNode()
		nodeA.name = "A"
		val nodeB = new NetNode()
		nodeB.name = "B"
		val nodeC = new NetNode()
		nodeC.name = "C"
		val nodeD = new NetNode()
		nodeD.name = "D"
		
		nodeA.references = newArrayList(nodeD,nodeC)
		nodeB.references = newArrayList(nodeA,nodeB)
		nodeC.references = newArrayList(nodeA,nodeB, nodeD)
		nodeD.references = newArrayList(nodeB,nodeC)
		
		val copyOfNodeA = copyNet(nodeA)
		val copyOfNodeB = copyNet(nodeB)
		Assert::assertNotSame(nodeA, copyOfNodeA)
		Assert::assertSame(copyOfNodeB.references.head, copyOfNodeA)		
		Assert::assertSame(copyOfNodeB.references.tail.head, copyOfNodeB)		
	}
	
	/**
	 * create a copy of the given NetNode
	 * initializes the fields lazily
	 */
	def create result : new NetNode() copyNet(NetNode toCopy) {
		result.name = toCopy.name
		result.references = toCopy.references.map( node | node.copyNet)
	}
}