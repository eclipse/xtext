/*******************************************************************************
 * Copyright (c) 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring

import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.ltk.core.refactoring.resource.RenameResourceDescriptor
import org.junit.ComparisonFailure
import org.junit.Test

import static org.junit.Assert.*

import static extension org.eclipse.xtext.util.Strings.*

/**
 * @author Christian Schneider - Initial contribution and API
 */
class ProgressReportingTest extends AbstractResourceRelocationTest {
	@Test 
	def void testProgressReportOfRenameCommonDir() {
		val x = file('foo/X.fileawaretestlanguage', '''
			package foo.bar
			element X {
				ref X
			}
		''')	
		val y = file('foo/Y.fileawaretestlanguage', '''
			package foo
			element Y {
				ref bar.X
			}
		''')
		
		val monitor = new TestProgressMonitor()
		performRename(x.parent, 'baz', monitor)
		assertFalse(x.exists)
		assertFalse(y.exists)
		monitor.assertLogged('''
			BeginTask (44)
			SetTaskName Checking preconditions...
			InternalWorked 4.0 (4.0)
			SetTaskName Checking preconditions...
			InternalWorked 22.22222222222222 (26.22222222222222)
			SetTaskName Preparing the refactoring...
			InternalWorked 1.777777777777778 (28.0)«               /* 1/5 of the work logged in 'ResourceRelocationProcessor, remaining: 7.111111 (4/5)*/»
			SetTaskName Preparing and applying file changes...«    /* 8/17 of 7.111111 == 3,3464... */»
			InternalWorked 0.8355555555555556 (28.835555555555555)«/* 2/17 on preparing first resource */»
			InternalWorked 0.8355555555555556 (29.67111111111111)« /* 2/17 on preparing second resource */»
			InternalWorked 0.4177777777777778 (30.08888888888889)« /* 1/17 on first modification */»
			InternalWorked 0.4177777777777778 (30.506666666666668)«/* 1/17 on second modification */»
			InternalWorked 0.4177777777777778 (30.924444444444447)«/* 1/17 on third modification */»
			InternalWorked 0.4177777777777778 (31.342222222222226)«/* 1/17 on fourth modification */»
			SetTaskName Creating text changes...«                  /* 9/17 of 7.111111 == 3,7647... */»
			InternalWorked 2.088888888888889 (33.431111111111115)« /* 5/17 on determining related resources (fixed enumerator) */
			                                                       /* setWorkRemaining(2), was 4, causes some initial fraction in 'usedForChildren' (0.00...) */»
			InternalWorked 0.8444444444444444 (34.275555555555556)«/* ca. 2/17 on creating changes for first resource */»
			InternalWorked 0.8355555555555556 (35.111111111111114)«/* ca. 2/17 on creating changes for first resource, differs due to rounding differences and the fraction from above */»
			InternalWorked 2.2222222222222223 (37.333333333333336)«/* final condition validations in ProcessorBasedRefactoring#checkFinalConditions(IPM) */»
			InternalWorked 6.666666666666664 (44.0)«               /* finalization of primary monitor in ProcessorBasedRefactoring#checkFinalConditions(IPM) */»
			Done
		''')
	}
	
	protected def performRename(IResource theResource, String theNewName, IProgressMonitor monitor) {
		performRefactoring(new RenameResourceDescriptor() => [
			resourcePath = theResource.fullPath
			newName = theNewName
			project = project.name
		], monitor)
	}
	
	static class TestProgressMonitor extends NullProgressMonitor {
		
		val events = <String>newArrayList()
		var double accumulatedWork = 0.0d
		
		override worked(int work) {
			accumulatedWork += work
			events += 'Worked ' + work + ' (' + accumulatedWork + ')'
		}
		
		override internalWorked(double work) {
			accumulatedWork += work
			events += 'InternalWorked ' + work + ' (' + accumulatedWork + ')'
		}
		
		override beginTask(String name, int totalWork) {
			events += 'BeginTask ' + name + (if (name.nullOrEmpty) '(' else ' (') + totalWork + ')'
		}
		
		override subTask(String name) {
			events += 'SubTask ' + name
		}
		
		override setTaskName(String name) {
			events += 'SetTaskName ' + name
		}
		
		override done() {
			events += 'Done'
		}
		
		override setCanceled(boolean value) {
			super.setCanceled(value)
			events += 'Canceled'
		}
		
		def assertLogged(String expectation) {
			val eventsDump = events.join('\n')
			if (!eventsDump.startsWith(expectation.toUnixLineSeparator))
				throw new ComparisonFailure('', expectation.toUnixLineSeparator, eventsDump)
		}
	}
}