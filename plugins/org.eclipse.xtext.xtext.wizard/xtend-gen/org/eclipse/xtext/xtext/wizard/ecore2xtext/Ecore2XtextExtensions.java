/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.wizard.ecore2xtext;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.wizard.EPackageInfo;
import org.eclipse.xtext.xtext.wizard.Ecore2XtextConfiguration;
import org.eclipse.xtext.xtext.wizard.ecore2xtext.UniqueNameUtil;

@SuppressWarnings("all")
public class Ecore2XtextExtensions {
  public static Iterable<EClassifier> allConcreteRuleClassifiers(final Ecore2XtextConfiguration it) {
    Iterable<EClassifier> _xifexpression = null;
    EClass _rootElementClass = it.getRootElementClass();
    boolean _equals = Objects.equal(_rootElementClass, null);
    if (_equals) {
      Set<EPackageInfo> _ePackageInfos = it.getEPackageInfos();
      final Function1<EPackageInfo, Set<EClassifier>> _function = new Function1<EPackageInfo, Set<EClassifier>>() {
        @Override
        public Set<EClassifier> apply(final EPackageInfo it) {
          EPackage _ePackage = it.getEPackage();
          return Ecore2XtextExtensions.allReferencedClassifiers(_ePackage, false);
        }
      };
      Iterable<Set<EClassifier>> _map = IterableExtensions.<EPackageInfo, Set<EClassifier>>map(_ePackageInfos, _function);
      Iterable<EClassifier> _flatten = Iterables.<EClassifier>concat(_map);
      Set<EClassifier> _set = IterableExtensions.<EClassifier>toSet(_flatten);
      final Function1<EClassifier, Boolean> _function_1 = new Function1<EClassifier, Boolean>() {
        @Override
        public Boolean apply(final EClassifier it) {
          return Boolean.valueOf(Ecore2XtextExtensions.needsConcreteRule(it));
        }
      };
      _xifexpression = IterableExtensions.<EClassifier>filter(_set, _function_1);
    } else {
      Set<EClassifier> _xblockexpression = null;
      {
        EClass _rootElementClass_1 = it.getRootElementClass();
        EClassifier _cast = EClassifier.class.cast(_rootElementClass_1);
        final ArrayList<EClassifier> c = CollectionLiterals.<EClassifier>newArrayList(_cast);
        EClass _rootElementClass_2 = it.getRootElementClass();
        Ecore2XtextExtensions.allAssignedClassifiers(_rootElementClass_2, c);
        final Function1<EClassifier, Boolean> _function_2 = new Function1<EClassifier, Boolean>() {
          @Override
          public Boolean apply(final EClassifier cl) {
            return Boolean.valueOf(Ecore2XtextExtensions.needsConcreteRule(cl));
          }
        };
        Iterable<EClassifier> _filter = IterableExtensions.<EClassifier>filter(c, _function_2);
        _xblockexpression = IterableExtensions.<EClassifier>toSet(_filter);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public static Collection<EClass> allDispatcherRuleClasses(final Ecore2XtextConfiguration it) {
    Set<EClass> _xifexpression = null;
    EClass _rootElementClass = it.getRootElementClass();
    boolean _equals = Objects.equal(_rootElementClass, null);
    if (_equals) {
      Set<EPackageInfo> _ePackageInfos = it.getEPackageInfos();
      final Function1<EPackageInfo, Set<EClassifier>> _function = new Function1<EPackageInfo, Set<EClassifier>>() {
        @Override
        public Set<EClassifier> apply(final EPackageInfo it) {
          EPackage _ePackage = it.getEPackage();
          return Ecore2XtextExtensions.allReferencedClassifiers(_ePackage, false);
        }
      };
      Iterable<Set<EClassifier>> _map = IterableExtensions.<EPackageInfo, Set<EClassifier>>map(_ePackageInfos, _function);
      Iterable<EClassifier> _flatten = Iterables.<EClassifier>concat(_map);
      Set<EClassifier> _set = IterableExtensions.<EClassifier>toSet(_flatten);
      final Function1<EClassifier, Boolean> _function_1 = new Function1<EClassifier, Boolean>() {
        @Override
        public Boolean apply(final EClassifier c) {
          return Boolean.valueOf(Ecore2XtextExtensions.needsDispatcherRule(c));
        }
      };
      Iterable<EClassifier> _filter = IterableExtensions.<EClassifier>filter(_set, _function_1);
      Iterable<EClass> _filter_1 = Iterables.<EClass>filter(_filter, EClass.class);
      _xifexpression = IterableExtensions.<EClass>toSet(_filter_1);
    } else {
      Iterable<EClassifier> _allConcreteRuleClassifiers = Ecore2XtextExtensions.allConcreteRuleClassifiers(it);
      Iterable<EClass> _filter_2 = Iterables.<EClass>filter(_allConcreteRuleClassifiers, EClass.class);
      final Function1<EClass, Iterable<EClassifier>> _function_2 = new Function1<EClass, Iterable<EClassifier>>() {
        @Override
        public Iterable<EClassifier> apply(final EClass c) {
          EList<EReference> _eAllReferences = c.getEAllReferences();
          final Function1<EReference, Boolean> _function = new Function1<EReference, Boolean>() {
            @Override
            public Boolean apply(final EReference r) {
              return Boolean.valueOf(Ecore2XtextExtensions.needsAssignment(r));
            }
          };
          Iterable<EReference> _filter = IterableExtensions.<EReference>filter(_eAllReferences, _function);
          final Function1<EReference, EClassifier> _function_1 = new Function1<EReference, EClassifier>() {
            @Override
            public EClassifier apply(final EReference it) {
              return it.getEType();
            }
          };
          return IterableExtensions.<EReference, EClassifier>map(_filter, _function_1);
        }
      };
      Iterable<Iterable<EClassifier>> _map_1 = IterableExtensions.<EClass, Iterable<EClassifier>>map(_filter_2, _function_2);
      Iterable<EClassifier> _flatten_1 = Iterables.<EClassifier>concat(_map_1);
      Iterable<EClass> _filter_3 = Iterables.<EClass>filter(_flatten_1, EClass.class);
      _xifexpression = IterableExtensions.<EClass>toSet(_filter_3);
    }
    return _xifexpression;
  }
  
  public static Collection<EPackage> allReferencedEPackages(final Ecore2XtextConfiguration prjInfo) {
    Set<EPackageInfo> _ePackageInfos = prjInfo.getEPackageInfos();
    final Function1<EPackageInfo, Set<EPackage>> _function = new Function1<EPackageInfo, Set<EPackage>>() {
      @Override
      public Set<EPackage> apply(final EPackageInfo it) {
        EPackage _ePackage = it.getEPackage();
        return Ecore2XtextExtensions.allReferencedEPackages(_ePackage, true);
      }
    };
    Iterable<Set<EPackage>> _map = IterableExtensions.<EPackageInfo, Set<EPackage>>map(_ePackageInfos, _function);
    Iterable<EPackage> _flatten = Iterables.<EPackage>concat(_map);
    return IterableExtensions.<EPackage>toSet(_flatten);
  }
  
  public static Set<EPackage> allReferencedEPackages(final EPackage ePack, final boolean includeCrossRefs) {
    Set<EClassifier> _allReferencedClassifiers = Ecore2XtextExtensions.allReferencedClassifiers(ePack, includeCrossRefs);
    final Function1<EClassifier, EPackage> _function = new Function1<EClassifier, EPackage>() {
      @Override
      public EPackage apply(final EClassifier it) {
        return it.getEPackage();
      }
    };
    Iterable<EPackage> _map = IterableExtensions.<EClassifier, EPackage>map(_allReferencedClassifiers, _function);
    Iterable<EPackage> _filterNull = IterableExtensions.<EPackage>filterNull(_map);
    return IterableExtensions.<EPackage>toSet(_filterNull);
  }
  
  public static Set<EClassifier> allReferencedClassifiers(final EPackage ePack, final boolean includeCrossRefs) {
    EList<EClassifier> _eClassifiers = ePack.getEClassifiers();
    Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
    final Function1<EClass, Iterable<EStructuralFeature>> _function = new Function1<EClass, Iterable<EStructuralFeature>>() {
      @Override
      public Iterable<EStructuralFeature> apply(final EClass it) {
        EList<EStructuralFeature> _eAllStructuralFeatures = it.getEAllStructuralFeatures();
        final Function1<EStructuralFeature, Boolean> _function = new Function1<EStructuralFeature, Boolean>() {
          @Override
          public Boolean apply(final EStructuralFeature f) {
            boolean _and = false;
            boolean _needsAssignment = Ecore2XtextExtensions.needsAssignment(f);
            if (!_needsAssignment) {
              _and = false;
            } else {
              boolean _or = false;
              if (includeCrossRefs) {
                _or = true;
              } else {
                boolean _isContainment = Ecore2XtextExtensions.isContainment(f);
                _or = _isContainment;
              }
              _and = _or;
            }
            return Boolean.valueOf(_and);
          }
        };
        return IterableExtensions.<EStructuralFeature>filter(_eAllStructuralFeatures, _function);
      }
    };
    final Iterable<Iterable<EStructuralFeature>> strFeatures = IterableExtensions.<EClass, Iterable<EStructuralFeature>>map(_filter, _function);
    Iterable<EStructuralFeature> _flatten = Iterables.<EStructuralFeature>concat(strFeatures);
    final Function1<EStructuralFeature, EClassifier> _function_1 = new Function1<EStructuralFeature, EClassifier>() {
      @Override
      public EClassifier apply(final EStructuralFeature it) {
        return it.getEType();
      }
    };
    Iterable<EClassifier> _map = IterableExtensions.<EStructuralFeature, EClassifier>map(_flatten, _function_1);
    final Set<EClassifier> refTypes = IterableExtensions.<EClassifier>toSet(_map);
    EList<EClassifier> _eClassifiers_1 = ePack.getEClassifiers();
    Iterable<EClassifier> _plus = Iterables.<EClassifier>concat(_eClassifiers_1, refTypes);
    final Set<EClassifier> retVal = IterableExtensions.<EClassifier>toSet(_plus);
    EClassifier _eString = UniqueNameUtil.eString();
    retVal.add(_eString);
    return retVal;
  }
  
  private static void allAssignedClassifiers(final EClass eClazz, final Collection<EClassifier> acceptor) {
    EList<EStructuralFeature> _eAllStructuralFeatures = eClazz.getEAllStructuralFeatures();
    final Function1<EStructuralFeature, Boolean> _function = new Function1<EStructuralFeature, Boolean>() {
      @Override
      public Boolean apply(final EStructuralFeature f) {
        return Boolean.valueOf(Ecore2XtextExtensions.needsAssignment(f));
      }
    };
    Iterable<EStructuralFeature> _filter = IterableExtensions.<EStructuralFeature>filter(_eAllStructuralFeatures, _function);
    final Function1<EStructuralFeature, EClassifier> _function_1 = new Function1<EStructuralFeature, EClassifier>() {
      @Override
      public EClassifier apply(final EStructuralFeature it) {
        return it.getEType();
      }
    };
    Iterable<EClassifier> _map = IterableExtensions.<EStructuralFeature, EClassifier>map(_filter, _function_1);
    final List<EClassifier> classifiers = IterableExtensions.<EClassifier>toList(_map);
    Iterable<EClass> _subClasses = Ecore2XtextExtensions.subClasses(eClazz);
    Iterables.<EClassifier>addAll(classifiers, _subClasses);
    classifiers.removeAll(acceptor);
    boolean _isEmpty = classifiers.isEmpty();
    if (_isEmpty) {
      return;
    } else {
      Iterables.<EClassifier>addAll(acceptor, classifiers);
      Iterable<EClass> _filter_1 = Iterables.<EClass>filter(classifiers, EClass.class);
      final Procedure1<EClass> _function_2 = new Procedure1<EClass>() {
        @Override
        public void apply(final EClass c) {
          Ecore2XtextExtensions.allAssignedClassifiers(c, acceptor);
        }
      };
      IterableExtensions.<EClass>forEach(_filter_1, _function_2);
    }
  }
  
  public static String fqn(final EClassifier it) {
    String _xifexpression = null;
    EPackage _ePackage = it.getEPackage();
    String _uniqueName = null;
    if (_ePackage!=null) {
      _uniqueName=UniqueNameUtil.uniqueName(_ePackage);
    }
    boolean _equals = Objects.equal(_uniqueName, null);
    if (_equals) {
      String _name = it.getName();
      _xifexpression = Ecore2XtextExtensions.quoteIfNeccesary(_name);
    } else {
      EPackage _ePackage_1 = it.getEPackage();
      String _uniqueName_1 = UniqueNameUtil.uniqueName(_ePackage_1);
      String _plus = (_uniqueName_1 + "::");
      String _name_1 = it.getName();
      String _quoteIfNeccesary = Ecore2XtextExtensions.quoteIfNeccesary(_name_1);
      _xifexpression = (_plus + _quoteIfNeccesary);
    }
    return _xifexpression;
  }
  
  public static Iterable<EStructuralFeature> prefixFeatures(final EClass it) {
    EList<EStructuralFeature> _eAllStructuralFeatures = it.getEAllStructuralFeatures();
    final Function1<EStructuralFeature, Boolean> _function = new Function1<EStructuralFeature, Boolean>() {
      @Override
      public Boolean apply(final EStructuralFeature f) {
        boolean _and = false;
        boolean _needsAssignment = Ecore2XtextExtensions.needsAssignment(f);
        if (!_needsAssignment) {
          _and = false;
        } else {
          boolean _isPrefixBooleanFeature = Ecore2XtextExtensions.isPrefixBooleanFeature(f);
          _and = _isPrefixBooleanFeature;
        }
        return Boolean.valueOf(_and);
      }
    };
    return IterableExtensions.<EStructuralFeature>filter(_eAllStructuralFeatures, _function);
  }
  
  public static Iterable<EStructuralFeature> inlinedFeatures(final EClass it) {
    EList<EStructuralFeature> _eAllStructuralFeatures = it.getEAllStructuralFeatures();
    final Function1<EStructuralFeature, Boolean> _function = new Function1<EStructuralFeature, Boolean>() {
      @Override
      public Boolean apply(final EStructuralFeature f) {
        return Boolean.valueOf(Ecore2XtextExtensions.needsAssignment(f));
      }
    };
    Iterable<EStructuralFeature> _filter = IterableExtensions.<EStructuralFeature>filter(_eAllStructuralFeatures, _function);
    final List<EStructuralFeature> features = IterableExtensions.<EStructuralFeature>toList(_filter);
    EAttribute _idAttribute = Ecore2XtextExtensions.idAttribute(it);
    features.remove(_idAttribute);
    Iterable<EStructuralFeature> _prefixFeatures = Ecore2XtextExtensions.prefixFeatures(it);
    List<EStructuralFeature> _list = IterableExtensions.<EStructuralFeature>toList(_prefixFeatures);
    features.removeAll(_list);
    return features;
  }
  
  public static boolean onlyOptionalFeatures(final EClass it) {
    boolean _xblockexpression = false;
    {
      Iterable<EStructuralFeature> _prefixFeatures = Ecore2XtextExtensions.prefixFeatures(it);
      Iterable<EStructuralFeature> _inlinedFeatures = Ecore2XtextExtensions.inlinedFeatures(it);
      final Iterable<EStructuralFeature> features = Iterables.<EStructuralFeature>concat(_prefixFeatures, _inlinedFeatures);
      final Function1<EStructuralFeature, Boolean> _function = new Function1<EStructuralFeature, Boolean>() {
        @Override
        public Boolean apply(final EStructuralFeature f) {
          return Boolean.valueOf(f.isRequired());
        }
      };
      Iterable<EStructuralFeature> _filter = IterableExtensions.<EStructuralFeature>filter(features, _function);
      _xblockexpression = IterableExtensions.isEmpty(_filter);
    }
    return _xblockexpression;
  }
  
  public static String assignedRuleCall(final EAttribute it) {
    String _xifexpression = null;
    boolean _isPrefixBooleanFeature = Ecore2XtextExtensions.isPrefixBooleanFeature(it);
    if (_isPrefixBooleanFeature) {
      String _name = it.getName();
      String _plus = ("\'" + _name);
      _xifexpression = (_plus + "\'");
    } else {
      EClassifier _eType = it.getEType();
      _xifexpression = UniqueNameUtil.uniqueName(_eType);
    }
    return _xifexpression;
  }
  
  public static String concreteRuleName(final EClass it) {
    String _xifexpression = null;
    boolean _needsDispatcherRule = Ecore2XtextExtensions.needsDispatcherRule(it);
    if (_needsDispatcherRule) {
      _xifexpression = UniqueNameUtil.uniqueImplName(it);
    } else {
      _xifexpression = UniqueNameUtil.uniqueName(it);
    }
    return _xifexpression;
  }
  
  public static String dataTypeRuleBody(final EDataType it) {
    String _switchResult = null;
    String _name = it.getName();
    boolean _matched = false;
    if (Objects.equal(_name, "EBigDecimal")) {
      _matched=true;
      _switchResult = "INT? \'.\' INT";
    }
    if (!_matched) {
      if (Objects.equal(_name, "EBigInteger")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.intRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "EBoolean")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.booleanRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "EBooleanObject")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.booleanRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "EByte")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.intRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "EByteObject")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.intRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "EChar")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.intRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "ECharObject")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.intRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "EDouble")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.decimalRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "EDoubleObject")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.decimalRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "EFloat")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.decimalRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "EFloatObject")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.decimalRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "EInt")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.intRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "EIntegerObject")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.intRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "ELong")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.intRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "ELongObject")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.intRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "EShort")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.intRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "EShortObject")) {
        _matched=true;
        _switchResult = Ecore2XtextExtensions.intRuleBody();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "EString")) {
        _matched=true;
        _switchResult = "STRING | ID";
      }
    }
    if (!_matched) {
      String _name_1 = it.getName();
      String _plus = ("\'" + _name_1);
      _switchResult = (_plus + "\' /* TODO: implement this rule and an appropriate IValueConverter */");
    }
    return _switchResult;
  }
  
  public static String intRuleBody() {
    return "\'-\'? INT";
  }
  
  public static String decimalRuleBody() {
    return "\'-\'? INT? \'.\' INT ((\'E\'|\'e\') \'-\'? INT)?";
  }
  
  public static String booleanRuleBody() {
    return "\'true\' | \'false\'";
  }
  
  public static String assignmentKeyword(final EStructuralFeature it) {
    String _xifexpression = null;
    boolean _isPrefixBooleanFeature = Ecore2XtextExtensions.isPrefixBooleanFeature(it);
    if (_isPrefixBooleanFeature) {
      _xifexpression = "";
    } else {
      String _name = it.getName();
      String _plus = ("\'" + _name);
      _xifexpression = (_plus + "\' ");
    }
    return _xifexpression;
  }
  
  public static String quoteIfNeccesary(final String str) {
    String _xifexpression = null;
    boolean _isXtextKeyword = Ecore2XtextExtensions.isXtextKeyword(str);
    if (_isXtextKeyword) {
      _xifexpression = ("^" + str);
    } else {
      _xifexpression = str;
    }
    return _xifexpression;
  }
  
  public static boolean isXtextKeyword(final String str) {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(
      "returns", 
      "generate", 
      "terminal", 
      "with", 
      "hidden", 
      "enum", 
      "grammar", 
      "import", 
      "as", 
      "current", 
      "fragment", 
      "EOF");
    return _newArrayList.contains(str);
  }
  
  public static EAttribute idAttribute(final EClass it) {
    EAttribute _xblockexpression = null;
    {
      final EAttribute idAttr = Ecore2XtextExtensions.idAttributeInternal(it);
      EAttribute _xifexpression = null;
      boolean _notEquals = (!Objects.equal(idAttr, null));
      if (_notEquals) {
        _xifexpression = idAttr;
      } else {
        EList<EAttribute> _eAllAttributes = it.getEAllAttributes();
        final Function1<EAttribute, Boolean> _function = new Function1<EAttribute, Boolean>() {
          @Override
          public Boolean apply(final EAttribute a) {
            boolean _and = false;
            boolean _and_1 = false;
            boolean _and_2 = false;
            boolean _needsAssignment = Ecore2XtextExtensions.needsAssignment(a);
            if (!_needsAssignment) {
              _and_2 = false;
            } else {
              String _name = a.getName();
              boolean _equals = Objects.equal(_name, "name");
              _and_2 = _equals;
            }
            if (!_and_2) {
              _and_1 = false;
            } else {
              EClassifier _eType = a.getEType();
              String _name_1 = _eType.getName();
              boolean _equals_1 = Objects.equal(_name_1, "EString");
              _and_1 = _equals_1;
            }
            if (!_and_1) {
              _and = false;
            } else {
              boolean _isMany = a.isMany();
              boolean _not = (!_isMany);
              _and = _not;
            }
            return Boolean.valueOf(_and);
          }
        };
        _xifexpression = IterableExtensions.<EAttribute>findFirst(_eAllAttributes, _function);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private static EAttribute idAttributeInternal(final EClass it) {
    EList<EAttribute> _eAllAttributes = it.getEAllAttributes();
    final Function1<EAttribute, Boolean> _function = new Function1<EAttribute, Boolean>() {
      @Override
      public Boolean apply(final EAttribute a) {
        boolean _and = false;
        boolean _needsAssignment = Ecore2XtextExtensions.needsAssignment(a);
        if (!_needsAssignment) {
          _and = false;
        } else {
          boolean _isID = a.isID();
          _and = _isID;
        }
        return Boolean.valueOf(_and);
      }
    };
    return IterableExtensions.<EAttribute>findFirst(_eAllAttributes, _function);
  }
  
  public static boolean isBoolean(final EClassifier it) {
    boolean _and = false;
    boolean _and_1 = false;
    if (!(it instanceof EDataType)) {
      _and_1 = false;
    } else {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("EBoolean", "EBooleanObject");
      String _name = it.getName();
      boolean _contains = _newArrayList.contains(_name);
      _and_1 = _contains;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _isEcoreType = Ecore2XtextExtensions.isEcoreType(it);
      _and = _isEcoreType;
    }
    return _and;
  }
  
  public static boolean isPrefixBooleanFeature(final EStructuralFeature it) {
    boolean _and = false;
    boolean _and_1 = false;
    EClassifier _eType = it.getEType();
    boolean _isBoolean = Ecore2XtextExtensions.isBoolean(_eType);
    if (!_isBoolean) {
      _and_1 = false;
    } else {
      boolean _isMany = it.isMany();
      boolean _not = (!_isMany);
      _and_1 = _not;
    }
    if (!_and_1) {
      _and = false;
    } else {
      String _defaultValueLiteral = it.getDefaultValueLiteral();
      boolean _notEquals = (!Objects.equal(_defaultValueLiteral, "true"));
      _and = _notEquals;
    }
    return _and;
  }
  
  public static boolean isString(final EClassifier it) {
    boolean _and = false;
    boolean _and_1 = false;
    if (!(it instanceof EDataType)) {
      _and_1 = false;
    } else {
      String _name = it.getName();
      boolean _equals = Objects.equal(_name, "EString");
      _and_1 = _equals;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _isEcoreType = Ecore2XtextExtensions.isEcoreType(it);
      _and = _isEcoreType;
    }
    return _and;
  }
  
  public static boolean isEcoreType(final EClassifier it) {
    EPackage _ePackage = it.getEPackage();
    String _nsURI = null;
    if (_ePackage!=null) {
      _nsURI=_ePackage.getNsURI();
    }
    return Objects.equal(_nsURI, "http://www.eclipse.org/emf/2002/Ecore");
  }
  
  public static boolean isID(final EStructuralFeature it) {
    boolean _and = false;
    if (!(it instanceof EAttribute)) {
      _and = false;
    } else {
      EAttribute _cast = EAttribute.class.cast(it);
      boolean _isID = _cast.isID();
      _and = _isID;
    }
    return _and;
  }
  
  public static boolean needsAssignment(final EStructuralFeature it) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    boolean _isDerived = it.isDerived();
    boolean _not = (!_isDerived);
    if (!_not) {
      _and_2 = false;
    } else {
      boolean _isTransient = it.isTransient();
      boolean _not_1 = (!_isTransient);
      _and_2 = _not_1;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      boolean _and_3 = false;
      if (!(it instanceof EReference)) {
        _and_3 = false;
      } else {
        EReference _cast = EReference.class.cast(it);
        boolean _isContainer = _cast.isContainer();
        _and_3 = _isContainer;
      }
      boolean _not_2 = (!_and_3);
      _and_1 = _not_2;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _and_4 = false;
      EClassifier _eType = it.getEType();
      if (!(_eType instanceof EDataType)) {
        _and_4 = false;
      } else {
        EClassifier _eType_1 = it.getEType();
        EDataType _cast_1 = EDataType.class.cast(_eType_1);
        boolean _isSerializable = _cast_1.isSerializable();
        boolean _not_3 = (!_isSerializable);
        _and_4 = _not_3;
      }
      boolean _not_4 = (!_and_4);
      _and = _not_4;
    }
    return _and;
  }
  
  public static boolean needsConcreteRule(final EClassifier eClassifier) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (eClassifier instanceof EClass) {
      _matched=true;
      boolean _and = false;
      boolean _isAbstract = ((EClass)eClassifier).isAbstract();
      boolean _not = (!_isAbstract);
      if (!_not) {
        _and = false;
      } else {
        boolean _isInterface = ((EClass)eClassifier).isInterface();
        boolean _not_1 = (!_isInterface);
        _and = _not_1;
      }
      _switchResult = _and;
    }
    if (!_matched) {
      _switchResult = true;
    }
    return _switchResult;
  }
  
  public static boolean needsDispatcherRule(final EClassifier eClassifier) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (eClassifier instanceof EClass) {
      _matched=true;
      Iterable<EClass> _subClasses = Ecore2XtextExtensions.subClasses(((EClass)eClassifier));
      final Function1<EClass, Boolean> _function = new Function1<EClass, Boolean>() {
        @Override
        public Boolean apply(final EClass c) {
          return Boolean.valueOf(Ecore2XtextExtensions.needsConcreteRule(c));
        }
      };
      Iterable<EClass> _filter = IterableExtensions.<EClass>filter(_subClasses, _function);
      boolean _isEmpty = IterableExtensions.isEmpty(_filter);
      _switchResult = (!_isEmpty);
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  public static boolean isContainment(final EStructuralFeature eStrFeat) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (eStrFeat instanceof EAttribute) {
      _matched=true;
      _switchResult = true;
    }
    if (!_matched) {
      if (eStrFeat instanceof EReference) {
        _matched=true;
        _switchResult = ((EReference)eStrFeat).isContainment();
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  public static Iterable<EClass> subClasses(final EClass it) {
    Iterable<EClass> _xifexpression = null;
    EPackage _ePackage = it.getEPackage();
    boolean _equals = Objects.equal(_ePackage, null);
    if (_equals) {
      _xifexpression = CollectionLiterals.<EClass>emptyList();
    } else {
      EPackage _ePackage_1 = it.getEPackage();
      EList<EClassifier> _eClassifiers = _ePackage_1.getEClassifiers();
      Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
      final Function1<EClass, Boolean> _function = new Function1<EClass, Boolean>() {
        @Override
        public Boolean apply(final EClass c) {
          EList<EClass> _eAllSuperTypes = c.getEAllSuperTypes();
          return Boolean.valueOf(_eAllSuperTypes.contains(it));
        }
      };
      _xifexpression = IterableExtensions.<EClass>filter(_filter, _function);
    }
    return _xifexpression;
  }
  
  public static Iterable<EAttribute> allAttributes(final EClass it) {
    Iterable<EStructuralFeature> _inlinedFeatures = Ecore2XtextExtensions.inlinedFeatures(it);
    return Iterables.<EAttribute>filter(_inlinedFeatures, EAttribute.class);
  }
  
  public static Iterable<EReference> allCrossReferences(final EClass it) {
    Iterable<EStructuralFeature> _inlinedFeatures = Ecore2XtextExtensions.inlinedFeatures(it);
    Iterable<EReference> _filter = Iterables.<EReference>filter(_inlinedFeatures, EReference.class);
    final Function1<EReference, Boolean> _function = new Function1<EReference, Boolean>() {
      @Override
      public Boolean apply(final EReference f) {
        boolean _isContainment = f.isContainment();
        return Boolean.valueOf((!_isContainment));
      }
    };
    return IterableExtensions.<EReference>filter(_filter, _function);
  }
  
  public static Iterable<EReference> allContainmentReferences(final EClass it) {
    Iterable<EStructuralFeature> _inlinedFeatures = Ecore2XtextExtensions.inlinedFeatures(it);
    Iterable<EReference> _filter = Iterables.<EReference>filter(_inlinedFeatures, EReference.class);
    final Function1<EReference, Boolean> _function = new Function1<EReference, Boolean>() {
      @Override
      public Boolean apply(final EReference f) {
        return Boolean.valueOf(f.isContainment());
      }
    };
    return IterableExtensions.<EReference>filter(_filter, _function);
  }
}
