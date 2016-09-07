/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.signatureHelp;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import io.typefox.lsapi.ParameterInformation;
import io.typefox.lsapi.SignatureHelp;
import io.typefox.lsapi.SignatureInformation;
import io.typefox.lsapi.impl.ParameterInformationImpl;
import io.typefox.lsapi.impl.SignatureHelpImpl;
import io.typefox.lsapi.impl.SignatureInformationImpl;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ide.server.signatureHelp.SignatureHelpService;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Operation;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.OperationCall;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Parameter;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.PrimitiveType;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Type;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Signature help service implementation for the test language.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@SuppressWarnings("all")
public class SignatureHelpServiceImpl implements SignatureHelpService {
  private final static String OPENING_CHAR = "(";
  
  private final static String CLOSING_CHAR = ")";
  
  private final static String SEPARATOR_CHAR = ",";
  
  /**
   * Shared comparator singleton to compare {@link SignatureInformation signature information} instances
   * based on the number of parameters first, then the parameter labels lexicographically.
   */
  private final static Comparator<SignatureInformation> SIGNATURE_INFO_ORDERING = ((Comparator<SignatureInformation>) (SignatureInformation left, SignatureInformation right) -> {
    List<? extends ParameterInformation> _parameters = left.getParameters();
    int _size = _parameters.size();
    List<? extends ParameterInformation> _parameters_1 = right.getParameters();
    int _size_1 = _parameters_1.size();
    int result = (_size - _size_1);
    if ((result == 0)) {
      int i = 0;
      List<? extends ParameterInformation> _parameters_2 = left.getParameters();
      int size = _parameters_2.size();
      boolean _while = (i < size);
      while (_while) {
        {
          List<? extends ParameterInformation> _parameters_3 = left.getParameters();
          ParameterInformation _get = _parameters_3.get(i);
          String _label = _get.getLabel();
          List<? extends ParameterInformation> _parameters_4 = right.getParameters();
          ParameterInformation _get_1 = _parameters_4.get(i);
          String _label_1 = _get_1.getLabel();
          int _compareTo = _label.compareTo(_label_1);
          result = _compareTo;
          if ((result != 0)) {
            return result;
          }
        }
        i++;
        _while = (i < size);
      }
    }
    return result;
  });
  
  @Inject
  private EObjectAtOffsetHelper offsetHelper;
  
  @Inject
  private IScopeProvider scopeProvider;
  
  @Extension
  private TestLanguagePackage _testLanguagePackage = TestLanguagePackage.eINSTANCE;
  
