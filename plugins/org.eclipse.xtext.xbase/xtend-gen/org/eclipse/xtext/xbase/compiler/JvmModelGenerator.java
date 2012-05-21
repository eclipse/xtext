package org.eclipse.xtext.xbase.compiler;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmByteAnnotationValue;
import org.eclipse.xtext.common.types.JvmCharAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmLongAnnotationValue;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmShortAnnotationValue;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.JavaKeywords;
import org.eclipse.xtext.xbase.compiler.TreeAppendableUtil;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * A generator implementation that processes the
 * derived {@link org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer JVM model}
 * and produces the respective java code.
 */
@SuppressWarnings("all")
public class JvmModelGenerator implements IGenerator {
  private final static Logger LOG = new Function0<Logger>() {
    public Logger apply() {
      Logger _logger = Logger.getLogger(JvmModelGenerator.class);
      return _logger;
    }
  }.apply();
  
  @Inject
  private ILogicalContainerProvider _iLogicalContainerProvider;
  
  @Inject
  private TypeReferences _typeReferences;
  
  @Inject
  private TreeAppendableUtil _treeAppendableUtil;
  
  @Inject
  private JvmTypeExtensions _jvmTypeExtensions;
  
  @Inject
  private XbaseCompiler compiler;
  
  @Inject
  private TypeReferenceSerializer typeRefSerializer;
  
  @Inject
  private ILocationInFileProvider locationProvider;
  
  @Inject
  private IEObjectDocumentationProvider documentationProvider;
  
  @Inject
  private IJvmModelAssociations jvmModelAssociations;
  
