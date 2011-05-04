package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.GenModelAccess;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess;
import org.eclipse.xtext.generator.serializer.GeneratedFile;
import org.eclipse.xtext.generator.serializer.SemanticSequencer;
import org.eclipse.xtext.generator.serializer.SemanticSequencerUtil;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.ConstraintElementType;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IFeatureInfo;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class AbstractSemanticSequencer extends GeneratedFile {
  @Inject private Grammar grammar;
  @Inject private GrammarAccess grammarAccess;
  @Inject private SemanticSequencerUtil sequencerUtil;
  @Inject private SemanticSequencer sequencer;
  
  public String getQualifiedName(final Grammar grammar) {
    String _name = this.getName(grammar, "Abstract", "SemanticSequencer");
    return _name;
  }
  
  public Iterable<EPackage> getAccessedPackages() {
    Collection<IConstraint> _grammarConstraints = this.sequencerUtil.getGrammarConstraints(this.grammar);
    final Function1<IConstraint,Boolean> _function = new Function1<IConstraint,Boolean>() {
        public Boolean apply(final IConstraint e) {
          EClass _type = e.getType();
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_type, null);
          return ((Boolean)_operator_notEquals);
        }
      };
    Iterable<IConstraint> _filter = IterableExtensions.<IConstraint>filter(_grammarConstraints, _function);
    final Function1<IConstraint,EPackage> _function_1 = new Function1<IConstraint,EPackage>() {
        public EPackage apply(final IConstraint e_1) {
          EClass _type_1 = e_1.getType();
          EPackage _ePackage = _type_1.getEPackage();
          return _ePackage;
        }
      };
    Iterable<EPackage> _map = IterableExtensions.<IConstraint, EPackage>map(_filter, _function_1);
    Set<EPackage> _set = IterableExtensions.<EPackage>toSet(_map);
    return _set;
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
        public Boolean apply(final EClass e_1) {
          boolean _operator_and = false;
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(e_1, null);
          if (!_operator_notEquals) {
            _operator_and = false;
          } else {
            EPackage _ePackage = e_1.getEPackage();
            boolean _operator_equals = ObjectExtensions.operator_equals(_ePackage, pkg);
            _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_equals);
          }
          return ((Boolean)_operator_and);
        }
      };
    Iterable<EClass> _filter = IterableExtensions.<EClass>filter(_map, _function_1);
    Set<EClass> _set = IterableExtensions.<EClass>toSet(_filter);
    return _set;
  }
  
  public Iterable<EClass> getAccessedClasses() {
    Collection<IConstraint> _grammarConstraints = this.sequencerUtil.getGrammarConstraints(this.grammar);
    final Function1<IConstraint,EClass> _function = new Function1<IConstraint,EClass>() {
        public EClass apply(final IConstraint e) {
          EClass _type = e.getType();
          return _type;
        }
      };
    Iterable<EClass> _map = IterableExtensions.<IConstraint, EClass>map(_grammarConstraints, _function);
    Set<EClass> _set = IterableExtensions.<EClass>toSet(_map);
    return _set;
  }
  
  public Map<IConstraint,List<EObject>> getAccessedConstraints(final EClass clazz) {
    Map<IConstraint,List<EObject>> _grammarConstraints = this.sequencerUtil.getGrammarConstraints(this.grammar, clazz);
    return _grammarConstraints;
  }
  
  public Collection<EObject> getAccessedContexts(final EClass clazz) {
    Collection<EObject> _grammarContexts = this.sequencerUtil.getGrammarContexts(this.grammar, clazz);
    return _grammarContexts;
  }
  
  public Collection<EObject> getAccessedContexts() {
    Collection<EObject> _grammarContexts = this.sequencerUtil.getGrammarContexts(this.grammar);
    return _grammarContexts;
  }
  
  public Collection<IConstraint> getAccessedConstraints() {
    Collection<IConstraint> _grammarConstraints = this.sequencerUtil.getGrammarConstraints(this.grammar);
    return _grammarConstraints;
  }
  
  public HashSet<Grammar> getGrammars(final IConstraintElement ele) {
    {
      HashSet<Grammar> _newHashSet = CollectionLiterals.<Grammar>newHashSet();
      final HashSet<Grammar> result = _newHashSet;
      boolean _operator_and = false;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(ele, null);
      if (!_operator_notEquals) {
        _operator_and = false;
      } else {
        AbstractElement _grammarElement = ele.getGrammarElement();
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_grammarElement, null);
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_notEquals_1);
      }
      if (_operator_and) {
        AbstractElement _grammarElement_1 = ele.getGrammarElement();
        Grammar _grammar = GrammarUtil.getGrammar(_grammarElement_1);
        result.add(_grammar);
      }
      boolean _operator_and_1 = false;
      boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(ele, null);
      if (!_operator_notEquals_2) {
        _operator_and_1 = false;
      } else {
        List<IConstraintElement> _children = ele.getChildren();
        boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(_children, null);
        _operator_and_1 = BooleanExtensions.operator_and(_operator_notEquals_2, _operator_notEquals_3);
      }
      if (_operator_and_1) {
        List<IConstraintElement> _children_1 = ele.getChildren();
        final Function1<IConstraintElement,HashSet<Grammar>> _function = new Function1<IConstraintElement,HashSet<Grammar>>() {
            public HashSet<Grammar> apply(final IConstraintElement c) {
              HashSet<Grammar> _grammars = AbstractSemanticSequencer.this.getGrammars(c);
              return _grammars;
            }
          };
        List<HashSet<Grammar>> _map = ListExtensions.<IConstraintElement, HashSet<Grammar>>map(_children_1, _function);
        Iterable<Grammar> _flatten = IterableExtensions.<Grammar>flatten(_map);
        for (Grammar g : _flatten) {
          result.add(g);
        }
      }
      return result;
    }
  }
  
  public boolean uses(final Grammar g1, final Grammar g2) {
    boolean _operator_and = false;
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(g1, null);
    if (!_operator_notEquals) {
      _operator_and = false;
    } else {
      EList<Grammar> _usedGrammars = g1.getUsedGrammars();
      final Function1<Grammar,Boolean> _function = new Function1<Grammar,Boolean>() {
          public Boolean apply(final Grammar e) {
            boolean _operator_or = false;
            boolean _operator_equals = ObjectExtensions.operator_equals(e, g2);
            if (_operator_equals) {
              _operator_or = true;
            } else {
              boolean _uses = AbstractSemanticSequencer.this.uses(e, g2);
              _operator_or = BooleanExtensions.operator_or(_operator_equals, _uses);
            }
            return ((Boolean)_operator_or);
          }
        };
      boolean _exists = IterableExtensions.<Grammar>exists(_usedGrammars, _function);
      _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _exists);
    }
    return _operator_and;
  }
  
  public Grammar getMostConcreteGrammar(final IConstraint constraint) {
    IConstraintElement _body = constraint.getBody();
    HashSet<Grammar> _grammars = this.getGrammars(_body);
    final Function2<Grammar,Grammar,Grammar> _function = new Function2<Grammar,Grammar,Grammar>() {
        public Grammar apply(final Grammar x , final Grammar y) {
          Grammar _xifexpression = null;
          boolean _uses = AbstractSemanticSequencer.this.uses(x, y);
          if (_uses) {
            _xifexpression = x;
          } else {
            _xifexpression = y;
          }
          return _xifexpression;
        }
      };
    Grammar _reduce = IterableExtensions.<Grammar>reduce(_grammars, _function);
    return _reduce;
  }
  
  public boolean usesSuperGrammar() {
    Collection<IConstraint> _accessedConstraints = this.getAccessedConstraints();
    final Function1<IConstraint,Grammar> _function = new Function1<IConstraint,Grammar>() {
        public Grammar apply(final IConstraint c) {
          Grammar _mostConcreteGrammar = AbstractSemanticSequencer.this.getMostConcreteGrammar(c);
          return _mostConcreteGrammar;
        }
      };
    Iterable<Grammar> _map = IterableExtensions.<IConstraint, Grammar>map(_accessedConstraints, _function);
    final Function1<Grammar,Boolean> _function_1 = new Function1<Grammar,Boolean>() {
        public Boolean apply(final Grammar g) {
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(g, AbstractSemanticSequencer.this.grammar);
          return ((Boolean)_operator_notEquals);
        }
      };
    boolean _exists = IterableExtensions.<Grammar>exists(_map, _function_1);
    return _exists;
  }
  
  public String getFileContents() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _packageName = this.getPackageName();
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.Collections;");
    _builder.newLine();
    _builder.append("import static java.util.Collections.singleton;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EObject;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.nodemodel.ICompositeNode;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.nodemodel.ILeafNode;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.serializer.GenericSequencer;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.serializer.ISemanticNodeProvider;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.serializer.ISemanticNodeProvider.INodesForEObjectProvider;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.serializer.ISemanticSequencer;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.serializer.ITransientValueService;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.serializer.ITransientValueService.ValueTransient;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.serializer.impl.AbstractSemanticSequencer;");
    _builder.newLine();
    _builder.append("import ");
    String _gaFQName = this.grammarAccess.gaFQName(this.grammar);
    _builder.append(_gaFQName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      Iterable<EPackage> _accessedPackages = this.getAccessedPackages();
      for(EPackage e : _accessedPackages) {
        _builder.append("import ");
        GenPackage _genPackage = GenModelAccess.getGenPackage(e);
        String _qualifiedPackageName = _genPackage.getQualifiedPackageName();
        _builder.append(_qualifiedPackageName, "");
        _builder.append(".*;");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _usesSuperGrammar = this.usesSuperGrammar();
      if (_usesSuperGrammar) {
        _builder.append("import ");
        EList<Grammar> _usedGrammars = this.grammar.getUsedGrammars();
        Grammar _head = IterableExtensions.<Grammar>head(_usedGrammars);
        String _qualifiedName = this.sequencer.getQualifiedName(_head);
        _builder.append(_qualifiedName, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("import com.google.inject.Inject;");
    _builder.newLine();
    _builder.append("import com.google.inject.Provider;\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"restriction\")");
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = this.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append(" extends AbstractSemanticSequencer {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inject");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected ");
    String _gaSimpleName = this.grammarAccess.gaSimpleName(this.grammar);
    _builder.append(_gaSimpleName, "	");
    _builder.append(" grammarAccess;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inject");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected ISemanticSequencerDiagnosticProvider diagnosticProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inject");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected ITransientValueService transientValues;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inject");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected ISemanticNodeProvider nodeProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inject");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@GenericSequencer");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Provider<ISemanticSequencer> genericSequencerProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected ISemanticSequencer genericSequencer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _usesSuperGrammar_1 = this.usesSuperGrammar();
      if (_usesSuperGrammar_1) {
        _builder.append("\t");
        _builder.append("@Inject");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected Provider<");
        EList<Grammar> _usedGrammars_1 = this.grammar.getUsedGrammars();
        Grammar _head_1 = IterableExtensions.<Grammar>head(_usedGrammars_1);
        String _simpleName_1 = this.sequencer.getSimpleName(_head_1);
        _builder.append(_simpleName_1, "	");
        _builder.append("> superSequencerProvider;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(" ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        EList<Grammar> _usedGrammars_2 = this.grammar.getUsedGrammars();
        Grammar _head_2 = IterableExtensions.<Grammar>head(_usedGrammars_2);
        String _simpleName_2 = this.sequencer.getSimpleName(_head_2);
        _builder.append(_simpleName_2, "	");
        _builder.append(" superSequencer; ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void init(ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super.init(sequenceAcceptor, errorAcceptor);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.genericSequencer = genericSequencerProvider.get();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.genericSequencer.init(sequenceAcceptor, errorAcceptor);");
    _builder.newLine();
    {
      boolean _usesSuperGrammar_2 = this.usesSuperGrammar();
      if (_usesSuperGrammar_2) {
        _builder.append("\t\t");
        _builder.append("this.superSequencer = superSequencerProvider.get();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("this.superSequencer.init(sequenceAcceptor, errorAcceptor); ");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("", "	");
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("", "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    StringConcatenation _genMethodCreateSequence = this.genMethodCreateSequence();
    _builder.append(_genMethodCreateSequence, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    Collection<IConstraint> _accessedConstraints = this.getAccessedConstraints();
    final Function1<IConstraint,Boolean> _function = new Function1<IConstraint,Boolean>() {
        public Boolean apply(final IConstraint e_1) {
          EClass _type = e_1.getType();
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_type, null);
          return ((Boolean)_operator_notEquals);
        }
      };
    Iterable<IConstraint> _filter = IterableExtensions.<IConstraint>filter(_accessedConstraints, _function);
    final Function1<IConstraint,StringConcatenation> _function_1 = new Function1<IConstraint,StringConcatenation>() {
        public StringConcatenation apply(final IConstraint e_2) {
          StringConcatenation _genMethodSequence = AbstractSemanticSequencer.this.genMethodSequence(e_2);
          return _genMethodSequence;
        }
      };
    String _join = IterableExtensions.<IConstraint>join(_filter, "\n\n", _function_1);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    String _string = _builder.toString();
    return _string;
  }
  
  public StringConcatenation genMethodCreateSequence() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void createSequence(EObject context, EObject semanticObject) {");
    _builder.newLine();
    _builder.append("\t");
    int pkgi = 0;
    _builder.newLineIfNotEmpty();
    {
      Iterable<EPackage> _accessedPackages = this.getAccessedPackages();
      for(EPackage pkg : _accessedPackages) {
        _builder.append("\t");
        {
          int _operator_plus = IntegerExtensions.operator_plus(((Integer)pkgi), ((Integer)1));
          int _pkgi = pkgi = _operator_plus;
          boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_pkgi), ((Integer)1));
          if (_operator_greaterThan) {
            _builder.append("else ");
          }
        }
        _builder.append("if(semanticObject.eClass().getEPackage() == ");
        GenPackage _genPackage = GenModelAccess.getGenPackage(pkg);
        String _packageInterfaceName = _genPackage.getPackageInterfaceName();
        _builder.append(_packageInterfaceName, "	");
        _builder.append(".eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {");
        _builder.newLineIfNotEmpty();
        {
          Iterable<EClass> _accessedClasses = this.getAccessedClasses(pkg);
          for(EClass type : _accessedClasses) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("case ");
            String _genIntLiteral = GenModelAccess.getGenIntLiteral(type);
            _builder.append(_genIntLiteral, "		");
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
              for(Entry<IConstraint,List<EObject>> ctx : _entrySet) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                {
                  int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)ctxi), ((Integer)1));
                  int _ctxi = ctxi = _operator_plus_1;
                  boolean _operator_greaterThan_1 = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_ctxi), ((Integer)1));
                  if (_operator_greaterThan_1) {
                    _builder.append("else ");
                  }
                }
                _builder.append("if(");
                {
                  List<EObject> _value = ctx.getValue();
                  boolean hasAnyElements = false;
                  for(EObject c : _value) {
                    if (!hasAnyElements) {
                      hasAnyElements = true;
                    } else {
                      _builder.appendImmediate(" ||\n   ", "			");
                    }
                    _builder.append("context == grammarAccess.");
                    String _gaAccessor = this.grammarAccess.gaAccessor(c);
                    _builder.append(_gaAccessor, "			");
                  }
                }
                _builder.append(") {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("sequence_");
                IConstraint _key = ctx.getKey();
                String _name = _key.getName();
                _builder.append(_name, "				");
                _builder.append("(context, (");
                String _name_1 = type.getName();
                _builder.append(_name_1, "				");
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
  
  public StringConcatenation genMethodSequence(final IConstraint c) {
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
    boolean _operator_equals = ObjectExtensions.operator_equals(_body, null);
    if (_operator_equals) {
      EClass _type = c.getType();
      String _name = _type.getName();
      String _operator_plus = StringExtensions.operator_plus("{", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "}");
      _xifexpression = _operator_plus_1;
    } else {
      IConstraintElement _body_1 = c.getBody();
      String _string = _body_1.toString();
      String _replaceAll = _string.replaceAll("\\n", "\n*     ");
      _xifexpression = _replaceAll;
    }
    _builder.append(_xifexpression, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Features:");
    _builder.newLine();
    {
      IFeatureInfo[] _features = c.getFeatures();
      final Function1<IFeatureInfo,Boolean> _function = new Function1<IFeatureInfo,Boolean>() {
          public Boolean apply(final IFeatureInfo e) {
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(e, null);
            return ((Boolean)_operator_notEquals);
          }
        };
      Iterable<IFeatureInfo> _filter = IterableExtensions.<IFeatureInfo>filter(((Iterable<IFeatureInfo>)Conversions.doWrapArray(_features)), _function);
      for(IFeatureInfo f : _filter) {
        _builder.append(" *    ", "");
        String _string_1 = f.toString();
        String _replaceAll_1 = _string_1.replaceAll("\\n", "\n *     ");
        _builder.append(_replaceAll_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("protected void sequence_");
    String _name_1 = c.getName();
    _builder.append(_name_1, "");
    _builder.append("(EObject context, ");
    EClass _type_1 = c.getType();
    GenClass _genClass = GenModelAccess.getGenClass(_type_1);
    String _interfaceName = _genClass.getInterfaceName();
    _builder.append(_interfaceName, "");
    _builder.append(" semanticObject) {");
    _builder.newLineIfNotEmpty();
    {
      HashSet<Grammar> _newHashSet = CollectionLiterals.<Grammar>newHashSet(this.grammar, null);
      Grammar _mostConcreteGrammar = this.getMostConcreteGrammar(c);
      boolean _contains = _newHashSet.contains(_mostConcreteGrammar);
      boolean _operator_not = BooleanExtensions.operator_not(_contains);
      if (_operator_not) {
        _builder.append("\t");
        _builder.append("superSequencer.createSequence(context, semanticObject);");
        _builder.newLine();} else {
        boolean _canGenerate = this.sequencerUtil.canGenerate(c);
        if (_canGenerate) {
          _builder.append("\t");
          _builder.append("if(errorAcceptor != null) {");
          _builder.newLine();
          {
            IFeatureInfo[] _features_1 = c.getFeatures();
            final Function1<IFeatureInfo,Boolean> _function_1 = new Function1<IFeatureInfo,Boolean>() {
                public Boolean apply(final IFeatureInfo e_1) {
                  boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(e_1, null);
                  return ((Boolean)_operator_notEquals_1);
                }
              };
            Iterable<IFeatureInfo> _filter_1 = IterableExtensions.<IFeatureInfo>filter(((Iterable<IFeatureInfo>)Conversions.doWrapArray(_features_1)), _function_1);
            for(IFeatureInfo f_1 : _filter_1) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("if(transientValues.isValueTransient(semanticObject, ");
              EStructuralFeature _feature = f_1.getFeature();
              String _genTypeLiteral = GenModelAccess.getGenTypeLiteral(_feature);
              _builder.append(_genTypeLiteral, "		");
              _builder.append(") == ValueTransient.YES)");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ");
              EStructuralFeature _feature_1 = f_1.getFeature();
              String _genTypeLiteral_1 = GenModelAccess.getGenTypeLiteral(_feature_1);
              _builder.append(_genTypeLiteral_1, "			");
              _builder.append("));");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);");
          _builder.newLine();
          {
            Iterable<IFeatureInfo> _xifexpression_1 = null;
            IConstraintElement _body_2 = c.getBody();
            IFeatureInfo _featureInfo = _body_2.getFeatureInfo();
            boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_featureInfo, null);
            if (_operator_notEquals_2) {
              IConstraintElement _body_3 = c.getBody();
              IFeatureInfo _featureInfo_1 = _body_3.getFeatureInfo();
              ArrayList<IFeatureInfo> _newArrayList = CollectionLiterals.<IFeatureInfo>newArrayList(_featureInfo_1);
              _xifexpression_1 = _newArrayList;
            } else {
              IConstraintElement _body_4 = c.getBody();
              List<IConstraintElement> _children = _body_4.getChildren();
              final Function1<IConstraintElement,Boolean> _function_2 = new Function1<IConstraintElement,Boolean>() {
                  public Boolean apply(final IConstraintElement e_2) {
                    IFeatureInfo _featureInfo_2 = e_2.getFeatureInfo();
                    boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(_featureInfo_2, null);
                    return ((Boolean)_operator_notEquals_3);
                  }
                };
              Iterable<IConstraintElement> _filter_2 = IterableExtensions.<IConstraintElement>filter(_children, _function_2);
              final Function1<IConstraintElement,IFeatureInfo> _function_3 = new Function1<IConstraintElement,IFeatureInfo>() {
                  public IFeatureInfo apply(final IConstraintElement e_3) {
                    IFeatureInfo _featureInfo_3 = e_3.getFeatureInfo();
                    return _featureInfo_3;
                  }
                };
              Iterable<IFeatureInfo> _map = IterableExtensions.<IConstraintElement, IFeatureInfo>map(_filter_2, _function_3);
              _xifexpression_1 = _map;
            }
            for(IFeatureInfo f_2 : _xifexpression_1) {
              _builder.append("\t");
              IConstraintElement[] _assignments = f_2.getAssignments();
              IConstraintElement _get = ((List<IConstraintElement>)Conversions.doWrapArray(_assignments)).get(0);
              final IConstraintElement assignment = _get;
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              ConstraintElementType _type_2 = assignment.getType();
              String _acceptMethod = this.sequencerUtil.toAcceptMethod(_type_2);
              _builder.append(_acceptMethod, "	");
              _builder.append("(semanticObject, grammarAccess.");
              AbstractElement _grammarElement = assignment.getGrammarElement();
              String _gaAccessor = this.grammarAccess.gaAccessor(_grammarElement);
              _builder.append(_gaAccessor, "	");
              _builder.append(", semanticObject.");
              EStructuralFeature _feature_2 = f_2.getFeature();
              GenFeature _genFeature = GenModelAccess.getGenFeature(_feature_2);
              String _getAccessor = _genFeature.getGetAccessor();
              _builder.append(_getAccessor, "	");
              _builder.append("(), -1, (");
              ConstraintElementType _type_3 = assignment.getType();
              String _nodeType = this.sequencerUtil.toNodeType(_type_3);
              _builder.append(_nodeType, "	");
              _builder.append(")nodes.getNodeForSingelValue(");
              EStructuralFeature _feature_3 = f_2.getFeature();
              String _genTypeLiteral_2 = GenModelAccess.getGenTypeLiteral(_feature_3);
              _builder.append(_genTypeLiteral_2, "	");
              _builder.append(", semanticObject.");
              EStructuralFeature _feature_4 = f_2.getFeature();
              GenFeature _genFeature_1 = GenModelAccess.getGenFeature(_feature_4);
              String _getAccessor_1 = _genFeature_1.getGetAccessor();
              _builder.append(_getAccessor_1, "	");
              _builder.append("()));");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("acceptFinish();");
          _builder.newLine();} else {
          _builder.append("\t");
          _builder.append("genericSequencer.createSequence(context, semanticObject);");
          _builder.newLine();
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}