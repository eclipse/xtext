---
layout: documentation
title: The Grammar Language
part: Reference Documentation
---

# {{page.title}} {#grammarLanguage}

The [grammar language]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/Xtext.xtext) is the corner stone of Xtext. It is a domain-specific language, carefully designed for the description of textual languages. The main idea is to describe the concrete syntax and how it is mapped to an in-memory representation - the semantic model. This model will be produced by the parser on-the-fly when it consumes an input file.

## A First Example {#statemachine}

To get an idea of how it works we'll start by implementing a [simple example](http://martinfowler.com/bliki/SyntacticNoise.html) introduced by Martin Fowler. It's mainly about describing state machines that are used as the (un)lock mechanism of secret compartments. People who have secret compartments control their access in a very old-school way, e.g. by opening a draw first and turning on the light afterwards. Then the secret compartment, for instance a panel, opens up. One of those state machines could look like this:

```fowlerexample
events
  doorClosed  D1CL
  drawOpened  D2OP
  lightOn     L1ON
  doorOpened  D1OP
  panelClosed PNCL
 end
 
resetEvents 
  doorOpened D1OP
end
 
commands
  unlockPanel PNUL
  lockPanel   PNLK
  lockDoor    D1LK
  unlockDoor  D1UL
end
 
state idle
  actions {unlockDoor lockPanel}
  doorClosed => active
end
 
state active
  drawOpened => waitingForLight
  lightOn    => waitingForDraw
end
 
state waitingForLight
  lightOn => unlockedPanel
end
 
state waitingForDraw
  drawOpened => unlockedPanel
end
 
state unlockedPanel
  actions {unlockPanel lockDoor}
  panelClosed => idle
end
```

What we have are a bunch of declared events, commands, and states. Some events are additionally marked as being reset events. Within states there are references to declared actions. Actions should be executed when entering the state. Furthermore, there are transitions consisting of a reference to an event and a state.

The first thing that you have to do in order to implement this tiny state machine example with Xtext, is to provide a grammar. It could look like this example:

```xtext
grammar org.xtext.example.SecretCompartments 
   with org.eclipse.xtext.common.Terminals

generate secrets "http://www.eclipse.org/secretcompartment"
 
Statemachine :
  'events'
     (events+=Event)+
  'end'
  ('resetEvents'
     (resetEvents+=[Event])+
  'end')?
  'commands'
     (commands+=Command)+
  'end'
  (states+=State)+;
 
Event :
  name=ID code=ID;
 
Command :
  name=ID code=ID;
 
State :
  'state' name=ID
     ('actions' '{' (actions+=[Command])+ '}')?
     (transitions+=Transition)*
  'end';
 
Transition :
  event=[Event] '=>' state=[State];
```

