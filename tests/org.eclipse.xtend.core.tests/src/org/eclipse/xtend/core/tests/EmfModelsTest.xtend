/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.util.List
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EParameter
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.XtextPackage
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.xbase.XbasePackage
import org.junit.Assert
import org.junit.Test

/**
 * @author dhuebner - Initial contribution and API
 */
class EmfModelsTest {
	private static final extension Logger LOGGER = Logger.getLogger(EmfModelsTest);

	@Test
	def void checkXbase() {
		check(XbasePackage.eINSTANCE);
	}

	@Test
	def void checkXtend() {
		check(XtendPackage.eINSTANCE);
	}

	@Test
	def void checkTypes() {
		check(TypesPackage.eINSTANCE);
	}

	@Test
	def void checkXtext() {
		check(XtextPackage.eINSTANCE);
	}

	def void check(EPackage ePack) {
		info("Checking EPackage '" + ePack.getName() + "'");
		for (it : ePack.getEClassifiers()) {
			if (it instanceof EClass) {
				check(it)
			}
		}
		info("EPackage '" + ePack.getName() + "' passed.");
	}

	def check(EClass eClassifier) {
		if (!eClassifier.isAbstract()) {
			val obj = eClassifier.getEPackage().getEFactoryInstance().create(eClassifier);
			for (EOperation eOperation : eClassifier.getEAllOperations()) {
				val List<Class<?>> paramTypes = newArrayList();
				val List<Object> parameters = newArrayList();
				for (EParameter parameter : eOperation.getEParameters()) {
					val Class<?> javaClass = toJavaClass(parameter.getEType());
					paramTypes.add(javaClass);
					parameters.add(getDefaultValue(javaClass));
				}
				try {
					val Method method = obj.getClass().getMethod(eOperation.getName(), paramTypes);
					try {
						info("Invoking: " + method.declaringClass.name+"."+method.name)
						method.invoke(obj, parameters.toArray);
					} catch (InvocationTargetException exc1) {
						if (exc1.getCause() instanceof UnsupportedOperationException) {
							val errorMessage = eClassifier.getName() + ": EOperation " +
								eOperation.getEContainingClass().getName() + "#" + eOperation.getName() +
								" not implemented in " + obj.getClass().getName()
							error(errorMessage)
							Assert.fail((errorMessage))
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					Assert.fail(e.message);
				}
			}
			if (LOGGER.debugEnabled)
				dumpFeatures(eClassifier, obj)
		}
	}

	def dumpFeatures(EClass eClassifier, EObject obj) {

		for (EStructuralFeature eStructuralFeature : eClassifier.getEAllStructuralFeatures()) {
			try {
				var prefix = "get"
				if (eStructuralFeature.getEType() == EcorePackage.Literals.EBOOLEAN && eStructuralFeature.
					getUpperBound() == 1) {
					prefix = "is"
				}
				val String getterName = (prefix) + Strings.toFirstUpper(eStructuralFeature.getName());
				val Method getter = obj.getClass().getMethod(getterName);

				if (isCustom(getter))
					debug(eClassifier.getName() + ": Overridden getter " + getterName);
				if (!eStructuralFeature.isMany()) {
					if (eStructuralFeature.isChangeable()) {
						val String setterName = "set" + Strings.toFirstUpper(eStructuralFeature.getName());
						val Method setter = obj.getClass().getMethod(setterName,
							toJavaClass(eStructuralFeature.getEType()));

						if (isCustom(setter))
							debug(eClassifier.getName() + ": Overridden setter " + setter.getName());
					}
					if (eStructuralFeature instanceof EReference && !(eStructuralFeature as EReference).isContainment() &&
						(eStructuralFeature as EReference).getEOpposite() == null) {
						val String basicGetterName = "basic" + Strings.toFirstUpper(getterName);
						val Method basicGetter = obj.getClass().getMethod(basicGetterName);
						if (isCustom(basicGetter))
							debug(eClassifier.getName() + ": Overridden basicGetter " + basicGetter.getName());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	def toJavaClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClass() != null) {
			return eClassifier.getInstanceClass();
		}
		return null;
	}

	def private Object getDefaultValue(Class<?> clazz) {
		if (clazz.isPrimitive()) {
			switch (clazz) {
				case Boolean.TYPE:
					return false
				case Long.TYPE:
					return 0l
				case Integer.TYPE:
					return 0
				case Character.TYPE:
					return 0 as char
				case Short.TYPE:
					return 0 as short
				case Byte.TYPE:
					return 0 as byte
				case Double.TYPE:
					return 0d
				case Float.TYPE:
					return 0f
			}
		}
		return null;
	}

	def private boolean isCustom(Method getter) {
		return getter.getDeclaringClass().getName().endsWith("ImplCustom");
	}

}
