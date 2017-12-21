package org.eclipse.xtend.lib.annotations

import org.junit.Test
import org.junit.Assert
import org.eclipse.xtend2.lib.StringConcatenation

class DataTest {
	
	@Test def void testData() {
		Assert.assertEquals(toUnix('''
			MyDataClass [
			  arg = "foo"
			  foo = false
			]'''), new MyDataClass("foo").toString)
	}
	
	@Data static class MyDataClass {
		String arg
		boolean foo = false
	} 

	def static String toUnix(String s) {
		var StringConcatenation result = new StringConcatenation("\n")
		result.append(s)
		return result.toString()
	}
}