Martin Fowler uses this example throughout his book [Domain Specific Languages](http://martinfowler.com/books/dsl.html) to implement external and internal DSLs using different technologies. Note that none of his implementations is nearly as readable and concise as the description in Xtext's grammar language above. That is of course because the grammar language is designed to do just that, i.e. it is specific to the domain of language descriptions.

## The Syntax {#syntax}

In the following the different concepts and syntactical constructs of the grammar language are explained. 

### Language Declaration

Each Xtext grammar starts with a header that defines some properties of the grammar.

```xtext
grammar org.xtext.example.SecretCompartments
   with org.eclipse.xtext.common.Terminals
```

The first line declares the name of the language. Xtext leverages Java's class path mechanism. This means that the name can be any valid Java qualifier. The file name needs to correspond to the language name and have the file extension `.xtext`. This means that the name has to be *SecretCompartments.xtext* and must be placed in a package *org.xtext.example* on your project's class path. In other words, your `.xtext` file has to reside in a Java source folder to be valid.

The second aspect that can be deduced from the first line of the grammar is its relationship to other languages. An Xtext grammar can declare another existing grammar to be reused. The mechanism is called [grammar mixin](301_grammarlanguage.html#grammar-mixins)).

### EPackage Declarations {#package-declarations}

Xtext parsers create in-memory object graphs while consuming text. Such object-graphs are instances of EMF Ecore models. An Ecore model basically consists of an [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) containing [EClasses]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java), [EDataTypes]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EDataType.java) and [EEnums]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EEnum.java) (see the [section on EMF](308_emf_integration.html#model-metamodel) for more details) and describes the structure of the instantiated objects. Xtext can infer Ecore models from a grammar (see [Ecore model inference](301_grammarlanguage.html#metamodel-inference)) but it is also possible to import existing Ecore models. You can even mix both approaches and use multiple existing Ecore models and infer some others from a single grammar. This allows for easy reuse of existing abstractions while still having the advantage of short turnarounds with derived Ecore models. 

#### EPackage Generation

The easiest way to get started is to let Xtext infer the Ecore model from your grammar. This is what is done in the secret compartment example. The `generate` declaration in the grammar advises the framework to do so:

`generate secrets 'http://www.eclipse.org/secretcompartment'`

That statement could actually be read as: generate an [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) with the *name* `secrets` and the *nsURI* `"http://www.eclipse.org/secretcompartment"`. Actually these are the mandatory properties that are necessary to create an empty [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java). Xtext will then add [EClasses]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java) with [EAttributes]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EAttribute.java) and [EReferences]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EReference.java) for the different parser rules in your grammar, as described in [Ecore model inference](301_grammarlanguage.html#metamodel-inference). 

#### EPackage Import {#epackage-import}

If you already have an existing [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java), you can import it using its namespace URI or a resource URI. An [URI](http://www.ietf.org/rfc/rfc2396.txt) (Uniform Resource Identifier) provides a simple and extensible means for identifying an abstract or physical resource. For all the nifty details about EMF URIs please refer to its [documentation]({{site.src.emf}}/plugins/org.eclipse.emf.common/src/org/eclipse/emf/common/util/URI.java). It is strongly recommended to use the namespace URI instead of the resource uri because it is independent from the concrete location in the file system and much more portable across different machines, easier to configure in the workflow and works better with language mixins. The import via platform URIs or file URIs can be considered deprecated and is only supported for backwards compatibility reasons.

##### Using Namespace URIs to Import Existing EPackages

You can use namespace URI in order to import existing [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java). This is generally preferable. The package will be read from the Xtext index and therefore your grammar is independent from the concrete location of the respective ecore file. You have to make sure though that the ecore file is contained in a project that is managed by Xtext. Therefore the project has to have to Xtext project nature attached. Ecore files that reside in referenced Java archives (JARs) are automatically picked up and indexed if the referencing project itself is an Xtext project.

To import an EPackage, you have to state its namespace URI like this:

`import "http://www.xtext.org/example/Domainmodel" as dmodel`

In order to be able to find the referenced package in the language generator, some configuration values have to be set. It is usually the easiest way to register the generated [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) interface in the workflow. The [StandaloneSetup]({{site.src.mwe}}/plugins/org.eclipse.emf.mwe.utils/src/org/eclipse/emf/mwe/utils/StandaloneSetup.java) offers the respective methods to achieve this. Simply state something like this in the workflow:

```mwe2
bean = StandaloneSetup {
  platformUri = "${runtimeProject}/../.."
  scanClassPath = true
  registerGeneratedEPackage = 
   "org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage"
  registerGenModelFile = 
   "platform:/resource/.../path/to/Domainmodel.genmodel"
}
```

The registered genmodel is necessary to tell the code generator how the referenced Java classes are named. Please see below for alternatives that allow to register the genmodel, too. They may be handy if you create the genmodel in the workflow itself. 

If the generated EPackage interface is not available when the language workflow is executed, you can use another approach to register the reference packages. This may happen if your want to generate EMF classes and the language infrastructure in one and the same workflow. The section in the workflow that refers the your grammar allows to set additional resources that should be loaded prior to loading the grammar file. The ecore files that contain the referenced EPackages are a good candidate for preloaded resources.

```mwe2
language = {
  loadedResource = 
   "platform:/resource/.../path/to/Domainmodel.ecore"
  uri = grammarURI
}
```

You can use either platform URIs or class path URIs to list the required ecore files (see below for details on both URI schemes).

Important note: EPackages have to refer to each other by means of platform-resource or platform-plugin URIs. Otherwise you'll get validation errors in the grammar editor. However, it'll provide quick fixes to update the ecore files accordingly. There is only one exception to the rule: If you refer to data types from the ecore package or directly to [EObject]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EObject.java), the namespace URI is valid, too. This is due to special assignability rules for these types. If you craft the EPackage manually, you'll usually face no problems due to these constraints since the reflective Ecore editor inserts platform URIs by default. The other cases and legacy packages (those that were tailored to match the restrictions of older Xtext versions) can be converted with the quick fixes in the grammar editor.

If you used platform-plugin URIs in the ecore files and cannot use the generated [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) in the workflow, you'll have to register URI mappings from platform-plugin to platform-resource.

```mwe2
bean = StandaloneSetup {
  platformUri = "${runtimeProject}/../.."
  scanClassPath = true
  uriMap = {
    from = "platform:/plugin/some.plugin/model/File.ecore"
    to = "platform:/resource/some.plugin/model/File.ecore"
  }
  // assuming that Domainmodel.ecore uses 
  // platform:/plugin/some.plugin/model/File.ecore
  registerEcoreFile = 
   "platform:/resource/.../path/to/Domainmodel.ecore"
  registerGenModelFile = 
   "platform:/resource/.../path/to/Domainmodel.genmodel"
}
```

If you face problems with that approach, it may be necessary to explicitly load the referenced packages in the language configuration of the workflow. You may run into this as soon as you refer to elements from *Ecore.ecore* and want to generate the EMF classes from within the same workflow.

```mwe2
language = {
  loadedResource = "platform:/resource/.../path/to/Domainmodel.ecore"
  loadedResource = "platform:/plugin/some.plugin/model/File.ecore"
  
  uri = "classpath:/.../path/to/Domainmodel.xtext"
  ..
}
```

##### Using Resource URIs to Import Existing EPackages - Deprecated

In order to import an existing Ecore model, you'll have to have the \*.ecore file describing the [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) you want to use somewhere in your workspace. To refer to that file you make use of the *platform:/resource* scheme. Platform URIs are a special EMF concept which allow to reference elements in the workspace independent of the physical location of the workspace. It is an abstraction that uses the Eclipse workspace concept as the logical root of each project. 

An import statement referring to an Ecore file by a *platform:/resource/*-URI looks like this: 

`import 'platform:/resource/my.project/model/SecretCompartments.ecore'`

If you want to mix generated and imported Ecore models you'll have to configure the generator fragment in your MWE file responsible for [generating the Ecore classes]({{site.src.xtext}}/plugins/org.eclipse.xtext.generator/src/org/eclipse/xtext/generator/ecore/EcoreGeneratorFragment.java) with resource URIs that point to the [generator models](308_emf_integration.html#emf-codegen) of the referenced Ecore models.

The *\*.genmodel* provides all kind of generator configuration used by EMF's code generator. Xtext will automatically create a generator model for derived [EPackages]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java), but if it references an existing, imported Ecore model, the code generator needs to know how that code was generated in order to generate valid Java code. 

Example:

```mwe2
fragment = org.eclipse.xtext.generator.ecore.EcoreGeneratorFragment {
  referencedGenModels =
    "platform:/resource/my.project/model/SecretCompartments.genmodel"
}
```

##### Using Class Path URIs to Import Existing EPackages - Deprecated

We usually like to leverage Java's class path mechanism, because is is well understood and can be configured easily with Eclipse. Furthermore it allows us to package libraries as jars. If you want to reference an existing *\*.ecore* file which is contained in a jar, you can make use of the *'classpath:'* URI scheme we've introduced. For instance if you want to reference Java elements, you can use the JvmType Ecore model which is shipped as part of Xtext. 

Example:

`import 'classpath:/model/JvmTypes.ecore' as types`

As with platform resource URIs you'll also have to tell the generator where the corresponding *\*.genmodel* can be found:

```mwe2
fragment = org.eclipse.xtext.generator.ecore.EcoreGeneratorFragment {
  referencedGenModels =
    "classpath:/model/JvmTypes.genmodel"
}
```

See the section on [Referring Java Types](305_xbase.html#jvmtypes) for a full explanation of this useful feature.

#### Ecore Model Aliases for EPackages

If you want to use multiple [EPackages]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) you need to specify aliases in the following way:

```xtext
generate secrets 'http://www.eclipse.org/secretcompartment'
import 'http://www.eclipse.org/anotherPackage' as another
```

When referring to a type somewhere in the grammar you need to qualify the reference using that alias (example `another::SomeType`). We'll see later where such type references occur.

It is also supported to put multiple [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) imports into one alias. This is no problem as long as there are not any two [EClassifiers]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClassifier.java) with the same name. In that case none of them can be referenced. It is even possible to `import` multiple and `generate` one Ecore model and declare all of them with same alias. If you do so, for a reference to an [EClassifier]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClassifier.java) first the imported [EPackages]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) are scanned before it is assumed that a type needs to be generated into the inferred package. 

Note that using this feature is not recommended, because it might cause problems that are hard to track down. For instance, a reference to *classA* would as well be linked to a newly created [EClass]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java), because the corresponding type in *http://www.eclipse.org/packContainingClassA* is spelled with a capital letter.

---

### Rules

Basically parsing can be separated in the following phases. 

1.  Lexing
1.  Parsing
1.  Linking
1.  Validation

#### Terminal Rules

In the first stage called *lexing*, a sequence of characters (the text input) is transformed into a sequence of so called tokens. In this context, a token is sort of a strongly typed part or region of the input sequence. It consists of one or more characters and was matched by a particular terminal rule or keyword and therefore represents an atomic symbol. Terminal rules are also referred to as *token rules* or *lexer rules*. There is an informal naming convention that names of terminal rules are all upper-case.

In the secret compartments example there are no explicitly defined terminal rules, since it only uses the *ID* rule which is inherited from the grammar `org.eclipse.xtext.common.Terminals` (cf. [Grammar Mixins](301_grammarlanguage.html#grammar-mixins)). Therein the *ID* rule is defined as follows:

```xtext
terminal ID : 
  ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*; 
```

It says that a token *ID* starts with an optional `'^'` character (caret), followed by a letter `('a'..'z'|'A'..'Z')` or underscore `'_'` followed by any number of letters, underscores and numbers `('0'..'9')`. 

The caret is used to escape an identifier if there are conflicts with existing keywords. It is removed by the *ID* rule's [ValueConverter](303_runtime_concepts.html#value-converter). 

This is the simplified formal definition of terminal rules:

```xtext
TerminalRule :
  'terminal' name=ID ('returns' type=TypeRef)? ':' 
    alternatives=TerminalAlternatives ';'
;
```

Note that *the order of terminal rules is crucial for your grammar*, as they may shadow each other. This is especially important for newly introduced rules in connection with imported rules from used grammars. 

It's almost in any case recommended to use data type rules instead. Let's assume you want to add a rule to allow fully qualified names in addition to simple IDs. Since a qualified name with only one segment looks like a plain ID, you should implement it as a [data type rule](301_grammarlanguage.html#datatype-rules), instead of adding another terminal rule. The same rule of thumb applies to floating point literals, too.

##### Return Types

Each terminal rule returns an atomic value (an `Ecore EDataType`). By default, it's assumed that an instance of `ecore::EString`) should be returned. However, if you want to provide a different type you can specify it. For instance, the rule *INT* is defined as:

```xtext
terminal INT returns ecore::EInt : 
  ('0'..'9')+;
```

This means that the terminal rule *INT* returns instances of `ecore::EInt`. It is possible to define any kind of data type here, which just needs to be an instance of `ecore::EDataType`. In order to tell the framework how to convert the parsed string to a value of the declared data type, you need to provide your own implementation of [IValueConverterService]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/conversion/IValueConverterService.java) (cf. [value converters](303_runtime_concepts.html#value-converter)). The value converter is also the service that allows to remove escape sequences or semantically unnecessary character like quotes from string literals or the caret `'^'` from identifiers. Its implementation needs to be registered as a service (cf. [Service Framework](302_configuration.html#dependency-injection)).

#### Extended Backus-Naur Form Expressions

Terminal rules are described using *Extended Backus-Naur Form*-like (EBNF) expressions. The different expressions are described in the following. Each of these expressions allows to define a cardinality. There are four different possible cardinalities:

1.  exactly one (the default, no operator)
1.  one or none (operator `?`)
1.  any (zero or more, operator `*`)
1.  one or more (operator `+`)

##### Keywords / Characters {#keywords}

Keywords are a kind of terminal rule literals. The *ID* rule in `org.eclipse.xtext.common.Terminals` for instance starts with a keyword:

`terminal ID : '^'? .... ;`

The question mark sets the cardinality to *none or one* (i.e. optional) like explained above.

Note that a keyword can have any length and contain arbitrary characters. 

The following standard Java notations for special characters are allowed: `\n`, `\r`, `\t`, `\b`, `\f` and the quoted unicode character notation, such as `\u123`.

##### Character Ranges

A character range can be declared using the `..` operator.

Example:

`terminal INT returns ecore::EInt: ('0'..'9')+;`

In this case an *INT* is comprised of one or more (note the `+` operator) characters between (and including) `'0'` and `'9'`.

##### Wildcard

If you want to allow any character you can simple write the wildcard operator `.` (dot): Example:

`terminal FOO : 'f' . 'o';`

The rule above would allow expressions like `foo`, `f0o` or even `f\_o`.

##### Until Token

With the until token it is possible to state that everything should be consumed until a certain token occurs. The multi-line comment is implemented this way:

`terminal ML_COMMENT  : '/*' -> '*/';`

This is the rule for Java-style comments that begin with `/*` and end with `*/`.

##### Negated Token {#negated-tokens}

All the tokens explained above can be inverted using a preceding exclamation mark:

`terminal BETWEEN_HASHES  : '#' (!'#')* '#';`

##### Rule Calls {#rule-calls}

Rules can refer to other rules. This is simply done by using the name of the rule to be called. We refer to this as rule calls. Rule calls in terminal rules can only point to terminal rules.

Example:

`terminal DOUBLE : INT '.' INT;`

**Note: It is generally not a good idea to implement floating point literals with terminal rules. You should use data type rules instead for the above mentioned reasons.**

##### Alternatives {#alternatives}

Alternatives allow to define multiple valid options in the input file. For instance, the white space rule uses alternatives like this:

`terminal WS : (' '|'\t'|'\r'|'\n')+;`

That is a WS can be made of one or more white space characters (including `' ', '\t', '\r', '\n'`).

##### Groups {#groups}

Finally, if you put tokens one after another, the whole sequence is referred to as a group. Example:

`terminal ASCII : '0x' ('0'..'7') ('0'..'9'|'A'..'F');`

That is the 2-digit hexadecimal code of ASCII characters.

#### Terminal Fragments {#terminal-fragment}

Since terminal rules are used in a stateless context, it's not easily possible to reuse parts of their definition. Fragments solve this problem. They allow the same EBNF elements as terminal rules do but may not be consumed by the lexer. Instead, they have to be used by other terminal rules. This allows to extract repeating parts of a definition:

```xtext
terminal fragment ESCAPED_CHAR : '\\' ('n'|'t'|'r'|'\\');
terminal STRING  : 
      '"' ( ESCAPED_CHAR | !('\\'|'"') )* '"' |
      "'" ( ESCAPED_CHAR | !('\\'|"'") )* "'"
;
```

#### EOF - End Of File {#eof}

The `EOF` (End Of File) token may be used to describe that the end of the input stream is a valid situation at a certain point in a terminal rule. This allows to consume the complete remaining input of a file starting with a special delimiter.

`terminal UNCLOSED_STRING : '"' (!'"')* EOF;`

The `EOF` token cannot be [negated](301_grammarlanguage.html#negated-tokens).

---

### Parser Rules {#parser-rules}

The parser is fed with a sequence of terminals and walks through the so called parser rules. Hence a parser rule - contrary to a terminal rule - does not produce a single atomic terminal token, but a tree of non-terminal and terminal tokens. They lead to a so called parse tree (in Xtext it is also referred as node model). Furthermore, parser rules are handled as kind of a building plan for the creation of the [EObjects]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EObject.java) that form the semantic model (the linked abstract syntax graph or AST). Due to this fact, parser rules are even called production or EObject rules. Different constructs like actions and assignments are used to derive types and initialize the semantic objects accordingly. 

#### Extended Backus-Naur Form Expressions

Not all the expressions that are available in terminal rules can be used in parser rules. Character ranges, wildcards, the until token and the negation as well as the EOF token are only available for terminal rules. 

The elements that are available in parser rules as well as in terminal rules are

1.  [Groups](301_grammarlanguage.html#groups), 
1.  [Alternatives](301_grammarlanguage.html#alternatives), 
1.  [Keywords](301_grammarlanguage.html#keywords) and 
1.  [Rule Calls](301_grammarlanguage.html#rule-calls).

In addition to these elements, there are some expressions used to direct how the AST is constructed. They are listed and explained in the following.

##### Assignments {#assignments}

Assignments are used to assign the consumed information to a feature of the currently produced object. The type of the current object, its [EClass]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java), is specified by the return type of the parser rule. If it is not explicitly stated it is implied that the type's name equals the rule's name. The type of the assigned feature is inferred from the right hand side of the assignment.

Example:

```xtext
State :
  'state' name=ID
    ('actions' '{' (actions+=[Command])+ '}')?
    (transitions+=Transition)*
  'end'
;
```

The syntactic declaration for states in the state machine example starts with a keyword `state` followed by an assignment:

`name=ID`

The left hand side refers to a feature *name* of the current object (which has the [EClass]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java) *State* in this case). The right hand side can be a rule call, a keyword, a [cross-reference](301_grammarlanguage.html#cross-references) or an alternative comprised by the former. The type of the feature needs to be compatible with the type of the expression on the right. As *ID* returns an *EString* in this case, the feature *name* needs to be of type [EString]({{site.javadoc.java}}/java/lang/String.html) as well.

**Assignment operators.** There are three different assignment operators, each with different semantics.

1.  The simple equal sign `=` is the straight forward assignment, and used for features which take only one element.
1.  The `+=` sign (the add operator) expects a multi-valued feature and adds the value on the right hand to that feature, which is a list feature.
1.  The `?=` sign (boolean assignment operator) expects a feature of type [EBoolean]({{site.javadoc.java}}/java/lang/Boolean.html) and sets it to true if the right hand side was consumed independently from the concrete value of the right hand side.

The used assignment operator does not influence the cardinality of the expected symbols on the right hand side. 

##### Cross-References {#cross-references}

A unique feature of Xtext is the ability to declare cross-links in the grammar. In traditional compiler construction the cross-links are not established during parsing but in a later linking phase. This is the same in Xtext, but we allow to specify cross-link information in the grammar. This information is used by the linker. The syntax for cross-links is:

```xtext
CrossReference :
  '[' type=TypeRef ('|' ^terminal=CrossReferenceableTerminal )? ']'
;
```

For example, the transition is made up of two cross-references, pointing to an event and a state:

```xtext
Transition :
  event=[Event] '=>' state=[State]
;
```

It is important to understand that the text between the square brackets does not refer to another rule, but to an [EClass]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java) - which is a type and not a parser rule! This is sometimes confusing, because one usually uses the same name for the rules and the returned types. That is if we had named the type for events differently like in the following the cross-reference needs to be adapted as well:

```xtext
Transition :
  event=[MyEvent] '=>' state=[State]
;
 
Event returns MyEvent : ....;
```

Looking at the syntax definition for cross-references, there is an optional part starting with a vertical bar (pipe) followed by *CrossReferenceableTerminal*. This is the part describing the concrete text, from which the cross-link later should be established. If the terminal is omitted, it is expected to be the rule with the name *ID* - if one can be found. The terminal is mandatory for languages that do not define a rule with the name *ID*.

Have a look at the [linking section](303_runtime_concepts.html#linking) in order to understand how linking is done.

##### Unordered Groups {#unordered-groups}

The elements of an unordered group can occur in any order but each element must appear once. Unordered groups are separated by `&`. The following rule `Modifier` allows to parse simplified modifiers of the Java language:

```xtext
Modifier: 
  static?='static'? & final?='final'? & visibility=Visibility;

enum Visibility:
  PUBLIC='public' | PRIVATE='private' | PROTECTED='protected';
```

Therefore, the following sequences of tokens are valid:

```java
public static final
static protected 
final private static
public
```

However, since no unordered groups are used in the rule `Modifier`, the parser refuses to accept this input lines:

```java
static final static // ERROR: static appears twice
public static final private // ERROR: visibility appears twice
final // ERROR: visibility is missing
```

Note that if you want an element of an unordered group to appear once or not at all, you have to choose a cardinality of `?`. In the example, the visibility is mandatory, while `static` or `final` are optional. Elements with a cardinality of `*` or `+` have to appear continuously without interruption, i.e.

```xtext
Rule:
  values+=INT* & name=ID;
```

will parse these lines

```java
0 8 15 x
x 0 8 15 
```

but not does not consume the following sequence without raising an error

```java
0 x 8 15 // wrong, as values may be interrupted by a name (ID)
```

##### Simple Actions

The object to be returned by a parser rule is usually created lazily on the first assignment. Its type is determined from the specified return type of the rule which may have been inferred from the rule's name if no explicit return type is specified.

With Actions however, the creation of returned [EObject]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EObject.java) can be made explicit. Xtext supports two kinds of Actions:

1.  *Simple* Actions, and
1.  *Assigned* Actions.

If you want to enforce the creation of an instance with specific type you can use simple actions. In the following example *TypeB* must be a subtype of *TypeA*. An expression *A ident* should create an instance of *TypeA*, whereas *B ident* should instantiate *TypeB*.

If you don't use actions, you'll have to define an alternative and delegate rules to guide the parser to the right types for the to-be-instantiated objects:

```xtext
MyRule returns TypeA :
  "A" name=ID |
  MyOtherRule
; 
 
MyOtherRule returns TypeB :
  "B" name = ID
;
```

Actions however allow to make this explicit. Thereby they can improve the readability of grammars. 

```xtext
MyRule returns TypeA :
  "A" name=ID |
  "B" {TypeB} name=ID
; 
```

Generally speaking, the instance is created as soon as the parser hits the first assignment. However, actions allow to explicitly instantiate any [EObject]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EObject.java). The notation *{TypeB}* will create an instance of TypeB and assign it to the result of the parser rule. This allows to define parser rules without any assignment and to create objects without the need to introduce unnecessary delegate rules.

**Note: If a parser rule does not instantiate any object because it does not contain an Action and no mandatory Assignment, you'll likely end up with unexpected situations for valid input files. Xtext detects this situation and will raise a warning for the parser rules in question.**

##### Unassigned Rule Calls

We previously explained that the [EObject]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EObject.java) to be returned is created lazily when the first assignment occurs or as soon as a simple action is evaluated. There is another way to *find* the [EObject]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EObject.java) to be returned. The concept is called *unassigned rule call*.

