package org.eclipse.xtend.ide.tests.refactoring

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator
import org.junit.Test

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import org.eclipse.core.runtime.NullProgressMonitor

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class DependentElementsCalculatorTests extends AbstractXtendUITestCase {
	
	@Inject IDependentElementsCalculator dependentElementsCalculator;
	
	@Inject extension IXtendJvmAssociations associations;
	
	@Inject WorkbenchTestHelper testHelper;
	
	@Test def testDependentElements() {
		val file = testHelper.xtendFile('Foo', '''
			class Foo {
				def Foo foo() {
					new Foo()
				}
			}
		''')
		val fooClass = file.xtendTypes.get(0) as XtendClass
		val dependentElementURIs = dependentElementsCalculator.getDependentElementURIs(fooClass, new NullProgressMonitor)
		assertEquals(3, dependentElementURIs.size);
		val fooFunction = fooClass.members.get(0) as XtendFunction
		for (it : newArrayList(fooFunction, fooClass.inferredType, fooClass.inferredConstructor)) {
			assertTrue(it.toString, dependentElementURIs.exists[element|element == it.URI])
		}
	}
	
	@Test def testPolymorphicDispatch() {
		val fooFile = testHelper.xtendFile('Foo', '''
			class Foo {
				def dispatch foo(Number it) {
				}
				def dispatch foo(String it) {
				}
			}
		''');
		IResourcesSetupUtil::waitForBuild
		val fooClass = fooFile.xtendTypes.get(0) as XtendClass
		val fooMethod1 = fooClass.members.get(1)
		val dependentElementURIs = dependentElementsCalculator.getDependentElementURIs(fooMethod1, new NullProgressMonitor)
		assertEquals(5, dependentElementURIs.size);
		for (it : (fooClass.members + fooClass.inferredType.members).filter[!(it instanceof JvmConstructor)].toList) {
			assertTrue(it.toString, dependentElementURIs.exists[element|element == it.URI])
		}
	}
}