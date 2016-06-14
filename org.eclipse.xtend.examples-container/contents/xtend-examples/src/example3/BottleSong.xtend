/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sven Efftinge
 *******************************************************************************/
package example3

import static extension example3.BottleSupport.*
import org.junit.Test

/**
 * Prints the lyrics of the song "99 bottles of beer"
 * See http://99-bottles-of-beer.net/
 * 
 * Uses template expressions and extension methods.
 */
class BottleSong {
	
	@Test def void singIt() {
		println(singTheSong(99))
	}
	
	def singTheSong(int all) '''
		«FOR i : all .. 1»
			«i.Bottles» of beer on the wall, «i.bottles» of beer.
			Take one down and pass it around, «(i - 1).bottles» of beer on the wall.
			
		«ENDFOR»
		No more bottles of beer on the wall, no more bottles of beer.
		Go to the store and buy some more, «all.bottles» of beer on the wall.
	'''

}

class BottleSupport {
	
	def static bottles(int i) {
		switch i {
			case 0 : 'no more bottles'
			case 1 : 'one bottle'
			default : '''«i» bottles'''
		}.toString
	}
	
	def static Bottles(int i) {
		bottles(i).toFirstUpper
	}
}
