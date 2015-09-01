/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.findUsages

import com.intellij.find.FindManager
import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.impl.FindManagerImpl
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiNamedElement
import com.intellij.usageView.UsageInfo
import com.intellij.util.CommonProcessors
import org.eclipse.xtend.idea.LightXtendTest

import static extension com.intellij.psi.util.PsiTreeUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendFindUsagesTest extends LightXtendTest {

	def void testGeneratedElements_01() {
		val file = myFixture.addFileToProject('mypackage/MyClass.xtend', '''
			package mypackage
			
			class MyClass {
			}
		''')
		val element = file.getNamedElementAt('MyClass')
		element.testFindUsages('''
			primaryElements {
				org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Type_XtendClassAnnotationInfoAction_2_0_0_ELEMENT_TYPE)
			}
			secondaryElements {
				PsiClass:MyClass
			}
		''')
	}

	def void testGeneratedElements_02() {
		val file = myFixture.addFileToProject('mypackage/MyClass.xtend', '''
			package mypackage
			
			class MyClass {
			}
		''')
		myFixture.addFileToProject('mypackage/MyClass2.xtend', '''
			package mypackage
			
			class MyClass2 extends MyClass {
			}
		''')
		val element = file.getNamedElementAt('MyClass')
		element.testFindUsages('''
			primaryElements {
				org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Type_XtendClassAnnotationInfoAction_2_0_0_ELEMENT_TYPE) {
					MyClass (class org.eclipse.xtext.psi.impl.XtextPsiReferenceImpl) {
						virtualFile : temp:///src/mypackage/MyClass2.xtend
						navigationOffset : 42
					}
				}
			}
			secondaryElements {
				PsiClass:MyClass {
					mypackage.MyClass (class com.intellij.psi.impl.source.PsiJavaCodeReferenceElementImpl) {
						virtualFile : temp:///src/xtend-gen/mypackage/MyClass2.java
						navigationOffset : 37
					}
					mypackage.MyClass (class com.intellij.psi.impl.source.PsiJavaCodeReferenceElementImpl) {
						virtualFile : temp:///src/xtend-gen/mypackage/MyClass2.java
						navigationOffset : 102
					}
				}
			}
		''')
	}

	def void testGeneratedElements_03() {
		val file = myFixture.addFileToProject('mypackage/MyClass.xtend', '''
			package mypackage

			import org.eclipse.xtend.lib.annotations.Accessors
			
			@Accessors class MyClass {
				int x
				int y
				def getX() {
					y
				}
			}
		''') 

		file.getNamedElementAt('int x').testFindUsages('''
			primaryElements {
				org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Member_XtendFieldAnnotationInfoAction_2_0_0_ELEMENT_TYPE)
			}
			secondaryElements {
				PsiField:x {
					this.x (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {
						virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java
						navigationOffset : 304
					}
				}
				PsiMethod:setX
				PsiParameter:x {
					x (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {
						virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java
						navigationOffset : 308
					}
				}
			}
		''')
	}

	def void testGeneratedElements_04() {
		val file = myFixture.addFileToProject('mypackage/MyClass.xtend', '''
			package mypackage

			import org.eclipse.xtend.lib.annotations.Accessors
			
			@Accessors class MyClass {
				int x
				int y
				def getX() {
					y
				}
			}
		''') 

		file.getNamedElementAt('int y').testFindUsages('''
			primaryElements {
				org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Member_XtendFieldAnnotationInfoAction_2_0_0_ELEMENT_TYPE) {
					y (class org.eclipse.xtext.psi.impl.XtextPsiReferenceImpl) {
						virtualFile : temp:///src/mypackage/MyClass.xtend
						navigationOffset : 128
					}
				}
			}
			secondaryElements {
				PsiField:y {
					this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {
						virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java
						navigationOffset : 251
					}
					this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {
						virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java
						navigationOffset : 364
					}
					this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {
						virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java
						navigationOffset : 417
					}
				}
				PsiMethod:getY
				PsiMethod:setY
				PsiParameter:y {
					y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {
						virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java
						navigationOffset : 421
					}
				}
			}
		''')
	}

	def void testOriginalElements_01() {
		val sourceFile = myFixture.addFileToProject('mypackage/MyClass.xtend', '''
			package mypackage
			
			class MyClass {
			}
		''')
		val generatedSource = sourceFile.getGeneratedSources[extension == 'java'].head
		val element = generatedSource.getNamedElementAt('MyClass')
		element.testFindUsages('''
			primaryElements {
				PsiClass:MyClass
			}
			secondaryElements {
				org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Type_XtendClassAnnotationInfoAction_2_0_0_ELEMENT_TYPE)
			}
		''')
	}

	def void testOriginalElements_02() {
		val sourceFile = myFixture.addFileToProject('mypackage/MyClass.xtend', '''
			package mypackage
			
			class MyClass {
			}
		''')
		myFixture.addFileToProject('mypackage/MyClass2.xtend', '''
			package mypackage
			
			class MyClass2 extends MyClass {
			}
		''')
		val generatedSource = sourceFile.getGeneratedSources[extension == 'java'].head
		val element = generatedSource.getNamedElementAt('MyClass')
		element.testFindUsages('''
			primaryElements {
				PsiClass:MyClass {
					mypackage.MyClass (class com.intellij.psi.impl.source.PsiJavaCodeReferenceElementImpl) {
						virtualFile : temp:///src/xtend-gen/mypackage/MyClass2.java
						navigationOffset : 37
					}
					mypackage.MyClass (class com.intellij.psi.impl.source.PsiJavaCodeReferenceElementImpl) {
						virtualFile : temp:///src/xtend-gen/mypackage/MyClass2.java
						navigationOffset : 102
					}
				}
			}
			secondaryElements {
				org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Type_XtendClassAnnotationInfoAction_2_0_0_ELEMENT_TYPE) {
					MyClass (class org.eclipse.xtext.psi.impl.XtextPsiReferenceImpl) {
						virtualFile : temp:///src/mypackage/MyClass2.xtend
						navigationOffset : 42
					}
				}
			}
		''')
	}

	def void testOriginalElements_03() {
		val sourceFile = myFixture.addFileToProject('mypackage/MyClass.xtend', '''
			package mypackage

			import org.eclipse.xtend.lib.annotations.Accessors
			
			@Accessors class MyClass {
				int x
				int y
				def getX() {
					y
				}
			}
		''') 

		val generatedSource = sourceFile.getGeneratedSources[extension == 'java'].head
		generatedSource.getNamedElementAt('int x').testFindUsages('''
			primaryElements {
				PsiField:x {
					this.x (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {
						virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java
						navigationOffset : 304
					}
				}
			}
			secondaryElements {
				org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Member_XtendFieldAnnotationInfoAction_2_0_0_ELEMENT_TYPE)
			}
		''')
	}

	def void testOriginalElements_04() {
		val sourceFile = myFixture.addFileToProject('mypackage/MyClass.xtend', '''
			package mypackage

			import org.eclipse.xtend.lib.annotations.Accessors
			
			@Accessors class MyClass {
				int x
				int y
				def getX() {
					y
				}
			}
		''') 

		val generatedSource = sourceFile.getGeneratedSources[extension == 'java'].head
		generatedSource.getNamedElementAt('int y').testFindUsages('''
			primaryElements {
				PsiField:y {
					this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {
						virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java
						navigationOffset : 251
					}
					this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {
						virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java
						navigationOffset : 364
					}
					this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {
						virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java
						navigationOffset : 417
					}
				}
			}
			secondaryElements {
				org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Member_XtendFieldAnnotationInfoAction_2_0_0_ELEMENT_TYPE) {
					y (class org.eclipse.xtext.psi.impl.XtextPsiReferenceImpl) {
						virtualFile : temp:///src/mypackage/MyClass.xtend
						navigationOffset : 128
					}
				}
			}
		''')
	}

	protected def getNamedElementAt(PsiFile file, String substring) {
		val offset = file.text.indexOf(substring)
		file.findElementAt(offset).getParentOfType(PsiNamedElement, false)
	}

	protected def void testHighlightUsages(PsiElement element, String expectation) {
		assertEquals(expectation, element.highlightUsagesHandler.printUsages)
	}

	protected def void testFindUsages(PsiElement element, String expectation) {
		assertEquals(expectation, element.findUsagesHandler.printUsages)
	}

	protected def String printUsages(FindUsagesHandler findUsagesHandler) {
		val primaryElements = findUsagesHandler.primaryElements
		val secondaryElements = findUsagesHandler.secondaryElements
		'''
			primaryElements {
				«findUsagesHandler.printUsages(primaryElements)»
			}
			secondaryElements {
				«findUsagesHandler.printUsages(secondaryElements)»
			}
		'''
	}

	protected def String printUsages(FindUsagesHandler findUsagesHandler, PsiElement ... elements) '''
		«FOR element : elements»
			«element»«val usages = findUsagesHandler.findUsages(element)»«IF !usages.empty» {
				«FOR usage : usages»
					«usage» {
						virtualFile : «usage.virtualFile»
						navigationOffset : «usage.navigationOffset»
					}
				«ENDFOR»
			}«ENDIF»
		«ENDFOR»
	'''

	protected def findUsages(FindUsagesHandler findUsagesHandler, PsiElement ... elements) {
		val processor = new CommonProcessors.CollectProcessor<UsageInfo>
		val options = findUsagesHandler.getFindUsagesOptions(null)
		for (element : elements)
			findUsagesHandler.processElementUsages(element, processor, options)
		processor.results
	}

	protected def getHighlightUsagesHandler(PsiElement element) {
		findManager.findUsagesManager.getFindUsagesHandler(element, true)
	}

	protected def getFindUsagesHandler(PsiElement element) {
		findManager.findUsagesManager.getFindUsagesHandler(element, false)
	}

	protected def getFindManager() {
		FindManager.getInstance(myFixture.project) as FindManagerImpl
	}

}