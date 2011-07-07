<?php  																														require_once($_SERVER['DOCUMENT_ROOT'] . "/eclipse.org-common/system/app.class.php");	require_once($_SERVER['DOCUMENT_ROOT'] . "/eclipse.org-common/system/nav.class.php"); 	require_once($_SERVER['DOCUMENT_ROOT'] . "/eclipse.org-common/system/menu.class.php"); 	$App 	= new App();	$Nav	= new Nav();	$Menu 	= new Menu();		include($App->getProjectCommon());    # All on the same line to unclutter the user's desktop'
	$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="style4.css"/>' . "\n\t");

	$App->AddExtraHtmlHeader('<script src="js/jquery-1.4.4.min.js" type="text/javascript"></script>' . "\n\t"); 
	$App->AddExtraHtmlHeader('<link rel="stylesheet" href="css/prettyPhoto.css" type="text/css" media="screen" title="prettyPhoto main stylesheet" charset="utf-8" />' . "\n\t"); 
	$App->AddExtraHtmlHeader('<script src="js/jquery.prettyPhoto.js" type="text/javascript" charset="utf-8"></script>' . "\n\t"); 
	$App->AddExtraHtmlHeader('<script src="js/jquery.easing.1.3.js" type="text/javascript" charset="utf-8"></script>' . "\n\t"); 
	$App->AddExtraHtmlHeader('<link rel="stylesheet" href="css/coda-slider-2.0.css" type="text/css" media="screen" charset="utf-8" />' . "\n\t"); 
	$App->AddExtraHtmlHeader('<script src="js/jquery.coda-slider-2.0.js" type="text/javascript" charset="utf-8"></script>' . "\n\t");
	$App->AddExtraHtmlHeader('<script type="text/javascript">
			$().ready(function() {
				$("#slider").codaSlider();
			});
		 </script>
		 ');
	
	// this file will be updated via a cronjob (currently by user hbehrens every 10 mins)
	$pipesNewsRequest = '/home/data/httpd/writable/xtext/news.php';
	$pipesFastNewsRequest = '/home/data/httpd/writable/xtext/fastnews.php';
	$commitStatsRequest = '/home/data/httpd/writable/xtext/commitstats.txt';
    
	if($isLocalVersion) {
		# fast-values (run local-cache/update.sh for recent values)
		
		#$path = "/Users/behrens/xtext-website/workspaces/090515/Xtext/local-cache/";
		$path = "local-cache/";
		$commitStatsRequest = $path . 'commitStatsRequest.txt';
		$pipesNewsRequest = $path . 'pipesNewsRequest.txt';
		$pipesFastNewsRequest = $path . 'pipesFastNewsRequest.txt';
		
		# current values
		#$commitStatsRequest = 'http://dash.eclipse.org/dash/commits/web-api/commit-summary.php?top=y&month=x&project=modeling.tmf.xtext'; //'commitstats.txt';
		#$pipesNewsRequest = 'http://pipes.yahoo.com/pipes/pipe.run?_id=c90e6166f0e980bf8df929fce8213a4e&_render=php';
		#$pipesFastNewsRequest = 'http://pipes.yahoo.com/pipes/pipe.run?_id=28f2285b56f4d72661235fca175d2156&_render=php';
	}
	

	/**
	* word-sensitive substring function with html tags awareness
	* @param text The text to cut
	* @param len The maximum length of the cut string
	* @returns string
	* http://de2.php.net/manual/en/function.substr.php#92063
	**/
	function mb_substrws( $text, $len=180 ) {
	
	    if( (mb_strlen($text) > $len) ) {
	
	        $whitespaceposition = mb_strpos($text," ",$len)-1;
	
	        if( $whitespaceposition > 0 ) {
	            $chars = count_chars(mb_substr($text, 0, ($whitespaceposition+1)), 1);
	            if (array_key_exists(ord('<'), $chars) && array_key_exists(ord('>'), $chars) && $chars[ord('<')] > $chars[ord('>')])
	                $whitespaceposition = mb_strpos($text,">",$whitespaceposition)-1;
	            $text = mb_substr($text, 0, ($whitespaceposition+1));
	        }
	
	        // close unclosed html tags
	        if( preg_match_all("|<([a-zA-Z]+)|",$text,$aBuffer) ) {
	
	            if( !empty($aBuffer[1]) ) {
	
	                preg_match_all("|</([a-zA-Z]+)>|",$text,$aBuffer2);
	
	                if( count($aBuffer[1]) != count($aBuffer2[1]) ) {
	
	                    foreach( $aBuffer[1] as $index => $tag ) {
	
	                        if( empty($aBuffer2[1][$index]) || $aBuffer2[1][$index] != $tag)
	                            $text .= '</'.$tag.'>';
	                    }
	                }
	            }
	        }
	    }
	    return $text;
	}
	
	// http://pkarl.com/articles/contextual-user-friendly-time-and-dates-php/
	function contextualTime($small_ts, $large_ts=false) {
	  if(!$large_ts) $large_ts = time();
	  $n = $large_ts - $small_ts;
	  if($n <= 1) return 'less than 1 second ago';
	  if($n < (60)) return $n . ' seconds ago';
	  if($n < (60*60)) { $minutes = round($n/60); return 'about ' . $minutes . ' minute' . ($minutes > 1 ? 's' : '') . ' ago'; }
	  if($n < (60*60*16)) { $hours = round($n/(60*60)); return 'about ' . $hours . ' hour' . ($hours > 1 ? 's' : '') . ' ago'; }
	  if($n < (time() - strtotime('yesterday'))) return 'yesterday';
	  if($n < (60*60*24)) { $hours = round($n/(60*60)); return 'about ' . $hours . ' hour' . ($hours > 1 ? 's' : '') . ' ago'; }
	  if($n < (60*60*24*6.5)) return 'about ' . round($n/(60*60*24)) . ' days ago';
	  if($n < (time() - strtotime('last week'))) return 'last week';
	  if(round($n/(60*60*24*7))  == 1) return 'about a week ago';
	  if($n < (60*60*24*7*3.5)) return 'about ' . round($n/(60*60*24*7)) . ' weeks ago';
	  if($n < (time() - strtotime('last month'))) return 'last month';
	  if(round($n/(60*60*24*7*4))  == 1) return 'about a month ago';
	  if($n < (60*60*24*7*4*11.5)) return 'about ' . round($n/(60*60*24*7*4)) . ' months ago';
	  if($n < (time() - strtotime('last year'))) return 'last year';
	  if(round($n/(60*60*24*7*52)) == 1) return 'about a year ago';
	  if($n >= (60*60*24*7*4*12)) return 'about ' . round($n/(60*60*24*7*52)) . ' years ago'; 
	  return false;
	}
	
	function getCommitStatsAndImage($request) {
		$lines = trim(file_get_contents($request));
		$commits = array();
		$dates = array();
		$milestones = array();
		foreach(array_slice(explode("\n", $lines), -19) as $index => $line) {
			// 200805	modeling	5833
			if(!preg_match('/20(\d{2})(\d{2})\s+modeling\s+(\d+)/' , $line, $matches))
				break;
			$data = $matches[3];
			// smooth data
			if($data > 5000)
				$data = 5000 + ($data - 5000) / 10;
			array_push($commits, $data);
			
			// dates
			$date = $matches[1] . "/" . $matches[2];
			if($index % 6 == 0)
				array_push($dates, $date);
			else
				array_push($dates, "");
				
			// milestones
			switch($date) {
				case "09/10":
					array_push($milestones, "M2");
					break;
				case "09/12":
					array_push($milestones, "M4");
					break;
				case "10/03":
					array_push($milestones, "M6");
					break;
				case "10/06":
					array_push($milestones, "Helios");
					break;
				case "10/10":
					array_push($milestones, "M2");
					break;
				case "10/12":
					array_push($milestones, "M4");
					break;
				case "11/03":
					array_push($milestones, "M6");
					break;
				case "11/06":
					array_push($milestones, "Indigo");
					break;
				default:
					array_push($milestones, "");		
			}
		}
	
		$legendColor = "DDDDDD";
		$barColor1 = "FFFFFF";
		$barColor2 = "DDDDDDBB";
		$chartUrl = "http://chart.apis.google.com/chart?cht=bvs&chf=bg,s,00000000|b0,lg,90,$barColor1,0,$barColor2,1&chs=260x125&chbh=10,1&chxt=x,x,r&chds=0,6000&chxr=2,0,6000";
		$chartUrl .= "&chd=t:" . implode(",", $commits);
		$chartUrl .= "&chxl=0:|" . implode("|", $milestones);
		$chartUrl .= "|1:|" . implode("|", $dates);
		$chartUrl .= "&chxs=0,$legendColor|1,$legendColor|2,$legendColor";
		
		$thisMonth = round(end($commits));
		$lastMonth = round(prev($commits)); 
		
		return array($thisMonth, $lastMonth, $chartUrl);
	}
	
	$commitStatsAndImage = getCommitStatsAndImage($commitStatsRequest);
	$commitStatsThisMonth = $commitStatsAndImage[0];
	$commitStatsLastMonth = $commitStatsAndImage[1];
	$commitStatsImageURL = $commitStatsAndImage[2];
	
	# Paste your HTML content between the EOHTML markers!
	// derive html file from this script name "full/path/to/<script>.php" -> "_<script>.html" 
	// (comes handy if testing with index2.php)
	$file = explode("/", $_SERVER["SCRIPT_NAME"]);
	$file = $file[count($file) - 1];
	$file = preg_replace('"\.php$"', '.html', $file);
	$html = file_get_contents('_' . $file);

	# build headlines-pipe
	
	// News Pipes Request
	$pipesSerialized = file_get_contents($pipesNewsRequest);
	$pipesContent = unserialize($pipesSerialized);
	$newsHeadlines = "<ul>\n";
	foreach(array_slice($pipesContent["value"]["items"], 0, 3) as $item) {
		#var_export($item);
		$date = $item['pubDate'];
		$span = contextualTime(strtotime($date));
		$title = $item['title'];
		$link = $item['link'];
		$author = $item['author']; 
		$description = mb_substrws(strip_tags($item['description'], '<b><i><strong>'), 300);
		$newsHeadlines .= "<li><div class='item'><div class='title'><a href='$link' target='_blank'>$title</a></div><div class='meta'>($span by $author)</div><div class='description'>$description</div></div></li>\n"; 
	}
	$newsHeadlines .= "</ul>\n";
	
	// fast news pipe
	$pipesSerialized = file_get_contents($pipesFastNewsRequest);
	$pipesContent = unserialize($pipesSerialized);
	$fastHeadlines = "<ul>\n";
	foreach(array_slice($pipesContent["value"]["items"], 0, 5) as $item) {
		$description = $item['content']['content'];
		$date = $item['pubDate'];
		$span = contextualTime(strtotime($date));
		$link = $item['link'];
		$authorName = $item['author']['name'];
		$authorLink = $item['author']['uri'];
		$fastHeadlines .= "<li><div class='item'><div class='description'>$description</div><div class='meta'><a href='$link' target='_blank'>$span</a> by <a href='$authorLink' target='_blank'>$authorName</a></div></div></li>\n";
	}
	$fastHeadlines .= "</ul>\n";
	
	// pick random quote
 	$images = glob("images/quotes/*.png");
 	$quoteUrl = $images[array_rand($images)];
	
	$html = str_replace("%%HEADLINES%%", $newsHeadlines, $html);
	$html = str_replace("%%FASTHEADLINES%%", $fastHeadlines, $html);
	$html = str_replace("%%COMMIT_STATS_IMAGE%%", $commitStatsImageURL, $html);
	$html = str_replace("%%COMMIT_STATS_THIS_MONTH%%", $commitStatsThisMonth, $html);
	$html = str_replace("%%COMMIT_STATS_LAST_MONTH%%", $commitStatsLastMonth, $html);
	$html = str_replace("%%QUOTE_URL%%", $quoteUrl, $html);
	
	# Generate the web page
	$App->generatePage($theme, $Menu, null, $pageAuthor, $pageKeywords, $pageTitle, $html);
	#echo $headlines;
?>
