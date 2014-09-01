package generator

class ReleaseNotes  extends AbstractWebsite {

	override path() {
		"releasenotes.html"
	}
	
	override protected isPrettyPrint() {
		true
	}
	
override contents() '''
		«headline('')»
		<div id="page">
	  <div class="inner">
	  	<div class="container clearfix">
	    <h2>Xtext 2.7.0 Release Notes (September 2nd, 2014)</h2>
        <hr>
        <div class="span1">&nbsp;</div>
          <div class="span9">
            <b>Not yet released, but you can try the latest <a href="download.html">"Bleeding Edge" builds</a></b> 
            <p>
              Version 2.7 got many new features, bug fixes and performance improvements (<a href="https://bugs.eclipse.org/bugs/buglist.cgi?bug_status=RESOLVED&bug_status=VERIFIED&bug_status=CLOSED&status_whiteboard=v2.7">full bugzilla list</a>). The most noteworthy changes are :
            </p>
            
            <section id="inferrer_api" style="padding-top: 68px; margin-top: -68px;">
				<h2>Published Inferrer API of Xbase</h2>
				<p>
				   The JVM model inferrer API, which is the heart of Xbase, has been finalized and is now public. We took the opportunity to simplify it in some places. Have a look at the <a href="https://github.com/xtext-dev/seven-languages-xtext/tree/xtext_2.7">updated seven languages example</a> for idiomatic usage of the API.
				</p>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h2>Performance Improvements</h2>
				<p>
				   Xtext is now able to cancel many jobs (like refreshing the outline view) when the user starts typing, greatly improving responsiveness. Also, many UI actions can now be cancelled by hitting the "Stop" button.
				   Resource clustering is now supported in the builder participant and standalone builder, reducing the memory footprint for large projects. There is a new parallel builder participant that can be used for even more performance gains.
				</p>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h2>
				   Better Integration with Xcore
				</h2>
				<p>
				   The "New Xtext Project" wizard now supports Xcore models and adding them to an existing mwe2 workflow is as simple as specifying them as a <code>loadedResource</code>. Xcore itself has undergone some serious performance improvements, making it suitable even for large models.
				</p>
				<img class="image_between_p" src="images/releasenotes/2_7_xtext-xcore-wizard.png"/>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h2>Debugging</h2>
				<p>
				   Breakpoints can now be toggled, enabled/disabled and inspected via the ruler context menu. Partial support for conditional breakpoints was added. Content assist in the condition editor will be added in version 2.8.
				</p>
				<img class="image_between_p" src="images/releasenotes/2_7_xtext-breakpoint-toggle.png"/>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h2>
				   Find References improved
				</h2>
				<p>
				   The find references API is now available in the runtime plugin and has undergone some performance improvements.
				</p>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h2>
				   Cross Plattform Improvements
				</h2>
				<p>
				   All Xtext generator fragments now accept an explicit line delimiter, so heterogeneous teams get the same results when generating the language infrastructure.
				</p>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h1>
				   Xtend 2.7.0
				</h1>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h2>
				   Language
				</h2>
				<p>
				   It is now allowed to leave out parameter declarations for all lambda expressions using a positional syntax.
<pre class="prettyprint lang-xtend linenums">
#[1, 2, 3].reduce[$0 + $1]
</pre>
				Enum constants in annotations can be referenced without their type name.
<pre class="prettyprint lang-xtend linenums">
@Retention(RUNTIME)
</pre>
				Type inference for parameterized inner classes was improved and supports types like
<pre class="prettyprint lang-xtend linenums">
Option&LT;T&GT;.Some
</pre>
				The validator will now detect use of deprecated API and is much better at finding dead code. Would you have spotted the following?
				</p>
				<img class="image_between_p" src="images/releasenotes/2_7_xtend-dead-code-analysis.png"/>
				<img>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h2>
				   Library
				</h2>
				<p>
				   The standard library has new extension methods for <code>Iterables</code>, including <code>min</code>/<code>max</code>, <code>groupBy</code> and <code>indexed</code>.
				</p>
<pre class="prettyprint lang-xtend linenums">
#["Xtend", "Java", "Eclipse"].maxBy[length]
</pre>
				<p>New Active Annotations have been added to free you of some repetitive tasks. The new <code>@Accessors</code> generates getters and setters, with fine grained control and even for all fields of a class if you want. The <code>@Delegate</code> annotation automatically implements the delegation pattern for you, so you only need to concentrate on methods that you actually want to implement differently than just delegating. Here is an example:</p>
<pre class="prettyprint lang-xtend linenums">
interface I {
   def void m1()
   def void m2()
   def void m3()
}
class A implements I {
   override m1() {}
   override m2() {}
   override m3() {}
}
class B implements I {
   //all methods automatically implemented
   @Delegate A delegate = new A
}
</pre>
				<p>Other additions include <code>@ToString</code>, <code>@EqualsHashCode</code>, <code>@FinalFieldsConstructor</code> and a new <code>@Data</code> (the old one is now deprecated as well as <code>@Property</code>).</p>
				<p>The active annotation API integrates even deeper with the IDE. Every generated element can (and should) now declare its source element. This tracing information is used in places like the outline view. A separate validation phase has been added, so the end result after running all transformations can be validated. Also, changes to classes and even arbitrary resources that the annotation processor requested are detected and lead to automatic rebuilds.</p>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
			<h2>IDE Features</h2>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h3>
				   Debugging
				</h3>
				<p>
				   Xtend breakpoints can now have conditions. Conditions are written in Java, so you get full access even to synthetic variables inserted by the Xtend compiler. Of course you also get content assist in the condition editor.
				</p>
				<img class="image_between_p" src="images/releasenotes/2_7_xtend-conditional-breakpoint.png"/>
				<p>
				   Breakpoints can now be toggled, enabled/disabled and inspected via the ruler context menu.
				</p>
				<img class="image_between_p" src="images/releasenotes/2_7_xtext-breakpoint-toggle.png"/>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h3>
				   Content Assist
				</h3>
				<p>
				   Content Assist has become a lot faster and more accurate at the same time. It will now also retain the "is"-prefix of boolean properties.
				</p>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h3>
				   Performance Improvements
				</h3>
				<p>
				   Performance has reached a new level with big improvements to Content Assist, parallel code generation and lots of fine tuning. Also, Xtend will now cancel jobs (like outline refreshing) when you start typing again, making the editor much more responsive.
				</p>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h3>
				   Outline with Java-Mode
				</h3>
				<p>
				   The outline view now supports two modes: One shows the original Xtend AST, the other one shows the resulting Java AST. This is very useful in the presence of Active Annotations that add a lot of new members to a class.
				</p>
				<img class="image_between_p" src="images/releasenotes/2_7_xtend-outline-normal.png"/>
				<img class="image_between_p" src="images/releasenotes/2_7_xtend-outline-jvm.png"/>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h3>
				   Organize imports on packages
				</h3>
				<p>
				   You can now use "Organize Xtend Imports" on whole packages via the "Source" context menu.
				</p>
				<img class="image_between_p" src="images/releasenotes/2_7_xtend-organize-imports.png"/>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h3>
				   Template proposals support import
				</h3>
				<p>
				   A new type of template variable was added. It adds an import to an Xtend file when the template is inserted. This greatly reduces the need for qualified type names in templates.
				</p>
				<img class="image_between_p" src="images/releasenotes/2_7_xtend-templates-import.png"/>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h3>
				   Open return type
				</h3>
				<p>
				   Ever wondered what you can do with the type of a variable or the return type of a method? You can now CTRL-Click on feature calls and open the declaration of the return type of that call.
				</p>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h3>
				   Show errors from derived Java files
				</h3>
				<p>
				   By using black box Java code within active annotations the generated Java source could sometimes have errors while the Xtend code is fine. In those cases, the errors are now shown at the appropriate locations in Xtend as well.
				</p>
			</section>
			<section id="xtext_performance_2_7" style="padding-top: 68px; margin-top: -68px;">
				<h3>Maven and Java 8</h3>
				<p>
				   The Xtend Maven plugin is now toolchain-aware. Using this, you can for instance run Maven on Java 8, but compile against a JDK 6.
				</p>
			</section>
		</div>
		</div>
		</div>
	  
	  
	  
	  
	  
	    <div class="container clearfix">
«««      2.6.0
	    <h2>Xtext 2.6.0 Release Notes (May 21th, 2014)</h2>
        <hr>
        <div class="span1">&nbsp;</div>
          <div class="span9">
            <p>
              Version 2.6 got many bug fixes and performance improvements (<a href="https://bugs.eclipse.org/bugs/buglist.cgi?bug_status=RESOLVED&bug_status=VERIFIED&bug_status=CLOSED&status_whiteboard=v2.6">full bugzilla list</a>). The new features are:
            </p>
            
            <section id="todo_tags" style="padding-top: 68px; margin-top: -68px;">
<h2>Task Tags</h2>
<p>TODO, FIXME, and XXX markers in comments are now recognized by the IDE as task markers.
It will be enabled for all Xtext languages, without any further ado (not even a rebuild is required). 
To get an corresponding preference page for configuraing the kind of Task markers, a special generator fragment is available.</p>
<img class="image_between_p" src="images/releasenotes/2_6_0_task_markers.png"/>

</section>

<section id="new_ide_features" style="padding-top: 68px; margin-top: -68px;">
 <h2>Gradle Plug-in</h2>
 <p>A gradle plug-in for easy integration of the Xtext-based languages in any Gradle-based Java projects is now available.<br/>
The gradle plug-in is hosted <a href="https://github.com/oehme/xtext-gradle-plugin">at github</a>. </p>
<p>All ou need to do is to add the plugin to your build classpath:</p>
<pre class="prettyprint lang-xtend linenums">
buildscript {
  repositories {
    mavenCentral()
  }
  dependencies {
    classpath 'org.xtext:xtext-gradle-plugin:0.0.2'
  }
}
</pre>
<p>Add your languages to the xtextTooling configuration</p>
<pre class="prettyprint lang-xtend linenums">
dependencies {
  xtextTooling 'org.example:org.example.hero.core:3.3.3'
  xtextTooling 'org.example:org.example.villain.core:6.6.6'
}
</pre>
<p>Add code that your models compile against to the xtext configuration. If you use the Java plugin, this configuration will automatically contain everything from compile and testCompile. So in many cases this can be omitted.</p>
<pre class="prettyprint lang-xtend linenums">
dependencies {
  xtext 'com.google.guava:guava:15.0'
}
</pre>
<p>Configure your languages</p>
<pre class="prettyprint lang-xtend linenums">
xtext {
  version = '2.5.3' // the current default, can be omitted
  encoding = 'UTF-8' //the default, can be omitted

  /* Java sourceDirs are added automatically,
   * so you only need this element if you have
   * additional source directories to add
   */
  sources {
    srcDir 'src/main/heroes'
    srcDir 'src/main/villains'
  }

  languages{
    heroes {
      setup = 'org.example.hero.core.HeroStandaloneSetup'
      consumesJava = true
      outputs {
        DEFAULT_OUTPUT.dir = 'build/heroes'
        SIDEKICKS.dir = 'build/sidekicks'
      }
    }

    villains {
      setup = 'org.example.villain.core.VillainStandaloneSetup'
      //equivalent to DEFAULT_OUTPUT.dir
      output.dir = 'build/villains'
    }
  }
}
</pre>
<section id="first_token_syntactic_predicates" style="padding-top: 68px; margin-top: -68px;">
<h2>First-TokenSet Syntactic Predicates</h2>
<p>Syntactic predicates are used to solve ambiguities in grammars. Sometimes the predicate needs to be set on a more complex rule call, which might involve consuming a great number of tokens.
With traditional syntactic predicates using the <code>=&gt;</code> operator, the parser would need to match all of those tokens in order to make te decision. The new operator <code>-&gt;</code>
tells the parser to only look at the first token and make the decision based on that, which is sufficient in most cases. As a result the parser is faster and does better error recovery.</p>

</section><section id="synchronized_expression" style="padding-top: 68px; margin-top: -68px;">
<h2>Xbase - Synchronized Expression</h2>
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

</section><section id="switch_fall_through" style="padding-top: 68px; margin-top: -68px;">
<h2>Xbase - Switch Fall Through</h2>
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
<h2>Xbase - Compound Assignments</h2>
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
<h2>Xbase - Postfix Operators</h2>
<p>Postfix operators for incrementing and decrementing numbers have been added.</p>
<pre class="prettyprint lang-xtend linenums">
var i = 0
while (condition()) {
    i++
}
</pre>
</section><section id="traditional_for_loop" style="padding-top: 68px; margin-top: -68px;">
<h2>Xbase - Traditional For-Loop</h2>
<p>The traditional for-loop from Java is now available in Xtend, too.</p>
<pre class="prettyprint lang-xtend linenums">
for (var i = 0; i < 99; i++) {
    println(''+i+' bottles of beer on the wall.')
}
</pre>

</section><section id="multivalued_annotation_sugar" style="padding-top: 68px; margin-top: -68px;">
<h2>Xbase - Multivalued Annotations Sugar</h2>
<p>Instead of writing </p>
<pre class="prettyprint lang-xtend linenums">
@SurpressWarnings(#["unused", "unchecked"])
</pre>
<p> you can write</p>
<pre class="prettyprint lang-xtend linenums">
@SurpressWarnings("unused", "unchecked")
</pre>

<section id="new_ide_features" style="padding-top: 68px; margin-top: -68px;">
<h2>Xbase - Open Implementation</h2>
<p>In addition to go to declaration, you can now navigate to existing implementations of a method. It works just like in JDT</p>
<img class="image_between_p" src="images/releasenotes/2_6_0_open_implementation.png"/>

</section><section id="new_ide_features" style="padding-top: 68px; margin-top: -68px;">
<h2>Xbase - Debug Hover Shows Inspect Dialog</h2>
<p>In a debug session, when hovering over a local variable or a visible field, the popo up shows the inspection tree of the hovered value.</p>
<img class="image_between_p" src="images/releasenotes/2_6_0_debug_hover_variable.png"/>

</section><section id="new_ide_features" style="padding-top: 68px; margin-top: -68px;">
<h2>Xbase - Hover Shows Annotations</h2>
<p>The declaration hover now includes the annotations.</p>
<img class="image_between_p" src="images/releasenotes/2_6_0_annotations_in_hover.png"/>

</section>

</section><section id="new_ide_features" style="padding-top: 68px; margin-top: -68px;">
<h2>Treeshaken Xbase Lib for Android</h2>
<p>For large Android projects there is a need to have as little code packaged as possible. 
Usually this is achieved by proguarding cour code and the dependencies during the build. 
For people who find that tedious and want to work with a reduced lib from the get go, we offer a treeshaken version of the library, which is only 300k small.</p>
<p>The library can be <a href="http://search.maven.org/#search%7Cga%7C1%7Corg.eclipse.xtext.xbase.lib.slim">downloaded from maven central</a>.</p>
            
         </div>
      </div>
«««      2.5.0
      <div class="inner">
            <div class="container clearfix">
        <h2>Xtext 2.5.0 Release Notes (December 11th, 2013)</h2>
	    <hr>
	    <div class="span1">&nbsp;</div>
	      <div class="span9">
	        <p>
	          Xtext 2.5.0 includes 
	          <a href="https://bugs.eclipse.org/bugs/buglist.cgi?f1=OP&list_id=7722745&f0=OP&status_whiteboard_type=allwordssubstr&f4=CP&query_format=advanced&j1=OR&f3=CP&status_whiteboard=v2.5&bug_status=RESOLVED&bug_status=VERIFIED&bug_status=CLOSED">more than 100 bug fixes and enhancements</a>.
	          Some of the more important enhancements are :
	        </p>
	        <section id="annotations_2_5" style="padding-top: 68px; margin-top: -68px;">
	          <h2>Better Maven Support</h2>
	          <p>
	            Xtext 2.5.0 comes with much improved support for integrating Xtext languages and the corresponding code generators in 
	          continuous integration builds. All the needed jars are available on Maven central now and we have added a dedicated Maven compiler plug-in that 
	          simulates the incremental build in a headless Java Maven build (no Tycho needed!). Please read the <a href="documentation.html#continuousIntegration">new section in the documentation</a> for more 
	          details on the new Maven support.
	          </p>
	<pre class="prettyprint xml linenums">
&lt;plugin&gt;
  &lt;groupId&gt;org.eclipse.xtext&lt;/groupId&gt;
  &lt;artifactId&gt;xtext-maven-plugin&lt;/artifactId&gt;
  &lt;version&gt;2.5.0&lt;/version&gt;
  &lt;executions&gt;
    &lt;execution&gt;
      &lt;goals&gt;
        &lt;goal&gt;generate&lt;/goal&gt;
      &lt;/goals&gt;
    &lt;/execution&gt;
  &lt;/executions&gt;
  &lt;configuration&gt;
    &lt;languages&gt;
      &lt;language&gt;
        &lt;setup&gt;my.mavenized.HeroLanguageStandaloneSetup&lt;/setup&gt;
        &lt;outputConfigurations&gt;
          &lt;outputConfiguration&gt;
            &lt;outputDirectory&gt;src/main/generated-sources/xtend/&lt;/outputDirectory&gt;
          &lt;/outputConfiguration&gt;
        &lt;/outputConfigurations&gt;
      &lt;/language&gt;
    &lt;/languages&gt;
  &lt;/configuration&gt;
  &lt;dependencies&gt;
    &lt;dependency&gt;
      &lt;groupId&gt;my.mavenized.herolanguage&lt;/groupId&gt;
      &lt;artifactId&gt;my.mavenized.herolanguage&lt;/artifactId&gt;
      &lt;version&gt;1.0.0-SNAPSHOT&lt;/version&gt;
    &lt;/dependency&gt;
  &lt;/dependencies&gt;
&lt;/plugin&gt;	
	</pre>
	        </section>
	        <section id="annotations_2_5" style="padding-top: 68px; margin-top: -68px;">
	        </section>
	        <section id="compilerchecks" style="padding-top: 68px; margin-top: -68px;">
	          <h2>Enhancements for Xbase</h2>
	          <p>
	            The Xbase language and compiler has been improved in many ways.
	          </p>
	          <h3>Full support for Annotations</h3>
	          <p>
	            Xbase now supports all annotation values and constant expressions in annotations.
	          </p>
	<pre class="prettyprint lang-xtend linenums">
class MyEntity {
  @Columns(#[@Column('id'), @Column(value = 'timestamp', length = 2 * 3 * 7)])
  CompositeKey key
}
	</pre>
	          <h3 id="ambiguous_methods">Method overload validation</h3>
	          <p>
	            Ambiguous method invocations are checked and reported with a detailled message.
	            The compiler optionally detects valid but suspiciously overloaded methods
	            that could be implemented by accident. This is especially handy when property access and 
	            extension methods come into play.
	          </p>
	          <p>
	            Here's an example how it is used within Xtend.
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
     * 	getCheck() in B and
     * 	isCheck() in A
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
	          <h3 id="ambiguous_methods">Discouraged variable names</h3>
	          <p>
	            Some variable names are used implicitely by Xtend, for example the variable name 'self'.
	            The compiler optionally reports if these names were picked manually.
	          </p>
	          <h3 id="improved_auto_casts">Auto casts</h3>
	          <p>
	            Xbase supported auto-casts right from the beginning with its powerful switch expression.
	            In 2.5, the more familiar syntax with instance-of checks caught up and also applies automatic
	            casts in if expressions and while loops. 
	          </p>
	<pre class="prettyprint lang-xtend linenums">
if (c instanceof String) {
  c.substring(42)
}
	</pre>
	          <h3 id="switch_enum">Switch over enums</h3>
	          <p>
	            One of the few places where Xbase's syntax could be improved compared to Java, was a switch expression
	            over enumeration values. Now it's no longer necessary to use a qualified name or static imports for the enum values but
	            the literals are available automatically for the case guards.
	          </p>
	<pre class="prettyprint lang-xtend linenums">
switch p {
  case CLASS: 1
  case RUNTIME: 2
  case SOURCE: 3
}
	</pre> 
	          <h3>Improved type inference with primitive values</h3>
	          <p>
	            The local type inference has been improved when primitive types are involved. Their wrapper
	            types will be used in fewer cases which prevents unexpected exceptions at runtime.
	            An optional compiler check can point to places where primitive defaults are used rather than
	            explicit values.
	          </p>
	        </section>
	      </div>
	    <div class="span1">&nbsp;</div>  
	  </div>
	</div>
	'''
	
}