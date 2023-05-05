/*******************************************************************************
 * Copyright (c) 2013, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.linking

import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test
import com.google.inject.Inject

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