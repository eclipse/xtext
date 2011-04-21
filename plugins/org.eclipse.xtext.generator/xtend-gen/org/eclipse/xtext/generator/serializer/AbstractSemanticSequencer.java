package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.GenModelAccess;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess;
import org.eclipse.xtext.generator.serializer.GeneratedFile;
import org.eclipse.xtext.generator.serializer.SemanticSequencerUtil;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.ConstraintElementType;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IFeatureInfo;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class AbstractSemanticSequencer extends GeneratedFile {
  @Inject private Grammar grammar;
  @Inject private GrammarAccess grammarAccess;
  
  public String getQualifiedName() {
    String _name = this.getName("Abstract", "SemanticSequencer");
    return _name;
  }
  
  public Iterable<EPackage> getAccessedPackages() {
    Collection<IConstraint> _grammarConstraints = SemanticSequencerUtil.getGrammarConstraints(this.grammar);
    final Function1<IConstraint,EPackage> _function = new Function1<IConstraint,EPackage>() {
        public EPackage apply(IConstraint e) {
          EClass _type = e.getType();
          EPackage _ePackage = _type.getEPackage();
          return _ePackage;
        }
      };
    Iterable<EPackage> _map = IterableExtensions.<IConstraint, EPackage>map(_grammarConstraints, _function);
    Set<EPackage> _set = IterableExtensions.<EPackage>toSet(_map);
    return _set;
  }
  
  public Iterable<EClass> getAccessedClasses(final EPackage pkg) {
    Collection<IConstraint> _grammarConstraints = SemanticSequencerUtil.getGrammarConstraints(this.grammar);
    final Function1<IConstraint,EClass> _function = new Function1<IConstraint,EClass>() {
        public EClass apply(IConstraint e) {
          EClass _type = e.getType();
          return _type;
        }
      };
    Iterable<EClass> _map = IterableExtensions.<IConstraint, EClass>map(_grammarConstraints, _function);
    final Function1<EClass,Boolean> _function_1 = new Function1<EClass,Boolean>() {
        public Boolean apply(EClass e_1) {
          final EClass typeConverted_e_1 = (EClass)e_1;
          EPackage _ePackage = typeConverted_e_1.getEPackage();
          final EPackage typeConverted_pkg = (EPackage)pkg;
          boolean _operator_equals = ObjectExtensions.operator_equals(_ePackage, typeConverted_pkg);
          return ((Boolean)_operator_equals);
        }
      };
    Iterable<EClass> _filter = IterableExtensions.<EClass>filter(_map, _function_1);
    Set<EClass> _set = IterableExtensions.<EClass>toSet(_filter);
    return _set;
  }
  
  public Iterable<EClass> getAccessedClasses() {
    Collection<IConstraint> _grammarConstraints = SemanticSequencerUtil.getGrammarConstraints(this.grammar);
    final Function1<IConstraint,EClass> _function = new Function1<IConstraint,EClass>() {
        public EClass apply(IConstraint e) {
          EClass _type = e.getType();
          return _type;
        }
      };
    Iterable<EClass> _map = IterableExtensions.<IConstraint, EClass>map(_grammarConstraints, _function);
    Set<EClass> _set = IterableExtensions.<EClass>toSet(_map);
    return _set;
  }
  
  public Map<IConstraint,List<EObject>> getAccessedConstraints(final EClass clazz) {
    Map<IConstraint,List<EObject>> _grammarConstraints = SemanticSequencerUtil.getGrammarConstraints(this.grammar, clazz);
    return _grammarConstraints;
  }
  
  public Collection<EObject> getAccessedContexts(final EClass clazz) {
    Collection<EObject> _grammarContexts = SemanticSequencerUtil.getGrammarContexts(this.grammar, clazz);
    return _grammarContexts;
  }
  
  public Collection<EObject> getAccessedContexts() {
    Collection<EObject> _grammarContexts = SemanticSequencerUtil.getGrammarContexts(this.grammar);
    return _grammarContexts;
  }
  
  public Collection<IConstraint> getAccessedConstraints() {
    Collection<IConstraint> _grammarConstraints = SemanticSequencerUtil.getGrammarConstraints(this.grammar);
    return _grammarConstraints;
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
    _builder.newLine();
    _builder.append("import com.google.common.collect.Lists;");
    _builder.newLine();
    _builder.append("import com.google.inject.Inject;");
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
    _builder.append("@GenericSequencer");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected ISemanticSequencer genericSequencer;");
    _builder.newLine();
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
    StringConcatenation _genMethodFindContext = this.genMethodFindContext();
    _builder.append(_genMethodFindContext, "	");
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    Iterable<EClass> _accessedClasses = this.getAccessedClasses();
    final Function1<EClass,Boolean> _function = new Function1<EClass,Boolean>() {
        public Boolean apply(EClass e_1) {
          Collection<EObject> _accessedContexts = AbstractSemanticSequencer.this.getAccessedContexts(e_1);
          int _size = _accessedContexts.size();
          boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Comparable<? super Integer>)_size), ((Integer)1));
          return ((Boolean)_operator_greaterThan);
        }
      };
    Iterable<EClass> _filter = IterableExtensions.<EClass>filter(_accessedClasses, _function);
    final Function1<EClass,StringConcatenation> _function_1 = new Function1<EClass,StringConcatenation>() {
        public StringConcatenation apply(EClass e_2) {
          StringConcatenation _genMethodFindContextType = AbstractSemanticSequencer.this.genMethodFindContextType(e_2);
          return _genMethodFindContextType;
        }
      };
    String _join = IterableExtensions.<EClass>join(_filter, "\n\n", _function_1);
    _builder.append(_join, "	");
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
    final Function1<IConstraint,StringConcatenation> _function_2 = new Function1<IConstraint,StringConcatenation>() {
        public StringConcatenation apply(IConstraint e_3) {
          StringConcatenation _genMethodSequence = AbstractSemanticSequencer.this.genMethodSequence(e_3);
          return _genMethodSequence;
        }
      };
    String _join_1 = IterableExtensions.<IConstraint>join(_accessedConstraints, "\n\n", _function_2);
    _builder.append(_join_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    String _string = _builder.toString();
    return _string;
  }
  
  public StringConcatenation genMethodFindContext() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public Iterable<EObject> findContexts(EObject semanitcObject, Iterable<EObject> contextCandidates) {");
    _builder.newLine();
    _builder.append("\t");
    int pkgi = 0;
    _builder.newLineIfNotEmpty();
    {
      Iterable<EPackage> _accessedPackages = this.getAccessedPackages();
      for(EPackage pkg : _accessedPackages) {
        _builder.append("\t");
        {
          final int typeConverted_pkgi = (int)pkgi;
          int _operator_plus = IntegerExtensions.operator_plus(((Integer)typeConverted_pkgi), ((Number)1));
          int _pkgi = pkgi = _operator_plus;
          boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Comparable<? super Integer>)_pkgi), ((Integer)1));
          if (_operator_greaterThan) {
            _builder.append("else ");
          }
        }
        _builder.append("if(semanitcObject.eClass().getEPackage() == ");
        GenPackage _genPackage = GenModelAccess.getGenPackage(pkg);
        String _packageInterfaceName = _genPackage.getPackageInterfaceName();
        _builder.append(_packageInterfaceName, "	");
        _builder.append(".eINSTANCE) ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("switch(semanitcObject.eClass().getClassifierID()) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        Iterable<EClass> _accessedClasses = this.getAccessedClasses(pkg);
        final Function2<EClass,Integer,Integer> _function = new Function2<EClass,Integer,Integer>() {
            public Integer apply(EClass type , Integer max) {
              final EClass typeConverted_type = (EClass)type;
              String _genIntLiteral = GenModelAccess.getGenIntLiteral(typeConverted_type);
              int _length = _genIntLiteral.length();
              final Integer typeConverted_max = (Integer)max;
              int _max = Math.max(_length, typeConverted_max);
              return ((Integer)_max);
            }
          };
        Integer _fold = IterableExtensions.<EClass, Integer>fold(_accessedClasses, ((Integer) ((Integer)0)), _function);
        final Integer width = _fold;
        _builder.newLineIfNotEmpty();
        {
          Iterable<EClass> _accessedClasses_1 = this.getAccessedClasses(pkg);
          for(EClass type_1 : _accessedClasses_1) {
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("case ");
            final EClass typeConverted_type_1 = (EClass)type_1;
            String _genIntLiteral_1 = GenModelAccess.getGenIntLiteral(typeConverted_type_1);
            _builder.append(_genIntLiteral_1, "			");
            _builder.append(":");
            final EClass typeConverted_type_1_1 = (EClass)type_1;
            String _genIntLiteral_2 = GenModelAccess.getGenIntLiteral(typeConverted_type_1_1);
            int _length_1 = _genIntLiteral_2.length();
            final Integer typeConverted_width = (Integer)width;
            Iterable<Integer> _operator_upTo = IntegerExtensions.operator_upTo(((Integer)_length_1), typeConverted_width);
            final Function2<Integer,String,String> _function_1 = new Function2<Integer,String,String>() {
                public String apply(Integer i , String s) {
                  String _operator_plus_1 = StringExtensions.operator_plus(s, " ");
                  return _operator_plus_1;
                }
              };
            String _fold_1 = IterableExtensions.<Integer, String>fold(_operator_upTo, "", _function_1);
            _builder.append(_fold_1, "			");
            _builder.append("return ");
            {
              Collection<EObject> _accessedContexts = this.getAccessedContexts(type_1);
              int _size = _accessedContexts.size();
              boolean _operator_equals = ObjectExtensions.operator_equals(((Object)_size), ((Object)1));
              if (_operator_equals) {
                _builder.append("singleton((EObject)grammarAccess.");
                Collection<EObject> _accessedContexts_1 = this.getAccessedContexts(type_1);
                Iterator<EObject> _iterator = _accessedContexts_1.iterator();
                EObject _next = _iterator.next();
                String _gaAccessor = this.grammarAccess.gaAccessor(_next);
                _builder.append(_gaAccessor, "			");
                _builder.append(")");} else {
                _builder.append("findContexts((");
                GenClass _genClass = GenModelAccess.getGenClass(type_1);
                String _interfaceName = _genClass.getInterfaceName();
                _builder.append(_interfaceName, "			");
                _builder.append(")semanitcObject, contextCandidates)");
              }
            }
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("return Collections.emptyList();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation genMethodFindContextType(final EClass type) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Potential Result Contexts:");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*     ");
    {
      Collection<EObject> _accessedContexts = this.getAccessedContexts(type);
      boolean hasAnyElements = false;
      for(EObject ctx : _accessedContexts) {
        if (!hasAnyElements) {
          hasAnyElements = true;
        } else {
          _builder.appendImmediate("\n*     ", " ");
        }
        String _gaAccessor = this.grammarAccess.gaAccessor(ctx);
        _builder.append(_gaAccessor, " ");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("protected Iterable<EObject> findContexts(");
    GenClass _genClass = GenModelAccess.getGenClass(type);
    String _interfaceName = _genClass.getInterfaceName();
    _builder.append(_interfaceName, "");
    _builder.append(" semanitcObject, Iterable<EObject> contextCandidates) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return genericSequencer.findContexts(semanitcObject, contextCandidates);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation genMethodCreateSequence() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void createSequence(EObject context, EObject semanticObject, ISemanticSequenceAcceptor sequenceAcceptor,\tAcceptor errorAcceptor) {");
    _builder.newLine();
    _builder.append("\t");
    int pkgi = 0;
    _builder.newLineIfNotEmpty();
    {
      Iterable<EPackage> _accessedPackages = this.getAccessedPackages();
      for(EPackage pkg : _accessedPackages) {
        _builder.append("\t");
        {
          final int typeConverted_pkgi = (int)pkgi;
          int _operator_plus = IntegerExtensions.operator_plus(((Integer)typeConverted_pkgi), ((Number)1));
          int _pkgi = pkgi = _operator_plus;
          boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Comparable<? super Integer>)_pkgi), ((Integer)1));
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
            final EClass typeConverted_type = (EClass)type;
            String _genIntLiteral = GenModelAccess.getGenIntLiteral(typeConverted_type);
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
                  final int typeConverted_ctxi = (int)ctxi;
                  int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)typeConverted_ctxi), ((Number)1));
                  int _ctxi = ctxi = _operator_plus_1;
                  boolean _operator_greaterThan_1 = ComparableExtensions.<Integer>operator_greaterThan(((Comparable<? super Integer>)_ctxi), ((Integer)1));
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
                final EClass typeConverted_type_1 = (EClass)type;
                String _name_1 = typeConverted_type_1.getName();
                _builder.append(_name_1, "				");
                _builder.append(") semanticObject, sequenceAcceptor, errorAcceptor); ");
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
    IConstraintElement _body = c.getBody();
    _builder.append(_body, " ");
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
          public Boolean apply(IFeatureInfo e) {
            final IFeatureInfo typeConverted_e = (IFeatureInfo)e;
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(typeConverted_e, null);
            return ((Boolean)_operator_notEquals);
          }
        };
      Iterable<IFeatureInfo> _filter = IterableExtensions.<IFeatureInfo>filter(((Iterable<IFeatureInfo>)Conversions.doWrapArray(_features)), _function);
      for(IFeatureInfo f : _filter) {
        _builder.append(" *    ", "");
        final IFeatureInfo typeConverted_f = (IFeatureInfo)f;
        String _string = typeConverted_f.toString();
        String _replaceAll = _string.replaceAll("\\n", "\n *     ");
        _builder.append(_replaceAll, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("protected void sequence_");
    String _name = c.getName();
    _builder.append(_name, "");
    _builder.append("(EObject context, ");
    EClass _type = c.getType();
    GenClass _genClass = GenModelAccess.getGenClass(_type);
    String _interfaceName = _genClass.getInterfaceName();
    _builder.append(_interfaceName, "");
    _builder.append(" semanticObject, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {");
    _builder.newLineIfNotEmpty();
    {
      boolean _canGenerate = SemanticSequencerUtil.canGenerate(c);
      if (_canGenerate) {
        _builder.append("\t");
        _builder.append("if(errorAcceptor != null) {");
        _builder.newLine();
        {
          IFeatureInfo[] _features_1 = c.getFeatures();
          final Function1<IFeatureInfo,Boolean> _function_1 = new Function1<IFeatureInfo,Boolean>() {
              public Boolean apply(IFeatureInfo e_1) {
                final IFeatureInfo typeConverted_e_1 = (IFeatureInfo)e_1;
                boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(typeConverted_e_1, null);
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
          IFeatureInfo[] _features_2 = c.getFeatures();
          final Function1<IFeatureInfo,Boolean> _function_2 = new Function1<IFeatureInfo,Boolean>() {
              public Boolean apply(IFeatureInfo e_2) {
                final IFeatureInfo typeConverted_e_2 = (IFeatureInfo)e_2;
                boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(typeConverted_e_2, null);
                return ((Boolean)_operator_notEquals_2);
              }
            };
          Iterable<IFeatureInfo> _filter_2 = IterableExtensions.<IFeatureInfo>filter(((Iterable<IFeatureInfo>)Conversions.doWrapArray(_features_2)), _function_2);
          for(IFeatureInfo f_2 : _filter_2) {
            _builder.append("\t");
            IConstraintElement[] _assignments = f_2.getAssignments();
            IConstraintElement _get = ((List<IConstraintElement>)Conversions.doWrapArray(_assignments)).get(0);
            final IConstraintElement assignment = _get;
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            ConstraintElementType _type_1 = assignment.getType();
            String _acceptMethod = SemanticSequencerUtil.toAcceptMethod(_type_1);
            _builder.append(_acceptMethod, "	");
            _builder.append("(sequenceAcceptor, errorAcceptor, semanticObject, grammarAccess.");
            AbstractElement _grammarElement = assignment.getGrammarElement();
            String _gaAccessor = this.grammarAccess.gaAccessor(_grammarElement);
            _builder.append(_gaAccessor, "	");
            _builder.append(", semanticObject.");
            EStructuralFeature _feature_2 = f_2.getFeature();
            GenFeature _genFeature = GenModelAccess.getGenFeature(_feature_2);
            String _getAccessor = _genFeature.getGetAccessor();
            _builder.append(_getAccessor, "	");
            _builder.append("(), -1, (");
            ConstraintElementType _type_2 = assignment.getType();
            String _nodeType = SemanticSequencerUtil.toNodeType(_type_2);
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
        }} else {
        _builder.append("\t");
        _builder.append("genericSequencer.createSequence(context, semanticObject, sequenceAcceptor, errorAcceptor);");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}