Unassigned rule calls (the name suggests it) are rule calls to other parser rules, which are not used within an assignment. The return value of the called rule becomes the return value of the calling parser rule if it is not assigned to a feature. 

With unassigned rule calls one can, for instance, create rules which just dispatch to other rules:

```xtext
AbstractToken :
  TokenA |
  TokenB |
  TokenC
;
```

As `AbstractToken` could possibly return an instance of *TokenA*, *TokenB* or *TokenC* its type must be a super type for all these types. Since the return value of the called rule becomes the result of the current rule, it is possible to further change the state of the AST element by assigning additional features.

Example:

```xtext
AbstractToken :
  ( TokenA |
    TokenB |
    TokenC ) (cardinality=('?'|'+'|'*'))?
;
```

This way the *cardinality* is optional (last question mark) and can be represented by a question mark, a plus, or an asterisk. It will be assigned to either an instance of type *TokenA*, *TokenB*, or *TokenC* which are all subtypes of *AbstractToken*. The rule in this example will never create an instance of *AbstractToken* directly but always return the instance that has been created by the invoked *TokenX* rule.

##### Assigned Actions {#grammar-actions}

Xtext leverages the powerful ANTLR parser which implements an `LL(*)` algorithm. Even though `LL` parsers have many advantages with respect to readability, debuggability and error recovery, there are also some drawbacks. The most important one is that it does not allow left recursive grammars. For instance, the following rule is not allowed in LL-based grammars, because `Expression '+' Expression` is left recursive:

