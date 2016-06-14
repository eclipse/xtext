/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.visitors;

import java.util.ArrayList;
import java.util.List;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Benchmark extends SimpleBenchmark {

	@Param({ "1", "2", "3", "5", "10" })
	int size;

	private final List<CaliperTypeReference> references = new ArrayList<CaliperTypeReference>();

	@Override
	protected void setUp() throws Exception {
		for (int i = 0; i < size; i++) {
			references.add(new CaliperArrayTypeReference());
			references.add(new CaliperCompoundTypeReference());
			references.add(new CaliperFunctionTypeReference());
			references.add(new CaliperParameterizedTypeReference());
			references.add(new CaliperUnboundTypeReference());
			references.add(new CaliperUnknownTypeReference());
			references.add(new CaliperWildcardTypeReference());
		}
	}

	public int timeInstanceMethodOverridden(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			for(CaliperTypeReference reference: references) {
				result += reference.specializeAllCasesInstanceMethod(reps, i);
			}
		}
		return result;
	}
	
	public int timeInstanceMethodInherited(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			for(CaliperTypeReference reference: references) {
				result += reference.specializeSomeCasesInstanceMethod(reps, i);
			}
		}
		return result;
	}
	
	public int timePolymorphicDispatchedOverridden(int reps) {
		SpecializeAllCasesPolymorphicDispatcher dispatcher = new SpecializeAllCasesPolymorphicDispatcher();
		int result = 0;
		for (int i = 0; i < reps; i++) {
			for(CaliperTypeReference reference: references) {
				result += dispatcher.accept(reference, reps, reps * reps);
			}
		}
		return result;
	}
	
	public int timePolymorphicDispatchedInherited(int reps) {
		SpecializeSomeCasesPolymorphicDispatcher dispatcher = new SpecializeSomeCasesPolymorphicDispatcher();
		int result = 0;
		for (int i = 0; i < reps; i++) {
			for(CaliperTypeReference reference: references) {
				result += dispatcher.accept(reference, reps, reps * reps);
			}
		}
		return result;
	}
	
	public int timeEmfVisitorOverridden(int reps) {
		SpecializeAllCasesEmfVisitor visitor = new SpecializeAllCasesEmfVisitor();
		int result = 0;
		for (int i = 0; i < reps; i++) {
			for(CaliperTypeReference reference: references) {
				result += visitor.switchCaliperTypeReference(reference, reps, reps * reps);
			}
		}
		return result;
	}
	
	public int timeEmfVisitorInherited(int reps) {
		SpecializeSomeCasesEmfVisitor visitor = new SpecializeSomeCasesEmfVisitor();
		int result = 0;
		for (int i = 0; i < reps; i++) {
			for(CaliperTypeReference reference: references) {
				result += visitor.switchCaliperTypeReference(reference, reps, reps * reps);
			}
		}
		return result;
	}
	
	public int timeVisitorOverridden(int reps) {
		SpecializeAllCasesVisitor visitor = new SpecializeAllCasesVisitor();
		int result = 0;
		for (int i = 0; i < reps; i++) {
			for(CaliperTypeReference reference: references) {
				result += reference.acceptVisitor(visitor, reps, reps * reps);
			}
		}
		return result;
	}
	
	public int timeVisitorInherited(int reps) {
		SpecializeSomeCasesVisitor visitor = new SpecializeSomeCasesVisitor();
		int result = 0;
		for (int i = 0; i < reps; i++) {
			for(CaliperTypeReference reference: references) {
				result += reference.acceptVisitor(visitor, reps, reps * reps);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Runner.main(Benchmark.class, args);
	}

}