package org.eclipse.xtend.ide.quickfix

import com.google.inject.Inject
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.jdt.core.IJavaElement
import org.eclipse.jdt.core.IType
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.lib.Data
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder
import org.eclipse.xtext.common.types.xtext.ui.JdtHyperlink
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.ui.editor.IURIEditorOpener
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.edit.IModification
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable

import static org.eclipse.xtext.xbase.XbasePackage$Literals.*
import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.*
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.nodemodel.INode

class UndefinedMethodFix {
	
	@Inject extension NewMethodModificationProvider 
	@Inject extension IsUndefinedMethod
	@Inject extension CallsReadOnlyType
	
	def apply(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor, XMemberFeatureCall featureCall){
		val issueString = textForFeature(featureCall, XABSTRACT_FEATURE_CALL__FEATURE);
		if(!featureCall.callsUndefinedMethod){
			return
		}
		if(featureCall.receiverIsReadOnly){
			return
		}
		issueResolutionAcceptor.accept(
			issue, 
			"create method '" + issueString + "'", "", 
			"fix_public_function.png", 
			createModification(featureCall, issueString)
		)
	}
	
	def private textForFeature(EObject eObject, EStructuralFeature feature){
		val nodes = findNodesForFeature(eObject, feature);
		val sb = new StringBuilder();
		for (INode node : nodes) {
			sb.append(node.getText());
		}
		return sb.toString().trim();
	}
}


class NewMethodModificationProvider{
	
	@Inject IURIEditorOpener editorOpener
	@Inject ReplacingAppendable$Factory apendableFactory
	@Inject extension MethodBuilderProvider methodBuilderProvider
	@Inject extension IJavaElementFinder elementProvider
	@Inject extension FeatureCallTargetTypeProvider 
	
	def IModification createModification(XMemberFeatureCall call, String methodName) {
		val targetType = call.targetType 
		val xtendClass = targetType.xtendClass
		if(xtendClass != null){
			val methodBuilder = newXtendMethodBuilder(methodName, call)
			return new CreateXtendMethod(methodBuilder, targetType.xtendClass, editorOpener, apendableFactory)
		}else{
			val methodBuilder = newJavaMethodBuilder(methodName, call)
			methodBuilder.isInterface = (targetType instanceof JvmGenericType) && (targetType as JvmGenericType).interface
			val javaElement = findElementFor(targetType)
			return new CreateJavaMethod(methodBuilder, javaElement as IType)
		}
	}
	
	def private xtendClass(JvmType type){
		if(type == null){
			return null
		}
		type.eResource.allContents.filter(typeof(XtendClass)).findFirst[it.name == type.simpleName]
	}
	
}

@Data
class CreateJavaMethod implements IModification{
	
	XtendMethodBuilder methodBuilder
	IType type
	
	override apply(IModificationContext context) throws Exception {
		generateMethod.openInEditor
	}
	
	def private generateMethod(){
		val importManager = new ImportManager(true, ".".charAt(0))
		val content = new StringBuilderBasedAppendable(importManager)
		methodBuilder.build(content)
		importManager.imports.forEach[
			type.compilationUnit.createImport(it, null, monitor)
		]
		type.createMethod(content.toString, null, true, monitor)
	}
	
	def monitor(){
		new NullProgressMonitor
	}
	
	def private openInEditor(IJavaElement element){
		val link = new JdtHyperlink()
		link.javaElement = element
		link.open
	}
}

@Data
class CreateXtendMethod implements IModification{
	
	XtendMethodBuilder methodBuilder
	XtendClass xtendClass
	IURIEditorOpener editorOpener
	ReplacingAppendable$Factory appendableFactory

	override apply(IModificationContext context) throws Exception {
		val editor = editorOpener.open(EcoreUtil::getURI(xtendClass), false);
		if (!(editor instanceof XtextEditor)) {
			return
		}
		val xtextEditor = editor as XtextEditor;
		val document = xtextEditor.getDocument();
		var offset = getFunctionInsertOffset(xtendClass)
		
		val appendable = appendableFactory.get(document, xtendClass, offset-1, 0, 1, false)
		appendable.newLine()
		methodBuilder.build(appendable)
		appendable.decreaseIndentation().newLine()
		appendable.commitChanges
		xtextEditor.setHighlightRange(offset + 1, appendable.length, true)
	}
	
	def getFunctionInsertOffset(XtendClass clazz) {
		val clazzNode = NodeModelUtils::findActualNodeFor(clazz)
		if (clazzNode == null)
			throw new IllegalStateException("Cannot determine node for clazz " + clazz.getName())
		var lastClosingBraceOffset = -1
		for (leafNode : clazzNode.getLeafNodes()) {
			if ((leafNode.getGrammarElement() instanceof Keyword)
					&& "}" == (leafNode.getGrammarElement() as Keyword).getValue()) {
				lastClosingBraceOffset = leafNode.getOffset();
			}
		}
		if(lastClosingBraceOffset == -1)
			clazzNode.getTotalEndOffset() 
		else lastClosingBraceOffset
	}
	
}

