package org.eclipse.xtext.idea.sdomain.idea.tests.containers

import org.eclipse.xtext.idea.tests.LightToolingTest
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType

abstract class LightSdomainTestCase extends LightToolingTest {
	
	new() {
		super(SDomainFileType.INSTANCE)
	}
	
}