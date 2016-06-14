/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.linking

import javax.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class LinkingBug421744Test extends AbstractXtendTestCase {
	
	@Inject ValidationTestHelper testHelper
	
	@Test def testTheBug() {
		val file = file('''
			package notification
			
			import java.util.List
			import static notification.NotificationType.*
			import notification.NotificationTester
			
			class Tester {

				def void volume() {
					NotificationTester.observeUnexpected([|getVolume_Key()], CHANGED)
				}
			}
			
			class NotificationTester {
			
				def static void observeUnexpected(Object x, NotificationType type, (List<String>)=>void observer) {
				}
			}
			
			enum NotificationType {
				CHANGED,
				DELETED
			}
		''', false)
		testHelper.assertError(file, XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INVALID_NUMBER_OF_ARGUMENTS,'observeUnexpected')
	}
}