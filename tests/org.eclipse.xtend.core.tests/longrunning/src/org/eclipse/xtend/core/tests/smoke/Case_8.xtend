package org.eclipse.xtend.core.tests.smoke

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.naming.IQualifiedNameProvider

import static org.junit.Assert.*

@SuppressWarnings("all")
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

	def <T1  extends  Object> List<List<T1>> foo(T1 t) {
        return null
    }
}