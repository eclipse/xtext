/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class EmfModelsTest {
  @Extension
  private static final Logger LOGGER = Logger.getLogger(EmfModelsTest.class);

  @Test
  public void checkXbase() {
    this.check(XbasePackage.eINSTANCE);
  }

  @Test
  public void checkXtend() {
    this.check(XtendPackage.eINSTANCE);
  }

  @Test
  public void checkTypes() {
    this.check(TypesPackage.eINSTANCE);
  }

  @Test
  public void checkXtext() {
    this.check(XtextPackage.eINSTANCE);
  }

  public void check(final EPackage ePack) {
    String _name = ePack.getName();
    String _plus = ("Checking EPackage \'" + _name);
    String _plus_1 = (_plus + "\'");
    EmfModelsTest.LOGGER.info(_plus_1);
    final Consumer<EClassifier> _function = (EClassifier it) -> {
      if ((it instanceof EClass)) {
        this.check(((EClass)it));
      }
    };
    ePack.getEClassifiers().forEach(_function);
    String _name_1 = ePack.getName();
    String _plus_2 = ("EPackage \'" + _name_1);
    String _plus_3 = (_plus_2 + "\' passed.");
    EmfModelsTest.LOGGER.info(_plus_3);
  }

  public void check(final EClass eClassifier) {
    boolean _isAbstract = eClassifier.isAbstract();
    boolean _not = (!_isAbstract);
    if (_not) {
      final EObject obj = eClassifier.getEPackage().getEFactoryInstance().create(eClassifier);
      EList<EOperation> _eAllOperations = eClassifier.getEAllOperations();
      for (final EOperation eOperation : _eAllOperations) {
        {
          final List<Class<?>> paramTypes = CollectionLiterals.<Class<?>>newArrayList();
          final List<Object> parameters = CollectionLiterals.<Object>newArrayList();
          EList<EParameter> _eParameters = eOperation.getEParameters();
          for (final EParameter parameter : _eParameters) {
            {
              final Class<?> javaClass = this.toJavaClass(parameter.getEType());
              paramTypes.add(javaClass);
              parameters.add(this.getDefaultValue(javaClass));
            }
          }
          try {
            final Method method = obj.getClass().getMethod(eOperation.getName(), ((Class<?>[])Conversions.unwrapArray(paramTypes, Class.class)));
            try {
              String _name = method.getDeclaringClass().getName();
              String _plus = ("Invoking: " + _name);
              String _plus_1 = (_plus + ".");
              String _name_1 = method.getName();
              String _plus_2 = (_plus_1 + _name_1);
              EmfModelsTest.LOGGER.info(_plus_2);
              method.invoke(obj, parameters.toArray());
            } catch (final Throwable _t) {
              if (_t instanceof InvocationTargetException) {
                final InvocationTargetException exc1 = (InvocationTargetException)_t;
                Throwable _cause = exc1.getCause();
                if ((_cause instanceof UnsupportedOperationException)) {
                  String _name_2 = eClassifier.getName();
                  String _plus_3 = (_name_2 + ": EOperation ");
                  String _name_3 = eOperation.getEContainingClass().getName();
                  String _plus_4 = (_plus_3 + _name_3);
                  String _plus_5 = (_plus_4 + "#");
                  String _name_4 = eOperation.getName();
                  String _plus_6 = (_plus_5 + _name_4);
                  String _plus_7 = (_plus_6 + 
                    " not implemented in ");
                  String _name_5 = obj.getClass().getName();
                  final String errorMessage = (_plus_7 + _name_5);
                  EmfModelsTest.LOGGER.error(errorMessage);
                  Assert.fail(errorMessage);
                }
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception e = (Exception)_t;
              e.printStackTrace();
              Assert.fail(e.getMessage());
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
      boolean _isDebugEnabled = EmfModelsTest.LOGGER.isDebugEnabled();
      if (_isDebugEnabled) {
        this.dumpFeatures(eClassifier, obj);
      }
    }
  }

  public void dumpFeatures(final EClass eClassifier, final EObject obj) {
    EList<EStructuralFeature> _eAllStructuralFeatures = eClassifier.getEAllStructuralFeatures();
    for (final EStructuralFeature eStructuralFeature : _eAllStructuralFeatures) {
      try {
        String prefix = "get";
        if ((Objects.equals(eStructuralFeature.getEType(), EcorePackage.Literals.EBOOLEAN) && (eStructuralFeature.getUpperBound() == 1))) {
          prefix = "is";
        }
        String _firstUpper = Strings.toFirstUpper(eStructuralFeature.getName());
        final String getterName = (prefix + _firstUpper);
        final Method getter = obj.getClass().getMethod(getterName);
        boolean _isCustom = this.isCustom(getter);
        if (_isCustom) {
          String _name = eClassifier.getName();
          String _plus = (_name + ": Overridden getter ");
          String _plus_1 = (_plus + getterName);
          EmfModelsTest.LOGGER.debug(_plus_1);
        }
        boolean _isMany = eStructuralFeature.isMany();
        boolean _not = (!_isMany);
        if (_not) {
          boolean _isChangeable = eStructuralFeature.isChangeable();
          if (_isChangeable) {
            String _firstUpper_1 = Strings.toFirstUpper(eStructuralFeature.getName());
            final String setterName = ("set" + _firstUpper_1);
            final Method setter = obj.getClass().getMethod(setterName, 
              this.toJavaClass(eStructuralFeature.getEType()));
            boolean _isCustom_1 = this.isCustom(setter);
            if (_isCustom_1) {
              String _name_1 = eClassifier.getName();
              String _plus_2 = (_name_1 + ": Overridden setter ");
              String _name_2 = setter.getName();
              String _plus_3 = (_plus_2 + _name_2);
              EmfModelsTest.LOGGER.debug(_plus_3);
            }
          }
          if ((((eStructuralFeature instanceof EReference) && (!((EReference) eStructuralFeature).isContainment())) && 
            (((EReference) eStructuralFeature).getEOpposite() == null))) {
            String _firstUpper_2 = Strings.toFirstUpper(getterName);
            final String basicGetterName = ("basic" + _firstUpper_2);
            final Method basicGetter = obj.getClass().getMethod(basicGetterName);
            boolean _isCustom_2 = this.isCustom(basicGetter);
            if (_isCustom_2) {
              String _name_3 = eClassifier.getName();
              String _plus_4 = (_name_3 + ": Overridden basicGetter ");
              String _name_4 = basicGetter.getName();
              String _plus_5 = (_plus_4 + _name_4);
              EmfModelsTest.LOGGER.debug(_plus_5);
            }
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          e.printStackTrace();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }

  public Class<?> toJavaClass(final EClassifier eClassifier) {
    Class<?> _instanceClass = eClassifier.getInstanceClass();
    boolean _tripleNotEquals = (_instanceClass != null);
    if (_tripleNotEquals) {
      return eClassifier.getInstanceClass();
    }
    return null;
  }

  private Object getDefaultValue(final Class<?> clazz) {
    boolean _isPrimitive = clazz.isPrimitive();
    if (_isPrimitive) {
      boolean _matched = false;
      if (Objects.equals(clazz, Boolean.TYPE)) {
        _matched=true;
        return Boolean.valueOf(false);
      }
      if (!_matched) {
        if (Objects.equals(clazz, Long.TYPE)) {
          _matched=true;
          return Long.valueOf(0l);
        }
      }
      if (!_matched) {
        if (Objects.equals(clazz, Integer.TYPE)) {
          _matched=true;
          return Integer.valueOf(0);
        }
      }
      if (!_matched) {
        if (Objects.equals(clazz, Character.TYPE)) {
          _matched=true;
          return Character.valueOf(((char) 0));
        }
      }
      if (!_matched) {
        if (Objects.equals(clazz, Short.TYPE)) {
          _matched=true;
          return Short.valueOf(((short) 0));
        }
      }
      if (!_matched) {
        if (Objects.equals(clazz, Byte.TYPE)) {
          _matched=true;
          return Byte.valueOf(((byte) 0));
        }
      }
      if (!_matched) {
        if (Objects.equals(clazz, Double.TYPE)) {
          _matched=true;
          return Double.valueOf(0d);
        }
      }
      if (!_matched) {
        if (Objects.equals(clazz, Float.TYPE)) {
          _matched=true;
          return Float.valueOf(0f);
        }
      }
    }
    return null;
  }

  private boolean isCustom(final Method getter) {
    return getter.getDeclaringClass().getName().endsWith("ImplCustom");
  }
}
