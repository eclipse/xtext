package org.eclipse.xtext.java.tests

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.access.IJvmTypeProvider
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.InMemoryURIHandler
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(JavaInjectorProvider)
class JavaSourceLanguageTest {

    @Test def void testNestedTypes() {
        val rs = resourceSet('MySuperClass.java' -> '''
            public class MySuperClass {
                interface InnerType {}
            }
        ''', 'MySubClass.java' -> '''
            public class MySubClass extends MySuperClass {
                public InnerType doStuff(InnerType some) {
                    return some;
                }
            }
        ''')
        val superResource = rs.resources.findFirst[URI.toString.endsWith('MySuperClass.java')]
        val nestedType = (superResource.contents.head as JvmGenericType).allNestedTypes.head
        val resource = rs.resources.findFirst[URI.toString.endsWith('MySubClass.java')]
        val clazz = resource.contents.head as JvmGenericType
        val returnType = clazz.declaredOperations.head.returnType
        val referenced = returnType.type
        Assert.assertSame(nestedType, referenced)
    }

    @Test def void testPackageInfo() {
        val rs = resourceSet( 'a/package-info.java' -> '''
            package a;
        ''', 'a/MyClass.java' -> '''
            package a;
            public class MyClass {
            }
        ''')
        val r1 = rs.resources.findFirst[URI.toString.endsWith('package-info.java')]
        Assert.assertEquals(0, r1.contents.size)
        val r2 = rs.resources.findFirst[URI.toString.endsWith('MyClass.java')]
        Assert.assertEquals(1, r2.contents.size)
    }

    @Test def void testOverridenInterfaceMethod() {
        val rs = resourceSet('MySuperClass.java' -> '''
            public interface MySuperClass {
                public java.util.Collection<? extends CharSequence> getThem();
            }
        ''', 'MySubClass.java' -> '''
            public interface MySubClass extends MySuperClass {
                @Override
                public java.util.List<? extends String> getThem();
            }
        ''')
        val resource = rs.resources.findFirst[URI.toString.endsWith('MySubClass.java')]
        val clazz = resource.contents.head as JvmGenericType
        val referenced = clazz.declaredOperations.head.returnType
        Assert.assertNotNull((referenced as JvmParameterizedTypeReference).arguments.head)
    }

    @Test def void testAnnotation() {
        val rs = resourceSet('MyAnnotation.java' -> '''
            public @interface MyAnnotation {
                String value();
                Class<?>[] imported() default {};
                boolean statementExpression() default false;
                boolean constantExpression() default false;
            }
        ''', 'MyClass.java' -> '''
            @MyAnnotation(value="foo", constantExpression = true)
            public interface MyClass {
            }
        ''')
        val annotation = rs.resources.findFirst[URI.toString.endsWith('MyAnnotation.java')].contents.head
        val resource = rs.resources.findFirst[URI.toString.endsWith('MyClass.java')]
        val clazz = resource.contents.head as JvmGenericType
        val annotationRef = clazz.annotations.head
        val value = annotationRef.values.findFirst[operation.simpleName == 'constantExpression']
        Assert.assertTrue((value as JvmBooleanAnnotationValue).values.head)
        val value2 = annotationRef.values.findFirst[it.operation.simpleName == 'statementExpression']
        Assert.assertFalse((value2 as JvmBooleanAnnotationValue).values.head)
        Assert.assertSame(annotation, annotationRef.annotation)
    }

    @Test def void testClassShadowing() {
    	    val rs = resourceSet('org/eclipse/xtext/java/tests/MySuperClass2.java' -> '''
            package org.eclipse.xtext.java.tests;
            public class MySuperClass2 {
                public void doSomething() {
                    
                }
            }
        ''', 'org/eclipse/xtext/java/tests/MySubClass2.java' -> '''
            package org.eclipse.xtext.java.tests;
            public class MySubClass2 extends MySuperClass2 {
            }
        ''')
        val superResource = rs.resources.findFirst[URI.toString.endsWith('MySuperClass2.java')]
        val clazz = superResource.contents.head as JvmGenericType
        Assert.assertNotNull(clazz.declaredOperations.head)
    }

    @Inject Provider<XtextResourceSet> resourceSetProvider
    @Inject IResourceDescription.Manager resourceDesriptionManager
    @Inject IJvmTypeProvider.Factory typeProviderFactory

    def protected resourceSet(Pair<String, String> ... files) {
        val result = resourceSetProvider.get
        typeProviderFactory.createTypeProvider(result)
        result.classpathURIContext = class.classLoader
        result.URIConverter.URIHandlers.clear
        val uriHandler = new InMemoryURIHandler
        val uris = files.map [
            val uri = URI.createURI(InMemoryURIHandler.SCHEME + ":/" + key)
            val out = uriHandler.createOutputStream(uri, emptyMap)
            out.write(value.bytes)
            out.close
            return uri
        ]
        result.URIConverter.URIHandlers.add(uriHandler)
        val List<IResourceDescription> descriptions = newArrayList()
        for (uri : uris) {
            val resource = result.getResource(uri, true)
            descriptions += resourceDesriptionManager.getResourceDescription(resource);
        }
        val chunkedResourceDescriptions = new ChunkedResourceDescriptions(#{
            'default' -> new ResourceDescriptionsData(descriptions)
        })
        (chunkedResourceDescriptions).attachToEmfObject(result)
        return result
    }
}
