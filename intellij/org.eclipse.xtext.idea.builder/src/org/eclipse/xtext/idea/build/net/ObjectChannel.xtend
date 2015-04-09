/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.net

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable
import java.nio.ByteBuffer
import java.nio.channels.SocketChannel

import static java.lang.Math.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class ObjectChannel {
	
	static val BUFFER_SIZE=32768
	ByteBuffer inputBuffer = ByteBuffer.allocate(BUFFER_SIZE)
	ByteBuffer outputBuffer = ByteBuffer.allocate(BUFFER_SIZE)
	
	SocketChannel channel
	
	new(SocketChannel channel) {
		this.channel = channel
		channel.configureBlocking(true)
		inputBuffer.flip
	}
	
	def writeObject(Serializable o) {
		outputBuffer.clear
		val baos = new ByteArrayOutputStream()
		val oos = new ObjectOutputStream(baos)
		try {
			oos.writeObject(o)
			val bytes = baos.toByteArray
			outputBuffer.putInt(bytes.length)
			var offset = 0
			while(bytes.length - offset > 0) {
				var numBytes = min(outputBuffer.remaining, bytes.length-offset)
				outputBuffer.put(bytes, offset, numBytes)
				outputBuffer.flip
				channel.write(outputBuffer)
				outputBuffer.clear
				offset += numBytes
			} 
		} finally {
			oos.close
		}
	}
	
	def Serializable readObject() {
		val length = ByteBuffer.wrap(readByteArray(4)).getInt(0)
		val ois = new ObjectInputStream(new ByteArrayInputStream(readByteArray(length)))
		try {
			return ois.readObject as Serializable
		} finally {
			ois.close
		}
	}
	
	protected def readByteArray(int numBytes) {
		val result = newByteArrayOfSize(numBytes)
		var offset = 0
		while(offset < numBytes) {
			if(inputBuffer.remaining > 0) {
				val availableBytes = min(numBytes - offset, inputBuffer.remaining)
				inputBuffer.get(result, offset, availableBytes)
				offset += availableBytes
			} else {
				inputBuffer.clear
				channel.read(inputBuffer)
				inputBuffer.flip			
			}
		}
		result
	}
}