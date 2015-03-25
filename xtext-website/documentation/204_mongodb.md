---
layout: documentation
title: DSL for MongoDB
part: Seven JVM Languages Built With Xbase
---

# {{page.title}} {#mongoDB}

[MongoDB](http://www.mongodb.org) is a very popular document-based database management system. In mongoDB, database entries (AKA *documents*) have fields, which are essentially *(key, value)* pairs. MongoDB is schema free, i.e. there are no rules, which fields have to be defined and of what type they are. This allows for very flexible and heterogeneous data structures and is a perfect match with JSON. 

![](images/mongobeans_screenshot.png)

OTOH, Java is statically typed: The available types, their field names and field types are known and validated at compile time. The JavaBeans convention defines how instances can be manipulated. The standard mongoDB Java driver reflects the fact that mongoDB is schema-free by providing mongo documents as plain Java maps. 

With this language you can describe statically typed Java-facades for MongoDB documents without hiding the dynamic nature of them. The language uses a tree-like syntax similar to JSON but lets you add static Java type information.

## Overview {#mongo-solution}

In this project, we have created a small DSL *mongoBeans* based on Xtext that allows to create basic entity classes. These are backed by mongoDB objects but provide a statically typed JavaBeans API. Think of the language as a description how to map mongoDB documents to JavaBeans, in analogy to well known object relational mappers.

An example mongoBeans file looks like this: 

```mongobeans
import java.util.*

package org.musicdb {
    // a mongo bean
    Artist {
        String name    // single valued property
        Album* albums  // array property
        // an operation
        Iterable<Track> getOeuvre() {
            albums.map[track].flatten
        }
    }

    // another mongo bean
    Album {
        String title 
        int year 
        // inline definition of a mongo bean
        Track {        
            String title
            int seconds
        }* tracks
    }
}
```

For each *MongoBean* definition in a *MongoFile* file, we generate a Java class that wraps a [DBObject]({{site.javadoc.mongodb}}/com/mongodb/DBObject.html). The class provides statically typed getter and setter methods for all defined *MongoProperties*. In the implementation of these accessor methods we delegate to the wrapped [DBObject]({{site.javadoc.mongodb}}/com/mongodb/DBObject.html) and do all the casting and conversion work. For the `Artist` in the above example, this would look like

```java
public class Artist implements IMongoBean {

  private DBObject _dbObject;  
  ...
  public String getName() {
    return (String) _dbObject.get("name");
  }
  
  public void setName(final String name) {
     _dbObject.put("name", name);
  }
  ...
}
```

By using the generated Java code, the rest of the application can use a type-safe and JavaBeans conformant API to access the data model. In addition, *MongoBeans* can define *MongoOperations*, which are translated to Java methods. We can use *MongoProperties* as well as Java types inside the operations' bodies. 

Client code could then look like this: 

```java
Artist john = new Artist();
john.setName("John Coltrane");
Album album = new Album();
album.setTitle("A Love Supreme");
john.getAlbums().add(album);
Track...  // create some tracks and add them to the album
 
System.out.println(john.getName() + "'s Oeuvre");
for(Track track: john.getOeuvre()) 
  System.out.println(track.getTitle());

DBCollection dbCollection = ... // standard mongoDB driver code
dbCollection.save(john.getDBObject())
```

## Running the Example {#mongo-running}

In addition to the [common requirements](201_sevenlang_introduction.html#common-requirements), you need the [mongoDB implementation](http://www.mongodb.org/downloads) for your platform. We have included the mongoDB Java driver from [Eclipse Orbit](http://download.eclipse.org/tools/orbit/downloads/) in the code base. 

Import the projects into an Eclipse workspace and run the launch configuration *Run (org.eclipse.xtext.mongobeans)*. Import the example plug-in into the new workspace and run `MusicDBXtendTest` as a JUnit test.

## Grammar {#mongo-grammar}

The complete mongoBeans grammar looks like this: 

```xtext
grammar org.xtext.mongobeans.MongoBeans with org.eclipse.xtext.xbase.Xbase

generate mongoBeans "http://www.eclipse.org/xtext/mongobeans/MongoBeans"

MongoFile:
	importSection=XImportSection?
	elements+=AbstractElement*;

AbstractElement:
	PackageDeclaration | MongoBean;

PackageDeclaration:
	'package' name=QualifiedName '{'
		elements+=AbstractElement*
	'}';

MongoBean:
	name=ValidID '{'
		features+=AbstractFeature*
	'}';

AbstractFeature:
	MongoOperation | MongoProperty;

MongoProperty:
	(type=JvmTypeReference | inlineType=MongoBean) (many?='*')? name=ValidID;

MongoOperation:
	=>(returnType=JvmTypeReference name=ValidID '(') 
		(parameters+=FullJvmFormalParameter 
			(',' parameters+=FullJvmFormalParameter)*
		)? 
	')' 
	body=XBlockExpression;
```

The language inherits from the `Xbase` grammar in order to allow Xbase expressions and references to Java elements. A *MongoFile* starts with an import section (see [Build DSL](203_builddsl.html#builddsl-imports) for details). The import section is followed by any number of *AbstractElements*, which can be *PackageDeclarations* or *MongoBeans*. Note that as opposed to Java, *PackageDeclarations* can be nested. *MongoBeans* define statically typed *MongoProperties*, which can be single-valued or multi-valued denoted by an `*` following the type name. The type of a *MongoProperty* can also be defined inline. *MongoBeans* can also define *MongoOperations*. The body of such an operation is an *XBlockExpression* from Xbase. 

## Translation to Java {#mongo-inferrer}

The JVM model inference is implemented in the [MongoBeansJvmModelInferrer]({{site.src.sevenlang}}/languages/org.xtext.mongobeans/src/org/xtext/mongobeans/jvmmodel/MongoBeansJvmModelInferrer.xtend). As the generated code is quite rich, this is the most complex component of this language.

For each *MongoBean*, we create a Java class implementing the interface [IMongoBean]({{site.src.sevenlang}}/languages/org.xtext.mongobeans.lib/src/org/xtext/mongobeans/lib/IMongoBean.xtend). This interface is the first type of a small runtime library that has to be on the classpath at runtime.

*   DSL:
    
    ```mongobeans
    package org.musicdb {
      Artist { ...
    ```
*   Java:
    
    ```java
    package org.musicdb;
    ...
    public class Artist implements IMongoBean {  ...
    ```

The inferrer code responsible for this section looks like this: 

```xtend
@Inject extension JvmTypesBuilder
@Inject extension IQualifiedNameProvider  
...
def dispatch void infer(MongoFile file, 
                        IJvmDeclaredTypeAcceptor acceptor, 
                        boolean isPreIndexingPhase) {
  for(bean : file.eAllOfType(MongoBean)) {
       acceptor.accept(bean.toClass(bean.fullyQualifiedName))[
           documentation = bean.documentation
           superTypes += typeRef(IMongoBean)
... // calling various methods to create Java members
    // from the AbstractFeatures
      ]
  }
}
```

First, it finds all elements of type *MongoBean* in the given *MongoFile*. For each of these, it creates a new Java class. Then the documentation is copied and the interface [IMongoBean]({{site.src.sevenlang}}/languages/org.xtext.mongobeans.lib/src/org/xtext/mongobeans/lib/IMongoBean.xtend) is added to the list of supertypes. This will also insert a Java import at the appropriate location. 

Each *MongoBean* wraps a [DBObject]({{site.javadoc.mongodb}}/com/mongodb/DBObject.html), which is represented as a Java field with a getter. There are two constructors, one for a given [DBObject]({{site.javadoc.mongodb}}/com/mongodb/DBObject.html) and one that creates a new one. We have to store the class name in the DB object, if we want to be able to restore JavaBeans from query results.

*   DSL:
    
    ```mongobeans
    Artist { ...
    ```
*   Java:
    
    ```java
    public class Artist implements IMongoBean { 
      private DBObject _dbObject;
      
      public DBObject getDbObject() {
        return this._dbObject;
      }
    
      public Artist(final DBObject dbObject) {
        this._dbObject = dbObject;
      }
      
      public Artist() {
        _dbObject = new BasicDBObject();
        _dbObject.put(JAVA_CLASS_KEY, "org.musicdb.Artist");
      }
    ...
    ```

The inferrer code does this in two separate methods: One for the property `_dbObject` and another for the constructors. 

```xtend
def protected addDbObjectProperty(JvmDeclaredType 
                                  inferredType, 
                                  MongoBean bean) {
  inferredType.members += bean.toField('_dbObject', typeRef(DBObject))
  inferredType.members += bean.toGetter('dbObject', '_dbObject', typeRef(DBObject))
}

def protected addConstructors(JvmDeclaredType inferredType, 
                              MongoBean bean) {
  inferredType.members += bean.toConstructor [
    documentation = '''...'''
    parameters += bean.toParameter("dbObject", typeRef(DBObject))
    body = '''
      this._dbObject = dbObject;
    '''
  ]
  inferredType.members += bean.toConstructor [
    documentation = '''...'''
    body = '''
      _dbObject = new com.mongodb.BasicDBObject();
      _dbObject.put(JAVA_CLASS_KEY, "«inferredType.identifier»");
    '''
  ]
}
```

Next on our list are the getters and setters delegating to the `_dbObject`. We have to handle four cases: Properties with a type that can be handled by the mongoDB Java-driver directly (most primitive types, [String]({{site.javadoc.java}}/java/lang/String.html), [Date]({{site.javadoc.java}}/java/util/Date.html), etc.), [IMongoBean]({{site.src.sevenlang}}/languages/org.xtext.mongobeans.lib/src/org/xtext/mongobeans/lib/IMongoBean.xtend) properties, and their respective multi-valued counterparts: 

*   DSL:
    
    ```mongobeans
    ...
      String name     // primitive property
      Artist friend   // bean-type property
      String* aliases // multi-valued primitive property
      Album* albums   // multi-valued bean-type property
    ...
    ```
*   Java:
    
    ```java
    ...
      public String getName() {
        return (String) _dbObject.get("name");
      }
      public void setName(final String name) {
         _dbObject.put("name", name);
      }
      
      public Artist getFriend() {
        return WrappingUtil.wrapAndCast(
            (DBObject) _dbObject.get("friend"));
      }
      public void setFriend(final Artist friend) {
         _dbObject.put("friend", WrappingUtil.unwrap(friend));
      }
      
      public List<String> getAliases() {
        return (List<String>) _dbObject.get("aliases");
      }
      
      private MongoBeanList<Album> _albums;
      public List<Album> getAlbums() {
        if(_albums==null)
          _albums = new MongoBeanList<Album>(_dbObject, "albums");
        return _albums;
      }
    ...
    ```

The runtime helper class [WrappingUtil]({{site.src.sevenlang}}/languages/org.xtext.mongobeans.lib/src/org/xtext/mongobeans/lib/WrappingUtil.xtend) does the conversion between [DBObject]({{site.javadoc.mongodb}}/com/mongodb/DBObject.html) and [IMongoBean]({{site.src.sevenlang}}/languages/org.xtext.mongobeans.lib/src/org/xtext/mongobeans/lib/IMongoBean.xtend). For multi-valued *MongoProperties* we need getters only. If they have a primitive type, they can be handled by the Java-driver directly. Multi-valued *MongoBean* typed properties require a special [MongoBeanList]({{site.src.sevenlang}}/languages/org.xtext.mongobeans.lib/src/org/xtext/mongobeans/lib/MongoBeanList.xtend) to automatically wrap/unwrap the elements. 

The corresponding inferrer code does not show anything particularly new so we skip most of it for brevity. To detect whether a type is an [IMongoBean]({{site.src.sevenlang}}/languages/org.xtext.mongobeans.lib/src/org/xtext/mongobeans/lib/IMongoBean.xtend) or a primitive mongoDB type, we use the last helper class [MongoTypes]({{site.src.sevenlang}}/languages/org.xtext.mongobeans/src/org/xtext/mongobeans/jvmmodel/MongoTypes.xtend). The following snippet shows the inference of the getter for multi-valued properties:

```xtend
def protected addListAccessor(JvmDeclaredType inferredType,
                              MongoProperty property) {
  val propertyType = property.jvmType.asWrapperTypeIfPrimitive
  if(propertyType.isMongoPrimitiveType) {
    inferredType.members += property.toMethod(
      'get' + property.name.toFirstUpper, 
       typeRef(List, propertyType)
    ) [
...
    ]    
  } else {
    inferredType.members += property.toField(
      '_' + property.name, typeRef(MongoBeanList, propertyType))
    inferredType.members += property.toMethod(
      'get' + property.name.toFirstUpper, typeRef(List, propertyType)
    ) [
 ...
```

Last but not least, we infer Java methods for *MongoOperations*. 

*   DSL:
    
    ```mongobeans
    ...
      Iterable<Track> getOeuvre() {
          albums.map[tracks].flatten
      }
    ...
    ```
*   Java:
    
    ```java
    ...
      public Iterable<Track> getOeuvre() {
        // some java code you really don't care about 
        // but it should just do the right thing
      }
    ...
    ```

The inferrer code for this particular task is surprisingly simple, as we can directly associate the body of the *MongoOperation* to the generated Java method. The Xbase compiler will automatically transform that to Java. 

```xtend
def protected addMethod(JvmDeclaredType inferredType, 
                        MongoOperation operation) {
  inferredType.members += operation.toMethod(operation.name, 
      operation.returnType) [
    documentation = operation.documentation
    for(parameter: operation.parameters)
      parameters += parameter.toParameter(parameter.name, 
          parameter.parameterType)
    body = operation.body
  ]
}
```

## Qualified Name Provider {#mongo-name-provider}

By default, the qualified name of an element is calculated by joining all the simple names of its containers with a dot. In our example, the *MongoBean* `Track` would consequently be named `org.musicdb.Album.track.Track`. To ignore properties and beans on the path, we implemented our own [MongoQualifiedNameProvider]({{site.src.sevenlang}}/languages/org.xtext.mongobeans/src/org/xtext/mongobeans/scoping/MongoQualifiedNameProvider.xtend). 

```xtend
class MongoQualifiedNameProvider extends XbaseQualifiedNameProvider {
  
  def qualifiedName(MongoBean mongoBean) {
    val packageDeclaration = 
      mongoBean.getContainerOfType(PackageDeclaration)
    if(packageDeclaration != null) 
      packageDeclaration.fullyQualifiedName.append(mongoBean.name)
    else
      return QualifiedName.create(mongoBean.name)
  }
}
```

To make the framework pick up our customization, we have to add a binding in the respective [Guice module]({{site.src.sevenlang}}/languages/org.xtext.mongobeans/src/org/xtext/mongobeans/MongoBeansRuntimeModule.java). 

```java
@Override
public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
  return MongoQualifiedNameProvider.class;
}
```

See [Dependency Injection](302_configuration.html#dependency-injection) to learn more about Xtext's dependency injection.

## Validation {#mongo-validation}

The Java driver for mongoDB cannot map all Java types to mongoDB types. To enforce that constraint, we have added the [MongoBeansValidator]({{site.src.sevenlang}}/languages/org.xtext.mongobeans/src/org/xtext/mongobeans/validation/MongoBeansValidator.xtend). It also checks for missing types and avoids name collisions in the generated code with the implicitly defined property `dbObject`.

```xtend
class MongoBeansValidator extends XbaseJavaValidator {
...
  @Inject extension MongoTypes mongoTypes
  
  @Check def checkMongoProperty(MongoProperty it) {
    if (name == 'dbObject') 
      error("Illegal property name 'dbObject'", 
            ABSTRACT_FEATURE__NAME, 
            ILLEGAL_PROPERTY_NAME, 
            '_' + name)
    if (type != null) {
      if (!type.isMongoType)
        error('Only MongoBeans and mappable types are allowed',
              MONGO_PROPERTY__TYPE, ILLEGAL_TYPE)
    } else if (inlineType == null) {
      error('Type must be set', ABSTRACT_FEATURE__NAME, MISSING_TYPE)
    }
  }
...
```

## IDE Enhancements {#mongo-visual}

The validator from the previous section raises an error `ILLEGAL_PROPERTY_NAME` when a property is named [DBObject]({{site.javadoc.mongodb}}/com/mongodb/DBObject.html). We have implemented a quick fix to replace the invalid name: 

```xtend
class MongoBeansQuickfixProvider extends XbaseWithAnnotationsQuickfixProvider {

  @Fix(MongoBeansValidator.ILLEGAL_PROPERTY_NAME)
  def void capitalizeName(Issue issue, IssueResolutionAcceptor acceptor) {
    acceptor.accept(issue, 
        'Rename to ' + issue.data.head, 
        '''Rename property to «issue.data.head».''', 
        null) [
      xtextDocument.replace(issue.offset, issue.length, issue.data.head)
    ]
  }
}
```

To improve the language IDE visually, we have tuned the [outline]({{site.src.sevenlang}}/languages/org.xtext.mongobeans.ui/src/org/xtext/mongobeans/ui/outline/MongoBeansOutlineTreeProvider.xtend) a bit

```xtend
class MongoBeansOutlineTreeProvider extends DefaultOutlineTreeProvider {
  // don't show children of operations
  def _isLeaf(MongoOperation operation) {
    true
  }
  
  // show inline declared MongoBeans
  def _createChildren(IOutlineNode parentNode, MongoProperty property) {
    if(property.inlineType != null)
      parentNode.createNode(property.inlineType)
  }
  
  def _isLeaf(MongoProperty property) {
    property.inlineType == null
  }
}
```

and the [label provider]({{site.src.sevenlang}}/languages/org.xtext.mongobeans.ui/src/org/xtext/mongobeans/ui/labeling/MongoBeansLabelProvider.xtend) as well:

```xtend
class MongoBeansLabelProvider extends XbaseLabelProvider {
...  
  override image(Object element) {
    // icons are stored in the 'icons' folder of this project
    switch element {
      MongoBean: 'Letter-B-blue-icon.png'
      MongoProperty: 'Letter-P-orange-icon.png'
      MongoOperation: 'Letter-O-red-icon.png'
      Import: 'imp_obj.gif'
      PackageDeclaration: 'package_obj.gif'
      default:
        super.image(element)
    }
  } 
```

---

**[Next Chapter: DSL for Guice](205_guice.html)**