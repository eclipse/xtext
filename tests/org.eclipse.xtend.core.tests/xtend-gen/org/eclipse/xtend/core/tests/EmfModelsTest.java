/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests;

import com.google.common.base.Objects;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
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
  private final static Logger LOGGER = Logger.getLogger(EmfModelsTest.class);
  
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
    EList<EClassifier> _eClassifiers = ePack.getEClassifiers();
    for (final EClassifier it : _eClassifiers) {
      if ((it instanceof EClass)) {
        this.check(((EClass)it));
      }
    }
    String _name_1 = ePack.getName();
    String _plus_2 = ("EPackage \'" + _name_1);
    String _plus_3 = (_plus_2 + "\' passed.");
    EmfModelsTest.LOGGER.info(_plus_3);
  }
  
  public void check(final EClass eClassifier) {
    boolean _isAbstract = eClassifier.isAbstract();
    boolean _not = (!_isAbstract);
    if (_not) {
      EPackage _ePackage = eClassifier.getEPackage();
      EFactory _eFactoryInstance = _ePackage.getEFactoryInstance();
      final EObject obj = _eFactoryInstance.create(eClassifier);
      EList<EOperation> _eAllOperations = eClassifier.getEAllOperations();
      for (final EOperation eOperation : _eAllOperations) {
        {
          final List<Class<?>> paramTypes = CollectionLiterals.<Class<?>>newArrayList();
          final List<Object> parameters = CollectionLiterals.<Object>newArrayList();
          EList<EParameter> _eParameters = eOperation.getEParameters();
          for (final EParameter parameter : _eParameters) {
            {
              EClassifier _eType = parameter.getEType();
              final Class<?> javaClass = this.toJavaClass(_eType);
              paramTypes.add(javaClass);
              Object _defaultValue = this.getDefaultValue(javaClass);
              parameters.add(_defaultValue);
            }
          }
          try {
            Class<? extends EObject> _class = obj.getClass();
            String _name = eOperation.getName();
            final Method method = _class.getMethod(_name, ((Class<?>[])Conversions.unwrapArray(paramTypes, Class.class)));
            try {
              Class<?> _declaringClass = method.getDeclaringClass();
              String _name_1 = _declaringClass.getName();
              String _plus = ("Invoking: " + _name_1);
              String _plus_1 = (_plus + ".");
              String _name_2 = method.getName();
              String _plus_2 = (_plus_1 + _name_2);
              EmfModelsTest.LOGGER.info(_plus_2);
              Object[] _array = parameters.toArray();
              method.invoke(obj, _array);
            } catch (final Throwable _t) {
              if (_t instanceof InvocationTargetException) {
                final InvocationTargetException exc1 = (InvocationTargetException)_t;
                Throwable _cause = exc1.getCause();
                if ((_cause instanceof UnsupportedOperationException)) {
                  String _name_3 = eClassifier.getName();
                  String _plus_3 = (_name_3 + ": EOperation ");
                  EClass _eContainingClass = eOperation.getEContainingClass();
                  String _name_4 = _eContainingClass.getName();
                  String _plus_4 = (_plus_3 + _name_4);
                  String _plus_5 = (_plus_4 + "#");
                  String _name_5 = eOperation.getName();
                  String _plus_6 = (_plus_5 + _name_5);
                  String _plus_7 = (_plus_6 + 
                    " not implemented in ");
                  Class<? extends EObject> _class_1 = obj.getClass();
                  String _name_6 = _class_1.getName();
                  final String errorMessage = (_plus_7 + _name_6);
                  EmfModelsTest.LOGGER.error(errorMessage);
                  Assert.fail(errorMessage);
                }
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          } catch (final Throwable _t_1) {
            if (_t_1 instanceof Exception) {
              final Exception e = (Exception)_t_1;
              e.printStackTrace();
              String _message = e.getMessage();
              Assert.fail(_message);
            } else {
              throw Exceptions.sneakyThrow(_t_1);
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
        boolean _and = false;
        EClassifier _eType = eStructuralFeature.getEType();
        boolean _equals = Objects.equal(_eType, EcorePackage.Literals.EBOOLEAN);
        if (!_equals) {
          _and = false;
        } else {
          int _upperBound = eStructuralFeature.getUpperBound();
          boolean _equals_1 = (_upperBound == 1);
          _and = _equals_1;
        }
        if (_and) {
          prefix = "is";
        }
        String _name = eStructuralFeature.getName();
        String _firstUpper = Strings.toFirstUpper(_name);
        final String getterName = (prefix + _firstUpper);
        Class<? extends EObject> _class = obj.getClass();
        final Method getter = _class.getMethod(getterName);
        boolean _isCustom = this.isCustom(getter);
        if (_isCustom) {
          String _name_1 = eClassifier.getName();
          String _plus = (_name_1 + ": Overridden getter ");
          String _plus_1 = (_plus + getterName);
          EmfModelsTest.LOGGER.debug(_plus_1);
        }
        boolean _isMany = eStructuralFeature.isMany();
        boolean _not = (!_isMany);
        if (_not) {
          boolean _isChangeable = eStructuralFeature.isChangeable();
          if (_isChangeable) {
            String _name_2 = eStructuralFeature.getName();
            String _firstUpper_1 = Strings.toFirstUpper(_name_2);
            final String setterName = ("set" + _firstUpper_1);
            Class<? extends EObject> _class_1 = obj.getClass();
            EClassifier _eType_1 = eStructuralFeature.getEType();
            Class<?> _javaClass = this.toJavaClass(_eType_1);
            final Method setter = _class_1.getMethod(setterName, _javaClass);
            boolean _isCustom_1 = this.isCustom(setter);
            if (_isCustom_1) {
              String _name_3 = eClassifier.getName();
              String _plus_2 = (_name_3 + ": Overridden setter ");
              String _name_4 = setter.getName();
              String _plus_3 = (_plus_2 + _name_4);
              EmfModelsTest.LOGGER.debug(_plus_3);
            }
          }
          boolean _and_1 = false;
          boolean _and_2 = false;
          if (!(eStructuralFeature instanceof EReference)) {
            _and_2 = false;
          } else {
            boolean _isContainment = ((EReference) eStructuralFeature).isContainment();
            boolean _not_1 = (!_isContainment);
            _and_2 = _not_1;
          }
          if (!_and_2) {
            _and_1 = false;
          } else {
            EReference _eOpposite = ((EReference) eStructuralFeature).getEOpposite();
            boolean _equals_2 = Objects.equal(_eOpposite, null);
            _and_1 = _equals_2;
          }
          if (_and_1) {
            String _firstUpper_2 = Strings.toFirstUpper(getterName);
            final String basicGetterName = ("basic" + _firstUpper_2);
            Class<? extends EObject> _class_2 = obj.getClass();
            final Method basicGetter = _class_2.getMethod(basicGetterName);
            boolean _isCustom_2 = this.isCustom(basicGetter);
            if (_isCustom_2) {
              String _name_5 = eClassifier.getName();
              String _plus_4 = (_name_5 + ": Overridden basicGetter ");
              String _name_6 = basicGetter.getName();
              String _plus_5 = (_plus_4 + _name_6);
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
    boolean _notEquals = (!Objects.equal(_instanceClass, null));
    if (_notEquals) {
      return eClassifier.getInstanceClass();
    }
    return null;
  }
  
  private Object getDefaultValue(final Class<?> clazz) {
    boolean _isPrimitive = clazz.isPrimitive();
    if (_isPrimitive) {
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(clazz, Boolean.TYPE)) {
          _matched=true;
          return Boolean.valueOf(false);
        }
      }
      if (!_matched) {
        if (Objects.equal(clazz, Long.TYPE)) {
          _matched=true;
          return Long.valueOf(0l);
        }
      }
      if (!_matched) {
        if (Objects.equal(clazz, Integer.TYPE)) {
          _matched=true;
          return Integer.valueOf(0);
        }
      }
      if (!_matched) {
        if (Objects.equal(clazz, Character.TYPE)) {
          _matched=true;
          return Character.valueOf(((char) 0));
        }
      }
      if (!_matched) {
        if (Objects.equal(clazz, Short.TYPE)) {
          _matched=true;
          return Short.valueOf(((short) 0));
        }
      }
      if (!_matched) {
        if (Objects.equal(clazz, Byte.TYPE)) {
          _matched=true;
          return Byte.valueOf(((byte) 0));
        }
      }
      if (!_matched) {
        if (Objects.equal(clazz, Double.TYPE)) {
          _matched=true;
          return Double.valueOf(0d);
        }
      }
      if (!_matched) {
        if (Objects.equal(clazz, Float.TYPE)) {
          _matched=true;
          return Float.valueOf(0f);
        }
      }
    }
    return null;
  }
  
  private boolean isCustom(final Method getter) {
    Class<?> _declaringClass = getter.getDeclaringClass();
    String _name = _declaringClass.getName();
    return _name.endsWith("ImplCustom");
  }
}
