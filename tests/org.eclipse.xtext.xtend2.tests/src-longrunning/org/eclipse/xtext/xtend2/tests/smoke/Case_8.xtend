package org.eclipse.xtext.xtend2.tests.smoke

import static junit.framework.Assert.*
import org.junit.runner.RunWith
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.junit.util.ParseHelper
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil

//@RunWith(typeof(XtextRunner))
//@InjectWith(typeof(ClasspathAwareInjectorProvider))
class Case_8 {

    @Inject
    extension ParseHelper<EObject> helper

    @Inject
    extension IQualifiedNameProvider qualifiedNameProvider

    def getErrors(EObject obj) {
        obj.eResource.errors
    }

    def resolve(EObject obj) {
        EcoreUtil::resolveAll(obj.eResource)
    }

    def parseAcme(CharSequence seq) {
        seq.parse.eContents.head
    }

    @Inject
    def explicitName() {
        val element = '''
            com.acme.SimpleElement as FooBar {}
        '''.parseAcme
        assertEquals("FooBar", element.fullyQualifiedName.toString)
    }

}