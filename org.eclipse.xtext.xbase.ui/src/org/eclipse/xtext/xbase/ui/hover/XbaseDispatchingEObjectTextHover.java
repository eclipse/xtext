/*******************************************************************************
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider.IInformationControlCreatorProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Stephane Galland - Adding support for XConstructorCall
 * @author Tamas Miklossy - Adding support for elements referenced in Javadoc comments
 * @since 2.3
 */
public class XbaseDispatchingEObjectTextHover extends DispatchingEObjectTextHover {
	
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	
	@Inject 
	private JavaDebugHoverProvider javaDebugHoverProvider;
	
	@Inject
	private IScopeProvider scopeProvider;
	
	@Inject
	private IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider;
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	@Override
	public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
		IInformationControlCreatorProvider creatorProvider = javaDebugHoverProvider
				.getInformationControlCreatorProvider(textViewer, hoverRegion);
		if (creatorProvider != null) {
			lastCreatorProvider = creatorProvider;
			return creatorProvider.getInfo();
		}
		return super.getHoverInfo2(textViewer, hoverRegion);
	}
	
	@Override
	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		IXtextDocument xtextDocument = XtextDocumentUtil.get(textViewer);
		if(xtextDocument == null || offset<0 || xtextDocument.getLength() < offset) 
			return null;
		@SuppressWarnings("restriction")
		IRegion word = org.eclipse.jdt.internal.ui.text.JavaWordFinder.findWord(xtextDocument, offset);
		if (word!= null)
			return word;
		//TODO return null for non-operators.
		return new Region(offset, 0);
	}

	@Override
	protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, int offset) {
		Pair<EObject, IRegion> original = super.getXtextElementAt(resource, offset);
		if (original != null) {
			EObject object = eObjectAtOffsetHelper.resolveContainedElementAt(resource, offset);
			if (object instanceof XAbstractFeatureCall){
				JvmIdentifiableElement feature = ((XAbstractFeatureCall) object).getFeature();
				if(feature instanceof JvmExecutable 
						|| feature instanceof JvmField 
						|| feature instanceof JvmConstructor 
						|| feature instanceof XVariableDeclaration 
						|| feature instanceof JvmFormalParameter)
					return Tuples.create(object, original.getSecond());
			} else if (object instanceof XConstructorCall){
					return Tuples.create(object, original.getSecond());
			}
		}
		
		Pair<EObject,IRegion> referencedElementInJavaDoc = getReferencedElementInJavaDoc(resource, offset);
		if(referencedElementInJavaDoc != null) {
			return referencedElementInJavaDoc;
		}
		
		return original;
	}
	
	/**
	 * Returns the referenced element in javadoc comments.
	 * 
	 * @since 2.16
	 */
	protected Pair<EObject, IRegion> getReferencedElementInJavaDoc(XtextResource resource, int offset) {
		IParseResult parseResult = resource.getParseResult();
		if(parseResult != null) {
			INode rootNode = parseResult.getRootNode();
			ILeafNode node = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset);
			EObject semanticObject = NodeModelUtils.findActualSemanticObjectFor(node);
			if(semanticObject != null) {
				IScope scope = scopeProvider.getScope(semanticObject, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
				List<ReplaceRegion> replaceRegions = javaDocTypeReferenceProvider.computeTypeRefRegions(node);
				for(ReplaceRegion replaceRegion : replaceRegions) {
					if(replaceRegion.getOffset() <= offset && offset <= replaceRegion.getEndOffset()) {
						String typeRefString = replaceRegion.getText();
						if(typeRefString != null && typeRefString.length() > 0) {
							Region region = new Region(replaceRegion.getOffset(), replaceRegion.getLength());
							IEObjectDescription candidate = scope.getSingleElement(qualifiedNameConverter.toQualifiedName(typeRefString));
							if(candidate != null) {
								EObject eObject = candidate.getEObjectOrProxy();
								if(eObject!=null) {
									return Tuples.create(eObject, region);
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
}