```xtext
Expression :
  Expression '+' Expression |
  '(' Expression ')' |
  INT
;
```

Instead one has to rewrite such things by "left-factoring" it:

```xtext
Expression :
  TerminalExpression ('+' TerminalExpression)?
;
 
TerminalExpression :
  '(' Expression ')' |
  INT
;
```

In practice this is always the same pattern and therefore not too difficult. However, by simply applying the Xtext AST construction features we've covered so far, a grammar ...

```xtext
Expression :
  {Operation} left=TerminalExpression (op='+' right=TerminalExpression)?
;
 
TerminalExpression returns Expression:
  '(' Expression ')' |
  {IntLiteral} value=INT
;
```

... would result in unwanted elements in the AST. For instance the expression `(42)` would result in a tree like this:

```mwe2
Operation {
  left=Operation {
    left=IntLiteral {
      value=42
    }
  }
}
```

Typically one would only want to have one instance of *IntLiteral* instead.

This problem can be solved by using a combination of unassigned rule calls and assigned actions:

```xtext
Expression :
  TerminalExpression ({Operation.left=current} 
    op='+' right=Expression)?
;
 
TerminalExpression returns Expression:
  '(' Expression ')' |
  {IntLiteral} value=INT
;
```

In the example above `{Operation.left=current}` is a so called tree rewrite action, which creates a new instance of the stated [EClass]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java) *Operation* and assigns the element currently to-be-returned (the `current` variable) to a feature of the newly created object. The example uses the feature *left* of the *Operation* instance to store the previously returned *Expression*. In Java these semantics could be expressed as:

