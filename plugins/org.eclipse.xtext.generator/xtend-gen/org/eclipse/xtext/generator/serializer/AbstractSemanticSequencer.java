/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.serializer;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess;
import org.eclipse.xtext.generator.serializer.GeneratedFile;
import org.eclipse.xtext.generator.serializer.JavaEMFFile;
import org.eclipse.xtext.generator.serializer.SemanticSequencerUtil;
import org.eclipse.xtext.generator.serializer.SerializerGenFileNames;
import org.eclipse.xtext.generator.serializer.SerializerGenFileNames.GenFileName;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IFeatureInfo;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class AbstractSemanticSequencer extends GeneratedFile {
  @Inject
  private Grammar grammar;
  
  @Inject
  @Extension
  private GrammarAccess grammarAccess;
  
  @Inject
  @Extension
  private SemanticSequencerUtil sequencerUtil;
  
  @Inject
  private SerializerGenFileNames names;
  
  @Inject
  @Extension
  private Context2NameFunction ctx2name;
  
  public <T extends ENamedElement> List<T> sortByName(final Iterable<T> iterable) {
    final Comparator<T> _function = new Comparator<T>() {
      public int compare(final T p1, final T p2) {
        String _name = p1.getName();
        String _name_1 = p2.getName();
        int _compareTo = _name.compareTo(_name_1);
        return _compareTo;
      }
    };
    List<T> _sort = IterableExtensions.<T>sort(iterable, _function);
    return _sort;
  }
  
  public Iterable<EPackage> getAccessedPackages() {
    Collection<IConstraint> _grammarConstraints = this.sequencerUtil.getGrammarConstraints(this.grammar);
    final Function1<IConstraint,Boolean> _function = new Function1<IConstraint,Boolean>() {
      public Boolean apply(final IConstraint e) {
        EClass _type = e.getType();
        boolean _notEquals = (!Objects.equal(_type, null));
        return Boolean.valueOf(_notEquals);
      }
    };
    Iterable<IConstraint> _filter = IterableExtensions.<IConstraint>filter(_grammarConstraints, _function);
    final Function1<IConstraint,EPackage> _function_1 = new Function1<IConstraint,EPackage>() {
      public EPackage apply(final IConstraint e) {
        EClass _type = e.getType();
        EPackage _ePackage = _type.getEPackage();
        return _ePackage;
      }
    };
    Iterable<EPackage> _map = IterableExtensions.<IConstraint, EPackage>map(_filter, _function_1);
    Set<EPackage> _set = IterableExtensions.<EPackage>toSet(_map);
    List<EPackage> _sortByName = this.<EPackage>sortByName(_set);
    return _sortByName;
  }
  
  public Iterable<EClass> getAccessedClasses(final EPackage pkg) {
    Collection<IConstraint> _grammarConstraints = this.sequencerUtil.getGrammarConstraints(this.grammar);
    final Function1<IConstraint,EClass> _function = new Function1<IConstraint,EClass>() {
      public EClass apply(final IConstraint e) {
        EClass _type = e.getType();
        return _type;
      }
    };
    Iterable<EClass> _map = IterableExtensions.<IConstraint, EClass>map(_grammarConstraints, _function);
    final Function1<EClass,Boolean> _function_1 = new Function1<EClass,Boolean>() {
      public Boolean apply(final EClass e) {
        boolean _and = false;
        boolean _notEquals = (!Objects.equal(e, null));
        if (!_notEquals) {
          _and = false;
        } else {
          EPackage _ePackage = e.getEPackage();
          boolean _equals = Objects.equal(_ePackage, pkg);
          _and = (_notEquals && _equals);
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<EClass> _filter = IterableExtensions.<EClass>filter(_map, _function_1);
    Set<EClass> _set = IterableExtensions.<EClass>toSet(_filter);
    List<EClass> _sortByName = this.<EClass>sortByName(_set);
    return _sortByName;
  }
  
  public Map<IConstraint,List<EObject>> getAccessedConstraints(final EClass clazz) {
    Map<IConstraint,List<EObject>> _grammarConstraints = this.sequencerUtil.getGrammarConstraints(this.grammar, clazz);
    return _grammarConstraints;
  }
  
  public CharSequence getFileContents(final GenFileName filename) {
    String _xblockexpression = null;
    {
      Resource _eResource = this.grammar.eResource();
      ResourceSet _resourceSet = _eResource.getResourceSet();
      String _packageName = filename.getPackageName();
      JavaEMFFile _javaEMFFile = new JavaEMFFile(_resourceSet, _packageName);
      final JavaEMFFile file = _javaEMFFile;
      file.imported(EObject.class);
      file.imported(GenericSequencer.class);
      file.imported(ISemanticSequencer.class);
      file.imported(ITransientValueService.class);
      file.imported(ISemanticSequenceAcceptor.class);
      file.imported(ISemanticSequencerDiagnosticProvider.class);
      file.imported(Acceptor.class);
      file.imported(Inject.class);
      file.imported(Provider.class);
      final Collection<IConstraint> localConstraints = this.sequencerUtil.getGrammarConstraints(this.grammar);
      Grammar _superGrammar = this.sequencerUtil.getSuperGrammar(this.grammar);
      final Collection<IConstraint> superConstraints = this.sequencerUtil.getGrammarConstraints(_superGrammar);
      String _xifexpression = null;
      final Function1<IConstraint,Boolean> _function = new Function1<IConstraint,Boolean>() {
        public Boolean apply(final IConstraint it) {
          boolean _contains = superConstraints.contains(it);
          return Boolean.valueOf(_contains);
        }
      };
      boolean _exists = IterableExtensions.<IConstraint>exists(localConstraints, _function);
      if (_exists) {
        GenFileName _semanticSequencer = this.names.getSemanticSequencer();
        EList<Grammar> _usedGrammars = this.grammar.getUsedGrammars();
        Grammar _head = IterableExtensions.<Grammar>head(_usedGrammars);
        String _qualifiedName = _semanticSequencer.getQualifiedName(_head);
        String _imported = file.imported(_qualifiedName);
        _xifexpression = _imported;
      } else {
        String _imported_1 = file.imported(AbstractDelegatingSemanticSequencer.class);
        _xifexpression = _imported_1;
      }
      final String superGrammar = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isAbstract = filename.isAbstract();
      if (_isAbstract) {
        _xifexpression_1 = "abstract ";
      } else {
        _xifexpression_1 = "";
      }
      final String _abstract = _xifexpression_1;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@SuppressWarnings(\"all\")");
      _builder.newLine();
      _builder.append("public ");
      _builder.append(_abstract, "");
      _builder.append("class ");
      String _simpleName = filename.getSimpleName();
      _builder.append(_simpleName, "");
      _builder.append(" extends ");
      _builder.append(superGrammar, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Inject");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private ");
      String _gaFQName = this.grammarAccess.gaFQName(this.grammar);
      String _imported_2 = file.imported(_gaFQName);
      _builder.append(_imported_2, "\t");
      _builder.append(" grammarAccess;");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _genMethodCreateSequence = this.genMethodCreateSequence(file);
      _builder.append(_genMethodCreateSequence, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      final Function1<IConstraint,Boolean> _function_1 = new Function1<IConstraint,Boolean>() {
        public Boolean apply(final IConstraint e) {
          boolean _and = false;
          EClass _type = e.getType();
          boolean _notEquals = (!Objects.equal(_type, null));
          if (!_notEquals) {
            _and = false;
          } else {
            boolean _contains = superConstraints.contains(e);
            boolean _not = (!_contains);
            _and = (_notEquals && _not);
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterable<IConstraint> _filter = IterableExtensions.<IConstraint>filter(localConstraints, _function_1);
      List<IConstraint> _sort = IterableExtensions.<IConstraint>sort(_filter);
      final Function1<IConstraint,CharSequence> _function_2 = new Function1<IConstraint,CharSequence>() {
        public CharSequence apply(final IConstraint e) {
          CharSequence _genMethodSequence = AbstractSemanticSequencer.this.genMethodSequence(file, e);
          return _genMethodSequence;
        }
      };
      String _join = IterableExtensions.<IConstraint>join(_sort, "\n\n", _function_2);
      _builder.append(_join, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      file.body = _string;
      String _string_1 = file.toString();
      _xblockexpression = (_string_1);
    }
    return _xblockexpression;
  }
  
  public <K extends Object, V extends Object> Map<K,V> toMap(final Iterable<Pair<K,V>> items) {
    HashMap<K,V> _xblockexpression = null;
    {
      final HashMap<K,V> result = CollectionLiterals.<K, V>newHashMap();
      for (final Pair<K,V> i : items) {
        K _key = i.getKey();
        V _value = i.getValue();
        result.put(_key, _value);
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public CharSequence genMethodCreateSequence(final JavaEMFFile file) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void createSequence(EObject context, EObject semanticObject) {");
    _builder.newLine();
    _builder.append("\t");
    Grammar _superGrammar = this.sequencerUtil.getSuperGrammar(this.grammar);
    Collection<IConstraint> _grammarConstraints = this.sequencerUtil.getGrammarConstraints(_superGrammar);
    final Function1<IConstraint,Pair<IConstraint,IConstraint>> _function = new Function1<IConstraint,Pair<IConstraint,IConstraint>>() {
      public Pair<IConstraint,IConstraint> apply(final IConstraint it) {
        Pair<IConstraint,IConstraint> _mappedTo = Pair.<IConstraint, IConstraint>of(it, it);
        return _mappedTo;
      }
    };
    Iterable<Pair<IConstraint,IConstraint>> _map = IterableExtensions.<IConstraint, Pair<IConstraint,IConstraint>>map(_grammarConstraints, _function);
    final Map<IConstraint,IConstraint> superConstraints = this.<IConstraint, IConstraint>toMap(_map);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    int pkgi = 0;
    _builder.newLineIfNotEmpty();
    {
      Iterable<EPackage> _accessedPackages = this.getAccessedPackages();
      for(final EPackage pkg : _accessedPackages) {
        _builder.append("\t");
        {
          int _pkgi = pkgi = (pkgi + 1);
          boolean _greaterThan = (_pkgi > 1);
          if (_greaterThan) {
            _builder.append("else ");
          }
        }
        _builder.append("if(semanticObject.eClass().getEPackage() == ");
        String _importedGenTypeLiteral = file.importedGenTypeLiteral(pkg);
        _builder.append(_importedGenTypeLiteral, "\t");
        _builder.append(") switch(semanticObject.eClass().getClassifierID()) {");
        _builder.newLineIfNotEmpty();
        {
          Iterable<EClass> _accessedClasses = this.getAccessedClasses(pkg);
          for(final EClass type : _accessedClasses) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("case ");
            String _importedGenIntLiteral = file.importedGenIntLiteral(type);
            _builder.append(_importedGenIntLiteral, "\t\t");
            _builder.append(":");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t");
            int ctxi = 0;
            _builder.newLineIfNotEmpty();
            {
              Map<IConstraint,List<EObject>> _accessedConstraints = this.getAccessedConstraints(type);
              Set<Entry<IConstraint,List<EObject>>> _entrySet = _accessedConstraints.entrySet();
              final Function1<Entry<IConstraint,List<EObject>>,String> _function_1 = new Function1<Entry<IConstraint,List<EObject>>,String>() {
                public String apply(final Entry<IConstraint,List<EObject>> e) {
                  IConstraint _key = e.getKey();
                  String _name = _key.getName();
                  return _name;
                }
              };
              List<Entry<IConstraint,List<EObject>>> _sortBy = IterableExtensions.<Entry<IConstraint,List<EObject>>, String>sortBy(_entrySet, _function_1);
              for(final Entry<IConstraint, List<EObject>> ctx : _sortBy) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                {
                  int _ctxi = ctxi = (ctxi + 1);
                  boolean _greaterThan_1 = (_ctxi > 1);
                  if (_greaterThan_1) {
                    _builder.append("else ");
                  }
                }
                _builder.append("if(");
                {
                  List<EObject> _value = ctx.getValue();
                  final Function1<EObject,String> _function_2 = new Function1<EObject,String>() {
                    public String apply(final EObject e) {
                      String _contextName = AbstractSemanticSequencer.this.ctx2name.getContextName(e);
                      return _contextName;
                    }
                  };
                  List<EObject> _sortBy_1 = IterableExtensions.<EObject, String>sortBy(_value, _function_2);
                  boolean _hasElements = false;
                  for(final EObject c : _sortBy_1) {
                    if (!_hasElements) {
                      _hasElements = true;
                    } else {
                      _builder.appendImmediate(" ||\n   ", "\t\t\t");
                    }
                    _builder.append("context == grammarAccess.");
                    String _gaAccessor = this.grammarAccess.gaAccessor(c);
                    _builder.append(_gaAccessor, "\t\t\t");
                  }
                }
                _builder.append(") {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                IConstraint _key = ctx.getKey();
                final IConstraint superConstraint = superConstraints.get(_key);
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                IConstraint _xifexpression = null;
                boolean _equals = Objects.equal(superConstraint, null);
                if (_equals) {
                  IConstraint _key_1 = ctx.getKey();
                  _xifexpression = _key_1;
                } else {
                  _xifexpression = superConstraint;
                }
                final IConstraint constraint = _xifexpression;
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("sequence_");
                String _simpleName = constraint.getSimpleName();
                _builder.append(_simpleName, "\t\t\t\t");
                _builder.append("(context, (");
                String _importedGenTypeName = file.importedGenTypeName(type);
                _builder.append(_importedGenTypeName, "\t\t\t\t");
                _builder.append(") semanticObject); ");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return; ");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("else break;");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence genMethodSequence(final JavaEMFFile file, final IConstraint c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Constraint:");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*     ");
    String _xifexpression = null;
    IConstraintElement _body = c.getBody();
    boolean _equals = Objects.equal(_body, null);
    if (_equals) {
      EClass _type = c.getType();
      String _name = _type.getName();
      String _plus = ("{" + _name);
      String _plus_1 = (_plus + "}");
      _xifexpression = _plus_1;
    } else {
      IConstraintElement _body_1 = c.getBody();
      String _string = _body_1.toString();
      String _replaceAll = _string.replaceAll("\\n", "\n*     ");
      _xifexpression = _replaceAll;
    }
    _builder.append(_xifexpression, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("protected void sequence_");
    String _simpleName = c.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append("(EObject context, ");
    EClass _type_1 = c.getType();
    String _importedGenTypeName = file.importedGenTypeName(_type_1);
    _builder.append(_importedGenTypeName, "");
    _builder.append(" semanticObject) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    EClass _type_2 = c.getType();
    final String cast = file.getEObjectCast(_type_2);
    _builder.newLineIfNotEmpty();
    {
      boolean _canGenerate = this.sequencerUtil.canGenerate(c);
      if (_canGenerate) {
        _builder.append("\t");
        _builder.append("if(errorAcceptor != null) {");
        _builder.newLine();
        {
          IFeatureInfo[] _features = c.getFeatures();
          final Function1<IFeatureInfo,Boolean> _function = new Function1<IFeatureInfo,Boolean>() {
            public Boolean apply(final IFeatureInfo e) {
              boolean _notEquals = (!Objects.equal(e, null));
              return Boolean.valueOf(_notEquals);
            }
          };
          Iterable<IFeatureInfo> _filter = IterableExtensions.<IFeatureInfo>filter(((Iterable<IFeatureInfo>)Conversions.doWrapArray(_features)), _function);
          for(final IFeatureInfo f : _filter) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("if(transientValues.isValueTransient(");
            _builder.append(cast, "\t\t");
            _builder.append("semanticObject, ");
            EStructuralFeature _feature = f.getFeature();
            String _importedGenTypeLiteral = file.importedGenTypeLiteral(_feature);
            _builder.append(_importedGenTypeLiteral, "\t\t");
            _builder.append(") == ");
            String _imported = file.imported(ValueTransient.class);
            _builder.append(_imported, "\t\t");
            _builder.append(".YES)");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(");
            _builder.append(cast, "\t\t\t");
            _builder.append("semanticObject, ");
            EStructuralFeature _feature_1 = f.getFeature();
            String _importedGenTypeLiteral_1 = file.importedGenTypeLiteral(_feature_1);
            _builder.append(_importedGenTypeLiteral_1, "\t\t\t");
            _builder.append("));");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        String _imported_1 = file.imported(INodesForEObjectProvider.class);
        _builder.append(_imported_1, "\t");
        _builder.append(" nodes = createNodeProvider(");
        _builder.append(cast, "\t");
        _builder.append("semanticObject);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _imported_2 = file.imported(SequenceFeeder.class);
        _builder.append(_imported_2, "\t");
        _builder.append(" feeder = createSequencerFeeder(");
        _builder.append(cast, "\t");
        _builder.append("semanticObject, nodes);");
        _builder.newLineIfNotEmpty();
        {
          Iterable<IFeatureInfo> _xifexpression_1 = null;
          IConstraintElement _body_2 = c.getBody();
          IFeatureInfo _featureInfo = _body_2.getFeatureInfo();
          boolean _notEquals = (!Objects.equal(_featureInfo, null));
          if (_notEquals) {
            IConstraintElement _body_3 = c.getBody();
            IFeatureInfo _featureInfo_1 = _body_3.getFeatureInfo();
            ArrayList<IFeatureInfo> _newArrayList = CollectionLiterals.<IFeatureInfo>newArrayList(_featureInfo_1);
            _xifexpression_1 = _newArrayList;
          } else {
            IConstraintElement _body_4 = c.getBody();
            List<IConstraintElement> _children = _body_4.getChildren();
            final Function1<IConstraintElement,Boolean> _function_1 = new Function1<IConstraintElement,Boolean>() {
              public Boolean apply(final IConstraintElement e) {
                IFeatureInfo _featureInfo = e.getFeatureInfo();
                boolean _notEquals = (!Objects.equal(_featureInfo, null));
                return Boolean.valueOf(_notEquals);
              }
            };
            Iterable<IConstraintElement> _filter_1 = IterableExtensions.<IConstraintElement>filter(_children, _function_1);
            final Function1<IConstraintElement,IFeatureInfo> _function_2 = new Function1<IConstraintElement,IFeatureInfo>() {
              public IFeatureInfo apply(final IConstraintElement e) {
                IFeatureInfo _featureInfo = e.getFeatureInfo();
                return _featureInfo;
              }
            };
            Iterable<IFeatureInfo> _map = IterableExtensions.<IConstraintElement, IFeatureInfo>map(_filter_1, _function_2);
            _xifexpression_1 = _map;
          }
          for(final IFeatureInfo f_1 : _xifexpression_1) {
            _builder.append("\t");
            IConstraintElement[] _assignments = f_1.getAssignments();
            final IConstraintElement assignment = _assignments[0];
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("feeder.accept(grammarAccess.");
            AbstractElement _grammarElement = assignment.getGrammarElement();
            String _gaAccessor = this.grammarAccess.gaAccessor(_grammarElement);
            _builder.append(_gaAccessor, "\t");
            _builder.append(", semanticObject.");
            EStructuralFeature _feature_2 = f_1.getFeature();
            String _getAccessor = file.getGetAccessor(_feature_2);
            _builder.append(_getAccessor, "\t");
            _builder.append("());");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("feeder.finish();");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("genericSequencer.createSequence(context, ");
        _builder.append(cast, "\t");
        _builder.append("semanticObject);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
