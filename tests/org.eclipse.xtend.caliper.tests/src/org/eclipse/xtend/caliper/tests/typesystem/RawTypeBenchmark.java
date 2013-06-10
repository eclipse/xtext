/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.typesystem;

import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.caliper.Param;
import com.google.caliper.Runner;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RawTypeBenchmark extends TypeBasedSimpleBenchmark {

	public enum Impl {
		REWRITTEN {
			@Override
			boolean isRawType(LightweightTypeReference typeReference) {
				return typeReference.isRawType();
			}
			@Override
			LightweightTypeReference getRawType(LightweightTypeReference typeReference) {
				return typeReference.getRawTypeReference();
			}
		},
		BASELINE {
			@Override
			boolean isRawType(LightweightTypeReference typeReference) {
				return typeReference.isRawType();
			}
			@Override
			LightweightTypeReference getRawType(LightweightTypeReference typeReference) {
				return typeReference.getRawTypeReference();
			}
		},
		;
		abstract boolean isRawType(LightweightTypeReference typeReference);
		abstract LightweightTypeReference getRawType(LightweightTypeReference typeReference);
	}

	@Param
	Impl implementation;

//	@Param
	Type type = Type.OBJECT_ARRAY;
	
	LightweightTypeReference typeReference;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		typeReference = getTypeReference(type);
	}

	public int timeIsRawType(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.isRawType(typeReference)) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}
	
	public int timeGetRawType(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.getRawType(typeReference) == typeReference) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Runner.main(RawTypeBenchmark.class, args);
	}

}
