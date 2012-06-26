package generator.xtend

class Index extends AbstractXtendWebsite {
	
	override path() {
		"index.html"
	}
	
	override protected isPrettyPrint() {
		true
	}
	
	override contents() '''
	<!--Container-->
	
	<div id="header_wrapper">
		<div class="container"> 
			<div class="flexslider image-slider">
				<div class="span5 slide">
				<h2>
					It's just Java
				</h2>
				<br />
					<p>Xtend is a little language that compiles 
					into idiomatic Java source code. 
						You can use any existing Java library seamlessly 
						from Xtend (and vice-versa). The compiled output is readable 
						and pretty-printed, and tends to run as fast or faster than the equivalent
						handwritten Java code.</p>
					<a href="download.html" class="btn_download"></a>
				<a href="documentation.html" class="btn_documentation"></a>
				</div>
				<div class="span6">
					<div class="introduction">
						<a href="#"><img src="images/title-screenshot.png"
							alt="Xtend Screencast" style="margin:40pt;"/></a> 
						<a href="http://vimeo.com/31248257"
							data-rel="prettyPhoto" title="Introduction" class="zoom zoom_icon"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="intro">
		<div class="container">
			<h1>What is Xtend?</h1>
			<p>Xtend is a statically-typed programming language which <strong>compiles to comprehensible Java source code</strong>.</p>
			<p>It is designed to work great with existing Java APIs and idioms, yet introduces new features to modernize Java applications.
			It's <strong>faster than Groovy</strong>, <strong>simpler than Scala</strong> and incorporates all <strong>benefits of Java</strong> such as <strong>great tool support</strong>.</p>
			<p>Xtend is implemented on top of <a href="http://xtext.org" style=" color : white; ">Xtext</a></p>
		</div>
	</div>

	<div id="features">
		<div class="container">
			<div class="row">
				<div class="span12">
					<br /> <br />
					<h1>6 Good Reasons to use Xtend</h1>
					<br />
				</div>
				«entry('Less Noise','''
					<p>
						Xtend removes all the unnecessary syntactical noise: No semicolons, 
						no empty parentheses, good default visibility.<br/><br/>
						<strong>Whitespace can be so beautiful!</strong>
					</p>
					''',
					'images/icon-noise.png',
					'http://vimeo.com/12824833'
				)»
				«entry('More Power','''
					<p>
						Learn how to enhance existing Java APIs through <a href="documentation.html#extensionMethods">extension methods</a> and <a href="documentation.html#lambdas">lambda expressions</a>.
						Make use of <a href="documentation.html#operators">operators</a> where you always wanted and <a href="documentation.html#switchExpression">get rid of lengthy instanceof / casting orgies</a> in
						your existing code.
					</p>
					''',
					'images/icon-expressive.png',
					'http://vimeo.com/12824833'
				)»
				«entry('100% Java Compatible','''
					<p>
						Unlike <strong>all</strong> other JVM-languages, Xtend resembles Java's type system without any compromises
						or cheap short-cuts. This guarantees that <strong>you won't run into any interoperability caveats</strong>. Integration with Java
						works as expected in both directions and the generated code runs as fast as or faster than hand-written Java.
					</p>
					''',
					'images/icon_interop.png',
					'http://vimeo.com/12824833'
				)»
				«entry('Better Tooling','''
					<p>
						Static typing is not only important for early error detection but even more so for top-notch IDE support.
						To ensure a great and holistic user experience, the IDE and the language has been designed side by side. And of course
						the tools integrate tightly with Eclipse's existing Java IDE.
					</p>
					''',
					'images/icon-tools.png',
					'http://vimeo.com/12824833'
				)»
				«entry('Easy to Learn','''
					<p>
						Xtend leverages existing Java concepts and adds modern language features on top.
						Unlike other JVM-Languages like Scala, Xtend doesn't add a whole new type system because this
						would cause interoperability issues and make the language harder to learn for Java developers.
						If you know Java you already know most of Xtend. 
					</p>
					''',
					'images/icon_simple.png',
					'http://vimeo.com/12824833'
				)»
				«entry('Still Java','''
					<p>
						Xtend not only resembles the type system to ensure 100% interoperability, it also generates comprehensible Java source code.
						This not only allows to run the code on platforms such as GWT, which doesn't understand bytecode, but also lets you see how certain language
						constructs are translated to idiomatic Java source code.
					</p>
					''',
					'images/icon-java.png',
					'http://vimeo.com/12824833'
				)»
			</div>
		</div>
	</div>
«««	«comparison()»
	'''
	def comparison() '''
		<div id="comparison">
		<div class="container">
			<div class="span12">
				<br/> <br/>
				<h1 align="center">Code Comparison</h1>
				<br/>
			</div>
			<table class="span12 table table-striped">
				<thead>
					<tr>
					  <th style="width:20%;"></th>
						<th style="width:40%;">
							<h2 style="text-align:center;">Xtend</h2>
						</th>
						<th style="width:40%;">
							<h2 style="text-align:center;">Java</h2>
						</th>
					</tr>
				</thead>
				<tbody>
		«compare('Google Guava','''
		myStrings.filter[ length > 5 ]
		''','''
		Iterables.filter(myStrings, new Predicate<String>() {
			public boolean apply(String it) {
				return it.length() > 5;
			}
		});
		''')»
		«compare('Java FX','''
		myStrings.filter[ length > 5 ]
		''','''
		Iterables.filter(myStrings, new Predicate<String>() {
			public boolean apply(String it) {
				return it.length() > 5;
			}
		}
		''')»
		«compare('Android','''
		myStrings.filter[ length > 5 ]
		''','''
		Iterables.filter(myStrings, new Predicate<String>() {
			public boolean apply(String it) {
				return it.length() > 5;
			}
		}
		''')»
		«compare('GWT','''
		myStrings.filter[ length > 5 ]
		''','''
		Iterables.filter(myStrings, new Predicate<String>() {
			public boolean apply(String it) {
				return it.length() > 5;
			}
		}
		''')»
		«compare('Java EE','''
			myStrings.filter[ length > 5 ]
		''','''
			Iterables.filter(myStrings, new Predicate<String>() {
				public boolean apply(String it) {
					return it.length() > 5;
				}
			});
		''')»
			</tbody>
			</table>
		</div>
		</div>
	'''

	
	def compare(String framework, String xtendCode, String javaCode) '''
		
			<tr>
				<td><h2>«framework»</h2></td>
				<td class="code">
					<pre class="prettyprint lang-Xtend" >
		«xtendCode.trim»
					</pre>
				</td>
			 	<td class="code">
					<pre class="prettyprint lang-Java" >
		«javaCode.trim»</pre>
			 	</td>
			</tr>
	'''
	
	def entry(String title, String description, String imgSrc, String imgRef) '''
		<div class="span6 float">
			<div class="thumb">
				<img class="screenshot"
					src="«imgSrc»" alt="Image" />
			</div>
			<h4>«title»</h4>
			«description»
		</div>
	'''

}