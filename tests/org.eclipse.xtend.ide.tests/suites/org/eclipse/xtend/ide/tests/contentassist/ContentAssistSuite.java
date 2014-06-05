/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	ContentAssistInLambdaTest2.class,
	ImplementSuperMemberAssistTest.class,
	ImportingTypesProposalTests.class,
	ContentAssistPrioritiesTest.class,
	Bug348446Test.class,
	Bug364966Test.class,
	Bug365368Test.class,
	Bug402876Test.class,
	Bug434709Test.class,
	Bug435043Test.class,
	Bug435184Test.class,
	Bug436564Test.class,
	MemberFeatureCallProposalsTest.class
})
public class ContentAssistSuite {
}
