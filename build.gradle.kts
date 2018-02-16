plugins {
    kotlin("jvm") version "1.2.21" 
}

repositories {
    jcenter() 
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib", "1.2.21")) 
    testImplementation("junit:junit:4.12") 
    compile("khttp:khttp:0.1.0")
}

