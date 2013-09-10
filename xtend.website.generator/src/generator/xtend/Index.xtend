package generator.xtend

class Index extends AbstractXtendWebsite {
	
	override path() {
		"index.html"
	}
	
	override protected isPrettyPrint() {
		true
	}
	
	override quickLinksAndTweets() '''
		«super.quickLinksAndTweets()»
		<a href="http://dryicons.com/">Icons by http://dryicons.com</a>
	'''
	
	override contents() '''
	<!--Container-->
	
	<div id="header_wrapper">
	<div class="container"> 
		<div class="flexslider image-slider">
			<div class="span6" style="margin-left:7px;">
			<h2 class="front-title">
				Java 10, today!
			</h2>
			<br />
			<p>Xtend is a flexible and expressive dialect of Java, which compiles into readable Java&nbsp;5 compatible source code. 
			   You can use any existing Java library seamlessly. The compiled output is readable 
				and pretty-printed, and tends to run as fast as the equivalent
				handwritten Java code.</p>
			<p>Get productive and write beautiful code with <a href="documentation.html#activeAnnotations">powerful macros</a>, <a href="documentation.html#lambdas">lambdas</a>, <a href="documentation.html#operators">operator overloading</a> and many more modern language features.</p>
				<a href="download.html" class="btn_download"></a>
				<a href="documentation.html" class="btn_documentation"></a>
			</div>
			<div class="span4">
				<iframe class="embedded-video" src="http://player.vimeo.com/video/31248257?title=0&amp;byline=0&amp;portrait=0" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe>
			</div>
		</div>
	</div>
</div>

<div id="intro">
	<div class="container">
		<h1>Get the New Release!</h1>
		<p style="font-family: 'Lato', sans-serif; font-size: 16px; font-weight: 300; color: #fff;word-spacing: 3px;">
		Get the new release and learn how to write efficient Android applications without the tedious boiler-plate code.<br/>
		Leverage the full power of Xtend by enhancing the compiler with <a href="documentation.html#activeAnnotations">Active Annotations</a> a unique macro system for Java.<br/>
		Enjoy the many new IDE and language features and the much improved type inference algorithm.</p>
	</div>
</div>

<div id="features">
	<div class="container">
		<div class="row">
			<br/>
			<br />
			<div class="span6 float">
				<div class="span2">
					<img src="images/android_logo.png" alt="Android" />
				</div>
				<div class="span3">
					<h4>Android Development</h4>
					<p>
						Xtend works great on Android, as it doesn't produce additional runtime overhead.
						The very thin lib and the advanced support for code generation are increasing productivity
						while helping to keep your Android apps small.
					</p>
				</div>
			</div>
			<div class="span6 float">
				<div class="span2">
					<img src="images/gwt-logo.png" alt="Google Web Toolkit" />
				</div>
				<div class="span3">
					<h4>Web Development</h4>
					<p>
						The Google Web Toolkit translates Java source code to fast Javascript code. Xtend makes typical
						GWT programming a joy. There are many nice examples and cool enhancements <a href="https://github.com/DJCordhose/todomvc-xtend-gwt">out there</a>.
					</p>
				</div>
			</div>
			<div class="span6 float">
				<div class="span2">
					<img src="images/Java_Duke_learning.png" alt="Java FX" />
				</div>
				<div class="span3">
					<h4>Fast Learning Curve!</h4>
					<p>
						If you know Java, you will be productive with Xtend in a few hours.
						Xtend is an extension to Java, so you can reuse all your knowledge about tools and libraries.
						Also complicated language features like Generics remain unchanged.
					</p>
				</div>
			</div>
			<div class="span6 float">
				<div class="span2">
					<img src="images/eclipse_logo.png" alt="Eclipse" />
				</div>
				<div class="span3">
					<h4>Advanced IDE Support</h4>
					<p>
						Static typing is not only important for early error detection but even more so for good IDE support.
						To ensure a great and holistic user experience, Xtend's IDE and language have been designed side by side. And of course
						the tools integrate seamlessly with the Eclipse Java IDE. 
					</p>
				</div>
			</div>
			<div class="span6 float">
				<div class="span2">
					<img src="images/java8_logo.png" alt="Java FX" />
				</div>
				<div class="span3">
					<h4>Java 8 Ready</h4>
					<p>
						Xtend works well with Java 8 APIs as it does the same kind of target typing coercion for lambdas.
						With its additional syntactical flexibility of course Xtend code looks much better than the equivalent Java 8 code.
						<a href="http://blog.efftinge.de/2012/12/java-8-vs-xtend.html">Here's are some examples</a>. 
					</p>
				</div>
			</div>
			<div class="span6 float">
				<div class="span2">
					<img src="images/javafx_logo.jpg" alt="Java FX" />
				</div>
				<div class="span3">
					<h4>XtendFX</h4>
					<p>
						UI programming in Java can be very tedious. 
						Checkout the <a href="https://github.com/svenefftinge/xtendfx">XtendFX project</a> to see how you can get rid of
						Java boiler plate easily. It contains some very useful <a href="http://www.eclipse.org/xtend/documentation.html#activeAnnotations">active annotations</a> for 
						automatically generating JavaFX properties. 
					</p>
				</div>
			</div>
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
	
}