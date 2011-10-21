package xtend.tutorial.basics

import junit.framework.Assert
import junit.framework.TestCase
import xtend.tutorial.util.NetNode

/**
 * Create functions are used to transform object graphs to new object 
 * graphs. The function is only exectued once and the cached result is 
 * returned in each subsequent call with the same argument.  
 *  
 * This solves two common M2M transformation problems:
 * - identities are preserved.
 * - cross links can be established in the same pass in which the objects
 *   are transformed.
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
	 * Create a copy of the given NetNode. Initialize the fields lazily.
	 */
	def create result : new NetNode() copyNet(NetNode toCopy) {
		result.name = toCopy.name
		result.references = toCopy.references.map( node | node.copyNet)
	}
}