```java
Operation temp = new Operation();
temp.setLeft(current);
current = temp;
```

### Hidden Terminal Symbols {#hidden-terminals}

Because parser rules describe not a single token, but a sequence of patterns in the input, it is necessary to define the interesting parts of the input. Xtext introduces the concept of hidden tokens to handle semantically unimportant things like white spaces, comments, etc. in the input sequence gracefully. It is possible to define a set of terminal symbols that are hidden from the parser rules and automatically skipped when they are recognized. Nevertheless, they are transparently woven into the node model, but not relevant for the semantic model. 

Hidden terminals may optionally appear between any other terminals in any cardinality. They can be described per rule or for the whole grammar. When [reusing a single grammar](301_grammarlanguage.html#grammar-mixins) its definition of hidden tokens is reused, too. The grammar `org.eclipse.xtext.common.Terminals` comes with a reasonable default and hides all comments and white space from the parser rules.

If a rule defines hidden symbols, you can think of a kind of scope that is automatically introduced. Any rule that is called transitively by the declaring rule uses the same hidden terminals as the calling rule, unless it defines hidden tokens itself.

```xtext
Person hidden(WS, ML_COMMENT, SL_COMMENT): 
  name=Fullname age=INT ';'
;

Fullname: 
  (firstname=ID)? lastname=ID
;
```

The sample rule *Person* defines multiline comments (`ML_COMMENT`), single-line comments (`SL_COMMENT`), and white space (`WS`) to be allowed between the *name* and the *age*. Because the rule *Fullname* does not introduce an own set of hidden terminals, it allows the same symbols to appear between *firstname* and *lastname* as the calling rule *Person*. Thus, the following input is perfectly valid for the given grammar snippet:

```java
John /* comment */ Smith // line comment
/* comment */
      42      ; // line comment
```

A list of all default terminals like `WS` can be found in section [Grammar Mixins](301_grammarlanguage.html#grammar-mixins).

### Data Type Rules {#datatype-rules}

Data type rules are parsing-phase rules, which create instances of [EDataType]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EDataType.java) instead of [EClass]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java). Thinking about it, one may discover that they are quite similar to terminal rules. However, the nice thing about data type rules is that they are actually parser rules and are therefore 

