pipeline {
  agent {
    kubernetes {
      inheritFrom 'centos-8'
    }
  }
  
  parameters {
    // see https://wiki.eclipse.org/Jenkins#JDK
    choice(name: 'JDK_VERSION', description: 'Which JDK should be used?', choices: [
      'temurin-jdk11-latest', 'temurin-jdk17-latest'
    ])
  }

  options {
    buildDiscarder(logRotator(numToKeepStr:'15'))
    disableConcurrentBuilds()
    timeout(time: 90, unit: 'MINUTES')
  }
  
  tools {
     maven "apache-maven-3.8.6"
     jdk "${params.JDK_VERSION}"
  }

  stages {
    stage('Initialize') {
      steps {
        checkout scm
        
        script {
          currentBuild.displayName = String.format("#%s(%s)", BUILD_NUMBER, javaVersion("${params.JDK_VERSION}"))
        }
      }
    }

    stage('Maven Build') {
      steps {
        dir('build') { deleteDir() }
        dir('.m2/repository/org/eclipse/xtext') { deleteDir() }
        dir('.m2/repository/org/eclipse/xtend') { deleteDir() }
        sh '''
          mvn \
            -f org.eclipse.xtext.maven.releng/pom.xml \
            --batch-mode \
            --update-snapshots \
            -fae \
            -PuseJenkinsSnapshots \
            -Dmaven.test.failure.ignore=true \
            -Dmaven.repo.local=${WORKSPACE}/.m2/repository \
            -DaltDeploymentRepository=local::default::file:./build/maven-repository \
            -DJENKINS_URL=$JENKINS_URL \
            -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn \
            clean deploy
        '''
      }
    }
  }

  post {
    always {
      junit testResults: '**/target/surefire-reports/*.xml'
    }
    success {
      archiveArtifacts artifacts: 'build/**'
    }
    cleanup {
      script {
        def curResult = currentBuild.currentResult
        def lastResult = 'NEW'
        if (currentBuild.previousBuild != null) {
          lastResult = currentBuild.previousBuild.result
        }

        if (curResult != 'SUCCESS' || lastResult != 'SUCCESS') {
          def color = ''
          switch (curResult) {
            case 'SUCCESS':
              color = '#00FF00'
              break
            case 'UNSTABLE':
              color = '#FFFF00'
              break
            case 'FAILURE':
              color = '#FF0000'
              break
            default: // e.g. ABORTED
              color = '#666666'
          }

          slackSend (
            message: "${lastResult} => ${curResult}: <${env.BUILD_URL}|${env.JOB_NAME}#${env.BUILD_NUMBER}>",
            botUser: true,
            channel: 'xtext-builds',
            color: "${color}"
          )
        }
      }
    }
  }
}

def javaVersion(String version) {
  return version.replaceAll(".*-(jdk\\d+).*", "\$1").toUpperCase()
}
