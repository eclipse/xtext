package foo

import org.junit.Test
import org.junit.Assert
import foo.FooClass

class FooTest {
	
	@Test
	def assertTrue() {
	    Assert::assertEquals(1,new FooClass().count);
	}
}