  @Override
  public SignatureHelp getSignatureHelp(final XtextResource resource, final int offset) {
    Preconditions.<XtextResource>checkNotNull(resource, "resource");
    Preconditions.checkArgument((offset >= 0), ("offset >= 0. Was: " + Integer.valueOf(offset)));
    final EObject object = this.offsetHelper.resolveContainedElementAt(resource, offset);
    if ((object instanceof OperationCall)) {
      final String operationName = this.getOperationName(((OperationCall)object));
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(operationName);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        EList<Integer> _params = ((OperationCall)object).getParams();
        final int currentParamCount = _params.size();
        final Pair<Boolean, Integer> currentParamIndexPair = this.getCurrentParamInfo(((OperationCall)object), offset);
        final Boolean incomplete = currentParamIndexPair.getFirst();
        final Integer currentParamIndex = currentParamIndexPair.getSecond();
        Iterable<Operation> _visibleOperationsWithName = this.getVisibleOperationsWithName(object, operationName);
        final Function1<Operation, Boolean> _function = (Operation it) -> {
          boolean _xifexpression = false;
          if ((incomplete).booleanValue()) {
            EList<Parameter> _params_1 = it.getParams();
            int _size = _params_1.size();
            _xifexpression = ((currentParamIndex).intValue() < _size);
          } else {
            EList<Parameter> _params_2 = it.getParams();
            int _size_1 = _params_2.size();
            _xifexpression = (currentParamCount <= _size_1);
          }
          return Boolean.valueOf(_xifexpression);
        };
        Iterable<Operation> _filter = IterableExtensions.<Operation>filter(_visibleOperationsWithName, _function);
        final List<Operation> visibleOperations = IterableExtensions.<Operation>toList(_filter);
        boolean _isNullOrEmpty_1 = IterableExtensions.isNullOrEmpty(visibleOperations);
        if (_isNullOrEmpty_1) {
          return SignatureHelpService.EMPTY;
        }
        SignatureHelpImpl _signatureHelpImpl = new SignatureHelpImpl();
        final Procedure1<SignatureHelpImpl> _function_1 = (SignatureHelpImpl it) -> {
          Integer _xifexpression = null;
          if ((currentParamCount == 0)) {
            _xifexpression = null;
          } else {
            _xifexpression = currentParamIndex;
          }
          it.setActiveParameter(_xifexpression);
          it.setActiveSignature(Integer.valueOf(0));
          final Function1<Operation, SignatureInformationImpl> _function_2 = (Operation operation) -> {
            SignatureInformationImpl _signatureInformationImpl = new SignatureInformationImpl();
            final Procedure1<SignatureInformationImpl> _function_3 = (SignatureInformationImpl it_1) -> {
              String _label = this.getLabel(operation);
              it_1.setLabel(_label);
              EList<Parameter> _params_1 = operation.getParams();
              final Function1<Parameter, ParameterInformationImpl> _function_4 = (Parameter param) -> {
                ParameterInformationImpl _parameterInformationImpl = new ParameterInformationImpl();
                final Procedure1<ParameterInformationImpl> _function_5 = (ParameterInformationImpl it_2) -> {
                  StringConcatenation _builder = new StringConcatenation();
                  String _name = param.getName();
                  _builder.append(_name, "");
                  _builder.append(": ");
                  Type _type = param.getType();
                  String _label_1 = this.getLabel(_type);
                  _builder.append(_label_1, "");
                  it_2.setLabel(_builder.toString());
                };
                return ObjectExtensions.<ParameterInformationImpl>operator_doubleArrow(_parameterInformationImpl, _function_5);
              };
              List<ParameterInformationImpl> _map = ListExtensions.<Parameter, ParameterInformationImpl>map(_params_1, _function_4);
              it_1.setParameters(_map);
            };
            return ObjectExtensions.<SignatureInformationImpl>operator_doubleArrow(_signatureInformationImpl, _function_3);
          };
          List<SignatureInformationImpl> _map = ListExtensions.<Operation, SignatureInformationImpl>map(visibleOperations, _function_2);
          List<SignatureInformationImpl> _list = IterableExtensions.<SignatureInformationImpl>toList(_map);
          List<SignatureInformationImpl> _sortWith = IterableExtensions.<SignatureInformationImpl>sortWith(_list, SignatureHelpServiceImpl.SIGNATURE_INFO_ORDERING);
          it.setSignatures(_sortWith);
        };
        return ObjectExtensions.<SignatureHelpImpl>operator_doubleArrow(_signatureHelpImpl, _function_1);
      }
    }
    return SignatureHelpService.EMPTY;
  }
  
  private Pair<Boolean, Integer> getCurrentParamInfo(final OperationCall operationCall, final int offset) {
    EList<Integer> _params = operationCall.getParams();
    final int paramSize = _params.size();
    if ((paramSize == 0)) {
      return Tuples.<Boolean, Integer>pair(Boolean.valueOf(false), Integer.valueOf(0));
    }
    final AtomicInteger openinIndex = new AtomicInteger((-1));
    final AtomicInteger closingIndex = new AtomicInteger((-1));
    final List<Integer> separatorIndices = CollectionLiterals.<Integer>newArrayList();
    ICompositeNode _node = NodeModelUtils.getNode(operationCall);
    BidiIterable<INode> _children = _node.getChildren();
    final Consumer<INode> _function = (INode it) -> {
      if ((Objects.equal(SignatureHelpServiceImpl.OPENING_CHAR, it.getText()) && (openinIndex.get() == (-1)))) {
        ITextRegion _textRegion = it.getTextRegion();
        int _offset = _textRegion.getOffset();
        openinIndex.set(_offset);
      } else {
        if ((Objects.equal(SignatureHelpServiceImpl.CLOSING_CHAR, it.getText()) && (closingIndex.get() == (-1)))) {
          ITextRegion _textRegion_1 = it.getTextRegion();
          int _offset_1 = _textRegion_1.getOffset();
          closingIndex.set(_offset_1);
        } else {
          String _text = it.getText();
          boolean _equals = Objects.equal(SignatureHelpServiceImpl.SEPARATOR_CHAR, _text);
          if (_equals) {
            ITextRegion _textRegion_2 = it.getTextRegion();
            int _offset_2 = _textRegion_2.getOffset();
            separatorIndices.add(Integer.valueOf(_offset_2));
          }
        }
      }
    };
    _children.forEach(_function);
    int _get = openinIndex.get();
    boolean _greaterEqualsThan = (_get >= offset);
    if (_greaterEqualsThan) {
      return Tuples.<Boolean, Integer>pair(Boolean.valueOf(true), Integer.valueOf(Integer.MAX_VALUE));
    }
    if (((closingIndex.get() != (-1)) && (closingIndex.get() < offset))) {
      return Tuples.<Boolean, Integer>pair(Boolean.valueOf(true), Integer.valueOf(Integer.MAX_VALUE));
    }
    int _get_1 = openinIndex.get();
    boolean _greaterEqualsThan_1 = (_get_1 >= 0);
    if (_greaterEqualsThan_1) {
      int i = 0;
      int size = separatorIndices.size();
      boolean _while = (i < size);
      while (_while) {
        Integer _get_2 = separatorIndices.get(i);
        boolean _greaterThan = ((_get_2).intValue() > (offset - 1));
        if (_greaterThan) {
          return Tuples.<Boolean, Integer>pair(Boolean.valueOf(false), Integer.valueOf(i));
        }
        i++;
        _while = (i < size);
      }
    }
    int _size = separatorIndices.size();
    boolean _greaterEqualsThan_2 = (_size >= paramSize);
    if (_greaterEqualsThan_2) {
      int _size_1 = separatorIndices.size();
      return Tuples.<Boolean, Integer>pair(Boolean.valueOf(true), Integer.valueOf(_size_1));
    } else {
      return Tuples.<Boolean, Integer>pair(Boolean.valueOf(false), Integer.valueOf((paramSize - 1)));
    }
  }
  
  private Iterable<Operation> getVisibleOperationsWithName(final EObject object, final String name) {
    EReference _operationCall_Operation = this._testLanguagePackage.getOperationCall_Operation();
    IScope _scope = this.scopeProvider.getScope(object, _operationCall_Operation);
    Iterable<IEObjectDescription> _allElements = _scope.getAllElements();
    final Function1<IEObjectDescription, Boolean> _function = (IEObjectDescription it) -> {
      EClass _eClass = it.getEClass();
      EClass _operation = this._testLanguagePackage.getOperation();
      return Boolean.valueOf(Objects.equal(_eClass, _operation));
    };
    Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(_allElements, _function);
    final Function1<IEObjectDescription, Boolean> _function_1 = (IEObjectDescription it) -> {
      QualifiedName _qualifiedName = it.getQualifiedName();
      String _lastSegment = _qualifiedName.getLastSegment();
      return Boolean.valueOf(Objects.equal(_lastSegment, name));
    };
    Iterable<IEObjectDescription> _filter_1 = IterableExtensions.<IEObjectDescription>filter(_filter, _function_1);
    final Function1<IEObjectDescription, EObject> _function_2 = (IEObjectDescription it) -> {
      return it.getEObjectOrProxy();
    };
    Iterable<EObject> _map = IterableExtensions.<IEObjectDescription, EObject>map(_filter_1, _function_2);
    return Iterables.<Operation>filter(_map, Operation.class);
  }
  
  private String getOperationName(final OperationCall call) {
    EReference _operationCall_Operation = this._testLanguagePackage.getOperationCall_Operation();
    List<INode> _findNodesForFeature = NodeModelUtils.findNodesForFeature(call, _operationCall_Operation);
    INode _head = IterableExtensions.<INode>head(_findNodesForFeature);
    String _text = null;
    if (_head!=null) {
      _text=_head.getText();
    }
    return _text;
  }
  
  private String _getLabel(final Operation it) {
    StringConcatenation _builder = new StringConcatenation();
    TypeDeclaration _containerOfType = EcoreUtil2.<TypeDeclaration>getContainerOfType(it, TypeDeclaration.class);
    String _name = _containerOfType.getName();
    _builder.append(_name, "");
    _builder.append(".");
    String _name_1 = it.getName();
    _builder.append(_name_1, "");
    _builder.append("(");
    {
      EList<Parameter> _params = it.getParams();
      boolean _hasElements = false;
      for(final Parameter p : _params) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _name_2 = p.getName();
        _builder.append(_name_2, "");
        _builder.append(": ");
        Type _type = p.getType();
        String _label = this.getLabel(_type);
        _builder.append(_label, "");
      }
    }
    _builder.append("): ");
    {
      Type _returnType = it.getReturnType();
      boolean _tripleEquals = (_returnType == null);
      if (_tripleEquals) {
        _builder.append("void");
      } else {
        Type _returnType_1 = it.getReturnType();
        String _label_1 = this.getLabel(_returnType_1);
        _builder.append(_label_1, "");
      }
    }
    return _builder.toString();
  }
  
  private String _getLabel(final TypeReference it) {
    TypeDeclaration _typeRef = it.getTypeRef();
    return _typeRef.getName();
  }
  
  private String _getLabel(final PrimitiveType it) {
    return it.getName();
  }
  
  private String getLabel(final EObject it) {
    if (it instanceof Operation) {
      return _getLabel((Operation)it);
    } else if (it instanceof PrimitiveType) {
      return _getLabel((PrimitiveType)it);
    } else if (it instanceof TypeReference) {
      return _getLabel((TypeReference)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
