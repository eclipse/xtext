/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.signatureHelp

import com.google.common.base.Preconditions
import com.google.inject.Inject
import java.util.Arrays
import java.util.Comparator
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.lsp4j.ParameterInformation
import org.eclipse.lsp4j.SignatureHelp
import org.eclipse.lsp4j.SignatureInformation
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.ide.server.signatureHelp.ISignatureHelpService
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Operation
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.OperationCall
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.PrimitiveType
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeReference
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.ide.server.Document
import org.eclipse.lsp4j.TextDocumentPositionParams
import org.eclipse.xtext.util.CancelIndicator

/**
 * Signature help service implementation for the test language.
 * 
 * @author akos.kitta - Initial contribution and API
 */
class SignatureHelpServiceImpl implements ISignatureHelpService {

    static val OPENING_CHAR = '(';
    
    static val CLOSING_CHAR = ')';
    
    static val SEPARATOR_CHAR = ',';

    /**
     * Shared comparator singleton to compare {@link SignatureInformation signature information} instances
     * based on the number of parameters first, then the parameter labels lexicographically.
     */
    static val Comparator<SignatureInformation> SIGNATURE_INFO_ORDERING = [ left, right |
        var result = left.parameters.size - right.parameters.size;
        if (result === 0) {
            for (var i = 0, var size = left.parameters.size; i < size; i++) {
                result = left.parameters.get(i).label.getLeft().compareTo(right.parameters.get(i).label.getLeft());
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
				
	override getSignatureHelp(Document document, XtextResource resource, TextDocumentPositionParams params, CancelIndicator cancelIndicator) {
		val offset = document.getOffSet(params.position)
		return getSignatureHelp(resource, offset)
	}

    override getSignatureHelp(XtextResource resource, int offset) {

        Preconditions.checkNotNull(resource, "resource");
        Preconditions.checkArgument(offset >= 0, "offset >= 0. Was: " + offset);

        val object = offsetHelper.resolveContainedElementAt(resource, offset);
        if (object instanceof OperationCall) {
            val operationName = object.operationName;
            if (!operationName.nullOrEmpty) {
				return getSignatureHelp(object, operationName, offset);
            }
        }

        return EMPTY;
    }
	
	private def getSignatureHelp(OperationCall call, String operationName, int offset) {

		// If the offset exceeds either the opening or the closing characters' offset we should not 
		// provide signature help at all.
		val List<Integer> separatorIndices = newArrayList();

		for (INode node : NodeModelUtils.getNode(call).getChildren()) {
			val text = node.text;
			if (OPENING_CHAR == text && node.offset >= offset) {
				return EMPTY;
			} else if (CLOSING_CHAR == text && node.offset < offset) {
				return EMPTY;
			} else if (SEPARATOR_CHAR == text) {
				separatorIndices.add(node.offset);
			}
		}		
						
		// Here we will distinguish between three different AST states:
		// 1. Valid state: when the number of parameter separators equals with the number of (parameters - 1) 
		// and each separator is surrounded by two parameters.
		// 2. Broken recoverable state: the number of parameters equals with the number of separators and the 
		//last separator offset is greater than the last parameter (offset + length) and each separator is 
		// surrounded by two parameters. Expect the last separator.
		// 3. Broken inconsistent state: non of the above cases.
		val paramCount = call.params.size;
		val separatorCount = separatorIndices.size;

		if ((separatorCount + 1) === paramCount || separatorCount === paramCount) {
			val paramNodes = NodeModelUtils.findNodesForFeature(call, operation_Params);
			// Parameter count could be greater than separator count.
			for (var i = 0; i < separatorCount; i++) {
				val paramNode = paramNodes.get(i);
				// If separator is not after a parameter, signature help should not be provided.
				if (paramNode.offset + paramNode.length > separatorIndices.get(i)) {
					return EMPTY;
				}
			}			
		} else {
			return EMPTY;
		}
		
		val currentParameter = if (paramCount === 0) {
			0;
		} else if (separatorIndices.contains(offset)) {
			separatorIndices.indexOf(offset) + 2
		} else {
			// Here we can execute a binary search for sure, because the nodes where visited in order. 
			-Arrays.binarySearch(separatorIndices, offset);
		}
		
		val visibleOperations = call.getVisibleOperationsWithName(operationName).filter [
			currentParameter <= params.size
		]
		
		val paramOffset = if (separatorIndices.contains(offset)) 2 else 1;
		val Integer activeParamIndex = if (paramCount === 0) {
			val paramSize = visibleOperations.map[params.size];
			// If on declaration-side no no-args exists, propose the first parameter on use-side.
			if (!paramSize.exists[it === 0] && visibleOperations.exists[!params.empty]) 0 else null;
		} else {
			currentParameter - paramOffset
		}
		return new SignatureHelp => [
                    activeParameter = activeParamIndex
                    activeSignature = 0;
                    signatures = visibleOperations.map [ operation |
                        new SignatureInformation => [
                            label = operation.label;
                            parameters = operation.params.map [ param |
                                new ParameterInformation => [
                                    label = '''«param.name»: «param.type.label»'''
                                ];
                            ];
                        ];
                    ].toList.sortWith(SIGNATURE_INFO_ORDERING);
                ]
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
