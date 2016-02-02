---
layout: documentation
title: The Grammar Language
part: Reference Documentation
---

# {{page.title}} {#grammarLanguage}

The [grammar language]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/Xtext.xtext) is the corner stone of Xtext. It is a domain-specific language, carefully designed for the description of textual languages. The main idea is to describe the concrete syntax and how it is mapped to an in-memory representation &ndash; the semantic model. This model will be produced by the parser on-the-fly when it consumes an input file. Of course the Xtext grammar language itself is implemented with Xtext, so you will find parts of its syntax described with its own means in this documentation.

An example grammar is shown in the [15 Minutes Tutorial](102_domainmodelwalkthrough.html#write-your-own-grammar).

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

Xtext parsers create in-memory object graphs while consuming text. Such object-graphs are instances of [EMF](https://www.eclipse.org/modeling/emf/) Ecore models. An Ecore model basically consists of an EPackage containing EClasses, EDataTypes and EEnums (see the [section on EMF](308_emf_integration.html#model-metamodel) for more details) and describes the structure of the instantiated objects. Xtext can infer Ecore models from a grammar (see [Ecore model inference](301_grammarlanguage.html#metamodel-inference)) but it is also possible to import existing Ecore models. You can even mix both approaches and use multiple existing Ecore models and infer some others from a single grammar. This allows for easy reuse of existing abstractions while still having the advantage of short turnarounds with derived Ecore models. 

#### EPackage Generation

The easiest way to get started is to let Xtext infer the Ecore model from your grammar. The `generate` declaration in the grammar advises the framework to do so:

```xtext
generate domainmodel "http://www.example.org/domainmodel/Domainmodel"
```

That statement could actually be read as: generate an [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) with the *name* `domainmodel` and the *nsURI* `"http://www.example.org/domainmodel/Domainmodel"`. Xtext will then add [EClasses]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java) with [EAttributes]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EAttribute.java) and [EReferences]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EReference.java) for the different parser rules in your grammar, as described in [Ecore model inference](301_grammarlanguage.html#metamodel-inference). 

#### EPackage Import {#epackage-import}

If you already have an existing EPackage, you can import it using its namespace URI:

```xtext
import "http://www.xtext.org/example/Domainmodel"
```

A [URI](http://www.ietf.org/rfc/rfc2396.txt) (Uniform Resource Identifier) provides a simple and extensible means for identifying an abstract or physical resource. It is also possible to import EPackages using resource URIs, but it is strongly recommended to use the namespace URI instead because it is independent from the concrete location in the file system, much more portable across different machines, easier to configure in the workflow, and works better with language mixins. The import via platform URIs or file URIs can be considered deprecated and is only supported for backwards compatibility.

#### Ecore Model Aliases for EPackages

If you want to use multiple EPackages you need to specify aliases in the following way:

```xtext
import "http://www.xtext.org/example/Domainmodel" as dmodel
import 'http://www.eclipse.org/anotherPackage' as another
```

When referring to a type somewhere in the grammar you need to qualify the reference using that alias (e.g. `another::SomeType`). Cases where such type references occur are explained below.

It is also supported to put multiple EPackage imports into one alias. This is no problem as long as there are not any two [EClassifiers]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClassifier.java) with the same name. In that case none of them can be referenced. It is even possible to `import` multiple and `generate` one Ecore model and declare all of them with same alias. If you do so, for a reference to an [EClassifier]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClassifier.java) first the imported [EPackages]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java) are scanned before it is assumed that a type needs to be generated into the inferred package. 

Note that using the same alias for multiple EPackages is not recommended, because it might cause problems that are hard to track down. For instance, a reference to `classA` could mistakenly be linked to a newly created EClass instead of an existing EClass `ClassA` because the latter is written with a capital letter.

### Terminal Rules {#terminal-rules}

Basically parsing can be separated in the following phases. 

1.  Lexing
1.  Parsing
1.  Linking
1.  Validation

In the first stage called *lexing*, a sequence of characters (the text input) is transformed into a sequence of so-called *tokens*. In this context, a token is sort of a strongly typed part or region of the input sequence. It consists of one or more characters and is matched by a particular terminal rule or keyword and therefore represents an atomic symbol. Terminal rules are also referred to as *token rules* or *lexer rules*. There is an informal naming convention that names of terminal rules are all upper-case.