  @Inject
  private JavaKeywords keywords;
  
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
    EList<EObject> _contents = input.getContents();
    for (final EObject obj : _contents) {
      this.internalDoGenerate(obj, fsa);
    }
  }
  
  protected void _internalDoGenerate(final EObject obj, final IFileSystemAccess fsa) {
  }
  
  protected void _internalDoGenerate(final JvmGenericType type, final IFileSystemAccess fsa) {
    String _qualifiedName = type.getQualifiedName();
    String _replace = _qualifiedName.replace(".", "/");
    String _plus = (_replace + ".java");
    CharSequence _generateType = this.generateType(type);
    fsa.generateFile(_plus, _generateType);
  }
  
  protected void _internalDoGenerate(final JvmEnumerationType type, final IFileSystemAccess fsa) {
    String _qualifiedName = type.getQualifiedName();
    String _replace = _qualifiedName.replace(".", "/");
    String _plus = (_replace + ".java");
    CharSequence _generateType = this.generateType(type);
    fsa.generateFile(_plus, _generateType);
  }
  
  public CharSequence generateType(final JvmDeclaredType type) {
    ImportManager _importManager = new ImportManager(true, type);
    final ImportManager importManager = _importManager;
    final TreeAppendable bodyAppendable = this.createAppendable(type, importManager);
    this.generateBody(type, bodyAppendable);
    final TreeAppendable importAppendable = this.createAppendable(type, importManager);
    String _packageName = type.getPackageName();
    boolean _notEquals = (!Objects.equal(_packageName, null));
    if (_notEquals) {
      ITreeAppendable _append = importAppendable.append("package ");
      String _packageName_1 = type.getPackageName();
      ITreeAppendable _append_1 = _append.append(_packageName_1);
      _append_1.append(";");
      TreeAppendable _newLine = importAppendable.newLine();
      _newLine.newLine();
    }
    List<String> _imports = importManager.getImports();
    for (final String i : _imports) {
      ITreeAppendable _append_2 = importAppendable.append("import ");
      ITreeAppendable _append_3 = _append_2.append(i);
      ITreeAppendable _append_4 = _append_3.append(";");
      _append_4.newLine();
    }
    List<String> _imports_1 = importManager.getImports();
    boolean _isEmpty = _imports_1.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      importAppendable.newLine();
    }
    importAppendable.append(bodyAppendable);
    return importAppendable;
  }
  
  protected ITreeAppendable _generateBody(final JvmGenericType it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      this.generateJavaDoc(it, appendable);
      final ITreeAppendable childAppendable = appendable.trace(it);
      this.generateAnnotations(it, childAppendable, true);
      this.generateModifier(it, childAppendable);
      boolean _isInterface = it.isInterface();
      if (_isInterface) {
        childAppendable.append("interface ");
      } else {
        childAppendable.append("class ");
      }
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(childAppendable, it);
      String _simpleName = it.getSimpleName();
      _traceSignificant.append(_simpleName);
      this.generateTypeParameterDeclaration(it, childAppendable);
      EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
      boolean _isEmpty = _typeParameters.isEmpty();
      if (_isEmpty) {
        childAppendable.append(" ");
      }
      this.generateExtendsClause(it, childAppendable);
      childAppendable.append("{");
      final Wrapper<Boolean> b = Wrapper.<Boolean>wrap(Boolean.valueOf(true));
      EList<JvmMember> _members = it.getMembers();
      final Procedure1<JvmMember> _function = new Procedure1<JvmMember>() {
          public void apply(final JvmMember it) {
            final ITreeAppendable memberAppendable = JvmModelGenerator.this._treeAppendableUtil.traceWithComments(childAppendable, it);
            memberAppendable.openScope();
            Boolean _get = b.get();
            boolean _generateMember = JvmModelGenerator.this.generateMember(it, memberAppendable, (_get).booleanValue());
            b.set(Boolean.valueOf(_generateMember));
            memberAppendable.closeScope();
          }
        };
      IterableExtensions.<JvmMember>forEach(_members, _function);
      ITreeAppendable _newLine = childAppendable.newLine();
      _newLine.append("}");
      ITreeAppendable _newLine_1 = appendable.newLine();
      _xblockexpression = (_newLine_1);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateBody(final JvmEnumerationType it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      this.generateJavaDoc(it, appendable);
      this.generateAnnotations(it, appendable, true);
      this.generateModifier(it, appendable);
      appendable.append("enum ");
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(appendable, it);
      String _simpleName = it.getSimpleName();
      _traceSignificant.append(_simpleName);
      appendable.append(" ");
      this.generateExtendsClause(it, appendable);
      appendable.append("{");
      final Wrapper<Boolean> b = Wrapper.<Boolean>wrap(Boolean.valueOf(true));
      EList<JvmEnumerationLiteral> _literals = it.getLiterals();
      final Procedure1<JvmEnumerationLiteral> _function = new Procedure1<JvmEnumerationLiteral>() {
          public void apply(final JvmEnumerationLiteral it) {
            ITreeAppendable _trace = appendable.trace(it);
            Boolean _get = b.get();
            boolean _generateEnumLiteral = JvmModelGenerator.this.generateEnumLiteral(it, _trace, (_get).booleanValue());
            b.set(Boolean.valueOf(_generateEnumLiteral));
          }
        };
      IterableExtensions.<JvmEnumerationLiteral>forEach(_literals, _function);
      EList<JvmMember> _members = it.getMembers();
      final Function1<JvmMember,Boolean> _function_1 = new Function1<JvmMember,Boolean>() {
          public Boolean apply(final JvmMember it) {
            boolean _not = (!(it instanceof JvmEnumerationLiteral));
            return Boolean.valueOf(_not);
          }
        };
      Iterable<JvmMember> _filter = IterableExtensions.<JvmMember>filter(_members, _function_1);
      final Procedure1<JvmMember> _function_2 = new Procedure1<JvmMember>() {
          public void apply(final JvmMember it) {
            ITreeAppendable _trace = appendable.trace(it);
            Boolean _get = b.get();
            boolean _generateMember = JvmModelGenerator.this.generateMember(it, _trace, (_get).booleanValue());
            b.set(Boolean.valueOf(_generateMember));
          }
        };
      IterableExtensions.<JvmMember>forEach(_filter, _function_2);
      ITreeAppendable _newLine = appendable.newLine();
      ITreeAppendable _append = _newLine.append("}");
      ITreeAppendable _newLine_1 = _append.newLine();
      _xblockexpression = (_newLine_1);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateModifier(final JvmDeclaredType it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      JvmVisibility _visibility = it.getVisibility();
      String _javaName = this.javaName(_visibility);
      appendable.append(_javaName);
      boolean _isAbstract = it.isAbstract();
      if (_isAbstract) {
        appendable.append("abstract ");
      }
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        appendable.append("static ");
      }
      ITreeAppendable _xifexpression = null;
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        ITreeAppendable _append = appendable.append("final ");
        _xifexpression = _append;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateModifier(final JvmField it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      JvmVisibility _visibility = it.getVisibility();
      String _javaName = this.javaName(_visibility);
      appendable.append(_javaName);
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        appendable.append("final ");
      }
      ITreeAppendable _xifexpression = null;
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        ITreeAppendable _append = appendable.append("static ");
        _xifexpression = _append;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateModifier(final JvmOperation it, final ITreeAppendable appendable) {
    ITreeAppendable _xblockexpression = null;
    {
      JvmVisibility _visibility = it.getVisibility();
      String _javaName = this.javaName(_visibility);
      appendable.append(_javaName);
      boolean _isAbstract = it.isAbstract();
      if (_isAbstract) {
        appendable.append("abstract ");
      }
      boolean _isStatic = it.isStatic();
      if (_isStatic) {
        appendable.append("static ");
      }
      ITreeAppendable _xifexpression = null;
      boolean _isFinal = it.isFinal();
      if (_isFinal) {
        ITreeAppendable _append = appendable.append("final ");
        _xifexpression = _append;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected ITreeAppendable _generateModifier(final JvmConstructor it, final ITreeAppendable appendable) {
    JvmVisibility _visibility = it.getVisibility();
    String _javaName = this.javaName(_visibility);
    ITreeAppendable _append = appendable.append(_javaName);
    return _append;
  }
  
  /**
   * Returns the visibility modifier and a space as suffix if not empty
   */
  public String javaName(final JvmVisibility visibility) {
    boolean _notEquals = (!Objects.equal(visibility, null));
    if (_notEquals) {
      String _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(visibility,JvmVisibility.PRIVATE)) {
          _matched=true;
          _switchResult = "private ";
        }
      }
      if (!_matched) {
        if (Objects.equal(visibility,JvmVisibility.PUBLIC)) {
          _matched=true;
          _switchResult = "public ";
        }
      }
      if (!_matched) {
        if (Objects.equal(visibility,JvmVisibility.PROTECTED)) {
          _matched=true;
          _switchResult = "protected ";
        }
      }
      if (!_matched) {
        if (Objects.equal(visibility,JvmVisibility.DEFAULT)) {
          _matched=true;
          _switchResult = "";
        }
      }
      return _switchResult;
    } else {
      return "";
    }
  }
  
  public void generateExtendsClause(final JvmDeclaredType it, final ITreeAppendable appendable) {
    EList<JvmTypeReference> _superTypes = it.getSuperTypes();
    boolean _isEmpty = _superTypes.isEmpty();
    if (_isEmpty) {
      return;
    }
    final Procedure2<Iterable<JvmTypeReference>,String> _function = new Procedure2<Iterable<JvmTypeReference>,String>() {
        public void apply(final Iterable<JvmTypeReference> it, final String prefix) {
          {
            boolean _isEmpty = IterableExtensions.isEmpty(it);
            if (_isEmpty) {
              return;
            }
            ITreeAppendable _append = appendable.append(prefix);
            _append.append(" ");
            JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(it);
            JvmModelGenerator.this.serialize(_head, appendable);
            Iterable<JvmTypeReference> _tail = IterableExtensions.<JvmTypeReference>tail(it);
            final Procedure1<JvmTypeReference> _function = new Procedure1<JvmTypeReference>() {
                public void apply(final JvmTypeReference it) {
                  appendable.append(", ");
                  JvmModelGenerator.this.serialize(it, appendable);
                }
              };
            IterableExtensions.<JvmTypeReference>forEach(_tail, _function);
            appendable.append(" ");
          }
        }
      };
    final Procedure2<? super Iterable<JvmTypeReference>,? super String> commaDelimited = _function;
    boolean _and = false;
    if (!(it instanceof JvmGenericType)) {
      _and = false;
    } else {
      boolean _isInterface = ((JvmGenericType) it).isInterface();
      _and = ((it instanceof JvmGenericType) && _isInterface);
    }
    if (_and) {
      EList<JvmTypeReference> _superTypes_1 = it.getSuperTypes();
      commaDelimited.apply(_superTypes_1, "extends");
    } else {
      EList<JvmTypeReference> _superTypes_2 = it.getSuperTypes();
      final Function1<JvmTypeReference,Boolean> _function_1 = new Function1<JvmTypeReference,Boolean>() {
          public Boolean apply(final JvmTypeReference typeRef) {
            String _identifier = typeRef.getIdentifier();
            boolean _notEquals = (!Objects.equal(_identifier, "java.lang.Object"));
            return Boolean.valueOf(_notEquals);
          }
        };
      final Iterable<JvmTypeReference> withoutObject = IterableExtensions.<JvmTypeReference>filter(_superTypes_2, _function_1);
      final Function1<JvmTypeReference,Boolean> _function_2 = new Function1<JvmTypeReference,Boolean>() {
          public Boolean apply(final JvmTypeReference typeRef) {
            boolean _and = false;
            JvmType _type = typeRef.getType();
            if (!(_type instanceof JvmGenericType)) {
              _and = false;
            } else {
              JvmType _type_1 = typeRef.getType();
              boolean _isInterface = ((JvmGenericType) _type_1).isInterface();
              boolean _not = (!_isInterface);
              _and = ((_type instanceof JvmGenericType) && _not);
            }
            return Boolean.valueOf(_and);
          }
        };
      Iterable<JvmTypeReference> _filter = IterableExtensions.<JvmTypeReference>filter(withoutObject, _function_2);
      final JvmTypeReference superClazz = IterableExtensions.<JvmTypeReference>head(_filter);
      final Function1<JvmTypeReference,Boolean> _function_3 = new Function1<JvmTypeReference,Boolean>() {
          public Boolean apply(final JvmTypeReference typeRef) {
            boolean _notEquals = (!Objects.equal(typeRef, superClazz));
            return Boolean.valueOf(_notEquals);
          }
        };
      final Iterable<JvmTypeReference> superInterfaces = IterableExtensions.<JvmTypeReference>filter(withoutObject, _function_3);
      boolean _notEquals = (!Objects.equal(superClazz, null));
      if (_notEquals) {
        appendable.append("extends ");
        this.serialize(superClazz, appendable);
        appendable.append(" ");
      }
      boolean _isEmpty_1 = IterableExtensions.isEmpty(superInterfaces);
      boolean _not = (!_isEmpty_1);
      if (_not) {
        commaDelimited.apply(superInterfaces, "implements");
      }
    }
  }
  
  public boolean generateEnumLiteral(final JvmEnumerationLiteral it, final ITreeAppendable appendable, final boolean first) {
    boolean _not = (!first);
    if (_not) {
      ITreeAppendable _append = appendable.append(",");
      _append.newLine();
    }
    ITreeAppendable _increaseIndentation = appendable.increaseIndentation();
    _increaseIndentation.newLine();
    this.generateJavaDoc(it, appendable);
    this.generateAnnotations(it, appendable, true);
    String _simpleName = it.getSimpleName();
    appendable.append(_simpleName);
    appendable.decreaseIndentation();
    return false;
  }
  
  protected boolean _generateMember(final JvmMember it, final ITreeAppendable appendable, final boolean first) {
    String _plus = ("generateMember not implemented for elements of type " + it);
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException(_plus);
    throw _unsupportedOperationException;
  }
  
  protected boolean _generateMember(final JvmGenericType it, final ITreeAppendable appendable, final boolean first) {
    ITreeAppendable _increaseIndentation = appendable.increaseIndentation();
    _increaseIndentation.newLine();
    this.generateBody(it, appendable);
    appendable.decreaseIndentation();
    return false;
  }
  
  protected boolean _generateMember(final JvmField it, final ITreeAppendable appendable, final boolean first) {
    ITreeAppendable _increaseIndentation = appendable.increaseIndentation();
    _increaseIndentation.newLine();
    boolean _not = (!first);
    if (_not) {
      appendable.newLine();
    }
    this.generateJavaDoc(it, appendable);
    final ITreeAppendable tracedAppendable = appendable.trace(it);
    this.generateAnnotations(it, tracedAppendable, true);
    this.generateModifier(it, tracedAppendable);
    JvmTypeReference _type = it.getType();
    this.serialize(_type, tracedAppendable);
    tracedAppendable.append(" ");
    ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
    String _simpleName = it.getSimpleName();
    _traceSignificant.append(_simpleName);
    this.generateInitialization(it, tracedAppendable);
    tracedAppendable.append(";");
    appendable.decreaseIndentation();
    return false;
  }
  
  protected boolean _generateMember(final JvmOperation it, final ITreeAppendable appendable, final boolean first) {
    ITreeAppendable _increaseIndentation = appendable.increaseIndentation();
    _increaseIndentation.newLine();
    boolean _not = (!first);
    if (_not) {
      appendable.newLine();
    }
    this.generateJavaDoc(it, appendable);
    final ITreeAppendable tracedAppendable = appendable.trace(it);
    this.generateAnnotations(it, tracedAppendable, true);
    this.generateModifier(it, tracedAppendable);
    this.generateTypeParameterDeclaration(it, tracedAppendable);
    JvmTypeReference _returnType = it.getReturnType();
    boolean _equals = Objects.equal(_returnType, null);
    if (_equals) {
      tracedAppendable.append("void");
    } else {
      JvmTypeReference _returnType_1 = it.getReturnType();
      this.serialize(_returnType_1, tracedAppendable);
    }
    tracedAppendable.append(" ");
    ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
    String _simpleName = it.getSimpleName();
    _traceSignificant.append(_simpleName);
    tracedAppendable.append("(");
    this.generateParameters(it, tracedAppendable);
    tracedAppendable.append(")");
    this.generateThrowsClause(it, tracedAppendable);
    boolean _isAbstract = it.isAbstract();
    if (_isAbstract) {
      tracedAppendable.append(";");
    } else {
      tracedAppendable.append(" ");
      this.generateExecutableBody(it, tracedAppendable);
    }
    appendable.decreaseIndentation();
    return false;
  }
  
  protected boolean _generateMember(final JvmConstructor it, final ITreeAppendable appendable, final boolean first) {
    boolean _isSingleSyntheticDefaultConstructor = this._jvmTypeExtensions.isSingleSyntheticDefaultConstructor(it);
    boolean _not = (!_isSingleSyntheticDefaultConstructor);
    if (_not) {
      ITreeAppendable _increaseIndentation = appendable.increaseIndentation();
      _increaseIndentation.newLine();
      boolean _not_1 = (!first);
      if (_not_1) {
        appendable.newLine();
      }
      this.generateJavaDoc(it, appendable);
      final ITreeAppendable tracedAppendable = appendable.trace(it);
      this.generateAnnotations(it, tracedAppendable, true);
      this.generateModifier(it, tracedAppendable);
      this.generateTypeParameterDeclaration(it, tracedAppendable);
      ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
      String _simpleName = it.getSimpleName();
      _traceSignificant.append(_simpleName);
      tracedAppendable.append("(");
      this.generateParameters(it, tracedAppendable);
      tracedAppendable.append(")");
      this.generateThrowsClause(it, tracedAppendable);
      tracedAppendable.append(" ");
      this.generateExecutableBody(it, tracedAppendable);
      appendable.decreaseIndentation();
      return false;
    }
    return first;
  }
  
  public void generateInitialization(final JvmField it, final ITreeAppendable appendable) {
    Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(it);
    boolean _notEquals = (!Objects.equal(_compilationStrategy, null));
    if (_notEquals) {
      appendable.append(" = ");
      appendable.increaseIndentation();
      Procedure1<? super ITreeAppendable> _compilationStrategy_1 = this._jvmTypeExtensions.getCompilationStrategy(it);
      _compilationStrategy_1.apply(appendable);
      appendable.decreaseIndentation();
    } else {
      final XExpression expression = this._iLogicalContainerProvider.getAssociatedExpression(it);
      boolean _notEquals_1 = (!Objects.equal(expression, null));
      if (_notEquals_1) {
        appendable.append(" = ");
        JvmTypeReference _type = it.getType();
        this.compiler.compileAsJavaExpression(expression, appendable, _type);
      } else {
        /* "" */
      }
    }
  }
  
  public void generateTypeParameterDeclaration(final JvmTypeParameterDeclarator it, final ITreeAppendable appendable) {
    EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
    boolean _isEmpty = _typeParameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      appendable.append("<");
      EList<JvmTypeParameter> _typeParameters_1 = it.getTypeParameters();
      JvmTypeParameter _head = IterableExtensions.<JvmTypeParameter>head(_typeParameters_1);
      this.generateTypeParameterDeclaration(_head, appendable);
      EList<JvmTypeParameter> _typeParameters_2 = it.getTypeParameters();
      Iterable<JvmTypeParameter> _tail = IterableExtensions.<JvmTypeParameter>tail(_typeParameters_2);
      final Procedure1<JvmTypeParameter> _function = new Procedure1<JvmTypeParameter>() {
          public void apply(final JvmTypeParameter it) {
            appendable.append(", ");
            JvmModelGenerator.this.generateTypeParameterDeclaration(it, appendable);
          }
        };
      IterableExtensions.<JvmTypeParameter>forEach(_tail, _function);
      appendable.append("> ");
    }
  }
  
  public void generateTypeParameterDeclaration(final JvmTypeParameter it, final ITreeAppendable appendable) {
    final ITreeAppendable tracedAppendable = appendable.trace(it);
    ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
    String _name = it.getName();
    _traceSignificant.append(_name);
    this.generateTypeParameterConstraints(it, tracedAppendable);
  }
  
  public void generateTypeParameterConstraints(final JvmTypeParameter it, final ITreeAppendable appendable) {
    EList<JvmTypeConstraint> _constraints = it.getConstraints();
    final Iterable<JvmUpperBound> upperBounds = Iterables.<JvmUpperBound>filter(_constraints, JvmUpperBound.class);
    boolean _isEmpty = IterableExtensions.isEmpty(upperBounds);
    boolean _not = (!_isEmpty);
    if (_not) {
      appendable.append(" extends ");
      JvmUpperBound _head = IterableExtensions.<JvmUpperBound>head(upperBounds);
      JvmTypeReference _typeReference = _head.getTypeReference();
      this.serialize(_typeReference, appendable);
      Iterable<JvmUpperBound> _tail = IterableExtensions.<JvmUpperBound>tail(upperBounds);
      final Procedure1<JvmUpperBound> _function = new Procedure1<JvmUpperBound>() {
          public void apply(final JvmUpperBound it) {
            appendable.append(" & ");
            JvmTypeReference _typeReference = it.getTypeReference();
            JvmModelGenerator.this.serialize(_typeReference, appendable);
          }
        };
      IterableExtensions.<JvmUpperBound>forEach(_tail, _function);
    }
  }
  
  public void generateThrowsClause(final JvmExecutable it, final ITreeAppendable appendable) {
    final HashSet<JvmType> seenExceptions = CollectionLiterals.<JvmType>newHashSet();
    EList<JvmTypeReference> _exceptions = it.getExceptions();
    boolean _isEmpty = _exceptions.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      appendable.append(" throws ");
      EList<JvmTypeReference> _exceptions_1 = it.getExceptions();
      JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_exceptions_1);
      JvmType _type = _head.getType();
      seenExceptions.add(_type);
      EList<JvmTypeReference> _exceptions_2 = it.getExceptions();
      JvmTypeReference _head_1 = IterableExtensions.<JvmTypeReference>head(_exceptions_2);
      ITreeAppendable _trace = appendable.trace(_head_1);
      EList<JvmTypeReference> _exceptions_3 = it.getExceptions();
      JvmTypeReference _head_2 = IterableExtensions.<JvmTypeReference>head(_exceptions_3);
      JvmType _type_1 = _head_2.getType();
      _trace.append(_type_1);
      EList<JvmTypeReference> _exceptions_4 = it.getExceptions();
      Iterable<JvmTypeReference> _tail = IterableExtensions.<JvmTypeReference>tail(_exceptions_4);
      final Procedure1<JvmTypeReference> _function = new Procedure1<JvmTypeReference>() {
          public void apply(final JvmTypeReference exception) {
            JvmType _type = exception.getType();
            boolean _add = seenExceptions.add(_type);
            if (_add) {
              appendable.append(", ");
              ITreeAppendable _trace = appendable.trace(exception);
              JvmType _type_1 = exception.getType();
              _trace.append(_type_1);
            }
          }
        };
      IterableExtensions.<JvmTypeReference>forEach(_tail, _function);
    }
  }
  
  public void generateParameters(final JvmExecutable it, final ITreeAppendable appendable) {
    EList<JvmFormalParameter> _parameters = it.getParameters();
    boolean _isEmpty = _parameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EList<JvmFormalParameter> _parameters_1 = it.getParameters();
      int _size = _parameters_1.size();
      int _minus = (_size - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      for (final Integer i : _upTo) {
        {
          int _plus = ((i).intValue() + 1);
          EList<JvmFormalParameter> _parameters_2 = it.getParameters();
          int _size_1 = _parameters_2.size();
          final boolean last = (_plus == _size_1);
          EList<JvmFormalParameter> _parameters_3 = it.getParameters();
          final JvmFormalParameter p = _parameters_3.get((i).intValue());
          boolean _and = false;
          if (!last) {
            _and = false;
          } else {
            boolean _isVarArgs = it.isVarArgs();
            _and = (last && _isVarArgs);
          }
          this.generateParameter(p, appendable, _and);
          boolean _not_1 = (!last);
          if (_not_1) {
            appendable.append(", ");
          }
        }
      }
    }
  }
  
  public void generateParameter(final JvmFormalParameter it, final ITreeAppendable appendable, final boolean vararg) {
    final ITreeAppendable tracedAppendable = appendable.trace(it);
    this.generateAnnotations(it, tracedAppendable, false);
    tracedAppendable.append("final ");
    if (vararg) {
      JvmTypeReference _parameterType = it.getParameterType();
      JvmTypeReference _componentType = ((JvmGenericArrayTypeReference) _parameterType).getComponentType();
      this.serialize(_componentType, tracedAppendable);
      tracedAppendable.append("...");
    } else {
      JvmTypeReference _parameterType_1 = it.getParameterType();
      this.serialize(_parameterType_1, tracedAppendable);
    }
    tracedAppendable.append(" ");
    String _simpleName = it.getSimpleName();
    String _makeJavaIdentifier = this.makeJavaIdentifier(_simpleName);
    final String name = tracedAppendable.declareVariable(it, _makeJavaIdentifier);
    ITreeAppendable _traceSignificant = this._treeAppendableUtil.traceSignificant(tracedAppendable, it);
    _traceSignificant.append(name);
  }
  
  public void generateExecutableBody(final JvmExecutable op, final ITreeAppendable appendable) {
    Procedure1<? super ITreeAppendable> _compilationStrategy = this._jvmTypeExtensions.getCompilationStrategy(op);
    boolean _notEquals = (!Objects.equal(_compilationStrategy, null));
    if (_notEquals) {
      appendable.openScope();
      ITreeAppendable _increaseIndentation = appendable.increaseIndentation();
      ITreeAppendable _append = _increaseIndentation.append("{");
      _append.newLine();
      Procedure1<? super ITreeAppendable> _compilationStrategy_1 = this._jvmTypeExtensions.getCompilationStrategy(op);
      _compilationStrategy_1.apply(appendable);
      ITreeAppendable _decreaseIndentation = appendable.decreaseIndentation();
      ITreeAppendable _newLine = _decreaseIndentation.newLine();
      _newLine.append("}");
      appendable.closeScope();
    } else {
      final XExpression expression = this._iLogicalContainerProvider.getAssociatedExpression(op);
      boolean _notEquals_1 = (!Objects.equal(expression, null));
      if (_notEquals_1) {
        appendable.openScope();
        JvmTypeReference _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (op instanceof JvmOperation) {
            final JvmOperation _jvmOperation = (JvmOperation)op;
            _matched=true;
            JvmTypeReference _returnType = _jvmOperation.getReturnType();
            _switchResult = _returnType;
          }
        }
        if (!_matched) {
          if (op instanceof JvmConstructor) {
            final JvmConstructor _jvmConstructor = (JvmConstructor)op;
            _matched=true;
            JvmTypeReference _typeForName = this._typeReferences.getTypeForName(Void.TYPE, _jvmConstructor);
            _switchResult = _typeForName;
          }
        }
        if (!_matched) {
          _switchResult = null;
        }
        final JvmTypeReference returnType = _switchResult;
        boolean _and = false;
        boolean _and_1 = false;
        if (!(expression instanceof XBlockExpression)) {
          _and_1 = false;
        } else {
          EList<XExpression> _expressions = ((XBlockExpression) expression).getExpressions();
          int _size = _expressions.size();
          boolean _notEquals_2 = (_size != 1);
          _and_1 = ((expression instanceof XBlockExpression) && _notEquals_2);
        }
        if (!_and_1) {
          _and = false;
        } else {
          _and = (_and_1 && (returnType instanceof JvmVoid));
        }
        if (_and) {
          final XBlockExpression block = ((XBlockExpression) expression);
          EList<XExpression> _expressions_1 = block.getExpressions();
          boolean _isEmpty = _expressions_1.isEmpty();
          if (_isEmpty) {
            appendable.append("{}");
          } else {
            EList<JvmTypeReference> _exceptions = op.getExceptions();
            Set<JvmTypeReference> _set = IterableExtensions.<JvmTypeReference>toSet(_exceptions);
            this.compiler.compile(expression, appendable, returnType, _set);
          }
        } else {
          ITreeAppendable _append_1 = appendable.append("{");
          _append_1.increaseIndentation();
          EList<JvmTypeReference> _exceptions_1 = op.getExceptions();
          Set<JvmTypeReference> _set_1 = IterableExtensions.<JvmTypeReference>toSet(_exceptions_1);
          this.compiler.compile(expression, appendable, returnType, _set_1);
          ITreeAppendable _decreaseIndentation_1 = appendable.decreaseIndentation();
          ITreeAppendable _newLine_1 = _decreaseIndentation_1.newLine();
          _newLine_1.append("}");
        }
        appendable.closeScope();
      } else {
        if ((op instanceof JvmOperation)) {
          ITreeAppendable _increaseIndentation_1 = appendable.increaseIndentation();
          ITreeAppendable _append_2 = _increaseIndentation_1.append("{");
          _append_2.newLine();
          appendable.append("throw new UnsupportedOperationException(\"");
          String _simpleName = op.getSimpleName();
          appendable.append(_simpleName);
          appendable.append("is not implemented\");");
          ITreeAppendable _decreaseIndentation_2 = appendable.decreaseIndentation();
          ITreeAppendable _newLine_2 = _decreaseIndentation_2.newLine();
          _newLine_2.append("}");
        } else {
          if ((op instanceof JvmConstructor)) {
            ITreeAppendable _append_3 = appendable.append("{");
            ITreeAppendable _newLine_3 = _append_3.newLine();
            _newLine_3.append("}");
          }
        }
      }
    }
  }
  
  public void generateJavaDoc(final EObject it, final ITreeAppendable appendable) {
    EList<Adapter> _eAdapters = it.eAdapters();
    Iterable<DocumentationAdapter> _filter = Iterables.<DocumentationAdapter>filter(_eAdapters, DocumentationAdapter.class);
    final DocumentationAdapter adapter = IterableExtensions.<DocumentationAdapter>head(_filter);
    String _documentation = adapter==null?(String)null:adapter.getDocumentation();
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_documentation);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      final StringConcatenation doc = ((StringConcatenation) _builder);
      doc.newLine();
      doc.append(" * ");
      String _documentation_1 = adapter.getDocumentation();
      doc.append(_documentation_1, " * ");
      doc.newLine();
      doc.append(" */");
      final Set<EObject> sourceElements = this.jvmModelAssociations.getSourceElements(it);
      boolean _and = false;
      int _size = sourceElements.size();
      boolean _equals = (_size == 1);
      if (!_equals) {
        _and = false;
      } else {
        _and = (_equals && (this.documentationProvider instanceof IEObjectDocumentationProviderExtension));
      }
      if (_and) {
        EObject _head = IterableExtensions.<EObject>head(sourceElements);
        final List<INode> documentationNodes = ((IEObjectDocumentationProviderExtension) this.documentationProvider).getDocumentationNodes(_head);
        boolean _isEmpty = documentationNodes.isEmpty();
        boolean _not_1 = (!_isEmpty);
        if (_not_1) {
          ITextRegionWithLineInformation documentationTrace = ITextRegionWithLineInformation.EMPTY_REGION;
          for (final INode node : documentationNodes) {
            int _offset = node.getOffset();
            int _length = node.getLength();
            int _startLine = node.getStartLine();
            int _endLine = node.getEndLine();
            TextRegionWithLineInformation _textRegionWithLineInformation = new TextRegionWithLineInformation(_offset, _length, _startLine, _endLine);
            ITextRegionWithLineInformation _merge = documentationTrace.merge(_textRegionWithLineInformation);
            documentationTrace = _merge;
          }
          LocationData _locationData = new LocationData(documentationTrace, null, null);
          ITreeAppendable _trace = appendable.trace(_locationData);
          String _string = doc.toString();
          _trace.append(_string);
          appendable.newLine();
          return;
        }
      }
      String _string_1 = doc.toString();
      ITreeAppendable _append = appendable.append(_string_1);
      _append.newLine();
    }
  }
  
  public void generateAnnotations(final JvmAnnotationTarget it, final ITreeAppendable appendable, final boolean withLineBreak) {
    EList<JvmAnnotationReference> _annotations = it.getAnnotations();
    boolean _isEmpty = _annotations.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EList<JvmAnnotationReference> _annotations_1 = it.getAnnotations();
      JvmAnnotationReference _head = IterableExtensions.<JvmAnnotationReference>head(_annotations_1);
      this.generateAnnotation(_head, appendable);
      EList<JvmAnnotationReference> _annotations_2 = it.getAnnotations();
      Iterable<JvmAnnotationReference> _tail = IterableExtensions.<JvmAnnotationReference>tail(_annotations_2);
      final Procedure1<JvmAnnotationReference> _function = new Procedure1<JvmAnnotationReference>() {
          public void apply(final JvmAnnotationReference it) {
            if (withLineBreak) {
              appendable.newLine();
            } else {
              appendable.append(" ");
            }
            JvmModelGenerator.this.generateAnnotation(it, appendable);
          }
        };
      IterableExtensions.<JvmAnnotationReference>forEach(_tail, _function);
      if (withLineBreak) {
        appendable.newLine();
      } else {
        appendable.append(" ");
      }
    }
  }
  
  public void generateAnnotation(final JvmAnnotationReference it, final ITreeAppendable appendable) {
    appendable.append("@");
    JvmAnnotationType _annotation = it.getAnnotation();
    appendable.append(_annotation);
    EList<JvmAnnotationValue> _values = it.getValues();
    boolean _isEmpty = _values.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      appendable.append("(");
      EList<JvmAnnotationValue> _values_1 = it.getValues();
      JvmAnnotationValue _head = IterableExtensions.<JvmAnnotationValue>head(_values_1);
      this.toJava(_head, appendable);
      EList<JvmAnnotationValue> _values_2 = it.getValues();
      Iterable<JvmAnnotationValue> _tail = IterableExtensions.<JvmAnnotationValue>tail(_values_2);
      final Procedure1<JvmAnnotationValue> _function = new Procedure1<JvmAnnotationValue>() {
          public void apply(final JvmAnnotationValue it) {
            appendable.append(", ");
            JvmModelGenerator.this.toJava(it, appendable);
          }
        };
      IterableExtensions.<JvmAnnotationValue>forEach(_tail, _function);
      appendable.append(")");
    }
  }
  
  public void toJava(final JvmAnnotationValue it, final ITreeAppendable appendable) {
    JvmOperation _operation = it.getOperation();
    boolean _notEquals = (!Objects.equal(_operation, null));
    if (_notEquals) {
      JvmOperation _operation_1 = it.getOperation();
      String _simpleName = _operation_1.getSimpleName();
      appendable.append(_simpleName);
      appendable.append(" = ");
    }
    this.toJavaLiteral(it, appendable);
  }
  
  protected void _toJavaLiteral(final JvmAnnotationAnnotationValue it, final ITreeAppendable appendable) {
    EList<JvmAnnotationReference> _values = it.getValues();
    int _size = _values.size();
    boolean _notEquals = (_size != 1);
    if (_notEquals) {
      appendable.append("{ ");
      this.generateAnnotations(it, appendable, false);
      appendable.append("} ");
    } else {
      this.generateAnnotations(it, appendable, false);
    }
  }
  
  protected void _toJavaLiteral(final JvmShortAnnotationValue it, final ITreeAppendable appendable) {
    EList<Short> _values = it.getValues();
    int _size = _values.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      EList<Short> _values_1 = it.getValues();
      Short _head = IterableExtensions.<Short>head(_values_1);
      String _string = _head.toString();
      appendable.append(_string);
    } else {
      EList<Short> _values_2 = it.getValues();
      final Function1<Short,String> _function = new Function1<Short,String>() {
          public String apply(final Short it) {
            String _string = it.toString();
            return _string;
          }
        };
      String _join = IterableExtensions.<Short>join(_values_2, "{ ", ", ", " }", _function);
      appendable.append(_join);
    }
  }
  
  protected void _toJavaLiteral(final JvmIntAnnotationValue it, final ITreeAppendable appendable) {
    EList<Integer> _values = it.getValues();
    int _size = _values.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      EList<Integer> _values_1 = it.getValues();
      Integer _head = IterableExtensions.<Integer>head(_values_1);
      String _string = _head.toString();
      appendable.append(_string);
    } else {
      EList<Integer> _values_2 = it.getValues();
      final Function1<Integer,String> _function = new Function1<Integer,String>() {
          public String apply(final Integer it) {
            String _string = it.toString();
            return _string;
          }
        };
      String _join = IterableExtensions.<Integer>join(_values_2, "{ ", ", ", " }", _function);
      appendable.append(_join);
    }
  }
  
  protected void _toJavaLiteral(final JvmLongAnnotationValue it, final ITreeAppendable appendable) {
    EList<Long> _values = it.getValues();
    int _size = _values.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      EList<Long> _values_1 = it.getValues();
      Long _head = IterableExtensions.<Long>head(_values_1);
      String _string = _head.toString();
      appendable.append(_string);
    } else {
      EList<Long> _values_2 = it.getValues();
      final Function1<Long,String> _function = new Function1<Long,String>() {
          public String apply(final Long it) {
            String _string = it.toString();
            return _string;
          }
        };
      String _join = IterableExtensions.<Long>join(_values_2, "{ ", ", ", " }", _function);
      appendable.append(_join);
    }
  }
  
  protected void _toJavaLiteral(final JvmByteAnnotationValue it, final ITreeAppendable appendable) {
    EList<Byte> _values = it.getValues();
    int _size = _values.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      EList<Byte> _values_1 = it.getValues();
      Byte _head = IterableExtensions.<Byte>head(_values_1);
      String _string = _head.toString();
      appendable.append(_string);
    } else {
      EList<Byte> _values_2 = it.getValues();
      final Function1<Byte,String> _function = new Function1<Byte,String>() {
          public String apply(final Byte it) {
            String _string = it.toString();
            return _string;
          }
        };
      String _join = IterableExtensions.<Byte>join(_values_2, "{ ", ", ", " }", _function);
      appendable.append(_join);
    }
  }
  
  protected void _toJavaLiteral(final JvmDoubleAnnotationValue it, final ITreeAppendable appendable) {
    EList<Double> _values = it.getValues();
    int _size = _values.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      EList<Double> _values_1 = it.getValues();
      Double _head = IterableExtensions.<Double>head(_values_1);
      String _string = _head.toString();
      appendable.append(_string);
    } else {
      EList<Double> _values_2 = it.getValues();
      final Function1<Double,String> _function = new Function1<Double,String>() {
          public String apply(final Double it) {
            String _switchResult = null;
            boolean _matched = false;
            if (!_matched) {
              boolean _isNaN = Double.isNaN((it).doubleValue());
              if (_isNaN) {
                _matched=true;
                _switchResult = "Double.NaN";
              }
            }
            if (!_matched) {
              if (Objects.equal(it,Double.POSITIVE_INFINITY)) {
                _matched=true;
                _switchResult = "Double.POSITIVE_INFINITY";
              }
            }
            if (!_matched) {
              if (Objects.equal(it,Double.NEGATIVE_INFINITY)) {
                _matched=true;
                _switchResult = "Double.NEGATIVE_INFINITY";
              }
            }
            if (!_matched) {
              String _string = it.toString();
              String _plus = (_string + "d");
              _switchResult = _plus;
            }
            return _switchResult;
          }
        };
      String _join = IterableExtensions.<Double>join(_values_2, "{ ", ", ", " }", _function);
      appendable.append(_join);
    }
  }
  
  protected void _toJavaLiteral(final JvmFloatAnnotationValue it, final ITreeAppendable appendable) {
    EList<Float> _values = it.getValues();
    int _size = _values.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      EList<Float> _values_1 = it.getValues();
      Float _head = IterableExtensions.<Float>head(_values_1);
      String _string = _head.toString();
      appendable.append(_string);
    } else {
      EList<Float> _values_2 = it.getValues();
      final Function1<Float,String> _function = new Function1<Float,String>() {
          public String apply(final Float it) {
            String _switchResult = null;
            boolean _matched = false;
            if (!_matched) {
              boolean _isNaN = Float.isNaN((it).floatValue());
              if (_isNaN) {
                _matched=true;
                _switchResult = "Float.NaN";
              }
            }
            if (!_matched) {
              if (Objects.equal(it,Float.POSITIVE_INFINITY)) {
                _matched=true;
                _switchResult = "Float.POSITIVE_INFINITY";
              }
            }
            if (!_matched) {
              if (Objects.equal(it,Float.NEGATIVE_INFINITY)) {
                _matched=true;
                _switchResult = "Float.NEGATIVE_INFINITY";
              }
            }
            if (!_matched) {
              String _string = it.toString();
              String _plus = (_string + "f");
              _switchResult = _plus;
            }
            return _switchResult;
          }
        };
      String _join = IterableExtensions.<Float>join(_values_2, "{ ", ", ", " }", _function);
      appendable.append(_join);
    }
  }
  
  protected void _toJavaLiteral(final JvmCharAnnotationValue it, final ITreeAppendable appendable) {
    EList<Character> _values = it.getValues();
    int _size = _values.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      EList<Character> _values_1 = it.getValues();
      Character _head = IterableExtensions.<Character>head(_values_1);
      String _string = _head.toString();
      String _convertToJavaString = Strings.convertToJavaString(_string, true);
      String _plus = ("\'" + _convertToJavaString);
      String _plus_1 = (_plus + "\'");
      appendable.append(_plus_1);
    } else {
      EList<Character> _values_2 = it.getValues();
      final Function1<Character,String> _function = new Function1<Character,String>() {
          public String apply(final Character it) {
            String _string = it.toString();
            String _convertToJavaString = Strings.convertToJavaString(_string, true);
            String _plus = ("\'" + _convertToJavaString);
            String _plus_1 = (_plus + "\'");
            return _plus_1;
          }
        };
      String _join = IterableExtensions.<Character>join(_values_2, "{ ", ", ", " }", _function);
      appendable.append(_join);
    }
  }
  
  protected void _toJavaLiteral(final JvmStringAnnotationValue it, final ITreeAppendable appendable) {
    EList<String> _values = it.getValues();
    int _size = _values.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      EList<String> _values_1 = it.getValues();
      String _head = IterableExtensions.<String>head(_values_1);
      String _convertToJavaString = Strings.convertToJavaString(_head, true);
      String _plus = ("\"" + _convertToJavaString);
      String _plus_1 = (_plus + "\"");
      appendable.append(_plus_1);
    } else {
      EList<String> _values_2 = it.getValues();
      final Function1<String,String> _function = new Function1<String,String>() {
          public String apply(final String it) {
            String _convertToJavaString = Strings.convertToJavaString(it, true);
            String _plus = ("\"" + _convertToJavaString);
            String _plus_1 = (_plus + "\"");
            return _plus_1;
          }
        };
      String _join = IterableExtensions.<String>join(_values_2, "{ ", ", ", " }", _function);
      appendable.append(_join);
    }
  }
  
  protected void _toJavaLiteral(final JvmTypeAnnotationValue it, final ITreeAppendable appendable) {
    EList<JvmTypeReference> _values = it.getValues();
    int _size = _values.size();
    boolean _notEquals = (_size != 1);
    if (_notEquals) {
      appendable.append("{ ");
      EList<JvmTypeReference> _values_1 = it.getValues();
      boolean _isEmpty = _values_1.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        EList<JvmTypeReference> _values_2 = it.getValues();
        JvmTypeReference _head = IterableExtensions.<JvmTypeReference>head(_values_2);
        JvmType _type = _head.getType();
        appendable.append(_type);
        appendable.append(".class");
        EList<JvmTypeReference> _values_3 = it.getValues();
        Iterable<JvmTypeReference> _tail = IterableExtensions.<JvmTypeReference>tail(_values_3);
        final Procedure1<JvmTypeReference> _function = new Procedure1<JvmTypeReference>() {
            public void apply(final JvmTypeReference it) {
              appendable.append(", ");
              JvmType _type = it.getType();
              appendable.append(_type);
              appendable.append(".class");
            }
          };
        IterableExtensions.<JvmTypeReference>forEach(_tail, _function);
      }
      appendable.append(" }");
    } else {
      EList<JvmTypeReference> _values_4 = it.getValues();
      JvmTypeReference _head_1 = IterableExtensions.<JvmTypeReference>head(_values_4);
      JvmType _type_1 = _head_1.getType();
      appendable.append(_type_1);
      appendable.append(".class");
    }
  }
  
  protected void _toJavaLiteral(final JvmEnumAnnotationValue it, final ITreeAppendable appendable) {
    EList<JvmEnumerationLiteral> _values = it.getValues();
    int _size = _values.size();
    boolean _notEquals = (_size != 1);
    if (_notEquals) {
      appendable.append("{ ");
      EList<JvmEnumerationLiteral> _values_1 = it.getValues();
      boolean _isEmpty = _values_1.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        EList<JvmEnumerationLiteral> _values_2 = it.getValues();
        JvmEnumerationLiteral _head = IterableExtensions.<JvmEnumerationLiteral>head(_values_2);
        JvmDeclaredType _declaringType = _head.getDeclaringType();
        appendable.append(_declaringType);
        appendable.append(".");
        EList<JvmEnumerationLiteral> _values_3 = it.getValues();
        JvmEnumerationLiteral _head_1 = IterableExtensions.<JvmEnumerationLiteral>head(_values_3);
        String _simpleName = _head_1.getSimpleName();
        appendable.append(_simpleName);
        EList<JvmEnumerationLiteral> _values_4 = it.getValues();
        Iterable<JvmEnumerationLiteral> _tail = IterableExtensions.<JvmEnumerationLiteral>tail(_values_4);
        final Procedure1<JvmEnumerationLiteral> _function = new Procedure1<JvmEnumerationLiteral>() {
            public void apply(final JvmEnumerationLiteral it) {
              appendable.append(", ");
              JvmDeclaredType _declaringType = it.getDeclaringType();
              appendable.append(_declaringType);
              appendable.append(".");
              String _simpleName = it.getSimpleName();
              appendable.append(_simpleName);
            }
          };
        IterableExtensions.<JvmEnumerationLiteral>forEach(_tail, _function);
      }
      appendable.append(" }");
    } else {
      EList<JvmEnumerationLiteral> _values_5 = it.getValues();
      JvmEnumerationLiteral _head_2 = IterableExtensions.<JvmEnumerationLiteral>head(_values_5);
      JvmDeclaredType _declaringType_1 = _head_2.getDeclaringType();
      appendable.append(_declaringType_1);
      appendable.append(".");
      EList<JvmEnumerationLiteral> _values_6 = it.getValues();
      JvmEnumerationLiteral _head_3 = IterableExtensions.<JvmEnumerationLiteral>head(_values_6);
      String _simpleName_1 = _head_3.getSimpleName();
      appendable.append(_simpleName_1);
    }
  }
  
  protected void _toJavaLiteral(final JvmBooleanAnnotationValue it, final ITreeAppendable appendable) {
    EList<Boolean> _values = it.getValues();
    int _size = _values.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      EList<Boolean> _values_1 = it.getValues();
      Boolean _head = IterableExtensions.<Boolean>head(_values_1);
      String _string = _head.toString();
      appendable.append(_string);
    } else {
      EList<Boolean> _values_2 = it.getValues();
      final Function1<Boolean,String> _function = new Function1<Boolean,String>() {
          public String apply(final Boolean it) {
            String _string = it.toString();
            return _string;
          }
        };
      String _join = IterableExtensions.<Boolean>join(_values_2, "{ ", ", ", " }", _function);
      appendable.append(_join);
    }
  }
  
  protected void _toJavaLiteral(final JvmCustomAnnotationValue it, final ITreeAppendable appendable) {
    EList<Object> _values = it.getValues();
    int _size = _values.size();
    final int _switchValue = _size;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,0)) {
        _matched=true;
        appendable.append("{}");
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,1)) {
        _matched=true;
        EList<Object> _values_1 = it.getValues();
        Object _head = IterableExtensions.<Object>head(_values_1);
        this.compiler.toJavaExpression(((XExpression) _head), appendable);
      }
    }
    if (!_matched) {
      {
        appendable.append("{ ");
        EList<Object> _values_2 = it.getValues();
        Object _head_1 = IterableExtensions.<Object>head(_values_2);
        this.compiler.toJavaExpression(((XExpression) _head_1), appendable);
        EList<Object> _values_3 = it.getValues();
        Iterable<Object> _tail = IterableExtensions.<Object>tail(_values_3);
        Iterable<XExpression> _filter = Iterables.<XExpression>filter(_tail, XExpression.class);
        final Procedure1<XExpression> _function = new Procedure1<XExpression>() {
            public void apply(final XExpression it) {
              appendable.append(", ");
              JvmModelGenerator.this.compiler.toJavaExpression(it, appendable);
            }
          };
        IterableExtensions.<XExpression>forEach(_filter, _function);
        appendable.append(" }");
      }
    }
  }
  
  public void serialize(final JvmTypeReference it, final ITreeAppendable appendable) {
    boolean _equals = Objects.equal(it, null);
    if (_equals) {
      NullPointerException _nullPointerException = new NullPointerException();
      JvmModelGenerator.LOG.warn("type was null", _nullPointerException);
      appendable.append("Object /* problem during compilation, see error log*/");
    } else {
      EObject _eContainer = it.eContainer();
      this.typeRefSerializer.serialize(it, _eContainer, appendable);
    }
  }
  
  public TreeAppendable createAppendable(final EObject context, final ImportManager importManager) {
    TreeAppendable _treeAppendable = new TreeAppendable(importManager, this.locationProvider, this.jvmModelAssociations, context, "  ", "\n");
    final TreeAppendable appendable = _treeAppendable;
    final JvmGenericType type = this.containerType(context);
    boolean _notEquals = (!Objects.equal(type, null));
    if (_notEquals) {
      JvmGenericType _containerType = this.containerType(context);
      appendable.declareVariable(_containerType, "this");
      JvmGenericType _containerType_1 = this.containerType(context);
      final JvmTypeReference superType = _containerType_1.getExtendedClass();
      boolean _notEquals_1 = (!Objects.equal(superType, null));
      if (_notEquals_1) {
        JvmType _type = superType.getType();
        appendable.declareVariable(_type, "super");
      }
    }
    return appendable;
  }
  
  public JvmGenericType containerType(final EObject context) {
    JvmGenericType _xifexpression = null;
    boolean _equals = Objects.equal(context, null);
    if (_equals) {
      _xifexpression = null;
    } else {
      JvmGenericType _xifexpression_1 = null;
      if ((context instanceof JvmGenericType)) {
        _xifexpression_1 = ((JvmGenericType) context);
      } else {
        EObject _eContainer = context.eContainer();
        JvmGenericType _containerType = this.containerType(_eContainer);
        _xifexpression_1 = _containerType;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected String makeJavaIdentifier(final String name) {
    String _xifexpression = null;
    boolean _isJavaKeyword = this.keywords.isJavaKeyword(name);
    if (_isJavaKeyword) {
      String _plus = (name + "_");
      _xifexpression = _plus;
    } else {
      _xifexpression = name;
    }
    return _xifexpression;
  }
  
  public void internalDoGenerate(final EObject type, final IFileSystemAccess fsa) {
    if (type instanceof JvmEnumerationType) {
      _internalDoGenerate((JvmEnumerationType)type, fsa);
      return;
    } else if (type instanceof JvmGenericType) {
      _internalDoGenerate((JvmGenericType)type, fsa);
      return;
    } else if (type != null) {
      _internalDoGenerate(type, fsa);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type, fsa).toString());
    }
  }
  
  public ITreeAppendable generateBody(final JvmDeclaredType it, final ITreeAppendable appendable) {
    if (it instanceof JvmEnumerationType) {
      return _generateBody((JvmEnumerationType)it, appendable);
    } else if (it instanceof JvmGenericType) {
      return _generateBody((JvmGenericType)it, appendable);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, appendable).toString());
    }
  }
  
  public ITreeAppendable generateModifier(final JvmMember it, final ITreeAppendable appendable) {
    if (it instanceof JvmConstructor) {
      return _generateModifier((JvmConstructor)it, appendable);
    } else if (it instanceof JvmOperation) {
      return _generateModifier((JvmOperation)it, appendable);
    } else if (it instanceof JvmDeclaredType) {
      return _generateModifier((JvmDeclaredType)it, appendable);
    } else if (it instanceof JvmField) {
      return _generateModifier((JvmField)it, appendable);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, appendable).toString());
    }
  }
  
  public boolean generateMember(final JvmMember it, final ITreeAppendable appendable, final boolean first) {
    if (it instanceof JvmConstructor) {
      return _generateMember((JvmConstructor)it, appendable, first);
    } else if (it instanceof JvmGenericType) {
      return _generateMember((JvmGenericType)it, appendable, first);
    } else if (it instanceof JvmOperation) {
      return _generateMember((JvmOperation)it, appendable, first);
    } else if (it instanceof JvmField) {
      return _generateMember((JvmField)it, appendable, first);
    } else if (it != null) {
      return _generateMember(it, appendable, first);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, appendable, first).toString());
    }
  }
  
  public void toJavaLiteral(final JvmAnnotationValue it, final ITreeAppendable appendable) {
    if (it instanceof JvmAnnotationAnnotationValue) {
      _toJavaLiteral((JvmAnnotationAnnotationValue)it, appendable);
      return;
    } else if (it instanceof JvmBooleanAnnotationValue) {
      _toJavaLiteral((JvmBooleanAnnotationValue)it, appendable);
      return;
    } else if (it instanceof JvmByteAnnotationValue) {
      _toJavaLiteral((JvmByteAnnotationValue)it, appendable);
      return;
    } else if (it instanceof JvmCharAnnotationValue) {
      _toJavaLiteral((JvmCharAnnotationValue)it, appendable);
      return;
    } else if (it instanceof JvmCustomAnnotationValue) {
      _toJavaLiteral((JvmCustomAnnotationValue)it, appendable);
      return;
    } else if (it instanceof JvmDoubleAnnotationValue) {
      _toJavaLiteral((JvmDoubleAnnotationValue)it, appendable);
      return;
    } else if (it instanceof JvmEnumAnnotationValue) {
      _toJavaLiteral((JvmEnumAnnotationValue)it, appendable);
      return;
    } else if (it instanceof JvmFloatAnnotationValue) {
      _toJavaLiteral((JvmFloatAnnotationValue)it, appendable);
      return;
    } else if (it instanceof JvmIntAnnotationValue) {
      _toJavaLiteral((JvmIntAnnotationValue)it, appendable);
      return;
    } else if (it instanceof JvmLongAnnotationValue) {
      _toJavaLiteral((JvmLongAnnotationValue)it, appendable);
      return;
    } else if (it instanceof JvmShortAnnotationValue) {
      _toJavaLiteral((JvmShortAnnotationValue)it, appendable);
      return;
    } else if (it instanceof JvmStringAnnotationValue) {
      _toJavaLiteral((JvmStringAnnotationValue)it, appendable);
      return;
    } else if (it instanceof JvmTypeAnnotationValue) {
      _toJavaLiteral((JvmTypeAnnotationValue)it, appendable);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, appendable).toString());
    }
  }
}
