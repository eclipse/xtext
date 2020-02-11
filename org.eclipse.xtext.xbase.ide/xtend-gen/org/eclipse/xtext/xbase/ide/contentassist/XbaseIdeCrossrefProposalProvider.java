/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ide.contentassist;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmConstructor;
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
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IdeCrossrefProposalProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceFactory;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

@SuppressWarnings("all")
public class XbaseIdeCrossrefProposalProvider extends IdeCrossrefProposalProvider {
  public static class ProposalBracketInfo {
    private String brackets = "";
    
    private int selectionOffset = 0;
    
    private int selectionLength = 0;
    
    private int caretOffset = 0;
  }
  
  @Inject
  private CommonTypeComputationServices typeComputationServices;
  
  @Override
  public ContentAssistEntry createProposal(final IEObjectDescription candidate, final CrossReference crossRef, final ContentAssistContext context) {
    boolean _hasIdRule = this.hasIdRule(crossRef);
    if (_hasIdRule) {
      final XbaseIdeCrossrefProposalProvider.ProposalBracketInfo bracketInfo = this.getProposalBracketInfo(candidate, context);
      String _string = this.getQualifiedNameConverter().toString(candidate.getName());
      final String proposalString = (_string + bracketInfo.brackets);
      int _xifexpression = (int) 0;
      if ((candidate instanceof IIdentifiableElementDescription)) {
        _xifexpression = ((IIdentifiableElementDescription)candidate).getNumberOfIrrelevantParameters();
      } else {
        _xifexpression = 0;
      }
      final int insignificantParameters = _xifexpression;
      final LightweightTypeReferenceFactory converter = this.getTypeConverter(context.getResource());
      final EObject objectOrProxy = candidate.getEObjectOrProxy();
      final Procedure1<ContentAssistEntry> _function = (ContentAssistEntry result) -> {
        result.setKind(ContentAssistEntry.KIND_REFERENCE);
        if ((objectOrProxy instanceof JvmFeature)) {
          boolean _startsWith = bracketInfo.brackets.startsWith(" =");
          if (_startsWith) {
            String _string_1 = this.getQualifiedNameConverter().toString(candidate.getName());
            String _plus = (_string_1 + bracketInfo.brackets);
            this.addNameAndDescription(result, ((JvmFeature)objectOrProxy), 
              false, insignificantParameters, _plus, converter);
          } else {
            boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(bracketInfo.brackets);
            boolean _not = (!_isNullOrEmpty);
            this.addNameAndDescription(result, ((JvmFeature)objectOrProxy), _not, insignificantParameters, 
              this.getQualifiedNameConverter().toString(candidate.getName()), converter);
          }
        } else {
          this.addNameAndDescription(result, objectOrProxy, 
            this.getQualifiedNameConverter().toString(candidate.getQualifiedName()), 
            this.getQualifiedNameConverter().toString(candidate.getName()));
        }
        int _offset = context.getOffset();
        int _length = context.getPrefix().length();
        int _minus = (_offset - _length);
        int _length_1 = proposalString.length();
        int offset = (_minus + _length_1);
        result.setEscapePosition(Integer.valueOf((offset + bracketInfo.caretOffset)));
        if ((bracketInfo.selectionOffset != 0)) {
          int _offset_1 = offset;
          offset = (_offset_1 + bracketInfo.selectionOffset);
          ArrayList<TextRegion> _editPositions = result.getEditPositions();
          TextRegion _textRegion = new TextRegion(offset, bracketInfo.selectionLength);
          _editPositions.add(_textRegion);
        }
        if ((objectOrProxy instanceof JvmExecutable)) {
          final StringBuilder parameterList = new StringBuilder();
          this.appendParameters(parameterList, ((JvmExecutable)objectOrProxy), insignificantParameters, converter);
        }
      };
      return this.getProposalCreator().createProposal(proposalString, context, _function);
    }
    return super.createProposal(candidate, crossRef, context);
  }
  
  protected boolean hasIdRule(final CrossReference crossRef) {
    AbstractElement _terminal = crossRef.getTerminal();
    if ((_terminal instanceof RuleCall)) {
      AbstractElement _terminal_1 = crossRef.getTerminal();
      final String ruleName = ((RuleCall) _terminal_1).getRule().getName();
      return ((Objects.equal(ruleName, "IdOrSuper") || Objects.equal(ruleName, "ValidID")) || Objects.equal(ruleName, "FeatureCallID"));
    }
    return false;
  }
  