In the [entities example](102_domainmodelwalkthrough.html) there are no explicitly defined terminal rules, since it only uses the *ID* rule which is inherited from the grammar `org.eclipse.xtext.common.Terminals` (see [Common Terminals](#common-terminals)). Therein the *ID* rule is defined as follows:

```xtext
terminal ID: 
    ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*; 
```

It says that a token *ID* starts with an optional `'^'` character (caret), followed by a letter `('a'..'z'|'A'..'Z')` or underscore `'_'` followed by any number of letters, underscores and numbers `('0'..'9')`. 

The caret is used to escape an identifier if there are conflicts with existing keywords. It is removed by the *ID* rule's [ValueConverter](303_runtime_concepts.html#value-converter). 

This is the simplified formal definition of terminal rules:

```xtext
TerminalRule:
    'terminal' name=ID ('returns' type=TypeRef)? ':' 
    alternatives=TerminalAlternatives ';';
```

Note that *the order of terminal rules is crucial for your grammar*, as they may shadow each other. This is especially important for newly introduced rules in connection with imported rules from used grammars. 

It's almost in any case recommended to use [data type rules](#datatype-rules) instead. Let's assume you want to add a rule to allow fully qualified names in addition to simple IDs. Since a qualified name with only one segment looks like a plain ID, you should implement it as a data type rule instead of adding another terminal rule. The same rule of thumb applies to floating point literals, too.

#### Return Types

Each terminal rule returns an atomic value (an [EDataType]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EDataType.java)). By default, it's assumed that an instance of `ecore::EString`) should be returned. However, if you want to provide a different type you can specify it. For instance, the rule *INT* is defined as:

```xtext
terminal INT returns ecore::EInt: 
    ('0'..'9')+;
```

This means that the terminal rule *INT* returns instances of `ecore::EInt`. It is possible to define any kind of data type here, which just needs to be an instance of `ecore::EDataType`. In order to tell the framework how to convert the parsed string to a value of the declared data type, you need to provide your own implementation of [IValueConverterService]({{site.src.xtext}}/plugins/org.eclipse.xtext/src/org/eclipse/xtext/conversion/IValueConverterService.java) (see [Value Converters](303_runtime_concepts.html#value-converter)). The value converter is also the service that allows to remove escape sequences or semantically unnecessary characters such as quotes from string literals or the caret `'^'` from identifiers.

#### Extended Backus-Naur Form Expressions

Terminal rules are described using *Extended Backus-Naur Form*-like (EBNF) expressions. The different expressions are described in the following. Each of these expressions allows to define a cardinality. There are four different possible cardinalities:

1.  exactly one (the default, no operator)
1.  zero or one (operator `?`)
1.  zero or more (operator `*`)
1.  one or more (operator `+`)

##### Keywords / Characters {#keywords}

Keywords are a kind of terminal rule literals. The *ID* rule in `org.eclipse.xtext.common.Terminals` for instance starts with a keyword:

```xtext
terminal ID:
    '^'? ... ;
```

The question mark sets the cardinality to *zero or one* (i.e. optional) as explained above.

A keyword can have any length, e.g. `'entity'`, and contain arbitrary characters. The following standard Java notations for special characters are allowed: `\n`, `\r`, `\t`, `\b`, `\f` and the quoted unicode character notation, such as `\u123`.

##### Character Ranges

A character range can be declared using the `..` operator. Example:

```xtext
terminal INT returns ecore::EInt:
    ('0'..'9')+;
```

In this case an *INT* is comprised of one or more (note the `+` operator) characters between (and including) `'0'` and `'9'`.

##### Wildcard

If you want to allow any character you can simply write the wildcard operator `.` (dot). Example:

```xtext
terminal FOO:
    'f' . 'o';
```

The rule above would allow expressions like `foo`, `f0o` or even `f°o`.

##### Until Token

With the *until token* it is possible to state that everything should be consumed until a certain token occurs. The multi-line comment is implemented this way:

```xtext
terminal ML_COMMENT:
    '/*' -> '*/';
```

This is the rule for Java-style comments that begin with `/*` and end with `*/`.

##### Negated Token {#negated-tokens}

All the tokens explained above can be inverted using a preceding exclamation mark:

```xtext
terminal BETWEEN_HASHES:
    '#' (!'#')* '#';
```

##### Rule Calls {#rule-calls}

Rules can refer to other rules. This is simply done by using the name of the rule to be called. We refer to this as *rule calls*. Rule calls in terminal rules can only point to terminal rules. Example:

```xtext
terminal DOUBLE:
    INT '.' INT;
```

Note: It is generally not a good idea to implement floating point literals with terminal rules. You should use data type rules instead due to possible shadowing problems explained above.

##### Alternatives {#alternatives}

Alternatives allow to define multiple valid options in the input file. For instance, the white space rule uses alternatives like this:

```xtext
terminal WS:
    (' '|'\t'|'\r'|'\n')+;
```

That is a WS can be made of one or more white space characters (including `' ', '\t', '\r', '\n'`).

##### Groups {#groups}

Finally, if you put tokens one after another, the whole sequence is referred to as a group. Example:

```xtext
terminal ASCII:
    '0x' ('0'..'7') ('0'..'9'|'A'..'F');
```

This group has three elements `'0x'`, `('0'..'7')`, and `('0'..'9'|'A'..'F')`, which have to appear in this order.

#### Terminal Fragments {#terminal-fragment}

Since terminal rules are used in a stateless context, it's not easily possible to reuse parts of their definition. Fragments solve this problem. They allow the same EBNF elements as terminal rules do but may not be consumed by the lexer. Instead, they have to be used by other terminal rules. This allows to extract repeating parts of a definition:

```xtext
terminal fragment ESCAPED_CHAR:
    '\\' ('n'|'t'|'r'|'\\');
terminal STRING: 
    '"' ( ESCAPED_CHAR | !('\\'|'"') )* '"' |
    "'" ( ESCAPED_CHAR | !('\\'|"'") )* "'";
```

#### EOF &ndash; End Of File {#eof}

The `EOF` (End Of File) token may be used to describe that the end of the input stream is a valid situation at a certain point in a terminal rule. This allows to consume the complete remaining input of a file starting with a special delimiter.

`terminal UNCLOSED_STRING : '"' (!'"')* EOF;`

The `EOF` token cannot be [negated](301_grammarlanguage.html#negated-tokens).

### Parser Rules {#parser-rules}

The parser is fed with a sequence of terminals and walks through the so-called *parser rules*. Hence a parser rule &ndash; contrary to a terminal rule &ndash; does not produce a single atomic terminal token, but a tree of non-terminal and terminal tokens. They lead to a so-called *parse tree* (in Xtext it is also referred as *node model*). Furthermore, parser rules are handled as kind of a building plan for the creation of the [EObjects]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EObject.java) that form the semantic model (the linked *abstract syntax tree* or AST). Due to this fact, parser rules are also called production or EObject rules. Different constructs like actions and assignments are used to derive types and initialize the semantic objects accordingly. 

#### Extended Backus-Naur Form Expressions

Not all the expressions that are available in terminal rules can be used in parser rules. Character ranges, wildcards, the until token and the negation as well as the EOF token are only available for terminal rules. 

The elements that are available in parser rules as well as in terminal rules are

1.  [Groups](301_grammarlanguage.html#groups), 
1.  [Alternatives](301_grammarlanguage.html#alternatives), 
1.  [Keywords](301_grammarlanguage.html#keywords), and 
1.  [Rule Calls](301_grammarlanguage.html#rule-calls).

In addition to these elements, there are some expressions used to direct how the AST is constructed. They are listed and explained in the following.

##### Assignments {#assignments}

Assignments are used to assign the consumed information to a feature of the currently produced object. The type of the current object, its [EClass]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java), is specified by the return type of the parser rule. If it is not explicitly stated it is implied that the type's name equals the rule's name. The type of the assigned feature is inferred from the right hand side of the assignment.

Example:

```xtext
DataType:
    'datatype' name = ID;
```

The syntactic declaration for datatypes starts with a keyword `datatype` followed by an assignment: `name = ID`. The left hand side refers to a feature *name* of the current object (which has the EClass *State* in this case). The right hand side can be a rule call, a keyword, a [cross-reference](301_grammarlanguage.html#cross-references) or an alternative comprised by the former options. The type of the feature needs to be compatible with the type of the expression on the right. As *ID* returns an [EString]({{site.javadoc.java}}/java/lang/String.html) in this case, the feature *name* needs to be of type EString as well.

There are three different assignment operators, each with different semantics.

1.  The simple equal sign `=` is the straightforward assignment, and is used for features which take only one element.
1.  The `+=` sign (the add operator) expects a multi-valued feature and adds the value on the right hand side to that feature, which is a list feature.
1.  The `?=` sign (boolean assignment operator) expects a feature of type [EBoolean]({{site.javadoc.java}}/java/lang/Boolean.html) and sets it to true if the right hand side was consumed, independently from the concrete value of the right hand side.

The used assignment operator does not influence the cardinality of the expected symbols on the right hand side. 

##### Cross-References {#cross-references}

A unique feature of Xtext is the ability to declare cross-links in the grammar. In traditional compiler construction the cross-links are not established during parsing but in a later linking phase. This is the same in Xtext, but we allow to specify cross-link information in the grammar. This information is used by the [linker](303_runtime_concepts.html#linking).

The syntax for cross-links is:

```xtext
CrossReference:
    '[' type=TypeRef ('|' ^terminal=CrossReferenceableTerminal )? ']';
```

For example, Features in the [entities example](102_domainmodelwalkthrough.html) contain a cross-reference pointing to a Type:

```xtext
Feature:
    (many ?= 'many')? name = ID ':' type = [Type];
```

It is important to understand that the text between the square brackets does not refer to another rule, but to an [EClass]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java) &ndash; which is a type and not a parser rule. This can be sometimes confusing because one usually uses the same name for the rules and the returned types.

Looking at the syntax definition for cross-references, there is an optional part starting with a vertical bar (pipe) followed by *CrossReferenceableTerminal*. This is the part describing the concrete text from which the cross-link should be established. If the terminal is omitted, it is expected to be the rule with the name *ID* &ndash; if one can be found. The terminal is mandatory for languages that do not define a rule with the name *ID*.

##### Unordered Groups {#unordered-groups}

The elements of an unordered group can occur in any order, but each element must appear once. Members of unordered groups are separated by `&`. The following rule `Modifier` allows to parse simplified modifiers of the Java language:

```xtext
Modifier: 
    static?='static'? & final?='final'? & visibility=Visibility;

enum Visibility:
    PUBLIC='public' | PRIVATE='private' | PROTECTED='protected';
```

With these definitions the following sequences of tokens are valid:

```java
public static final
static protected 
final private static
public
```

In contrast, the parser refuses to accept these input lines:

```java
static final static // ERROR: static appears twice
public static final private // ERROR: visibility appears twice
final // ERROR: visibility is missing
```

Note that if you want an element of an unordered group to appear once or not at all, you have to choose a cardinality of `?`. In the example, the visibility is mandatory, while `static` or `final` are optional. Elements with a cardinality of `*` or `+` have to appear continuously without interruption, i.e.

```xtext
ExampleRule:
    values+=INT* & name=ID;
```

can parse these lines

```java
0 8 15 x
x 0 8 15 
```

but not does not consume the following sequence without raising an error

```java
0 x 8 15 // wrong, as values must not be interrupted by a name (ID)
```

##### Simple Actions

The object to be returned by a parser rule is usually created lazily on the first assignment. Its type is determined from the specified return type of the rule, which may have been inferred from the rule's name if no explicit return type is specified.

With Actions however, the creation of returned [EObject]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EObject.java) can be made explicit. Xtext supports two kinds of Actions:

1. *Simple* Actions, and
1. *Assigned* Actions.

If you want to enforce the creation of an instance with specific type you can use simple actions. In the following example *TypeB* must be a subtype of *TypeA*. An expression `A ident` should create an instance of *TypeA*, whereas `B ident` should instantiate *TypeB*.

If you don't use actions, you'll have to define an alternative and delegate rules to guide the parser to the right types for the to-be-instantiated objects:

```xtext
MyRule returns TypeA:
    "A" name=ID |
    MyOtherRule; 
 
MyOtherRule returns TypeB:
    "B" name = ID;
```

Actions however allow to make this explicit. Thereby they can improve the readability of grammars. 

```xtext
MyRule returns TypeA:
    "A" name=ID |
    "B" {TypeB} name=ID; 
```

Generally speaking, the instance is created as soon as the parser hits the first assignment. However, actions allow to explicitly instantiate any [EObject]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EObject.java). The notation `{TypeB}` will create an instance of *TypeB* and assign it to the result of the parser rule. This allows to define parser rules without any assignment and to create objects without the need to introduce unnecessary delegate rules.

Note: If a parser rule does not instantiate any object because it does not contain an Action and no mandatory Assignment, you'll likely end up with unexpected situations for valid input files. Xtext detects this situation and will raise a warning for the parser rules in question.

##### Unassigned Rule Calls

We previously explained that the [EObject]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EObject.java) to be returned is created lazily when the first assignment occurs or as soon as a simple action is evaluated. There is another concept to find the EObject to be returned, called *unassigned rule call*. Unassigned rule calls, as the name suggests it, are rule calls to other parser rules which are not used within an assignment. The return value of the called rule becomes the return value of the calling parser rule if it is not assigned to a feature.

With unassigned rule calls one can, for instance, create rules which just dispatch to other rules:

```xtext
AbstractToken:
    TokenA |
    TokenB |
    TokenC;
```

As `AbstractToken` could possibly return an instance of *TokenA*, *TokenB* or *TokenC* its type must be a super type for all these types. Since the return value of the called rule becomes the result of the current rule, it is possible to further change the state of the AST element by assigning additional features.

Example:

```xtext
AbstractToken:
    ( TokenA |
      TokenB |
      TokenC ) cardinality=('?'|'+'|'*')?;
```

This way the *cardinality* is optional (last question mark) and can be represented by a question mark, a plus, or an asterisk. It will be assigned to either an instance of type *TokenA*, *TokenB*, or *TokenC*, which are all subtypes of *AbstractToken*. The rule in this example will never create an instance of *AbstractToken* directly, but always return the instance that has been created by the invoked *TokenX* rule.

##### Assigned Actions {#grammar-actions}

Xtext leverages the powerful ANTLR parser which implements an `LL(*)` algorithm. Even though LL parsers have many advantages with respect to readability, debuggability and error recovery, there are also some drawbacks. The most important one is that it does not allow left recursive grammars. For instance, the following rule is not allowed in LL-based grammars, because `Expression '+' Expression` is left-recursive:

```xtext
Expression:
    Expression '+' Expression |
    '(' Expression ')' |
    INT;
```

Instead one has to rewrite such left-recursive rules by "left-factoring" them:

```xtext
Expression:
    TerminalExpression ('+' TerminalExpression)?;
 
TerminalExpression:
    '(' Expression ')' |
    INT;
```

In practice this is always the same pattern and therefore not too difficult. However, by simply applying the Xtext AST construction features we've covered so far, a grammar such as

```xtext
Expression:
    {Operation} left=TerminalExpression (op='+' right=TerminalExpression)?;
 
TerminalExpression returns Expression:
    '(' Expression ')' |
    {IntLiteral} value=INT;
```

would result in unwanted elements in the AST. For instance the expression `(42)` would result in a tree like this:

```mwe2
Operation {
  left=Operation {
    left=IntLiteral {
      value=42
    }
  }
}
```

Typically one would only want to have one instance of *IntLiteral* instead. This problem can be solved by using a combination of unassigned rule calls and assigned actions:

```xtext
Expression:
    TerminalExpression ({Operation.left=current} 
    op='+' right=Expression)?;
 
TerminalExpression returns Expression:
    '(' Expression ')' |
    {IntLiteral} value=INT;
```

In the example above `{Operation.left=current}` is a so-called *tree rewrite action*, which creates a new instance of the stated [EClass]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java) *Operation* and assigns the element currently to-be-returned (the `current` variable) to a feature of the newly created object. The example uses the feature *left* of the *Operation* instance to store the previously returned *Expression*. In Java these semantics could be expressed as:

```java
Operation temp = new Operation();
temp.setLeft(current);
current = temp;
```

With these improved rules the expression `(42)` would lead to a single *IntLiteral* instance, while `40 + 2` creates an *Operation* with two *IntLiterals*.

#### Syntactic Predicates {#syntactic-predicates}

It is sometimes not easily possible to define an `LL(*)` grammar for a given language that parses all possible valid input files and still produces abstract syntax graphs that mimic the actual structure of the files. There are even cases that cannot be described with an unambiguous grammar. There are solutions that allow to deal with this problem:

* Enable backtracking: Xtext allows to enable backtracking for the ANTLR parser generator. This is usually not recommended since it influences error message strategies at runtime and shadows actually existing problems in the grammar.
* Syntactic predicates: The grammar language allows to guide the parser in case of ambiguities. This mechanism is achieved by *syntactic predicates*. Since they affect only a very small part of the grammar, syntactic predicates are the recommended approach to handle ANTLR error messages during the parser generation.

The classical example for ambiguous language parts is the *dangling else problem*. A conditional in a programming language usually looks like this:

```java
if (isTrue()) 
    doStuff(); 
else 
    dontDoStuff(); 
```

The problems becomes obvious as soon as nested conditions are used:

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

The parser understands the predicate basically like this: If you are at this particular decision point and you don't know what to do, check whether the `else` keyword is present. If it is, take that branch directly without considering other options that would match the same token sequence.

Well chosen predicates allow to solve most ambiguities and backtracking can often be disabled. Be warned, though, that an ambiguity for the parser can also mean an ambiguity for the user, so before forcing the syntax into handling such cases you should consider avoiding them in the first place.

##### First Token Set Predicates

Sometimes you need to put a syntactic predicate on a more complex rule, e.g. an expression, which might be very long. For disambiguation it is often sufficient to look only at the first token set. In those cases one can use the `->` operator instead of `=>`, instructing the parser to just look at the first token and make the decision based on that. This can heavily reduce the lookahead and as a consequence make the parser faster and more robust to syntactic errors. This also affects the behavior of the IDE, such as content assist, in a positive way.

### Hidden Terminal Symbols {#hidden-terminals}

Because parser rules describe not a single token, but a sequence of patterns in the input, it is necessary to define the important parts of the input. Xtext introduces the concept of hidden tokens to handle semantically irrelevant things like white spaces, comments, etc. in the input sequence gracefully. It is possible to define a set of terminal symbols that are hidden from the parser rules and automatically skipped when they are recognized. Nevertheless, they are transparently woven into the node model, but not relevant for the semantic model. 

Hidden terminals may optionally appear between any other terminals in any cardinality. They can be described per rule or for the whole grammar. When [reusing a single grammar](301_grammarlanguage.html#grammar-mixins) its definition of hidden tokens is reused, too. The grammar `org.eclipse.xtext.common.Terminals` comes with a reasonable default and hides all comments and white space from the parser rules.

If a rule defines hidden symbols, you can think of a kind of scope that is automatically introduced. Any rule that is called transitively by the declaring rule uses the same hidden terminals as the calling rule, unless it defines hidden tokens itself.

```xtext
Person hidden(WS, ML_COMMENT, SL_COMMENT):
    name=Fullname age=INT ';';

Fullname:
    (firstname=ID)? lastname=ID;
```

The sample rule *Person* defines multiline comments (`ML_COMMENT`), single-line comments (`SL_COMMENT`), and white space (`WS`) to be allowed between the *name* and the *age*. Because the rule *Fullname* does not introduce an own set of hidden terminals, it allows the same symbols to appear between *firstname* and *lastname* as the calling rule *Person*. Thus, the following input is perfectly valid for the given grammar snippet:

```java
John /* comment */ Smith // line comment
/* comment */
      42      ; // line comment
```

A list of all default terminals such as `WS` can be found in [Common Terminals](#common-terminals).

### Data Type Rules {#datatype-rules}

Data type rules create instances of [EDataType]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EDataType.java) instead of [EClass]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java). They are quite similar to terminal rules, but they are actually parser rules and are therefore

1. context sensitive and
1. allow for use of hidden tokens.

Assuming you want to define a rule to consume Java-like qualified names (e.g. `foo.bar.Baz`) you could write:

```xtext
QualifiedName:
    ID ('.' ID)*;
```

In contrast to a terminal rule this is only valid in certain contexts, i.e. it won't conflict with the rule *ID*. If you had defined it as a terminal rule, it would possibly hide the simple *ID* rule.

In addition, by defining the *QualifiedName* as a data type rule, it is allowed to use hidden tokens such as `/* comment */` between the segment IDs and dots (e.g. `foo/* comment */. bar . Baz`).

Return types can be specified in the same way as for terminal rules:

```xtext
QualifiedName returns ecore::EString: 
    ID ('.' ID)*;
```

Note that rules that do not call other parser rules and do neither contain any actions nor [assignments](301_grammarlanguage.html#assignments) are considered to be data type rules, and the data type [EString]({{site.javadoc.java}}/java/lang/String.html) is implied if none has been explicitly declared.

[Value converters](303_runtime_concepts.html#value-converter) are used to transform the parsed string to the actually returned data type value.

### Enum Rules

Enum rules return enumeration literals from strings. They can be seen as a shortcut for data type rules with specific value converters. The main advantage of enum rules is their simplicity, type safety and therefore nice validation. Furthermore it is possible to infer enums and their respective literals during the Ecore model transformation.

If you want to define a `ChangeKind` from [org.eclipse.emf.ecore.change/model/Change.ecore](http://download.eclipse.org/modeling/emf/emf/javadoc/2.6.0/org/eclipse/emf/ecore/change/package-summary.html) with *ADD*, *MOVE* and *REMOVE* you could write:

```xtext
enum ChangeKind:
    ADD | MOVE | REMOVE;
```

It is even possible to use alternative literals for your enums or reference an enum value twice:

```xtext
enum ChangeKind:
    ADD = 'add' | ADD = '+' | 
    MOVE = 'move' | MOVE = '->' | 
    REMOVE = 'remove' | REMOVE = '-';
```

Please note that Ecore does not support unset values for enums. If you define a grammar like

```xtext
Element:
	'element' name=ID (value=SomeEnum)?;
```

with the input of `element Foo` the resulting instance *Foo* will hold the enum value with the internal representation of `0` (zero). When generating the EPackage from your grammar this will be the first literal you define. As a workaround you could introduce a dedicated none-value or order the enums accordingly. Note that it is not possible to define an enum literal with an empty textual representation. You can overcome this by importing a meta model where the enum is defined and omitting some of its literals in the grammar.

---

## Ecore Model Inference {#metamodel-inference}

The Ecore model (or meta model) of a textual language describes the structure of its abstract syntax trees (AST). 

Xtext uses Ecore's EPackages to define Ecore models. Ecore models are declared to be either inferred from the grammar or imported. By using the `generate` directive, one tells Xtext to infer an EPackage from the grammar. 

### Type and Package Generation

Xtext creates

* an [EPackage]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EPackage.java)    
  * for each `generate` declaration. The *name* of the EPackage is set to the first parameter of such a declaration, its *nsURI* to the second parameter. An optional alias as the third parameter allows to distinguish generated EPackages later. Only one generated package declaration per alias is allowed.
* an [EClass]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java)    
  * for each return type of a parser rule. If a parser rule does not define a return type, an implicit one with the same name as the rule itself is assumed. You can specify multiple rules that return the same type, but only one EClass is generated for each type name.
  * for each type defined in an action or a cross-reference.
* an [EEnum]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EEnum.java)    
  * for each return type of an enum rule.
* an [EDataType]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EDataType.java)    
  * for each return type of a terminal rule or a data type rule.

All EClasses, EEnums, and EDataTypes are added to the EPackage referred to by the alias provided in the type reference they were created from.

### Feature and Type Hierarchy Generation

While walking through the grammar, the model inference algorithm keeps track of a set of the currently possible return types to add features to. 

* Entering a parser rule the set contains only the return type of the rule. 
* Entering an element of an alternative the set is reset to the same state it was in when entering the first option of the alternative. 
* Leaving an alternative the set contains the union of all types at the end of each of its paths.
* After an optional element, the set is reset to the same state it was before entering it. 
* After a non-optional unassigned rule call the set contains only the return type of the called rule. An optional rule call does not modify the set. A rule call is optional if its cardinality is `?` or `*`.
* After an action the set contains only the type of the action.

While traversing the parser rules Xtext creates 

* an [EAttribute]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EAttribute.java) in each current return type     
  * of type [EBoolean]({{site.javadoc.java}}/java/lang/Boolean.html) for each feature assignment using the `?=` operator. No further EReferences or EAttributes are generated from such an assignment.
  * for each assignment with the `=` or `+=` operator calling a terminal rule or data type rule. Its type is the return type of the called rule.
* an [EReference]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EReference.java) in each current return type     
  * for each assignment with the `=` or `+=` operator in a parser rule calling a parser rule. The type of the EReference is the return type of the called parser rule.
  * for each assigned action. The type of the reference is the return type of the current rule containing the action. 

