/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard.ecore2xtext;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
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
import org.eclipse.xtext.xtext.wizard.EPackageInfo;
import org.eclipse.xtext.xtext.wizard.Ecore2XtextConfiguration;
import org.eclipse.xtext.xtext.wizard.ecore2xtext.UniqueNameUtil;

@SuppressWarnings("all")
public class Ecore2XtextExtensions {
  public static Iterable<EClassifier> allConcreteRuleClassifiers(final Ecore2XtextConfiguration it) {
    Iterable<EClassifier> _xifexpression = null;
    EClass _rootElementClass = it.getRootElementClass();
    boolean _tripleEquals = (_rootElementClass == null);
    if (_tripleEquals) {
      final Function1<EPackageInfo, Set<EClassifier>> _function = (EPackageInfo it_1) -> {
        return Ecore2XtextExtensions.allReferencedClassifiers(it_1.getEPackage(), false);
      };
      final Function1<EClassifier, Boolean> _function_1 = (EClassifier it_1) -> {
        return Boolean.valueOf(Ecore2XtextExtensions.needsConcreteRule(it_1));
      };
      _xifexpression = IterableExtensions.<EClassifier>filter(IterableExtensions.<EClassifier>toSet(Iterables.<EClassifier>concat(IterableExtensions.<EPackageInfo, Set<EClassifier>>map(it.getEPackageInfos(), _function))), _function_1);
    } else {
      Set<EClassifier> _xblockexpression = null;
      {
        final ArrayList<EClassifier> c = CollectionLiterals.<EClassifier>newArrayList(EClassifier.class.cast(it.getRootElementClass()));
        Ecore2XtextExtensions.allAssignedClassifiers(it.getRootElementClass(), c);
        final Function1<EClassifier, Boolean> _function_2 = (EClassifier cl) -> {
          return Boolean.valueOf(Ecore2XtextExtensions.needsConcreteRule(cl));
        };
        _xblockexpression = IterableExtensions.<EClassifier>toSet(IterableExtensions.<EClassifier>filter(c, _function_2));
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public static Collection<EClass> allDispatcherRuleClasses(final Ecore2XtextConfiguration it) {
    Set<EClass> _xifexpression = null;
    EClass _rootElementClass = it.getRootElementClass();
    boolean _tripleEquals = (_rootElementClass == null);
    if (_tripleEquals) {
      final Function1<EPackageInfo, Set<EClassifier>> _function = (EPackageInfo it_1) -> {
        return Ecore2XtextExtensions.allReferencedClassifiers(it_1.getEPackage(), false);
      };
      final Function1<EClassifier, Boolean> _function_1 = (EClassifier c) -> {
        return Boolean.valueOf(Ecore2XtextExtensions.needsDispatcherRule(c));
      };
      _xifexpression = IterableExtensions.<EClass>toSet(Iterables.<EClass>filter(IterableExtensions.<EClassifier>filter(IterableExtensions.<EClassifier>toSet(Iterables.<EClassifier>concat(IterableExtensions.<EPackageInfo, Set<EClassifier>>map(it.getEPackageInfos(), _function))), _function_1), EClass.class));
    } else {
      final Function1<EClass, Iterable<EClassifier>> _function_2 = (EClass c) -> {
        final Function1<EReference, Boolean> _function_3 = (EReference r) -> {
          return Boolean.valueOf(Ecore2XtextExtensions.needsAssignment(r));
        };
        final Function1<EReference, EClassifier> _function_4 = (EReference it_1) -> {
          return it_1.getEType();
        };
        return IterableExtensions.<EReference, EClassifier>map(IterableExtensions.<EReference>filter(c.getEAllReferences(), _function_3), _function_4);
      };
      _xifexpression = IterableExtensions.<EClass>toSet(Iterables.<EClass>filter((Iterables.<EClassifier>concat(IterableExtensions.<EClass, Iterable<EClassifier>>map(Iterables.<EClass>filter(Ecore2XtextExtensions.allConcreteRuleClassifiers(it), EClass.class), _function_2))), EClass.class));
    }
    return _xifexpression;
  }
  
  public static Collection<EPackage> allReferencedEPackages(final Ecore2XtextConfiguration prjInfo) {
    final Function1<EPackageInfo, Set<EPackage>> _function = (EPackageInfo it) -> {
      return Ecore2XtextExtensions.allReferencedEPackages(it.getEPackage(), true);
    };
    return IterableExtensions.<EPackage>toSet(Iterables.<EPackage>concat(IterableExtensions.<EPackageInfo, Set<EPackage>>map(prjInfo.getEPackageInfos(), _function)));
  }
  
  public static Set<EPackage> allReferencedEPackages(final EPackage ePack, final boolean includeCrossRefs) {
    final Function1<EClassifier, EPackage> _function = (EClassifier it) -> {
      return it.getEPackage();
    };
    return IterableExtensions.<EPackage>toSet(IterableExtensions.<EPackage>filterNull(IterableExtensions.<EClassifier, EPackage>map(Ecore2XtextExtensions.allReferencedClassifiers(ePack, includeCrossRefs), _function)));
  }
  
  public static Set<EClassifier> allReferencedClassifiers(final EPackage ePack, final boolean includeCrossRefs) {
    final Function1<EClass, Iterable<EStructuralFeature>> _function = (EClass it) -> {
      final Function1<EStructuralFeature, Boolean> _function_1 = (EStructuralFeature f) -> {
        return Boolean.valueOf((Ecore2XtextExtensions.needsAssignment(f) && (includeCrossRefs || Ecore2XtextExtensions.isContainment(f))));
      };
      return IterableExtensions.<EStructuralFeature>filter(it.getEAllStructuralFeatures(), _function_1);
    };
    final Iterable<Iterable<EStructuralFeature>> strFeatures = IterableExtensions.<EClass, Iterable<EStructuralFeature>>map(Iterables.<EClass>filter(ePack.getEClassifiers(), EClass.class), _function);
    final Function1<EStructuralFeature, EClassifier> _function_1 = (EStructuralFeature it) -> {
      return it.getEType();
    };
    final Set<EClassifier> refTypes = IterableExtensions.<EClassifier>toSet(IterableExtensions.<EStructuralFeature, EClassifier>map(Iterables.<EStructuralFeature>concat(strFeatures), _function_1));
    EList<EClassifier> _eClassifiers = ePack.getEClassifiers();
    final Set<EClassifier> retVal = IterableExtensions.<EClassifier>toSet(Iterables.<EClassifier>concat(_eClassifiers, refTypes));
    retVal.add(UniqueNameUtil.eString());
    return retVal;
  }
  
  private static void allAssignedClassifiers(final EClass eClazz, final Collection<EClassifier> acceptor) {
    final Function1<EStructuralFeature, Boolean> _function = (EStructuralFeature f) -> {
      return Boolean.valueOf(Ecore2XtextExtensions.needsAssignment(f));
    };
    final Function1<EStructuralFeature, EClassifier> _function_1 = (EStructuralFeature it) -> {
      return it.getEType();
    };
    final List<EClassifier> classifiers = IterableExtensions.<EClassifier>toList(IterableExtensions.<EStructuralFeature, EClassifier>map(IterableExtensions.<EStructuralFeature>filter(eClazz.getEAllStructuralFeatures(), _function), _function_1));
    Iterable<EClass> _subClasses = Ecore2XtextExtensions.subClasses(eClazz);
    Iterables.<EClassifier>addAll(classifiers, _subClasses);
    classifiers.removeAll(acceptor);
    boolean _isEmpty = classifiers.isEmpty();
    if (_isEmpty) {
      return;
    } else {
      Iterables.<EClassifier>addAll(acceptor, classifiers);
      final Consumer<EClass> _function_2 = (EClass c) -> {
        Ecore2XtextExtensions.allAssignedClassifiers(c, acceptor);
      };
      Iterables.<EClass>filter(classifiers, EClass.class).forEach(_function_2);
    }
  }
  
  public static String fqn(final EClassifier it) {
    String _xifexpression = null;
    EPackage _ePackage = it.getEPackage();
    String _uniqueName = null;
    if (_ePackage!=null) {
      _uniqueName=UniqueNameUtil.uniqueName(_ePackage);
    }
    boolean _tripleEquals = (_uniqueName == null);
    if (_tripleEquals) {
      _xifexpression = Ecore2XtextExtensions.quoteIfNeccesary(it.getName());
    } else {
      String _uniqueName_1 = UniqueNameUtil.uniqueName(it.getEPackage());
      String _plus = (_uniqueName_1 + "::");
      String _quoteIfNeccesary = Ecore2XtextExtensions.quoteIfNeccesary(it.getName());
      _xifexpression = (_plus + _quoteIfNeccesary);
    }
    return _xifexpression;
  }
  
  public static Iterable<EStructuralFeature> prefixFeatures(final EClass it) {
    final Function1<EStructuralFeature, Boolean> _function = (EStructuralFeature f) -> {
      return Boolean.valueOf((Ecore2XtextExtensions.needsAssignment(f) && Ecore2XtextExtensions.isPrefixBooleanFeature(f)));
    };
    return IterableExtensions.<EStructuralFeature>filter(it.getEAllStructuralFeatures(), _function);
  }
  
  public static Iterable<EStructuralFeature> inlinedFeatures(final EClass it) {
    final Function1<EStructuralFeature, Boolean> _function = (EStructuralFeature f) -> {
      return Boolean.valueOf(Ecore2XtextExtensions.needsAssignment(f));
    };
    final List<EStructuralFeature> features = IterableExtensions.<EStructuralFeature>toList(IterableExtensions.<EStructuralFeature>filter(it.getEAllStructuralFeatures(), _function));
    features.remove(Ecore2XtextExtensions.idAttribute(it));
    features.removeAll(IterableExtensions.<EStructuralFeature>toList(Ecore2XtextExtensions.prefixFeatures(it)));
    return features;
  }
  
  public static boolean onlyOptionalFeatures(final EClass it) {
    boolean _xblockexpression = false;
    {
      Iterable<EStructuralFeature> _prefixFeatures = Ecore2XtextExtensions.prefixFeatures(it);
      Iterable<EStructuralFeature> _inlinedFeatures = Ecore2XtextExtensions.inlinedFeatures(it);
      final Iterable<EStructuralFeature> features = Iterables.<EStructuralFeature>concat(_prefixFeatures, _inlinedFeatures);
      final Function1<EStructuralFeature, Boolean> _function = (EStructuralFeature f) -> {
        return Boolean.valueOf(f.isRequired());
      };
      _xblockexpression = IterableExtensions.isEmpty(IterableExtensions.<EStructuralFeature>filter(features, _function));
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
      _xifexpression = UniqueNameUtil.uniqueName(it.getEType());
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
    if (_name != null) {
      switch (_name) {
        case "EBigDecimal":
          _switchResult = "INT? \'.\' INT";
          break;
        case "EBigInteger":
          _switchResult = Ecore2XtextExtensions.intRuleBody();
          break;
        case "EBoolean":
          _switchResult = Ecore2XtextExtensions.booleanRuleBody();
          break;
        case "EBooleanObject":
          _switchResult = Ecore2XtextExtensions.booleanRuleBody();
          break;
        case "EByte":
          _switchResult = Ecore2XtextExtensions.intRuleBody();
          break;
        case "EByteObject":
          _switchResult = Ecore2XtextExtensions.intRuleBody();
          break;
        case "EChar":
          _switchResult = Ecore2XtextExtensions.intRuleBody();
          break;
        case "ECharObject":
          _switchResult = Ecore2XtextExtensions.intRuleBody();
          break;
        case "EDouble":
          _switchResult = Ecore2XtextExtensions.decimalRuleBody();
          break;
        case "EDoubleObject":
          _switchResult = Ecore2XtextExtensions.decimalRuleBody();
          break;
        case "EFloat":
          _switchResult = Ecore2XtextExtensions.decimalRuleBody();
          break;
        case "EFloatObject":
          _switchResult = Ecore2XtextExtensions.decimalRuleBody();
          break;
        case "EInt":
          _switchResult = Ecore2XtextExtensions.intRuleBody();
          break;
        case "EIntegerObject":
          _switchResult = Ecore2XtextExtensions.intRuleBody();
          break;
        case "ELong":
          _switchResult = Ecore2XtextExtensions.intRuleBody();
          break;
        case "ELongObject":
          _switchResult = Ecore2XtextExtensions.intRuleBody();
          break;
        case "EShort":
          _switchResult = Ecore2XtextExtensions.intRuleBody();
          break;
        case "EShortObject":
          _switchResult = Ecore2XtextExtensions.intRuleBody();
          break;
        case "EString":
          _switchResult = "STRING | ID";
          break;
        default:
          String _name_1 = it.getName();
          String _plus = ("\'" + _name_1);
          _switchResult = (_plus + "\' /* TODO: implement this rule and an appropriate IValueConverter */");
          break;
      }
    } else {
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
    return CollectionLiterals.<String>newArrayList(
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
      "EOF").contains(str);
  }
  
  public static EAttribute idAttribute(final EClass it) {
    EAttribute _xblockexpression = null;
    {
      final EAttribute idAttr = Ecore2XtextExtensions.idAttributeInternal(it);
      EAttribute _xifexpression = null;
      if ((idAttr != null)) {
        _xifexpression = idAttr;
      } else {
        final Function1<EAttribute, Boolean> _function = (EAttribute a) -> {
          return Boolean.valueOf((((Ecore2XtextExtensions.needsAssignment(a) && Objects.equal(a.getName(), "name")) && Objects.equal(a.getEType().getName(), "EString")) && (!a.isMany())));
        };
        _xifexpression = IterableExtensions.<EAttribute>findFirst(it.getEAllAttributes(), _function);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private static EAttribute idAttributeInternal(final EClass it) {
    final Function1<EAttribute, Boolean> _function = (EAttribute a) -> {
      return Boolean.valueOf((Ecore2XtextExtensions.needsAssignment(a) && a.isID()));
    };
    return IterableExtensions.<EAttribute>findFirst(it.getEAllAttributes(), _function);
  }
  
  public static boolean isBoolean(final EClassifier it) {
    return (((it instanceof EDataType) && CollectionLiterals.<String>newArrayList("EBoolean", "EBooleanObject").contains(it.getName())) && Ecore2XtextExtensions.isEcoreType(it));
  }
  
  public static boolean isPrefixBooleanFeature(final EStructuralFeature it) {
    return ((Ecore2XtextExtensions.isBoolean(it.getEType()) && (!it.isMany())) && (!Objects.equal(it.getDefaultValueLiteral(), "true")));
  }
  
  public static boolean isString(final EClassifier it) {
    return (((it instanceof EDataType) && Objects.equal(it.getName(), "EString")) && Ecore2XtextExtensions.isEcoreType(it));
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
    return ((it instanceof EAttribute) && EAttribute.class.cast(it).isID());
  }
  
  public static boolean needsAssignment(final EStructuralFeature it) {
    return ((((!it.isDerived()) && (!it.isTransient())) && (!((it instanceof EReference) && EReference.class.cast(it).isContainer()))) && 
      (!((it.getEType() instanceof EDataType) && (!EDataType.class.cast(it.getEType()).isSerializable()))));
  }
  
  public static boolean needsConcreteRule(final EClassifier eClassifier) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (eClassifier instanceof EClass) {
      _matched=true;
      _switchResult = ((!((EClass)eClassifier).isAbstract()) && (!((EClass)eClassifier).isInterface()));
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
      final Function1<EClass, Boolean> _function = (EClass c) -> {
        return Boolean.valueOf(Ecore2XtextExtensions.needsConcreteRule(c));
      };
      boolean _isEmpty = IterableExtensions.isEmpty(IterableExtensions.<EClass>filter(Ecore2XtextExtensions.subClasses(((EClass)eClassifier)), _function));
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
    boolean _tripleEquals = (_ePackage == null);
    if (_tripleEquals) {
      _xifexpression = CollectionLiterals.<EClass>emptyList();
    } else {
      final Function1<EClass, Boolean> _function = (EClass c) -> {
        return Boolean.valueOf(c.getEAllSuperTypes().contains(it));
      };
      _xifexpression = IterableExtensions.<EClass>filter(Iterables.<EClass>filter(it.getEPackage().getEClassifiers(), EClass.class), _function);
    }
    return _xifexpression;
  }
  
  public static Iterable<EAttribute> allAttributes(final EClass it) {
    return Iterables.<EAttribute>filter(Ecore2XtextExtensions.inlinedFeatures(it), EAttribute.class);
  }
  
  public static Iterable<EReference> allCrossReferences(final EClass it) {
    final Function1<EReference, Boolean> _function = (EReference f) -> {
      boolean _isContainment = f.isContainment();
      return Boolean.valueOf((!_isContainment));
    };
    return IterableExtensions.<EReference>filter(Iterables.<EReference>filter(Ecore2XtextExtensions.inlinedFeatures(it), EReference.class), _function);
  }
  
  public static Iterable<EReference> allContainmentReferences(final EClass it) {
    final Function1<EReference, Boolean> _function = (EReference f) -> {
      return Boolean.valueOf(f.isContainment());
    };
    return IterableExtensions.<EReference>filter(Iterables.<EReference>filter(Ecore2XtextExtensions.inlinedFeatures(it), EReference.class), _function);
  }
}
