/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.RuntimeTestSetup;
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RuntimeInjectorProviderWithCustomSynonyms extends RuntimeInjectorProvider {

	@Override
	protected Injector internalCreateInjector() {
		return new RuntimeTestSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtendRuntimeTestModule() {
					@SuppressWarnings("unused")
					public Class<? extends SynonymTypesProvider> bindSynonymTypesProvider() {
						return CustomSynonymTypesProvider.class;
					}
				});
			}
		}.createInjectorAndDoEMFRegistration();
	}
	
	public static class CustomSynonymTypesProvider extends SynonymTypesProvider {
	
		@Override
		protected boolean collectCustomSynonymTypes(/* @Nullable */ LightweightTypeReference type, /* @NonNull */ Acceptor acceptor) {
			if (type.getInvariantBoundSubstitute().isType(BigInteger.class)) {
				return announceBigDecimal(type, acceptor);
			}
			return true;
		}

		protected boolean announceBigDecimal(LightweightTypeReference bigInteger, Acceptor acceptor) {
			ITypeReferenceOwner owner = bigInteger.getOwner();
			return announceSynonym(owner.newReferenceTo(BigDecimal.class), ConformanceFlags.DEMAND_CONVERSION, acceptor);
		}
	}
	
}
