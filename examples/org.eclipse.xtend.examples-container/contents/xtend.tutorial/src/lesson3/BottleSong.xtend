package lesson3

import static extension lesson3.BottleSupport.*
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
