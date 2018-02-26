plugins {
    kotlin("jvm") version "1.2.21" 
    idea
    maven
    application
}

repositories {
    jcenter() 
    mavenCentral()
    maven {  setUrl("https://dl.bintray.com/kotlin/exposed")  }
}

dependencies {
    implementation(kotlin("stdlib", "1.2.21")) 
    testImplementation("junit:junit:4.12") 
    compile("com.github.kittinunf.fuel:fuel:1.12.1")
    compile("com.github.kittinunf.fuel:fuel-gson:1.12.1")
    compile("com.github.kittinunf.fuel:fuel-jackson:1.12.1")
    compile("com.github.kittinunf.fuel:fuel-moshi:1.12.1")
    compile("com.google.code.gson:gson:2.8.0")
    compile("org.jetbrains.exposed:exposed:0.9.1")
    compile("org.postgresql:postgresql:42.2.1")
}

application {
    mainClassName = "org.osrsxp.toolkit.ToolKit"
}