1.  context sensitive and 
1.  allow for use of hidden tokens.

Assuming you want to define a rule to consume Java-like qualified names (e.g. "foo.bar.Baz") you could write:

```xtext
QualifiedName :
  ID ('.' ID)*
;
```

In contrast to a terminal rule this is only valid in certain contexts, i.e. it won't conflict with the rule *ID*. If you had defined it as a terminal rule, it would possibly hide the simple *ID* rule.

In addition, by defining the *QualifiedName* as a data type rule, it is allowed to use hidden tokens (e.g. `/* comment */` between the segment IDs and dots (e.g. `foo/* comment */. bar . Baz`).

Return types can be specified in the same way as for terminal rules:

```xtext
QualifiedName returns ecore::EString : 
  ID ('.' ID)*
;
```

Note that rules that do not call other parser rules and do neither contain any actions nor [assignments](301_grammarlanguage.html#assignments) are considered to be data type rules, and the data type [EString]({{site.javadoc.java}}/java/lang/String.html) is implied if none has been explicitly declared.

[Value converters](303_runtime_concepts.html#value-converter) are used to transform the parsed string to the actually returned data type value.

### Enum Rules

Enum rules return enumeration literals from strings. They can be seen as a shortcut for data type rules with specific value converters. The main advantage of enum rules is their simplicity, type safety and therefore nice validation. Furthermore it is possible to infer enums and their respective literals during the Ecore model transformation.

If you want to define a `ChangeKind` from [org.eclipse.emf.ecore.change/model/Change.ecore](http://download.eclipse.org/modeling/emf/emf/javadoc/2.6.0/org/eclipse/emf/ecore/change/package-summary.html) with *ADD*, *MOVE* and *REMOVE* you could write:

```xtext
enum ChangeKind :
  ADD | MOVE | REMOVE
;
```

It is even possible to use alternative literals for your enums or reference an enum value twice:

```xtext
enum ChangeKind :
  ADD = 'add' | ADD = '+' | 
  MOVE = 'move' | MOVE = '->' | 
  REMOVE = 'remove' | REMOVE = '-'
;
```

Please note that Ecore does not support unset values for enums. If you define a grammar like

`Element: "element" name=ID (value=SomeEnum)?;`

with the input of

`element Foo`

the resulting value of the element *Foo* will hold the enum value with the internal representation of `0` (zero). When generating the [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) from your grammar this will be the first literal you define. As a workaround you could introduce a dedicated none-value or order the enums accordingly. Note that it is not possible to define an enum literal with an empty textual representation.

```xtext
enum Visibility: 
  package | private | protected | public
;
```

You can overcome this by using an explicitly imported metamodel.

### Syntactic Predicates {#syntactic-predicates}

It's sometimes not easily possible to define an `LL(*)` grammar for a given language that parses all possible valid input files and still produces abstract syntax graphs that mimic the actual structure of the files. There are even cases that cannot be described with an unambiguous grammar. There are solutions that allow to deal with this problem:

*   Enable Backtracking: Xtext allows to enable backtracking for the ANTLR parser generator. This is usually not recommended since it influences error message strategies at runtime and shadows actually existing problems in the grammar.
*   Syntactic Predicates: The grammar language enables users to guide the parser in case of ambiguities. This mechanism is achieved by syntactic predicates. Since they affect only a very small part of the grammar, syntactic predicates are the recommended approach to handle ANTLR error messages during the parser generation.

The classical example for ambiguous language parts is the *dangling else problem*. A conditional in a programming language usually looks like this:

```java
if (isTrue()) 
  doStuff(); 
else 
  dontDoStuff(); 
```

The problems becomes more obvious as soon as nested conditions are used:

```java
if (isTrue())
  if (isTrueAsWell())  
    doStuff(); 
  else 
    dontDoStuff(); 
```

Where does the `else` branch belong to? This question can be answered by a quick look into the language specification which tells that the `else` branch is part of the inner condition. However, the parser generator cannot be convinced that easily. We have to guide it to this decision point by means of syntactic predicates which are expressed by a leading `=>` operator.

```xtext
Condition: 
  'if' '(' condition=BooleanExpression ')' 
    then=Expression 
    (=>'else' else=Expression)?
```

The parser understands the predicate basically like this: If you are at this particular decision point and you don't know what to do, check whether the `else` keyword is present. Don't try to choose the other option that would start with an `else` keyword, too.

Well chosen predicates allow to solve most ambiguities and backtracking can often be disabled.

#### First Token Set Predicates

Sometimes you need to put a syntactic predicate on a more complex rule, e.g. an expression, which might be very long. For disambiguation it is often sufficient to look only at the first token set. In those cases one can use the `->` operator instead of `=>` which tells the parser to just look at the first token and make the decision based on that. This can heavily reduce the lookahead and as a consequence make the parser faster and more robust to syntactic errors. This also affects the behavior of the IDE, such as content assist, in a positive way.

---

## Ecore Model Inference {#metamodel-inference}

The Ecore model (or meta model) of a textual language describes the structure of its abstract syntax trees (AST). 

Xtext uses Ecore's [EPackages]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) to define Ecore models. Ecore models are declared to be either inferred (generated) from the grammar or imported. By using the `generate` directive, one tells Xtext to derive an [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) from the grammar. 

### Type and Package Generation

Xtext creates

*   an [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java)    
    *   for each generate-package declaration. After the directive `generate` a list of parameters follows. The *name* of the [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) will be set to the first parameter, its *nsURI* to the second parameter. An optional alias as the third parameter allows to distinguish generated [EPackages]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) later. Only one generated package declaration per alias is allowed.
*   an [EClass]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java)    
    *   for each return type of a parser rule. If a parser rule does not define a return type, an implicit one with the same name as the rule itself is assumed. You can specify more than one rule that return the same type but only one [EClass]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java) will be generated.
    *   for each type defined in an action or a cross-reference.
*   an [EEnum]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EEnum.java)    
    *   for each return type of an enum rule.
