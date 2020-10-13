def call(Map config=[:], Closure body) {
    node {
        git url: "https://github.com/werne2j/sample-nodejs"
        stage("Install") {
            bat "npm install"
        }
        stage("Test") {
            bat "npm test"
        }
        stage("Deploy") {
            if (config.deploy) {
                bat "npm publish"
            }
        }
        body()
    }
}
