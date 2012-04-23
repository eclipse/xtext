package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext;

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
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.EPackageInfo;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.Ecore2XtextProjectInfo;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.UniqueNameUtil;

@SuppressWarnings("all")
public class Ecore2XtextExtensions {
  /**
   * cached Collection[EClassifier] allConcreteRuleClassifiers(Ecore2XtextProjectInfo this) :
   *  rootElementClass == null
   * 	? EPackageInfos.EPackage.allReferencedClassifiers(false).flatten().toSet().select(c|c.needsConcreteRule())
   *   : (let c = { rootElementClass } : rootElementClass.allAssignedClassifiers(c) -> c.select(c|c.needsConcreteRule()).toSet());
   */
  public static Iterable<EClassifier> allConcreteRuleClassifiers(final Ecore2XtextProjectInfo it) {
    Iterable<EClassifier> _xifexpression = null;
    EClass _rootElementClass = it.getRootElementClass();
    boolean _equals = Objects.equal(_rootElementClass, null);
    if (_equals) {
      Collection<EPackageInfo> _ePackageInfos = it.getEPackageInfos();
      final Function1<EPackageInfo,Set<EClassifier>> _function = new Function1<EPackageInfo,Set<EClassifier>>() {
          public Set<EClassifier> apply(final EPackageInfo it) {
            EPackage _ePackage = it.getEPackage();
            Set<EClassifier> _allReferencedClassifiers = Ecore2XtextExtensions.allReferencedClassifiers(_ePackage, false);
            return _allReferencedClassifiers;
          }
        };
      Iterable<Set<EClassifier>> _map = IterableExtensions.<EPackageInfo, Set<EClassifier>>map(_ePackageInfos, _function);
      Iterable<EClassifier> _flatten = Iterables.<EClassifier>concat(_map);
      Set<EClassifier> _set = IterableExtensions.<EClassifier>toSet(_flatten);
      final Function1<EClassifier,Boolean> _function_1 = new Function1<EClassifier,Boolean>() {
          public Boolean apply(final EClassifier it) {
            boolean _needsConcreteRule = Ecore2XtextExtensions.needsConcreteRule(it);
            return Boolean.valueOf(_needsConcreteRule);
          }
        };
      Iterable<EClassifier> _filter = IterableExtensions.<EClassifier>filter(_set, _function_1);
      _xifexpression = _filter;
    } else {
      Set<EClassifier> _xblockexpression = null;
      {
        EClass _rootElementClass_1 = it.getRootElementClass();
        EClass _rootElementClass_2 = it.getRootElementClass();
        ArrayList<EClass> _newArrayList = CollectionLiterals.<EClass>newArrayList(_rootElementClass_2);
        final Iterable<EClassifier> cls = Ecore2XtextExtensions.allAssignedClassifiers(_rootElementClass_1, _newArrayList);
        final Function1<EClassifier,Boolean> _function_2 = new Function1<EClassifier,Boolean>() {
            public Boolean apply(final EClassifier c) {
              boolean _needsConcreteRule = Ecore2XtextExtensions.needsConcreteRule(c);
              return Boolean.valueOf(_needsConcreteRule);
            }
          };
        Iterable<EClassifier> _filter_1 = IterableExtensions.<EClassifier>filter(cls, _function_2);
        Set<EClassifier> _set_1 = IterableExtensions.<EClassifier>toSet(_filter_1);
        _xblockexpression = (_set_1);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  /**
   * cached Collection[EPackage] allReferencedEPackages(Ecore2XtextProjectInfo this) :
   * 	EPackageInfos.EPackage.allReferencedEPackages(true).flatten().toSet();
   */
  public static Collection<EPackage> allReferencedEPackages(final Ecore2XtextProjectInfo prjInfo) {
    Collection<EPackageInfo> _ePackageInfos = prjInfo.getEPackageInfos();
    final Function1<EPackageInfo,Set<EPackage>> _function = new Function1<EPackageInfo,Set<EPackage>>() {
        public Set<EPackage> apply(final EPackageInfo it) {
          EPackage _ePackage = it.getEPackage();
          Set<EPackage> _allReferencedEPackages = Ecore2XtextExtensions.allReferencedEPackages(_ePackage, true);
          return _allReferencedEPackages;
        }
      };
    Iterable<Set<EPackage>> _map = IterableExtensions.<EPackageInfo, Set<EPackage>>map(_ePackageInfos, _function);
    Iterable<EPackage> _flatten = Iterables.<EPackage>concat(_map);
    Set<EPackage> _set = IterableExtensions.<EPackage>toSet(_flatten);
    return _set;
  }
  
  /**
   * private cached Collection[EPackage] allReferencedEPackages(EPackage this, boolean includeCrossRefs) :
   *  allReferencedClassifiers(includeCrossRefs).EPackage.toSet();
   */
  public static Set<EPackage> allReferencedEPackages(final EPackage ePack, final boolean includeCrossRefs) {
    Set<EClassifier> _allReferencedClassifiers = Ecore2XtextExtensions.allReferencedClassifiers(ePack, includeCrossRefs);
    final Function1<EClassifier,EPackage> _function = new Function1<EClassifier,EPackage>() {
        public EPackage apply(final EClassifier it) {
          EPackage _ePackage = it.getEPackage();
          return _ePackage;
        }
      };
    Iterable<EPackage> _map = IterableExtensions.<EClassifier, EPackage>map(_allReferencedClassifiers, _function);
    Set<EPackage> _set = IterableExtensions.<EPackage>toSet(_map);
    return _set;
  }
  
  public static Set<EClassifier> allReferencedClassifiers(final EPackage ePack, final boolean includeCrossRefs) {
    EList<EClassifier> _eClassifiers = ePack.getEClassifiers();
    Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
    final Function1<EClass,Iterable<EStructuralFeature>> _function = new Function1<EClass,Iterable<EStructuralFeature>>() {
        public Iterable<EStructuralFeature> apply(final EClass it) {
          EList<EStructuralFeature> _eAllStructuralFeatures = it.getEAllStructuralFeatures();
          final Function1<EStructuralFeature,Boolean> _function = new Function1<EStructuralFeature,Boolean>() {
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
                    _or = (includeCrossRefs || _isContainment);
                  }
                  _and = (_needsAssignment && _or);
                }
                return Boolean.valueOf(_and);
              }
            };
          Iterable<EStructuralFeature> _filter = IterableExtensions.<EStructuralFeature>filter(_eAllStructuralFeatures, _function);
          return _filter;
        }
      };
    final Iterable<Iterable<EStructuralFeature>> strFeatures = IterableExtensions.<EClass, Iterable<EStructuralFeature>>map(_filter, _function);
    Iterable<EStructuralFeature> _flatten = Iterables.<EStructuralFeature>concat(strFeatures);
    final Function1<EStructuralFeature,EClassifier> _function_1 = new Function1<EStructuralFeature,EClassifier>() {
        public EClassifier apply(final EStructuralFeature it) {
          EClassifier _eType = it.getEType();
          return _eType;
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
  
  /**
   * private cached allAssignedClassifiers(EClass this, Collection acceptor) :
   * (let classifiers = (EAllStructuralFeatures.select(f|f.needsAssignment()).EType).union(subClasses()).removeAll(acceptor) :
   * classifiers.isEmpty
   * ? null
   * : (acceptor.addAll(classifiers) ->
   * classifiers.typeSelect(EClass).collect(c|c.allAssignedClassifiers(acceptor))));
   */
  private static Iterable<EClassifier> allAssignedClassifiers(final EClass it, final Collection acceptor) {
    EList<EStructuralFeature> _eAllStructuralFeatures = it.getEAllStructuralFeatures();
    final Function1<EStructuralFeature,Boolean> _function = new Function1<EStructuralFeature,Boolean>() {
        public Boolean apply(final EStructuralFeature f) {
          boolean _needsAssignment = Ecore2XtextExtensions.needsAssignment(f);
          return Boolean.valueOf(_needsAssignment);
        }
      };
    Iterable<EStructuralFeature> _filter = IterableExtensions.<EStructuralFeature>filter(_eAllStructuralFeatures, _function);
    final Function1<EStructuralFeature,EClassifier> _function_1 = new Function1<EStructuralFeature,EClassifier>() {
        public EClassifier apply(final EStructuralFeature it) {
          EClassifier _eType = it.getEType();
          return _eType;
        }
      };
    Iterable<EClassifier> _map = IterableExtensions.<EStructuralFeature, EClassifier>map(_filter, _function_1);
    final List<EClassifier> classifiers = IterableExtensions.<EClassifier>toList(_map);
    Iterable<EClass> _subClasses = Ecore2XtextExtensions.subClasses(it);
    Iterables.<EClassifier>addAll(classifiers, _subClasses);
    classifiers.removeAll(acceptor);
    boolean _isEmpty = classifiers.isEmpty();
    if (_isEmpty) {
      return null;
    } else {
      Iterables.<EClassifier>addAll(acceptor, classifiers);
      Iterable<EClass> _filter_1 = Iterables.<EClass>filter(classifiers, EClass.class);
      final Function1<EClass,Iterable<EClassifier>> _function_2 = new Function1<EClass,Iterable<EClassifier>>() {
          public Iterable<EClassifier> apply(final EClass c) {
            Iterable<EClassifier> _allAssignedClassifiers = Ecore2XtextExtensions.allAssignedClassifiers(c, acceptor);
            return _allAssignedClassifiers;
          }
        };
      Iterable<Iterable<EClassifier>> _map_1 = IterableExtensions.<EClass, Iterable<EClassifier>>map(_filter_1, _function_2);
      return Iterables.<EClassifier>concat(_map_1);
    }
  }
  
  public static String fqn(final EClassifier it) {
    String _xifexpression = null;
    EPackage _ePackage = it.getEPackage();
    String _uniqueName = UniqueNameUtil.uniqueName(_ePackage);
    boolean _equals = Objects.equal(_uniqueName, null);
    if (_equals) {
      String _name = it.getName();
      String _quoteIfNeccesary = Ecore2XtextExtensions.quoteIfNeccesary(_name);
      _xifexpression = _quoteIfNeccesary;
    } else {
      EPackage _ePackage_1 = it.getEPackage();
      String _uniqueName_1 = UniqueNameUtil.uniqueName(_ePackage_1);
      String _plus = (_uniqueName_1 + "::");
      String _name_1 = it.getName();
      String _quoteIfNeccesary_1 = Ecore2XtextExtensions.quoteIfNeccesary(_name_1);
      String _plus_1 = (_plus + _quoteIfNeccesary_1);
      _xifexpression = _plus_1;
    }
    return _xifexpression;
  }
  
  /**
   * Void resetUniqueNames(EPackageInfo defaultPackageInfo):
   * JAVA org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.UniqueNameUtil.clearUniqueNames(org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.EPackageInfo);
   * 
   * String uniqueName(ENamedElement this):
   * JAVA org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.UniqueNameUtil.uniqueName(org.eclipse.emf.ecore.ENamedElement);
   * 
   * String uniqueImplName(ENamedElement this):
   * JAVA org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.UniqueNameUtil.uniqueImplName(org.eclipse.emf.ecore.ENamedElement);
   * 
   * cached prefixFeatures(EClass this) :
   * EAllStructuralFeatures.select(f|f.needsAssignment() && f.isPrefixBooleanFeature());
   * 
   * cached inlinedFeatures(EClass this) :
   * EAllStructuralFeatures.select(f|f.needsAssignment()).remove(idAttribute()).removeAll(prefixFeatures());
   * 
   * cached onlyOptionalFeatures(EClass this) :
   * prefixFeatures().union(inlinedFeatures()).select(f|f.required).isEmpty;
   * 
   * assignedRuleCall(EAttribute this):
   * (isPrefixBooleanFeature()) ? "'"+name+"'" : EType.uniqueName();
   * 
   * concreteRuleName(EClass this):
   * needsDispatcherRule()? uniqueImplName() : uniqueName();
   */
  public static String dataTypeRuleBody(final EDataType it) {
    String _switchResult = null;
    String _name = it.getName();
    final String getName = _name;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(getName,"EBigDecimal")) {
        _matched=true;
        _switchResult = "INT? \'.\' INT";
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EBigInteger")) {
        _matched=true;
        String _intRuleBody = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EBoolean")) {
        _matched=true;
        String _booleanRuleBody = Ecore2XtextExtensions.booleanRuleBody();
        _switchResult = _booleanRuleBody;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EBooleanObject")) {
        _matched=true;
        String _booleanRuleBody_1 = Ecore2XtextExtensions.booleanRuleBody();
        _switchResult = _booleanRuleBody_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EByte")) {
        _matched=true;
        String _intRuleBody_1 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EByteObject")) {
        _matched=true;
        String _intRuleBody_2 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_2;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EChar")) {
        _matched=true;
        String _intRuleBody_3 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_3;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"ECharObject")) {
        _matched=true;
        String _intRuleBody_4 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_4;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EDouble")) {
        _matched=true;
        String _decimalRuleBody = Ecore2XtextExtensions.decimalRuleBody();
        _switchResult = _decimalRuleBody;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EDoubleObject")) {
        _matched=true;
        String _decimalRuleBody_1 = Ecore2XtextExtensions.decimalRuleBody();
        _switchResult = _decimalRuleBody_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EFloat")) {
        _matched=true;
        String _decimalRuleBody_2 = Ecore2XtextExtensions.decimalRuleBody();
        _switchResult = _decimalRuleBody_2;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EFloatObject")) {
        _matched=true;
        String _decimalRuleBody_3 = Ecore2XtextExtensions.decimalRuleBody();
        _switchResult = _decimalRuleBody_3;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EInt")) {
        _matched=true;
        String _intRuleBody_5 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_5;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EIntegerObject")) {
        _matched=true;
        String _intRuleBody_6 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_6;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"ELong")) {
        _matched=true;
        String _intRuleBody_7 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_7;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"ELongObject")) {
        _matched=true;
        String _intRuleBody_8 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_8;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EShort")) {
        _matched=true;
        String _intRuleBody_9 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_9;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EShortObject")) {
        _matched=true;
        String _intRuleBody_10 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_10;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EString")) {
        _matched=true;
        _switchResult = "STRING | ID";
      }
    }
    if (!_matched) {
      String _name_1 = it.getName();
      String _plus = ("\'" + _name_1);
      String _plus_1 = (_plus + "\' // TODO: implement this rule and an appropriate IValueConverter ");
      _switchResult = _plus_1;
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
  
  /**
   * quoteIfNeccesary(String this) :
   * isXtextKeyword() ? '^' + this : this;
   */
  public static String quoteIfNeccesary(final String str) {
    String _xifexpression = null;
    boolean _isXtextKeyword = Ecore2XtextExtensions.isXtextKeyword(str);
    if (_isXtextKeyword) {
      String _plus = ("^" + str);
      _xifexpression = _plus;
    } else {
      _xifexpression = str;
    }
    return _xifexpression;
  }
  
  public static boolean isXtextKeyword(final String str) {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("ML_COMMENT", "ID", "WS", "INT", "STRING", "ANY_OTHER", "SL_COMMENT", 
      "returns", "generate", "terminal", "with", "hidden", "enum", "grammar", 
      "import", "as", "current", "fragment", "EOF");
    boolean _contains = _newArrayList.contains(str);
    return _contains;
  }
  
  /**
   * idAttribute(EClass this) :
   * idAttributeInternal() != null ? idAttributeInternal() : EAllAttributes.selectFirst(a|a.needsAssignment() && a.name == 'name' && a.EType.name=="EString" && !a.many);
   * 
   * private idAttributeInternal(EClass this) :
   * EAllAttributes.selectFirst(a|a.needsAssignment() && a.ID);
   * 
   * isBoolean(EClassifier this) :
   * EDataType.isInstance(this) && {'EBoolean', 'EBooleanObject'}.contains(name) && isEcoreType();
   * 
   * isPrefixBooleanFeature(EStructuralFeature this) :
   * EType.isBoolean() && !many && defaultValueLiteral != "true";
   * 
   * isString(EClassifier this) :
   * EDataType.isInstance(this) && name == 'EString' && isEcoreType();
   * 
   * isEcoreType(EClassifier this) :
   * EPackage.nsURI == "http://www.eclipse.org/emf/2002/Ecore";
   * 
   * isID(EStructuralFeature this) :
   * EAttribute.isInstance({this}) && ((EAttribute)this).ID;
   */
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
      _and_2 = (_not && _not_1);
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
        _and_3 = ((it instanceof EReference) && _isContainer);
      }
      boolean _not_2 = (!_and_3);
      _and_1 = (_and_2 && _not_2);
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _and_4 = false;
      EClassifier _eType = it.getEType();
      if (!(_eType instanceof EDataType)) {
        _and_4 = false;
      } else {
        EDataType _cast_1 = EDataType.class.cast(it);
        boolean _isSerializable = _cast_1.isSerializable();
        boolean _not_3 = (!_isSerializable);
        _and_4 = ((_eType instanceof EDataType) && _not_3);
      }
      boolean _not_4 = (!_and_4);
      _and = (_and_1 && _not_4);
    }
    return _and;
  }
  
  /**
   * boolean needsConcreteRule(EClass this) :
   * 	!abstract && !interface;
   */
  public static boolean needsConcreteRule(final EClassifier it) {
    boolean _xblockexpression = false;
    {
      if ((it instanceof EClass)) {
        final EClass eClazz = EClass.class.cast(it);
        boolean _and = false;
        boolean _isAbstract = eClazz.isAbstract();
        boolean _not = (!_isAbstract);
        if (!_not) {
          _and = false;
        } else {
          boolean _isInterface = eClazz.isInterface();
          boolean _not_1 = (!_isInterface);
          _and = (_not && _not_1);
        }
      }
      _xblockexpression = (true);
    }
    return _xblockexpression;
  }
  
  /**
   * isContainment(EStructuralFeature this) : false;
   * isContainment(EAttribute this) : true;
   * isContainment(EReference this) : containment;
   */
  public static boolean isContainment(final EStructuralFeature eStrFeat) {
    if ((eStrFeat instanceof EAttribute)) {
      return true;
    } else {
      if ((eStrFeat instanceof EReference)) {
        EReference _cast = EReference.class.cast(eStrFeat);
        return _cast.isContainment();
      } else {
        return false;
      }
    }
  }
  
  public static Iterable<EClass> subClasses(final EClass it) {
    EPackage _ePackage = it.getEPackage();
    EList<EClassifier> _eClassifiers = _ePackage.getEClassifiers();
    Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
    final Function1<EClass,Boolean> _function = new Function1<EClass,Boolean>() {
        public Boolean apply(final EClass c) {
          EList<EClass> _eAllSuperTypes = c.getEAllSuperTypes();
          boolean _contains = _eAllSuperTypes.contains(it);
          return Boolean.valueOf(_contains);
        }
      };
    Iterable<EClass> _filter_1 = IterableExtensions.<EClass>filter(_filter, _function);
    return _filter_1;
  }
}
