/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(Suite.class)
@SuiteClasses({
	ContentAssistTest.class,
	ContentAssistInElseBlockTest.class,
	ContentAssistInLambdaTest.class,
	ContentAssistInLambda2Test.class,
	ImplementSuperMemberAssistTest.class,
	ImportingTypesProposalTests.class,
	ContentAssistPrioritiesTest.class,
	Bug348446Test.class,
	Bug364966Test.class,
	Bug365368Test.class,
	Bug370955Test.class,
	Bug402876Test.class,
	Bug434709Test.class,
	Bug435043Test.class,
	Bug435184Test.class,
	Bug436564Test.class,
	Bug437678Test.class,
	Bug439019Test.class,
	Bug440069Test.class,
	Bug440951Test.class,
	Bug443025Test.class,
	Bug448017Test.class,
	Bug450911Test.class,
	Bug453271Test.class,
	Bug458611Test.class,
	Bug461923Test.class,
	MemberFeatureCallProposalsTest.class
})
public class ContentAssistSuite {
}
