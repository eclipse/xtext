/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.signatureHelp

import com.google.common.base.Preconditions
import com.google.inject.Inject
import io.typefox.lsapi.SignatureInformation
import io.typefox.lsapi.impl.ParameterInformationImpl
import io.typefox.lsapi.impl.SignatureHelpImpl
import io.typefox.lsapi.impl.SignatureInformationImpl
import java.util.Comparator
import java.util.List
import java.util.concurrent.atomic.AtomicInteger
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.ide.server.signatureHelp.SignatureHelpService
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Operation
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.OperationCall
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.PrimitiveType
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeReference
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.util.Tuples

/**
 * Signature help service implementation for the test language.
 * 
 * @author akos.kitta - Initial contribution and API
 */
class SignatureHelpServiceImpl implements SignatureHelpService {

    private static val OPENING_CHAR = '(';
    
    private static val CLOSING_CHAR = ')';
    
    private static val SEPARATOR_CHAR = ','; 

    /**
     * Shared comparator singleton to compare {@link SignatureInformation signature information} instances
     * based on the number of parameters first, then the parameter labels lexicographically.
     */
    private static val Comparator<SignatureInformation> SIGNATURE_INFO_ORDERING = [ left, right |
        var result = left.parameters.size - right.parameters.size;
        if (result === 0) {
            for (var i = 0, var size = left.parameters.size; i < size; i++) {
                result = left.parameters.get(i).label.compareTo(right.parameters.get(i).label);
                if (result != 0) {
                    return result;
                }
            }
        }
        return result;
    ];

    @Inject
    EObjectAtOffsetHelper offsetHelper;
    
    @Inject
    IScopeProvider scopeProvider;

    extension TestLanguagePackage = TestLanguagePackage.eINSTANCE;

    @Override
    override getSignatureHelp(XtextResource resource, int offset) {

        Preconditions.checkNotNull(resource, "resource");
        Preconditions.checkArgument(offset >= 0, "offset >= 0. Was: " + offset);

        val object = offsetHelper.resolveContainedElementAt(resource, offset);
        if (object instanceof OperationCall) {
            val operationName = object.operationName;
            if (!operationName.nullOrEmpty) {

                // Collect all visible operations with the matching name
                // Also filter those operations that have less number of formal parameters than our call requires
                val currentParamCount = object.params.size;
                val currentParamIndexPair = object.getCurrentParamInfo(offset);
                val incomplete = currentParamIndexPair.first;
                val currentParamIndex = currentParamIndexPair.second;
                val visibleOperations = object.getVisibleOperationsWithName(operationName).filter [
                    if (incomplete) currentParamIndex < params.size else currentParamCount <= params.size
                ].toList;

                if (visibleOperations.nullOrEmpty) {
                    return EMPTY;
                }

                return new SignatureHelpImpl => [
                    activeParameter = if (currentParamCount === 0) null else currentParamIndex;
                    activeSignature = 0;
                    signatures = visibleOperations.map [ operation |
                        new SignatureInformationImpl() => [
                            label = operation.label;
                            parameters = operation.params.map [ param |
                                new ParameterInformationImpl() => [
                                    label = '''«param.name»: «param.type.label»'''
                                ];
                            ];
                        ];
                    ].toList.sortWith(SIGNATURE_INFO_ORDERING);
                ]

            }
        }

        return EMPTY;
    }

    private def getCurrentParamInfo(OperationCall operationCall, int offset) {

        // Handling case when no parameters are defined at all
        val paramSize = operationCall.params.size;
        if (paramSize == 0) {
            return Tuples.pair(false, 0);
        }

        // Case for handling leading and trailing whitespaces properly
        val openinIndex = new AtomicInteger(-1);
        val closingIndex = new AtomicInteger(-1);
        val List<Integer> separatorIndices = newArrayList();
        
        NodeModelUtils.getNode(operationCall).getChildren().forEach [
            if (OPENING_CHAR == text && openinIndex.get === -1) {
                openinIndex.set(textRegion.offset);
            } else if (CLOSING_CHAR == text && closingIndex.get === -1) {
                closingIndex.set(textRegion.offset);    
            } else if (SEPARATOR_CHAR == text) {
                separatorIndices.add(textRegion.offset);
            }
        ];
        
        // Offset is before the operation parameters
        if (openinIndex.get >= offset) {
            return Tuples.pair(true, Integer.MAX_VALUE); 
        }
        
        // Offset exceeds the operation parameters
        if (closingIndex.get !== -1 && closingIndex.get < offset) {
            return Tuples.pair(true, Integer.MAX_VALUE);
        }

        if (openinIndex.get >= 0) {
            for (var i = 0, var size = separatorIndices.size; i < size; i++) {
                if (separatorIndices.get(i) > offset - 1) {
                    return Tuples.pair(false, i);
                }
            }
        }
        
        // Assuming broken AST
        if (separatorIndices.size >= paramSize) {
            return Tuples.pair(true, separatorIndices.size);
        } else {
            return Tuples.pair(false, paramSize - 1);
        }
    }

    private def getVisibleOperationsWithName(EObject object, String name) {
        return scopeProvider.getScope(object, operationCall_Operation)
            .allElements
            .filter[EClass == operation]
            .filter [qualifiedName.lastSegment == name]
            .map[EObjectOrProxy]
            .filter(Operation);
    }

    private def getOperationName(OperationCall call) {
        return NodeModelUtils.findNodesForFeature(call, operationCall_Operation).head?.text;
    }

    private dispatch def String getLabel(Operation it) {
        return '''«EcoreUtil2.getContainerOfType(it, TypeDeclaration).name».«name»(«FOR p : params SEPARATOR ', '»«p.name»: «p.type.label»«ENDFOR»): «IF returnType === null»void«ELSE»«returnType.label»«ENDIF»''';
    }

    private dispatch def String getLabel(TypeReference it) {
        return typeRef.name;
    }

    private dispatch def String getLabel(PrimitiveType it) {
        return name;
    }

}
