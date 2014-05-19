package generator.xtend

class ReleaseNotes extends AbstractXtendWebsite {

    override path() {
        "releasenotes.html"
    }
    
    override protected isPrettyPrint() {
        true
    }
    
    override contents() '''
        «headline('Release Notes')»
        <div id="page">
      <div class="inner">
            <div class="container clearfix">
        <h2>Xtend 2.6.0 Release Notes (May 21th, 2014)</h2>
        <hr>
        <div class="span1">&nbsp;</div>
          <div class="span9">
            <p>
              Version 2.6 got many bug fixes and performance improvements (<a href="https://bugs.eclipse.org/bugs/buglist.cgi?bug_status=RESOLVED&bug_status=VERIFIED&bug_status=CLOSED&status_whiteboard=v2.6">full bugzilla list</a>). The new features are:
            </p>
            </section><section id="anonymous_classes" style="padding-top: 68px; margin-top: -68px;">
<h2>Anonymous Classes</h2>
<p>Xtend supports using lambdas to implement anonymous classes with just one abstract method since its inception. 
For interfaces and abstract classes with more than one method you can now also use the an anonymous class using the following syntax:</p>

<pre class="prettyprint lang-xtend linenums">
val tabListener = new ActionBar.TabListener() {

    override onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // show the given tab
    }

    override onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        // hide the given tab
    }

    override onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        // probably ignore this event
    }
};
</pre>     
</section><section id="static_nested_classes" style="padding-top: 68px; margin-top: -68px;">
<h2>Static Nested Classes</h2>
<p>Xtend now supports static nested classes.</p>
<pre class="prettyprint lang-xtend linenums">
class A {
    static class NestedClass {
    }
}
</pre>
</section><section id="operator_declaration" style="padding-top: 68px; margin-top: -68px;">
<h2>Operator Declarations</h2>
<p>In addition to overloading operators by adhering to the name mappings, listed in <a href="documentation.html#operators">the documentation</a>, 
one can now use the actual operator in the declaration as well.</p>
<pre class="prettyprint lang-xtend linenums">
class Money {
    def + (Money other) { ... }
    def - (Money other) { ... }
    def * (BigDecimal times) { ... }
    ...
}
</pre>
</section><section id="synchronized_expression" style="padding-top: 68px; margin-top: -68px;">
<h2>Synchronized Expression</h2>
<p>
    The synchronized expression works basically like Java's synchronized statement.
</p>
<pre class="prettyprint lang-xtend linenums">
synchronized(lock) {
    // do stuff
}
</pre>
<p>
    But of course it is an expression, as everything in Xtend/Xbase. So you can write the following as well:
</p>
<pre class="prettyprint lang-xtend linenums">
someMethodCall(synchronized(lock) { ... })
</pre>
</section><section id="qualified_static_imports" style="padding-top: 68px; margin-top: -68px;">
<h2>Qualified Static Imports</h2>
<p>It is now possible to import features in a fully qualified way. This works for regular static imports as well as for extension imports.</p>
<pre class="prettyprint lang-xtend linenums">
// static import
import static java.util.Collections.singleton
// extension import
import static extension java.util.Collections.min
import static extension java.util.Collections.max
</pre>
</section><section id="switch_fall_through" style="padding-top: 68px; margin-top: -68px;">
<h2>Switch Fall Through</h2>
<p>The switch expression now supports a kind of fall through. Here's an example</p>
<pre class="prettyprint lang-xtend linenums">
switch myOperator {
    case '+',
    case '-' : handlePlusMinus()    
    case '*',
    case '/' : handleDivMultiply()
    default : throw new IllegalStateException
}
</pre>
</section><section id="compound_assignments" style="padding-top: 68px; margin-top: -68px;">
<h2>Compound Assignments</h2>
<p>Xtend now supports compound assignment operators.</p>
<pre class="prettyprint lang-xtend linenums">
var i = 0
i += 42
</pre>
<p>Compound operators work on overloaded operators as well. That is you don't need to declare '+=' if you have '+' defined. 
Example:</p>
<pre class="prettyprint lang-xtend linenums">
var distance = 15.km
distance += 5.km
</pre>
</section><section id="postfix_operators" style="padding-top: 68px; margin-top: -68px;">
<h2>Postfix Operators</h2>
<p>Postfix operators for incrementing and decrementing numbers have been added.</p>
<pre class="prettyprint lang-xtend linenums">
var i = 0
while (condition()) {
    i++
}
</pre>
</section><section id="traditional_for_loop" style="padding-top: 68px; margin-top: -68px;">
<h2>Traditional For-Loop</h2>
<p>The traditional for-loop from Java is now available in Xtend, too.</p>
<pre class="prettyprint lang-xtend linenums">
for (var i = 0; i < 99; i++) {
    println(''+i+' bottles of beer on the wall.')
}
</pre>

</section><section id="multivalued_annotation_sugar" style="padding-top: 68px; margin-top: -68px;">
<h2>Multivalued Annotations Sugar</h2>
<p>Instead of writing </p>
<pre class="prettyprint lang-xtend linenums">
@SurpressWarnings(#["unused", "unchecked"])
</pre>
<p> you can write</p>
<pre class="prettyprint lang-xtend linenums">
@SurpressWarnings("unused", "unchecked")
</pre>

</section><section id="active_annotation_mark_as_read" style="padding-top: 68px; margin-top: -68px;">
<h2>Active Annotations - Flag fields as read resp. initialized</h2>
<p>When initializing a final field within a synthetic constructor, the control flow analysis couldn't detect it was in fact initialized and would raise an error. Another typical solution was a warning when a private field was only accessed through methods added by an active annotation (e.g. a setter or getter). You can now mark a field as read resp. initialized.</p>

</section><section id="style_checks" style="padding-top: 68px; margin-top: -68px;">
<h2>Style Checks</h2>
<p>2.6 adds the following optional compiler checks (inactive by default):</p>
    <h3>Force return expression</h3>
    <img class="image_between_p" src="images/releasenotes/2_6_0_validation-explicit-return.png"/>
    <h3>Force declare return types</h3>
    <img class="image_between_p" src="images/releasenotes/2_6_0_validation-explicit-return-declaration.png"/>
    <h3>Force empty parenthesis on method invocation</h3>
    <img class="image_between_p" src="images/releasenotes/2_6_0_validation-empty-parenthesis.png"/>

</section><section id="new_ide_features" style="padding-top: 68px; margin-top: -68px;">
<h2>Task Tags</h2>
<p>TODO, FIXME, and XXX markers in comments are no recognized by teh IDE as task markers.
The Xtend editor picks up the preference of JDT for adding new kind of markers or removing existing ones.</p>
<img class="image_between_p" src="images/releasenotes/2_6_0_task_markers.png"/>

</section><section id="new_ide_features" style="padding-top: 68px; margin-top: -68px;">
<h2>Open Implementation</h2>
<p>In addition to go to declaration, you can now navigate to existing implementations of a method. It works just like in JDT</p>
<img class="image_between_p" src="images/releasenotes/2_6_0_open_implementation.png"/>

</section><section id="new_ide_features" style="padding-top: 68px; margin-top: -68px;">
<h2>Debug Hover Shows Inspect Dialog</h2>
<p>In a debug session, when hovering over a local variable or a visible field, the popo up shows the inspection tree of the hovered value.</p>
<img class="image_between_p" src="images/releasenotes/2_6_0_debug_hover_variable.png"/>

</section><section id="new_ide_features" style="padding-top: 68px; margin-top: -68px;">
<h2>Hover Shows Annotations</h2>
<p>The declaration hover now includes the annotations.</p>
<img class="image_between_p" src="images/releasenotes/2_6_0_annotations_in_hover.png"/>

</section><section id="new_ide_features" style="padding-top: 68px; margin-top: -68px;">
 <h2>Gradle Plug-in</h2>
 <p>A gradle plug-in for easy integration of the Xtend compiler in any gradle based Java projects is now available.
The gradle plug-in even also works with the new Android buildsystem developed by Google. <br/>
The gradle plug-in is hosted <a href="https://github.com/oehme/xtend-gradle-plugin">at github</a>. </p>
<pre class="prettyprint lang-xtend linenums">
buildscript {
  repositories {
    mavenCentral()
  }
  dependencies {
    classpath 'org.xtend:xtend-gradle-plugin:0.0.8'
  }
}
apply plugin: 'xtend'
repositories {
    mavenCentral()
}
dependencies {
  //or testCompile if you only want to use Xtend for some tests
  compile 'org.eclipse.xtend:org.eclipse.xtend.lib:2.6.0'
}
</pre>
</section><section id="new_ide_features" style="padding-top: 68px; margin-top: -68px;">
<h2>Treeshaken Lib for Android</h2>
<p>For large Android projects there is a need to have as little code packaged as possible. 
Usually this is achieved by proguarding cour code and the dependencies during the build. 
For people who find that tedious and want to work with a reduced lib from the get go, we offer a treeshaken version of the library, which is only 300k small.</p>
<p>The library can be <a href="http://search.maven.org/#search%7Cga%7C1%7Corg.eclipse.xtext.xbase.lib.slim">downloaded from maven central</a>.</p>
            
         </div>
      </div>
      <div class="inner">
            <div class="container clearfix">
        <h2>Xtend 2.5.0 Release Notes (Dec 11th, 2013)</h2>
        <hr>
        <div class="span1">&nbsp;</div>
          <div class="span9">
            <p>
              With over <a href="http://goo.gl/7zorrn">100 bugfixes</a> Version 2.5.0 is mainly a bugfix and
              performance release. The team has been working on ironing out any glitches in the user experience
              and further improving a fluent workflow with the language and the tools.
            </p>
            <section id="annotations_2_5" style="padding-top: 68px; margin-top: -68px;">
              <h2>Full support for Java 7 Annotations</h2>
              <p>
                The Xtend compiler now supports all annotation values and constant expressions in annotations.
                These annotation can be evaluated during compilation within active annotations. Also all values
                supported in Java can now be set during annotation processing.
              </p>
    <pre class="prettyprint lang-xtend linenums">
    annotation Columns {
      Column[] value = #[ @Column('id') ]
    }
    annotation Column {
      String value
      int length = 2 << 16
    }
    </pre>
    <pre class="prettyprint lang-xtend linenums">
    class Entity {
      @Columns(#[@Column('id'), @Column(value = 'timestamp', length = 2 * 3 * 7)])
      CompositeKey key
    }
    </pre>
            </section>
            <section id="compiler_checks_2_5" style="padding-top: 68px; margin-top: -68px;">
              <h2>Improved compiler checks</h2>
              <p>
                The Xtend compiler now detects ambiguously overloaded methods.
              </p>
              <h3 id="ambiguous_methods">Method overload validation</h3>
              <p>
                Ambiguous method invocations are checked and reported with a detailled message.
                The compiler optionally detects valid but suspiciously overloaded methods
                that could be implemented by accident. This is especially handy when property access and 
                extension methods come into play.
              </p>
    <pre class="prettyprint lang-xtend linenums">
    class A {
      def isCheck() {..}
    }
    class B extends A {
      def m() {
        /*
         * Ambiguous feature call.
         * The methods
         *     getCheck() in B and
         *     isCheck() in A
         * both match.
         */ 
        this.check
      }
      def getCheck() {..}
    }
    </pre>
              <em>Important note:</em>
              <p>
                You have to make sure to use the library in version 2.5 along with the introduced compiler checks.
              </p>
              <h3 id="discouraged_variable_names">Discouraged variable names</h3>
              <p>
                Some variable names are used implicitely by Xtend, for example the variable name 'self'.
                The compiler optionally reports if these names were picked manually.
              </p>
            </section>
            <section id="language_enhancements_2_5" style="padding-top: 68px; margin-top: -68px;">
              <h2>Small language enhancements</h2>
              <p>
                Some refinements have been made to the Xtend language semantics to improve the overall experience.
              </p>
              <h3 id="improved_auto_casts">Auto casts</h3>
              <p>
                Xtend supported auto-casts right from the beginning with its powerful switch expression.
                In 2.5, the more familiar syntax with instance-of checks caught up and also applies automatic
                casts in if expressions and while loops. 
              </p>
    <pre class="prettyprint lang-xtend linenums">
    def m(CharSequence c) {
      if (c instanceof String) {
        c.substring(42)
      }
    }
    </pre>
              <h3 id="switch_enum">Switch over enums</h3>
              <p>
                One of the few places where Xtend's syntax could be improved compared to Java, was a switch expression
                over enumeration values. Now it's no longer necessary to use a qualified name or static imports for the enum values but
                the literals are available automatically for the case guards. 
              </p>
    <pre class="prettyprint lang-xtend linenums">
    def m(RetentionPolicy p) {
      switch p {
        case CLASS: 1
        case RUNTIME: 2
        case SOURCE: 3
      }
    }
    </pre> 
            </section>
            <section id="template_expression_2_5" style="padding-top: 68px; margin-top: -68px;">
              <h2>Customizable template expression</h2>
              <p>
                The template expressions can now be semantically enhanced via target typing.
                One use case is code generation where imports are automatically added when concatenating a type
                or if the appended object does not have a proper string representation. It is also possible
                to pass an explicit line delimiter rather than using the platform default.
              </p>
    <pre class="prettyprint lang-xtend linenums">
    def StringConcatenationClient m() '«»''my template'«»'' // uses target type
    
    // caller code
    val result = new StringConcatenation(lineDelimiter) // custom line delimiter or subtype
    result.append(m)
    return result.toString()
    </pre>
            </section>
            <section id="primitive_types_2_5" style="padding-top: 68px; margin-top: -68px;">
              <h2>Improved type inference with primitive values</h2>
              <p>
                The local type inference has been improved when primitive types are involved. Their wrapper
                types will be used in fewer cases which prevents unexpected exceptions at runtime.
                An optional compiler check can point to places where primitive defaults are used rather than
                explicit values.
              </p>
            </section>
            <section id="mvn_android_2_5" style="padding-top: 68px; margin-top: -68px;">
              <h2>Better experience with Maven and Android</h2>
              <p>
                The Android archetype for Maven was improved. It
                properly configures the compiler and debug settings, uses the latest Android libraries and the produced
                Eclipse project matches the structure that is created by the ADT wizards.
              </p>
            </section>
          </div>
        </div>
        <div class="container clearfix">
        <h2>Xtend 2.4.3 Release Notes (Sep 04th, 2013)</h2>
        <hr>
        <div class="span1">&nbsp;</div>
          <div class="span9">
            <p>
              The team is proud to present a release with 
              more than <a href="https://bugs.eclipse.org/bugs/buglist.cgi?o5=anywordssubstr&f1=OP&f0=OP&resolution=FIXED&classification=Modeling&classification=Tools&f4=CP&v5=kepler&query_format=advanced&j1=OR&f3=CP&bug_status=RESOLVED&bug_status=VERIFIED&f5=flagtypes.name&component=Backlog&component=Common&component=Core&component=Releng&component=Website&component=Xtext&component=Xtext%20Backlog&product=TMF&product=Xtend&list_id=4768360">450 bug fixes</a> and features.
            </p>
            <h2>Table of contents</h2>
            <ul>
              <li><a href="#android_development">Android Support</a>
                  <ul>
                      <li><a href="#android_debugging">Debugging</a>
                      <li><a href="#android_maven">Maven Archetype</a>
                  </ul>
              <li><a href="#new_language_features">New Language Features</a>
                <ul>
                <li><a href="#streamlined">Streamlined Syntax Changes</a>
                <li><a href="#active_annotations">Active Annotations</a>
                <li><a href="#collection_literals">Collection Literals and Array Access</a>
                <li><a href="#extension_provider">Extension Providers</a>
                <li><a href="#interfaces_enums_annotations">Interfaces, Enumerations and Annotations</a>
                <li><a href="#sam_types">SAM Type Conversion</a>
                <li><a href="#new_operators">New Operators</a>
                </ul>
              </li>
              <li><a href="#new_ide_features">New Editor Features</a>
                <ul>
                <li><a href="#organize_imports">Organize Imports</a>
                <li><a href="#extract_method">Extract Method and Extract Local Variable</a>
                <li><a href="#suppression_followup">Supression of Follow-Up Errors</a>
                <li><a href="#optional_errors">Optional Errors and Warnings</a>
                <li><a href="#quickfixes">New Quickfixes</a>
                <li><a href="#content_assist">Improved Content Assist</a>
                <li><a href="#formatter">Code Formatter</a>
                <li><a href="#javadoc">JavaDoc</a>
                <li><a href="#copy_qualifiedname">Copy Qualified Name</a>
                </ul>
              </li>
            </ul>
            <section id="android_development" style="padding-top: 68px; margin-top: -68px;">
              <h2>Android Support</h2>
              <p>Xtend is a great choice for Android application development because it compiles to Java source code 
              and doesn't require a fat runtime library. With version 2.4 the Android support has been 
              further improved.
              </p>
              <h3 id="android_debugging">Debugging</h3>
                <p>
                Debugging Android applications works now. Previously Xtend supported debugging through JSR-45 only, which is not supported by the 
                Dalvik VM. Now you can configure the compiler to install the debug information in a Dalvik-compatible manner.
                </p>
              <h3 id="android_maven">Maven Archetype</h3>
                <p>
                There is also a Maven archetype to set up a working Android project easily. If you 
                have installed Maven and the Android SDK you only need the following command to 
                get started:
                </p>
    <pre class="prettyprint linenums">
    mvn archetype:generate -DarchetypeGroupId=org.eclipse.xtend \
      -DarchetypeArtifactId=xtend-android-archetype \
      -DarchetypeCatalog=http://repo.maven.apache.org/maven2
    </pre>
            </section>
            <section id="new_language_features" style="padding-top: 68px; margin-top: -68px;">
            <h2>New Language Features</h2>
            <p>
            The following new features have been added to the Xtend language.
            </p>
            <h3 id="streamlined" >Streamlined Java syntax</h3>
            <p>
                In 2.4.2 we have introduced new (more Java-like) ways to access nested classes and static members. Also 
                type literals can be written by just using the class name.
            </p>
            
            <p>
                Here is an example for a static access of the generated methods in Android's ubiquitous R class:
            </p>
    <pre class="prettyprint lang-xtend linenums">
    R.id.edit_message 
    // previously it was (still supported) :
    R$id::edit_message
    </pre> 
            <p>
                Type literals can now be written even shorter. Let's say you want to filter a list by type:
            </p>
    <pre class="prettyprint lang-xtend linenums">
    myList.filter(MyType) 
    // where previously you had to write (still supported) :
    myList.filter(typeof(MyType)
    </pre> 
            <p>
                If you use the Java syntax (e.g. <i>MyType.class</i>), you'll get an error marker pointing you to the right syntax.
            </p>
            <h3 id="active_annotations" >Active Annotations (Provisional API)</h3>
          <p>
          <em>Active Annotations</em> let developers particpate in the translation process
          from Xtend code to Java source code. The developer declares an annotation and a call back for the compiler where 
          the generated Java code can be customized arbitrarily. This doesn't break static typing 
          or the IDE! Any changes made in an active annotation are completely reflected by the environment.

          A simple example would be a JavaBeans 
          property supporting the Observer pattern. Here you need a getter and a 
          setter method for each field and also an observer list and the proper code to notify 
          them about changes. In many software systems you have hundreds of these properties. 
          Active Annotation allow you to define and automate the implementation of such patterns 
          and idioms at a single point and 
          let the compiler expand it on the fly. And all this based on lightweight, custom libraries. 
          You do no longer have to write nor 
          read the boiler plate code anymore. <a href="documentation.html#activeAnnotations">Read more...</a>
          </p>
            <h3 id="collection_literals">Collection Literals and Arrays</h3>
            <p>
            Xtend now has literals for unmodifiable collections.
            </p>
    <pre class="prettyprint lang-xtend linenums">
    val listOfWords = #["Hello", "Xtend"]
    val setOfWords  = #{"Hello", "Xtend"}
    val mapOfWords  = #{1->"Hello", 2->"Xtend"}
    </pre> 
          <p>
          Collections created with a literal are immutable. The list literal can be used to natively create arrays, too. 
          If the target type is an array, it will compile to an array initializer.
          </p>
    <pre class="prettyprint lang-xtend linenums">
    val String[] arrayOfWords = #["Hello", "Xtend"]
    </pre> 
          <p>
          In addition to literals for arrays you can now also easily access and modify arrays 
          as well as create empty arrays of any size.
          </p>
    <pre class="prettyprint lang-xtend linenums">
    val String[] arrayOfWords = newArrayOfSize(2)
    arrayOfWords.set(0, 'Hello')
    arrayOfWords.set(1, 'Xtend')
    </pre> 
          <h3 id="interfaces_enums_annotations">Interfaces, Enums and Annotations</h3>
          <p>
          Interfaces, enumerations and annotation types can now be declared directly in Xtend. 
          </p>
    <pre class="prettyprint lang-xtend linenums">
    interface Container<T> {
      def T findChild((T)=>boolean matcher)
    }
    
    enum Color {
      RED, GREEN, BLUE
    }
    
    @Retention(RetentionPolicy::RUNTIME)
    @Target(ElementType::TYPE)
    annotation DependsOn {
      Class&lt;? extends Target&gt; value
      val version = "2.4.0" // type 'String' inferred 
    }
    </pre>
    
          <h3 id="extension_provider">Extension Provider</h3>
          <p>
          Extension methods allow to add new methods to existing types without modifying them. 
          Consider the omnipresent class <code class="prettyprint lang-java">java.lang.String</code>.
          If you have to parse a string to a number, you could always write
          </p>
    <pre class="prettyprint lang-java linenums">
    Integer::parseInt('42')
    </pre>
          <p>but what you actually think of is</p>
    <pre class="prettyprint lang-xtend linenums">
    '42'.parseInt
    </pre>
          <p>To make that possible, you simply import the class <code class="prettyprint lang-java">Integer</code> as a static extension:</p>
    <pre class="prettyprint lang-xtend linenums">
    import static extension java.lang.Integer.*
    </pre>
          <p>This enables to pass the base of the number as an argument, too:</p>
    <pre class="prettyprint lang-xtend linenums">
    '2A'.parseInt(16)
    </pre>
          Extension methods are available in other language such as C# as well, but Xtend can do better.
          The new <em>Extensions Providers</em> render a former limitiation obsolete: In Xtend 2.4, fields, 
          parameters and local variables can provide extensions, too. <a href="documentation.html#Extension_Provider">Read more...</a>
    <br><br>
          <h3 id="sam_types">SAM Type Conversion</h3>
          <p>
          Lambda expressions now work with interfaces and classes with a single abstract method 
          (SAM types). For example, the <code class="prettyprint lang-java">AbstractIterator</code> 
          from the Guava library has a single abstract method 
          <code class="prettyprint lang-java">computeNext()</code>. A lambda can be used to implement that:
          </p>
    <pre class="prettyprint lang-xtend linenums">
    val AbstractIterator&lt;Double&gt; infiniteRandomNumbers = [| Math::random]
    </pre>
    
          <h3 id="new_operators">New Operators</h3>
          <p>
          Some new operators have been added. In addition to the usual <code>==</code> and <code>!=</code>
          operators which map to <code>Object.equals(Object)</code>, the operators <code>===</code> and
          <code>!==</code> respectively can be used to test for identity equality.
    <pre class="prettyprint lang-xtend linenums">
    if (myObject === otherObject) {
      println("same objects")
    }
    </pre>
          <p>
            Also new exclusive range operators have been introduced. In order to iterate over a list and
            work with the index you can write:</p>
    <pre class="prettyprint lang-xtend linenums">
    for (idx : 0 ..&lt; list.size) {
      println("("+idx+") "+list.get(idx))
    }
    </pre>
          <p>
            Or if you want to iterate backwards :</p>
    <pre class="prettyprint lang-xtend linenums">
    for (idx : list.size &gt;.. 0) {
      println("("+idx+") "+list.get(idx))
    }
    </pre>
            </section>
            <section id="new_ide_features" style="padding-top: 68px; margin-top: -68px;">
            <h2>New IDE Features</h2>
            <p>Being an Eclipse project Xtend has always been designed with IDE integration in 
            mind. The team is proud to announce that the editing support is now almost on par with 
            Java's and in some aspects already even better. A user recently wrote in the newsgroup:
            </p>
            <blockquote>
               Tooling for Xtend is unlike any other language for the JVM after Java. The IDE support 
               is first class. It will take years for some languages to catch up. Some never will.
               </blockquote>
               <p>
            The following new IDE features improve the editing experience significantly:
            </p>
            <dl>
                <h3 id="organize_imports">Organize Imports</h3>
                <p>
                With the new release we have overhauled the <em>Organize imports</em> action. It 
                processes all kinds of imports, asks to resolve conflicts, and shortens qualified names
                automatically.
                </p>
                <img class="image_between_p" src="images/releasenotes/organize_imports.png"/>
    
                <h3 id="extract_method">Extract Method and Extract Local Variable</h3>
                <p>
                New refactorings have been added. You can now extract code into a new local variable
                </p>
                <img class="image_between_p" src="images/releasenotes/extract_local_variable.png"/>
                <p>
                or into a new method.
                </p>
                <img class="image_between_p" src="images/releasenotes/extract_method_refactoring.png"/>
    
                <h3 id="suppression_followup">Supression of Follow-Up Errors</h3>
                <p>
                Follow-up error markers are now suppressed and errors in general are much more local, 
                so it is very easy to spot the problem immediately.
                </p>
                <img class="image_between_p" src="images/releasenotes/follow_up_errors.png"/>
    
                <h3 id="optional_errors">Optional Errors and Warnings</h3>
                <p>The severity of optional compiler errors can be configured globally as well as 
                individually for a single project. They can either be set explicitly or delegate to the equivalent
                setting of the Java compiler.</p>
                <img class="image_between_p" src="images/releasenotes/issue_severities.png"/>
    
                <h3 id="quickfixes">More Quickfixes</h3>
                <p>
                Xtend now offers to create missing fields, methods, and types through quick fix proposals.
                </p>
                <img class="image_between_p" src="images/releasenotes/quickfixes.png"/> 
            
                <h3 id="content_assist">Improved Content Assist</h3>
                <p>
                The content assist has become much smarter. It now proposes lambda brackets if the method 
                accepts a single function and it offers hints on the parameter types when you 
                are working with overloaded methods.
                </p>
                <img class="image_between_p" src="images/releasenotes/content_assist.png"/>
            
                <h3 id="formatter">Formatter</h3>
                <p>
                A configurable formatter which pretty prints and indents code idiomatically is now available.
                </p>
                <img class="image_between_p" src="images/releasenotes/formatter.png"/>
                <img class="image_between_p" src="images/releasenotes/formatter_preferences.png"/>
                
                <h3 id="javadoc">JavaDoc</h3>
                <p>
                An Xtend editor now has validation and content assist within JavaDoc comments.
                </p>
                <img class="image_between_p" src="images/releasenotes/javadoc_content_assist.png"/>
                
                <h3 id="copy_qualifiedname">Copy Qualified Name</h3>
                <p>
                You can use <em>Copy Qualified Name</em> in the editor and the outline view to copy the name
                of types, fields and methods into the clipboard.
                </p>
                <img class="image_between_p" src="images/releasenotes/copy_qualified_name.png"/>
            </dl>
            </section>
    
            
          </div>  
        <div class="span1">&nbsp;</div>  
      </div>
    </div>
    '''
    
}

