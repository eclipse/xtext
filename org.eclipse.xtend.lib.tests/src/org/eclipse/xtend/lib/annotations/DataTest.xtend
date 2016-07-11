package org.eclipse.xtend.lib.annotations

import org.junit.Test
import org.junit.Assert

class DataTest {
	
	@Test def void testData() {
		Assert.assertEquals('''
			MyDataClass [
			  arg = "foo"
			  foo = false
			]'''.toString, new MyDataClass("foo").toString)
	}
	
	@Data static class MyDataClass {
		String arg
		boolean foo = false
	} 
}