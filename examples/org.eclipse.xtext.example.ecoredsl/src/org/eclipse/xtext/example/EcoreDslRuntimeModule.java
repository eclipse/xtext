/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractToStringConverter;
import org.eclipse.xtext.conversion.impl.AbstractValueConverter;
import org.eclipse.xtext.crossref.impl.Linker;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;

/**
 * Used to register components to be used within the IDE.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class EcoreDslRuntimeModule extends AbstractEcoreDslRuntimeModule {

	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());
	
	@Override
	public Class<? extends org.eclipse.xtext.crossref.ILinker> bindILinker() {
		return EcoreDslRuntimeModule.EcoreDslLinker.class;
	}
	
	@Override
	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return EcoreDslRuntimeModule.EcoreDslConverters.class;
	}

	@Override
	public Class<? extends ITransientValueService> bindITransientValueService() {
		return EcoreDslRuntimeModule.EcoreDslTransientValueService.class;
	}
	
	public static class EcoreDslConverters extends DefaultTerminalConverters {

		@ValueConverter(rule = "SINT")
		public IValueConverter<Integer> sint() {
			return new AbstractToStringConverter<Integer>() {
				@Override
				public Integer internalToValue(String string, AbstractNode node) {
					return Integer.valueOf(string);
				}
			};
		}

		@ValueConverter(rule = "Bag")
		public IValueConverter<Boolean> bag() {
			return negatedBooleanConverter("bag");
		}

		@ValueConverter(rule = "Random")
		public IValueConverter<Boolean> random() {
			return negatedBooleanConverter("random");
		}

		@ValueConverter(rule = "Readonly")
		public IValueConverter<Boolean> readonly() {
			return negatedBooleanConverter("readonly");
		}

		@ValueConverter(rule = "Local")
		public IValueConverter<Boolean> local() {
			return negatedBooleanConverter("local");
		}

		@ValueConverter(rule = "Serializable")
		public IValueConverter<Boolean> serializable() {
			return negatedBooleanConverter("!serializable");
		}

		private IValueConverter<Boolean> negatedBooleanConverter(final String keyword) {
			return new AbstractValueConverter<Boolean>(){
				public Boolean toValue(String string, AbstractNode node) throws ValueConverterException {
					return string == null;
				}
			
				public String toString(Boolean value) {
					return value ? "" : keyword;
				}
			};
		}

	}

	public static class EcoreDslLinker extends Linker {

		// logger available to subclasses
		protected final Logger logger = Logger.getLogger(getClass());
		
		@Override
		protected void setDefaultValueImpl(EObject obj, EReference ref, IDiagnosticProducer producer) {
			//hack: ePackage always needs an eFactoryInstance (gets cleared in #clearReferences?)
			if (ref.getName().equalsIgnoreCase("eFactoryInstance")) {
				((EPackage) obj).setEFactoryInstance(EcoreFactory.eINSTANCE.createEFactory());
			}
			super.setDefaultValueImpl(obj, ref, producer);
		}

		@Override
		protected void clearReferences(EObject obj) {
			EList<EReference> allReferences = obj instanceof EClass ? ((EClass) obj).getEAllReferences() : obj.eClass()
					.getEAllReferences();
			// hack: exceptions when eType, eExceptions are null
			for (EReference ref : allReferences) {
				try {
					if (ref.isContainment() || 
					    ref.isContainer()   || 
					    ref.isDerived() 	|| obj.eGet(ref) == null || ref.getName() == null
							|| (obj instanceof ETypedElement && ref.getName().equalsIgnoreCase("eType"))
							|| (obj instanceof ETypedElement && ref.getName().equalsIgnoreCase("eExceptions"))) {
						continue;
					}

					clearReference(obj, ref);
				}
				catch (Exception e) {
					logger.error(e);
				}
			}
		}
	}

	public static class EcoreDslTransientValueService extends DefaultTransientValueService {
		@Override
		public boolean isTransient(EObject owner, EStructuralFeature feature, int index) {
			if (EcorePackage.eINSTANCE.getETypedElement_EType() == feature || EcorePackage.eINSTANCE.getEClass_ESuperTypes() == feature)
				return true;
			if (EcorePackage.eINSTANCE.getETypedElement_EGenericType() == feature || EcorePackage.eINSTANCE.getEClass_EGenericSuperTypes() == feature)
				return false;
			return super.isTransient(owner, feature, index);
		}
	}

}
