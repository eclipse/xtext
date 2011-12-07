package bootstrap

class MainSite {
	
	def header() '''
		<!DOCTYPE html>
		<html lang="en">
		<head>
		<meta charset="utf-8">
		<title>Eclipse Xtend</title>
		<meta name="description"
			content="Eclipse Xtend is a statically-typed programming language running on the JVM.">
		<meta name="author" content="Sven Efftinge">
		
		<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
		<!--[if lt IE 9]>
		      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		    <![endif]-->
		
		<!-- Le styles -->
		<!-- <link href="bootstrap.css" rel="stylesheet"> -->
		<link rel="stylesheet" href="http://twitter.github.com/bootstrap/1.4.0/bootstrap.min.css">
		<style type="text/css">
		body {
			padding-top: 40px;
		}
		
		section {
			padding-top: 40px;
		}
		
		div#maincontainer>section {
			padding-top: 90px;
		}
		</style>
		<link href="google-code-prettify/prettify.css" type="text/css"
			rel="stylesheet" />
		<script type="text/javascript" src="google-code-prettify/prettify.js"></script>
		<script type="text/javascript" src="google-code-prettify/lang-xtend.js"></script>
		<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="bootstrap-dropdown.js"></script>
		
		<script type="text/javascript">
			var _gaq = _gaq || [];
			_gaq.push([ '_setAccount', 'UA-2429174-4' ]);
			_gaq.push([ '_trackPageview' ]);
		
			(function() {
				var ga = document.createElement('script');
				ga.type = 'text/javascript';
				ga.async = true;
				ga.src = ('https:' == document.location.protocol ? 'https://ssl'
						: 'http://www')
						+ '.google-analytics.com/ga.js';
				var s = document.getElementsByTagName('script')[0];
				s.parentNode.insertBefore(ga, s);
			})();
		</script>
		
		<!-- Place this render call where appropriate -->
		<script type="text/javascript">
		  (function() {
		    var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
		    po.src = 'https://apis.google.com/js/plusone.js';
		    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
		  })();
		</script>
		
		<script type="text/javascript">
			$('#topbar').dropdown();
		</script>
		
		<!-- Le fav and touch icons -->
		<link rel="shortcut icon" href="images/favicon.ico">
		<link rel="apple-touch-icon" href="images/apple-touch-icon.png">
		<link rel="apple-touch-icon" sizes="72x72"
			href="images/apple-touch-icon-72x72.png">
		<link rel="apple-touch-icon" sizes="114x114"
			href="images/apple-touch-icon-114x114.png">
		</head>
		
		<body onload="prettyPrint()">
	'''
	
	def footer() '''
		</body>
	</html>
	'''
}