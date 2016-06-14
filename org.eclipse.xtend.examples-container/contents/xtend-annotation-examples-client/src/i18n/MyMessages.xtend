package i18n

import java.util.Date

@Externalized
class MyMessages {
	
	val GREETING = "Hello {0}!"
	val DATE_AND_LOCATION = "Today is {0,date} and you are in {1}"
	
	def static void main(String[] args) {
		println('''
			«GREETING("World")»
			«DATE_AND_LOCATION(new Date(), "Kiel")»
		''')
	}
}