*   an [EDataType]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EDataType.java)    
    *   for each return type of a terminal rule or a data type rule.

All [EClasses]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java), [EEnums]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EEnum.java), and [EDataTypes]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EDataType.java) are added to the [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) referred to by the alias provided in the type reference they were created from.

### Feature and Type Hierarchy Generation

While walking through the grammar, the algorithm keeps track of a set of the currently possible return types to add features to. 

*   Entering a parser rule the set contains only the return type of the rule. 
*   Entering an element of an alternative the set is reset to the same state it was in when entering the first option of the alternative. 
*   Leaving an alternative the set contains the union of all types at the end of each of its paths.
*   After an optional element, the set is reset to the same state it was before entering it. 
*   After a mandatory (non-optional) rule call or mandatory action the set contains only the return type of the called rule or action.
*   An optional rule call does not modify the set.
*   A rule call is optional, if its cardinality is `?` or `*`.

While iterating the parser rules Xtext creates 

*   an [EAttribute]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EAttribute.java) in each current return type     
    
    *   of type [EBoolean]({{site.javadoc.java}}/java/lang/Boolean.html) for each feature assignment using the `?=` operator. No further [EReferences]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EReference.java) or [EAttributes]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EAttribute.java) will be generated from this assignment.
    *   for each assignment with the `=` or `+=` operator calling a terminal rule. Its type will be the return type of the called rule.