  protected XbaseIdeCrossrefProposalProvider.ProposalBracketInfo getProposalBracketInfo(final IEObjectDescription proposedDescription, final ContentAssistContext contentAssistContext) {
    final XbaseIdeCrossrefProposalProvider.ProposalBracketInfo info = new XbaseIdeCrossrefProposalProvider.ProposalBracketInfo();
    if ((proposedDescription instanceof IIdentifiableElementDescription)) {
      final JvmIdentifiableElement jvmFeature = ((IIdentifiableElementDescription)proposedDescription).getElementOrProxy();
      if ((jvmFeature instanceof JvmExecutable)) {
        final EList<JvmFormalParameter> parameters = ((JvmExecutable)jvmFeature).getParameters();
        int _numberOfParameters = ((IIdentifiableElementDescription)proposedDescription).getNumberOfParameters();
        boolean _equals = (_numberOfParameters == 1);
        if (_equals) {
          if ((((JvmExecutable)jvmFeature).getSimpleName().startsWith("set") && (!((IIdentifiableElementDescription)proposedDescription).getName().getFirstSegment().startsWith("set")))) {
            info.brackets = " = value";
            int _length = "value".length();
            int _minus = (-_length);
            info.selectionOffset = _minus;
            info.selectionLength = "value".length();
            return info;
          }
          final JvmTypeReference parameterType = IterableExtensions.<JvmFormalParameter>last(parameters).getParameterType();
          final LightweightTypeReference light = this.getTypeConverter(contentAssistContext.getResource()).toLightweightReference(parameterType);
          boolean _isFunctionType = light.isFunctionType();
          if (_isFunctionType) {
            final int numParameters = light.getAsFunctionTypeReference().getParameterTypes().size();
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
                int _length_1 = b.length();
                int _minus_1 = (-_length_1);
                int _minus_2 = (_minus_1 - 2);
                info.selectionOffset = _minus_2;
                info.selectionLength = b.length();
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
  
  protected void addNameAndDescription(final ContentAssistEntry entry, final JvmFeature feature, final boolean withParents, final int insignificantParameters, final String shortName, final LightweightTypeReferenceFactory converter) {
    final StringBuilder labelBuilder = new StringBuilder(shortName);
    final StringBuilder descriptionBuilder = new StringBuilder();
    if ((feature instanceof JvmOperation)) {
      if (withParents) {
        labelBuilder.append("(");
        this.appendParameters(labelBuilder, ((JvmExecutable)feature), insignificantParameters, converter);
        labelBuilder.append(")");
      }
      final JvmTypeReference returnType = ((JvmOperation)feature).getReturnType();
      if (((returnType != null) && (returnType.getSimpleName() != null))) {
        labelBuilder.append(" : ");
        labelBuilder.append(converter.toLightweightReference(returnType).getHumanReadableName());
      }
      descriptionBuilder.append(converter.toPlainTypeReference(((JvmOperation)feature).getDeclaringType()).getHumanReadableName());
      if ((!withParents)) {
        descriptionBuilder.append(".");
        descriptionBuilder.append(((JvmOperation)feature).getSimpleName());
        descriptionBuilder.append("()");
      }
    } else {
      if ((feature instanceof JvmField)) {
        labelBuilder.append(" : ");
        JvmTypeReference _type = ((JvmField)feature).getType();
        boolean _tripleNotEquals = (_type != null);
        if (_tripleNotEquals) {
          final String fieldType = converter.toLightweightReference(((JvmField)feature).getType()).getHumanReadableName();
          if ((fieldType != null)) {
            labelBuilder.append(fieldType);
          }
        }
        descriptionBuilder.append(converter.toPlainTypeReference(((JvmField)feature).getDeclaringType()).getHumanReadableName());
      } else {
        if ((feature instanceof JvmConstructor)) {
          if (withParents) {
            labelBuilder.append("(");
            this.appendParameters(labelBuilder, ((JvmExecutable)feature), insignificantParameters, converter);
            labelBuilder.append(")");
          }
        }
      }
    }
    entry.setLabel(labelBuilder.toString());
    entry.setDescription(descriptionBuilder.toString());
  }
  
  protected void addNameAndDescription(final ContentAssistEntry entry, final EObject element, final String qualifiedNameAsString, final String shortName) {
    final QualifiedName qualifiedName = this.getQualifiedNameConverter().toQualifiedName(qualifiedNameAsString);
    int _segmentCount = qualifiedName.getSegmentCount();
    boolean _greaterThan = (_segmentCount > 1);
    if (_greaterThan) {
      entry.setLabel(qualifiedName.getLastSegment());
      entry.setDescription(qualifiedNameAsString);
    } else {
      entry.setLabel(qualifiedNameAsString);
    }
  }
  
  protected void appendParameters(final StringBuilder result, final JvmExecutable executable, final int insignificantParameters, final LightweightTypeReferenceFactory ownedConverter) {
    final EList<JvmFormalParameter> declaredParameters = executable.getParameters();
    final List<JvmFormalParameter> relevantParameters = declaredParameters.subList(Math.min(insignificantParameters, declaredParameters.size()), declaredParameters.size());
    for (int i = 0; (i < relevantParameters.size()); i++) {
      {
        final JvmFormalParameter parameter = relevantParameters.get(i);
        if ((i != 0)) {
          result.append(", ");
        }
        if ((((i == (relevantParameters.size() - 1)) && executable.isVarArgs()) && (parameter.getParameterType() instanceof JvmGenericArrayTypeReference))) {
          JvmTypeReference _parameterType = parameter.getParameterType();
          final JvmGenericArrayTypeReference parameterType = ((JvmGenericArrayTypeReference) _parameterType);
          result.append(ownedConverter.toLightweightReference(parameterType.getComponentType()).getHumanReadableName());
          result.append("...");
        } else {
          JvmTypeReference _parameterType_1 = parameter.getParameterType();
          boolean _tripleNotEquals = (_parameterType_1 != null);
          if (_tripleNotEquals) {
            final String simpleName = ownedConverter.toLightweightReference(parameter.getParameterType()).getHumanReadableName();
            if ((simpleName != null)) {
              result.append(simpleName);
            }
          }
        }
        result.append(" ");
        result.append(String.valueOf(parameter.getName()));
      }
    }
  }
  
  protected boolean isExplicitOperationCall(final IIdentifiableElementDescription desc) {
    int _numberOfParameters = desc.getNumberOfParameters();
    return (_numberOfParameters > 0);
  }
}
