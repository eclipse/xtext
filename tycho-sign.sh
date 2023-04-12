# THIS SIGNS, SKIPPING TESTS

mvn \
  -f org.eclipse.xtext.p2.releng \
  package \
  -P useJenkinsSnapshots \
  -P eclipse-sign \
  --batch-mode \
  -Dmaven.repo.local=.m2/repository \
  -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn \
  $@