package generator

class ReleaseNotes  extends AbstractWebsite {

	override path() {
		"releasenotes.html"
	}
	
	override protected isPrettyPrint() {
		true
	}
	
override contents() '''
		«headline('Release Notes - Version 2.5.0 (December 2013)')»
		<div id="page">
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