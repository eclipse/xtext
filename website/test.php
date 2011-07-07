<?php
/*
print "######1\n";
	#$pipesRequest = 'http://pipes.yahoo.com/pipes/pipe.run?_id=c90e6166f0e980bf8df929fce8213a4e&_render=php';
	#$pipesRequest = 'http://www.eclipse.org/projects/project-plan.php?planurl=http://www.eclipse.org/modeling/emf/cdo/project-info/plan.xml&component=CDO';
	$pipesRequest = '/home/data/httpd/writable/xtext/news.php';
print "######2\n";
	$pipesSerialized = file_get_contents($pipesRequest);
print var_export($pipesSerialized);
*/

/*
print "#####A\n";
$docRoot = $_SERVER["DOCUMENT_ROOT"];
require_once "$docRoot/modeling/includes/db.php";
print "#####B\n";

#$result = wmysql_query("SELECT CommitterID, PhotoURL, Name, Company, Location, Role, Website, EMail FROM developers");
$result = wmysql_query("SELECT * FROM commits WHERE PROJECT LIKE 'modeling.tmf.xtext'");
print "#####C\n";

var_dump($result);

print "#####D\n";

if ($result && mysql_num_rows($result) > 0) {
	while ($row = mysql_fetch_row($result)) {
		var_dump($row);
	}
}

print "#####E\n";
*/
print "3\n";

#$commitStatsRequest = '/home/data/httpd/writable/xtext/commitstats.txt';
$commitStatsRequest = 'commitstats.txt';
function getCommitStatsAndImage() {
	global $commitStatsRequest;
	$lines = file_get_contents($commitStatsRequest);
	$commits = array();
	$labels = array();
	foreach(array_slice(explode("\n", $lines), -19) as $index => $line) {
		// 200805	modeling	5833
		preg_match('/20(\d{2})(\d{2})\s+modeling\s+(\d+)/' , $line, $matches);
		#print "$line\n";
		array_push($commits, $matches[3]);
		if($index % 6 == 0)
			array_push($labels, $matches[1] . "/" . $matches[2]);
		else
			array_push($labels, "");
	}

	$chartUrl = "http://chart.apis.google.com/chart?cht=bvs&chco=DBD7EF&chs=300x125&chbh=10,1&chxt=x,y&chds=0,10000&chxr=1,0,10000";
	$chartUrl .= "&chd=t:" . implode(",", $commits);
	$chartUrl .= "&chxl=0:|" . implode("|", $labels);
	$thisMonth = end($commits);
	$lastMonth = prev($commits); 
	
	return array($thisMonth, $lastMonth, $chartUrl);
}
	
	print( var_dump(getCommitStatsAndImage()) );
?>