*   an [EReference]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EReference.java) in each current return type     
    
    *   for each assignment with the `=` or `+=` operator in a parser rule calling a parser rule. The [EReference's]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EReference.java) type will be the return type of the called parser rule.
    *   for each assigned action. The reference's type will be set to the return type of the current calling rule. 

Each [EAttribute]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EAttribute.java) or [EReference]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EReference.java) takes its name from the assignment or action that caused it. Multiplicities will be `0..1` for assignments with the `=` operator and `0..*` for assignments with the `+=` operator. 

Furthermore, each type that is added to the currently possible return types automatically extends the current return type of the parser rule. You can specify additional common super types by means of "artificial" parser rules that are never called, e.g.

```xtext
CommonSuperType:
  SubTypeA | SubTypeB | SubTypeC;
```

### Enum Literal Generation

For each alternative defined in an enum rule, the transformer creates an enum literal, as long as no other literal with the same name can be found. The *literal* property of the generated enum literal is set to the right hand side of the declaration. If it is omitted, an enum literal with equal *name* and *literal* attributes is inferred.

```xtext
enum MyGeneratedEnum:
  NAME = 'literal' | EQUAL_NAME_AND_LITERAL;
```

### Feature Normalization

In the next step the generator examines all generated [EClasses]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java) and lifts up similar features to super types if there is more than one subtype and the feature is defined in every subtypes. This does even work for multiple super types.

### Error Conditions

The following conditions cause an error 

*   An [EAttribute]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EAttribute.java) or [EReference]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EReference.java) has two different types or different cardinality.
*   There is an [EAttribute]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EAttribute.java) and an [EReference]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EReference.java) with the same name in the same [EClass]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java).
*   There is a cycle in the type hierarchy.
*   An new [EAttribute]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EAttribute.java), [EReference]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EReference.java) or super type is added to an imported type.
*   An [EClass]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java) is added to an imported [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java).
*   An undeclared alias is used. 
*   An imported Ecore model cannot be loaded.

---

## Grammar Mixins {#grammar-mixins}

Xtext supports the reuse of existing grammars. Grammars that are created via the Xtext wizard use `org.eclipse.xtext.common.Terminals` by default which introduces a common set of terminal rules and defines reasonable defaults for hidden terminals.

To reuse an existing grammar, make sure the grammar file is on the class path of the inheriting language. If it is in a different plug-in, make sure to add a plug-in dependency in the `MANIFEST.MF`. 

```xtext
grammar org.xtext.example.SecretCompartments 
   with org.eclipse.xtext.common.Terminals

generate secrets "http://www.eclipse.org/secretcompartment"
 
Statemachine: ..
```

Mixing another grammar into a language makes the rules defined in that grammar referable. It is also possible to overwrite rules from the used grammar. 

Example:

```xtext
grammar my.SuperGrammar

generate super "http://my.org/super"

...
RuleA : "a" stuff=RuleB;
RuleB : "{" name=ID "}";

grammar my.SubGrammar with my.SuperGrammar

import "http://my.org/super"

 ...

Model : (ruleAs+=RuleA)*;

// overrides my.SuperGrammar.RuleB
RuleB : '[' name=ID ']';
```

**Note that declared terminal rules always get a higher priority then imported terminal rules.**

In addition, you have to register the Ecore models used in your super grammar and their corresponding generator models to the MWE2 workflow of the inheriting language, e.g.

```mwe2
Workflow {
    bean = StandaloneSetup {
        scanClassPath = true
        platformUri = "${runtimeProject}/.."
        ...
        // add the FQN of the generated EPackage
        registerGeneratedEPackage = "my.supergrammar.super.SuperPackage" 
        // add the platfrom resource URI of the corresponding Ecore genmodel
        registerGenModelFile = "platform:/resource/my/src-gen/my/supergrammar/super/Super.genmodel"
    }
//...
```

You might also want to read about [EPackage imports](301_grammarlanguage.html#epackage-import) for the inheriting grammar.

## Common Terminals

Xtext ships with a default set of predefined, reasonable and often required terminal rules. The grammar for these common terminal rules is defined as follows:

```xtext
 grammar org.eclipse.xtext.common.Terminals 
  hidden(WS, ML_COMMENT, SL_COMMENT)

import "http://www.eclipse.org/emf/2002/Ecore" as ecore

terminal ID : 
  '^'?('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
terminal INT returns ecore::EInt: 
  ('0'..'9')+;
terminal STRING  : 
  '"' ( '\\'('b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\') | !('\\'|'"') )* '"' |
  "'" ( '\\'('b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\') | !('\\'|"'") )* "'"; 
terminal ML_COMMENT  : 
  '/*' -> '*/';
terminal SL_COMMENT : 
  '//' !('\n'|'\r')* ('\r'? '\n')?;

terminal WS  : 
  (' '|'\t'|'\r'|'\n')+;

terminal ANY_OTHER: 
  .;
```

---

**[Next Chapter: Configuration](302_configuration.html)**