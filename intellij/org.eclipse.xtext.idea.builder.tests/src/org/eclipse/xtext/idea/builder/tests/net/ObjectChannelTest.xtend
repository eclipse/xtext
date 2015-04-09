/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.builder.tests.net

import java.nio.channels.Pipe
import org.eclipse.xtext.idea.build.net.ObjectChannel
import org.eclipse.xtext.idea.build.net.Protocol.BuildRequestMessage
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.xtext.idea.build.net.Protocol.BuildIssueMessage
import org.eclipse.xtext.idea.build.net.Protocol.BuildResultMessage
import org.jetbrains.jps.incremental.messages.BuildMessage

/**
 * @author Jan Koehnlein
 */
class ObjectChannelTest {
	
	ObjectChannel alice
	ObjectChannel bob
	
	@Before
	def void setUp() {
		val alice2Bob = Pipe.open
		val bob2Alice = Pipe.open
		alice = new ObjectChannel(bob2Alice.source, alice2Bob.sink)
		bob = new ObjectChannel(alice2Bob.source, bob2Alice.sink)
	}
	
	@After
	def void tearDown() {
		alice?.close
		bob?.close
	}
	
	@Test
	def void testReadWriteString() {
		alice.writeObject('Hi Bob')
		val messageFromAlice = bob.readObject
		assertTrue(messageFromAlice instanceof String)
		assertEquals('Hi Bob', messageFromAlice)
		bob.writeObject('Hi Alice')
		val messageFromBob = alice.readObject
		assertTrue(messageFromBob instanceof String)
		assertEquals('Hi Alice', messageFromBob)
	}

	@Test
	def void testReadWriteTooBig() {
		var message = 'x'
		while(message.length < ObjectChannel.BUFFER_SIZE)
			message = message + message
		val messageWritten = message;
		(new Thread [
			alice.writeObject(messageWritten)
		]).start
		val messageRead = bob.readObject()
		assertEquals(messageWritten, messageRead)
	}
	
	@Test
	def void testProtocol() {
		val request = new BuildRequestMessage => [
					dirtyFiles += 'dirty.txt'
					deletedFiles += 'deleted.txt'
					classpath += 'foo.jar'
					sourceRoots += 'src'
					baseDir = 'bar'
					encoding = 'UTF-8'
				]
		alice.writeObject(request)
		assertEquals(request, bob.readObject)
		val issue = new BuildIssueMessage => [
			kind = BuildMessage.Kind.ERROR
			message = 'So ja nu nich!'
			path = 'foo'
			startOffset = 42
			endOffset = 43
			locationOffset = 42
			line = 2
			column = 21
		]
		bob.writeObject(issue)
		assertEquals(issue, alice.readObject)
		val result = new BuildResultMessage => [
			dirtyFiles += 'foo.txt'
			deletedFiles += 'deleted.txt'
			outputDirs += 'bin' 
		]
		bob.writeObject(result)
		assertEquals(result, alice.readObject)
	}
}