Each [EAttribute]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EAttribute.java) or [EReference]({{site.src.emf}}/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EReference.java) takes its name from the assignment or action that caused it. Multiplicities are `0..1` for assignments with the `=` operator and `0..*` for assignments with the `+=` operator. 

Furthermore, each type that is added to the currently possible return types automatically extends the current return type of the parser rule. You can specify additional common super types by means of "artificial" parser rules that are never called, e.g.

```xtext
CommonSuperType:
    SubTypeA | SubTypeB | SubTypeC;
```

After the traversal of all grammar rules the model inference algorithm examines all generated EClasses and lifts up similar features to supertypes if there is more than one subtype and the feature is defined in all subtypes. This works even for multiple super types.

### Enum Literal Generation

For each alternative defined in an enum rule, the transformer creates an enum literal, as long as no other literal with the same name can be found. The *literal* property of the generated enum literal is set to the right hand side of the declaration. If it is omitted, an enum literal with equal *name* and *literal* attributes is inferred.

```xtext
enum MyGeneratedEnum:
    NAME = 'literal' | EQUAL_NAME_AND_LITERAL;
```

### Error Conditions

The following conditions cause an error 

*   An EAttribute or EReference has two different types or different cardinalities.
*   There is an EAttribute and an EReference with the same name in the same EClass.
*   There is a cycle in the type hierarchy.
*   An new EAttribute, EReference or super type is added to an imported type.
*   An EClass is added to an imported EPackage.
*   An undeclared alias is used. 
*   An imported Ecore model cannot be loaded.

