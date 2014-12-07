package org.eclipse.xtext.idea.ide.hierarchy

import com.google.inject.Inject
import com.intellij.ide.hierarchy.type.JavaTypeHierarchyProvider
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import java.util.Collection
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.psi.PsiEObject
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.jetbrains.annotations.NotNull

import static extension com.intellij.codeInsight.TargetElementUtilBase.*
import static extension org.eclipse.xtext.idea.actionSystem.DataContextExtensions.*

class JvmDeclaredTypeHierarchyProvider extends JavaTypeHierarchyProvider {

	@Inject
	extension IPsiModelAssociations

	@Inject
	extension IJvmModelAssociations

	override PsiElement getTarget(@NotNull DataContext dataContext) {
		val project = dataContext.project
		if (project == null) {
			return null
		}
		val editor = dataContext.editor
		if (editor == null) {
			return dataContext.psiElement.psiClass
		}
		val file = project.getPsiFile(editor)
		if (file == null) {
			return null
		}
		val psiClass = editor.targetElement.psiClass
		if (psiClass != null) {
			return psiClass
		}
		val offset = editor.caretModel.offset
		file.findElementAt(offset).findPsiClass
	}

	def getTargetElement(Editor editor) {
		editor.findTargetElement(
			ELEMENT_NAME_ACCEPTED.bitwiseOr(REFERENCED_ELEMENT_ACCEPTED).bitwiseOr(LOOKUP_ITEM_ACCEPTED)
		)
	}

	protected def getPsiFile(Project project, Editor editor) {
		PsiDocumentManager.getInstance(project).getPsiFile(editor.document)
	}

	protected def dispatch PsiClass findPsiClass(BaseXtextFile element) {
		element.resource.contents.psiClass
	}

	protected def dispatch PsiClass findPsiClass(PsiElement element) {
		val psiClass = element.psiClass
		if (psiClass != null) {
			return psiClass
		}
		element.parent.findPsiClass
	}

	protected def dispatch PsiClass findPsiClass(Void element) {
		return null
	}

	protected def getPsiClass(PsiElement element) {
		switch element {
			PsiClass:
				element
			PsiEObject: {
				val eObject = element.EObject
				if (eObject == null)
					null
				else
					eObject.jvmElements.psiClass
			}
		}
	}

	protected def getPsiClass(Collection<EObject> objects) {
		val jvmType = objects.filter(JvmDeclaredType).head
		if (jvmType == null) {
			return null
		}
		val psiElement = jvmType.psiElement
		if (psiElement instanceof PsiClass) {
			return psiElement
		}
	}

}