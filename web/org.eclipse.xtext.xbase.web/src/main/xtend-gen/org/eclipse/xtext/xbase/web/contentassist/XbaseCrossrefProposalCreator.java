package org.eclipse.xtext.xbase.web.contentassist;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.contentassist.CrossrefProposalCreator;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceFactory;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

@SuppressWarnings("all")
public class XbaseCrossrefProposalCreator extends CrossrefProposalCreator {
  public static class ProposalBracketInfo {
    private String brackets = "";
    
    private int selectionOffset = 0;
    
    private int selectionLength = 0;
    
    private int caretOffset = 0;
  }
  
  private final String ruleName;
  
  private final CommonTypeComputationServices typeComputationServices;
  
  public XbaseCrossrefProposalCreator(final ContentAssistContext contentAssistContext, final IQualifiedNameConverter qualifiedNameConverter, final CommonTypeComputationServices typeComputationServices, final String ruleName) {
    super(contentAssistContext, qualifiedNameConverter);
    this.typeComputationServices = typeComputationServices;
    this.ruleName = ruleName;
  }
  
  @Override
  public ContentAssistResult.Entry apply(final IEObjectDescription candidate) {
    boolean _and = false;
    if (!(candidate instanceof IIdentifiableElementDescription)) {
      _and = false;
    } else {
      boolean _isIdRule = this.isIdRule(this.ruleName);
      _and = _isIdRule;
    }
    if (_and) {
      ContentAssistContext _contentAssistContext = this.getContentAssistContext();
      final XbaseCrossrefProposalCreator.ProposalBracketInfo bracketInfo = this.getProposalBracketInfo(candidate, _contentAssistContext);
      IQualifiedNameConverter _qualifiedNameConverter = this.getQualifiedNameConverter();
      QualifiedName _name = candidate.getName();
      String _string = _qualifiedNameConverter.toString(_name);
      final String proposalString = (_string + bracketInfo.brackets);
      int insignificantParameters = 0;
      if ((candidate instanceof IIdentifiableElementDescription)) {
        int _numberOfIrrelevantParameters = ((IIdentifiableElementDescription)candidate).getNumberOfIrrelevantParameters();
        insignificantParameters = _numberOfIrrelevantParameters;
      }
      ContentAssistContext _contentAssistContext_1 = this.getContentAssistContext();
      XtextResource _resource = _contentAssistContext_1.getResource();
      final LightweightTypeReferenceFactory converter = this.getTypeConverter(_resource);
      final EObject objectOrProxy = candidate.getEObjectOrProxy();
      ContentAssistContext _contentAssistContext_2 = this.getContentAssistContext();
      String _prefix = _contentAssistContext_2.getPrefix();
      ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(ContentAssistResult.CROSSREF, _prefix);
      final Procedure1<ContentAssistResult.Entry> _function = new Procedure1<ContentAssistResult.Entry>() {
        @Override
        public void apply(final ContentAssistResult.Entry it) {
          it.setProposal(proposalString);
        }
      };
      final ContentAssistResult.Entry result = ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function);
      if ((objectOrProxy instanceof JvmFeature)) {
        boolean _startsWith = bracketInfo.brackets.startsWith(" =");
        if (_startsWith) {
          IQualifiedNameConverter _qualifiedNameConverter_1 = this.getQualifiedNameConverter();
          QualifiedName _name_1 = candidate.getName();
          String _string_1 = _qualifiedNameConverter_1.toString(_name_1);
          String _plus = (_string_1 + bracketInfo.brackets);
          this.addNameAndDescription(result, ((JvmFeature) objectOrProxy), 
            false, insignificantParameters, _plus, converter);
        } else {
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(bracketInfo.brackets);
          boolean _not = (!_isNullOrEmpty);
          IQualifiedNameConverter _qualifiedNameConverter_2 = this.getQualifiedNameConverter();
          QualifiedName _name_2 = candidate.getName();
          String _string_2 = _qualifiedNameConverter_2.toString(_name_2);
          this.addNameAndDescription(result, ((JvmFeature) objectOrProxy), _not, insignificantParameters, _string_2, converter);
        }
      } else {
        IQualifiedNameConverter _qualifiedNameConverter_3 = this.getQualifiedNameConverter();
        QualifiedName _qualifiedName = candidate.getQualifiedName();
        String _string_3 = _qualifiedNameConverter_3.toString(_qualifiedName);
        IQualifiedNameConverter _qualifiedNameConverter_4 = this.getQualifiedNameConverter();
        QualifiedName _name_3 = candidate.getName();
        String _string_4 = _qualifiedNameConverter_4.toString(_name_3);
        this.addNameAndDescription(result, objectOrProxy, _string_3, _string_4);
      }
      ContentAssistContext _contentAssistContext_3 = this.getContentAssistContext();
      int _offset = _contentAssistContext_3.getOffset();
      int _length = proposalString.length();
      int offset = (_offset + _length);
      result.setEscapePosition((offset + bracketInfo.caretOffset));
      if ((bracketInfo.selectionOffset != 0)) {
        int _offset_1 = offset;
        offset = (_offset_1 + bracketInfo.selectionOffset);
        ArrayList<ContentAssistResult.EditPosition> _editPositions = result.getEditPositions();
        ContentAssistResult.EditPosition _editPosition = new ContentAssistResult.EditPosition(offset, bracketInfo.selectionLength);
        _editPositions.add(_editPosition);
      }
      if ((objectOrProxy instanceof JvmExecutable)) {
        final StringBuilder parameterList = new StringBuilder();
        this.appendParameters(parameterList, ((JvmExecutable)objectOrProxy), insignificantParameters, converter);
      }
      return result;
    }
    return super.apply(candidate);
  }
  
  protected boolean isIdRule(final String ruleName) {
    boolean _or = false;
    boolean _or_1 = false;
    boolean _equals = Objects.equal(ruleName, "IdOrSuper");
    if (_equals) {
      _or_1 = true;
    } else {
      boolean _equals_1 = Objects.equal(ruleName, "ValidID");
      _or_1 = _equals_1;
    }
    if (_or_1) {
      _or = true;
    } else {
      boolean _equals_2 = Objects.equal(ruleName, "FeatureCallID");
      _or = _equals_2;
    }
    return _or;
  }
  
  protected XbaseCrossrefProposalCreator.ProposalBracketInfo getProposalBracketInfo(final IEObjectDescription proposedDescription, final ContentAssistContext contentAssistContext) {
    final XbaseCrossrefProposalCreator.ProposalBracketInfo info = new XbaseCrossrefProposalCreator.ProposalBracketInfo();
    if ((proposedDescription instanceof IIdentifiableElementDescription)) {
      final JvmIdentifiableElement jvmFeature = ((IIdentifiableElementDescription)proposedDescription).getElementOrProxy();
      if ((jvmFeature instanceof JvmExecutable)) {
        final EList<JvmFormalParameter> parameters = ((JvmExecutable)jvmFeature).getParameters();
        int _numberOfParameters = ((IIdentifiableElementDescription)proposedDescription).getNumberOfParameters();
        boolean _equals = (_numberOfParameters == 1);
        if (_equals) {
          boolean _and = false;
          String _simpleName = ((JvmExecutable)jvmFeature).getSimpleName();
          boolean _startsWith = _simpleName.startsWith("set");
          if (!_startsWith) {
            _and = false;
          } else {
            QualifiedName _name = ((IIdentifiableElementDescription)proposedDescription).getName();
            String _firstSegment = _name.getFirstSegment();
            boolean _startsWith_1 = _firstSegment.startsWith("set");
            boolean _not = (!_startsWith_1);
            _and = _not;
          }
          if (_and) {
            info.brackets = " = value";
            int _length = "value".length();
            int _minus = (-_length);
            info.selectionOffset = _minus;
            int _length_1 = "value".length();
            info.selectionLength = _length_1;
            return info;
          }
          int _size = parameters.size();
          int _minus_1 = (_size - 1);
          JvmFormalParameter _get = parameters.get(_minus_1);
          final JvmTypeReference parameterType = _get.getParameterType();
          XtextResource _resource = contentAssistContext.getResource();
          LightweightTypeReferenceFactory _typeConverter = this.getTypeConverter(_resource);
          final LightweightTypeReference light = _typeConverter.toLightweightReference(parameterType);
          boolean _isFunctionType = light.isFunctionType();
          if (_isFunctionType) {
            FunctionTypeReference _asFunctionTypeReference = light.getAsFunctionTypeReference();
            List<LightweightTypeReference> _parameterTypes = _asFunctionTypeReference.getParameterTypes();
            final int numParameters = _parameterTypes.size();
            if ((numParameters == 1)) {
              info.brackets = "[]";
              info.caretOffset = (-1);
              return info;
            } else {
              if ((numParameters == 0)) {
                info.brackets = "[|]";
                info.caretOffset = (-1);
                return info;
              } else {
                final StringBuilder b = new StringBuilder();
                for (int i = 0; (i < numParameters); i++) {
                  {
                    if ((i != 0)) {
                      b.append(", ");
                    }
                    b.append(("p" + Integer.valueOf((i + 1))));
                  }
                }
                String _string = b.toString();
                String _plus = ("[" + _string);
                String _plus_1 = (_plus + "|]");
                info.brackets = _plus_1;
                info.caretOffset = (-1);
                int _length_2 = b.length();
                int _minus_2 = (-_length_2);
                int _minus_3 = (_minus_2 - 2);
                info.selectionOffset = _minus_3;
                int _length_3 = b.length();
                info.selectionLength = _length_3;
                return info;
              }
            }
          }
        }
      }
      boolean _isExplicitOperationCall = this.isExplicitOperationCall(((IIdentifiableElementDescription)proposedDescription));
      if (_isExplicitOperationCall) {
        info.brackets = "()";
        info.selectionOffset = (-1);
      }
    }
    return info;
  }
  
  protected LightweightTypeReferenceFactory getTypeConverter(final XtextResource context) {
    StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.typeComputationServices, context);
    return new LightweightTypeReferenceFactory(_standardTypeReferenceOwner) {
      @Override
      public LightweightTypeReference doVisitParameterizedTypeReference(final JvmParameterizedTypeReference reference) {
        final LightweightTypeReference result = super.doVisitParameterizedTypeReference(reference);
        boolean _isFunctionType = result.isFunctionType();
        if (_isFunctionType) {
          return result.tryConvertToFunctionTypeReference(false);
        }
        return result;
      }
    };
  }
  
  protected void addNameAndDescription(final ContentAssistResult.Entry entry, final JvmFeature feature, final boolean withParents, final int insignificantParameters, final String shortName, final LightweightTypeReferenceFactory converter) {
    final StringBuilder nameBuilder = new StringBuilder(shortName);
    final StringBuilder descriptionBuilder = new StringBuilder();
    if ((feature instanceof JvmOperation)) {
      if (withParents) {
        nameBuilder.append("(");
        this.appendParameters(nameBuilder, ((JvmExecutable)feature), insignificantParameters, converter);
        nameBuilder.append(")");
      }
      final JvmTypeReference returnType = ((JvmOperation)feature).getReturnType();
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(returnType, null));
      if (!_notEquals) {
        _and = false;
      } else {
        String _simpleName = returnType.getSimpleName();
        boolean _notEquals_1 = (!Objects.equal(_simpleName, null));
        _and = _notEquals_1;
      }
      if (_and) {
        nameBuilder.append(" : ");
        LightweightTypeReference _lightweightReference = converter.toLightweightReference(returnType);
        String _humanReadableName = _lightweightReference.getHumanReadableName();
        nameBuilder.append(_humanReadableName);
      }
      JvmDeclaredType _declaringType = ((JvmOperation)feature).getDeclaringType();
      LightweightTypeReference _plainTypeReference = converter.toPlainTypeReference(_declaringType);
      String _humanReadableName_1 = _plainTypeReference.getHumanReadableName();
      descriptionBuilder.append(_humanReadableName_1);
      if ((!withParents)) {
        descriptionBuilder.append(".");
        String _simpleName_1 = ((JvmOperation)feature).getSimpleName();
        descriptionBuilder.append(_simpleName_1);
        descriptionBuilder.append("()");
      }
    } else {
      if ((feature instanceof JvmField)) {
        nameBuilder.append(" : ");
        JvmTypeReference _type = ((JvmField)feature).getType();
        boolean _notEquals_2 = (!Objects.equal(_type, null));
        if (_notEquals_2) {
          JvmTypeReference _type_1 = ((JvmField)feature).getType();
          LightweightTypeReference _lightweightReference_1 = converter.toLightweightReference(_type_1);
          final String fieldType = _lightweightReference_1.getHumanReadableName();
          boolean _notEquals_3 = (!Objects.equal(fieldType, null));
          if (_notEquals_3) {
            nameBuilder.append(fieldType);
          }
        }
        JvmDeclaredType _declaringType_1 = ((JvmField)feature).getDeclaringType();
        LightweightTypeReference _plainTypeReference_1 = converter.toPlainTypeReference(_declaringType_1);
        String _humanReadableName_2 = _plainTypeReference_1.getHumanReadableName();
        descriptionBuilder.append(_humanReadableName_2);
      } else {
        if ((feature instanceof JvmConstructor)) {
          if (withParents) {
            nameBuilder.append("(");
            this.appendParameters(nameBuilder, ((JvmExecutable)feature), insignificantParameters, converter);
            nameBuilder.append(")");
          }
        }
      }
    }
    String _string = nameBuilder.toString();
    entry.setName(_string);
    String _string_1 = descriptionBuilder.toString();
    entry.setDescription(_string_1);
  }
  
  protected void addNameAndDescription(final ContentAssistResult.Entry entry, final EObject element, final String qualifiedNameAsString, final String shortName) {
    IQualifiedNameConverter _qualifiedNameConverter = this.getQualifiedNameConverter();
    final QualifiedName qualifiedName = _qualifiedNameConverter.toQualifiedName(qualifiedNameAsString);
    int _segmentCount = qualifiedName.getSegmentCount();
    boolean _greaterThan = (_segmentCount > 1);
    if (_greaterThan) {
      String _lastSegment = qualifiedName.getLastSegment();
      entry.setName(_lastSegment);
      entry.setDescription(qualifiedNameAsString);
    } else {
      entry.setName(qualifiedNameAsString);
    }
  }
  
  protected void appendParameters(final StringBuilder result, final JvmExecutable executable, final int insignificantParameters, final LightweightTypeReferenceFactory ownedConverter) {
    final EList<JvmFormalParameter> declaredParameters = executable.getParameters();
    int _size = declaredParameters.size();
    int _min = Math.min(insignificantParameters, _size);
    int _size_1 = declaredParameters.size();
    final List<JvmFormalParameter> relevantParameters = declaredParameters.subList(_min, _size_1);
    for (int i = 0; (i < relevantParameters.size()); i++) {
      {
        final JvmFormalParameter parameter = relevantParameters.get(i);
        if ((i != 0)) {
          result.append(", ");
        }
        boolean _and = false;
        boolean _and_1 = false;
        int _size_2 = relevantParameters.size();
        int _minus = (_size_2 - 1);
        boolean _equals = (i == _minus);
        if (!_equals) {
          _and_1 = false;
        } else {
          boolean _isVarArgs = executable.isVarArgs();
          _and_1 = _isVarArgs;
        }
        if (!_and_1) {
          _and = false;
        } else {
          JvmTypeReference _parameterType = parameter.getParameterType();
          _and = (_parameterType instanceof JvmGenericArrayTypeReference);
        }
        if (_and) {
          JvmTypeReference _parameterType_1 = parameter.getParameterType();
          final JvmGenericArrayTypeReference parameterType = ((JvmGenericArrayTypeReference) _parameterType_1);
          JvmTypeReference _componentType = parameterType.getComponentType();
          LightweightTypeReference _lightweightReference = ownedConverter.toLightweightReference(_componentType);
          String _humanReadableName = _lightweightReference.getHumanReadableName();
          result.append(_humanReadableName);
          result.append("...");
        } else {
          JvmTypeReference _parameterType_2 = parameter.getParameterType();
          boolean _notEquals = (!Objects.equal(_parameterType_2, null));
          if (_notEquals) {
            JvmTypeReference _parameterType_3 = parameter.getParameterType();
            LightweightTypeReference _lightweightReference_1 = ownedConverter.toLightweightReference(_parameterType_3);
            final String simpleName = _lightweightReference_1.getHumanReadableName();
            boolean _notEquals_1 = (!Objects.equal(simpleName, null));
            if (_notEquals_1) {
              result.append(simpleName);
            }
          }
        }
        result.append(" ");
        String _name = parameter.getName();
        String _valueOf = String.valueOf(_name);
        result.append(_valueOf);
      }
    }
  }
  
  protected boolean isExplicitOperationCall(final IIdentifiableElementDescription desc) {
    int _numberOfParameters = desc.getNumberOfParameters();
    return (_numberOfParameters > 0);
  }
}
