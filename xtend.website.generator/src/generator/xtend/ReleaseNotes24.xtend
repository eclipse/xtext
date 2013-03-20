package generator.xtend

class ReleaseNotes24 extends AbstractXtendWebsite {

	override path() {
		"releasenotes_2_4.html"
	}
	
	override protected isPrettyPrint() {
		true
	}
	
	override contents() '''
		«headline('Release Notes - Version 2.4')»
		<div id="page">
	  <div class="inner">
	    <div class="container clearfix">
	    <h2>Xtend 2.4 Release Notes</h2>
	    <hr>
	    <div class="span1">&nbsp;</div>
	      <div class="span9">
	        <p>
	          The team is proud to present a release with 
	          more than <a href="https://bugs.eclipse.org/bugs/buglist.cgi?o5=anywordssubstr&f1=OP&f0=OP&resolution=FIXED&classification=Modeling&classification=Tools&f4=CP&v5=kepler&query_format=advanced&j1=OR&f3=CP&bug_status=RESOLVED&bug_status=VERIFIED&f5=flagtypes.name&component=Backlog&component=Common&component=Core&component=Releng&component=Website&component=Xtext&component=Xtext%20Backlog&product=TMF&product=Xtend&list_id=4768360">300 bug fixes</a> and some ground breaking features.
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
	            <li><a href="#active_annotations">Active Annotations</a>
	            <li><a href="#collection_literals">Collection Literals and Array Access</a>
	            <li><a href="#extension_values">Extension Values</a>
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
	  -DarchetypeCatalog=http://build.eclipse.org/common/xtend/maven/
	</pre>
	        </section>
	        <section id="new_language_features" style="padding-top: 68px; margin-top: -68px;">
	        <h2>New Language Features</h2>
	        <p>
	        The following new features have been added to the Xtend language.
	        </p>
	        <h3 id="active_annotations" >Active Annotations (Provisional API)</h3>
	      <p>
	      <em>Active Annotations</em> let developers particpate in the translation process
	      from Xtend code to Java source code. The developer declares an annotation and a call back for the compiler where 
	      the generated Java code can be customized arbitrarily. This doesn't break static typing 
	      or the IDE! Any changes made in an active annotation are completely reflected by the environment

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