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
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.xtext.builtin.conversion.XtextBuiltInConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractToStringConverter;
import org.eclipse.xtext.crossref.internal.Linker;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.parser.DefaultEcoreElementFactory;
import org.eclipse.xtext.parsetree.AbstractNode;

import com.google.inject.Binder;

/**
 * Used to register components to be used within the IDE.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class EcoreDslRuntimeModule extends AbstractEcoreDslRuntimeModule {

	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
	}
	
	
	public Class<? extends org.eclipse.xtext.crossref.ILinker> bindILinker() {
		return EcoreDslRuntimeModule.EcoreDslLinker.class;
	}
	
	public Class<? extends org.eclipse.xtext.parser.IAstFactory> bindIAstFactory() {
		return EcoreDslRuntimeModule.EcoreDslElementFactory.class;
	}
	
	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return EcoreDslRuntimeModule.EcoreDslConverters.class;
	}
	
	public static class EcoreDslConverters extends XtextBuiltInConverters {

		@ValueConverter(rule = "SINT")
		public IValueConverter<Integer> SINT() {
			return new AbstractToStringConverter<Integer>() {
				public Integer internalToValue(String string, AbstractNode node) {
					return Integer.valueOf(string);
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
				((EPackage) obj).setEFactoryInstance(EcoreFactoryImpl.eINSTANCE.createEFactory());
			}
			super.setDefaultValueImpl(obj, ref, producer);
		}

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

	public static class EcoreDslElementFactory extends DefaultEcoreElementFactory {

		// logger available to subclasses
		protected final Logger logger = Logger.getLogger(getClass());
		
		@Override
		public void set(EObject _this, String feature, Object value, String ruleName, AbstractNode node)
				throws ValueConverterException {
			// hack: negated boolean assignments (not possible out of the box with xtext)
			if (ruleName.equals("readonly")) {
				((EStructuralFeature) _this).setChangeable(false);
				return;
			}
			else if (ruleName.equals("readonly")) {
				((EStructuralFeature) _this).setChangeable(false);
				return;
			}
			else if (ruleName.equals("local")) {
				((EReference) _this).setResolveProxies(false);
				return;
			}
			else if (ruleName.equals("random")) {
				((ETypedElement) _this).setOrdered(false);
				return;
			}
			else if (ruleName.equals("bag")) {
				((ETypedElement) _this).setUnique(false);
				return;
			}
			else if (ruleName.equals("!serializable")) {
				((EDataType) _this).setSerializable(false);
				return;
			}
			super.set(_this, feature, value, ruleName, node);
		}

		@Override
		public void add(EObject _this, String feature, Object value, String ruleName, AbstractNode node)
				throws ValueConverterException {
			if (feature.equals("contents") && _this instanceof EAnnotation) {
				String key = (String) ((EObject) value).eGet(((EObject) value).eClass().getEAllAttributes().get(0));
				String stringValue = (String) ((EObject) value).eGet(((EObject) value).eClass().getEAllAttributes()
						.get(1));
				((EAnnotation) _this).getDetails().put(key, stringValue);
				return;
			}
			super.add(_this, feature, value, ruleName, node);
		}

	}
	
}
