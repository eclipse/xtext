/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.typesystem.newImpl;

import org.eclipse.xtend.core.tests.typesystem.AssignabilityTest;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputer;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnitTest extends AssignabilityTest {
	private TypeConformanceComputer conformanceComputer = new TypeConformanceComputer();
	
	@Override
	public boolean doIsAssignable(LightweightTypeReference lhs, LightweightTypeReference rhs) {
		return conformanceComputer.isConformant(lhs, rhs);
	}
	
	// if run against 2.4.2
	// 66 sec
	
	// if run against old implementation of the type conformance computer:
	// 48.5 sec
	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	public static class RepeatedAssignabilityTest extends AssignabilityTest {
		
		@Override
		public boolean doIsAssignable(LightweightTypeReference lhs, LightweightTypeReference rhs) {
			for(int i = 0; i < 10000; i++)
				super.doIsAssignable(lhs, rhs);
			return super.doIsAssignable(lhs, rhs);
		}
	}

	// with new implementation
	// 27.1
	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	public static class RepeatedUnitTest extends UnitTest {
		
		@Override
		public boolean doIsAssignable(LightweightTypeReference lhs, LightweightTypeReference rhs) {
			for(int i = 0; i < 10000; i++)
				super.doIsAssignable(lhs, rhs);
			return super.doIsAssignable(lhs, rhs);
		}
	}
}