---

## Grammar Mixins {#grammar-mixins}

Xtext supports the reuse of existing grammars. Grammars that are created via the Xtext wizard use `org.eclipse.xtext.common.Terminals` by default, which introduces a common set of terminal rules and defines reasonable defaults for hidden terminals.

```xtext
grammar org.example.domainmodel.Domainmodel
    with org.eclipse.xtext.common.Terminals

generate domainmodel "http://www.example.org/domainmodel/Domainmodel"

Model:
    greetings+=Greeting*;
  
Greeting:
    'Hello' name=ID '!';
```

To reuse an existing grammar, make sure the grammar file is on the classpath of the inheriting language. If it is in a different plug-in, make sure to add a plug-in dependency in the `MANIFEST.MF`. 

Mixing another grammar into a language makes the rules defined in that grammar referable. It is also possible to overwrite rules from the used grammar. Example:

```xtext
grammar my.SuperGrammar

generate super "http://my.org/super"

RuleA: 'a' stuff=RuleB;
RuleB: '{' name=ID '}';
```

```xtext
grammar my.SubGrammar with my.SuperGrammar

import "http://my.org/super"

Model: (ruleAs+=RuleA)*;

// overrides my.SuperGrammar.RuleB
RuleB: '[' name=ID ']';
```

Declared terminal rules always get a higher priority than imported terminal rules.

### Common Terminals {#common-terminals}

Xtext ships with a default set of predefined, reasonable and often required terminal rules. The grammar for these common terminal rules is defined as follows:

```xtext
grammar org.eclipse.xtext.common.Terminals 
    hidden(WS, ML_COMMENT, SL_COMMENT)

import "http://www.eclipse.org/emf/2002/Ecore" as ecore

terminal ID: 
    '^'?('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

terminal INT returns ecore::EInt: 
    ('0'..'9')+;

terminal STRING: 
    '"' ( '\\'('b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\') | !('\\'|'"') )* '"' |
    "'" ( '\\'('b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\') | !('\\'|"'") )* "'";
 
terminal ML_COMMENT: 
    '/*' -> '*/';

terminal SL_COMMENT: 
    '//' !('\n'|'\r')* ('\r'? '\n')?;

terminal WS: 
    (' '|'\t'|'\r'|'\n')+;

terminal ANY_OTHER: 
    .;
```

---

**[Next Chapter: Configuration](302_configuration.html)**